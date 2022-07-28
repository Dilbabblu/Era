import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RmanLookupsVService } from '../../rmanLookupsV/rmanLookupsVservice';
import { RmanReconDealsArggRepComponent } from '../../rmanReconDealsArggRep/rmanReconDealsArggRep.component';
import { RmanReconInvoiceReportVComponent } from '../../rmanReconInvoiceReportV/rmanReconInvoiceReportV.component';
import { RmanReconRevtrigRecogRepComponent } from '../../rmanReconRevtrigRecogRep/rmanReconRevtrigRecogRep.component';
import { RmanReconShippedSoTrgRepComponent } from '../../rmanReconShippedSoTrgRep/rmanReconShippedSoTrgRep.component';
import { RmanReconSosrcToBkingsRepComponent } from '../../rmanReconSosrcToBkingsRep/rmanReconSosrcToBkingsRep.component';
import { NewSharedModule } from '../../shared/shared.module';
import { ReconciliationReportsComponent } from './reconciliationReports.component';

const routes: Routes = [
  {path: '', component: ReconciliationReportsComponent},
  {path: "rmanReconDealsArggRep",component:RmanReconDealsArggRepComponent},
  {path: "rmanReconSosrcToBkingsRep",component:RmanReconSosrcToBkingsRepComponent},
  {path: "rmanReconInvoiceRep" , component: RmanReconInvoiceReportVComponent},
  {path: "rmanReconShippedSoTrgRep",component:RmanReconShippedSoTrgRepComponent},
  {path: "rmanReconRevtrigRecogRep",component:RmanReconRevtrigRecogRepComponent},
]

@NgModule({
  imports:[NewSharedModule,RouterModule.forChild(routes)],
  declarations:[ReconciliationReportsComponent,
                RmanReconInvoiceReportVComponent, 
                RmanReconSosrcToBkingsRepComponent,
                RmanReconDealsArggRepComponent,
                RmanReconRevtrigRecogRepComponent,
                RmanReconShippedSoTrgRepComponent],
  providers: [RmanLookupsVService]

})

export class ReconciliationReportsModule {
}
