import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  template: `
  <footer class="footer">
    <div class="container">
      <div class="col-md-12 text-center" style="color:black">&copy; 2021 - 2022 Ayara Inc. All Rights Reserved.</div>
    </div>
  </footer>
  `
})
export class FooterComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
