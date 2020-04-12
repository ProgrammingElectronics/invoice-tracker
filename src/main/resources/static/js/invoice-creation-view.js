// contractor view functions

//variables used for addService function
var totalServs = 1;
var counter = 1;
var limit = 15;

/* The following function adds lines to the service items section of the
*  invoice creation view by creating an additional Div element that matches
*  the fields used in the default one. It also creates gives the Div element
*  a unique id to destinguish between the separate service items
*/
function addService(divName) {
    if (totalServs == limit) {
        alert("You have reached the service limit.")
    }
    else {
        var newServ = document.createElement('div');
        counter++;
        newServ.id = counter;
        newServ.className = 'serviceInfoSet';
        newServ.innerHTML = `
        <input type="text" class="info" id="serviceDescription">
        <input type="date" class="info" id="dateOfService">
        <input type="number" class="info" id="amountDue">
        <button type='button' onclick='deleteServ(` + counter + `)' id='deleteServBtn'>X</button>
        `;
        document.getElementById(divName).appendChild(newServ);

        totalServs++;
    }
}
//Old Function
// function addService(divName) {
//     if (totalServs == limit) {
//         alert("You have reached the service limit.")
//     }
//     else {
//         var newServ = document.createElement('div');
//         // newServ.outerHTML = `<div class='serviceInfoSet' id='counter'></div>`
//         counter++;
//         newServ.innerHTML = `
//         <input type="text" class="info" id="clientName">
//         <input type="text" class="info" id="serviceName">
//         <input type="date" class="info" id="serviceDate">
//         <input type="number" class="info" id="serviceTime">
//         <input type="number" class="info" id="hourlyRate">
//         <input type="number" class="info" id="amountDue">
//         <button type='button' onclick='deleteServ(` + counter + `)' id='deleteServBtn'>X</button>
//         `;
//         newServ.id = counter;
//         document.getElementById(divName).appendChild(newServ);
//         newServ.className = 'serviceInfoSet';
//         totalServs++;
//     }
// }

// The following function applies to the x button which is connected to each
// service item allowing a user to delete lines

function deleteServ(id) {
    var target = document.getElementById(id);
    target.parentElement.removeChild(target);
    // console.log("firing"); //This log is for testing
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

//invoice total function
var totalAmountDue;
var tempValue;

function totalAmountDue() {
    console.log("fired");
    var tempValue = 0;
    var valueArray = document.getElementsByName('amountDue').values;
    valueArray.forEach(addEmUp());
    totalAmountDue = tempValue;
    document.getElementById('totalAmountDue').innerHTML(totalAmountDue);
}

function addEmUp(index, item) {
    tempValue = tempValue + item;
}


// for (let infoSet of serviceInfoSets) {
//         var amountDueTemp;

//         var values = infoSet.getElementsByClassName('info').getElementById('amountDue');
//         for (value of values) {
//             amountDueTemp = value.value + amountDueTemp;
//         }
//     }
//     totalAmountDue = amountDueTemp;
//     document.getElementById('totalAmountDue').innerHTML(totalAmountDue);
// }