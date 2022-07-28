//import { ToastModule, ToastOptions } from 'ng2-toastr/ng2-toastr';
import { DatePipe } from '@angular/common';
import { HttpClientModule, HttpClientXsrfModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule, Title } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { MessageService } from 'primeng/api';
import { AppComponent } from './app.component';
import { AppPreloadingStrategy } from './appPreloadingStrategy';
import { FooterComponent } from './footer/footer.component';
import { AppService } from './reports/analyticalReports/services/app.service';
import { DrillDownService } from './reports/analyticalReports/services/drill-down.service';
import { RmanPasswordComponent } from './rmanPassword/rmanPassword.component';
import { CommonSharedService } from './shared/common.service';
import { NotificationService } from './shared/notifications.service';
import { NewSharedModule } from './shared/shared.module';
import { UploadService } from './shared/upload.service';
import { SystemInfoComponent } from './systemInfo/systemInfo.component';
import { UserInfoComponent } from './userInfo/userInfo.component';
import { ChartsModule } from 'ng2-charts';
import { CsrfTokenInterceptorService } from './csrftoken-interceptor.service';


const routes: Routes = [
  { path: "dashboard", loadChildren: () => import('./landingDashboard/landingDashboard.module').then(m => m.LandingDashboardModule) },
  { path: "configuration", loadChildren: () => import('./configurationManager/configurationManager.module').then(m => m.configurationManagerModule) },
  { path: "admin", loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule) },
  { path: "fairValues", loadChildren: () => import('./fairValues/fairValues.module').then(m => m.FairValuesModule) },
  { path: "rmanArrangementsAllV", loadChildren: () => import('./arrangementManager/arrangementManager.module').then(m => m.ArrangementManagerModule) },
  { path: "jobs", loadChildren: () => import('./jobs/jobs.module').then(m => m.JobsModule) },
  { path: "reports", loadChildren: () => import('./reportsModule/reports.module').then(m => m.reportsModule) },
  { path: "reports/analytical/report", loadChildren: () => import('./reports/analyticalReports/report/report.module').then(m => m.ReportModule) },
  { path: "reports/analytical/report/:id", loadChildren: () => import('./reports/analyticalReports/report/report.module').then(m => m.ReportModule) },
  { path: "exceptions", loadChildren: () => import('./exceptions/exceptions.module').then(m => m.ExceptionsModule) },
  { path: "userInfo", component: UserInfoComponent},
  { path: "systemInfo", component: SystemInfoComponent},
  { path: "approvals", loadChildren: () => import('./approvals/approvals.module').then(m => m.ApprovalsModule) },
  { path: '', redirectTo: 'dashboard', pathMatch: 'full' }
];
@NgModule({
  imports: [BrowserModule, HttpClientModule, BrowserAnimationsModule, RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules, useHash: true }), NewSharedModule,ChartsModule,
			HttpClientXsrfModule.withOptions({
              cookieName: "CSRF-TOKEN",
              headerName: "X-CSRF-TOKEN"
            })
		   ],
  declarations: [AppComponent, RmanPasswordComponent, FooterComponent, UserInfoComponent, SystemInfoComponent],
  providers: [DatePipe, AppPreloadingStrategy, CommonSharedService, Title, DrillDownService, AppService, NotificationService, MessageService, UploadService,
			  { provide: HTTP_INTERCEPTORS, 
                useClass: CsrfTokenInterceptorService, 
                multi: true 
              }
			 ],
  bootstrap: [AppComponent],
  entryComponents: [RmanPasswordComponent]
})
export class AppModule { }
