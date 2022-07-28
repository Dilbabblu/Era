import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RmanApprovalHistoryComponent } from '../rmanApprovalHistory/rmanApprovalHistory.component';
import { NewSharedModule } from '../shared/shared.module';

const routes: Routes = [
  {path: '', component:  RmanApprovalHistoryComponent},
]

@NgModule({
  imports:[NewSharedModule,RouterModule.forChild(routes)],
  exports:[RouterModule],
  declarations:[RmanApprovalHistoryComponent],
  providers: []
})

export class ApprovalHistoryModule {
}
