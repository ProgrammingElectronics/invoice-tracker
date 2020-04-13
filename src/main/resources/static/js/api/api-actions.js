/**
 * Boiler Plate
 */
function postRequest(location, requestBody) {
    fetch(location, {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestBody)
    })
        .then(response => response.json())
        .catch(err => console.log(err))
}

