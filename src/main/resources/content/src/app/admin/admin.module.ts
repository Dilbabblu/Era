import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConfirmationService } from 'primeng/api';
import { RmanAccountSetupComponent } from '../rmanAccountSetup/rmanAccountSetup.component';
import { RmanCurrencyComponent } from '../rmanCurrency/rmanCurrency.component';
import { RmanCustomersComponent } from '../rmanCustomers/rmanCustomers.component';
import { RmanEntitiesComponent } from '../rmanEntities/rmanEntities.component';
import { RmanEntityParametersComponent } from '../rmanEntityParameters/rmanEntityParameters.component';
import { RmanEntityParametersVComponent } from '../rmanEntityParametersV/rmanEntityParametersV.component';
import { RmanEventsComponent } from '../rmanEvents/rmanEvents.component';
import { RmanFunctionsComponent } from '../rmanFunctions/rmanFunctions.component';
import { RmanGlAccountsComponent } from '../rmanGlAccounts/rmanGlAccounts.component';
import { RmanLegalEntitiesComponent } from '../rmanLegalEntities/rmanLegalEntities.component';
import { RmanLookupCodesComponent } from '../rmanLookupCodes/rmanLookupCodes.component';
import { RmanLookupsVComponent } from '../rmanLookupsV/rmanLookupsV.component';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { RmanLookupTypesComponent } from '../rmanLookupTypes/rmanLookupTypes.component';
import { RmanProductsComponent } from '../rmanProducts/rmanProducts.component';
import { RmanResponsibilitiesComponent } from '../rmanResponsibilities/rmanResponsibilities.component';
import { RmanResponsibilitiesService } from '../rmanResponsibilities/rmanResponsibilitiesservice';
import { RmanPermissionsComponent } from '../rmanResponsibilitiesPermissions/rmanResponsibilitiesPermissions.component';
import { RmanRevenueTemplatesComponent } from '../rmanRevenueTemplates/rmanRevenueTemplates.component';
import { RmanRolePermissionsComponent } from '../rmanRolePermissions/rmanRolePermissions.component';
import { RmanUserResponsibilitiesComponent } from '../rmanUserResponsibilities/rmanUserResponsibilities.component';
import { RmanUsersComponent } from '../rmanUsers/rmanUsers.component';
import { NewSharedModule } from '../shared/shared.module';
import { AdminComponent } from './admin.component';

const routes: Routes =[
  {path:'',component:AdminComponent},
  {path:'rmanLegalEntities',component:RmanLegalEntitiesComponent},
  {path:'rmanProducts',component:RmanProductsComponent},
  {path:'rmanGlAccounts',component:RmanGlAccountsComponent},
  {path:'rmanRevenueTemplates',component:RmanRevenueTemplatesComponent},
  {path:'rmanAccountSetup',component:RmanAccountSetupComponent},
  {path:'rmanOrderEvents',component:RmanEventsComponent},
  {path:'rmanEntities',component:RmanEntitiesComponent},
  {path:'rmanEntityParameters',component:RmanEntityParametersComponent},
  {path:'rmanUsers',component:RmanUsersComponent},
  {path:'rmanUserResponsibilities',component:RmanUserResponsibilitiesComponent},
  {path:'rmanLookupTypes',component:RmanLookupTypesComponent},
  {path:'rmanLookupCodes',component:RmanLookupCodesComponent},
  {path:'rmanResponsibilities',component:RmanResponsibilitiesComponent},
  {path: "rmanCustomers", component: RmanCustomersComponent},
  {path: "rmanCurrency", component: RmanCurrencyComponent},
  {path: "rmanFunctions", component: RmanFunctionsComponent},
  {path: "rmanRolePermissions", component: RmanRolePermissionsComponent},
  {path: "rmanRolePermissions/:role/:name", component: RmanRolePermissionsComponent},

]

@NgModule({
  imports:[NewSharedModule,RouterModule.forChild(routes)],
  declarations:[RmanCurrencyComponent,RmanCustomersComponent, AdminComponent,
    RmanLegalEntitiesComponent,RmanProductsComponent,RmanGlAccountsComponent,
    RmanRevenueTemplatesComponent,RmanAccountSetupComponent,RmanEventsComponent,
    RmanEntitiesComponent,RmanEntityParametersComponent,RmanUsersComponent,
    RmanUserResponsibilitiesComponent,RmanLookupCodesComponent,RmanLookupTypesComponent,
    RmanEntityParametersVComponent,RmanLookupsVComponent,
    RmanResponsibilitiesComponent,RmanPermissionsComponent,RmanFunctionsComponent,
    RmanRolePermissionsComponent],
    providers: [RmanResponsibilitiesService,RmanLookupsVService ,ConfirmationService]

})

export class AdminModule{
}
