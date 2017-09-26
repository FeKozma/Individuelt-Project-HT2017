import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ApplicationRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';

import { AgmCoreModule } from '@agm/core';
/** import { AddAdComponent } from './add-ad/addAdImport'; */

@NgModule({
  imports: [
    BrowserModule,
    CommonModule,
    FormsModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyAQOaX5EYPir-ZbXGfIlNNMexWInASEXcQ'
    })
  ],
  providers: [],
  declarations: [ AppComponent/**, AddAdComponent*/ ],
  bootstrap: [ AppComponent ]
})
export class AppModule {}
