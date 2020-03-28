var counter = 1;
var limit = 15;

function addService(divName) {
    if (counter == limit) {
        alert("You have reached the service limit.")
    }
    else {
        var newServ = document.createElement('div');
        newServ.innerHTML = `<input type='text' id='clientName'><input type='text' id='serviceName'><input type ='date' id='serviceDate'><input type ='time' id='serviceTime'>`;

        document.getElementById(divName).appendChild(newServ);
        counter++;
    }
}

var paid = 'no';

function payInvoice(divName) {
    var color = document.getElementById('payBtn');
    if (paid == 'yes') {
        alert("Invoice has already been paid.")
    }
    else {
        paid = 'yes';
        color.style.backgroundColor = "green";

    }
}