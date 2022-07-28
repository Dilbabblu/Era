import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from './app.service';
declare var require:any;
const appSettings = require('../../../appsettings');

@Injectable()
export class DrillDownService {
  arrangementsData = [];
  reportsArrangementData:any = []; 
  allAndFavoritesSwitch:boolean;
  columnDataBackup:any;
  showChart:boolean;
  verticalBarChart:boolean;
  constructor(
    private appService: AppService,
    private router: Router,
    private httpClient: HttpClient
  ) {}
  getArrangementData(dateRange, reportId) {

    let startDateFormat = dateRange.startDate.getDate() +"/"+ (dateRange.startDate.getMonth() + 1) +"/"+ dateRange.startDate.getFullYear();
    let endDateFormat = dateRange.endDate.getDate() +"/"+ (dateRange.endDate.getMonth() + 1) +"/"+ dateRange.endDate.getFullYear();
    
    return this.httpClient
      .get(
        appSettings.apiUrl+"/revmantra/apivot?startDate="+ startDateFormat +"&endDate="+ endDateFormat
      )
      .toPromise()
      .then((response: any) => {
        this.arrangementsData = response;
        if(reportId !== undefined || reportId !== null){
          this.reportsArrangementData.push({id: reportId, data: response});
        }
        return response;
      });
  }
  getReports(paginationOptions:any, isFavorite:any) {

    let serviceUrl=appSettings.apiUrl+'/xTestClobSearch?';
    
    let searchString='';

    if(isFavorite === true) searchString = 'favoriteFlag:Y';

    if (searchString == '') {
      serviceUrl=serviceUrl+'search=%25';
    }
    else {
        serviceUrl=serviceUrl+'search='+searchString;
    }

    if (paginationOptions.pageNumber!=undefined && paginationOptions.pageNumber!="" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber!=0) {
      serviceUrl=serviceUrl+'&page='+paginationOptions.pageNumber+'&size='+paginationOptions.pageSize;
    }

    return this.appService.getAll(serviceUrl).then((response: any) => {
      return response;
    });
  }

  getReport(id) {
    return this.appService.get('reports', id);
  }
  deleteReport(id) {
    return this.appService.delete('reports', id).then((response: any) => {
      return response;
    });
  }
  saveReport(data, id) {
    if (id) {
      return this.appService.update('reports', id, data).then((data) => {
        return data;
      });
    } else {
      return this.appService.create('reports', data).then((data) => {
        this.router.navigate(['/report', data.id]);
        return data;
      });
    }
  }

  markAndUnmarkAsFavorite(report){
    return this.appService.markAndUnmarkAsFavorite(report);
  }
}
