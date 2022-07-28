import { Directive, ViewContainerRef } from '@angular/core';

@Directive({
  selector: '[ad-cm]',
})
export class AdCmDirective {
  constructor(public viewContainerRef: ViewContainerRef) { }
}
