import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
declare var require: any;
const appSettings = require('../appsettings');


@Injectable()
export class RmanArrgWaterfallReportVService {

    constructor(private http: HttpClient) { }

    getAllRmanArrgWaterfallReportV(paginationOptions: any, rmanArrgWaterfallReportV: any): Promise<any[]> {

        let serviceUrl = appSettings.apiUrl + '/rmanArrgWaterfallReportNvSearch?';

        let searchString = '';

        if (searchString == '') {
            serviceUrl = serviceUrl + 'search=%25';
        }
        else {
            serviceUrl = serviceUrl + 'search=' + searchString;
        }

        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    getRmanWaterFallDetailsReport(fromArrgId: any, toArrgId: any, fromPeriod: any, toPeriod: any, po: any, so: any, legalEntity: any) {

        if (fromPeriod == undefined) {
            fromPeriod = '';
        }
        if (toPeriod == undefined) {
            toPeriod = '';
        }
        if (po == undefined) {
            po = '';
        }
        if (so == undefined) {
            so = '';
        }
        if (legalEntity == undefined) {
            legalEntity = '';
        }
        if (fromArrgId == undefined) {
            fromArrgId = 0;
        }
        if (toArrgId == undefined) {
            toArrgId = 0;
        }

        let serviceUrl = appSettings.apiUrl + '/revmantra/wfr/?fromArrgId=' + fromArrgId + '&toArrgId=' + toArrgId + '&fromPeriod=' + fromPeriod + '&toPeriod=' + toPeriod + '&po=' + po + '&so=' + so + '&legalEntity=' + legalEntity;
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    getRmanWaterFallDetailsReportFile(fromArrgId: any, toArrgId: any, fromPeriod: any, toPeriod: any, po: any, so: any, legalEntity: any, exportCols: any) {

        if (fromPeriod == undefined) {
            fromPeriod = '';
        }
        if (toPeriod == undefined) {
            toPeriod = '';
        }
        if (so == undefined) {
            so = '';
        }
        if (po == undefined) {
            po = '';
        }
        if (legalEntity == undefined) {
            legalEntity = '';
        }
        if (fromArrgId == undefined) {
            fromArrgId = 0;
        }
        if (toArrgId == undefined) {
            toArrgId = 0;
        }

        let serviceUrl = appSettings.apiUrl + '/exportWFReport?fromArrgId=' + fromArrgId + '&toArrgId=' + toArrgId + '&fromPeriod=' + fromPeriod + '&toPeriod=' + toPeriod + '&po=' + po + '&so=' + so + '&legalEntity=' + legalEntity;

        if (exportCols != undefined && exportCols != "") {
            serviceUrl = serviceUrl + '&exportCols=' + exportCols;
        }
        return serviceUrl;
    }
}
