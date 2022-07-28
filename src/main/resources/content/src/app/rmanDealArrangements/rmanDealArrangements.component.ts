import { Component, ComponentFactoryResolver, ComponentRef, Input, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Event, NavigationEnd, NavigationStart, Router } from "@angular/router";
import { Subscription } from 'rxjs';
import { ArrangementManagerSharedService } from '../arrangementManager/arrangementManager-shared.service';
import { DealArrangementComponent } from '../dealArrangements/dealArrangement.component';
import { RmanArrangementTotalLevelsService } from '../services/rmanArrangementTotalLevelsservice';
import { RmanArrgLineOfBusinessVService } from '../services/rmanArrgLineOfBusinessVservice';
import { RmanArrgTotalsDateBasedVService } from '../services/rmanArrgTotalsDateBasedVservice';
import { AdCmDirective } from '../shared/ad-cm.directive';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanDealArrangements } from './rmanDealArrangements';
import { RmanDealArrangementsLabels } from './rmanDealArrangementsLabels';
import { RmanDealArrangementsService } from './rmanDealArrangementsservice';

declare var $: any;

@Component({
  templateUrl: './rmanDealArrangements.component.html',
  selector: 'rmanDealArrangements-data',
  providers: [RmanDealArrangementsService, RmanArrgTotalsDateBasedVService, RmanArrgLineOfBusinessVService, RmanArrangementTotalLevelsService, CommonSharedService],
  entryComponents: [DealArrangementComponent]
})

export class RmanDealArrangementsComponent implements OnInit, OnDestroy {

  edialog: boolean = false;

  displayDialog: boolean;

  displayEditDialog: boolean;

  displaySearchDialog: boolean;

  @Input() arrId: any;
  parrangementDealFlag: any;

  arrIdK: any;
  rmanDealArrangements: any = new RmanDealArrangementsImpl();

  rmanDealArrangementsSearch: any = new RmanDealArrangementsImpl();
  rmanDealTotalLevels: any = new RmanArrangementTotalLevelsImpl();
  isSerached: number = 0;

  selectedRmanDealArrangements: any;

  newRmanDealArrangements: boolean;

  rmanDealArrangementsList: any[];
  rmanArrgLineOfBusinessVList: any[];
  rmanArrangementTotalLevelsList: any[];
  rmanArrgTotalsDateBasedVList: any[];

  columns: ILabels;

  columnOptions: any[];

  paginationOptions: any;

  pages: {};

  pageSize: number;
  totalElements: number;

  collapsed: boolean = true;

  analystName: any;
  managerName: any;



  public barChartOptions: any = {
    scaleShowVerticalLines: false,
    responsive: true,
    title: {
      display: true,
      text: 'Waterfall Analysis'
    }
  };
  public doughnutChartOptions: any = {
    scaleShowVerticalLines: false,
    responsive: true,
    title: {
      display: true,
      text: 'Revenue By Line of Business'
    }
  };
  public barChartLabels: any[];//['May-2014','June-2014'] ;//['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
  public barChartType: string = 'bar';
  public barChartLegend: boolean = true;

  public barChartData: any[];

  //dougChart

  public doughnutChartLabels: string[]; //=['Download Sales', 'In-Store Sales', 'Mail-Order Sales'];
  public doughnutChartData: number[] = [350, 450, 100];
  public doughnutChartType: string = 'doughnut';
  @ViewChild(AdCmDirective) adCm: AdCmDirective;
  componentRefference: ComponentRef<any>;
  subscription1: Subscription;
  loading: boolean;
  


  constructor(private sharedService: ArrangementManagerSharedService, private componentFactoryResolver: ComponentFactoryResolver, private rmanDealArrangementsService: RmanDealArrangementsService, private router: Router, private route: ActivatedRoute, private rmanArrgTotalsDateBasedVService: RmanArrgTotalsDateBasedVService, private rmanArrgLineOfBusinessVService: RmanArrgLineOfBusinessVService, private rmanArrangementTotalLevelsService: RmanArrangementTotalLevelsService, private notificationService: NotificationService, private commonSharedService:CommonSharedService) {
    this.router.events.subscribe((event: Event) => {
      if (event instanceof NavigationStart) {
        // Show loading indicator
        this.removeComponent();
      }

      if (event instanceof NavigationEnd) {
        // Hide loading indicator
      }
    })



    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    this.route.params.subscribe(params => {
      this.parrangementDealFlag = params['dealFlag'];
      this.arrIdK = params['id'];
    });

    //  this.cref = ref;
    this.getRmanDealArrangementsById();
    this.barChartLabels = [];
    this.barChartData = [
      { data: [0], label: 'Bookings' },
      { data: [0], label: 'Delivered' },
      { data: [0], label: 'Billed' },
      { data: [0], label: 'Revenue Recognized' },
      { data: [0], label: 'Revenue Deffered' },
      { data: [0], label: 'COGS Recognized' }
    ];
    this.doughnutChartLabels = [];
    this.subscription1 = this.sharedService.getNotifyParent().subscribe((data: any) => {
      this.getNotification(data);
    });
    this.getAllRmanArrgTotalsDateBasedV();
    this.getAllRmanArrgLineOfBusinessV();
    this.getAllRmanArrangementTotalLevels();



  }

  ngOnInit() {
    let rmanDealArrangementsLabels = new RmanDealArrangementsLabels();
    this.columns = rmanDealArrangementsLabels.fieldLabels;
  }


  loadComponent() {

    let componentFactory = this.componentFactoryResolver.resolveComponentFactory(DealArrangementComponent);
    let viewContainerRef = this.adCm.viewContainerRef;
    viewContainerRef.clear();
    this.componentRefference = viewContainerRef.createComponent(componentFactory);
    this.componentRefference.instance.actionDetails = 'EDIT';

  }

  removeComponent() {
    if (this.componentRefference) {
      this.componentRefference.destroy();
    }
    else {
      /* no-code */
    }
  }

  onEdit() {
    this.displayEditDialog = true;
    this.loadComponent();
  }

  onHide(eve) {
    this.removeComponent();
  }

  getNotification(event: any) {
    this.displayEditDialog = event.value;
    this.notificationService.showSuccess('Updated successfully');
    this.getRmanDealArrangementsById();
  }

  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }



  public chartClicked(e: any): void {

  }

  public chartHovered(e: any): void {

  }

  getAllRmanArrangementTotalLevels() {
    this.loading = true;
    this.rmanArrangementTotalLevelsService.getAllRmanArrangementTotalLevels(this.paginationOptions, { 'dealArrangementId': this.arrIdK }).then((rmanArrangementTotalLevelsList: any) => {
      this.rmanArrangementTotalLevelsList = rmanArrangementTotalLevelsList.content;
      if (this.rmanArrangementTotalLevelsList.length == 0) {
        this.rmanDealTotalLevels.arrangementamount = 0;
        this.rmanDealTotalLevels.bookingsamount = 0;
        this.rmanDealTotalLevels.shippedamount = 0;
        this.rmanDealTotalLevels.billedamount = 0;
        this.rmanDealTotalLevels.revrecognizeamount = 0;
        this.rmanDealTotalLevels.revdeffered = 0;
        this.rmanDealTotalLevels.cogsrev = 0;
        this.rmanDealTotalLevels.grossmargin = 0;
      } else {
        this.rmanDealTotalLevels = this.rmanArrangementTotalLevelsList[0];
      }
      this.loading = false;
      this.totalElements = rmanArrangementTotalLevelsList.totalElements;
      this.pageSize = rmanArrangementTotalLevelsList.size;
    });
  }


  getAllRmanArrgTotalsDateBasedV() {
    this.rmanArrgTotalsDateBasedVService.getAllRmanArrgTotalsDateBasedV(this.paginationOptions, { 'dealArrangementId': this.arrIdK }).then((rmanArrgTotalsDateBasedVList: any) => {
      this.rmanArrgTotalsDateBasedVList = rmanArrgTotalsDateBasedVList.content;
      this.totalElements = rmanArrgTotalsDateBasedVList.totalElements;
      this.pageSize = rmanArrgTotalsDateBasedVList.size;
      let barChartlabelVar: any = [];
      let label: any = [];
      for (let i = 0; i < this.rmanArrgTotalsDateBasedVList.length; i++) {
        let barChartlabelVarItem = this.rmanArrgTotalsDateBasedVList[i].month + '-' + this.rmanArrgTotalsDateBasedVList[i].year;
        let labelItem = this.rmanArrgTotalsDateBasedVList[i].type;
        if (!barChartlabelVar.includes(barChartlabelVarItem)) {
          barChartlabelVar.push(barChartlabelVarItem);
        }
        if (!label.includes(labelItem)) {
          label.push(labelItem);
        }
      }
      let clone = JSON.parse(JSON.stringify(this.barChartData));
      let cloneSize = clone.length;
      for (let k = 0; k < cloneSize; k++) {
        let data: any = [];
        let tempData: any = [];
        for (let i = 0; i < this.rmanArrgTotalsDateBasedVList.length; i++) {
          if (this.rmanArrgTotalsDateBasedVList[i].type == clone[k].label) {
            data.push({ monthYear: this.rmanArrgTotalsDateBasedVList[i].month + '-' + this.rmanArrgTotalsDateBasedVList[i].year, amount: this.rmanArrgTotalsDateBasedVList[i].amount });
          }
        }
        barChartlabelVar.forEach(my => {
          let tempRow = data.find(item => item.monthYear == my);
          if (tempRow) {
            tempData.push(tempRow.amount);
          } else {
            tempData.push(0);
          }
        });
        clone[k].data = tempData;
      }
      this.barChartData = clone;
      this.barChartLabels = barChartlabelVar;
    });

  }
  getAllRmanArrgLineOfBusinessV() {
    this.rmanArrgLineOfBusinessVService.getAllRmanArrgLineOfBusinessV(this.paginationOptions, { 'lineOfBusiness': 'ELEMENT', 'dealArrangementId': this.arrIdK }).then((rmanArrgLineOfBusinessVList: any) => {
      this.rmanArrgLineOfBusinessVList = rmanArrgLineOfBusinessVList.content;
      this.totalElements = rmanArrgLineOfBusinessVList.totalElements;
      this.pageSize = rmanArrgLineOfBusinessVList.size;
      let douglabels: any = [];
      let dougdata: any = [];
      for (let i = 0; i < this.rmanArrgLineOfBusinessVList.length; i++) {
        douglabels.push(this.rmanArrgLineOfBusinessVList[i].lineOfBusinessName);
        dougdata.push(this.rmanArrgLineOfBusinessVList[i].amount);
      }
      this.doughnutChartData = dougdata;
      this.doughnutChartLabels = douglabels;
    });
  }



  getAllRmanDealArrangements() {
    this.__getData(this.paginationOptions,this.rmanDealArrangements);
  }

  __getData(paginationOptions:any,dealArrangements:any){
    this.rmanDealArrangementsService.getAllRmanDealArrangements(paginationOptions, dealArrangements).then((rmanDealArrangementsList: any) => {
      this.rmanDealArrangementsList = rmanDealArrangementsList.content;
      this.totalElements = rmanDealArrangementsList.totalElements;
      this.pageSize = rmanDealArrangementsList.size;
    });
  }

  getRmanDealArrangementsById() {
    let pdealArrangementId = this.arrIdK;
    this.rmanDealArrangementsService.getAllRmanDealArrangements(this.paginationOptions, { 'dealArrangementId': pdealArrangementId }).then((rmanDealArrangementsList: any) => {
      this.rmanDealArrangementsList = rmanDealArrangementsList.content;
      this.rmanDealArrangements = this.rmanDealArrangementsList[0];
      if (this.rmanDealArrangements.analystUser != null) {
        this.analystName = this.rmanDealArrangements.analystUser.fullName;
        if (this.rmanDealArrangements.managerUser != null) {
          this.managerName = this.rmanDealArrangements.managerUser.fullName;
        }
      }
    });

  }

  getRmanDealArrangements(event: any) {

    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.__getData(this.paginationOptions,this.rmanDealArrangements);
  }

  showDialogToAdd() {
    this.newRmanDealArrangements = true;
    this.rmanDealArrangements = new RmanDealArrangementsImpl();
    this.displayDialog = true;

  }


  save() {

    if (this.newRmanDealArrangements) {
      this.rmanDealArrangementsService.saveRmanDealArrangements(this.rmanDealArrangements).then((response: any) => {
        this.getAllRmanDealArrangements();
      });
    }
    else {
      this.rmanDealArrangementsService.updateRmanDealArrangements(this.rmanDealArrangements).then((response: any) => {
        this.getAllRmanDealArrangements();
      });

    }
    this.rmanDealArrangements = new RmanDealArrangementsImpl();
    this.displayDialog = false;
  }


  delete(rmanDealArrangements: any) {
    this.rmanDealArrangements = rmanDealArrangements;
    this.displayDialog = false;
    if (window.confirm('Are you sure you want to delete this record?')) {
      this.rmanDealArrangementsList.splice(this.findSelectedRmanDealArrangementsIndex(), 1);
      this.rmanDealArrangementsService.deleteRmanDealArrangements(this.rmanDealArrangements).then((response: any) => {
        this.rmanDealArrangements = new RmanDealArrangementsImpl();
        this.getAllRmanDealArrangements();
      });
    }

  }

  editRow(rmanDealArrangements: any) {
    this.newRmanDealArrangements = false;
    this.rmanDealArrangements = this.cloneRmanDealArrangements(rmanDealArrangements);
    this.displayDialog = true;

  }


  findSelectedRmanDealArrangementsIndex(): number {
    return this.rmanDealArrangementsList.indexOf(this.selectedRmanDealArrangements);
  }

  onRowSelect(event: any) {

  }

  cloneRmanDealArrangements(c: RmanDealArrangements): RmanDealArrangements {
    let rmanDealArrangements: any = new RmanDealArrangementsImpl();
    for (let prop in c) {
      rmanDealArrangements[prop] = c[prop];
    }
    return rmanDealArrangements;
  }

  hideColumnMenu: boolean = true;

  toggleColumnMenu() {
    if (this.hideColumnMenu) {
      this.hideColumnMenu = false;
    } else {
      this.hideColumnMenu = true;
    }
  }

  showFilter: boolean = false;

  toggleFilterBox() {
    if (this.showFilter) {
      this.showFilter = false;
    } else {
      this.showFilter = true;
    }
  }

  showDialogToSearch() {
    if (this.isSerached == 0) {
      this.rmanDealArrangementsSearch = new RmanDealArrangementsImpl();
    }
  }

  search() {
    this.isSerached = 1;
    this.rmanDealArrangements = this.rmanDealArrangementsSearch;
    this.getAllRmanDealArrangements();
  }

  ngOnDestroy() {
    this.subscription1.unsubscribe();
    if (this.componentRefference) {
      this.componentRefference.destroy();
    }
  }

}


export class RmanDealArrangementsImpl {
  constructor(public dealCosedDate?: any, public attribute30?: any, public lastUpdateDate?: any, public dealArrangementBasis?: any, public dealArrangementKey?: any, public dealArrangementTotal?: any, public changeReason?: any, public attribute29?: any, public attribute28?: any, public dealArrangementType?: any, public attribute27?: any, public dealApprovalDate?: any, public attribute26?: any, public masterArrgId?: any, public dealName?: any, public attribute3?: any, public createdBy?: any, public attribute2?: any, public lastUpdatedBy?: any, public attribute1?: any, public dealArrangementSource?: any, public salesContact?: any, public legalEntityId?: any, public creationDate?: any, public attribute9?: any, public attribute8?: any, public attribute7?: any, public attribute6?: any, public attribute5?: any, public attribute4?: any, public allocationEligible?: any, public dealAgreementId?: any, public dealArrangementStatus?: any, public attribute10?: any, public endCustomerName?: any, public dealArrangementNumber?: any, public masterArrgName?: any, public revManagerId?: any, public attribute14?: any, public attribute13?: any, public arrangementCurrency?: any, public attribute12?: any, public msaName?: any, public attribute11?: any, public dealApprovedBy?: any, public dealArrangementName?: any, public endCustomerNumber?: any, public customerContact?: any, public dealId?: any, public dealArrangementSaMe?: any, public dealNumber?: any, public attribute21?: any, public salesNodeLevel4?: any, public attribute20?: any, public msaNumber?: any, public salesNodeLevel2?: any, public salesNodeLevel3?: any, public dealArrangementQtr?: any, public attribute25?: any, public attribute24?: any, public attribute23?: any, public revAccountantId?: any, public attribute22?: any, public reasonCode?: any, public masterArrgFlag?: any, public salesNodeLevel1?: any, public dealArrangementId?: any, public legalEntityName?: any, public attribute18?: any, public attribute17?: any, public attribute16?: any, public attribute15?: any, public dealAgreementName?: any, public attribute19?: any, public managerUser?: any, public analystUser?: any) { }
}

class RmanArrangementTotalLevelsImpl {
  constructor(public bookingsamount?: any,
    public cogsrev?: any,
    public revrecognizeamount?: any,
    public billedamount?: any,
    public revdeffered?: any,
    public arrangementamount?: any,
    public grossmargin?: any,
    public dealArrangementId?: any,
    public shippedamount?: any) { }
}



interface ILabels {
  [index: string]: string;
}
