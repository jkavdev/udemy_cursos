import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-event-component',
  template: `

  <button (click)="buttonEvent($event)">Vamos</button>
  <button (mouseenter)="enterEvent($event)">Vamos</button>

  `,
  styleUrls: ['./event-component.component.css']
})
export class EventComponentComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  buttonEvent(event) {
    console.log('vamos que ta funcionando porra...........')
    console.log(event)
  }
  enterEvent(event) {
    alert('Mouse porra ,kkk')
    alert(event)
  }

}
