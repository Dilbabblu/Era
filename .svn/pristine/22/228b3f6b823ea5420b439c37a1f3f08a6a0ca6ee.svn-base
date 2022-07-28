import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { pdfComponent } from '../reports/analyticalReports/report/PdfComponent';
import { ReportsService } from '../reports/reportsservice';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { NewSharedModule } from '../shared/shared.module';
import { ChartsModule } from 'ng2-charts';
import {GraphSharedModule} from '../shared/graphShared.module';

const routes: Routes = [
  { path: "operational", loadChildren: () => import('../reports/operationalReports/operationalReports.module').then(m => m.OperationalReportsModule) },
  { path: "reconciliation", loadChildren: () => import('../reports/reconciliationReports/reconciliationReports.module').then(m => m.ReconciliationReportsModule) },
  { path: "analytical", loadChildren: () => import('../reports/analyticalReports/dashboard/dashboard.module').then(m => m.DashboardModule) },
  { path: 'pdfDownload', component: pdfComponent },
  { path: '', redirectTo: 'rmanArrangementsAllV', pathMatch: 'full' }
]

@NgModule({
  imports: [NewSharedModule, GraphSharedModule, ChartsModule, RouterModule.forChild(routes)],
  declarations: [],
  providers: [RmanLookupsVService, ReportsService]

})

export class reportsModule {
}
