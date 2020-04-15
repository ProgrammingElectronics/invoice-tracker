// contractor view functions

/* The following function adds lines to the service items section of the
*  invoice creation view by creating an additional Div element that matches
*  the fields used in the default one. It also creates gives the Div element
*  a unique id to destinguish between the separate service items
*/

//variables used for addService function
var totalServs = 1;
var counter = 1;
var limit = 15;

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
        <input type="number" class="info amountDue" oninput="totalAmountDueFunction()" id="amountDue" value="0">
        <button type='button' onclick='deleteServ(` + counter + `)' id='deleteServBtn'>X</button>
        `;
        document.getElementById(divName).appendChild(newServ);

        totalServs++;
    }
}


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

function totalAmountDueFunction() {
    var totalAmountDue = 0;
    var amountDueArray = document.getElementsByClassName('amountDue')
    for (let serviceAmount of amountDueArray) {

        totalAmountDue += parseFloat(serviceAmount.value)
        console.log(serviceAmount.value)
        console.log(totalAmountDue)
    }

    let totalAmountDueBlock = document.getElementById("totalAmountDue")
    totalAmountDueBlock.innerText = totalAmountDue
    return totalAmountDue;
}

