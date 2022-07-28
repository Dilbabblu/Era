import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
declare var require:any;
const appSettings = require('../appsettings');

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
  })
};

@Injectable()
export class CommonSharedService {
    // notifyRole= new Subject<any>();
    notifyRole= new BehaviorSubject<any>(null);
    readAccess = new BehaviorSubject<string>(null);
    dismissPwdCmp    = new Subject<any>();
    allPermissions = [];
    roleList = [];
    stickyToast:boolean = true;
    
    constructor(private httpClient: HttpClient) {}

    setRoleBasedPermissions(permissions:any){
      this.allPermissions = permissions;
    }
	    
    setRole(data: any){
        this.roleList = data;
        this.notifyRole.next(data);
    }

    getRole(): Observable<any> {
      return  this.notifyRole.asObservable();
    }

    setDismissPwdComponent(data){      
      this.dismissPwdCmp.next(data);
    }

    getDismissPwdComponent(): Observable<any>{            
      return  this.dismissPwdCmp.asObservable();
    }

    saveOrUpdateTableColumns(pageName: string, tableName: string, cols: string, userId: number) {
      const reqObj = {
        "pageName": pageName,
        "tableName": tableName,
        "tableColumns": cols
      };
      if (!userId) {
        const serviceUrl = `${appSettings.apiUrl}/saveAyaraUserTableCoulmns`;
        return this.httpClient.post<any[]>(serviceUrl, reqObj, httpOptions).toPromise().then(data => {
          return data;
        });
      } else {
        reqObj["userId"] = userId;
        const serviceUrl = `${appSettings.apiUrl}/updateAyaraUserTableCoulmns`;
        return this.httpClient.put<any[]>(serviceUrl, reqObj, httpOptions).toPromise().then(data => {
          return data;
        });
      }  
    }

    getConfiguredColDetails(pageName: string, tableName: string) {
      const serviceUrl = `${appSettings.apiUrl}/ayaraUserTableColumns?pageName=${pageName}&tableName=${tableName}`;
      return this.httpClient.get(serviceUrl).toPromise().then((data: any) => {
        return data;
      });
    }
}