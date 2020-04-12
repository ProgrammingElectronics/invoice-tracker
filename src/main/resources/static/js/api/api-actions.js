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

