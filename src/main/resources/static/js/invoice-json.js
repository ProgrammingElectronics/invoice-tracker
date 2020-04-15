// **** this function of a for/of loop allows iteration of a html collection ****
// **** this example also prints to the console each DOM's id                ****
// var list = document.getElementsByClassName('events');
// for (let item of list) {
//     console.log(item.id);
// }

// the commented out console.log() throughout this document where used in testing
// as the page was built.

function submitInvoice() {
    var contractorId = document.getElementById("contractor_id").innerText;
    var dateOfInvoice = document.getElementById('invoiceDateField').value;
    var invoiceNote = document.getElementById('serviceNotes').value;



    var invoiceJson = {
        "dateOfInvoice": dateOfInvoice,
        "invoiceNote": invoiceNote,
        "contractor": {
            "id": contractorId,
        },
        "serviceItems": [
            {
                "dateOfService": "2020-03-11",
                "amountDue": 100,
            },
            {
                "dateOfService": "2020-02-01",
                "amountDue": 150,
            }
        ],
    }
    console.log(invoiceJson);
    return invoiceJson;
}

// function submitInvoice() {
//     var contractorId = document.getElementById("contractor_id").value;
//     var contractorName = document.getElementById('contractorName').value;
//     var invoiceNumber = document.getElementById('invoiceNumber').value;
//     var invoiceDate = document.getElementById('invoiceDate').value;
//     var serviceInfoSets = document.getElementsByClassName('serviceInfoSet');
//     for (let infoSet of serviceInfoSets) {
//         //console.log(infoSet.id);
//         var innerInvoiceId = infoSet.id;
//         var serviceDate;
//         var serviceDescripton;
//         var amountDue;


//         var values = infoSet.getElementsByClassName('info');
//         for (let value of values) {
//             tempValue = value.value;

//             if (value.id == 'serviceName') {
//                 serviceName = tempValue;
//                 // console.log('test2');
//             }
//             if (value.id == 'serviceDate') {
//                 serviceDate = tempValue;
//                 // console.log('test3');
//             }
//             if (value.id == 'serviceDescripton') {
//                 serviceDescripton = tempValue;
//                 // console.log('test4');
//             }
//             if (value.id == 'amountDue') {
//                 amountDue = tempValue;
//                 // console.log('test6');
//             }
//         }

//         //console.log(innerInvoiceId, clientName, serviceName, serviceDate, serviceDescripton, hourlyRate, amountDue);

//         var infoSetValues = {
//             'innerInvoiceId': innerInvoiceId,
//             'serviceDate': serviceDate,
//             'serviceDescripton': serviceDescripton,
//             'amountDue': amountDue
//         }

//         // console.log(infoSetValues);
//         // invoiceArray.push(infoSetValues);



//         //the preperation of the json data for transport

//         var invoiceJson = {
//             'id': contractorId,
//             'contractorName': contractorName,
//             'invoiceDate': invoiceDate,
//             'invoiceNumber': invoiceNumber,
//             infoSetValues
//         }
//         console.log(JSON.stringify(invoiceJson));
//         return invoiceJson;

//     }
// }

// function submitInvoice() {

//     // ***information from the upper half of the html doc***

//     var contractorName = document.getElementById('contractorName').value;
//     var contractorAddress = document.getElementById('contractorAddress').value;
//     var contractorPhone = document.getElementById('contractorPhone').value
//     var contractorJson = {
//         'contractorName': contractorName,
//         'contractorAddress': contractorAddress,
//         'contractorPhone': contractorPhone
//     }
//     //console.log(contractorJson);

//     var invoiceNumber = document.getElementById('invoiceNumber').value;
//     var invoiceDate = document.getElementById('invoiceDate').value;
//     var invoiceTerm = document.getElementById('invoiceTerm').value;
//     var invoiceNumbersJson = {
//         'invoiceNumber': invoiceNumber,
//         'invoiceDate': invoiceDate,
//         'invoiceTerm': invoiceTerm
//     }
//     //console.log(invoiceNumbersJson);

//     var agencyName = document.getElementById('agencyName').value;
//     var agencyAddress = document.getElementById('agencyAddress').value;
//     var agencyPhone = document.getElementById('agencyPhone').value;
//     var agencyJson = {
//         'agencyName': agencyName,
//         'agencyAddress': agencyAddress,
//         'agencyPhone': agencyPhone
//     }
//     //console.log(agencyJson);

//     // ***information from the lower half of the html doc***

//     var invoiceArray = [];
//     //console.log(invoiceArray);

//     var serviceInfoSets = document.getElementsByClassName('serviceInfoSet');
//     for (let infoSet of serviceInfoSets) {
//         // console.log(infoSet.id);
//         var innerInvoiceId = infoSet.id;
//         var clientName;
//         var serviceName;
//         var serviceDate;
//         var serviceDescripton;
//         var hourlyRate;
//         var amountDue;


//         var values = infoSet.getElementsByClassName('info');
//         for (let value of values) {
//             tempValue = value.value;
//             if (value.id == 'clientName') {
//                 clientName = tempValue;
//                 // console.log('test1');
//             }
//             if (value.id == 'serviceName') {
//                 serviceName = tempValue;
//                 // console.log('test2');
//             }
//             if (value.id == 'serviceDate') {
//                 serviceDate = tempValue;
//                 // console.log('test3');
//             }
//             if (value.id == 'serviceDescripton') {
//                 serviceDescripton = tempValue;
//                 // console.log('test4');
//             }
//             if (value.id == 'hourlyRate') {
//                 hourlyRate = tempValue;
//                 //console.log('test5');
//             }
//             if (value.id == 'amountDue') {
//                 amountDue = tempValue;
//                 // console.log('test6');
//             }
//         }

//         //console.log(innerInvoiceId, clientName, serviceName, serviceDate, serviceDescripton, hourlyRate, amountDue);

//         var infoSetValues = {
//             'innerInvoiceId': innerInvoiceId,
//             'clientName': clientName,
//             'serviceName': serviceName,
//             'serviceDate': serviceDate,
//             'serviceDescripton': serviceDescripton,
//             'hourlyRate': hourlyRate,
//             'amountDue': amountDue
//         }

//         // console.log(infoSetValues);
//         invoiceArray.push(infoSetValues);

//     }

//     //the preperation of the json data for transport

//     var invoiceJson = {
//         contractorJson,
//         invoiceNumbersJson,
//         agencyJson,
//         invoiceArray
//     }
//     // console.log(JSON.stringify(invoiceJson));
//     return invoiceJson;

// }

