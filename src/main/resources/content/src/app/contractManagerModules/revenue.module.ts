import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RmanContReleaseEventsVComponent } from '../rmanContReleaseEventsV/rmanContReleaseEventsV.component';
import { RmanRevDetailsVComponent } from '../rmanRevDetailsV/rmanRevDetailsV.component';
import { NewSharedModule } from '../shared/shared.module';

const routes: Routes = [
  {path: '', component:  RmanRevDetailsVComponent},
]

@NgModule({
  imports:[NewSharedModule,RouterModule.forChild(routes)],
  exports:[RouterModule],
  declarations:[RmanRevDetailsVComponent, RmanContReleaseEventsVComponent],
  providers: []
})

export class RevenueModule {
}
