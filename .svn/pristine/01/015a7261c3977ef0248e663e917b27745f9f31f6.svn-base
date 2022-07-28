import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RmanDealRfcstVComponent } from '../rmanDealRfcstV/rmanDealRfcstV.component';
import { RmanForecastActualsAnalysisComponent } from '../rmanForecastActualAnalysis/rmanForecastActualsAnalysis.component';
//import { RmanForecastingDetailsComponent } from '../rmanForecastingDetails/rmanForecastingDetails.component';
import { NewSharedModule } from '../shared/shared.module';

const routes: Routes = [
 // {path: 'enterForecasting', component:  RmanForecastingDetailsComponent},
  {path: 'viewForecasting', component:  RmanDealRfcstVComponent},
  {path: 'actualAnalysis', component:  RmanForecastActualsAnalysisComponent},
]

@NgModule({
  imports:[NewSharedModule,RouterModule.forChild(routes)],
  exports:[RouterModule],
  declarations:[RmanDealRfcstVComponent,RmanForecastActualsAnalysisComponent],
  providers: []

})

export class ForecastingModule {
}
