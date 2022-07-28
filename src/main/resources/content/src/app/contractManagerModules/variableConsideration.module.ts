import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RmanContReleaseLinesVComponent } from '../rmanContReleaseLinesV/rmanContReleaseLinesV.component';
import { RmanContTransLinesComponent } from '../rmanContTransLines/rmanContTransLines.component';
import { RmanContTransToReleaseComponent } from '../rmanContTransToRelease/rmanContTransToRelease.component';
import { NewSharedModule } from '../shared/shared.module';

const routes: Routes = [
  {path: '', component:  RmanContTransToReleaseComponent},
]

@NgModule({
  imports:[NewSharedModule,RouterModule.forChild(routes)],
  exports:[RouterModule],
  declarations:[RmanContTransToReleaseComponent,RmanContTransLinesComponent,RmanContReleaseLinesVComponent],
  providers: []

})

export class VariableConsiderationModule {
}
