import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService } from 'primeng/api';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { NotificationService } from '../shared/notifications.service';
import { SspBooks } from './sspBooks';
import { SspBooksService } from './sspBooks.service';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
  selector: 'ssp-books',
  templateUrl: './sspBooks.component.html',
  providers: [ConfirmationService, SspBooksService]
})
export class SspBooksComponent implements OnInit {

  sspBookForm:FormGroup;
  noData = appSettings.noData;
  datasource: any[];
  paginationOptions: any;
  pageSize: number;
  totalElements: number;
  loading: boolean;
  sspBookStatusValues: any[] =[];
  sspBookStatus: any;
  displaySearchDialog: boolean;
  displayDialog: boolean;
  isCreate: boolean;

  sspBooks:any = new SspBooksImpl();
  sspBooksSearch:any = new SspBooksImpl();
  selectedSspBooks: SspBooks;

  sspBooksList: any[];
  sspBookId:any;
  selectedBookStatus:any;

  sspBookStatusList: any[] = [];

  editFlag:any = true;

  constructor( private confirmationService: ConfirmationService, private notificationService: NotificationService,
    private sspBooksService:SspBooksService, private formBuilder: FormBuilder, private rmanLookupsVService: RmanLookupsVService) {
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    this.prepareSspBookStatusObject();
   }


  ngOnInit() {
    this.buildForm();
  }

  onHide(ev:any){
    
  }
  
  prepareSspBookStatusObject() {
    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'SSP_BOOK_STATUS' }).then((sspBookStatusList: any) => {
      this.sspBookStatusList = sspBookStatusList.content;
      let sspStatusTempObj: any = [{ label: appSettings.dropDownOptions.selectStatus, value: null }];
      this.sspBookStatusList.forEach((sspStatus) => {
        sspStatusTempObj.push({ label: sspStatus.lookupDescription, value: sspStatus.lookupCode });
      });
      this.sspBookStatusValues = sspStatusTempObj;
    });

  }

  onStatusChange(sspBook:any){
    if(sspBook.status !== null){
      this.sspBooksService.updateSspBook(sspBook).then((response: any) => {
        this.notificationService.showSuccess('Updated successfully');
      }).catch((err: any) => {
        this.notificationService.showError(err.error.message);
        this.getSspBooks();
      });
    }
  }

  getSspBooks() {
    this.loading = true;
    this.sspBooksService.getAllSspBooks(this.paginationOptions, this.sspBooks).then((sspBooksList: any) => {
      this.loading = false;
      this.datasource = sspBooksList.content;
      this.sspBooksList = sspBooksList.content;
      this.totalElements = sspBooksList.totalElements;
      this.pageSize = sspBooksList.size;
      this.displaySearchDialog = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }


  getAllSspBooks(event:any){
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.sspBooksService.getAllSspBooks(this.paginationOptions, this.sspBooks).then((sspBooksList: any) => {
    this.loading = false;
    this.datasource = sspBooksList.content;
    this.sspBooksList = sspBooksList.content;
    this.totalElements = sspBooksList.totalElements;
    this.pageSize = sspBooksList.size;
  }).catch((err: any) => {
    this.notificationService.showError('Error occured while getting data');
    this.loading = false;
  });
}

buildForm() {
  this.sspBookForm = this.formBuilder.group({
    'sspBookName': ['', []],
    'sspBookFromDate': ['', [Validators.required]],
    'sspBookToDate': ['', [Validators.required]],
  });
  this.sspBookForm.valueChanges
    .subscribe(data => this.onValueChanged(data));
  this.onValueChanged();
}

onValueChanged(data?: any) {
  if (!this.sspBookForm) { return; }
  const form = this.sspBookForm;

  for (const field in this.formErrors) {
    this.formErrors[field] = '';
    const control = form.get(field);
    if (control && control.dirty && !control.valid) {
      const messages = this.validationMessages[field];
      for (const key in control.errors) {
        this.formErrors[field] += messages[key] + ' ';
      }
    }
  }
}

formErrors = {
  'sspBookName': '','sspBookFromDate':'','sspBookToDate': ''
};

validationMessages = {
  'sspBookName':{ 'required': "SSP Book name is required" },
  'sspBookFromDate': { 'required': "From date is required" },
  'sspBookToDate':{ 'required': "To Date required" },
}

onStartDaeChange(){
  this.sspBooks.bookName = "SSP for FY "+ this.sspBooks.startDate.getFullYear();
}

  reset(dt:any){
    this.loading = true;
    this.paginationOptions = {};
    this.sspBooks = new SspBooksImpl();
    dt.reset();
  }

  showDialogToAdd(){
    this.sspBooks = new SspBooksImpl();
    this.displayDialog = true;
    this.isCreate = true;
  }

  showDialogToSearch(){
    this.sspBooksSearch = new SspBooksImpl();
    this.displaySearchDialog = true;
  }

  cancelSearch(){
    this.displaySearchDialog = false;
  }

  search(){
    this.displaySearchDialog = false;
    this.loading = true;
    this.sspBooks = this.sspBooksSearch;
    this.getSspBooks();
  }

  saveOrUpdate(msg: any){
    this.notificationService.showSuccess(msg);
    this.displayDialog = false;
    this.sspBooks = new SspBooksImpl();
    this.getSspBooks();
  }

  save(){
    this.displayDialog = false;
    if(this.isCreate){
      this.sspBooks.status = 'DRAFT';
      var bookName = 'SSP for FY ';
      bookName = bookName + this.sspBooks.startDate.getFullYear();
      bookName = bookName + '-' + this.sspBooks.endDate.getFullYear().toString().substr(2,3);
      this.sspBooks.bookName = bookName;
      this.loading = true;
      this.sspBooksService.saveSspBook(this.sspBooks).then((response: any) => {
        this.saveOrUpdate('Saved successfully');
      }).catch((err: any) => {
        this.notificationService.showError(err.error.message);
        this.loading = false;
      });
    }else{
      if(this.sspBooks.status === null){
        this.sspBooks.status = 'DRAFT';
      }
      this.loading = true;
      this.sspBooksService.updateSspBook(this.sspBooks).then((response: any) => {
        this.saveOrUpdate('Updated successfully')
      }).catch((err: any) => {
        this.notificationService.showError(err.error.message);
        this.loading = false;
      });
    }
  }

  onRowSelect(event:any){
    this.selectedSspBooks = event.data;
    this.sspBookId = this.selectedSspBooks.bookId;
    this.selectedBookStatus = this.selectedSspBooks.status;
  }

  onRowUnSelect(){
    this.sspBookId = null;
  }

  cancel(){
    this.displayDialog = false;
  }

  editRow(sspBook: any) {
    this.isCreate = false;
    this.sspBooks = this.cloneRmanUsers(sspBook);
    if (this.sspBooks.startDate) {
      this.sspBooks.startDate = new Date(this.sspBooks.startDate);
    }
    if (this.sspBooks.endDate) {
      this.sspBooks.endDate = new Date(this.sspBooks.endDate);
    }
    this.displayDialog = true;
  }

  cloneRmanUsers(c: SspBooks): SspBooks {
    let sspBook: any
      = new SspBooksImpl();
    for (let prop in c) {
      sspBook[prop] = c[prop];
    }
    return sspBook;
  }

  delete(sspBook: any) {
    this.displayDialog = false;
    this.confirmationService.confirm({
      message: 'Are you sure you want to delete this record?',
      header: 'Confirmation',
      icon: '',
      accept: () => {
        this.loading = true;
        this.sspBooksService.deleteSspBook(sspBook).then((response: any) => {
          this.sspBooks = new SspBooksImpl();
          this.getSspBooks();
        });
        this.notificationService.showSuccess('Deleted successfully');
      },
      reject: () => {
        this.notificationService.showWarning('You have rejected');
      }
    });

  }

}

export class SspBooksImpl{
  constructor(public bookId?:any,
    public bookName?:any,
    public startDate?:any,
    public endDate?:any,
    public status?:any,
    public attribute1?:any,
    public attribute2?:any,
    public attribute3?:any,
    public attribute4?:any,
    public attribute5?:any,
    public attribute6?:any,
    public attribute7?:any,
    public attribute8?:any,
    public attribute9?:any,
    public attribute10?:any){

  }
}
