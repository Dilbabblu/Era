import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService, Message } from 'primeng/api';
import { Table } from 'primeng/table';
import { NotificationService } from '../shared/notifications.service';
import { RmanFcBuckets } from './rmanFcBuckets';
import { RmanFcBucketsLabels } from './rmanFcBucketsLabels';
import { RmanFcBucketsService } from './rmanFcBucketsservice';


declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

export function DecimalValidator(control: FormControl): { [key: string]: boolean } {

    if (true) {
        return {
            'percentage': true
        };
    }


}
@Component({
    templateUrl: './rmanFcBuckets.component.html',
    selector: 'rmanFcBuckets-data',
    providers: [RmanFcBucketsService, ConfirmationService]
})

export class RmanFcBucketsComponent implements OnInit {

    displayDialog: boolean;


    displaySearchDialog: boolean;

    rmanFcBuckets: any = new RmanFcBucketsImpl();

    rmanFcBucketsSearch: any = new RmanFcBucketsImpl();

    isSerached: number = 0;

    cref: ChangeDetectorRef;

    showMsg: any;

    msgs: Message[] = [];

    

    selectedRmanFcBuckets: RmanFcBuckets;

    newRmanFcBuckets: boolean;

    rmanFcBucketsList: any[];

    cols: any[];
    columns: ILabels;

    columnOptions: any[];

    paginationOptions: any;

    pages: {};

    datasource: any[];
    pageSize: number;
    totalElements: number;

    collapsed: boolean = true;
    noData = appSettings.noData;
    loading: boolean;
    forecastingBucketsForm: FormGroup;


    constructor(private ref: ChangeDetectorRef, private rmanFcBucketsService: RmanFcBucketsService, private formBuilder: FormBuilder, private confirmationService: ConfirmationService,
        private notificationService: NotificationService) {

        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };

        this.cref = ref;

    }

    ngAfterViewChecked() {
        this.cref.detectChanges();
    }

    ngOnInit() {

        this.getAllRmanFcBuckets();
        let rmanFcBucketsLabels = new RmanFcBucketsLabels();
        this.columns = rmanFcBucketsLabels.fieldLabels;
        this.buildForm();
    }

    reset(dt: Table) {
        this.paginationOptions = {};
        this.rmanFcBuckets = new RmanFcBucketsImpl();
        dt.reset();
    }

    buildForm() {
        this.forecastingBucketsForm = this.formBuilder.group({
            'name': ['', [Validators.required]
            ],
            'fcStartDate': ['', [Validators.required]],
            'numberOfBuckets': [''],
            'numberOfPeriods': [''],
            'numberOfQtrs': [''],
            'numberOfYears': ['']
        });

        this.forecastingBucketsForm.valueChanges
            .subscribe(data => this.onValueChanged(data));

        this.onValueChanged();
    }

    onValueChanged(data?: any) {
        if (!this.forecastingBucketsForm) { return; }
        const form = this.forecastingBucketsForm;

        for (const field in this.formErrors) {
            // clear previous error message (if any)
            this.formErrors[field] = '';
            const control = form.get(field);
            if (control && control.dirty && !control.valid) {
                const messages = this.validationMessages[field];
                for (const key in control.errors) {
                    this.formErrors[field] += '<div>' + messages[key] + ' ' + '</div>';
                }
            }
        }
    }

    formErrors = {
        'name': '', 'fcStartDate': '', 'numberOfBuckets': '', 'numberOfPeriods': '', 'numberOfQtrs': '', 'numberOfYears': ''
    };

    validationMessages = {
        'name': {
            'required': "Name is required"
        },
        'fcStartDate': {
            'required': "Start Date is Required"
        },
        'numberOfBuckets': {
            "pattern": "invlid pattern(Only numbers allowed)",
            "min": "minimun number 0",
        },
        'numberOfPeriods': {
            "pattern": "invlid pattern(Only numbers allowed)",
            "min": "minimun number 0",
            "max": "maximum number 12"
        },
        'numberOfQtrs': {
            "pattern": "invlid pattern(Only numbers allowed)",
            "min": "minimun number 0",
            "max": "maximum number 3"
        },
        'numberOfYears': {
            "pattern": "invlid pattern(Only numbers allowed)",
            "min": "minimun number 0",
        }

    }




    getAllRmanFcBuckets() {
        this.loading = true;
        this.rmanFcBucketsService.getAllRmanFcBuckets(this.paginationOptions, this.rmanFcBuckets).then((rmanFcBucketsList: any) => {
            this.loading = false;
            this.datasource = rmanFcBucketsList.content;
            this.rmanFcBucketsList = rmanFcBucketsList.content;
            this.totalElements = rmanFcBucketsList.totalElements;
            this.pageSize = rmanFcBucketsList.size;
            this.displaySearchDialog = false;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });
    }


    getRmanFcBuckets(event: any) {

        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.loading = true;
        this.rmanFcBucketsService.getAllRmanFcBuckets(this.paginationOptions, this.rmanFcBuckets).then((rmanFcBucketsList: any) => {
            this.loading = false;
            this.datasource = rmanFcBucketsList.content;
            this.rmanFcBucketsList = rmanFcBucketsList.content;
            this.totalElements = rmanFcBucketsList.totalElements;
            this.pageSize = rmanFcBucketsList.size;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });

    }


    showDialogToAdd() {

        this.newRmanFcBuckets = true;
        this.rmanFcBuckets = new RmanFcBucketsImpl();
        this.displayDialog = true;
        this.buildForm();
    }

    cancelEdit() {
        this.rmanFcBuckets = new RmanFcBucketsImpl();
        this.displayDialog = false;
    }

    saveOrUpdate(msg: any){
        this.notificationService.showSuccess(msg);
        this.loading = false;
        this.getAllRmanFcBuckets();
    }

    save() {

        if (!this.rmanFcBuckets.numberOfBuckets) this.rmanFcBuckets.numberOfBuckets = 0;
        if (!this.rmanFcBuckets.numberOfPeriods) this.rmanFcBuckets.numberOfPeriods = 0;
        if (!this.rmanFcBuckets.numberOfQtrs) this.rmanFcBuckets.numberOfQtrs = 0;
        if (!this.rmanFcBuckets.numberOfYears) this.rmanFcBuckets.numberOfYears = 0;

        if (this.newRmanFcBuckets) {
            this.loading = true;
            this.rmanFcBucketsService.saveRmanFcBuckets(this.rmanFcBuckets).then((response: any) => {
                this.saveOrUpdate('Saved Successfully');
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while saving the data');
                this.loading = false;
            });
        }
        else {
            this.loading = true;
            this.rmanFcBucketsService.updateRmanFcBuckets(this.rmanFcBuckets).then((response: any) => {
                this.saveOrUpdate('Updated Successfully');
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while updating the data');
                this.loading = false;
            });
        }

        this.rmanFcBuckets = new RmanFcBucketsImpl();

        this.displayDialog = false;

    }



    delete(rmanFcBuckets: any) {
        this.rmanFcBuckets = rmanFcBuckets;
        if (this.rmanFcBuckets.startDate) {
            this.rmanFcBuckets.startDate = new Date(this.rmanFcBuckets.startDate);
        }
        if (this.rmanFcBuckets.endDate) {
            this.rmanFcBuckets.endDate = new Date(this.rmanFcBuckets.endDate);
        }
        this.displayDialog = false;
        this.confirmationService.confirm({
            message: 'Are you sure you want to delete this record?',
            header: 'Confirmation',
            icon: '',
            accept: () => {
                this.rmanFcBucketsList.splice(this.findSelectedRmanFcBucketsIndex(), 1);
                this.loading = true;
                this.rmanFcBucketsService.deleteRmanFcBuckets(this.rmanFcBuckets).then((response: any) => {
                    this.loading = false;
                    this.rmanFcBuckets = new RmanFcBucketsImpl();
                    this.getAllRmanFcBuckets();
                });
                this.notificationService.showSuccess('Deleted succesfully');
            },
            reject: () => {
                this.notificationService.showWarning('You have rejected');
            }
        });
    }

    editRow(rmanFcBuckets: any) {
        this.newRmanFcBuckets = false;
        this.rmanFcBuckets = this.cloneRmanFcBuckets(rmanFcBuckets);
        if (this.rmanFcBuckets.startDate) {
            this.rmanFcBuckets.startDate = new Date(this.rmanFcBuckets.startDate);
        }
        if (this.rmanFcBuckets.endDate) {
            this.rmanFcBuckets.endDate = new Date(this.rmanFcBuckets.endDate);
        }
        this.displayDialog = true;
    }


    findSelectedRmanFcBucketsIndex(): number {
        return this.rmanFcBucketsList.indexOf(this.selectedRmanFcBuckets);
    }

    onRowSelect(event: any) {

    }

    cloneRmanFcBuckets(c: RmanFcBuckets): RmanFcBuckets {
        let rmanFcBuckets: any
            = new RmanFcBucketsImpl();
        for (let prop in c) {
            rmanFcBuckets[prop] = c[prop];
        }
        return rmanFcBuckets;
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

        this.rmanFcBucketsSearch = new RmanFcBucketsImpl();

        if (this.isSerached == 0) {
            this.rmanFcBucketsSearch = new RmanFcBucketsImpl();
        }
        this.displaySearchDialog = true;

    }

    cancelSearch() {
        this.displaySearchDialog = false;
        this.rmanFcBucketsSearch = new RmanFcBucketsImpl();
    }

    search() {

        this.isSerached = 1;
        this.rmanFcBuckets = this.rmanFcBucketsSearch;
        this.paginationOptions = {};
        this.getAllRmanFcBuckets();
    }

    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }

}


class RmanFcBucketsImpl {
    constructor(public attribute10?: any, public attribute14?: any, public attribute13?: any, public createdDate?: any, public attribute12?: any, public attribute11?: any, public bucketId?: any, public endDate?: any, public numberOfYears?: any, public attribute3?: any, public createdBy?: any, public attribute2?: any, public lastUpdatedBy?: any, public attribute1?: any, public numberOfBuckets?: any, public startDate?: any, public attribute9?: any, public attribute8?: any, public attribute7?: any, public latestFlag?: any, public attribute6?: any, public attribute5?: any, public name?: any, public attribute4?: any, public lastUpdatedDate?: any, public numberOfQtrs?: any, public version?: any, public numberOfPeriods?: any, public attribute15?: any) { }
}

interface ILabels {
    [index: string]: string;
}
