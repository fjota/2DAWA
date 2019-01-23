let username = document.getElementById("username")
let password = document.getElementById("password")
let signupBtn = document.getElementById("signup")
let msgServer = document.getElementById("msgServer")


username.addEventListener("input", (e) => {
  let request = new XMLHttpRequest()
  request.onreadystatechange = () => {
    if (request.readyState === 4) {
      if (request.status === 200) {
        request.responseText === "0" ? signupBtn.disabled = true : signupBtn.disabled = false
      } else {
        msgServer.textContent = "Se ha producido un error en el servidor"
      }
    }
  }
  let usernameJson = {
    username: username.value
  }
  request.open("GET", "exists.php?cadena=" + JSON.stringify(usernameJson), true)
  request.send()
})

document.getElementById("login").addEventListener("click", (e) => {
  if (validateData()) {
    let request = new XMLHttpRequest()
    request.onreadystatechange = () => {
      if (request.readyState === 4) {
        if (request.status === 200) {
          switch (request.responseText) {
            case "0":
              msgServer.textContent = "Inicio de sesion correcto"
              break;
            case "1":
              msgServer.textContent = "Contraseña incorrecta"
              break;
            case "2":
              msgServer.textContent = "El usuario no existe"
              break;
          }
        } else {
          msgServer.textContent = "Se ha producido un error en el servidor"
        }
      }
    }
    request.open("GET", "login.php?cadena=" + formDataToJson(), true)
    request.send()
  } else {
    msgServer.textContent = "Los campos no deben estar vacios"
  }
})

signupBtn.addEventListener("click", (e) => {
  if (validateData()) {
    let request = new XMLHttpRequest()
    request.onreadystatechange = () => {
      if (request.readyState === 4) {
        if (request.status === 200) {
          if (request.responseText === "0") {
            msgServer.textContent = "Se ha registrado correctamente"
          }
          else if (request.responseText === "1") {
            msgServer.textContent = "No se ha podido registrar"
          }
        } else {
          msgServer.textContent = "Se ha producido un error en el servidor"
        }
      }
    }
    request.open("GET", "signup.php?cadena=" + formDataToJson(), true)
    request.send()
  } else {
    msgServer.textContent = "Los campos no deben estar vacios"
  }
})

document.getElementById("change_password").addEventListener("click", (e) => {
  if (validateData()) {
    let request = new XMLHttpRequest()
    request.onreadystatechange = () => {
      if (request.readyState === 4) {
        if (request.status === 200) {
          if (request.responseText === "0") {
            msgServer.textContent = "Cambio su contraseña correctamente"
          }
          else if (request.responseText === "1") {
            msgServer.textContent = "No se ha podido cambiar su contraseña"
          }
        } else {
          msgServer.textContent = "Se ha producido un error en el servidor"
        }
      }
    }
    request.open("GET", "chgpassword.php?cadena=" + formDataToJson(), true)
    request.send()
  } else {
    msgServer.textContent = "Los campos no deben estar vacios"
  }
})

function formDataToJson() {
  let jsonData = {
    username: username.value,
    password: password.value
  }
  jsonData = JSON.stringify(jsonData);
  return jsonData
}

function validateData() {
  if (username.value.length > 0 && password.value.length > 0) {
    return true
  }
  return false
}