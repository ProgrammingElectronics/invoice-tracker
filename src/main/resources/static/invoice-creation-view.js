// contractor view functions
var counter = 1;
var limit = 15;

function addService(divName) {
    if (counter == limit) {
        alert("You have reached the service limit.")
    }
    else {
        var newServ = document.createElement('div');
        newServ.innerHTML = `<input type='text' id='clientName'><input type='text' id='serviceName'><input type ='date' id='serviceDate'><input type ='number' id='serviceTime'><input type='number' id='hourly rate'><input type='number' id='amountDue'><button type='button' onclick='deleteServ()' id='deleteServBtn'>X</button>`;
        document.getElementById(divName).appendChild(newServ);

        counter++;
    }
}

// function addDeleteBtn(divName) {
//     if (counter == limit) {
//     }
//     else {
//         var newBtn = document.createElement('div');
//         newBtn.innerHTML = `<button type='button' onclick='deleteServ()'>X</button>`;
//         document.getElementById(divName).appendChild(newBtn);
//     }
// }

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