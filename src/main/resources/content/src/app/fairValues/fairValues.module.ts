import { NgModule, Optional, SkipSelf } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RmanFmvRulesDefComponent } from '../rmanFmvRulesDef/rmanFmvRulesDef.component';
import { RmanFmvRulesDefParaValueComponent } from '../rmanFmvRulesDefParaValue/rmanFmvRulesDefParaValue.component';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { NewSharedModule } from '../shared/shared.module';
import { SspActionLogsComponent } from '../sspActionLogs/sspActionLogs.component';
import { GenerateSSPComponent } from '../sspBooks/generateSsp/generateSsp.component';
import { SspBooksComponent } from '../sspBooks/sspBooks.component';
import { SspGroupingRuleDimensionsComponent } from '../sspGroupingRuleDimensions/sspGroupingRuleDimensions.component';
import { SspGroupingRulesComponent } from '../sspGroupingRules/sspGroupingRules.component';
import { FairValuesComponent } from './fairValues.component';


const routes: Routes =[
  {path:'',component:FairValuesComponent},
  {path:'rmanFmvRulesDef',component:RmanFmvRulesDefComponent},
  {path:'sspBooks/rmanFmvRulesDef/:id',component:RmanFmvRulesDefComponent},
  {path:'rmanFmvRulesDefParaValue',component:RmanFmvRulesDefParaValueComponent},
  {path:'sspBooks', component: SspBooksComponent},
  {path:'sspBooks/groupingRules', component:SspGroupingRulesComponent},
  {path:'sspBooks/generateSSP/:id', component:GenerateSSPComponent},
  {path:'sspActionLogs', component:SspActionLogsComponent}
]


@NgModule({
  imports:[NewSharedModule,RouterModule.forChild(routes)],
  declarations:[FairValuesComponent,RmanFmvRulesDefParaValueComponent,RmanFmvRulesDefComponent,
    SspBooksComponent,SspGroupingRulesComponent, SspGroupingRuleDimensionsComponent,
    GenerateSSPComponent,SspActionLogsComponent],
  providers: [RmanLookupsVService]

})

export class FairValuesModule{
  constructor(@Optional() @SkipSelf() fair:FairValuesModule ) {
  }
}
