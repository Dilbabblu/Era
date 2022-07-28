import { DecimalPipe } from '@angular/common';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'round' })
export class RoundPipe implements PipeTransform {
  transform(value: any, precision?: any): any {
    if (!precision) {
      precision = 2;
    }
    if (!value) {
      value = 0;
    }
    var x = new DecimalPipe('en-US');
    var y = '1'.concat('.').concat(precision).concat('-').concat(precision);
    return x.transform(this.roundNumber(value, precision), y);
  }
  roundNumber(number: any, precision: any) {
    precision = Math.abs(parseInt(precision)) || 0;
    var multiplier = Math.pow(10, precision);
    return (Math.round(number * multiplier) / multiplier);
  }

}
