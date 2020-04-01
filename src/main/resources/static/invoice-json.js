function test() {
    var serviceInfoSets = document.getElementsByClassName('serviceInfoSet');
    for (let infoSet of serviceInfoSets) {
        console.log(infoSet.id);
        var values = infoSet.getElementsByClassName('info');
        for (let value of values) {
            console.log(value.value);
        }
    }

}


// **** this function of a for/of loop allows iteration of a html collection ****
// **** this example also prints to the console each DOM's id                ****
// var list = document.getElementsByClassName("events");
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