import apiActions from './api/api-actions'
import invoiceJSON from '../invoice-json.js'

submitInvoice = document.querySelector('#submitBtn')
submitInvoice.addEventListener('click', function{
    const invoiceJSON = submitInvoice();
    apiActions.postRequest('http://localhost:8080/submit-invoice',
        invoiceJSON,
        null)
})



/*

//post request
getAppContext().addEventListener('click', function () {
    if (event.target.classList.contains('add-campus__submit')) {
        const campusName = event.target.parentElement.querySelector('.add-campus__campusName').value
        apiActions.postRequest('http://localhost:8080/campuses/add-campus', {
            campusName: campusName
        }, (campuses) => app.innerHTML = Campuses(campuses))
    }
})


function getAppContext() {
    return document.querySelector('#app')
}

function testTransfer() {
    const invoiceJSON = ;
    console.log(invoiceJSON);
}

*/