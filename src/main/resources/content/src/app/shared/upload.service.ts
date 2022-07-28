import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NotificationService } from './notifications.service';
declare var require:any;
const appSettings = require('../appsettings');

@Injectable()
export class UploadService {

  uploadLoading:boolean = false;
  uploadDialog:boolean = false;
  displayPBDialog:boolean = false;
  displayshipmentsDialog:boolean = false;
  displayInvDialog:boolean = false;
  displayQuotesDialog: boolean = false;
  displayContRelDialog: boolean = false;
  displayUsageDialog: boolean = false;

  constructor(private http: HttpClient, private notificationService: NotificationService) { }

  processUpload(event: any, serviceUrl){
    this.uploadLoading = true;
    this._callUpload(event.files[0], serviceUrl)
    .subscribe((response:any) => {
      this.uploadLoading = false;
      this.uploadDialog = false;
      this.displayPBDialog = false;
      this.displayshipmentsDialog = false;
      this.displayInvDialog = false;
      this.displayQuotesDialog = false;
      this.displayContRelDialog = false;
      this.displayUsageDialog = false;
    }, error => {
      this.uploadLoading = false;
      this.uploadDialog = false;
      this.displayPBDialog = false;
      this.displayshipmentsDialog = false;
      this.displayInvDialog = false;
      this.displayQuotesDialog = false;
      this.displayContRelDialog = false;
      this.displayUsageDialog = false;
      if(error.error.error){
        if(error.error.text === "Success"){
          this.notificationService.showSuccess("File uploaded successfully.Job is Submitted and will notify you once job completed or Check the Job Status in Jobs Menu.");
        }
        if(error.error.text === "Failed"){
          this.notificationService.showError("File upload failed. Please check file and try again");
        }
      }else{
        this.notificationService.showError(error.error.message);
      }
    });
  }


  private _callUpload(file:any, url:any){
    const formData: FormData = new FormData();
    formData.append('file', file, file.name);
    return this.http.post(appSettings.uploadUrl + url, formData);
  }
}
