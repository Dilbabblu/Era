import { Injectable } from "@angular/core";
import { MessageService } from "primeng/api";

@Injectable()
export class NotificationService {

    stickyToast:boolean = false;
    constructor(private messageService:MessageService){

    }

    showError(details){
        this.messageService.add({severity:'error', summary:'Error Message', detail:details, sticky: this.stickyToast, life: 10000});
    }
    showInfo(details){
        this.messageService.add({severity:'info', summary:'Info Message', detail:details, sticky: this.stickyToast, life: 10000});
    }
    showWarning(details){
        this.messageService.add({severity:'warn', summary:'Warn Message', detail:details, sticky: this.stickyToast, life: 10000});
    }
    showSuccess(details){
        this.messageService.add({severity:'success', summary:'Success Message', detail:details, sticky: this.stickyToast, life: 10000});
    }

    clear(){
        this.messageService.clear();
    }

}