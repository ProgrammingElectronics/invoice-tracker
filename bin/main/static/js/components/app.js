function submitInvoiceButton() {

    console.log("submitInvoiceButton fired")

    const invoiceJSON = submitInvoice()
    postRequest('http://localhost:8080/submit-invoice',
        invoiceJSON,
        null)
    console.log(JSON.stringify(invoiceJSON));

}