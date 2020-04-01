// contractor view functions
var totalServs = 1;
var counter = 1;
var limit = 15;

function addService(divName) {
    if (totalServs == limit) {
        alert("You have reached the service limit.")
    }
    else {
        var newServ = document.createElement('div');
        // newServ.outerHTML = `<div class='serviceInfoSet' id='counter'></div>`
        counter++;
        newServ.innerHTML = `<input type='text' id='clientName'><input type='text' id='serviceName'><input type ='date' id='serviceDate'><input type ='number' id='serviceTime'><input type='number' id='hourly rate'><input type='number' id='amountDue'><button type='button' onclick='deleteServ(` + counter + `)' id='deleteServBtn'>X</button>`;
        newServ.id = counter;
        document.getElementById(divName).appendChild(newServ);
        newServ.className = 'serviceInfoSet';
        totalServs++;
    }
}

function deleteServ(id) {
    var target = document.getElementById(id);
    target.parentElement.removeChild(target);
    console.log("firing");
    totalServs--;
}

// agency view functions
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