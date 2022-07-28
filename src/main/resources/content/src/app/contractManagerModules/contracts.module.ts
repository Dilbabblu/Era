import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContractHeadersInfoVComponent } from '../contractHeadersInfoV/contractHeadersInfoV.component';
import { DealarrangementService } from '../dealArrangements/dealarrangement.service';
import { RmanDealDetailsComponent } from '../rmanDealDetails/rmanDealDetails.component';
import { NewSharedModule } from '../shared/shared.module';

const routes: Routes = [
  {path: '', component:  ContractHeadersInfoVComponent},
]

@NgModule({
  imports:[NewSharedModule,RouterModule.forChild(routes)],
  exports:[RouterModule],
  declarations:[ContractHeadersInfoVComponent,RmanDealDetailsComponent],
  providers: [DealarrangementService],

})

export class ContractsModule {
}
