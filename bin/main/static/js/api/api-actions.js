/**
 * Boiler Plate
 */

function postRequest(location, requestBody) {
    fetch(location, {
        method: "POST",
        body: JSON.stringify(requestBody)
    })
        .then(response => response.json())
        .catch(err => console.log(err))
}


/* function postRequest(location, requestBody, callback) {
    fetch(location, {
        method: "POST",
        body: JSON.stringify(requestBody)
    })
        .then(response => response.json())
        .then(data => callback(data))
        .catch(err => console.log(err))
}
*/
