function proJoFunction(id) {
    var x = document.getElementById(id);
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else {
        x.className = x.className.replace(" w3-show", "");
    }
}

function validateForm() {
    var x = document.forms["personal"]["name"].value;
    if (x == "") {
        alert("Name must be filled out.");
        return false;
    }
}


/********************************** Patch Request *******************************************/

function updateProfile() {
    let contractorId = document.getElementById('contractor_id').value
    profileJson = getProfileJson()
    console.log(profileJson)
    putRequest('http://localhost:8080/update-profile/' + contractorId, profileJson)
}

function getProfileJson() {

    let profileJson = {
        'firstName': document.getElementById('firstName').value,
        'lastName': document.getElementById('lastName').value,
        'addressLineOne': document.getElementById('address1').value,
        'addressLineTwo': document.getElementById('address2').value,
        'city': document.getElementById('city').value,
        'state': document.getElementById('state').value,
        'zip': document.getElementById('zip').value,
        'country': document.getElementById('country').value,
        'phoneNumber': document.getElementById('phone').value,
        'email': document.getElementById('email').value
        //'payPalId': document.getElementById('pay-pal').value,
    }

    return profileJson;
}

function putRequest(location, requestBody) {
    fetch(location, {
        method: "PATCH",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestBody)
    })
}
