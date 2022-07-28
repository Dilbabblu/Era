import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
declare var require:any;
const appSettings = require('../appsettings');


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
  })
};




@Injectable()
export class RmanCustomersService {

    constructor(private http: HttpClient) {}
    
    getAllRmanCustomers(paginationOptions:any,rmanCustomersSearchObject:any, fetchAll:any): Promise<any[]> {
        let serviceUrl=appSettings.apiUrl+'/rmanCustomersSearch?';
        
        let searchString='';

        if(fetchAll){
            serviceUrl = serviceUrl + 'fetchAll=true&'
        }

        if (rmanCustomersSearchObject.customerId!=undefined && rmanCustomersSearchObject.customerId!="") {
            searchString=searchString+'customerId:'+rmanCustomersSearchObject.customerId+',';
        }

        if (rmanCustomersSearchObject.customerName!=undefined && rmanCustomersSearchObject.customerName!="") {
            searchString=searchString+'customerName:'+encodeURIComponent(rmanCustomersSearchObject.customerName)+',';
        }

        if (rmanCustomersSearchObject.customerNumber!=undefined && rmanCustomersSearchObject.customerNumber!="") {
            searchString=searchString+'customerNumber:'+rmanCustomersSearchObject.customerNumber+',';
        }

        if (rmanCustomersSearchObject.status!=undefined && rmanCustomersSearchObject.status!="") {
            searchString=searchString+'status:'+rmanCustomersSearchObject.status+',';
        }

        if (rmanCustomersSearchObject.lastUpdateDate!=undefined && rmanCustomersSearchObject.lastUpdateDate!="") {
            searchString=searchString+'lastUpdateDate:'+rmanCustomersSearchObject.lastUpdateDate+',';
        }

        if (rmanCustomersSearchObject.lastUpdatedBy!=undefined && rmanCustomersSearchObject.lastUpdatedBy!="") {
            searchString=searchString+'lastUpdatedBy:'+rmanCustomersSearchObject.lastUpdatedBy+',';
        }

        if (rmanCustomersSearchObject.creationDate!=undefined && rmanCustomersSearchObject.creationDate!="") {
            searchString=searchString+'creationDate:'+rmanCustomersSearchObject.creationDate+',';
        }

        if (rmanCustomersSearchObject.createdBy!=undefined && rmanCustomersSearchObject.createdBy!="") {
            searchString=searchString+'createdBy:'+rmanCustomersSearchObject.createdBy+',';
        }

        if (rmanCustomersSearchObject.customerType!=undefined && rmanCustomersSearchObject.customerType!="") {
            searchString=searchString+'customerType:'+rmanCustomersSearchObject.customerType+',';
        }

        if (rmanCustomersSearchObject.customerClassCode!=undefined && rmanCustomersSearchObject.customerClassCode!="") {
            searchString=searchString+'customerClassCode:'+rmanCustomersSearchObject.customerClassCode+',';
        }

        if (rmanCustomersSearchObject.primarySalesrepName!=undefined && rmanCustomersSearchObject.primarySalesrepName!="") {
            searchString=searchString+'primarySalesrepName:'+rmanCustomersSearchObject.primarySalesrepName+',';
        }

        if (rmanCustomersSearchObject.salesChannelCode!=undefined && rmanCustomersSearchObject.salesChannelCode!="") {
            searchString=searchString+'salesChannelCode:'+rmanCustomersSearchObject.salesChannelCode+',';
        }

        if (rmanCustomersSearchObject.attributeCategory!=undefined && rmanCustomersSearchObject.attributeCategory!="") {
            searchString=searchString+'attributeCategory:'+rmanCustomersSearchObject.attributeCategory+',';
        }

        if (rmanCustomersSearchObject.attribute1!=undefined && rmanCustomersSearchObject.attribute1!="") {
            searchString=searchString+'attribute1:'+rmanCustomersSearchObject.attribute1+',';
        }

        if (rmanCustomersSearchObject.attribute2!=undefined && rmanCustomersSearchObject.attribute2!="") {
            searchString=searchString+'attribute2:'+rmanCustomersSearchObject.attribute2+',';
        }

        if (rmanCustomersSearchObject.attribute3!=undefined && rmanCustomersSearchObject.attribute3!="") {
            searchString=searchString+'attribute3:'+rmanCustomersSearchObject.attribute3+',';
        }

        if (rmanCustomersSearchObject.attribute4!=undefined && rmanCustomersSearchObject.attribute4!="") {
            searchString=searchString+'attribute4:'+rmanCustomersSearchObject.attribute4+',';
        }

        if (rmanCustomersSearchObject.attribute5!=undefined && rmanCustomersSearchObject.attribute5!="") {
            searchString=searchString+'attribute5:'+rmanCustomersSearchObject.attribute5+',';
        }

        if (rmanCustomersSearchObject.attribute6!=undefined && rmanCustomersSearchObject.attribute6!="") {
            searchString=searchString+'attribute6:'+rmanCustomersSearchObject.attribute6+',';
        }

        if (rmanCustomersSearchObject.attribute7!=undefined && rmanCustomersSearchObject.attribute7!="") {
            searchString=searchString+'attribute7:'+rmanCustomersSearchObject.attribute7+',';
        }

        if (rmanCustomersSearchObject.attribute8!=undefined && rmanCustomersSearchObject.attribute8!="") {
            searchString=searchString+'attribute8:'+rmanCustomersSearchObject.attribute8+',';
        }

        if (rmanCustomersSearchObject.attribute9!=undefined && rmanCustomersSearchObject.attribute9!="") {
            searchString=searchString+'attribute9:'+rmanCustomersSearchObject.attribute9+',';
        }

        if (rmanCustomersSearchObject.attribute10!=undefined && rmanCustomersSearchObject.attribute10!="") {
            searchString=searchString+'attribute10:'+rmanCustomersSearchObject.attribute10+',';
        }

        if (rmanCustomersSearchObject.attribute11!=undefined && rmanCustomersSearchObject.attribute11!="") {
            searchString=searchString+'attribute11:'+rmanCustomersSearchObject.attribute11+',';
        }

        if (rmanCustomersSearchObject.attribute12!=undefined && rmanCustomersSearchObject.attribute12!="") {
            searchString=searchString+'attribute12:'+rmanCustomersSearchObject.attribute12+',';
        }

        if (rmanCustomersSearchObject.attribute13!=undefined && rmanCustomersSearchObject.attribute13!="") {
            searchString=searchString+'attribute13:'+rmanCustomersSearchObject.attribute13+',';
        }

        if (rmanCustomersSearchObject.attribute14!=undefined && rmanCustomersSearchObject.attribute14!="") {
            searchString=searchString+'attribute14:'+rmanCustomersSearchObject.attribute14+',';
        }

        if (rmanCustomersSearchObject.attribute15!=undefined && rmanCustomersSearchObject.attribute15!="") {
            searchString=searchString+'attribute15:'+rmanCustomersSearchObject.attribute15+',';
        }

        if (rmanCustomersSearchObject.attribute16!=undefined && rmanCustomersSearchObject.attribute16!="") {
            searchString=searchString+'attribute16:'+rmanCustomersSearchObject.attribute16+',';
        }

        if (rmanCustomersSearchObject.attribute17!=undefined && rmanCustomersSearchObject.attribute17!="") {
            searchString=searchString+'attribute17:'+rmanCustomersSearchObject.attribute17+',';
        }

        if (rmanCustomersSearchObject.attribute18!=undefined && rmanCustomersSearchObject.attribute18!="") {
            searchString=searchString+'attribute18:'+rmanCustomersSearchObject.attribute18+',';
        }

        if (rmanCustomersSearchObject.attribute19!=undefined && rmanCustomersSearchObject.attribute19!="") {
            searchString=searchString+'attribute19:'+rmanCustomersSearchObject.attribute19+',';
        }

        if (rmanCustomersSearchObject.attribute20!=undefined && rmanCustomersSearchObject.attribute20!="") {
            searchString=searchString+'attribute20:'+rmanCustomersSearchObject.attribute20+',';
        }

        if (rmanCustomersSearchObject.attribute21!=undefined && rmanCustomersSearchObject.attribute21!="") {
            searchString=searchString+'attribute21:'+rmanCustomersSearchObject.attribute21+',';
        }

        if (rmanCustomersSearchObject.attribute22!=undefined && rmanCustomersSearchObject.attribute22!="") {
            searchString=searchString+'attribute22:'+rmanCustomersSearchObject.attribute22+',';
        }

        if (rmanCustomersSearchObject.attribute23!=undefined && rmanCustomersSearchObject.attribute23!="") {
            searchString=searchString+'attribute23:'+rmanCustomersSearchObject.attribute23+',';
        }

        if (rmanCustomersSearchObject.attribute24!=undefined && rmanCustomersSearchObject.attribute24!="") {
            searchString=searchString+'attribute24:'+rmanCustomersSearchObject.attribute24+',';
        }

        if (rmanCustomersSearchObject.globalAttributeCategory!=undefined && rmanCustomersSearchObject.globalAttributeCategory!="") {
            searchString=searchString+'globalAttributeCategory:'+rmanCustomersSearchObject.globalAttributeCategory+',';
        }

        if (rmanCustomersSearchObject.globalAttribute1!=undefined && rmanCustomersSearchObject.globalAttribute1!="") {
            searchString=searchString+'globalAttribute1:'+rmanCustomersSearchObject.globalAttribute1+',';
        }

        if (rmanCustomersSearchObject.globalAttribute2!=undefined && rmanCustomersSearchObject.globalAttribute2!="") {
            searchString=searchString+'globalAttribute2:'+rmanCustomersSearchObject.globalAttribute2+',';
        }

        if (rmanCustomersSearchObject.globalAttribute4!=undefined && rmanCustomersSearchObject.globalAttribute4!="") {
            searchString=searchString+'globalAttribute4:'+rmanCustomersSearchObject.globalAttribute4+',';
        }

        if (rmanCustomersSearchObject.globalAttribute3!=undefined && rmanCustomersSearchObject.globalAttribute3!="") {
            searchString=searchString+'globalAttribute3:'+rmanCustomersSearchObject.globalAttribute3+',';
        }

        if (rmanCustomersSearchObject.globalAttribute5!=undefined && rmanCustomersSearchObject.globalAttribute5!="") {
            searchString=searchString+'globalAttribute5:'+rmanCustomersSearchObject.globalAttribute5+',';
        }

        if (rmanCustomersSearchObject.globalAttribute6!=undefined && rmanCustomersSearchObject.globalAttribute6!="") {
            searchString=searchString+'globalAttribute6:'+rmanCustomersSearchObject.globalAttribute6+',';
        }

        if (rmanCustomersSearchObject.globalAttribute7!=undefined && rmanCustomersSearchObject.globalAttribute7!="") {
            searchString=searchString+'globalAttribute7:'+rmanCustomersSearchObject.globalAttribute7+',';
        }

        if (rmanCustomersSearchObject.globalAttribute8!=undefined && rmanCustomersSearchObject.globalAttribute8!="") {
            searchString=searchString+'globalAttribute8:'+rmanCustomersSearchObject.globalAttribute8+',';
        }

        if (rmanCustomersSearchObject.globalAttribute9!=undefined && rmanCustomersSearchObject.globalAttribute9!="") {
            searchString=searchString+'globalAttribute9:'+rmanCustomersSearchObject.globalAttribute9+',';
        }

        if (rmanCustomersSearchObject.globalAttribute10!=undefined && rmanCustomersSearchObject.globalAttribute10!="") {
            searchString=searchString+'globalAttribute10:'+rmanCustomersSearchObject.globalAttribute10+',';
        }

        if (rmanCustomersSearchObject.globalAttribute11!=undefined && rmanCustomersSearchObject.globalAttribute11!="") {
            searchString=searchString+'globalAttribute11:'+rmanCustomersSearchObject.globalAttribute11+',';
        }

        if (rmanCustomersSearchObject.globalAttribute12!=undefined && rmanCustomersSearchObject.globalAttribute12!="") {
            searchString=searchString+'globalAttribute12:'+rmanCustomersSearchObject.globalAttribute12+',';
        }

        if (rmanCustomersSearchObject.globalAttribute13!=undefined && rmanCustomersSearchObject.globalAttribute13!="") {
            searchString=searchString+'globalAttribute13:'+rmanCustomersSearchObject.globalAttribute13+',';
        }

        if (rmanCustomersSearchObject.globalAttribute14!=undefined && rmanCustomersSearchObject.globalAttribute14!="") {
            searchString=searchString+'globalAttribute14:'+rmanCustomersSearchObject.globalAttribute14+',';
        }

        if (rmanCustomersSearchObject.globalAttribute15!=undefined && rmanCustomersSearchObject.globalAttribute15!="") {
            searchString=searchString+'globalAttribute15:'+rmanCustomersSearchObject.globalAttribute15+',';
        }

        if (rmanCustomersSearchObject.globalAttribute16!=undefined && rmanCustomersSearchObject.globalAttribute16!="") {
            searchString=searchString+'globalAttribute16:'+rmanCustomersSearchObject.globalAttribute16+',';
        }

        if (rmanCustomersSearchObject.globalAttribute17!=undefined && rmanCustomersSearchObject.globalAttribute17!="") {
            searchString=searchString+'globalAttribute17:'+rmanCustomersSearchObject.globalAttribute17+',';
        }

        if (rmanCustomersSearchObject.globalAttribute18!=undefined && rmanCustomersSearchObject.globalAttribute18!="") {
            searchString=searchString+'globalAttribute18:'+rmanCustomersSearchObject.globalAttribute18+',';
        }

        if (rmanCustomersSearchObject.globalAttribute19!=undefined && rmanCustomersSearchObject.globalAttribute19!="") {
            searchString=searchString+'globalAttribute19:'+rmanCustomersSearchObject.globalAttribute19+',';
        }

        if (rmanCustomersSearchObject.globalAttribute20!=undefined && rmanCustomersSearchObject.globalAttribute20!="") {
            searchString=searchString+'globalAttribute20:'+rmanCustomersSearchObject.globalAttribute20+',';
        }

        if (rmanCustomersSearchObject.origSystemReference!=undefined && rmanCustomersSearchObject.origSystemReference!="") {
            searchString=searchString+'origSystemReference:'+rmanCustomersSearchObject.origSystemReference+',';
        }

        if (rmanCustomersSearchObject.personFirstName!=undefined && rmanCustomersSearchObject.personFirstName!="") {
            searchString=searchString+'personFirstName:'+rmanCustomersSearchObject.personFirstName+',';
        }

        if (rmanCustomersSearchObject.personMiddleName!=undefined && rmanCustomersSearchObject.personMiddleName!="") {
            searchString=searchString+'personMiddleName:'+rmanCustomersSearchObject.personMiddleName+',';
        }

        if (rmanCustomersSearchObject.personLastName!=undefined && rmanCustomersSearchObject.personLastName!="") {
            searchString=searchString+'personLastName:'+rmanCustomersSearchObject.personLastName+',';
        }

        if (rmanCustomersSearchObject.personNameSuffix!=undefined && rmanCustomersSearchObject.personNameSuffix!="") {
            searchString=searchString+'personNameSuffix:'+rmanCustomersSearchObject.personNameSuffix+',';
        }

        if (rmanCustomersSearchObject.personTitle!=undefined && rmanCustomersSearchObject.personTitle!="") {
            searchString=searchString+'personTitle:'+rmanCustomersSearchObject.personTitle+',';
        }

        if (rmanCustomersSearchObject.personAcademicTitle!=undefined && rmanCustomersSearchObject.personAcademicTitle!="") {
            searchString=searchString+'personAcademicTitle:'+rmanCustomersSearchObject.personAcademicTitle+',';
        }

        if (rmanCustomersSearchObject.personPreviousLastName!=undefined && rmanCustomersSearchObject.personPreviousLastName!="") {
            searchString=searchString+'personPreviousLastName:'+rmanCustomersSearchObject.personPreviousLastName+',';
        }

        if (rmanCustomersSearchObject.knownAs!=undefined && rmanCustomersSearchObject.knownAs!="") {
            searchString=searchString+'knownAs:'+rmanCustomersSearchObject.knownAs+',';
        }

        if (rmanCustomersSearchObject.personIdenType!=undefined && rmanCustomersSearchObject.personIdenType!="") {
            searchString=searchString+'personIdenType:'+rmanCustomersSearchObject.personIdenType+',';
        }

        if (rmanCustomersSearchObject.personIdentifier!=undefined && rmanCustomersSearchObject.personIdentifier!="") {
            searchString=searchString+'personIdentifier:'+rmanCustomersSearchObject.personIdentifier+',';
        }

        if (rmanCustomersSearchObject.groupType!=undefined && rmanCustomersSearchObject.groupType!="") {
            searchString=searchString+'groupType:'+rmanCustomersSearchObject.groupType+',';
        }

        if (rmanCustomersSearchObject.country!=undefined && rmanCustomersSearchObject.country!="") {
            searchString=searchString+'country:'+rmanCustomersSearchObject.country+',';
        }

        if (rmanCustomersSearchObject.address1!=undefined && rmanCustomersSearchObject.address1!="") {
            searchString=searchString+'address1:'+rmanCustomersSearchObject.address1+',';
        }

        if (rmanCustomersSearchObject.address2!=undefined && rmanCustomersSearchObject.address2!="") {
            searchString=searchString+'address2:'+rmanCustomersSearchObject.address2+',';
        }

        if (rmanCustomersSearchObject.address3!=undefined && rmanCustomersSearchObject.address3!="") {
            searchString=searchString+'address3:'+rmanCustomersSearchObject.address3+',';
        }

        if (rmanCustomersSearchObject.address4!=undefined && rmanCustomersSearchObject.address4!="") {
            searchString=searchString+'address4:'+rmanCustomersSearchObject.address4+',';
        }

        if (rmanCustomersSearchObject.city!=undefined && rmanCustomersSearchObject.city!="") {
            searchString=searchString+'city:'+rmanCustomersSearchObject.city+',';
        }

        if (rmanCustomersSearchObject.postalCode!=undefined && rmanCustomersSearchObject.postalCode!="") {
            searchString=searchString+'postalCode:'+rmanCustomersSearchObject.postalCode+',';
        }

        if (rmanCustomersSearchObject.state!=undefined && rmanCustomersSearchObject.state!="") {
            searchString=searchString+'state:'+rmanCustomersSearchObject.state+',';
        }

        if (rmanCustomersSearchObject.province!=undefined && rmanCustomersSearchObject.province!="") {
            searchString=searchString+'province:'+rmanCustomersSearchObject.province+',';
        }

        if (rmanCustomersSearchObject.county!=undefined && rmanCustomersSearchObject.county!="") {
            searchString=searchString+'county:'+rmanCustomersSearchObject.county+',';
        }

        if (rmanCustomersSearchObject.sicCodeType!=undefined && rmanCustomersSearchObject.sicCodeType!="") {
            searchString=searchString+'sicCodeType:'+rmanCustomersSearchObject.sicCodeType+',';
        }

        if (rmanCustomersSearchObject.emailAddress!=undefined && rmanCustomersSearchObject.emailAddress!="") {
            searchString=searchString+'emailAddress:'+rmanCustomersSearchObject.emailAddress+',';
        }

        if (rmanCustomersSearchObject.doNotMailFlag!=undefined && rmanCustomersSearchObject.doNotMailFlag!="") {
            searchString=searchString+'doNotMailFlag:'+rmanCustomersSearchObject.doNotMailFlag+',';
        }

        if (rmanCustomersSearchObject.dunsNumber!=undefined && rmanCustomersSearchObject.dunsNumber!="") {
            searchString=searchString+'dunsNumber:'+rmanCustomersSearchObject.dunsNumber+',';
        }

        if (rmanCustomersSearchObject.requestId!=undefined && rmanCustomersSearchObject.requestId!="") {
            searchString=searchString+'requestId:'+rmanCustomersSearchObject.requestId+',';
        }

        if (rmanCustomersSearchObject.primaryPhoneNumber!=undefined && rmanCustomersSearchObject.primaryPhoneNumber!="") {
            searchString=searchString+'primaryPhoneNumber:'+rmanCustomersSearchObject.primaryPhoneNumber+',';
        }

        if (rmanCustomersSearchObject.faxNumber!=undefined && rmanCustomersSearchObject.faxNumber!="") {
            searchString=searchString+'faxNumber:'+rmanCustomersSearchObject.faxNumber+',';
        }

        if (rmanCustomersSearchObject.financeContact!=undefined && rmanCustomersSearchObject.financeContact!="") {
            searchString=searchString+'financeContact:'+rmanCustomersSearchObject.financeContact+',';
        }

        if (rmanCustomersSearchObject.paymentTerms!=undefined && rmanCustomersSearchObject.paymentTerms!="") {
            searchString=searchString+'paymentTerms:'+rmanCustomersSearchObject.paymentTerms+',';
        }

        if (rmanCustomersSearchObject.revAccountId!=undefined && rmanCustomersSearchObject.revAccountId!="") {
            searchString=searchString+'revAccountId:'+rmanCustomersSearchObject.revAccountId+',';
        }

        if (rmanCustomersSearchObject.cogsAccountId!=undefined && rmanCustomersSearchObject.cogsAccountId!="") {
            searchString=searchString+'cogsAccountId:'+rmanCustomersSearchObject.cogsAccountId;
        }


        
        if (searchString == '') {
            serviceUrl=serviceUrl+'search=%25';
        }
        else {
            serviceUrl=serviceUrl+'search='+searchString;
        }
        
        if (paginationOptions.pageNumber!=undefined && paginationOptions.pageNumber!="" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber!=0) {
           serviceUrl=serviceUrl+'&page='+paginationOptions.pageNumber+'&size='+paginationOptions.pageSize;
        }
                
        return this.http.get(serviceUrl).toPromise().then((data:any) => {
            return data;
        });
    }
    
	searchRmanCustomers(rmanCustomers:any): Promise<any[]> {
        return this.http.get(appSettings.apiUrl+'/RMAN_CUSTOMERS/search/findByCustomerIdAndCustomerNameAndCustomerNumberAndStatusAndLastUpdateDateAndLastUpdatedByAndCreationDateAndCreatedByAndCustomerTypeAndCustomerClassCodeAndPrimarySalesrepNameAndSalesChannelCodeAndAttributeCategoryAndAttribute1AndAttribute2AndAttribute3AndAttribute4AndAttribute5AndAttribute6AndAttribute7AndAttribute8AndAttribute9AndAttribute10AndAttribute11AndAttribute12AndAttribute13AndAttribute14AndAttribute15AndAttribute16AndAttribute17AndAttribute18AndAttribute19AndAttribute20AndAttribute21AndAttribute22AndAttribute23AndAttribute24AndGlobalAttributeCategoryAndGlobalAttribute1AndGlobalAttribute2AndGlobalAttribute4AndGlobalAttribute3AndGlobalAttribute5AndGlobalAttribute6AndGlobalAttribute7AndGlobalAttribute8AndGlobalAttribute9AndGlobalAttribute10AndGlobalAttribute11AndGlobalAttribute12AndGlobalAttribute13AndGlobalAttribute14AndGlobalAttribute15AndGlobalAttribute16AndGlobalAttribute17AndGlobalAttribute18AndGlobalAttribute19AndGlobalAttribute20AndOrigSystemReferenceAndPersonFirstNameAndPersonMiddleNameAndPersonLastNameAndPersonNameSuffixAndPersonTitleAndPersonAcademicTitleAndPersonPreviousLastNameAndKnownAsAndPersonIdenTypeAndPersonIdentifierAndGroupTypeAndCountryAndAddress1AndAddress2AndAddress3AndAddress4AndCityAndPostalCodeAndStateAndProvinceAndCountyAndSicCodeTypeAndEmailAddressAndDoNotMailFlagAndDunsNumberAndRequestIdAndPrimaryPhoneNumberAndFaxNumberAndFinanceContactAndPaymentTermsAndRevAccountIdAndCogsAccountId?customerId='+rmanCustomers.customerId+'&customerName='+rmanCustomers.customerName+'&customerNumber='+rmanCustomers.customerNumber+'&status='+rmanCustomers.status+'&lastUpdateDate='+rmanCustomers.lastUpdateDate+'&lastUpdatedBy='+rmanCustomers.lastUpdatedBy+'&creationDate='+rmanCustomers.creationDate+'&createdBy='+rmanCustomers.createdBy+'&customerType='+rmanCustomers.customerType+'&customerClassCode='+rmanCustomers.customerClassCode+'&primarySalesrepName='+rmanCustomers.primarySalesrepName+'&salesChannelCode='+rmanCustomers.salesChannelCode+'&attributeCategory='+rmanCustomers.attributeCategory+'&attribute1='+rmanCustomers.attribute1+'&attribute2='+rmanCustomers.attribute2+'&attribute3='+rmanCustomers.attribute3+'&attribute4='+rmanCustomers.attribute4+'&attribute5='+rmanCustomers.attribute5+'&attribute6='+rmanCustomers.attribute6+'&attribute7='+rmanCustomers.attribute7+'&attribute8='+rmanCustomers.attribute8+'&attribute9='+rmanCustomers.attribute9+'&attribute10='+rmanCustomers.attribute10+'&attribute11='+rmanCustomers.attribute11+'&attribute12='+rmanCustomers.attribute12+'&attribute13='+rmanCustomers.attribute13+'&attribute14='+rmanCustomers.attribute14+'&attribute15='+rmanCustomers.attribute15+'&attribute16='+rmanCustomers.attribute16+'&attribute17='+rmanCustomers.attribute17+'&attribute18='+rmanCustomers.attribute18+'&attribute19='+rmanCustomers.attribute19+'&attribute20='+rmanCustomers.attribute20+'&attribute21='+rmanCustomers.attribute21+'&attribute22='+rmanCustomers.attribute22+'&attribute23='+rmanCustomers.attribute23+'&attribute24='+rmanCustomers.attribute24+'&globalAttributeCategory='+rmanCustomers.globalAttributeCategory+'&globalAttribute1='+rmanCustomers.globalAttribute1+'&globalAttribute2='+rmanCustomers.globalAttribute2+'&globalAttribute4='+rmanCustomers.globalAttribute4+'&globalAttribute3='+rmanCustomers.globalAttribute3+'&globalAttribute5='+rmanCustomers.globalAttribute5+'&globalAttribute6='+rmanCustomers.globalAttribute6+'&globalAttribute7='+rmanCustomers.globalAttribute7+'&globalAttribute8='+rmanCustomers.globalAttribute8+'&globalAttribute9='+rmanCustomers.globalAttribute9+'&globalAttribute10='+rmanCustomers.globalAttribute10+'&globalAttribute11='+rmanCustomers.globalAttribute11+'&globalAttribute12='+rmanCustomers.globalAttribute12+'&globalAttribute13='+rmanCustomers.globalAttribute13+'&globalAttribute14='+rmanCustomers.globalAttribute14+'&globalAttribute15='+rmanCustomers.globalAttribute15+'&globalAttribute16='+rmanCustomers.globalAttribute16+'&globalAttribute17='+rmanCustomers.globalAttribute17+'&globalAttribute18='+rmanCustomers.globalAttribute18+'&globalAttribute19='+rmanCustomers.globalAttribute19+'&globalAttribute20='+rmanCustomers.globalAttribute20+'&origSystemReference='+rmanCustomers.origSystemReference+'&personFirstName='+rmanCustomers.personFirstName+'&personMiddleName='+rmanCustomers.personMiddleName+'&personLastName='+rmanCustomers.personLastName+'&personNameSuffix='+rmanCustomers.personNameSuffix+'&personTitle='+rmanCustomers.personTitle+'&personAcademicTitle='+rmanCustomers.personAcademicTitle+'&personPreviousLastName='+rmanCustomers.personPreviousLastName+'&knownAs='+rmanCustomers.knownAs+'&personIdenType='+rmanCustomers.personIdenType+'&personIdentifier='+rmanCustomers.personIdentifier+'&groupType='+rmanCustomers.groupType+'&country='+rmanCustomers.country+'&address1='+rmanCustomers.address1+'&address2='+rmanCustomers.address2+'&address3='+rmanCustomers.address3+'&address4='+rmanCustomers.address4+'&city='+rmanCustomers.city+'&postalCode='+rmanCustomers.postalCode+'&state='+rmanCustomers.state+'&province='+rmanCustomers.province+'&county='+rmanCustomers.county+'&sicCodeType='+rmanCustomers.sicCodeType+'&emailAddress='+rmanCustomers.emailAddress+'&doNotMailFlag='+rmanCustomers.doNotMailFlag+'&dunsNumber='+rmanCustomers.dunsNumber+'&requestId='+rmanCustomers.requestId+'&primaryPhoneNumber='+rmanCustomers.primaryPhoneNumber+'&faxNumber='+rmanCustomers.faxNumber+'&financeContact='+rmanCustomers.financeContact+'&paymentTerms='+rmanCustomers.paymentTerms+'&revAccountId='+rmanCustomers.revAccountId+'&cogsAccountId='+rmanCustomers.cogsAccountId).toPromise().then((data:any) => {
			return data; 
			});
    }
    
    saveRmanCustomers(rmanCustomers:any): Promise<any[]> {
        let body = JSON.stringify(rmanCustomers);
        return this.http.post(appSettings.apiUrl+'/RMAN_CUSTOMERS',body,httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }
    
    updateRmanCustomers(rmanCustomers:any): Promise<any[]> {
        
        delete rmanCustomers._links;
        delete rmanCustomers.interests;
        let body = JSON.stringify(rmanCustomers);
        return this.http.put(appSettings.apiUrl+'/RMAN_CUSTOMERS/'+rmanCustomers.customerId,body,httpOptions).toPromise().then((data: any) => {
            return data;
        });
        
    }
    
    deleteRmanCustomers(rmanCustomers:any): Promise<any[]> {
        let deleteUrl=appSettings.apiUrl+'/RMAN_CUSTOMERS/'+rmanCustomers.customerId;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

}
