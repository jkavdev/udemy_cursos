import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-css-inline-component',
  template: `
  
    <h1>Vamos que ta funcionando</h1>

  `
  ,
  styles: [`
  
  h1 {
    text-decoration: underline;
    color: brown;
  }

  `]
})
export class CssInlineComponentComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
