import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConfirmationService } from 'primeng/api';
import { NewSharedModule } from '../../../shared/shared.module';
import { AppService } from '../services/app.service';
import { DrillDownService } from '../services/drill-down.service';
import { DashboardComponent } from './dashboard.component';
import { DashboardFavoritesComponent } from './dashboardFavorites/dashboardFavorites.component';
import { ChartsModule } from 'ng2-charts';
import {GraphSharedModule} from '../../../shared/graphShared.module';


const routes: Routes = [
  {path: '', component: DashboardComponent},
];

@NgModule({
  declarations: [
    DashboardComponent,
    DashboardFavoritesComponent
  ],
  imports: [
    CommonModule,NewSharedModule,ChartsModule,GraphSharedModule,
    RouterModule.forChild(routes),
  ],
  providers: [
    DrillDownService,
    AppService,
    ConfirmationService
  ]
})
export class DashboardModule { }
