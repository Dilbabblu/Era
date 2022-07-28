import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ReportsService } from '../reportsservice';
declare var $: any;
declare var require: any;
const appSettings = require('../../appsettings');


@Component({
  selector : 'reconciliation-reports-data',
  templateUrl : './reconciliationReports.component.html'
})

export class ReconciliationReportsComponent{

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
    this.reportsService.getAllReports('enabledFlag:Y,reportType:RECONCILIATION').then((reportsList:any) => {
      this.reportsList= reportsList.content;
      this.loading = false;
   });
  }

  path1(reports:any){
    this.router.navigate([reports.reportPath]);
  }

  path(reports:any){
    if(reports.sno == '1'){
      this.router.navigate(['reports/reconciliation/rmanReconDealsArggRep']);
    }
    
    if(reports.sno == '2'){
      this.router.navigate(['reports/reconciliation/rmanReconSosrcToBkingsRep']);
    }
    if(reports.sno == '3'){
      this.router.navigate(['reports/reconciliation/rmanReconInvoiceRep']);
    }
    
    if(reports.sno == '4'){
      this.router.navigate(['reports/reconciliation/rmanReconShippedSoTrgRep']);
    }
    if(reports.sno == '5'){
      this.router.navigate(['reports/reconciliation/rmanReconRevtrigRecogRep']);
    }
    
  }


}
