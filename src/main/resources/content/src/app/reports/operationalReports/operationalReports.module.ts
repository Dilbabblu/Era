import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BsbReportComponent } from 'src/app/bsbReport/bsbReport.component';
import { ConsolidatedArrgSummaryRepComponent } from 'src/app/consolidatedArrgSummaryRep/consolidatedArrgSummaryRep.component';
import { RmanDzsGlAccountingVComponent } from 'src/app/rmanDzsGlAccountingV/rmanDzsGlAccountingV.component';
import { RmanArrgSummaryReportVComponent } from '../../rmanArrgSummaryReportV/rmanArrgSummaryReportV.component';
import { RmanArrgWaterfallReportVComponent } from '../../rmanArrgWaterfallReportV/rmanArrgWaterfallReportV.component';
import { RmanDefRollforwardReportVComponent } from '../../rmanDefRollforwardReportV/rmanDefRollforwardReportV.component';
import { RmanGlAccountingVComponent } from '../../rmanGlAccountingV/rmanGlAccountingV.component';
import { AyaraForecastActualRepComponent } from '../../ayaraForecastActualRep/ayaraForecastActualRep.component'; 
import { RmanLookupsVService } from '../../rmanLookupsV/rmanLookupsVservice';
import { RmanTrxDetailReportComponent } from '../../rmanTrxDetailReport/rmanTrxDetailReport.component';
import { NewSharedModule } from '../../shared/shared.module';
import { OperationalReportsComponent } from './operationalReports.component';
import { RmanArrgForecastingDetailReportComponent } from '../../rmanArrgForecastingDetailReport/rmanArrgForecastingDetailReport.component';
import { AyaraActiveQuotesARMReportComponent } from '../../ayaraActiveQuotesARMReport/ayaraActiveQuotesARMReport.component';
import { AyaraActualsARMReportComponent } from '../../ayaraActualsARMReport/ayaraActualsARMReport.component';
import { AyaraActualsVsActiveReportComponent } from '../../ayaraActualsVsActiveReport/ayaraActualsVsActiveReport.component';
import { ChartsModule } from 'ng2-charts';
import { GraphSharedModule } from '../../shared/graphShared.module';

const routes: Routes = [
  {path: '', component:OperationalReportsComponent},
  {path: "rmanArrgSummaryRep",component:RmanArrgSummaryReportVComponent},
  {path: "rmanTrxDetailReport", component: RmanTrxDetailReportComponent},
  {path: "rmanArrgWaterfallReportV",component:RmanArrgWaterfallReportVComponent},
  {path: "rmanDeferredRollForwardRep" , component: RmanDefRollforwardReportVComponent},
  {path: "rmanGlAccountingV", component: RmanGlAccountingVComponent },
  {path: "ayaraForecastActualRep", component: AyaraForecastActualRepComponent },
  {path: "rmanArrgForecastingDetailReport", component: RmanArrgForecastingDetailReportComponent},
  {path: "ayaraActiveQuotesARMReport", component: AyaraActiveQuotesARMReportComponent},
  {path: "ayaraActualsARMReport", component: AyaraActualsARMReportComponent},
  {path: "ayaraActualsVsActiveReport", component: AyaraActualsVsActiveReportComponent}
]

@NgModule({
  imports:[NewSharedModule,RouterModule.forChild(routes),ChartsModule, GraphSharedModule ],
  declarations:[OperationalReportsComponent,RmanGlAccountingVComponent,RmanArrgSummaryReportVComponent, RmanArrgWaterfallReportVComponent, RmanTrxDetailReportComponent,RmanDefRollforwardReportVComponent, BsbReportComponent, ConsolidatedArrgSummaryRepComponent, RmanDzsGlAccountingVComponent,RmanArrgWaterfallReportVComponent,AyaraForecastActualRepComponent, RmanArrgForecastingDetailReportComponent,AyaraActiveQuotesARMReportComponent, AyaraActualsARMReportComponent, AyaraActualsVsActiveReportComponent],
  providers: [RmanLookupsVService]

})

export class OperationalReportsModule {
}
