import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-css-inline-component',
  template: `
  
    <h1>Vamos que ta funcionando</h1>
    <h1 [class]="titleClass">Usando style class</h1>
    <h1 [class.blue-title]="titleClass">Usando style class</h1>
    
    <h1 [ngClass]="titleClasses">Usando style classes</h1>

  `
  ,
  styles: [`
  
  h1 {
    text-decoration: underline;
    color: brown;
  }
  
  .red-title {
    color: red;
  }
  .large-title {
    font-size: 150px;
  }
  .blue-title {
    color: blue;
  }

  `]
})
export class CssInlineComponentComponent implements OnInit {

  titleClass = 'red-title';
  titleClasses = {
    'red-title': true,
    'large-title': true
  };

  constructor() { }

  ngOnInit() {
  }

}
