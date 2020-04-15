function submitInvoiceButton() {

    const invoiceJSON = submitInvoice()
    postRequest('http://localhost:8080/submit-invoice', invoiceJSON)
    console.log(JSON.stringify(invoiceJSON))

    //loginRedirect()
}


function loginRedirect() {

    let contractorId = document.getElementById("contractor_id").innerText
    window.location.href = "/contractor/search-invoice-list/" + contractorId;
}