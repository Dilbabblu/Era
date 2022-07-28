import { Component, OnInit } from '@angular/core';
import jsPDF from 'jspdf';

@Component({
  selector: 'pdfComponent',
  template: '',
})
export class pdfComponent implements OnInit {
  ngOnInit() {
    let element = document.createElement('div');
    element.innerHTML = window.sessionStorage.content;
    element.style.width = 'fit-content';
    window.document.body.appendChild(element);
    var doc = new jsPDF({
      orientation: 'landscape',
      unit: 'px',
      format: [
        element.clientHeight + 84,
        element.clientWidth + 64,
      ],
    });
    doc.html(element, {
      callback: function (doc) {
        doc.save();
        setTimeout(() => {
          window.close();
        }, 500);
      },
      x: 32,
      y: 32,
    });
  }
}
