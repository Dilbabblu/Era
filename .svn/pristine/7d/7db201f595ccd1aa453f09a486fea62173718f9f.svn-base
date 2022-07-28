import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { ChartComponent } from 'smart-webcomponents-angular/chart';
import { DrillDownService } from '../../services/drill-down.service';
import { CommonSharedService } from '../../../../shared/common.service';
import { ChartOptions } from 'chart.js';


@Component({
  selector: 'pie-data-chart',
  templateUrl: './pieChart.component.html',
  providers: [CommonSharedService],
})
export class PieDataChartComponent implements OnInit {
  @ViewChild('chart', { read: ChartComponent, static: false } as any)
  chart: ChartComponent;
  @Input() columnData;
  @Input() title;
  @Input() desc;
  @Input() routeUrl: string;
  @Input() reportId;
  chartData = [];
  chartdynamicWidth: any;
  chartDynamicHeight: any
  leftPadding: any;
  currentUrl = "";

  labelRadius;
  initialAngle;
  radius;
  centerOffset;

  public doughnutChartLabels: any[]; 
  public doughnutChartData: any[];
  public doughnutChartType: string = 'doughnut';
  public chartReady: boolean = false;
  public doughnutChartOptions: ChartOptions = {
    responsive: true,
    legend:{
      position: 'bottom',
    }
  };
 

  constructor(private drillDownService: DrillDownService, private commonSharedService: CommonSharedService) { }
  ngOnInit() {
    this.getChartData();
  }
  formartFunction = function (value: any) {
    var exp, rounded,
      suffixes = ['K', 'M', 'G', 'T', 'P', 'E'];
    if (Number.isNaN(value)) {
      return null;
    }
    if (value == 0) return 0;
    if (value < 1000) {
      return Math.floor(value).toFixed(2);
    }
    exp = Math.floor(Math.log(value) / Math.log(1000));
    return (value / Math.pow(1000, exp)).toFixed(2) + suffixes[exp - 1];
  }
  type = '';
  orientation = '';
  flipChart = false;
  showLegend = true;
  caption = "";
  description = "";
  //legendLayout = { left: 1000, top: 160, width: 300, height: 200, flow: 'vertical' };
  legendPosition = { left: 520, top: 140, width: 100, height: 100 };
  padding = { left: 5, top: 5, right: 5, bottom: 0 };
  titlePadding = { left: 90, top: 0, right: 0, bottom: 10 };
  dataSource = this.chartData;
  colorScheme = 'scheme29';
  //columnSeriesOverlap: true;
  xAxis = {
    dataField: '',
    unitInterval: 1,
    textRotationAngle: 0,
    valuesOnTicks: true,
    tickMarks: {
      visible: true,
      unitInterval: 1,
      color: '#888888',
    },
    gridLines: {
      visible: false,
      unitInterval: 1,
      color: '#888888',
    },
  };
  valueAxis = {
    unitInterval: 1,
    minValue: 0,
    maxValue: 0,
    visible: true,
    axisSize: 'auto',
    flip: false,
    textRotationAngle: 0,
    tickMarks: { color: '#888888' },
    gridLines: { color: '#888888' },
    formatSettings: { decimalPlaces: 0 }
  };
  seriesGroups = [];

  getChartData() {

    

    this.title ? this.caption = this.title.dataset.value : this.caption = "";
    this.desc ? this.description = this.desc.dataset.value : this.description = "";

    if (this.routeUrl == "/" || this.routeUrl == "/dashboard") {
      this.chartdynamicWidth = '350px';
      this.chartDynamicHeight = '350px';
      //this.leftPadding = '-15px';
      this.labelRadius = 110;
      this.initialAngle = 15;
      this.radius = 100;
      this.centerOffset = 0;
    } else {
      this.chartdynamicWidth = '1350px';
      this.chartDynamicHeight = '500px';
      this.labelRadius = 200;
      this.initialAngle = 15;
      this.radius = 170;
      this.centerOffset = 0;
    }

    let dataGroup = [];
    if (this.columnData.rowGroup) {
      dataGroup.push(...this.columnData.rowGroup);
    }
    if (this.columnData.pivot) {
      dataGroup.push(...this.columnData.pivot);
    }
    let timeUnit = ['year', 'quarter', 'month', "customer"];
    let lastChildTimeUnit = null;
    let columnGroup = [];
    for (let i = 0; i < dataGroup.length; i++) {
      if (timeUnit.indexOf(dataGroup[i]) != -1) {
        lastChildTimeUnit = dataGroup[i];
        if (this.columnData.rowGroup || i < this.columnData.rowGroup.length - 1) {
          //console.log("column data row group: "+this.columnData.rowGroup);
          //columnGroup = this.columnData.pivot;
        } else {
          columnGroup = this.columnData.rowGroup;
          //console.log("columnGroup: "+columnGroup);
        }
        break;
      }
    }
    let data = {};
    if(this.routeUrl == "/" || this.routeUrl == "/dashboard"){
      if(this.drillDownService.reportsArrangementData.length > 0){
        let reportData =  this.drillDownService.reportsArrangementData.filter(d => d.id === this.reportId);
        if(reportData[0].data == undefined){
          this.drillDownService.arrangementsData = [];
        }else{
          this.drillDownService.arrangementsData = reportData[0].data;
        }
      }
    }
    this.drillDownService.arrangementsData.forEach((item) => {
      if (!data[item[lastChildTimeUnit]]) {
        data[item[lastChildTimeUnit]] = {};
      }
      let timeUnitData = data[item[lastChildTimeUnit]];
      for (let summary of this.columnData.summary) {
        if (!timeUnitData[summary.label]) timeUnitData[summary.label] = {};
        let summaryData = timeUnitData[summary.label];
        if (!columnGroup || !columnGroup.length) columnGroup = ['All'];
        for (let column of columnGroup) {
          let columnField = item[column];
          if (!summaryData[columnField]) {
            summaryData[columnField] = 0;
          }
          summaryData[columnField] += item[summary.name];
        }
      }
    });
    //let max, min;
    let dataSource = [];

    //let columns = [];
    

    let labels: any = [];
    let values: any = [];

    let chartValue: string;

    for (let timeField in data) {
      let obj = {};
      obj[lastChildTimeUnit] = timeField;
      for (let summary in data[timeField]) {
        for (let column in data[timeField][summary]) {
          let value = data[timeField][summary][column];
          let key = "'" + summary + "'";
          obj[key] = value;
          chartValue = key; //used for fetching donut chart values
         /* if (!max && value > max) {
            max = value;
          }
          if (!min || value < min) {
            min = value;
          }*/
         // if (!columns[summary]) columns[summary] = {};
        //  columns[summary][column] = '';
        }
      }
      dataSource.push(obj);
      //console.log(obj);
    }
    if (lastChildTimeUnit == "customer") {
      if (dataSource.length > 10) {
        dataSource.splice(10, (dataSource.length - 1) - 10);
      }
    }
    //console.log("lastChildTimeUnit: "+lastChildTimeUnit);
    //let dataField;
   // let count: number = 0;
    /*for (let key in columns) {
      this.type = "pie";
      let chartColumns = {
        type: this.type,
        orientation: this.orientation,
        series: [],
        showLabels: true,
      };

      for (let column in columns[key]) {
        if (count == 0) {
          dataField = key;
          chartColumns.series.push({
            dataField: "'" + dataField + "'",
            displayText: lastChildTimeUnit,
            labelRadius: this.labelRadius,
            initialAngle: this.initialAngle,
            radius: this.radius,
            centerOffset: this.centerOffset,
          });
        }
        count++;
      }
      this.seriesGroups.push(chartColumns);
    }*/
    //this.xAxis.dataField = lastChildTimeUnit;
    this.dataSource = dataSource;
   // this.valueAxis.minValue = min;
   // this.valueAxis.maxValue = max;
   // this.valueAxis.axisSize = "auto";
    //this.valueAxis.unitInterval = (max - min) / 100;
    //console.log(this.dataSource);
    let chartKey: string = lastChildTimeUnit;
    for (let i = 0; i < this.dataSource.length; i++) {
     labels.push(this.dataSource[i][chartKey]);
     values.push(this.dataSource[i][chartValue]);
    }
    this.doughnutChartLabels = labels;
    this.doughnutChartData = values;
    //console.log(labels);
    //console.log(values);
    //console.log(this.doughnutChartLabels);
    //console.log(this.doughnutChartData);
    this.chartReady = true;
  }

}
