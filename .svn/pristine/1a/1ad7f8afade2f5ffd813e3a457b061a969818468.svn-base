import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
declare var require: any;
const appSettings = require('../appsettings');


const httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json',
    })
};




@Injectable()
export class RmanOpenDealArrangementsservice {

    constructor(private http: HttpClient) { }

    getAllRmanDealArrangements(paginationOptions: any, rmanDealArrangementsSearchObject: any): Promise<any[]> {
        let serviceUrl = appSettings.apiUrl + '/rmanOpenDealArrangementsVSearch?';

        let searchString = '';



        if (rmanDealArrangementsSearchObject.dealArrangementKey != undefined && rmanDealArrangementsSearchObject.dealArrangementKey != "") {
            searchString = searchString + 'dealArrangementKey:' + rmanDealArrangementsSearchObject.dealArrangementKey + ',';
        }

        if (rmanDealArrangementsSearchObject.poNumber != undefined && rmanDealArrangementsSearchObject.poNumber != "") {
            searchString = searchString + 'poNumber:' + rmanDealArrangementsSearchObject.poNumber + ',';
        }

        if (rmanDealArrangementsSearchObject.dealArrangementId != undefined && rmanDealArrangementsSearchObject.dealArrangementId != "") {
            searchString = searchString + 'dealArrangementId:' + rmanDealArrangementsSearchObject.dealArrangementId + ',';
        }

        if (rmanDealArrangementsSearchObject.dealArrangementName != undefined && rmanDealArrangementsSearchObject.dealArrangementName != "") {
            searchString = searchString + 'dealArrangementName:' + rmanDealArrangementsSearchObject.dealArrangementName + ',';
        }

        if (rmanDealArrangementsSearchObject.dealArrangementSaMe != undefined && rmanDealArrangementsSearchObject.dealArrangementSaMe != "") {
            searchString = searchString + 'dealArrangementSaMe:' + rmanDealArrangementsSearchObject.dealArrangementSaMe + ',';
        }

        if (rmanDealArrangementsSearchObject.dealArrangementQtr != undefined && rmanDealArrangementsSearchObject.dealArrangementQtr != "") {
            searchString = searchString + 'dealArrangementQtr:' + rmanDealArrangementsSearchObject.dealArrangementQtr + ',';
        }

        if (rmanDealArrangementsSearchObject.dealArrangementStatus != undefined && rmanDealArrangementsSearchObject.dealArrangementStatus != "") {
            searchString = searchString + 'dealArrangementStatus:' + rmanDealArrangementsSearchObject.dealArrangementStatus + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute1 != undefined && rmanDealArrangementsSearchObject.attribute1 != "") {
            searchString = searchString + 'attribute1:' + rmanDealArrangementsSearchObject.attribute1 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute2 != undefined && rmanDealArrangementsSearchObject.attribute2 != "") {
            searchString = searchString + 'attribute2:' + rmanDealArrangementsSearchObject.attribute2 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute3 != undefined && rmanDealArrangementsSearchObject.attribute3 != "") {
            searchString = searchString + 'attribute3:' + rmanDealArrangementsSearchObject.attribute3 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute4 != undefined && rmanDealArrangementsSearchObject.attribute4 != "") {
            searchString = searchString + 'attribute4:' + rmanDealArrangementsSearchObject.attribute4 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute5 != undefined && rmanDealArrangementsSearchObject.attribute5 != "") {
            searchString = searchString + 'attribute5:' + rmanDealArrangementsSearchObject.attribute5 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute6 != undefined && rmanDealArrangementsSearchObject.attribute6 != "") {
            searchString = searchString + 'attribute6:' + rmanDealArrangementsSearchObject.attribute6 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute7 != undefined && rmanDealArrangementsSearchObject.attribute7 != "") {
            searchString = searchString + 'attribute7:' + rmanDealArrangementsSearchObject.attribute7 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute8 != undefined && rmanDealArrangementsSearchObject.attribute8 != "") {
            searchString = searchString + 'attribute8:' + rmanDealArrangementsSearchObject.attribute8 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute9 != undefined && rmanDealArrangementsSearchObject.attribute9 != "") {
            searchString = searchString + 'attribute9:' + rmanDealArrangementsSearchObject.attribute9 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute10 != undefined && rmanDealArrangementsSearchObject.attribute10 != "") {
            searchString = searchString + 'attribute10:' + rmanDealArrangementsSearchObject.attribute10 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute11 != undefined && rmanDealArrangementsSearchObject.attribute11 != "") {
            searchString = searchString + 'attribute11:' + rmanDealArrangementsSearchObject.attribute11 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute12 != undefined && rmanDealArrangementsSearchObject.attribute12 != "") {
            searchString = searchString + 'attribute12:' + rmanDealArrangementsSearchObject.attribute12 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute13 != undefined && rmanDealArrangementsSearchObject.attribute13 != "") {
            searchString = searchString + 'attribute13:' + rmanDealArrangementsSearchObject.attribute13 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute14 != undefined && rmanDealArrangementsSearchObject.attribute14 != "") {
            searchString = searchString + 'attribute14:' + rmanDealArrangementsSearchObject.attribute14 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute15 != undefined && rmanDealArrangementsSearchObject.attribute15 != "") {
            searchString = searchString + 'attribute15:' + rmanDealArrangementsSearchObject.attribute15 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute16 != undefined && rmanDealArrangementsSearchObject.attribute16 != "") {
            searchString = searchString + 'attribute16:' + rmanDealArrangementsSearchObject.attribute16 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute17 != undefined && rmanDealArrangementsSearchObject.attribute17 != "") {
            searchString = searchString + 'attribute17:' + rmanDealArrangementsSearchObject.attribute17 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute18 != undefined && rmanDealArrangementsSearchObject.attribute18 != "") {
            searchString = searchString + 'attribute18:' + rmanDealArrangementsSearchObject.attribute18 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute19 != undefined && rmanDealArrangementsSearchObject.attribute19 != "") {
            searchString = searchString + 'attribute19:' + rmanDealArrangementsSearchObject.attribute19 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute20 != undefined && rmanDealArrangementsSearchObject.attribute20 != "") {
            searchString = searchString + 'attribute20:' + rmanDealArrangementsSearchObject.attribute20 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute21 != undefined && rmanDealArrangementsSearchObject.attribute21 != "") {
            searchString = searchString + 'attribute21:' + rmanDealArrangementsSearchObject.attribute21 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute22 != undefined && rmanDealArrangementsSearchObject.attribute22 != "") {
            searchString = searchString + 'attribute22:' + rmanDealArrangementsSearchObject.attribute22 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute23 != undefined && rmanDealArrangementsSearchObject.attribute23 != "") {
            searchString = searchString + 'attribute23:' + rmanDealArrangementsSearchObject.attribute23 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute24 != undefined && rmanDealArrangementsSearchObject.attribute24 != "") {
            searchString = searchString + 'attribute24:' + rmanDealArrangementsSearchObject.attribute24 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute25 != undefined && rmanDealArrangementsSearchObject.attribute25 != "") {
            searchString = searchString + 'attribute25:' + rmanDealArrangementsSearchObject.attribute25 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute26 != undefined && rmanDealArrangementsSearchObject.attribute26 != "") {
            searchString = searchString + 'attribute26:' + rmanDealArrangementsSearchObject.attribute26 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute27 != undefined && rmanDealArrangementsSearchObject.attribute27 != "") {
            searchString = searchString + 'attribute27:' + rmanDealArrangementsSearchObject.attribute27 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute28 != undefined && rmanDealArrangementsSearchObject.attribute28 != "") {
            searchString = searchString + 'attribute28:' + rmanDealArrangementsSearchObject.attribute28 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute29 != undefined && rmanDealArrangementsSearchObject.attribute29 != "") {
            searchString = searchString + 'attribute29:' + rmanDealArrangementsSearchObject.attribute29 + ',';
        }

        if (rmanDealArrangementsSearchObject.attribute30 != undefined && rmanDealArrangementsSearchObject.attribute30 != "") {
            searchString = searchString + 'attribute30:' + rmanDealArrangementsSearchObject.attribute30 + ',';
        }

        if (rmanDealArrangementsSearchObject.creationDate != undefined && rmanDealArrangementsSearchObject.creationDate != "") {
            searchString = searchString + 'creationDate:' + rmanDealArrangementsSearchObject.creationDate + ',';
        }

        if (rmanDealArrangementsSearchObject.createdBy != undefined && rmanDealArrangementsSearchObject.createdBy != "") {
            searchString = searchString + 'createdBy:' + rmanDealArrangementsSearchObject.createdBy + ',';
        }

        if (rmanDealArrangementsSearchObject.lastUpdateDate != undefined && rmanDealArrangementsSearchObject.lastUpdateDate != "") {
            searchString = searchString + 'lastUpdateDate:' + rmanDealArrangementsSearchObject.lastUpdateDate + ',';
        }

        if (rmanDealArrangementsSearchObject.lastUpdatedBy != undefined && rmanDealArrangementsSearchObject.lastUpdatedBy != "") {
            searchString = searchString + 'lastUpdatedBy:' + rmanDealArrangementsSearchObject.lastUpdatedBy + ',';
        }

        if (rmanDealArrangementsSearchObject.dealArrangementType != undefined && rmanDealArrangementsSearchObject.dealArrangementType != "") {
            searchString = searchString + 'dealArrangementType:' + rmanDealArrangementsSearchObject.dealArrangementType + ',';
        }

        if (rmanDealArrangementsSearchObject.legalEntityName != undefined && rmanDealArrangementsSearchObject.legalEntityName != "") {
            searchString = searchString + 'legalEntityName:' + rmanDealArrangementsSearchObject.legalEntityName + ',';
        }

        if (rmanDealArrangementsSearchObject.legalEntityId != undefined && rmanDealArrangementsSearchObject.legalEntityId != "") {
            searchString = searchString + 'legalEntityId:' + rmanDealArrangementsSearchObject.legalEntityId + ',';
        }

        if (rmanDealArrangementsSearchObject.dealArrangementTotal != undefined && rmanDealArrangementsSearchObject.dealArrangementTotal != "") {
            searchString = searchString + 'dealArrangementTotal:' + rmanDealArrangementsSearchObject.dealArrangementTotal + ',';
        }

        if (rmanDealArrangementsSearchObject.endCustomerName != undefined && rmanDealArrangementsSearchObject.endCustomerName != "") {
            searchString = searchString + 'endCustomerName:' + rmanDealArrangementsSearchObject.endCustomerName + ',';
        }

        if (rmanDealArrangementsSearchObject.endCustomerNumber != undefined && rmanDealArrangementsSearchObject.endCustomerNumber != "") {
            searchString = searchString + 'endCustomerNumber:' + rmanDealArrangementsSearchObject.endCustomerNumber + ',';
        }

        if (rmanDealArrangementsSearchObject.dealArrangementBasis != undefined && rmanDealArrangementsSearchObject.dealArrangementBasis != "") {
            searchString = searchString + 'dealArrangementBasis:' + rmanDealArrangementsSearchObject.dealArrangementBasis + ',';
        }

        if (rmanDealArrangementsSearchObject.dealArrangementSource != undefined && rmanDealArrangementsSearchObject.dealArrangementSource != "") {
            searchString = searchString + 'dealArrangementSource:' + rmanDealArrangementsSearchObject.dealArrangementSource + ',';
        }

        if (rmanDealArrangementsSearchObject.dealAgreementId != undefined && rmanDealArrangementsSearchObject.dealAgreementId != "") {
            searchString = searchString + 'dealAgreementId:' + rmanDealArrangementsSearchObject.dealAgreementId + ',';
        }

        if (rmanDealArrangementsSearchObject.dealId != undefined && rmanDealArrangementsSearchObject.dealId != "") {
            searchString = searchString + 'dealId:' + rmanDealArrangementsSearchObject.dealId + ',';
        }

        if (rmanDealArrangementsSearchObject.dealNumber != undefined && rmanDealArrangementsSearchObject.dealNumber != "") {
            searchString = searchString + 'dealNumber:' + rmanDealArrangementsSearchObject.dealNumber + ',';
        }

        if (rmanDealArrangementsSearchObject.dealCosedDate != undefined && rmanDealArrangementsSearchObject.dealCosedDate != "") {
            searchString = searchString + 'dealCosedDate:' + rmanDealArrangementsSearchObject.dealCosedDate + ',';
        }

        if (rmanDealArrangementsSearchObject.dealApprovalDate != undefined && rmanDealArrangementsSearchObject.dealApprovalDate != "") {
            searchString = searchString + 'dealApprovalDate:' + rmanDealArrangementsSearchObject.dealApprovalDate + ',';
        }

        if (rmanDealArrangementsSearchObject.dealApprovedBy != undefined && rmanDealArrangementsSearchObject.dealApprovedBy != "") {
            searchString = searchString + 'dealApprovedBy:' + rmanDealArrangementsSearchObject.dealApprovedBy + ',';
        }

        if (rmanDealArrangementsSearchObject.msaNumber != undefined && rmanDealArrangementsSearchObject.msaNumber != "") {
            searchString = searchString + 'msaNumber:' + rmanDealArrangementsSearchObject.msaNumber + ',';
        }

        if (rmanDealArrangementsSearchObject.salesNodeLevel1 != undefined && rmanDealArrangementsSearchObject.salesNodeLevel1 != "") {
            searchString = searchString + 'salesNodeLevel1:' + rmanDealArrangementsSearchObject.salesNodeLevel1 + ',';
        }

        if (rmanDealArrangementsSearchObject.salesNodeLevel2 != undefined && rmanDealArrangementsSearchObject.salesNodeLevel2 != "") {
            searchString = searchString + 'salesNodeLevel2:' + rmanDealArrangementsSearchObject.salesNodeLevel2 + ',';
        }

        if (rmanDealArrangementsSearchObject.salesNodeLevel3 != undefined && rmanDealArrangementsSearchObject.salesNodeLevel3 != "") {
            searchString = searchString + 'salesNodeLevel3:' + rmanDealArrangementsSearchObject.salesNodeLevel3 + ',';
        }

        if (rmanDealArrangementsSearchObject.salesNodeLevel4 != undefined && rmanDealArrangementsSearchObject.salesNodeLevel4 != "") {
            searchString = searchString + 'salesNodeLevel4:' + rmanDealArrangementsSearchObject.salesNodeLevel4 + ',';
        }

        if (rmanDealArrangementsSearchObject.arrangementCurrency != undefined && rmanDealArrangementsSearchObject.arrangementCurrency != "") {
            searchString = searchString + 'arrangementCurrency:' + rmanDealArrangementsSearchObject.arrangementCurrency + ',';
        }

        if (rmanDealArrangementsSearchObject.revAccountantId != undefined && rmanDealArrangementsSearchObject.revAccountantId != "") {
            searchString = searchString + 'revAccountantId:' + rmanDealArrangementsSearchObject.revAccountantId + ',';
        }

        if (rmanDealArrangementsSearchObject.revManagerId != undefined && rmanDealArrangementsSearchObject.revManagerId != "") {
            searchString = searchString + 'revManagerId:' + rmanDealArrangementsSearchObject.revManagerId + ',';
        }

        if (rmanDealArrangementsSearchObject.salesContact != undefined && rmanDealArrangementsSearchObject.salesContact != "") {
            searchString = searchString + 'salesContact:' + rmanDealArrangementsSearchObject.salesContact + ',';
        }

        if (rmanDealArrangementsSearchObject.customerContact != undefined && rmanDealArrangementsSearchObject.customerContact != "") {
            searchString = searchString + 'customerContact:' + rmanDealArrangementsSearchObject.customerContact + ',';
        }

        if (rmanDealArrangementsSearchObject.dealAgreementName != undefined && rmanDealArrangementsSearchObject.dealAgreementName != "") {
            searchString = searchString + 'dealAgreementName:' + rmanDealArrangementsSearchObject.dealAgreementName + ',';
        }

        if (rmanDealArrangementsSearchObject.reasonCode != undefined && rmanDealArrangementsSearchObject.reasonCode != "") {
            searchString = searchString + 'reasonCode:' + rmanDealArrangementsSearchObject.reasonCode + ',';
        }

        if (rmanDealArrangementsSearchObject.allocationEligible != undefined && rmanDealArrangementsSearchObject.allocationEligible != "") {
            searchString = searchString + 'allocationEligible:' + rmanDealArrangementsSearchObject.allocationEligible + ',';
        }

        if (rmanDealArrangementsSearchObject.msaName != undefined && rmanDealArrangementsSearchObject.msaName != "") {
            searchString = searchString + 'msaName:' + rmanDealArrangementsSearchObject.msaName + ',';
        }

        if (rmanDealArrangementsSearchObject.dealArrangementNumber != undefined && rmanDealArrangementsSearchObject.dealArrangementNumber != "") {
            searchString = searchString + 'dealArrangementNumber:' + rmanDealArrangementsSearchObject.dealArrangementNumber + ',';
        }

        if (rmanDealArrangementsSearchObject.dealName != undefined && rmanDealArrangementsSearchObject.dealName != "") {
            searchString = searchString + 'dealName:' + rmanDealArrangementsSearchObject.dealName + ',';
        }

        if (rmanDealArrangementsSearchObject.changeReason != undefined && rmanDealArrangementsSearchObject.changeReason != "") {
            searchString = searchString + 'changeReason:' + rmanDealArrangementsSearchObject.changeReason + ',';
        }

        if (rmanDealArrangementsSearchObject.masterArrgFlag != undefined && rmanDealArrangementsSearchObject.masterArrgFlag != "") {
            searchString = searchString + 'masterArrgFlag:' + rmanDealArrangementsSearchObject.masterArrgFlag + ',';
        }

        if (rmanDealArrangementsSearchObject.masterArrgId != undefined && rmanDealArrangementsSearchObject.masterArrgId != "") {
            searchString = searchString + 'masterArrgId:' + rmanDealArrangementsSearchObject.masterArrgId + ',';
        }

        if (rmanDealArrangementsSearchObject.masterArrgName != undefined && rmanDealArrangementsSearchObject.masterArrgName != "") {
            searchString = searchString + 'masterArrgName:' + rmanDealArrangementsSearchObject.masterArrgName;
        }



        if (searchString == '') {
            serviceUrl = serviceUrl + 'search=%25';
        }
        else {
            serviceUrl = serviceUrl + 'search=' + searchString;
        }

        if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber != 0) {
            serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
        }

        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    saveRmanDealArrangements(rmanDealArrangements: any): Promise<any[]> {
        let body = JSON.stringify(rmanDealArrangements);
        return this.http.post(appSettings.apiUrl + '/RMAN_DEAL_ARRANGEMENTS', body, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

    updateRmanDealArrangements(rmanDealArrangements: any): Promise<any[]> {

        delete rmanDealArrangements._links;
        delete rmanDealArrangements.interests;
        let body = JSON.stringify(rmanDealArrangements);
        return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_DEAL_ARRANGEMENTS/' + rmanDealArrangements.dealArrangementId, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanDealArrangements(rmanDealArrangements: any): Promise<any[]> {
        let deleteUrl = appSettings.apiUrl + '/RMAN_DEAL_ARRANGEMENTS/' + rmanDealArrangements.dealArrangementId;
        return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

}
