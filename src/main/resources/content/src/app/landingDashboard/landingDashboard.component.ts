import { Component, OnInit, ViewChild } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { DataChartComponent } from '../reports/analyticalReports/report/chart/chart.component';
import { DrillDownService } from '../reports/analyticalReports/services/drill-down.service';
import { RmanFiscalPeriodsService } from '../rmanFiscalPeriods/rmanFiscalPeriodsservice';
import { NotificationService } from '../shared/notifications.service';
import { LandingDashboardService } from './landingDashboard.service';
declare var require: any;
const appSettings = require('../appsettings');

@Component({
  selector: 'app-landing-dashboard',
  templateUrl: './landingDashboard.component.html',
  //styleUrls: ['./../../assets/css/bootstrap.min.css'],
})
export class LandingDashboardComponent implements OnInit {

  paginationOptions: any;
  addReports = false;
  showChart: boolean = false;
  

  @ViewChild('dataChart', {
    read: DataChartComponent,
    static: false,
  } as any)
  dataChart: DataChartComponent;

  currentUrl = "";
  reportsList: any[] = [];
  checkedReportsList: any[] = [];
  showLoading = false;
  saveLoading = false;
  noReports = false;

  rmanFYears: any[];
  rmanFYList: any[] = [];
  currentFY: any;

  rmanPeriods: any[];
  rmanQuarters: any[];
  rmanPeriod: any;
  rmanQuarter: any;

  rmanPeriodDimensions: any[];
  rmanPeriodDimensionsList: any[] = [];
  currentPeriodDimension: any;

  overviewDataLoading = false;
  noOverviewData = false;

  overviewFigures: any[];

  constructor(public drillDownService: DrillDownService, private router: Router,
    private landingDashboardService: LandingDashboardService, private rmanFiscalPeriodsService: RmanFiscalPeriodsService,
    private notificationService: NotificationService) {
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.currentUrl = event.url;
      }
    });

    this.overviewDataLoading = true;
    this.rmanFiscalPeriodsService.getFinancialYears().then((fYears: any) => {
      this.rmanFYList = fYears;
      let rmanFYTemp: any = [{ label: appSettings.dropDownOptions.selectYear, value: null }];
      for (let q = 0; q < this.rmanFYList.length; q++) {
        rmanFYTemp.push({ label: this.rmanFYList[q], value: this.rmanFYList[q] });
      }
      this.rmanFYears = rmanFYTemp;
    });

    this.rmanFiscalPeriodsService.getPeriodDimensions().then((pDimensions: any) => {
      this.rmanPeriodDimensionsList = pDimensions;
      this.currentPeriodDimension = this.rmanPeriodDimensionsList[0];
      let rmanPeriodDimensionsTemp: any = [{ label: appSettings.dropDownOptions.selectPeriod, value: null }];
      for (let q = 0; q < this.rmanPeriodDimensionsList.length; q++) {
        rmanPeriodDimensionsTemp.push({ label: this.rmanPeriodDimensionsList[q], value: this.rmanPeriodDimensionsList[q] });
      }
      this.rmanPeriodDimensions = rmanPeriodDimensionsTemp;

      this.loadArrangementData();
    });

    this.showLoading = true;
    this.drillDownService.getReports(this.paginationOptions,false).then((reports) => {
      this.reportsList = reports.content;
      if (this.reportsList.length == 0) {
        this.noReports = true;
      }
      this.showLoading = false;
      for (let report of this.reportsList) {
        this.checkedReportsList.push(report);

        this.drillDownService.getReport(report.id).then((data1) => {
          this.showLoading = false;
          let data = JSON.parse(data1.clob);
          data.id = data1.id;

          report.columnData = data.columnData;
          report.datetimepickerfrom = new Date(data.dateRange.endDate);
          report.datetimepickerto = new Date(data.dateRange.startDate);
          report.reportName = data.reportName;
          report.switchChart = false;
          report.showChart = true;
          this.drillDownService.showChart = true;

          let dateRange = {
            startDate: report.datetimepickerto,
            endDate: report.datetimepickerfrom,
          };
          report.showLoading = true;
          this.drillDownService.getArrangementData(dateRange,data.id).then((response) => {
            report.showLoading = false;
          })

        });
      }
    });
  }

  loadArrangementData() {
    this.landingDashboardService.getOverviewFigures(this.currentFY, this.currentPeriodDimension, this.rmanPeriod, this.rmanQuarter).then((response) => {
      if (response == null) {
        this.overviewDataLoading = false;
        this.noOverviewData = true;
        this.notificationService.showError("Failed to load Overview Data");
      } else {
        this.overviewFigures = response.Content;
        this.overviewDataLoading = false;
      }

    });
  }

  ngOnInit() {

  }

  onAddingReports(ev: any) {
    this.addReports = !this.addReports;
  }
  closeAddReports(ev: any) {
    this.addReports = false;
  }

  onReportChange(report) {
    if (report.showOnDashbaord == 'Y') {
      report.showOnDashbaord = 'N'
      this.checkedReportsList.splice(this.checkedReportsList.indexOf(report), 1);
    } else {
      report.showOnDashbaord = 'Y';
      this.checkedReportsList.push(report);
    }
  }

  saveDashboardReports() {
    this.saveLoading = true;
    this.landingDashboardService.saveDashboardReportsLayout(this.reportsList).then((reports) => {
      this.saveLoading = false;
      this.notificationService.showSuccess('Reports Updated Successfully');
    }).catch((err: any) => {
      this.saveLoading = false;
      this.notificationService.showError('Error occured while updating Data');
    });

  }

  transformValues(value: any) {
    return value != null ? Math.round(value) : 0;
  }

  onSelectChange() {
    if (this.currentFY != null) {
      this.preparePeriods(this.currentFY);
      this.prepareQuarters(this.currentFY);
      this.rmanPeriod = null;
      this.rmanQuarter = null;
      this.overviewDataLoading = false;
      this.loadArrangementData();
    } else if (this.currentPeriodDimension != null) {
      this.rmanPeriod = null;
      this.rmanQuarter = null;
      this.overviewDataLoading = false;
      this.loadArrangementData();
    }
  }
  onDimensionChange() {
    this.rmanPeriod = null;
    this.rmanQuarter = null;
    this.onPeriodsChange();
  }
  onPeriodsChange() {
    this.overviewDataLoading = false;
    this.loadArrangementData();
  }

  prepareQuarters(year) {
    if (year != null) {
      let quarters: any = [{ label: appSettings.dropDownOptions.selectQuarterName, value: null }];
      for (var i = 0; i < 4; i++) {
        quarters.push({
          label:
            i == 0 ? 'Q1-' + year :
              i == 1 ? 'Q2-' + year :
                i == 2 ? 'Q3-' + year :
                  i == 3 ? 'Q4-' + year : ''
          , value:
            i == 0 ? 'Q1-' + year :
              i == 1 ? 'Q2-' + year :
                i == 2 ? 'Q3-' + year :
                  i == 3 ? 'Q4-' + year : ''
        });
      }
      this.rmanQuarters = quarters;
    }
  }

  preparePeriods(year) {
    if (year != null) {
      var year1 = year.toString().substr(2, 4);
      let periods: any = [{ label: appSettings.dropDownOptions.selectedPeriodName, value: null }];
      for (var i = 0; i < 12; i++) {
        periods.push({
          label:
            i == 0 ? 'Jan-' + year1 :
              i == 1 ? 'Feb-' + year1 :
                i == 2 ? 'Mar-' + year1 :
                  i == 3 ? 'Apr-' + year1 :
                    i == 4 ? 'May-' + year1 :
                      i == 5 ? 'Jun-' + year1 :
                        i == 6 ? 'Jul-' + year1 :
                          i == 7 ? 'Aug-' + year1 :
                            i == 8 ? 'Sep-' + year1 :
                              i == 9 ? 'Oct-' + year1 :
                                i == 10 ? 'Nov-' + year1 :
                                  i == 11 ? 'Dec-' + year1 : ''
          , value:
            i == 0 ? 'Jan-' + year1 :
              i == 1 ? 'Feb-' + year1 :
                i == 2 ? 'Mar-' + year1 :
                  i == 3 ? 'Apr-' + year1 :
                    i == 4 ? 'May-' + year1 :
                      i == 5 ? 'Jun-' + year1 :
                        i == 6 ? 'Jul-' + year1 :
                          i == 7 ? 'Aug-' + year1 :
                            i == 8 ? 'Sep-' + year1 :
                              i == 9 ? 'Oct-' + year1 :
                                i == 10 ? 'Nov-' + year1 :
                                  i == 11 ? 'Dec-' + year1 : ''
        });
      }
      this.rmanPeriods = periods;
    }
  }
}
