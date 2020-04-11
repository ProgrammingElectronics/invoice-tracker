function markAsPaid() {
    let paidImage = document.getElementById("paid_stamp")
    paidImage.style.display = "block"

    let paidButton = document.getElementById("payBtn")
    paidButton.innerHTML = "Marked as Paid"
    paidButton.style.background = "#4CAF50";
    paidButton.style.color = "#ffffff";
}

function printInvoice() {

    window.print();
}

function PrintPage() {
    var sOption = "toolbar=yes,location=no,directories=yes,menubar=yes,scrollbars=yes,width=900,height=300,left=100,top=25";
    var sWinHTML = document.getElementsByTagName('body').innerHTML;
    var winprint = window.open("", "", sOption);
    winprint.document.open();
    winprint.document.write('<html><head><style type="text/css">');
    winprint.document.write('body,td,th{font-family:Arial, Helvetica, sans-serif;font-size:10px;color:#000000}');
    winprint.document.write('.style1 {font-size:11px; font-weight:bold; color:#000000; }');
    winprint.document.write('.style2 {font-size:11px; font-weight:bold; color:#FFFFFF; }');
    winprint.document.write('</style></head><body onload="window.print();">');
    winprint.document.write(sWinHTML);
    winprint.document.write('</body></html>');
    winprint.document.close();
    winprint.focus();
}

// function PrintElem(elem) {
//     var mywindow = window.open('', 'PRINT', 'height=800,width=600');


//     mywindow.document.write('<html><head><title>' + document.title + '</title>');
//     mywindow.document.write('</head><body >');
//     mywindow.document.write('<h1>' + document.title + '</h1>');
//     mywindow.document.write(document.getElementById(elem).innerHTML);
//     mywindow.document.write('</body></html>');

//     mywindow.document.close(); // necessary for IE >= 10
//     mywindow.focus(); // necessary for IE >= 10*/

//     mywindow.print();
//     mywindow.close();

//     return true;
// }