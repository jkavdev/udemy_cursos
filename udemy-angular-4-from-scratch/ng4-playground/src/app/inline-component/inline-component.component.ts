import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-inline-component',
  template:
    `<h1>Inline html component</h1>
    
    <br/>{{user.sexo}} - {{user.idade}}


    <h1>Hey Users</h1>
    <ul>
      <li *ngFor="let user of users">
        {{user.sexo}} - {{user.idade}}
      </li>
    </ul>

    <div *ngIf="user; then template1 else template2"></div>

    <ng-template #template1>{{user.sexo}} - {{user.idade}}</ng-template>
    <ng-template #template2>usuario nao existe</ng-template>

    `
  ,
  styleUrls: ['./inline-component.component.css']
})
export class InlineComponentComponent implements OnInit {

  user = {
    sexo: 'masculino',
    idade: 15,
    localidade: 'BRA'
  }

  users = [
    {
      sexo: 'masculino',
      idade: 15,
      localidade: 'BRA'
    },
    {
      sexo: 'feminino',
      idade: 16,
      localidade: 'EUA'
    },
    {
      sexo: 'masculino',
      idade: 21,
      localidade: 'FRE'
    },
  ]

  constructor() { }

  ngOnInit() {
  }



}
