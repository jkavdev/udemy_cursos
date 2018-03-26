import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-service-component',
  template: `
  
  <p>{{someproperty}}</p>

  `,
  styleUrls: ['./service-component.component.css']
})
export class ServiceComponentComponent implements OnInit {

  someproperty: string = '';

  constructor(
    private dataService: DataService
  ) { }

  ngOnInit() {
    console.log(this.dataService.cars);
    this.someproperty = JSON.stringify(this.dataService.myCars());
  }

}
