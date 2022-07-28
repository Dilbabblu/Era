import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'datex'
})

export class DateTimePipe implements PipeTransform {
    transform(value: string, type: string = ""): string {
        var d = new Date(value);

        var dy = d.getDate();
        var m = d.getMonth() + 1;
        var y = d.getFullYear();
        let date_str = (dy <= 9 ? '0' + dy : dy) + '/' + (m <= 9 ? '0' + m : m) + "/" + y;

        let time = '';

        var hh = d.getHours();
        var mm = d.getMinutes();
        var ss = d.getSeconds();
        var hh1 = (hh <= 9 ? '0' + hh : hh);
        var mm1 = (mm <= 9 ? '0' + mm : mm);
        var ss1 = (ss <= 9 ? '0' + ss : ss);
        time = `${hh1}:${mm1}:${ss1}`;

        if (value != null) {
            return `${date_str} ${time}`;
        }
        else
            return '';
    }
}