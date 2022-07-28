import { Component } from '@angular/core';
import { NotificationService } from 'src/app/shared/notifications.service';
import { DrillDownService } from '../../services/drill-down.service';
import { DashboardLabels } from '../dashboardLabels';
declare var $: any;
declare var require: any;
const appSettings = require('../../../../appsettings');

@Component({
  selector: 'dashborad-favorites-reports',
  templateUrl: './dashboardFavorites.component.html',
  styleUrls: ['./dashboardFavorites.component.css'],
})
export class DashboardFavoritesComponent {
  reportList:any[];
  showLoading = false;
  noData = appSettings.noData;
  paginationOptions: any;
  loading: boolean;

  datasource: any[];
  pageSize: number;
  totalElements: number;

  cols: any[];
  columns: ILabels;

  

  constructor(private drillDownService: DrillDownService, private notificationService: NotificationService) {
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    this.getAllReportsList();

  }
  ngOnInit() {
    let dashboardLabels = new DashboardLabels();

    this.columns = dashboardLabels.fieldLabels;
  }

  getAllReportsList(){
    this.loading = true;
    this.__getData(this.paginationOptions);
  }
  getAllReports(event:any){
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.__getData(this.paginationOptions);
  }

  __getData(paginationOptions:any){
    this.drillDownService.getReports(paginationOptions, true).then((allReports)=>{
      this.loading = false;
      this.datasource = allReports.content;
      this.reportList = allReports.content;
      this.totalElements = allReports.totalElements;
      this.pageSize = allReports.size;
    })
  }
  
  deleteReport(index){
    let id = this.reportList[index].id;
    this.reportList.splice(index,1);
    this.drillDownService.deleteReport(id);
  }

  markUnmarkAsFavorite(report:any){
    if(report){
      report.favoriteFlag == 'N' ? report.favoriteFlag = 'Y' : report.favoriteFlag = 'N';
      this.drillDownService.markAndUnmarkAsFavorite(report);
      if(report.favoriteFlag == 'Y'){
        this.notificationService.showSuccess('Report Marked as Favorite succesfully');
      }else{
        this.notificationService.showSuccess('Report Un-Marked as Favorite succesfully');
      }
      
    }
    this.getAllReportsList();
  }

  goToAllReports(){
    this.drillDownService.allAndFavoritesSwitch = false;
  }
}

interface ILabels {
  [index: string]: string;
}
