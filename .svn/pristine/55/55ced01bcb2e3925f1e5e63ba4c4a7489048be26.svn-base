import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router } from "@angular/router";
import { Table } from 'primeng/table';
import { NotificationService } from '../shared/notifications.service';
import { RmanApprovalHistory } from './rmanApprovalHistory';
import { RmanApprovalHistoryLabels } from './rmanApprovalHistoryLabels';
import { RmanApprovalHistoryService } from './rmanApprovalHistoryservice';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
  templateUrl: './rmanApprovalHistory.component.html',
  selector: 'rmanApprovalHistory-data',
  providers: [RmanApprovalHistoryService]
})

export class RmanApprovalHistoryComponent implements OnInit {
  noData = appSettings.noData;

  arrIdK: any;
  cref: ChangeDetectorRef;
  loading: boolean;

  rmanApprovalHistoryList: any[] = [];
  columns: ILabels;
  paginationOptions: any;

  pages: {};

  datasource: any[];
  pageSize: number;
  totalElements: number;
  parrangementId: any;

  constructor(private ref: ChangeDetectorRef, private rmanApprovalHistoryService: RmanApprovalHistoryService, private router: Router, private route: ActivatedRoute, private notificationService: NotificationService) {

    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    let url = router.url;
    this.parrangementId = url.split('/')[3];
    console.log(this.parrangementId);
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
    let rmanApprovalHistoryLabels = new RmanApprovalHistoryLabels();
    this.columns = rmanApprovalHistoryLabels.fieldLabels;
  }

  reset(dt: Table) {
    dt.reset();
    this.paginationOptions = {};
    this.getAllRmanApprovalHistory();
  }

  getAllRmanApprovalHistory() {
    this.loading = true;
    this.rmanApprovalHistoryService.getAllApprovalHistory(this.paginationOptions, { 'arrangementId': this.parrangementId }).then((rmanApprovalHistoryList: any) => {
     this.integrateHistoryData(rmanApprovalHistoryList);
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }

  integrateHistoryData(rmanApprovalHistoryList: any){
    this.loading = false;
    this.datasource = rmanApprovalHistoryList.content;
    this.rmanApprovalHistoryList = rmanApprovalHistoryList.content;
    this.totalElements = rmanApprovalHistoryList.totalElements;
    this.pageSize = rmanApprovalHistoryList.size;
  }


  getRmanApprovalHistory(event: any) {
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.rmanApprovalHistoryService.getAllApprovalHistory(this.paginationOptions, { 'arrangementId': this.parrangementId }).then((rmanApprovalHistoryList: any) => {
      this.integrateHistoryData(rmanApprovalHistoryList);
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }

}           
              
class RmanApprovalHistoryImpl {
  constructor(public taskStatus?: any, public userId?: any, public commentDate?: any, public userComment?: any, public arrangementId?: any, commentBy?: any) { }
}

interface ILabels {
  [index: string]: string;
}
