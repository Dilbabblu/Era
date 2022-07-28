import { AfterViewInit, Component, ComponentFactoryResolver, OnInit, Renderer2, ViewChild, ViewContainerRef } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Event, NavigationCancel, NavigationEnd, NavigationError, NavigationStart, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { RmanPasswordComponent } from './rmanPassword/rmanPassword.component';
import { RmanUsersImpl } from './rmanUsers/rmanUsers.component';
import { RmanUsersService } from './rmanUsers/rmanUsersservice';
import { CommonSharedService } from './shared/common.service';
import { NotificationService } from './shared/notifications.service';
declare var require: any;
const appSettings = require('./appsettings');
declare var $: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  providers: [RmanUsersService]
})

export class AppComponent implements OnInit, AfterViewInit {

  displayPasswordDialog: boolean;
  rmanUserDetails: any = {};
  errorUrl = appSettings.apiUrl.substring(0, appSettings.apiUrl.lastIndexOf("/api"));

  rmanUsers: any = new RmanUsersImpl();
  message: string = '';
  isLoading = false;
  isHeaderMenuLoading = false;
  tabSelected: string = '';
  componentRef: any;
  role: any;
  roleList = [];
  roleSubscription: Subscription;
  navigationStartRoute: any;
  showUserPopup = false;
  username: string = '';
  emailAddress: string = '';
  versionNumber: string = appSettings.version;

  @ViewChild('passwordcontainer', { read: ViewContainerRef }) entry: ViewContainerRef;

  constructor(private router: Router, private rmanUsersService: RmanUsersService,
    private commonSharedService: CommonSharedService, private componentFactoryResolver: ComponentFactoryResolver,
    private titleService: Title, private notificationService: NotificationService,
    private renderer: Renderer2) {
    $.blockUI.defaults.message = '<img src="./assets/images/loading.gif" /> Just a moment please';

    if (sessionStorage.getItem('title') == null) {
      sessionStorage.setItem('title', document.title);
    }

    this.commonSharedService.getDismissPwdComponent().subscribe(dismissPwdCmp => {
      this.destroyPasswordComponent(dismissPwdCmp);
    }
    );
    this.router.events.subscribe((event: Event) => {
      this.navigationStartRoute = this.router.url;

      switch (true) {
        case event instanceof NavigationStart: {
          this.isLoading = true;
          break;
        }

        case event instanceof NavigationCancel:
        case event instanceof NavigationError:
        case event instanceof NavigationEnd: {
          if (this.navigationStartRoute != "/") {
            this.isLoading = false;
          }
          this.setTitle(event['url']);
          window.scrollTo(0, 0);
          break;
        }
        default: {
          //no-code
        }
      }
    });
  }

  ngAfterViewInit() {
    this.renderer.setStyle(this.renderer.selectRootElement('#firstLoad'), 'display', 'none');
  }


  ngOnInit() {
    var sideslider = $('[data-toggle=collapse-side]');
    var sel = sideslider.attr('data-target');
    var sel2 = sideslider.attr('data-target-2');
    sideslider.click(function (event: any) {
      $(sel).toggleClass('in');
      $(sel2).toggleClass('out');
    });

    $('.topbar-menu').click(function ($event: any) {
      $('.topbar-menu li').toggleClass('active-topmenuitem');
      $event.stopPropagation();
    });

    $('#topbar-menu-button').click(function ($event: any) {
      $('#userAccount').toggleClass('topbar-menu-visible');
      $('#innerList').toggleClass('topbar-menu topbar-menu-visible');

      $event.stopPropagation();
    });

    $(document).click(() => {
      $(".topbar-menu li").removeClass("active-topmenuitem");
      $('#userAccount').removeClass('topbar-menu-visible');
      $('#innerList').removeClass('topbar-menu topbar-menu-visible');
    });
    this.getRmanUsersInfo();
  }

  displayPopup(event: any) {
    this.showUserPopup = !this.showUserPopup;
  }

  closePopup(event: any) {
    this.showUserPopup = false;
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

  getRmanUsersInfo() {
    this.isHeaderMenuLoading = true;
    this.rmanUsersService.getUsersInfo().then((rmanUsersInfo: any) => {
      this.rmanUserDetails = rmanUsersInfo;
      if (rmanUsersInfo != null) {
        this.username = (this.rmanUserDetails.fullName != null) ? this.rmanUserDetails.fullName : 
                    (this.rmanUserDetails.firstName != null && this.rmanUserDetails.lastName != null) ? (this.rmanUserDetails.firstName + " " + this.rmanUserDetails.lastName):
                    (this.rmanUserDetails.firstName != null && this.rmanUserDetails.lastName == null) ? this.rmanUserDetails.firstName :
                    (this.rmanUserDetails.firstName == null && this.rmanUserDetails.lastName != null) ? this.rmanUserDetails.lastName: '';
       
        this.emailAddress = this.rmanUserDetails.emailAddress;
        this.setPermissions();
      }
      this.isHeaderMenuLoading = false;
      this.isLoading = false;
    }).catch((err: any) => {
      this.isHeaderMenuLoading = false;
      this.isLoading = false;
    })
  }

  setPermissions() {
    let permissionsSet = []
    for (var responsibility of this.rmanUserDetails.rmanUserResponsibilitiesSet) {
      if (responsibility.enabledFlag == 'Y') {
        this.roleList.push(responsibility.rmanResponsibilities.responsibilityName)
        for (var functions of responsibility.rmanResponsibilities.rmanRoleFunctions) {
          permissionsSet.push(functions);
        }
      }
    }
    this.commonSharedService.setRole(this.roleList);
    this.commonSharedService.setRoleBasedPermissions(permissionsSet);
    this.isHeaderMenuLoading = false;
    this.isLoading = false;
  }

  get isRevAdmin() {
    return this.role === 'REVADMIN';
  }

  get isManager() {
    return this.role === 'MANAGER';
  }

  get isAnalyst() {
    return this.role === 'ANALYST';
  }



  destroyPasswordComponent(dismissPwdComponentResponse) {
    this.displayPasswordDialog = false;
    this.componentRef.destroy();
    if (dismissPwdComponentResponse && dismissPwdComponentResponse.pwd_changed) {
      this.notificationService.showSuccess('Your password has been changed successfully');
    }
  }

  setTitle(url: string) {
    if (url.includes('/rmanArrangementsAllV/rmanArrangementsOverView/')) {
      const rmanStr = '/rmanArrangementsOverView/';
      let reportId = url.substring(url.indexOf(rmanStr) + rmanStr.length, url.lastIndexOf('/'));
      this.titleService.setTitle(`Arrangements Overview: ${reportId}`);
    } else {
      this.titleService.setTitle(sessionStorage.getItem('title'));
    }
  }

}
