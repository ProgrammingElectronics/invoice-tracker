function submitInvoiceButton() {

    console.log("submitInvoiceButton fired")

    const invoiceJSON = submitInvoice()
    postRequest('http://localhost:8080/submit-invoice',
        invoiceJSON)
    console.log(JSON.stringify(invoiceJSON));

}