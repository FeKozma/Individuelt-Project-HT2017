import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ApplicationRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';


import { AgmCoreModule } from '@agm/core';
import { ForumComponent } from './forum/forum.component';
/** import { AddAdComponent } from './add-ad/addAdImport'; */

import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';

import { ApproveAppComponent } from './approveApp/approveApp.component';
import { ApproveCompanyComponent } from './approve-company/approve-company.component';

@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    RouterModule.forRoot([
      {
        path: 'approve-app',
        component: ApproveAppComponent
      },
      {
        path: '',
        component: ForumComponent
      },
      {
        path: 'approve-company',
        component: ApproveCompanyComponent
      }
    ]),
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyAQOaX5EYPir-ZbXGfIlNNMexWInASEXcQ',
      libraries: ["places"]
    })
  ],
  providers: [],
  declarations: [ AppComponent, ForumComponent, ApproveAppComponent, ApproveCompanyComponent/**, AddAdComponent*/ ],
  bootstrap: [ AppComponent ]
})
export class AppModule {
//  model = new Cordinates(0, 0, 0);
getId() { return 3 }
}
