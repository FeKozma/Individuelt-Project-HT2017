import { NgModule, Component } from '@angular/core';
import { AgmCoreModule } from '@agm/core';
import { BrowserModule } from '@angular/platform-browser';
/** import { AddAdComponent } from './add-ad/addAdImport'*/

import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';



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
  private apiUrl = 'http://localhost:8080/hello';
  data: any = {};

  constructor(private http: Http) {
    console.log('contacting api');
    this.getContacts();
    this.getData();
  }

  getData() {
    return this.http.get(this.apiUrl).map((res: Response) => res.json())
  }

  getContacts() {
    this.getData().subscribe(data => {
        console.log(data);
        this.data = data;
    })
  }
}
