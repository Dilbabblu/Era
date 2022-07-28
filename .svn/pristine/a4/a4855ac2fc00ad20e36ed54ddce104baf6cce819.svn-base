import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService, Message, SelectItem } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanContHeaderService } from '../rmanContHeader/rmanContHeaderservice';
import { RmanCustomers } from '../rmanCustomers/rmanCustomers';
import { RmanCustomersImpl } from '../rmanCustomers/rmanCustomers.component';
import { RmanCustomersService } from '../rmanCustomers/rmanCustomersservice';
import { RmanProductsImpl } from '../rmanProducts/rmanProducts.component';
import { RmanProductsService } from '../rmanProducts/rmanProductsservice';
import { NotificationService } from '../shared/notifications.service';
import { SspGroupingRulesImpl } from '../sspGroupingRules/sspGroupingRules.component';
import { ConcurrentProgramsService } from './conurrentProgramsService';
declare var require: any;
declare var $: any;
const appSettings = require('../appsettings');

@Component({
	templateUrl: './conurrentPrograms.component.html',
	selector: 'conurrentPrograms-data',
	providers: [ConcurrentProgramsService, RmanContHeaderService, RmanCustomersService,
	RmanProductsService]
})

export class ConcurrentProgramsComponent implements OnInit{

	programs: SelectItem[];

	selectedProgram: string;

	msgs: Message[];

	collapsed: boolean = true;

	pageSize: number;

	totalElements: number;

	paginationOptions: any;

	noData = appSettings.noData;

	loading: boolean;

	fileLog: any[] = [];

	displaySearchDialog:any;

	sspGroupingRules:any = new SspGroupingRulesImpl();

	rmanContHeaderVList: any[] = [];
	rmanContHeaderV: any[];

	contReleaseForm:FormGroup;

	dateFlag:any

	fromDate:any;
	toDate:any;
	headerId:any;
	customerNumber:any
	productGroup:any;
	productFamily:any;
	productLine:any;
	orderNumber:any;
	customerPo:any;
	releaseDate: any;
	minimumDate = new Date();


	filteredCustomerNumberList:any[];
	filteredProductGroupList:any[];
	filteredProductFamilyList:any[];
	filteredProductLineList:any[];
	filteredOrderNumberList:any[];
	filteredCustomerPoList:any[];

	customerNamePlaceHolder:any;
	productGroupPlaceHolder:any;
	productFamilyPlaceHolder:any;
	productLinePlaceHolder:any;



	constructor(private conurrentProgramsService: ConcurrentProgramsService, private notificationService: NotificationService,
		private rmanContHeaderService: RmanContHeaderService, private formBuilder: FormBuilder,
		private customersService:RmanCustomersService, private productsService:RmanProductsService) {

		this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };

		this.programs = [];
		this.programs.push({ label: 'Select Job', value: null });
		this.programs.push({ label: 'Ayara Process Contracts', value: 'PROCESS_DEALS' });
		this.programs.push({ label: 'Ayara Update POB to Deals', value: 'PROCESS_UPDATE_POB' });
		this.programs.push({ label: 'Ayara FMV Submit Process to Deals', value: 'PROCESS_FMV_DEALS' });
		this.programs.push({ label: 'Ayara Update VC to Deals', value: 'PROCESS_VC_UPDATE' });
		this.programs.push({ label: 'Ayara Allocations to Deals', value: 'PROCESS_DEAL_ALLOCATIONS' });
		this.programs.push({ label: 'Ayara LT and ST Account Reversal Entry', value: 'LT_ST_REVERSE_ENTRY' });
		this.programs.push({ label: 'Contingency Release Program', value: 'CONT_RELEASE_PROG' });


		this.rmanContHeaderService.getAllRmanContHeader(this.paginationOptions, { 'lookupTypeName': 'APPLICATION_LEVEL' }).then((rmanContHeaderVList: any) => {
			this.rmanContHeaderVList = rmanContHeaderVList.content;
			this.prepareRmanContHeaderVObject();
		}).catch((err: any) => {
			this.notificationService.showError('Error occured while getting "Rule Category" data');
			this.loading = false;
		  });
			
	}

	ngOnInit(){
		this.buildForm();
	}

	rmanCustomers: RmanCustomers = new RmanCustomersImpl();
	filterCustomerNumber(event: any) {
		let query = event.query;
		this.rmanCustomers.customerNumber = query;
		this.customersService.getAllRmanCustomers(this.paginationOptions, this.rmanCustomers, false).then((response:any) => {
		  this.filteredCustomerNumberList = response.content.map(item => item.customerNumber);
		}).catch(err => {
		  this.filteredCustomerNumberList = [];
		});
	  }

	  rmanProducts: any = new RmanProductsImpl();
	  filterProductGroup(event: any) {
		let query = event.query;
		this.rmanProducts = new RmanProductsImpl();
		this.rmanProducts.attribute1 = query;
		this.productsService.getAllRmanProducts(this.paginationOptions, this.rmanProducts, false).then((response:any) => {
		  this.filteredProductGroupList = response.content.map(item => item.attribute1);
		  this.filteredProductGroupList = this.filteredProductGroupList.filter(((element, i) => i === this.filteredProductGroupList.indexOf(element)));
		}).catch(err => {
		  this.filteredProductGroupList = [];
		});
	  }

	  filterProductFamily(event: any) {
		let query = event.query;
		this.rmanProducts = new RmanProductsImpl();
		this.rmanProducts.attribute2 = query;
		this.productsService.getAllRmanProducts(this.paginationOptions, this.rmanProducts, false).then((response:any) => {
		  this.filteredProductFamilyList = response.content.map(item => item.attribute2);
		  this.filteredProductFamilyList = this.filteredProductFamilyList.filter(((element, i) => i === this.filteredProductFamilyList.indexOf(element)));
		}).catch(err => {
		  this.filteredProductFamilyList = [];
		});
	  }

	  filterProductLine(event: any) {
		let query = event.query;
		this.rmanProducts = new RmanProductsImpl();
		this.rmanProducts.attribute3 = query;
		this.productsService.getAllRmanProducts(this.paginationOptions, this.rmanProducts, false).then((response:any) => {
		  this.filteredProductLineList = response.content.map(item => item.attribute3);
		  this.filteredProductLineList = this.filteredProductLineList.filter(((element, i) => i === this.filteredProductLineList.indexOf(element)));
		}).catch(err => {
		  this.filteredProductLineList = [];
		});
	  }

	//   rmanOrders: RmanOrders = new RmanOrdersImpl();
	//   filterOrderNumber(event: any) {
	// 	let query = event.query;
	// 	this.rmanOrders = new RmanOrdersImpl();
	// 	this.rmanOrders.orderNumber = query;
	// 	this.ordersService.getAllRmanOrders(this.paginationOptions, this.rmanOrders, false).then((response:any) => {
	// 	  this.filteredOrderNumberList = response.content.map(item => item.orderNumber);
	// 	}).catch(err => {
	// 	  this.filteredOrderNumberList = [];
	// 	});
	//   }

	//   filterCustomerPo(event: any) {
	// 	let query = event.query;
	// 	this.rmanOrders = new RmanOrdersImpl();
	// 	this.rmanOrders.customerPoNum = query;
	// 	this.ordersService.getAllRmanOrders(this.paginationOptions, this.rmanOrders, false).then((response:any) => {
	// 	  this.filteredCustomerPoList = response.content.map(item => item.customerPoNum);
	// 	}).catch(err => {
	// 	  this.filteredCustomerPoList = [];
	// 	});
	//   }

	dateCheck(event: any) {
		if (this.fromDate && this.toDate) {
		  if (this.fromDate > this.toDate) {
			this.dateFlag = true;
		  }
		  else {
			this.dateFlag = false;
		  }
		}
	  }

	prepareRmanContHeaderVObject() {
		let rmanContHeaderVTempObj: any = [];
		rmanContHeaderVTempObj.push({ label: 'Select Contingency Name(*)', value: '' });
		this.rmanContHeaderVList.forEach((rmanContHeaderV) => {
		  rmanContHeaderVTempObj.push({ label: rmanContHeaderV.ruleName, value: rmanContHeaderV.ruleHeaderId });
		});
	
		this.rmanContHeaderV = rmanContHeaderVTempObj;
	
	  }

	submitConcurrentProgram() {
		if(this.selectedProgram === 'CONT_RELEASE_PROG'){
			this.displaySearchDialog = true
		}else{
			this.notificationService.showInfo('Job submitted and Running');
			$.blockUI();
			this.conurrentProgramsService.executeConcurrentprogram(this.selectedProgram).then((result: any) => {
				$.unblockUI();
				if (result) {
					this.notificationService.showSuccess('Job successfully completed');
				} else {
					this.notificationService.showError('Job execution failed');
				}
	
			}).catch((err: any) => {
				$.unblockUI();
				this.notificationService.showError('Job execution has been terminated');
			});
		}
	}

	release(){
		this.notificationService.showInfo('Job submitted and Running');
			$.blockUI();
			if(this.customerNumber === undefined) this.customerNumber = '';
			if(this.productGroup === undefined) this.productGroup = '';
			if(this.productFamily === undefined) this.productFamily = '';
			if(this.productLine === undefined) this.productLine = '';
			if(this.orderNumber === undefined) this.orderNumber = '';
			if(this.customerPo === undefined) this.customerPo = '';
			if(this.releaseDate === undefined) this.releaseDate = '';
			
			this.conurrentProgramsService.releaseContingency(this.headerId, new DatePipe('en-US').transform(this.fromDate, 'yyyy-MM-dd'), new DatePipe('en-US').transform(this.toDate, 'yyyy-MM-dd'), this.customerNumber, this.productGroup, this.productFamily, this.productLine, this.orderNumber, this.customerPo, new DatePipe('en-US').transform(this.releaseDate, 'yyyy-MM-dd')).then((result: any) => {
				$.unblockUI();
				this.displaySearchDialog = false;
				if (result) {
					this.notificationService.showSuccess('Job successfully completed');
				} else {
					this.notificationService.showError('Job execution failed');
				}
	
			}).catch((err: any) => {
				$.unblockUI();
				this.displaySearchDialog = false;
				this.notificationService.showError('Job execution has been terminated');
			});
	}

	cancelSearch(){
		this.displaySearchDialog = false;
	}

	onBeforeToggle(evt: any) {

		this.collapsed = evt.collapsed;
	}

	getAllUploadLogsList() {
		this.__getData(this.paginationOptions);
	}

	getAllUploadLogs(event: any) {
		let first: number = event.first;
		let rows: number = event.rows;
		let pageNumber: number = first / rows;
		this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
		this.loading = true;
		this.__getData(this.paginationOptions);
	}

	__getData(paginationOptions:any){
		this.conurrentProgramsService.fetchUploadLogs(paginationOptions).then((fileLog: any) => {
			this.loading = false;
			this.fileLog = fileLog.content;
			this.totalElements = fileLog.totalElements;
			this.pageSize = fileLog.size;
		});
	}

	exportExcel(filelogs: any) {
		let serviceUrl = this.conurrentProgramsService.exportArchiveFiles(filelogs.attribute1, filelogs.jobId, filelogs.attribute3);
		window.location.href = serviceUrl;
	}

	downloadFile(filelogs: any) {
		let serviceUrl = this.conurrentProgramsService.downloadUploadedFile(filelogs.jobId);
		window.location.href = serviceUrl;
	}

	reset(dt: Table) {
		this.paginationOptions = {};
		dt.reset();
	}

	buildForm() {
		this.contReleaseForm = this.formBuilder.group({
		  'sspGrule': ['', [Validators.required]],
		  'FromDate': ['', [Validators.required]],
		  'ToDate': ['', [Validators.required]],
		  'customerNumber': ['', []],
		  'productGroup': ['', []],
		  'productFamily': ['', []],
		  'productLine': ['', []],
		  'orderNumber': ['', []],
			'customerPo': ['', []],
			'releaseDate': ['', [Validators.required]],

		});
		this.contReleaseForm.valueChanges
		  .subscribe(data => this.onValueChanged(data));
		this.onValueChanged();
	  }
	
	  onValueChanged(data?: any) {
		if (!this.contReleaseForm) { return; }
		const form = this.contReleaseForm;
	
		for (const field in this.formErrors) {
		  this.formErrors[field] = '';
		  const control = form.get(field);
		  if (control && control.dirty && !control.valid) {
			const messages = this.validationMessages[field];
			for (const key in control.errors) {
			  this.formErrors[field] += messages[key] + ' ';
			}
		  }
		}
	  }
	
	  formErrors = {
		'sspGrule': '','FromDate':'','ToDate': '','customerNumber':'', 'productGroup':'', 'productFamily':'','productLine':'','orderNumber':'','customerPo':'','releaseDate':''};
	
	  validationMessages = {
		'sspGrule': { 'required': "Rule Name is required" },
		'FromDate':{ 'required': "From Date is required" },
		'ToDate':{ 'required': "To Date is required" },
		'customerNumber': { 'required': "Customer Number is required" },
		'productGroup':{ 'required': "Product Group is required" },
		'productFamily':{ 'required': "Product Family is required" },
		'productLine': { 'required': "Product Line is required" },
		'orderNumber':{ 'required': "Order Number is required" },
		'customerPo':{ 'required': "Customer Po is required" },
		'releaseDate':{ 'required': "Release Date is required" },
	  }

}
