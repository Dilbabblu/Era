import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router } from "@angular/router";
import { Table } from 'primeng/table';
import { NotificationService } from '../shared/notifications.service';
import { RmanDealGmAsv } from './rmanDealGmAsv';
import { RmanDealGmAsvLabels } from './rmanDealGmAsvLabels';
import { RmanDealGmAsvService } from './rmanDealGmAsvservice';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
  templateUrl: './rmanDealGmAsv.component.html',
  selector: 'rmanDealGmAsv-data',
  providers: [RmanDealGmAsvService]
})

export class RmanDealGmAsvComponent implements OnInit {
  noData = appSettings.noData;
  displayDialog: boolean;

  displaySearchDialog: boolean;
  arrIdK: any;

  rmanDealGmAsv: any = new RmanDealGmAsvImpl();

  rmanDealGmAsvSearch: any = new RmanDealGmAsvImpl();

  isSerached: number = 0;

  cref: ChangeDetectorRef;
  loading: boolean;

  selectedRmanDealGmAsv: RmanDealGmAsv;

  newRmanDealGmAsv: boolean;

  rmanDealGmAsvList: any[] = [];

  cols: any[];
  columns: ILabels;

  columnOptions: any[];

  paginationOptions: any;

  pages: {};

  datasource: any[];
  pageSize: number;
  totalElements: number;

  collapsed: boolean = true;

  


  constructor(private ref: ChangeDetectorRef, private rmanDealGmAsvService: RmanDealGmAsvService, private router: Router, private route: ActivatedRoute, private notificationService: NotificationService) {

    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.arrIdK = event.url.split('/')[3];
      }
    });
    this.cref = ref;
  }

  ngAfterViewChecked() {
    this.cref.detectChanges();
  }

  ngOnInit() {
    let rmanDealGmAsvLabels = new RmanDealGmAsvLabels();
    this.columns = rmanDealGmAsvLabels.fieldLabels;
  }

  exportExcel() {
    let serviceUrl = this.rmanDealGmAsvService.getServiceUrl(this.paginationOptions, { 'arrangementId': this.arrIdK }, 1);
    window.location.href = serviceUrl;

  }

  reset(dt: Table) {
    dt.reset();
    this.paginationOptions = {};
    this.rmanDealGmAsv = new RmanDealGmAsvImpl();
    this.getAllRmanDealGmAsv();
  }


  getAllRmanDealGmAsv() {
    this.loading = true;
    this.rmanDealGmAsvService.getAllRmanDealGmAsv(this.paginationOptions, { 'arrangementId': this.arrIdK }).then((rmanDealGmAsvList: any) => {
      this.loading = false;
      this.datasource = rmanDealGmAsvList.content;
      this.rmanDealGmAsvList = rmanDealGmAsvList.content;
      this.totalElements = rmanDealGmAsvList.totalElements;
      this.pageSize = rmanDealGmAsvList.size;
      this.displaySearchDialog = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }


  getRmanDealGmAsv(event: any) {
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.rmanDealGmAsvService.getAllRmanDealGmAsv(this.paginationOptions, { 'arrangementId': this.arrIdK }).then((rmanDealGmAsvList: any) => {
      this.loading = false;
      this.datasource = rmanDealGmAsvList.content;
      this.rmanDealGmAsvList = rmanDealGmAsvList.content;
      this.totalElements = rmanDealGmAsvList.totalElements;
      this.pageSize = rmanDealGmAsvList.size;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }


  showDialogToAdd() {
    this.newRmanDealGmAsv = true;
    this.rmanDealGmAsv = new RmanDealGmAsvImpl();
    this.displayDialog = true;
  }


  save() {
    if (this.newRmanDealGmAsv) {
      this.loading = true;
      this.rmanDealGmAsvService.saveRmanDealGmAsv(this.rmanDealGmAsv).then((response: any) => {
        this.getAllRmanDealGmAsv();
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while saving the data');
        this.loading = false;
      });
    }
    else {
      this.loading = true;
      this.rmanDealGmAsvService.updateRmanDealGmAsv(this.rmanDealGmAsv).then((response: any) => {
        this.getAllRmanDealGmAsv();
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while updating the data');
        this.loading = false;
      });
    }

    this.rmanDealGmAsv = new RmanDealGmAsvImpl();
    this.displayDialog = false;
  }


  delete(rmanDealGmAsv: any) {
    this.rmanDealGmAsv = rmanDealGmAsv;
    this.displayDialog = false;

    if (window.confirm('Are you sure you want to delete this record?')) {
      this.rmanDealGmAsvList.splice(this.findSelectedRmanDealGmAsvIndex(), 1);
      this.loading = true;
      this.rmanDealGmAsvService.deleteRmanDealGmAsv(this.rmanDealGmAsv).then((response: any) => {
        this.loading = false;
        this.rmanDealGmAsv = new RmanDealGmAsvImpl();
        this.getAllRmanDealGmAsv();
      });
    }

  }

  editRow(rmanDealGmAsv: any) {
    this.newRmanDealGmAsv = false;
    this.rmanDealGmAsv = this.cloneRmanDealGmAsv(rmanDealGmAsv);
    this.displayDialog = true;

  }


  findSelectedRmanDealGmAsvIndex(): number {
    return this.rmanDealGmAsvList.indexOf(this.selectedRmanDealGmAsv);
  }

  onRowSelect(event: any) {

  }

  cloneRmanDealGmAsv(c: RmanDealGmAsv): RmanDealGmAsv {
    let rmanDealGmAsv: any
      = new RmanDealGmAsvImpl();
    for (let prop in c) {
      rmanDealGmAsv[prop] = c[prop];
    }
    return rmanDealGmAsv;
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

    this.rmanDealGmAsvSearch = new RmanDealGmAsvImpl();

    if (this.isSerached == 0) {
      this.rmanDealGmAsvSearch = new RmanDealGmAsvImpl();
    }
    this.displaySearchDialog = true;

  }

  search() {

    this.isSerached = 1;
    this.rmanDealGmAsv = this.rmanDealGmAsvSearch;
    this.getAllRmanDealGmAsv();
  }

  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }
}


class RmanDealGmAsvImpl {
  constructor(public sno?: any, public qty?: any, public netPrice?: any, public grossMargin?: any, public elementType?: any, public totalExpectedBookings?: any, public arrangementName?: any, public sku?: any, public arrangementId?: any, public lineCost?: any) { }
}

interface ILabels {
  [index: string]: string;
}
