let username = document.getElementById("username")
let password = document.getElementById("password")
let loginBtn = document.getElementById("login")
let signup = document.getElementById("signup")


username.addEventListener("input", (e) => {
  let request = new XMLHttpRequest()
  request.onreadystatechange = () => {
    if (request.readyState === 4) {
      if (request.status === 200) {
        console.log(request.responseText);   
        if (request.responseText === "0") {
          signup.disabled = true;
        }     
        else {
          signup.disabled = false
        }
      }
    }
  }
  let usernameJson = {
    username: username.value
  }
  request.open("GET", "exists.php?cadena=" +  JSON.stringify(usernameJson), true )
  request.send()
})