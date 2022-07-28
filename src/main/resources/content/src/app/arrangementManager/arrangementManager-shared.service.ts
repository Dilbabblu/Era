/** using dynamic components nested childrens to parent call 
 * 
*/

import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';


@Injectable()
export class ArrangementManagerSharedService {
    notifyFlag = new Subject<any>();
    notifyErrorFlag =  new Subject<any>();   
    notifyParent = new Subject<any>();

    constructor() {}

    setNotifyFlag(data: any){
       this.notifyFlag.next(data);
    }

    getNotifyFlag(): Observable<any> {
      return  this.notifyFlag.asObservable();
    }

    setNotifyErrorFlag(data: any) {
        this.notifyErrorFlag.next(data);
    }

    getNotifyErrorFlag(): Observable<any> {
       return this.notifyErrorFlag.asObservable();
    }

    setNotifyParent(data: any) {
      this.notifyParent.next(data);
    }

    getNotifyParent(): Observable<any>  {
     return this.notifyParent.asObservable();
    }

}