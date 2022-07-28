import { CommonModule } from '@angular/common';
import { HttpClientModule, HttpClientXsrfModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RmanPendingApprovalsComponent } from '../rmanPendingApprovals/rmanPendingApprovals.component';
import { NewSharedModule } from '../shared/shared.module';
import { ApprovalsComponent } from './approvals.component';
import { CsrfTokenInterceptorService } from '../csrftoken-interceptor.service';

const routes: Routes =[
  {path:'',component:RmanPendingApprovalsComponent},
]

@NgModule({
  imports:[CommonModule,NewSharedModule,HttpClientModule,RouterModule.forChild(routes),
           HttpClientXsrfModule.withOptions({
              cookieName: "CSRF-TOKEN",
              headerName: "X-CSRF-TOKEN"
            })
          ],
  declarations:[RmanPendingApprovalsComponent,ApprovalsComponent],
  providers: [{ provide: HTTP_INTERCEPTORS, 
                useClass: CsrfTokenInterceptorService, 
                multi: true 
              }
             ]


})

export class ApprovalsModule{
}
