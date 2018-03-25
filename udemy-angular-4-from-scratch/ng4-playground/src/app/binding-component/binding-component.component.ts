import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-binding-component',
  template: `

  <img src="{{angularLogo}}" width="150"/>
  <img [src]="angularLogo" width="150"/>
  <img bind-src="angularLogo" width="150"/>

  <button [disabled]="buttonStatus" (click)="OkButton()">Enabled</button>
  <button [disabled]="!buttonStatus" (click)="OkButton()">Disabled</button>

  `,
  styleUrls: ['./binding-component.component.css']
})
export class BindingComponentComponent implements OnInit {

  angularLogo = 'https://angular.io/assets/images/logos/angular/angular.svg';
  buttonStatus = false;

  constructor() { }

  ngOnInit() {
  }

  OkButton(){
    console.log('OKOKOKOKOKOKOKOKOK')
  }


}
