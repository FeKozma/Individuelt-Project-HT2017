import { Component, OnInit } from '@angular/core';

import { Data } from '../data.model';

@Component({
  selector: 'app-forum',
  templateUrl: './forum.component.html',
  styleUrls: ['./forum.component.css']
})
export class ForumComponent implements OnInit {

  model = new Data(1, '', '', 'http://');

  constructor() { }

  ngOnInit() {
  }

  get currentData(){
    return JSON.stringify(this.model);
  }
}
