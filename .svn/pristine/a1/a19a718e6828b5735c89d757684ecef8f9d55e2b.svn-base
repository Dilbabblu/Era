import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
declare var require:any;
const appSettings = require('../../../appsettings');

@Injectable()
export class AppService {
  httpHeaders = new HttpHeaders();
  categoryCount = 0;

  constructor(private httpClient: HttpClient) {
    this.httpHeaders.append("Content-Type", "application/json");
  }
  create(path, data) {
    return this.httpClient
      //.post("http://localhost:3000/" + path + "/", data, {
       // headers: this.httpHeaders
        .post(appSettings.apiUrl+"/saveTestClob", data, {
      })
      .toPromise()
      .then((response: any) => response);
  }
  update(path, id, data) {
    return this.httpClient
      //.put("http://localhost:3000/" + path + "/" + id, data, {
        //headers: this.httpHeaders
        .put(appSettings.apiUrl+"/updateOneClob", data, {
      })
      .toPromise()
      .then((response: any) => response);
  }
  get(path, id) {
    return this.httpClient
      .get(appSettings.apiUrl+"/getOneClob?id=" + id, {
        //headers: this.httpHeaders
      })
      .toPromise()
      .then((response: any) => response);
  }
  getAll(serviceUrl) {
    return this.httpClient
    //.get("http://localhost:3000/" + path + "/", { headers: this.httpHeaders })
    .get(serviceUrl)
      .toPromise()
      .then((response: any) => response);
  }
  delete(path, id) {
    return this.httpClient
      .delete(appSettings.apiUrl+"/deleteOneClob?id=" + id)
      .toPromise()
      .then((response: any) => response);
  }

  markAndUnmarkAsFavorite(report){
    return this.httpClient.put(appSettings.apiUrl+ '/JSON_DOCUMENTS/'+report.id, report)
    .toPromise().then((response:any) => response);
  }
}
