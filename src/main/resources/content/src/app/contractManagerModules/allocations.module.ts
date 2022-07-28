import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ArrgContractAllocationsVComponent } from '../arrgContractAllocationsV/arrgContractAllocationsV.component';
import { NewSharedModule } from '../shared/shared.module';

const routes: Routes = [
  {path: '', component:  ArrgContractAllocationsVComponent},
]

@NgModule({
  imports:[NewSharedModule,RouterModule.forChild(routes)],
  exports:[RouterModule],
  declarations:[ArrgContractAllocationsVComponent],
  providers: []

})

export class AllocationsModule {
}
