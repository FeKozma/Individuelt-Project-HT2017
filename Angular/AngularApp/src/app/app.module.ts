import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ApplicationRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
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
    ReactiveFormsModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyAQOaX5EYPir-ZbXGfIlNNMexWInASEXcQ',
      libraries: ["places"]
    })
  ],
  providers: [],
  declarations: [ AppComponent, ForumComponent/**, AddAdComponent*/ ],
  bootstrap: [ AppComponent ]
})
export class AppModule {
//  model = new Cordinates(0, 0, 0);
getId() { return 3 }
}
