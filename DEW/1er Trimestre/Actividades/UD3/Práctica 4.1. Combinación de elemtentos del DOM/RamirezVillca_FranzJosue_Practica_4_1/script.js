let colorAmarillo = "yellow", colorVerde = "green", colorRojo = "red",
  fuenteSegoeUI = "Segoe UI", fuenteMonospace = "monospace", fuenteSansSerif = "sans-serif",
  textoNegrita = "bold", decoracionTexto = "underline", estiloFuenteItalic = "italic";

let configuracionEstilos = {
  "color": ["yellow", "green","red", "blue"],
  "fuente": ["Segoe UI", "monospace", "sans-serif"],
  "estiloTexto": ["bold"],
  "decoracionTexto": ["underline"],
  "estiloFuente": ["italic"]
};
console.log(configuracionEstilos);
function MostrarTexto2(e) {
  let datos = new FormData(formulario);
  let arrayFormulario = [];
  e.innerText = "X";
  for (const item of datos) {
    arrayFormulario.push(item[1]);        
  }
  for (const item of configuracionEstilos) {
      
  }
}







let columna = document.getElementById("columna");
let fila = document.getElementById("fila");
let tabla = document.getElementsByTagName("table").item(0);
let formulario = document.getElementsByTagName("form").item(0);

if (ObtenerCookie("tamanoTabla") != null) {
  document.getElementById("formularioTabla").remove();
  let tamanoTabla = ObtenerCookie("tamanoTabla");
  tamanoTabla = tamanoTabla.split(":");
  columna.value = tamanoTabla[0];
  fila.value = tamanoTabla[1];
  CrearTabla();
}

function CrearTabla() {
  if (TryParseInt(columna.value) === false || TryParseInt(fila.value) === false) {
    columna.style.borderColor = "red";
    fila.style.borderColor = "red";
  } else {
    let nodeTR = document.createElement("tr");
    let nodeTD = document.createElement("td");
    nodeTD.setAttribute("onclick", "MostrarTexto(this)");
    let nodeTDText = document.createTextNode("");
    nodeTD.appendChild(nodeTDText);
    //Crea una fila con todas las columnas
    for (let i = 0; i < parseInt(columna.value); i++) {
      nodeTR.appendChild(nodeTD.cloneNode(true));
    }
    //Rellena las filas restantes 
    for (let i = 0; i < parseInt(fila.value); i++) {
      tabla.appendChild(nodeTR.cloneNode(true));
    }
    if (ObtenerCookie("tamanoTabla") === null) {
      AlmacenarCookie("tamanoTabla", columna.value + ":" + fila.value, 3);
    }
    if (document.getElementById("formularioTabla") != null) {
      document.getElementById("formularioTabla").remove();
    }
  }
}

function MostrarTexto(e) {
  let datos = new FormData(formulario);
  e.innerText = "X";
  for (const item of datos) {
    switch (item[1].toString()) {
      case colorAmarillo:
        e.style.color = colorAmarillo;
        break;
      case colorVerde:
        e.style.color = colorVerde;
        break;
      case colorRojo:
        e.style.color = colorRojo;
        break;
      case fuenteSegoeUI:
        e.style.fontFamily = fuenteSegoeUI;
        break;
      case fuenteMonospace:
        e.style.fontFamily = fuenteMonospace;
        break;
      case fuenteSansSerif:
        e.style.fontFamily = fuenteSansSerif;
        break;
      case textoNegrita:
        e.style.fontWeight = textoNegrita;
        break;
      case estiloFuenteItalic:
        e.style.fontStyle = estiloFuenteItalic;
        break;
      case decoracionTexto:
        e.style.textDecoration = decoracionTexto;
        break;
    }
  }
}

function ObtenerCookie(name) {
  let index = document.cookie.indexOf(name + "=");
  if (index == -1) {
    return null;
  }
  index = document.cookie.indexOf("=", index) + 1;
  let endStr = document.cookie.indexOf(";", index);
  if (endStr == -1) {
    endStr = document.cookie.length;
  }
  return decodeURIComponent(document.cookie.substring(index, endStr));
}

function AlmacenarCookie(name, value, exdays) {
  let date = new Date();
  date.setTime(date.getTime() + (exdays * 24 * 60 * 60 * 1000));
  let expires = "expires" + "=" + date.toUTCString();
  document.cookie = name + "=" + encodeURIComponent(value) + ";" + expires + ";path=" + window.location.href + ";";
}

function TryParseInt(number) {
  let auxNumber = parseInt(number);
  let errorNumber = number.substring(auxNumber.toString().length);
  if (isNaN(errorNumber) || isNaN(auxNumber)) {
    return false;
  } else {
    return auxNumber;
  }
}

if (document.getElementById("genTabla") != null) {
  document.getElementById("genTabla").addEventListener("click", CrearTabla);
}
