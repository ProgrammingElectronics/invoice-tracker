function submitInvoiceButton() {

    const invoiceJSON = submitInvoice()
    const newLocal = 'http://localhost:8080/submit';
    postRequest(newLocal,
        invoiceJSON)
}