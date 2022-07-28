import { CommonModule } from '@angular/common';
import { HttpClientModule, HttpClientXsrfModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConcurrentProgramsComponent } from '../conurrentPrograms/conurrentPrograms.component';
import { NewSharedModule } from '../shared/shared.module';
import { JobsComponent } from './jobs.component';
import { CsrfTokenInterceptorService } from '../csrftoken-interceptor.service';


const routes: Routes =[
  {path:'',component:ConcurrentProgramsComponent},
]

@NgModule({
  imports:[CommonModule,NewSharedModule,HttpClientModule,RouterModule.forChild(routes),
			HttpClientXsrfModule.withOptions({
              cookieName: "CSRF-TOKEN",
              headerName: "X-CSRF-TOKEN"
            })
		  ],
  declarations:[ConcurrentProgramsComponent,JobsComponent],
  providers: [{ provide: HTTP_INTERCEPTORS, 
                useClass: CsrfTokenInterceptorService, 
                multi: true 
              }
             ]


})

export class JobsModule{
}
