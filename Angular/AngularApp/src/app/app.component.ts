import { NgModule, Component } from '@angular/core';
import { AgmCoreModule } from '@agm/core';
import { BrowserModule } from '@angular/platform-browser';
/** import { AddAdComponent } from './add-ad/addAdImport'*/



@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.css'],
/**  directives: [AddAdComponent]*/
})
export class AppComponent {
  title: string = 'Google maps';
  lat: number = 56.16156;
  lng: number = 15.58661;

}

@NgModule({
  imports: [
    BrowserModule,
    AgmCoreModule.forRoot({
      apiKey: 'YOUR_GOOGLE_MAPS_API_KEY'
    })
  ],
  declarations: [ AppComponent ],
  bootstrap: [ AppComponent ]
})
export class AppModule {}
