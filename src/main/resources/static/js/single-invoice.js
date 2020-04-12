function markAsPaid() {
    let paidImage = document.getElementById("paid_stamp")
    paidImage.style.display = "block"

    let paidButton = document.getElementById("payBtn")
    paidButton.innerHTML = "Marked as Paid"
    paidButton.style.background = "#4CAF50";
    paidButton.style.color = "#ffffff";

    markInvoicePaid()
}

function markInvoicePaid() {
    let invoiceId = document.getElementById('invoice_id').value;
    putRequest('http://localhost:8080/contractor/mark-invoice-paid/' + invoiceId)
}

function putRequest(location, requestBody) {
    fetch(location, {
        method: "PUT"
    })
}

function printInvoice() {
    window.print();
}
