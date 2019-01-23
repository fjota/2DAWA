let username = document.getElementById("username")
let password = document.getElementById("password")
let loginBtn = document.getElementById("login")
let signupBtn = document.getElementById("signup")
let changePasswordBtn = document.getElementById("change_password")


username.addEventListener("input", (e) => {
  let request = new XMLHttpRequest()
  request.onreadystatechange = () => {
    if (request.readyState === 4) {
      if (request.status === 200) {
        console.log(request.responseText);   
        if (request.responseText === "0") {
          signupBtn.disabled = true;
        }     
        else {
          signupBtn.disabled = false
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

loginBtn.addEventListener("click", (e) => {
  let request = new XMLHttpRequest()
  request.onreadystatechange = () => {
    if (request.readyState === 4) {
      if (request.status === 200) {
        console.log(request.responseText);   
        if (request.responseText === "0") {
          console.log("Inicio de sesion correcto");        
        }     
        else if(request.responseText === "1") {
          console.log("Contraseña incorrecta");        
        } else if(request.responseText === "2") {
          console.log("El usuario no exisxtes");          
        }
      }
    }
  }
  let loginUser = {
    username: username.value,
    password: password.value
  }
  request.open("GET", "login.php?cadena=" +  JSON.stringify(loginUser), true )
  request.send()
})

signupBtn.addEventListener("click", (e) => {
  let request = new XMLHttpRequest()
  request.onreadystatechange = () => {
    if (request.readyState === 4) {
      if (request.status === 200) {
        console.log(request.responseText);   
        if (request.responseText === "0") {
          console.log("Se ha registrado correctamente");        
        }     
        else if(request.responseText === "1") {
          console.log("No le queremos en nuestra empresa");        
        } 
      }
    }
  }
  let loginUser = {
    username: username.value,
    password: password.value
  }
  request.open("GET", "signup.php?cadena=" +  JSON.stringify(loginUser), true )
  request.send()
})

changePasswordBtn.addEventListener("click", (e) => {
  let request = new XMLHttpRequest()
  request.onreadystatechange = () => {
    if (request.readyState === 4) {
      if (request.status === 200) {
        console.log(request.responseText);   
        if (request.responseText === "0") {
          console.log("Cambio su contraseña correctamenta");        
        }     
        else if(request.responseText === "1") {
          console.log("no cambio nada compañerp");        
        } 
      }
    }
  }
  let loginUser = {
    username: username.value,
    password: password.value
  }
  request.open("GET", "chgpassword.php?cadena=" +  JSON.stringify(loginUser), true )
  request.send()
})