import * as ExcelJS from "exceljs/dist/exceljs.min.js";

export const DownloadAdapter = {
    XLSXCSV: (type,params)=>{
    const workbook = new ExcelJS.Workbook();
    workbook.creator = 'Me';
    workbook.lastModifiedBy = 'Her';
    workbook.created = workbook.modified = workbook.lastPrinted = new Date();
    workbook.views = [
      {
        x: 0, y: 0, width: 10000, height: 20000,
        firstSheet: 0, activeTab: 1, visibility: 'visible'
      }
    ];
    const worksheet = workbook.addWorksheet('My Sheet');
    
    worksheet.state = 'visible';
    let table = document.getElementById('pivotTableTableContainer');
    let headTr = table.children[0];
    let maxChar = [];
    let updateMaxChar = (len,index)=>{
      if(maxChar.length <= index){
        maxChar.push(len);
      } else {
        if(maxChar[index]<len){
          maxChar[index] = len;
        }
      }
    }
    if(type=='xlsx') {
        worksheet.addRow();
        worksheet.addRow([`Report Name: ${params.name}    Start Date: ${params.startDate}    End Date: ${params.endDate}`]);
        worksheet.mergeCells('A2:F2');
        worksheet.getCell('A2').alignment = { vertical: 'middle', horizontal: 'center' };
        worksheet.addRow();
        worksheet.addRow();
    } 
    //@ts-ignore
    for (let row of headTr.children) {
      let columns = [];
    //@ts-ignore
      for (let item of row.children) {
        //@ts-ignore
        let text = item.innerText;
        columns.push(text);
        updateMaxChar(text.length+4, columns.length - 1);
        //@ts-ignore
        if (item.colSpan > 1) {
          //@ts-ignore
          for (let i = 0; i < item.colSpan - 1; i++) {
            columns.push('merge');
            updateMaxChar(0, columns.length - 1);
          }
        }
      }
      
      worksheet.addRow(columns);
      let mergeCells = [];
      worksheet.lastRow.eachCell((cell, index) => {
        cell.font = {bold: true };
        if (cell.text == 'merge') {
          cell.value = '';
          mergeCells[mergeCells.length - 1].push(cell.address);
        } else {
          mergeCells.push([cell.address]);
        }
      });
      mergeCells.forEach((item) => {
        if (item.length > 1) {
          worksheet.mergeCells(item[0] + ':' + item[item.length - 1]);
        }
      });
    }
    let tableBody = table.children[1];
    //@ts-ignore
    for(let row of tableBody.children) {
      let rowData = [];
      let groupIndex = -1;
      for(let item of row.children) {
        //@ts-ignore
        rowData.push(item.innerText);
        if(item.getAttribute('data-field').indexOf('group')==0){
          groupIndex = rowData.length-1;
        }
        //@ts-ignore
        updateMaxChar(item.innerText.length,rowData.length-1);
      } 
      worksheet.addRow(rowData);
      worksheet.lastRow.eachCell((cell,index)=>{
        if(cell.text && !isNaN(cell.text) && index-1 > groupIndex) {
          cell.value = Number(cell.text);
          cell.numFmt = "0.000";
        }
      });
    } 
    let columns = [];
    maxChar.forEach((item)=>{
      columns.push({width: item < 10 ? 10 : item})
    });
    if(columns[0].width <= 10)columns[0].width = 14;
    worksheet.columns = columns;
    if (type == 'csv') {
      let csvData = maxChar.map((data) => '');
      worksheet.insertRow(1,[
        'Report Name',params.name,'','Start Date-',params.startDate,'','End Date',params.endDate,
        ...csvData
      ]);
    }

    let totals =  document.getElementsByClassName('grand-total');
    if(totals && totals.length) {
        let rowData = [];
        //@ts-ignore
        for (let item of totals[0].children) {
          //@ts-ignore
          rowData.push(item.innerText);
        }
        worksheet.addRow(rowData); 
        worksheet.lastRow.eachCell((cell,index)=>{
          if(cell.text && !isNaN(cell.text)) {
            cell.value = Number(cell.text);
            cell.numFmt = "0.000";
          }
        });
    }
    
      workbook[type].writeBuffer().then((data) => {
        var blob = new Blob([data], {
          type:
            'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet',
        });
        var saveData = (function () {
          var a = document.createElement('a');
          document.body.appendChild(a);
          a.style.display = 'none';
          return function (data, fileName) {
            var blob = data,
              url = window.URL.createObjectURL(blob);
            a.href = url;
            a.download = fileName;
            a.click();
            window.URL.revokeObjectURL(url);
          };
        })();
        saveData(blob, 'report.'+type);
      });
    },
    PDF: (params)=> {
      let element = document.getElementById('pivotTableTableContainer');
      let rowElement = element.getElementsByTagName('tr');
      let tableContainer = document.createElement('div');
      tableContainer.style.width='fit-content';
      let tableElement = document.createElement('table');
    //   let tablePdf =  document.getElementById('tablePdf');
    //   tablePdf.appendChild(tableContainer);
      //Report Heading
      let elementHeading = document.createElement('div');
      elementHeading.style.paddingBottom = '8px';
      elementHeading.innerHTML = `Report Name: ${params.name} &nbsp;&nbsp;&nbsp; Start Date: ${params.startDate}  &nbsp;&nbsp;&nbsp; End Date: ${params.endDate} `
      tableContainer.appendChild(elementHeading);
      //Report Table
      tableContainer.appendChild(tableElement);
      tableElement.style.fontSize = '10px';
      tableElement.style.wordBreak = '10px';
      tableElement.style.whiteSpace = 'nowrap';
      tableElement.style.borderSpacing = '0px';
      tableElement.style.borderTop = '1px solid black';
      tableElement.style.borderRight = '1px solid black';
      let tbodyElement = document.createElement('tbody');
      tableElement.appendChild(tbodyElement);
        //@ts-ignore
      for(let item of rowElement) {
        let trElement = document.createElement('tr');
        tbodyElement.appendChild(trElement);
        //@ts-ignore
        for(let data of item.children) {
          //@ts-ignore
          let tdElement = document.createElement('td');
          //@ts-ignore
          tdElement.innerText = data.innerText;
          tdElement.style.borderBottom = '1px solid black';
          tdElement.style.borderLeft = '1px solid black';
          tdElement.style.padding = '4px';
          trElement.appendChild(tdElement);
        }
      }
      var myWindow = window.open(window.location.origin+'/#/reports/pdfDownload');
      myWindow.sessionStorage.content = tableContainer.innerHTML;

    }
}