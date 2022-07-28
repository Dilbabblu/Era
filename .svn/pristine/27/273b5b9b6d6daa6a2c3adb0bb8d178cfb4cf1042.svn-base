import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RmanOpenDealArrangementsComponent } from '../rmanOpenDealArrangements/rmanOpenDealArrangements.component';
import { RmanOrderBookingsVComponent } from '../rmanOrderBookingsV/rmanOrderBookingsV.component';
import { RmanOrderLinesBookingsVComponent } from '../rmanOrderLinesBookingsV/rmanOrderLinesBookingsV.component';
import { RmanOrdersAuditVComponent } from '../rmanOrdersAuditV/rmanOrdersAuditV.component';
import { NewSharedModule } from '../shared/shared.module';

const routes: Routes = [
  {path: '', component:  RmanOrderBookingsVComponent},
]

@NgModule({
  imports:[NewSharedModule,RouterModule.forChild(routes)],
  exports:[RouterModule],
  declarations:[RmanOrderBookingsVComponent, RmanOrderLinesBookingsVComponent,RmanOrdersAuditVComponent,RmanOpenDealArrangementsComponent],
  providers: []
})

export class BookingsModule {
}
