// the commented out console.log() throughout this document where used in testing
// as the page was built.

/******************* function to create the json **********************/

function submitInvoice() {
    var invoiceDate = document.getElementById('invoiceDateField').value;
    var invoiceNote = document.getElementById('serviceNotes').value;
    var contractor_id = document.getElementById('contractor_id').innerText;

    var invoiceJson = {
        "dateOfInvoice": invoiceDate,
        "invoiceNote": invoiceNote,
        "contractor": {
            "id": contractor_id,
        },
        "serviceItems": makeServiceItemArray()
    }
    console.log(invoiceJson);
    return invoiceJson;
}

/***** function to create the array of service items for the json ******/
var serviceItemsArray = [];

function makeServiceItemArray() {
    var serviceInfoSets = document.getElementsByClassName('serviceInfoSet');
    for (let infoSet of serviceInfoSets) {
        //console.log(infoSet.id);
        var serviceDate;
        var amountDue;
        var serviceDescripton;

        var values = infoSet.getElementsByClassName('info');
        for (let value of values) {
            tempValue = value.value;

            if (value.id == 'dateOfService') {
                serviceDate = tempValue
            }
            if (value.id == 'amountDue') {
                amountDue = tempValue
            }
            if (value.id == 'serviceDescription') {
                serviceDescripton = tempValue
            }
        }

        var infoSetValues = {
            'dateOfService': serviceDate,
            'amountDue': amountDue,
            'serviceDescription': serviceDescripton
        }
        serviceItemsArray.push(infoSetValues);
    }
    // console.log(infoSetValues)
    // console.log(serviceItemsArray);
    return serviceItemsArray;
}