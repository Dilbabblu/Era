import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-exception-job-monitor',
  templateUrl: './exception-job-monitor.component.html',
})
export class ExceptionJobMonitorComponent implements OnInit {

  rmanJobMonitorDetails:any[]=[
    {runName:'AAAAAAAAAA',pid:1,startDate:new Date(),endDate:new Date(),status:'Running'},
    {runName:'BBBBBBBBBB',pid:2,startDate:new Date('09/15/2019'),endDate:new Date('09/16/2019'),status:'Completed'},
    {runName:'CCCCCCCCCCCC',pid:3,startDate:new Date('09/17/2019'),endDate:new Date('09/18/2019'),status:'Completed'},
    {runName:'DDDDDDDDDDDDDDDDD',pid:4,startDate:new Date('10/23/2019'),endDate:new Date('10/29/2019'),status:'Running'},
    {runName:'EEEEEEEEEE',pid:5,startDate:new Date('11/22/2019'),endDate:new Date('11/25/2019'),status:'Completed'},
  ];
  collapsed: boolean = true;
  constructor() { }

  ngOnInit() {
  }
  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
}

}
