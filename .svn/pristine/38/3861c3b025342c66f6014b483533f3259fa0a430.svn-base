import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService } from 'primeng/api';
import { Table } from 'primeng/table';
import { NotificationService } from '../shared/notifications.service';
import { RmanCurrency } from './rmanCurrency';
import { RmanCurrencyLabels } from './rmanCurrencyLabels';
import { RmanCurrencyService } from './rmanCurrencyservice';
import { CommonSharedService } from '../shared/common.service';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
    templateUrl: './rmanCurrency.component.html',
    selector: 'rmanCurrency-data',
    providers: [RmanCurrencyService, ConfirmationService]
})

export class RmanCurrencyComponent implements OnInit {

    displayDialog: boolean;

    displaySearchDialog: boolean;

    rmanCurrency: any = new RmanCurrencyImpl();

    rmanCurrencySearch: any = new RmanCurrencyImpl();

    isSerached: number = 0;

    selectedRmanCurrency: RmanCurrency;

    newRmanCurrency: boolean;

    rmanCurrencyList: any[];

    cols: any[];
    //columns: ILabels;

    columnOptions: any[];

    paginationOptions: any;

    pages: {};

    datasource: any[];
    pageSize: number;
    totalElements: number;
    collapsed: boolean = true;
    
    noData = appSettings.noData;
    loading: boolean;
    currencyForm: FormGroup;
    isSelectAllChecked = true;
    globalCols: any[];
    clonedCols: any[];
    userId: number;
    showPaginator: boolean = true;
    startIndex: number;
    showAddColumns = true;
    columns: any[];

    constructor(private formBuilder: FormBuilder, private rmanCurrencyService: RmanCurrencyService, private confirmationService: ConfirmationService, private notificationService: NotificationService,  private commonSharedService: CommonSharedService) {
        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
        this.buildForm();
    }

    ngOnInit() {
        this.globalCols = [
            { field: 'currencyCode', header: 'Currency Code', showField: true, drag: true, display: "table-cell",type:'text'},
            { field: 'name', header: 'Name', showField: true, drag: true, display: "table-cell",type:'text' }
        ];

        this.columns = [];
        this.getTableColumns("rmanCurrency", "Currencies");
    }

    getTableColumns(pageName: string, tableName: string) {
        this.isSelectAllChecked = true;
        this.commonSharedService.getConfiguredColDetails(pageName, tableName).then((response) => {
          if (response && response != null && response.userId) {
            this.columns = [];
            let colsList = response.tableColumns.split(",");
            if (colsList.length > 0) {
              colsList.forEach((item, index) => {
                if (item) {
                  this.startIndex = this.globalCols.findIndex(col => col.field == item);
                  this.onDrop(index);
                }
              });
            }
            this.globalCols.forEach(col => {
              if (response.tableColumns.indexOf(col.field) !== -1) {
                this.columns.push(col);
              } else {
                col.showField = false;
              }
            });
            if (this.columns.length != this.globalCols.length) this.isSelectAllChecked = false;
            this.showPaginator = this.columns.length !== 0;
            this.userId = response.userId;
          } else {
            this.columns = this.globalCols;
          }
        }).catch(() => {
          this.notificationService.showError('Error occured while getting table columns data');
          this.loading = false;
        });
      }
    
      saveColumns() {
        let selectedCols = "";
        this.showAddColumns = !this.showAddColumns;
        const colLength = this.globalCols.length - 1;
        this.globalCols.forEach((col, index) => {
          if (col.showField) {
            selectedCols += col.field;
            if (index < colLength) {
              selectedCols += ",";
            }
          }
        });
        this.loading = true;
        this.commonSharedService.saveOrUpdateTableColumns("rmanCurrency", "Currencies", selectedCols, this.userId).then((response) => {
          this.columns = this.globalCols.filter(item => item.showField);
          this.userId = response["userId"];
          this.showPaginator = this.columns.length !== 0;
          this.loading = false;
        }).catch(() => {
          this.notificationService.showError('Error occured while getting data');
          this.loading = false;
        });
      }
    
      onDragStart(index: number) {
        this.startIndex = index;
      }
    
      onDrop(dropIndex: number) {
        const general = this.globalCols[this.startIndex]; // get element
        this.globalCols.splice(this.startIndex, 1);       // delete from old position
        this.globalCols.splice(dropIndex, 0, general);    // add to new position
        //console.log(this.globalCols);
      }
    
      selectColumns(col: any) {
        let cols = this.globalCols.filter(item => !item.showField);
        if (cols.length > 0) {
          this.isSelectAllChecked = false;
        } else {
          this.isSelectAllChecked = true;
        }
      }
    
      onSelectAll() {
        this.isSelectAllChecked = !this.isSelectAllChecked;
        this.globalCols.forEach(col => {
          if (this.isSelectAllChecked) {
            col.showField = true;
          } else {
            if (col.drag) {
              col.showField = false;
            }
          }
        });
      }
    
      onConfiguringColumns(event: any) {
        this.clonedCols = JSON.parse(JSON.stringify(this.globalCols));
        this.showAddColumns = false;
      }
    
      closeConfigureColumns(event: any) {
      this.showAddColumns = true;
      this.globalCols = this.clonedCols;
      let configCol = this.globalCols.filter(item => !item.showField);
      this.isSelectAllChecked = !(configCol.length > 0);
      }

    getAllRmanCurrency() {
        this.loading = true;
        this.rmanCurrencyService.getAllRmanCurrency(this.paginationOptions, this.rmanCurrency, true).then((rmanCurrencyList: any) => {
            this.datasource = rmanCurrencyList.content;
            this.rmanCurrencyList = rmanCurrencyList.content;
            this.totalElements = rmanCurrencyList.totalElements;
            this.pageSize = rmanCurrencyList.size;
            this.displaySearchDialog = false;
            this.loading = false;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });
    }

    getRmanCurrency(event: any) {
        this.loading = true;
        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.rmanCurrencyService.getAllRmanCurrency(this.paginationOptions, this.rmanCurrency, true).then((rmanCurrencyList: any) => {
            this.datasource = rmanCurrencyList.content;
            this.rmanCurrencyList = rmanCurrencyList.content;
            this.totalElements = rmanCurrencyList.totalElements;
            this.pageSize = rmanCurrencyList.size;
            this.loading = false;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });

    }

    buildForm() {
        this.currencyForm = this.formBuilder.group({
            'currencyCode': ['', [Validators.required, Validators.minLength(2),Validators.maxLength(7)]],
            'format': ['', [Validators.required]],
            'name': ['', [Validators.required, Validators.minLength(4),Validators.maxLength(30)]]
        });

        this.currencyForm.valueChanges
            .subscribe(data => this.onValueChanged(data));

        this.onValueChanged();
    }

    onValueChanged(data?: any) {
        if (!this.currencyForm) { return; }
        const form = this.currencyForm;

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
        'currencyCode': '', 'format': '', 'name': ''
    };

    validationMessages = {
        'currencyCode': {
            'required': "Currency Code is required (minimum length is 2 and maximum length is 7 characters)",
            'minlength': 'Currency Code must be at least 2 characters long.',
            'maxlength': 'Currency Code cannot be more than 7 characters long.',
        },
        'format': {
            'required': "Format is Required"
        },
        'name': {
            'required': "Name is Required (minimum length is 4 and maximum length is 30 characters)",
            'minlength': 'Currency Code must be at least 4 characters long.',
            'maxlength': 'Currency Code cannot be more than 30 characters long.',
        }
    }



    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }

    showDialogToAdd() {

        this.newRmanCurrency = true;
        this.rmanCurrency = new RmanCurrencyImpl();
        this.displayDialog = true;
        this.buildForm();
    }

    save() {
        if (this.newRmanCurrency) {
            this.loading = true;
            this.rmanCurrencyService.saveRmanCurrency(this.rmanCurrency).then((response: any) => {
                this.notificationService.showSuccess('Saved successfully');
                this.getAllRmanCurrency();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while saving data');
                this.loading = false;
            });
        }
        else {
            this.loading = true;
            this.rmanCurrencyService.updateRmanCurrency(this.rmanCurrency).then((response: any) => {
                this.notificationService.showSuccess('Updated successfully');
                this.getAllRmanCurrency();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while updating data');
                this.loading = false;
            });
        }
        this.rmanCurrency = new RmanCurrencyImpl();
        this.displayDialog = false;
    }

    delete(rmanCurrency: any) {
        this.rmanCurrency = rmanCurrency;
        this.displayDialog = false;
        this.confirmationService.confirm({
            message: 'Are you sure you want to delete this record?',
            header: 'Confirmation',
            icon: '',
            accept: () => {
                this.rmanCurrencyList.splice(this.findSelectedRmanCurrencyIndex(), 1);
                this.rmanCurrencyService.deleteRmanCurrency(this.rmanCurrency).then((response: any) => {
                    this.rmanCurrency = new RmanCurrencyImpl();
                    this.getAllRmanCurrency();
                    this.notificationService.showSuccess('Deleted successfully');
                });
            },
            reject: () => {
                this.notificationService.showWarning('You have rejected');
            }
        })

    }

    editRow(rmanCurrency: any) {
        this.newRmanCurrency = false;
        this.rmanCurrency = this.cloneRmanCurrency(rmanCurrency);
        this.displayDialog = true;

    }


    findSelectedRmanCurrencyIndex(): number {
        return this.rmanCurrencyList.indexOf(this.selectedRmanCurrency);
    }

    onRowSelect(event: any) {

    }

    cloneRmanCurrency(c: RmanCurrency): RmanCurrency {
        let rmanCurrency: any
            = new RmanCurrencyImpl();
        for (let prop in c) {
            rmanCurrency[prop] = c[prop];
        }
        return rmanCurrency;
    }

    hideColumnMenu: boolean = true;

    toggleColumnMenu() {
        if (this.hideColumnMenu) {
            this.hideColumnMenu = false;
        } else {
            this.hideColumnMenu = true;
        }
    }

    showFilter: boolean = false;

    toggleFilterBox() {
        if (this.showFilter) {
            this.showFilter = false;
        } else {
            this.showFilter = true;
        }
    }

    showDialogToSearch() {
        if (this.isSerached == 0) {
            this.rmanCurrencySearch = new RmanCurrencyImpl();
        }
        this.rmanCurrencySearch = new RmanCurrencyImpl();
        this.displaySearchDialog = true;

    }
    cancelAddEdit() {
        this.displayDialog = false;
        this.rmanCurrency = new RmanCurrencyImpl();
    }
    search() {

        this.isSerached = 1;
        this.rmanCurrency = this.rmanCurrencySearch;
        this.paginationOptions = {};
        this.getAllRmanCurrency();
    }

    reset(dt: Table) {
        this.paginationOptions = {};
        this.rmanCurrency = new RmanCurrencyImpl();
        dt.reset();

    }
}


class RmanCurrencyImpl {
    constructor(public format?: any, public currencyCode?: any, public name?: any) { }
}

interface ILabels {
    [index: string]: string;
}
