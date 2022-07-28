import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ReportsService } from '../reportsservice';
declare var $: any;
declare var require: any;
const appSettings = require('../../appsettings');


@Component({
  selector : 'operational-reports-data',
  templateUrl : './operationalReports.component.html'
})

export class OperationalReportsComponent implements OnInit{

  reportsList:any[]=[];
  reports:any;
  noData = appSettings.noData;
  loading:boolean;

  constructor(private router: Router,private reportsService:ReportsService){}

  ngOnInit(){
    this.getAllReports();
  }

  private getAllReports(){
    this.loading = true;
    this.reportsService.getAllReports('enabledFlag:Y,reportType:OPERATIONAL').then((reportsList:any) => {
      this.loading = false;
      this.reportsList= reportsList.content;
   });
  }

  path1(reports:any){
    this.router.navigate([reports.reportPath]);
  }

  path(reports:any){
    if(reports.sno == '1'){
       this.router.navigate(['reports/operational/rmanArrgSummaryRep']);
    }
    if(reports.sno == '2'){
      this.router.navigate(['reports/operational/rmanTrxDetailReport']);
    }
    if(reports.sno == '3'){
      this.router.navigate(['reports/operational/rmanArrgWaterfallReportV']);
    }
    if(reports.sno == '4'){
      this.router.navigate(['reports/operational/rmanDeferredRollForwardRep']);
    }
   
    if(reports.sno == '5'){
      this.router.navigate(['reports/operational/rmanGlAccountingV']);
    }
    
    if(reports.sno == '14'){
      this.router.navigate(['reports/operational/ayaraForecastActualRep']);
    }
  }
}
