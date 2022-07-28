import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RmanContHeaderComponent } from '../rmanContHeader/rmanContHeader.component';
import { RmanContTemplateComponent } from '../rmanContTemplate/rmanContTemplate.component';
import { RmanConversionRatesComponent } from '../rmanConversionRates/rmanConversionRates.component';
import { RmanFcBucketsComponent } from '../rmanFcBuckets/rmanFcBuckets.component';
import { RmanFiscalPeriodsComponent } from '../rmanFiscalPeriods/rmanFiscalPeriods.component';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { RmanPobMappingComponent } from '../rmanPobMapping/rmanPobMapping.component';
import { RmanRuleParameterValueComponent } from '../rmanRuleParameterValue/rmanRuleParameterValue.component';
import { RmanRulesHeaderComponent } from '../rmanRulesHeader/rmanRulesHeader.component';
import {RmanApprovalRulesComponent } from '../rmanApprovalRules/rmanApprovalRules.component';
import { NewSharedModule } from '../shared/shared.module';
import { ConfigurationManagerComponent } from './configurationManager.component';



const routes: Routes =[
  {path:'',component:ConfigurationManagerComponent},
  {path:'rmanRulesHeader',component:RmanRulesHeaderComponent},
  {path:'rmanContHeader',component:RmanContHeaderComponent},
  {path:'rmanContTemplate',component:RmanContTemplateComponent},
  {path:'rmanFcBuckets',component:RmanFcBucketsComponent},
  {path:'rmanFiscalPeriods',component:RmanFiscalPeriodsComponent},
  {path:'rmanPobMappings',component:RmanPobMappingComponent},
  {path: 'rmanConversionRates', component: RmanConversionRatesComponent},
  {path: 'rmanApprovalRules', component: RmanApprovalRulesComponent}
]   

@NgModule({
  imports:[NewSharedModule,RouterModule.forChild(routes)],
  declarations:[RmanConversionRatesComponent, ConfigurationManagerComponent,RmanRulesHeaderComponent,RmanRuleParameterValueComponent,RmanContHeaderComponent,RmanContTemplateComponent,RmanFiscalPeriodsComponent,RmanPobMappingComponent,RmanFcBucketsComponent, RmanApprovalRulesComponent],
  providers: [RmanLookupsVService]

})

export class configurationManagerModule{
}
