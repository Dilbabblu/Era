import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-exceptions',
  templateUrl: './exceptions.component.html',
})
export class ExceptionsComponent implements OnInit {

  exceptionType: string;
  orderType: string = '';
  tabHeader: string = '';
  constructor(private route: ActivatedRoute) {
    this.route.params.subscribe((params: any) => {
      this.exceptionType = params['exceptionType'];
      this.orderType = this.exceptionType === 'bookings' ? 'B' : (this.exceptionType === 'shipments' ? 'S' : '');
      this.tabHeader = this.exceptionType.charAt(0).toUpperCase() + this.exceptionType.slice(1);
    });
  }

  ngOnInit() {

  }
  handleChange(event: any) {

  }

}
