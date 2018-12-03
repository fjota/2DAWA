//ELEMENTOS DEL FORMULARIO
let formulario = document.getElementById("formulario");
let correcto = document.getElementById("correcto");
let nif = document.getElementById("nif");
let fechaNacimiento = document.getElementById("fechaNacimiento");
let clave = document.getElementById("clave");
let borrarClave = document.getElementById("borrar");
let tecladoVirtual = document.getElementById("teclado");
let reset = document.getElementById("reiniciar");
let registrar = document.getElementById("registrar");

//NIF
let dniRegex = new RegExp("^[0-9]{1,8}[A-Za-z]$"); //Con nacionalidad
let nifRegex = new RegExp("^[a-zA-Z][0-9]{1,7}[A-Za-z]$"); //Sin nacionalidad
let nifPlaceholder = "Introduzca su NIF sin espacios en blanco ni guiones";
nif.placeholder = nifPlaceholder;

nif.addEventListener("focus", function() {
  nif.placeholder = "";
});

nif.addEventListener("blur", function() {
  if (this.value.length === 0) {
    nif.placeholder = nifPlaceholder;
  }
});

nif.addEventListener("change", function() {
  if (dniRegex.test(nif.value) || nifRegex.test(nif.value)) {        
    eliminarMensajeError(nif);
  } else {
    nif.value = "";
    mensajeError("El NIF introducido no es válido o no tiene el formato adecuado", nif, formulario);     
  }
});


//FECHA DE NACIMIENTO
let nacimientoPlaceholder = "DD/MM/AAAA";
fechaNacimiento.placeholder = nacimientoPlaceholder;
let fechaNacimientoRegex = new RegExp("^[0-9]{2}\/[0-9]{2}\/[0-9]{4}$");

fechaNacimiento.addEventListener("focus", function() {
  fechaNacimiento.placeholder = "";
});

fechaNacimiento.addEventListener("blur", function() {
  if (this.value.length === 0) {
    fechaNacimiento.placeholder = "Introduzca fecha en el siguiente formato DD/MM/AAA.";
  }
});

fechaNacimiento.addEventListener("change", function() {  
  if (fechaNacimientoRegex.test(fechaNacimiento.value)) {       
    eliminarMensajeError(fechaNacimiento);
  } else {
    fechaNacimiento.value = "";
    mensajeError("La fecha introducida no es válida o no tiene el formato adecuado", fechaNacimiento, formulario);     
  }
});

//CLAVE 
let longitudClaveValida = 6;

borrarClave.addEventListener("click", function() {
  clave.value = "";
})


//TECLADO VIRTUAL
let numeros = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
function ordenarNumerosAleatorio() {
  for (let i = 0; i < numeros.length; i++) {
    let random = Math.floor(Math.random() * 10);
    let aux = numeros[random];
    numeros[random] = numeros[i];
    numeros[i] = aux;
  }
}

function crearTecladoVirtual() {
  ordenarNumerosAleatorio();
  let indexNumbers = 0;
  for (let i = 0; i < 2; i++) {
    let row = document.createElement("div");
    row.setAttribute("class", "row");
    for (let j = 0; j < 5; j++) {
      let square = document.createElement("div");      
      let squareText = document.createTextNode(numeros[indexNumbers]);
      square.setAttribute("onclick", "escribirDigito(this)");
      square.appendChild(squareText);
      square.setAttribute("class", "key");      
      row.appendChild(square.cloneNode(true));
      indexNumbers++;
    }
    tecladoVirtual.appendChild(row.cloneNode(true));
  }
}

function cambiarOrderTeclado() {
  let indexNumbers = 0;
  let rows = document.getElementsByClassName("key");
  for (let i = 0; i < numeros.length; i++) {
    rows.item(i).textContent = numeros[indexNumbers];
    indexNumbers++;
  }   
}

function escribirDigito(e) {
  clave.value += e.textContent;
}

//Crea el teclado virtual
crearTecladoVirtual();


//BOTONES DE VALIDACION 
registrar.addEventListener("click", function() {
  let bandera = true;
  //NIF
  if (nif.value.length === 0) {
    bandera = false;
    mensajeError("Campo obligatorio", nif, formulario);    
  }
  //FECHA NACIMIENTO
  if (fechaNacimiento.value.length === 0) {
    bandera = false;
    mensajeError("Campo obligatorio", fechaNacimiento, formulario);
  }
  //CLAVE 
  if (clave.value.length === 0 || clave.value.length > longitudClaveValida || clave.value != "012345") {
    bandera = false;
    clave.value = "";
    mensajeError("La clave no cumple con el requisito de número de dígitos introducidos", clave, formulario);
  } 
  if (bandera) {    
    correcto.style.backgroundColor = "#90EE90";
    correcto.style.color = "green";
    correcto.innerText = "Formulario enviado";
  }
});

reset.addEventListener("click", function () {
  nif.value = "";
  eliminarMensajeError(nif);
  fechaNacimiento.value = "";
  eliminarMensajeError(fechaNacimiento);
  clave.value = "";
  eliminarMensajeError(clave);
  ordenarNumerosAleatorio();
  cambiarOrderTeclado();
  correcto.innerHTML = "";
});

//FUNCIONES 

/**
 * Crea un mensaje de error despues del elemento especificado
 * @param {Mensaje} mensaje 
 * @param {Elemento HTML} elemento 
 * @param {Padre contenedor} contenedor 
 */
function mensajeError(mensaje, elemento, contenedor) {
  if (elemento.nextSibling.nodeName === "SPAN") {
    elemento.nextSibling.remove();
  }
  let error = document.createElement("span");
  let errorText = document.createTextNode(mensaje);    
  error.appendChild(errorText);
  error.style.color = "red";
  contenedor.insertBefore(error, elemento.nextSibling); 
  elemento.style.border = "1px solid red";
}

/**
 * Elimina el mensaje de error generado del elemento especificado
 * @param {Elemento HTML} elemento 
 */
function eliminarMensajeError(elemento) {
  if (elemento.nextSibling.nodeName === "SPAN") {
    elemento.nextSibling.remove();
  }
  elemento.style.border = "1px solid black";
}




