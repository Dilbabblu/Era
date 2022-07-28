import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { ChartComponent } from 'smart-webcomponents-angular/chart';
import { DrillDownService } from '../../services/drill-down.service';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label } from 'ng2-charts';
import { CommonSharedService } from '../../../../shared/common.service';

@Component({
  selector: 'data-chart',
  templateUrl: './chart.component.html',
  providers: [CommonSharedService],
})
export class DataChartComponent implements OnInit {
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
  isDrillDown = null;
  month:any = "month";
  quarter:any = "quarter";
  year:any = "year";
  ShowHideChart:boolean = true;

  values: any = [];
  legends: any = [];
  
  public barChartLabels: Label[] = [];
  public barChartData: ChartDataSets[] = [];
  public barChartOptions: ChartOptions = {
    responsive: true,
    legend:{
      position: 'bottom',
    }
  };
  //public barChartLabels: Label[] = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
  public barChartType: ChartType = 'bar';
  public barChartLegend = true;
  public barChartPlugins = [];

  public chartReady: boolean = false;
  clicksCount: number = 0;
  reachedYear: boolean = false;
 

  constructor(private drillDownService: DrillDownService, private commonSharedService: CommonSharedService) {
  }
  ngOnInit() {
    //this.columnData = this.pivottable.columnData;
    //window.addEventListener('scroll', this.scroll, true);
    this.getChartData();
  }
  
  

  onBarClick(event: any) {
   // console.log("active length"+event.active.length);
    if(event.active.length >0){
   // this.clicksCount++;
    //console.log(this.clicksCount);
   /* if(event.detail !=undefined && event.detail.event){
      this.isDrillDown = true;
      this.getChartData();
    }else if(event.detail !=undefined && !event.detail.event){
      if(event.path.length == 13 || event.path.length == 25){
        this.isDrillDown = false;
        this.getChartData();
      }
    }else */
    
    if(event.detail == undefined ){
      if(this.columnData.rowGroup[0] == this.year){
        this.isDrillDown = true;
       // this.reachedYear = true;
        localStorage.setItem('reachedYear', 'true');
        this.getChartData();
      }else if(this.columnData.rowGroup[0] == this.quarter){
        if(localStorage.getItem('reachedYear') == 'true'){
          this.isDrillDown = true;
          localStorage.setItem('reachedYear', 'false');
        }else{
          this.isDrillDown = false;
        }
        this.getChartData();
      }else{    
        this.isDrillDown = false;
        this.getChartData();
      }
      
    }
  }
  }

  type = '';
  orientation = '';
  flipChart = false;
  showLegend = true;
  caption = "";
  description = "";
  padding = { left: 10, top: 5, right: 25, bottom: 0 };
  titlePadding = { left: 90, top: 0, right: 0, bottom: 10 };
  dataSource = this.chartData;
  colorScheme = 'scheme29';
  animationDuration = 400;
  //columnSeriesOverlap: false;
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
    unitInterval: 10,
    minValue: 0,
    maxValue: 10000000000,
    visible: true,
    axisSize: 'auto',
    flip: false,
    textRotationAngle: 0,
    tickMarks: { color: '#888888' },
    gridLines: { color: '#888888' },
    formatSettings: { decimalPlaces: 0 },
    //labels: { horizontalAlignment: 'right' },
  };
  seriesGroups = [];

   

  getChartData() {
    this.legends =[];
    this.barChartData = [];
    this.title ? this.caption = this.title.dataset.value : this.caption = "";
    this.desc ? this.desc = this.desc.dataset.value : this.desc = "";

    if (this.routeUrl == "/" || this.routeUrl == "/dashboard") {
      this.chartdynamicWidth = '385px';
      this.chartDynamicHeight = '350px';
      this.leftPadding = '-15px';
    } else {
      this.chartdynamicWidth = '1350px';
      this.chartDynamicHeight = '500px';
    }

    let dataGroup = [];
    if (this.columnData.rowGroup) {
      //console.log(this.columnData.rowGroup[0]);
      if(this.isDrillDown){
        if(this.columnData.rowGroup[0] == this.year){
          this.columnData.rowGroup[0] = this.quarter;
        }else if(this.columnData.rowGroup[0] == this.quarter){
          this.columnData.rowGroup[0] = this.month;
        }
      }else if(this.isDrillDown === false){
        if(this.columnData.rowGroup[0] == this.month){
          this.columnData.rowGroup[0] = this.quarter;
        }else if(this.columnData.rowGroup[0] == this.quarter){
          this.columnData.rowGroup[0] = this.year;
        }
      }
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
          columnGroup = this.columnData.pivot;
        } else {
          columnGroup = this.columnData.rowGroup;
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
    let max = 0, min = 0;
    let dataSource = [];

    let columns = [];
    //let pivotsRestriction = [];

    if (this.routeUrl == "/" || this.routeUrl == "/dashboard") {
      let rowGroupCount: number = 0;
      let pivotsCount: number = 0;
      let summariesCount: number = 0;
      for (let timeField in data) {
        let rowLength = 3;
        if (lastChildTimeUnit == "customer") {
          rowLength = 4;
        }
        if (rowGroupCount <= rowLength) {
          let obj = {};
          obj[lastChildTimeUnit] = timeField;
          summariesCount = 0;
          for (let summary in data[timeField]) {
            if (summariesCount == 0) {
              pivotsCount = 0;
              for (let column in data[timeField][summary]) {
                //if (pivotsRestriction.includes(column)) {
                  if (pivotsCount <= 1) {
                    let value = data[timeField][summary][column];
                    obj[summary + column] = value;
                    // if (!max && value > max) {
                    //   max = value;
                    // }
                    // if (!min || value < min) {
                    //   min = value;
                    // }
                    if (value > max) {
                      max = value;
                    }
                    if (!columns[summary]) columns[summary] = {};
                    columns[summary][column] = '';
                  }
                  pivotsCount++;

              }
            }
            summariesCount++;
          }
          dataSource.push(obj);
        }
        rowGroupCount++;
      }
    } else {
      for (let timeField in data) {
        let obj = {};
        obj[lastChildTimeUnit] = timeField;
        for (let summary in data[timeField]) {
          for (let column in data[timeField][summary]) {
            let value = data[timeField][summary][column];
            obj[summary + column] = value;
            // if (!max && value > max) {
            //   max = value;
            // }
            // if (!min || value < min) {
            //   min = value;
            // }
            if (value > max) {
              max = value;
            }
            if (!columns[summary]) columns[summary] = {};
            columns[summary][column] = '';
          }
        }
        dataSource.push(obj);
      }
    }

    if (this.routeUrl != "/" && this.routeUrl != "/dashboard") {
      if (lastChildTimeUnit == "customer") {
        if (dataSource) {
          let dataSize = dataSource.length;
          //console.log(dataSize);
          if (dataSize > 10) {
            var chartHeight = dataSize * 30;
            //console.log(chartHeight);
            if (chartHeight > 500) {
              this.chartDynamicHeight = chartHeight + 'px';
            }
          }
        }
      }
    }
    for (let key in columns) {
      if (lastChildTimeUnit == "customer") {
        //this.type = "column";
        this.orientation = "horizontal";
      } else {
        //this.type = "stackedcolumn";
      }
      let labels: boolean = false;
      if (!this.columnData.pivot) {
        labels = false;
      }
      let chartColumns = {
        type: "stackedcolumn",
        orientation: this.orientation,
        columnsMinWidth: 15,
        columnsMaxWidth: 15,
        columnsGapPercent: 50,
        seriesGapPercent: 1000,
        //skipOverlappingPoints: true,
        series: [],
        showLabels: labels,
        // toolTipFormatFunction: function (value: any, itemIndex: number, series: any) {
        //   //console.log(dataSource[itemIndex]);
        //   var test = series.displayField;
        //   return dataSource[itemIndex].test;
        // },
      };

      

      for (let column in columns[key]) {
        let labels;
        let formartFunction;
        if (!this.columnData.pivot) {
          if (lastChildTimeUnit == "customer") {
            labels = {
              visible: true,
              horizontalAlignment: 'right',
              offset: { x: 50, y: 0 },
              //formatSettings: { decimalPlaces: 0 },
              //fill:'#E25848'
            }
          } else {
            labels = {
              visible: true,
              verticalAlignment: 'top',
              offset: { x: 0, y: -20 },
              //formatSettings: { decimalPlaces: 0 }
            }
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
            //console.log((value / Math.pow(1000, exp)).toFixed(2) + suffixes[exp - 1]);
            return (value / Math.pow(1000, exp)).toFixed(2) + suffixes[exp - 1];
          }
        }
        chartColumns.series.push({
          dataField: key + column,
          displayText: (column != 'undefined' ? column : '') + ' ' + key,
          labels: labels,
          formatFunction: formartFunction,
          //   colorFunction: function (value: number, itemIndex: any, serie: any, group: any) {
          //     return (value < 0) ? '#E25848' : '#61D14F';
          // }
        });

        this.legends.push(key+column);
       
        
        //console.log("key: "+ key);
        //console.log("column: "+ column);
        //console.log("labels: "+ labels);
        //console.log("formartFunction: "+ formartFunction.value);
        
       // console.log("columns: "+columns);
        //console.log("columns[key]: "+columns[key]);
        
      }
      //console.log(this.legends);
      this.seriesGroups.push(chartColumns);
    
    }
    this.xAxis.dataField = lastChildTimeUnit;
    this.dataSource = dataSource;
    this.valueAxis.minValue = min;
    this.valueAxis.maxValue = max;
    this.valueAxis.axisSize = "auto";
    if (lastChildTimeUnit == "customer") {
      this.valueAxis.flip = true;
      this.xAxis.textRotationAngle = 90;
      this.valueAxis.textRotationAngle = -75;
    } else {
      this.valueAxis.flip = false;
    }
    //this.valueAxis.unitInterval = (max - min) / 100;

    let interval = Math.ceil(max) / 10;
    let unit = interval + interval / 2; 
    this.valueAxis.unitInterval = (Math.ceil(max + unit)) / 10;

    if(this.isDrillDown || this.isDrillDown === false){
      this.drillDownService.showChart = false;
      setTimeout(() => {
        this.drillDownService.showChart = true;
        //this.drillDownService.verticalBarChart = true;
      }, 0);
    }
    //console.log(dataSource);
    let labels: any = [];
    

    let chartKey: string = lastChildTimeUnit;
    for (let i = 0; i < this.dataSource.length; i++) {
     labels.push(this.dataSource[i][chartKey]);
    // values.push(this.dataSource[i][chartValue]);
    }
    this.barChartLabels = labels;
   // console.log(labels);

    /*let keyPosition = 0;
    let object = {};
    let size = this.legends.length; //3
   
    for(let i=0; i < this.dataSource.length; i++){ //4
      while(size!=0 && keyPosition<size){
        this.values.push(dataSource[i][this.legends[keyPosition]]);
      }
      object[keyPosition]={data: this.values, label: this.legends[keyPosition]}
      keyPosition++;
      
    }*/

let object = {};

for(let i=0; i<this.legends.length; i++){
this.values=[];
let count =0
	while(count<dataSource.length){
		let val = (dataSource[count][this.legends[i]] !=undefined)? dataSource[count][this.legends[i]] : 0;
		this.values.push(val); 
		count++;
	}
	object[i] = {data: this.values, label: this.legends[i]};
	this.barChartData.push(object[i]);
}
this.chartReady = true;

    //console.log(object);

    
    //this.doughnutChartLabels = labels;
    //this.doughnutChartData = values;
    
    //console.log(values);
   // console.log(this.doughnutChartLabels);
   // console.log(this.doughnutChartData);

  }



}

