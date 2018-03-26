import { Component, OnInit, trigger, state, style, transition, animate, keyframes } from '@angular/core';

@Component({
  selector: 'app-animation-component',
  template: `
  
    <p [@locaAnimacao]='state' (click)="meAnime()">Anime-se</p>
    <p [@locaAnimacaoFrames]='state' (click)="meAnime()">Anime-se</p>
  
  `,
  styles: [`
  
    p {
      width: 200px;
      background: lightgray;
      margin: 100px auto;
      text-align: center;
      padding:200px;
      font-size: 1.5em;
    }
  
  `],
  animations: [
    trigger('locaAnimacao', [
      state('small', style({
        transform: 'scale(1)',
      })),
      state('large', style({
        transform: 'scale(1.2)',
      })),

      transition('small => large', animate('300ms ease-in', style({
        transform: 'translateY(40px)'
      }))),
    ]),
    trigger('locaAnimacaoFrames', [
      state('small', style({
        transform: 'scale(1)',
      })),
      state('large', style({
        transform: 'scale(1.2)',
      })),

      transition('small => large', animate('300ms ease-in', keyframes([
        style({ opacity: 0, transform: 'translateY(-75%)', offset: 0 }),
        style({ opacity: 1, transform: 'translateY(35%)', offset: .5 }),
        style({ opacity: 1, transform: 'translateY(0)', offset: 1 })
      ]))),
    ]),
  ]
})
export class AnimationComponentComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  state: string = "small";

  meAnime() {
    this.state = (this.state === 'small' ? 'large' : 'small');
  }

}
