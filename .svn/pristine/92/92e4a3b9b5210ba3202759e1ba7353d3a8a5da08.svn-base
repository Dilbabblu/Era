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
export class RmanProductsService {

    constructor(private http: HttpClient) { }

    getAllRmanProducts(paginationOptions: any, rmanProductsSearchObject: any, fetchAll:any) {
        let serviceUrl = appSettings.apiUrl + '/rmanProductsSearch?';

        let searchString = '';

        if(fetchAll){
            serviceUrl = serviceUrl + 'fetchAll=true&'
        }

        if (rmanProductsSearchObject.productId != undefined && rmanProductsSearchObject.productId != "") {
            searchString = searchString + 'productId:' + rmanProductsSearchObject.productId + ',';
        }

        if (rmanProductsSearchObject.productName != undefined && rmanProductsSearchObject.productName != "") {
            searchString = searchString + 'productName:' + rmanProductsSearchObject.productName + ',';
        }

        if (rmanProductsSearchObject.productDescription != undefined && rmanProductsSearchObject.productDescription != "") {
            searchString = searchString + 'productDescription:' + rmanProductsSearchObject.productDescription + ',';
        }

        if (rmanProductsSearchObject.productOrgId != undefined && rmanProductsSearchObject.productOrgId != "") {
            searchString = searchString + 'productOrgId:' + rmanProductsSearchObject.productOrgId + ',';
        }

        if (rmanProductsSearchObject.productOrgName != undefined && rmanProductsSearchObject.productOrgName != "") {
            searchString = searchString + 'productOrgName:' + rmanProductsSearchObject.productOrgName + ',';
        }

        if (rmanProductsSearchObject.productOrgCode != undefined && rmanProductsSearchObject.productOrgCode != "") {
            searchString = searchString + 'productOrgCode:' + rmanProductsSearchObject.productOrgCode + ',';
        }

        if (rmanProductsSearchObject.productStatus != undefined && rmanProductsSearchObject.productStatus != "") {
            searchString = searchString + 'productStatus:' + rmanProductsSearchObject.productStatus + ',';
        }

        if (rmanProductsSearchObject.productType != undefined && rmanProductsSearchObject.productType != "") {
            searchString = searchString + 'productType:' + rmanProductsSearchObject.productType + ',';
        }

        if (rmanProductsSearchObject.productCost != undefined && rmanProductsSearchObject.productCost != "") {
            searchString = searchString + 'productCost:' + rmanProductsSearchObject.productCost + ',';
        }

        if (rmanProductsSearchObject.productRevAccount != undefined && rmanProductsSearchObject.productRevAccount != "") {
            searchString = searchString + 'productRevAccount:' + rmanProductsSearchObject.productRevAccount + ',';
        }

        if (rmanProductsSearchObject.shippableFlag != undefined && rmanProductsSearchObject.shippableFlag != "") {
            searchString = searchString + 'shippableFlag:' + rmanProductsSearchObject.shippableFlag + ',';
        }

        if (rmanProductsSearchObject.attribute1 != undefined && rmanProductsSearchObject.attribute1 != "") {
            searchString = searchString + 'attribute1:' + rmanProductsSearchObject.attribute1 + ',';
        }

        if (rmanProductsSearchObject.attribute2 != undefined && rmanProductsSearchObject.attribute2 != "") {
            searchString = searchString + 'attribute2:' + rmanProductsSearchObject.attribute2 + ',';
        }

        if (rmanProductsSearchObject.attribute3 != undefined && rmanProductsSearchObject.attribute3 != "") {
            searchString = searchString + 'attribute3:' + rmanProductsSearchObject.attribute3 + ',';
        }

        if (rmanProductsSearchObject.attribute4 != undefined && rmanProductsSearchObject.attribute4 != "") {
            searchString = searchString + 'attribute4:' + rmanProductsSearchObject.attribute4 + ',';
        }

        if (rmanProductsSearchObject.attribute5 != undefined && rmanProductsSearchObject.attribute5 != "") {
            searchString = searchString + 'attribute5:' + rmanProductsSearchObject.attribute5 + ',';
        }

        if (rmanProductsSearchObject.attribute6 != undefined && rmanProductsSearchObject.attribute6 != "") {
            searchString = searchString + 'attribute6:' + rmanProductsSearchObject.attribute6 + ',';
        }

        if (rmanProductsSearchObject.attribute7 != undefined && rmanProductsSearchObject.attribute7 != "") {
            searchString = searchString + 'attribute7:' + rmanProductsSearchObject.attribute7 + ',';
        }

        if (rmanProductsSearchObject.attribute8 != undefined && rmanProductsSearchObject.attribute8 != "") {
            searchString = searchString + 'attribute8:' + rmanProductsSearchObject.attribute8 + ',';
        }

        if (rmanProductsSearchObject.attribute9 != undefined && rmanProductsSearchObject.attribute9 != "") {
            searchString = searchString + 'attribute9:' + rmanProductsSearchObject.attribute9 + ',';
        }

        if (rmanProductsSearchObject.attribute10 != undefined && rmanProductsSearchObject.attribute10 != "") {
            searchString = searchString + 'attribute10:' + rmanProductsSearchObject.attribute10 + ',';
        }

        if (rmanProductsSearchObject.attribute11 != undefined && rmanProductsSearchObject.attribute11 != "") {
            searchString = searchString + 'attribute11:' + rmanProductsSearchObject.attribute11 + ',';
        }

        if (rmanProductsSearchObject.attribute12 != undefined && rmanProductsSearchObject.attribute12 != "") {
            searchString = searchString + 'attribute12:' + rmanProductsSearchObject.attribute12 + ',';
        }

        if (rmanProductsSearchObject.attribute13 != undefined && rmanProductsSearchObject.attribute13 != "") {
            searchString = searchString + 'attribute13:' + rmanProductsSearchObject.attribute13 + ',';
        }

        if (rmanProductsSearchObject.attribute14 != undefined && rmanProductsSearchObject.attribute14 != "") {
            searchString = searchString + 'attribute14:' + rmanProductsSearchObject.attribute14 + ',';
        }

        if (rmanProductsSearchObject.attribute15 != undefined && rmanProductsSearchObject.attribute15 != "") {
            searchString = searchString + 'attribute15:' + rmanProductsSearchObject.attribute15 + ',';
        }

        if (rmanProductsSearchObject.attribute16 != undefined && rmanProductsSearchObject.attribute16 != "") {
            searchString = searchString + 'attribute16:' + rmanProductsSearchObject.attribute16 + ',';
        }

        if (rmanProductsSearchObject.attribute17 != undefined && rmanProductsSearchObject.attribute17 != "") {
            searchString = searchString + 'attribute17:' + rmanProductsSearchObject.attribute17 + ',';
        }

        if (rmanProductsSearchObject.attribute18 != undefined && rmanProductsSearchObject.attribute18 != "") {
            searchString = searchString + 'attribute18:' + rmanProductsSearchObject.attribute18 + ',';
        }

        if (rmanProductsSearchObject.attribute19 != undefined && rmanProductsSearchObject.attribute19 != "") {
            searchString = searchString + 'attribute19:' + rmanProductsSearchObject.attribute19 + ',';
        }

        if (rmanProductsSearchObject.attribute20 != undefined && rmanProductsSearchObject.attribute20 != "") {
            searchString = searchString + 'attribute20:' + rmanProductsSearchObject.attribute20 + ',';
        }

        if (rmanProductsSearchObject.attribute21 != undefined && rmanProductsSearchObject.attribute21 != "") {
            searchString = searchString + 'attribute21:' + rmanProductsSearchObject.attribute21 + ',';
        }

        if (rmanProductsSearchObject.attribute22 != undefined && rmanProductsSearchObject.attribute22 != "") {
            searchString = searchString + 'attribute22:' + rmanProductsSearchObject.attribute22 + ',';
        }

        if (rmanProductsSearchObject.attribute23 != undefined && rmanProductsSearchObject.attribute23 != "") {
            searchString = searchString + 'attribute23:' + rmanProductsSearchObject.attribute23 + ',';
        }

        if (rmanProductsSearchObject.attribute24 != undefined && rmanProductsSearchObject.attribute24 != "") {
            searchString = searchString + 'attribute24:' + rmanProductsSearchObject.attribute24 + ',';
        }

        if (rmanProductsSearchObject.attribute25 != undefined && rmanProductsSearchObject.attribute25 != "") {
            searchString = searchString + 'attribute25:' + rmanProductsSearchObject.attribute25 + ',';
        }

        if (rmanProductsSearchObject.attribute26 != undefined && rmanProductsSearchObject.attribute26 != "") {
            searchString = searchString + 'attribute26:' + rmanProductsSearchObject.attribute26 + ',';
        }

        if (rmanProductsSearchObject.attribute27 != undefined && rmanProductsSearchObject.attribute27 != "") {
            searchString = searchString + 'attribute27:' + rmanProductsSearchObject.attribute27 + ',';
        }

        if (rmanProductsSearchObject.attribute28 != undefined && rmanProductsSearchObject.attribute28 != "") {
            searchString = searchString + 'attribute28:' + rmanProductsSearchObject.attribute28 + ',';
        }

        if (rmanProductsSearchObject.attribute29 != undefined && rmanProductsSearchObject.attribute29 != "") {
            searchString = searchString + 'attribute29:' + rmanProductsSearchObject.attribute29 + ',';
        }

        if (rmanProductsSearchObject.attribute30 != undefined && rmanProductsSearchObject.attribute30 != "") {
            searchString = searchString + 'attribute30:' + rmanProductsSearchObject.attribute30 + ',';
        }

        if (rmanProductsSearchObject.creationDate != undefined && rmanProductsSearchObject.creationDate != "") {
            searchString = searchString + 'creationDate:' + rmanProductsSearchObject.creationDate + ',';
        }

        if (rmanProductsSearchObject.createdBy != undefined && rmanProductsSearchObject.createdBy != "") {
            searchString = searchString + 'createdBy:' + rmanProductsSearchObject.createdBy + ',';
        }

        if (rmanProductsSearchObject.lastUpdateDate != undefined && rmanProductsSearchObject.lastUpdateDate != "") {
            searchString = searchString + 'lastUpdateDate:' + rmanProductsSearchObject.lastUpdateDate + ',';
        }

        if (rmanProductsSearchObject.lastUpdatedBy != undefined && rmanProductsSearchObject.lastUpdatedBy != "") {
            searchString = searchString + 'lastUpdatedBy:' + rmanProductsSearchObject.lastUpdatedBy + ',';
        }

        if (rmanProductsSearchObject.sourceProductId != undefined && rmanProductsSearchObject.sourceProductId != "") {
            searchString = searchString + 'sourceProductId:' + rmanProductsSearchObject.sourceProductId + ',';
        }

        if (rmanProductsSearchObject.source != undefined && rmanProductsSearchObject.source != "") {
            searchString = searchString + 'source:' + rmanProductsSearchObject.source + ',';
        }

        if (rmanProductsSearchObject.revenueCategory != undefined && rmanProductsSearchObject.revenueCategory != "") {
            searchString = searchString + 'revenueCategory:' + rmanProductsSearchObject.revenueCategory + ',';
        }

        if (rmanProductsSearchObject.acctRuleName != undefined && rmanProductsSearchObject.acctRuleName != "") {
            searchString = searchString + 'acctRuleName:' + rmanProductsSearchObject.acctRuleName + ',';
        }

        if (rmanProductsSearchObject.allocationFlag != undefined && rmanProductsSearchObject.allocationFlag != "") {
            searchString = searchString + 'allocationFlag:' + rmanProductsSearchObject.allocationFlag + ',';
        }

        if (rmanProductsSearchObject.elementType != undefined && rmanProductsSearchObject.elementType != "") {
            searchString = searchString + 'elementType:' + rmanProductsSearchObject.elementType + ',';
        }

        if (rmanProductsSearchObject.directCv != undefined && rmanProductsSearchObject.directCv != "") {
            searchString = searchString + 'directCv:' + rmanProductsSearchObject.directCv + ',';
        }

        if (rmanProductsSearchObject.cvPercent != undefined && rmanProductsSearchObject.cvPercent != "") {
            searchString = searchString + 'cvPercent:' + rmanProductsSearchObject.cvPercent + ',';
        }

        if (rmanProductsSearchObject.fvOptional != undefined && rmanProductsSearchObject.fvOptional != "") {
            searchString = searchString + 'fvOptional:' + rmanProductsSearchObject.fvOptional + ',';
        }

        if (rmanProductsSearchObject.revAccountId != undefined && rmanProductsSearchObject.revAccountId != "") {
            searchString = searchString + 'revAccountId:' + rmanProductsSearchObject.revAccountId + ',';
        }

        if (rmanProductsSearchObject.cogsAccountId != undefined && rmanProductsSearchObject.cogsAccountId != "") {
            searchString = searchString + 'cogsAccountId:' + rmanProductsSearchObject.cogsAccountId + ',';
        }

        if (rmanProductsSearchObject.productCogsAccount != undefined && rmanProductsSearchObject.productCogsAccount != "") {
            searchString = searchString + 'productCogsAccount:' + rmanProductsSearchObject.productCogsAccount + ',';
        }

        if (rmanProductsSearchObject.allowRevrecWoInvoice != undefined && rmanProductsSearchObject.allowRevrecWoInvoice != "") {
            searchString = searchString + 'allowRevrecWoInvoice:' + rmanProductsSearchObject.allowRevrecWoInvoice + ',';
        }

        if (rmanProductsSearchObject.revrecType != undefined && rmanProductsSearchObject.revrecType != "") {
            searchString = searchString + 'revrecType:' + rmanProductsSearchObject.revrecType + ',';
        }

        if (rmanProductsSearchObject.bundleFlag != undefined && rmanProductsSearchObject.bundleFlag != "") {
            searchString = searchString + 'bundleFlag:' + rmanProductsSearchObject.bundleFlag + ',';
        }

        if (rmanProductsSearchObject.uom != undefined && rmanProductsSearchObject.uom != "") {
            searchString = searchString + 'uom:' + rmanProductsSearchObject.uom + ',';
        }

        if (rmanProductsSearchObject.startDate != undefined && rmanProductsSearchObject.startDate != "") {
            searchString = searchString + 'startDate:' + rmanProductsSearchObject.startDate + ',';
        }

        if (rmanProductsSearchObject.endDate != undefined && rmanProductsSearchObject.endDate != "") {
            searchString = searchString + 'endDate:' + rmanProductsSearchObject.endDate + ',';
        }

        if (rmanProductsSearchObject.invoiceEnabledFlag != undefined && rmanProductsSearchObject.invoiceEnabledFlag != "") {
            searchString = searchString + 'invoiceEnabledFlag:' + rmanProductsSearchObject.invoiceEnabledFlag + ',';
        }

        if (rmanProductsSearchObject.revenueTemplateId != undefined && rmanProductsSearchObject.revenueTemplateId != "") {
            searchString = searchString + 'revenueTemplateId:' + rmanProductsSearchObject.revenueTemplateId + ',';
        }

        if (rmanProductsSearchObject.residualValue != undefined && rmanProductsSearchObject.residualValue != "") {
            searchString = searchString + 'residualValue:' + rmanProductsSearchObject.residualValue;
        }



        if (searchString == '') {
            serviceUrl = serviceUrl + 'search=%25';
        }
        else {
            serviceUrl = serviceUrl + 'search=' + searchString;
        }

        if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber)) {
            serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
        }

        return this.http.get(serviceUrl).toPromise().then(data => {
            return data;
        });
    }



    saveRmanProducts(rmanProducts: any) {
        let body = JSON.stringify(rmanProducts);
        return this.http.post(appSettings.apiUrl + '/RMAN_PRODUCTS', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanProducts(rmanProducts: any) {

        delete rmanProducts._links;
        delete rmanProducts.interests;
        let body = JSON.stringify(rmanProducts);
        return this.http.put(appSettings.apiUrl + '/RMAN_PRODUCTS/' + rmanProducts.productId, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanProducts(rmanProducts: any) {
        let deleteUrl = appSettings.apiUrl + '/RMAN_PRODUCTS/' + rmanProducts.productId;
        return this.http.delete(deleteUrl, httpOptions).toPromise().then(data => {
            return data;
        });
    }

}
