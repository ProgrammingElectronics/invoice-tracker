var invoiceArray = [];

function test() {

    var serviceInfoSets = document.getElementsByClassName('serviceInfoSet');
    for (let infoSet of serviceInfoSets) {
        // console.log(infoSet.id);
        var innerInvoiceId = infoSet.id;
        var clientName;
        var serviceName;
        var serviceDate;
        var serviceTime;
        var hourlyRate;
        var amountDue;


        var values = infoSet.getElementsByClassName('info');
        for (let value of values) {
            tempValue = value.value;
            if (value.id == 'clientName') {
                clientName = tempValue;
                // console.log('test1');
            }
            if (value.id == 'serviceName') {
                serviceName = tempValue;
                // console.log('test2');
            }
            if (value.id == 'serviceDate') {
                serviceDate = tempValue;
                // console.log('test3');
            }
            if (value.id == 'serviceTime') {
                serviceTime = tempValue;
                // console.log('test4');
            }
            if (value.id == 'hourlyRate') {
                hourlyRate = tempValue;
                console.log('test5');
            }
            if (value.id == 'amountDue') {
                amountDue = tempValue;
                // console.log('test6');
            }
        }

        console.log(innerInvoiceId, clientName, serviceName, serviceDate, serviceTime, hourlyRate, amountDue);

        var infoSetValues = {
            'innerInvoiceId': innerInvoiceId,
            'clientName': clientName,
            'serviceName': serviceName,
            'serviceDate': serviceDate,
            'serviceTime': serviceTime,
            'hourlyRate': hourlyRate,
            'amountDue': amountDue
        }

        // console.log(infoSetValues);
        invoiceArray.push(infoSetValues);

    }

}

console.log(invoiceArray);

// **** this function of a for/of loop allows iteration of a html collection ****
// **** this example also prints to the console each DOM's id                ****
// var list = document.getElementsByClassName('events');
// for (let item of list) {
//     console.log(item.id);
// }

function submit() {
    var contractorName = document.getElementById('contractorName').value;
    var contractorAddress = document.getElementById('contractorAddress').value;
    var contractorPhone = document.getElementById('contractorPhone').value

    var invoiceNumber = document.getElementById('invoiceNumber').value;
    var invoiceDate = document.getElementById('invoiceDate').value;
    var invoiceTerm = document.getElementById('invoiceTerm').value;

    var agencyName = document.getElementById('agencyName').value;
    var agencyAddress = document.getElementById('agencyAddress').value;
    var agencyPhone = document.getElementById('agencyPhone').value;


}