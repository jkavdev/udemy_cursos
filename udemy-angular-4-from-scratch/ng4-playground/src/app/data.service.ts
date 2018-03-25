import { Injectable } from '@angular/core';

@Injectable()
export class DataService {

  cars = [
    'Ford', 'Chevrolet', 'Fiat'
  ]

  constructor() { }

  myCars() {
    return this.cars;
  }

}
