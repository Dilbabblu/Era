import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RmanInvoiceHeadersVComponent } from '../rmanInvoiceHeadersV/rmanInvoiceHeadersV.component';
import { RmanInvoiceLinesVComponent } from '../rmanInvoiceLinesV/rmanInvoiceLinesV.component';
import { NewSharedModule } from '../shared/shared.module';

const routes: Routes = [
  {path: '', component:  RmanInvoiceHeadersVComponent},
]

@NgModule({
  imports:[NewSharedModule,RouterModule.forChild(routes)],
  exports:[RouterModule],
  declarations:[RmanInvoiceHeadersVComponent,RmanInvoiceLinesVComponent],
  providers: []
})

export class BillingsModule {
}
