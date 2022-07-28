import { Component, OnInit, ViewChild, ViewContainerRef, ComponentFactoryResolver } from '@angular/core';
import { Subscription } from 'rxjs';
import { UserInfoService } from './userInfo.service';
import { RmanPasswordComponent } from '.././rmanPassword/rmanPassword.component';
import { NotificationService } from '.././shared/notifications.service';
import { CommonSharedService } from '.././shared/common.service';
import { RmanUsersService } from '.././rmanUsers/rmanUsersservice';

@Component({
  selector: 'user-info',
  templateUrl: './userInfo.component.html',
  providers: [UserInfoService, RmanUsersService]
})
export class UserInfoComponent implements OnInit {

  fullName: any;
  email: any;
  userName: any;
  phone: any;
  employeeId: any;
  role: any;
  rmanUserDetails: any = {};
  displayPasswordDialog: boolean;
  componentRef: any;
  subscription1: Subscription;

  @ViewChild('passwordcontainer', { read: ViewContainerRef }) entry: ViewContainerRef;

  constructor(private componentFactoryResolver: ComponentFactoryResolver, private notificationService: NotificationService, private commonSharedService: CommonSharedService,
    private rmanUsersService: RmanUsersService) {

      this.commonSharedService.getDismissPwdComponent().subscribe(dismissPwdCmp => {
        this.destroyPasswordComponent(dismissPwdCmp);
      });

      this.subscription1 = this.commonSharedService.getRole().subscribe(res => {
        this.role = res;
      });

  }

  ngOnInit(): void {

    this.getUserInfo();
  }

  getUserInfo() {
    this.rmanUsersService.getUsersInfo().then((rmanUsersInfo: any) => {
      this.rmanUserDetails = rmanUsersInfo;
      if (rmanUsersInfo != null) {
        this.userName = this.rmanUserDetails.userName;
        this.fullName = this.rmanUserDetails.fullName;
        this.phone = this.rmanUserDetails.workPhone;
        this.employeeId = this.rmanUserDetails.rmanEmployeeId;
        this.email = this.rmanUserDetails.emailAddress;
      }

    }).catch((err: any) => {
      this.notificationService.showError('Error Occurred while fetching User Details');
    })
  }

  showChangePwd() {
    if (this.rmanUserDetails && this.rmanUserDetails.rmanUserId) {
      this.displayPasswordDialog = true;
      this.entry.clear();
      let componentFactory = this.componentFactoryResolver.resolveComponentFactory(RmanPasswordComponent);
      this.componentRef = this.entry.createComponent(componentFactory);
      this.componentRef.instance.userId = this.rmanUserDetails.userId;
    } else {
      this.notificationService.showError('Invalid User Details');
      return false;
    }
  }

  destroyPasswordComponent(dismissPwdComponentResponse) {
    this.displayPasswordDialog = false;
    this.componentRef.destroy();
    if (dismissPwdComponentResponse && dismissPwdComponentResponse.pwd_changed) {
      this.notificationService.showSuccess('Your password has been changed successfully');
    }
  }

}
