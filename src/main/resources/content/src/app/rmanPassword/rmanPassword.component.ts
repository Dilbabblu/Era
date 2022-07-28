import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subject } from 'rxjs';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
@Component({
    selector: 'rmanPassword-data',
    templateUrl: './rmanPassword.component.html'
})

export class RmanPasswordComponent implements OnInit {
   
    @Input() userId: any;
    oldPassword:any;
    newPassword: any;
    cnfrmPassword: any;
    changePasswordForm: FormGroup;
    formErrors:any={};
    
    subject = new Subject<any>();
    pwd: any;
    validationMessages = {
        'oldPwd': {
          'required': "Old Password is required"
        },
        'newPwd': {
          'required': "New Password is required.",
          'pattern': "Enter a valid password."
        },
        'cnfrmPwd': {
          'required': "Confirm Password is required.",
          'pattern': "Enter a valid password."
        }
    }

    constructor(private formBuilder: FormBuilder,private http: HttpClient,private commonSharedService: CommonSharedService,
      private notificationService:NotificationService) { }

    ngOnInit() { 
        this.pwd = {oldPassword:'',newPassword:'',cnfrmPassword:'',userId:this.userId};
        this.buildForm();
        this.createFormErrorsObj();
    }

    buildForm(){
        this.changePasswordForm = this.formBuilder.group({
            'oldPwd': ['', [Validators.required]],
            'newPwd': ['', [Validators.required, Validators.pattern(/^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]){8,}/)]],
            'cnfrmPwd': ['', [Validators.required, Validators.pattern(/^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]){8,}/)]]
          });
        this.changePasswordForm.valueChanges
            .subscribe(data => this.onValueChanged(data));
    }
    createFormErrorsObj(){
        this.formErrors = {'oldPwd': '', 'newPwd': '', 'cnfrmPwd': ''};
    }
    onValueChanged(data){
        if (!this.changePasswordForm) { return; }

        this.createFormErrorsObj();
        for (const field in this.formErrors) {
           
            const control = this.changePasswordForm.get(field);
            if (control && control.dirty && !control.valid) {
              const messages = this.validationMessages[field];
              for (const key in control.errors) {
                this.formErrors[field] += messages[key] + ' ';
              }
            }
        }

    }

    validate() {       
        if (this.pwd.newPassword && this.pwd.cnfrmPassword && this.pwd.oldPassword) {
          if (this.pwd.newPassword != this.pwd.cnfrmPassword) {
            this.notificationService.showError('New password and confirm password does not match');
          } else {
            this.http.post("/api/changePassword", JSON.stringify(this.pwd)).toPromise().then((res: any) => {        
                this.commonSharedService.setDismissPwdComponent({dismiss:true,pwd_changed:true});
            }).catch((err: any) => {                       
              this.notificationService.showError(err.error.message);
            });   
          }
        }
      
      }
    ngOnDestroy(): void {
        //Called once, before the instance is destroyed.
        //Add 'implements OnDestroy' to the class.        
    }
    cancel(){
        this.commonSharedService.setDismissPwdComponent({dismiss:true,pwd_changed:false});
    }

}
