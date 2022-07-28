import { Component, OnInit } from '@angular/core';
import { UploadService } from '../shared/upload.service';

@Component({
  selector: 'progress-bar',
  template: `
    <p-progressBar *ngIf="_uploadService.uploadLoading" id="infinite-progress" mode="indeterminate"></p-progressBar>
  `
})
export class UploadProgressComponent implements OnInit {

  constructor(public _uploadService:UploadService) { }

  ngOnInit(): void {
  }

}
