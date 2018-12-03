let formulario = document.getElementById("formulario");
let nif = document.getElementById("nif");
let fechaNacimiento = document.getElementById("fechaNacimiento");
let clave = document.getElementById("clave");
let tecladoVirtual = document.getElementById("teclado");
let reset = document.getElementById("reiniciar");
let registrar = document.getElementById("registrar");

//nif
let dniRegex = new RegExp("^[0-9]{1,8}[A-Za-z]$");
let nifRegex = new RegExp("^[a-zA-Z][0-9]{1,7}[A-Za-z]$");
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
    //TODO
  } else {
    mensajeError("El NIF introducido no es válido o no tiene el formato adecuado", nif, formulario);     
  }
});


//Fecha de nacimiento
let nacimientoPlaceholder = "DD/MM/AAAA";
fechaNacimiento.placeholder = nacimientoPlaceholder;
let fechaNacimientoRegex = new RegExp("^[0-9]{2}/[0-9]{2}/[0-9]{4}$");

fechaNacimiento.addEventListener("focus", function() {
  fechaNacimiento.placeholder = "";
});

fechaNacimiento.addEventListener("blur", function() {
  if (this.value.length === 0) {
    fechaNacimiento.placeholder = "Introduzca fecha en el siguiente formato DD/MM/AAA.";
  }
});

fechaNacimiento.addEventListener("change", function() {
  
  if (dniRegex.test(fechaNacimiento.value)) {       
    //TODO
  } else {
    mensajeError("El NIF introducido no es válido o no tiene el formato adecuado", fechaNacimiento, formulario);     
  }
});



//Virtual keyboard
let numbers = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
function genRandomOrder() {
  for (let i = 0; i < numbers.length; i++) {
    let random = Math.floor(Math.random() * 10);
    let aux = numbers[random];
    numbers[random] = numbers[i];
    numbers[i] = aux;
  }
}

function createVirtualKeyboard() {
  genRandomOrder();
  let indexNumbers = 0;
  for (let i = 0; i < 2; i++) {
    let row = document.createElement("div");
    row.setAttribute("class", "row");
    for (let j = 0; j < 5; j++) {
      let square = document.createElement("div");
      let squareText = document.createTextNode(numbers[indexNumbers]);
      square.appendChild(squareText);
      square.setAttribute("class", "key");      
      row.appendChild(square.cloneNode(true));
      indexNumbers++;
    }
    tecladoVirtual.appendChild(row.cloneNode(true));
  }
}

createVirtualKeyboard();

function changeValueKeyboard() {
  let indexNumbers = 0;
  let rows = document.getElementsByClassName("key");
  for (let i = 0; i < numbers.length; i++) {
    rows.item(i).textContent = numbers[indexNumbers];
    indexNumbers++;
  }
   
}

reset.addEventListener("click", function () {
   genRandomOrder();
   changeValueKeyboard();
})

//Botones 
registrar.addEventListener("click", function() {
  //Nif
  if (nif.value.length === 0) {
    mensajeError("Campo obligatorio", nif, formulario);    
  }
  //Fecha nacimiento
  if (fechaNacimiento.value.length === 0) {
    mensajeError("Campo obligatorio", fechaNacimiento, formulario);
  }
})


//Funciones 
function mensajeError(mensaje, elemento, contenedor) {
  if (elemento.nextSibling.nodeName === "SPAN") {
    elemento.nextSibling.remove();
  }
  let error = document.createElement("span");
  let errorText = document.createTextNode(mensaje);    
  error.appendChild(errorText);
  error.style.color = "red";
  contenedor.insertBefore(error, elemento.nextSibling); 
}




