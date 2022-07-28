import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RmanDealGmAsvComponent } from '../rmanDealGmAsv/rmanDealGmAsv.component';
import { NewSharedModule } from '../shared/shared.module';

const routes: Routes = [
  {path: '', component:  RmanDealGmAsvComponent},
]

@NgModule({
  imports:[NewSharedModule,RouterModule.forChild(routes)],
  exports:[RouterModule],
  declarations:[RmanDealGmAsvComponent],
  providers: []
})

export class GrossMarginModule {
}
