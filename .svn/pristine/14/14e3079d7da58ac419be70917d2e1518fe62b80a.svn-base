import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
declare var require: any;
const appSettings = require('../appsettings');

@Injectable()
export class ConcurrentProgramsService {

  constructor(private http: HttpClient) { }

  executeConcurrentprogram(programName: any): Promise<any[]> {
    let releaseUrl: any;
    if (programName == 'PROCESS_DEALS') {
      releaseUrl = appSettings.apiUrl + '/revmantra/processcontracts';
    } else if (programName == 'PROCESS_BILLINGS') {
      releaseUrl = appSettings.apiUrl + '/revmantra/processbillings';
    } else if (programName == 'IMPORT_BOOKINGS') {
      releaseUrl = appSettings.apiUrl + '/revmantra/importbookings';
    } else if (programName == 'IMPORT_DISTRIBUTIONS') {
      releaseUrl = appSettings.apiUrl + '/revmantra/importdistributions';
    } else if (programName == 'PROCESS_CONT_RELEASE') {
      releaseUrl = appSettings.apiUrl + '/revmantra/contrelease';
    } else if (programName == 'PROCESS_FMV_DEALS') {
      releaseUrl = appSettings.apiUrl + '/revmantra/dealFMVSubmitProcess';
    } else if (programName == 'PROCESS_VC_UPDATE') {
      releaseUrl = appSettings.apiUrl + '/revmantra/dealVCUpdateProcess?arrangementId=0';
    } else if (programName == 'PROCESS_DEAL_ALLOCATIONS') {
      releaseUrl = appSettings.apiUrl + '/revmantra/dealAllocationProcess?arrangementId=0';
    } else if (programName == 'PROCESS_UPDATE_POB') {
      releaseUrl = appSettings.apiUrl + '/revmantra/dealPOBUpdateProcess';
    } else if (programName == 'IMPORT_ORDER_EVENTS') {
      releaseUrl = appSettings.apiUrl + '/revmantra/processEvents';
    } else if (programName == 'LT_ST_REVERSE_ENTRY') {
      releaseUrl = appSettings.apiUrl + '/revmantra/reverseLTandSTAccountEntry';
    }
    return this.http.post(releaseUrl,null).toPromise().then((data: any) => {
      return data;
    });
  }

  releaseContingency(headerId:any,fromDate:any,toDate:any,customerNumber:any,productGroup:any,
    productFamily:any, productLine:any,orderNumber:any,customerPo:any, releaseDate: any){

      let serviceUrl = appSettings.apiUrl + '/revmantra/releaseContingency?';

      serviceUrl = serviceUrl + 'headerId='+headerId+'&fromDate='+fromDate+'&toDate='+ toDate+
              '&customerNumber='+customerNumber+'&productGroup='+productGroup+'&productFamily='+productFamily+
              '&productLine='+productLine+'&orderNumber='+orderNumber+'&customerPo='+customerPo+'&releaseDate='+releaseDate;

        
      return this.http.post(serviceUrl,null).toPromise().then((data: any) => {
        return data;
      });

  }

  exportArchiveFiles(fileType: any, groupId: any, fileName: any) {
    return appSettings.apiUrl + '/rmanArchiveFileExport?fileType=' + fileType + '&groupId=' + groupId + '&fileName=' + fileName;
  }

  downloadUploadedFile(jobId) {
    return appSettings.apiUrl + '/downloadFile/' + jobId;
  }

  fetchUploadLogs(paginationOptions: any) {
    let uploadJobRunsUrl: any;

    uploadJobRunsUrl = appSettings.apiUrl + '/rmanFileUploadJobsSearch?';

    if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != null && !isNaN(paginationOptions.pageNumber)) {
      uploadJobRunsUrl = uploadJobRunsUrl + 'search=&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;

    } else {
      uploadJobRunsUrl = uploadJobRunsUrl + 'search=%25';
    }

    return this.http.get(uploadJobRunsUrl).toPromise().then((data: any) => {
      return data;
    });
  }

}
