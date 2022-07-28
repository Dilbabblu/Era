import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpInterceptor, HttpRequest,HttpHandler, HttpEvent, HttpXsrfTokenExtractor    } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CsrfTokenInterceptorService implements HttpInterceptor  {

  constructor(private tokenExtractor: HttpXsrfTokenExtractor) {
  }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
  const cookieheaderName = 'X-CSRF-TOKEN';
  let csrfToken = this.tokenExtractor.getToken();
  if (csrfToken !== null && !req.headers.has(cookieheaderName) && ( req.method.toLowerCase() === 'post' ||req.method.toLowerCase() === 'put' || req.method.toLowerCase() === 'delete')) {
    req = req.clone({ headers: req.headers.set(cookieheaderName, csrfToken) });
  }
  return next.handle(req);
  }
}