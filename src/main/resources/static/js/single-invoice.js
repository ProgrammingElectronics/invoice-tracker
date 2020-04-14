
alreadyPaidActions()
alreadySentActions()

//TODO: This function should get worked into separate functions.
function alreadyPaidActions() {

    let isPaid = document.getElementById("is_paid").value;
    if (isPaid === "true") {
        //Hide Payment button and show Paid stamp
        let paidImage = document.getElementById("paid_stamp")
        paidImage.style.display = "block"
        let paidButton = document.getElementById("payBtn")
        paidButton.style.display = "none"

        //Hide Sent Button and Sent Image
        let sentImage = document.getElementById("sent_stamp")
        sentImage.style.display = "none"
        let sentButton = document.getElementById("sentBtn")
        sentButton.style.display = "none"
    }
}

function alreadySentActions() {

    let isSent = document.getElementById("is_sent").value;
    let isPaid = document.getElementById("is_paid").value;
    if (isSent === "true" && isPaid === "false") {
        //Display Sent Stamp and hide sent button
        let sentImage = document.getElementById("sent_stamp")
        sentImage.style.display = "block"
        let sentButton = document.getElementById("sentBtn")
        sentButton.style.display = "none"
    }
}

/***********************  Mark Invoice Paid  ******************************/

//TODO: This function should get worked into separate functions.
function markAsPaid() {

    //Hide Payment button and show Paid stamp
    let paidImage = document.getElementById("paid_stamp")
    paidImage.style.display = "block"
    let paidButton = document.getElementById("payBtn")
    paidButton.style.display = "none"

    //Hide Sent Button and Sent Image
    let sentImage = document.getElementById("sent_stamp")
    sentImage.style.display = "none"
    let sentButton = document.getElementById("sentBtn")
    sentButton.style.display = "none"

    markInvoicePaid()
}

/* 
TODO: This function need a code reveiew.
It works, but it's not right but I am not sure what right looks like.
*/
function markInvoicePaid() {
    let invoiceId = document.getElementById('invoice_id').value;
    putRequest('http://localhost:8080/contractor/mark-invoice-paid/' + invoiceId)
}

/***********************  Mark Invoice Sent  ******************************/

//TODO: This functions needs worked into separate functions.
function markAsSent() {

    //Display Sent Stamp and hide sent button
    let sentImage = document.getElementById("sent_stamp")
    sentImage.style.display = "block"
    let sentButton = document.getElementById("sentBtn")
    sentButton.style.display = "none"

    markInvoiceSent()
}

function markInvoiceSent() {
    let invoiceId = document.getElementById('invoice_id').value;
    putRequest('http://localhost:8080/contractor/mark-invoice-sent/' + invoiceId)
}


function putRequest(location, requestBody) {
    fetch(location, {
        method: "PUT"
    })
}

/***********************  Printing Invoice ******************************/

function printInvoice() {
    window.print();
}
