function loginButton() {

    console.log("loginButton fired")

    const loginJSON = enterLogin()
    postRequest('http://localhost:8080/enter-login',
        loginJSON)
    console.log(JSON.stringify(loginJSON));

}