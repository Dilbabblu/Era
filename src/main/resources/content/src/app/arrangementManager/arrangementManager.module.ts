import { HttpClientModule,HttpClientXsrfModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DealArrangementComponent } from '../dealArrangements/dealArrangement.component';
import { DealarrangementService } from '../dealArrangements/dealarrangement.service';
import { RmanArrangementsAllVComponent } from '../rmanArrangementsAllV/rmanArrangementsAllV.component';
import { RmanArrangementsOverViewComponent } from '../rmanArrangementsOverView/rmanArrangementsOverView.component';
import { RmanDealArrangementsComponent } from '../rmanDealArrangements/rmanDealArrangements.component';
import { RmanDealArrangementsService } from '../rmanDealArrangements/rmanDealArrangementsservice';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { NewSharedModule } from '../shared/shared.module';
import { ArrangementManagerSharedService } from './arrangementManager-shared.service';
import { ArrangementManagerComponent } from './arrangementManager.component';
import { CsrfTokenInterceptorService } from '../csrftoken-interceptor.service';


const routes: Routes =[
  {path:'',component:RmanArrangementsAllVComponent},
  {path:'rmanArrangementsOverView/:id/:dealFlag',component:RmanArrangementsOverViewComponent,
  children: [
    {path:'contracts', loadChildren : () => import('../contractManagerModules/contracts.module').then(m => m.ContractsModule)},
    {path:'allocations', loadChildren : () => import('../contractManagerModules/allocations.module').then(m => m.AllocationsModule)},
    {path:'vconsideration', loadChildren : () => import('../contractManagerModules/variableConsideration.module').then(m => m.VariableConsiderationModule)},
    {path:'bookings', loadChildren : () => import('../contractManagerModules/bookings.module').then(m => m.BookingsModule)},
    {path:'billings', loadChildren : () => import('../contractManagerModules/billings.module').then(m => m.BillingsModule)},
    {path:'revenue', loadChildren : () => import('../contractManagerModules/revenue.module').then(m => m.RevenueModule)},
    {path:'grossmargin', loadChildren : () => import('../contractManagerModules/grossMargin.module').then(m => m.GrossMarginModule)},
    {path:'forecasting', loadChildren : () => import('../contractManagerModules/forecasting.module').then(m => m.ForecastingModule)},
    {path:'approvalhistory', loadChildren : () => import('../contractManagerModules/approvalhistory.module').then(m => m.ApprovalHistoryModule)}

  ], 
  }
]

@NgModule({
  imports:[NewSharedModule,HttpClientModule,RouterModule.forChild(routes),
			HttpClientXsrfModule.withOptions({
              cookieName: "CSRF-TOKEN",
              headerName: "X-CSRF-TOKEN"
            })
		  ],
  declarations:[ArrangementManagerComponent, RmanArrangementsAllVComponent,RmanArrangementsOverViewComponent,DealArrangementComponent, RmanDealArrangementsComponent],
  providers: [RmanLookupsVService, RmanDealArrangementsService, ArrangementManagerSharedService, DealarrangementService,
			  { provide: HTTP_INTERCEPTORS, 
                useClass: CsrfTokenInterceptorService, 
                multi: true 
              }
  			 ]
})

export class ArrangementManagerModule {
  
}
