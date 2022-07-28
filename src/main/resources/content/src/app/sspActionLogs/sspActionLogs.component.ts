import { Component, OnInit } from '@angular/core';
import { NotificationService } from '../shared/notifications.service';
import { SspActionLogsService } from './sspActionLogs.service';

@Component({
  selector: 'ssp-action-logs',
  templateUrl: './sspActionLogs.component.html',
  providers:[SspActionLogsService]
})
export class SspActionLogsComponent implements OnInit {

  datasource: any[];
  paginationOptions: any;
  pageSize: number;
  totalElements: number;

  loading: boolean;

  sspActionsList:any[] =[];
  sspActionLogs:any[];

  constructor(private sspActionLogsService: SspActionLogsService, private notificationService: NotificationService) {
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
   }

  ngOnInit() {
  }

  getAllSspActionLogs(event:any){
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.sspActionLogsService.getActionLogs(this.paginationOptions).then((actionsList: any) => {
      this.loading = false;
      this.datasource = actionsList.content;
      this.sspActionLogs = actionsList.content;
      this.totalElements = actionsList.totalElements;
      this.pageSize = actionsList.size;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }

}
