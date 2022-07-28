import { CommonModule } from '@angular/common';
import { HttpClientModule,HttpClientXsrfModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { CardModule } from 'primeng/card';
import { DropdownModule } from 'primeng/dropdown';
import { ProgressSpinnerModule } from 'primeng/progressspinner';
import { RmanFiscalPeriodsService } from '../rmanFiscalPeriods/rmanFiscalPeriodsservice';
import { GraphSharedModule } from '../shared/graphShared.module';
import { LandingDashboardComponent } from './landingDashboard.component';
import { LandingDashboardService } from './landingDashboard.service';
import { CsrfTokenInterceptorService } from '../csrftoken-interceptor.service';


const routes: Routes = [
  { path: "", component: LandingDashboardComponent }
]

@NgModule({
  declarations: [LandingDashboardComponent],
  imports: [CardModule, DropdownModule,FormsModule,CommonModule, ProgressSpinnerModule,GraphSharedModule, HttpClientModule,RouterModule.forChild(routes),
			HttpClientXsrfModule.withOptions({
              cookieName: "CSRF-TOKEN",
              headerName: "X-CSRF-TOKEN"
            })
     	   ],
  exports: [CardModule,DropdownModule,FormsModule,ProgressSpinnerModule],
  providers: [LandingDashboardService, RmanFiscalPeriodsService,
				{ provide: HTTP_INTERCEPTORS, 
	                useClass: CsrfTokenInterceptorService, 
	                multi: true 
	              }
    		 ],
})
export class LandingDashboardModule { }
