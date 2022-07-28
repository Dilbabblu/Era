import { AfterViewInit, Component, Input, OnInit, ViewChild } from '@angular/core';
import { PivotTableComponent } from 'smart-webcomponents-angular/pivottable';
import { DrillDownService } from '../../services/drill-down.service';

@Component({
  selector: 'data-table',
  templateUrl: './data-table.component.html',
  styleUrls: ['./data-table.component.css'],
})
export class DataTableComponent implements OnInit,AfterViewInit {
  @ViewChild('pivottable', { read: PivotTableComponent, static: false }as any)
  pivottable: PivotTableComponent;
  @Input() columnData;

  
  rowSummary = false;
  grandTotals = true;
  rowTotals = false;
  freezeHeader = true;
  keyboardNavigation = true;
  toolbar = true;
  columnTotals = false;
  drillDown = true;
  filters = {};
  dataSource = null;
  arrangements = null;
  data = [];
  conditionalFormatting = [];
  designer:boolean = false;
  getDefaultSummaryFunction = () => 'sum';
  summarySettings = {
    prefix: '$', decimalPlaces: 2 , align:'right', thousandsSeparator:','
  }

 constructor(public drilldownService: DrillDownService) {
   this.arrangements = this.drilldownService.arrangementsData;
   //console.log(this.arrangements);
   //this.dataSource = this.createPivotDataSource(this.arrangements);
 }
onColumnRender(dt){
    if(dt.column.dataField){
      if(dt.column.originalColumn.dataType){
        if(dt.column.originalColumn.dataType == "number"){
         dt.text = dt.column.originalColumn.label;
        }
      }
    }
    return;
  }
  onInit = function () {
    this.expandAllRows();
  };
  toggleDesigner(){
    this.designer = !this.designer;
  }
  formatFunction = (e)=>{
    //e.value = e.value.substr(0,e.value.indexOf('('));
    return;
  }

  createPivotDataSource(data): any {
    return new window.Smart.DataAdapter({
      dataSource: data,
    });
  }

  onChange(ev){
    this.getColumns();
    this.sortArrangementData();
    //this.pivottable.expandAllRows();
  }

  ngOnInit() {
    this.columnData == undefined ? this.designer = true : this.designer = false; 
    if(this.columnData){
      this.sortArrangementData();
    }
    if(this.columnData) {
      let changePosition = (val , index, key) => {
        let data = this.columns[index];
        this.columns.splice(index,1);
        this.columns.unshift(data);
        this.columns[0][key] = val;
      }
      for (let key in this.columnData) {
        if (key == 'summary') {
          this.columnData[key].forEach(element => {
            let index = this.columns.findIndex((item)=> item.dataField == element.name);
            if (index != -1) {
              changePosition(element.fun,index,key);
              this.columns[0]['summarySettings'] =  this.summarySettings;
            }
          });          
        } else {
          this.columnData[key].forEach(element => {
            let index = this.columns.findIndex((item)=> item.dataField == element);
            if (index != -1) {
              changePosition(true,index,key);
            }
          })
        }
      }
      
    } else {
      let index = this.columns.findIndex((item) => item.dataField == 'revenueBeginbalanceQTD')
      this.columns[index]['summary']= 'sum';
      this.columns[index]['summarySettings']= this.summarySettings;
    }
    
  }
  ngAfterViewInit(){
    
  }

  sortArrangementData(){
    this.data = [];
    //console.log(this.columnData);
    this.arrangements.forEach(item => {
      for(let summaryVal of this.columnData.summary){
        if(item[summaryVal.name] != null && item[summaryVal.name] != 0) {
          this.data.push(item);
        }
      }
    });
    if(this.data.length == 0){
      this.dataSource = this.createPivotDataSource(this.arrangements);
    }else{
      this.dataSource = this.createPivotDataSource(this.data);
    }
  }

  getColumns() {
    let columnData = {};
    let groups = ['pivot', 'rowGroup', 'summary'];
    this.pivottable.columns.forEach((item) => {
      for (let key of groups) {
        if (item[key]) {
          if (!columnData[key]) {
            columnData[key] = [];
          }
          if (key == 'summary') {
            columnData[key].push({
              name: item.dataField,
              label: item.label,
              fun: item[key],
              settings: item.summarySettings,
            });
          } else {
            columnData[key].push(item.dataField);
          }
        }
      }
    });
    for (let key in columnData) {
      columnData[key] = columnData[key].reverse();
    }
    this.columnData = columnData;
  }

  columns = [
    {
      label: 'Year',
      dataField: 'year',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: false,
      formatFunction: this.formatFunction,
    },
    {
      label: 'Quarter',
      dataField: 'quarter',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: false,
      formatFunction: this.formatFunction,
    },
    {
      label: 'Month',
      dataField: 'month',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: false,
      formatFunction: this.formatFunction,
    },
    {
      label: 'Quarter Name',
      dataField: 'quarterName',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: false,
      formatFunction: this.formatFunction,

    },
    {
      label: 'Period Name',
      dataField: 'periodName',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: false,
      formatFunction: this.formatFunction,
    },
    {
      label: 'Cust #', 
      dataField: 'cust',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: true,
      formatFunction: this.formatFunction,
    },
    {
      label: 'Customer',
      dataField: 'customer',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: true,
      formatFunction: this.formatFunction,
    },
    {
      label: 'PO#',
      dataField: 'po',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: true,
      formatFunction: this.formatFunction,
    },
    {
      label: 'SO#',
      dataField: 'so',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: true,
      formatFunction: this.formatFunction,
    },
    {
      label: 'Deal #',
      dataField: 'deal',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: true,
      formatFunction: this.formatFunction,
    },
    {
      label: 'Deal line #',
      dataField: 'dealLine',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: true,
      formatFunction: this.formatFunction,
    },
    {
      label: 'BK Qty',
      dataField: 'bkQty',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: true,
      formatFunction: this.formatFunction,
    },
    {
      label: 'Transaction Currency',
      dataField: 'transactionCurrency',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: true,
      formatFunction: this.formatFunction,
    },
    {
      label: 'Arrangement Number',
      dataField: 'arrangementNumber',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: true,
      formatFunction: this.formatFunction,
    },
    {
      label: 'Arrangement Name',
      dataField: 'arrangementName',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: true,
      formatFunction: this.formatFunction,
    },
    {
      label: 'Arrangement Type',
      dataField: 'arrangementType',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: true,
      formatFunction: this.formatFunction,
    },
    {
      label: 'Sales Theater',
      dataField: 'salesTheater',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: true,
      formatFunction: this.formatFunction,
    },
    {
      label: 'Sales Region',
      dataField: 'salesRegion',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: true,
      formatFunction: this.formatFunction,
    },
    {
      label: 'Sales Territory',
      dataField: 'salesTerritory',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: true,
      formatFunction: this.formatFunction,
    },
    {
      label: 'Sales Rep',
      dataField: 'salesRep',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: true,
      formatFunction: this.formatFunction,
    },
    {
      label: 'Product Name',
      dataField: 'productName',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: true,
      formatFunction: this.formatFunction,
    },
    {
      label: 'Product Portfolio',
      dataField: 'productPortfolio',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: true,
      formatFunction: this.formatFunction,
    },
    {
      label: 'Product Family',
      dataField: 'productFamily',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: true,
      formatFunction: this.formatFunction,
    },
    {
      label: 'Product Line',
      dataField: 'productLine',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: true,
      formatFunction: this.formatFunction,
    },
    {
      label: 'Contingency Release Date',
      dataField: 'contigencyReleaseDate',
      dataType: 'string',
      allowRowGroup: true,
      allowPivot: true,
      allowFilter: true,
      formatFunction: this.formatFunction,
    },
    {
      label: 'Allocated Amount (TC)',
      dataField: 'allocatedAmtTC',
      dataType: 'number',
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'Allocated Amount (FC)',
      dataField: 'allocatedAmtFC',
      dataType: 'number',
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'Delivered Amount (TC)',
      dataField: 'devliveredAmtTC',
      dataType: 'number',
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'Billed Amt(TC)',
      dataField: 'billedAmtTC',
      dataType: 'number',
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'Billed Amt(FC)',
      dataField: 'billedAmtFC',
      dataType: 'number',
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'Delivered not billed (DNB)',
      dataField: 'deliveredNotBilledDNB',
      dataType: 'number',
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'Delivered Allocated Price (TC)',
      dataField: 'deliveredAllocatedPriceTC',
      dataType: 'number',
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'Delivered Allocated Price (FC)',
      dataField: 'deliveredAllocatedPriceFC',
      dataType: 'number',
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'Revenue Deferred(TC)',
      dataField: 'revenueDeferredTC',
      dataType: 'number',
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'Revenue Deferred(FC)',
      dataField: 'revenueDeferredFC',
      dataType: 'number',
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'Contract Asset (TC)',
      dataField: 'contractAssetTC',
      dataType: 'number',
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'Contract Liability (TC)',
      dataField: 'contractLiabilityTC',
      dataType: 'number',
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'Deferred Revenue (TC)',
      dataField: 'deferredRevenueTC',
      dataType: 'number',
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'Clearing (TC)',
      dataField: 'clearingTC',
      dataType: 'number',
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'Contract Asset (FC)',
      dataField: 'contractAssetFC',
      dataType: 'number',
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'Contract Liability (FC)',
      dataField: 'contractLiabilityFC',
      dataType: 'number',
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'Deferred Revenue (FC)',
      dataField: 'deferredRevenueFC',
      dataType: 'number',
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'Clearing (FC)',
      dataField: 'clearingFC',
      dataType: 'number',
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'Revenue Begin Balance (TC)',
      dataField: 'revenueBeginBalanceTC',
      dataType: 'number', 
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'Revenue Current Balance (TC)',
      dataField: 'revenueCurrentBalanceTC',
      dataType: 'number',
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'Revenue End Balance (TC)',
      dataField: 'revenueEndBalanceTC',
      dataType: 'number',
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'Revenue Begin Balance (FC)',
      dataField: 'revenueBeginBalanceFC',
      dataType: 'number',
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'Revenue Current Balance (FC)',
      dataField: 'revenueCurrentBalanceFC',
      dataType: 'number',
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'Revenue End Balance (FC)',
      dataField: 'revenueEndBalanceFC',
      dataType: 'number',
      allowFilter: false,
      summarySettings: this.summarySettings,
    },
    {
      label: 'QTD Revenue Begin Balance (TC)',
      dataField: 'revenueBeginbalanceQTD',
      dataType: 'number',
      summarySettings: this.summarySettings,
      allowFilter: false,
      // formatFunction: (data)=>{
      //   data.cell.ondblclick = (e)=>{
      //     let a = data;
      //     //console.log(a);
      //   }
      // }
    },
    {
      label: 'QTD Revenue Current Balance (TC)',
      dataField: 'revenueCurrentBalanceQTD',
      dataType: 'number',
      summarySettings: this.summarySettings,
      allowFilter: false,
    },
    {
      label: 'YTD Revenue Begin Balance (TC)',
      dataField: 'revenueBeginbalanceYTD',
      dataType: 'number',
      summarySettings: this.summarySettings,
      allowFilter: false,
    },
    {
      label: 'YTD Revenue Current Balance (TC)',
      dataField: 'revenueCurrentBalanceYTD',
      dataType: 'number',
      summarySettings: this.summarySettings,
      allowFilter: false,
    },
  ];
}
