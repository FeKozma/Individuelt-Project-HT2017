import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ApplicationRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';

import { AgmCoreModule } from '@agm/core';
import { ForumComponent } from './forum/forum.component';
/** import { AddAdComponent } from './add-ad/addAdImport'; */

import { HttpModule } from '@angular/http';

@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    CommonModule,
    FormsModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyAQOaX5EYPir-ZbXGfIlNNMexWInASEXcQ'
    })
  ],
  providers: [],
  declarations: [ AppComponent, ForumComponent/**, AddAdComponent*/ ],
  bootstrap: [ AppComponent ]
})
export class AppModule {}
