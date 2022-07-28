// import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RmanIntfDealDetailsComponent } from '../rmanIntfDealDetails/rmanIntfDealDetails.component';
import { RmanInvoiceLinesInterfaceComponent } from '../rmanInvoiceLinesInterface/rmanInvoiceLinesInterface.component';
import { RmanOrdersInterfaceComponent } from '../rmanOrdersInterface/rmanOrdersInterface.component';
import { NewSharedModule } from '../shared/shared.module';
import { ExceptionJobMonitorComponent } from './exception-job-monitor/exception-job-monitor.component';
import { ExceptionsComponent } from './exceptions/exceptions.component';
import { AllExceptionsComponent } from './allExceptions/allExceptions.component';

const routes: Routes =[
    {path:':exceptionType',component:ExceptionsComponent},
   
    
];
@NgModule({
    imports:[NewSharedModule,RouterModule.forChild(routes)],
    declarations:[RmanInvoiceLinesInterfaceComponent,RmanOrdersInterfaceComponent,RmanIntfDealDetailsComponent, ExceptionsComponent, ExceptionJobMonitorComponent, AllExceptionsComponent],
  })
  
  export class ExceptionsModule{
      
  }