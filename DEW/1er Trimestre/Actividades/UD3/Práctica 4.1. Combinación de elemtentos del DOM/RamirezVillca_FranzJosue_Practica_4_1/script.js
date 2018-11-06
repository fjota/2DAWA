let colorAmarillo = "yellow", colorVerde = "green", colorRojo = "red",
  fuenteFantasy = "fantasy", fuenteMonospace = "monospace", fuenteSansSerif = "sans-serif",
  textoNegrita = "bold", decoracionTexto = "underline", estiloFuenteItalic = "italic";

let columna = document.getElementById("columna");
let fila = document.getElementById("fila");
let tabla = document.getElementsByTagName("table").item(0);
let formulario = document.getElementsByTagName("form").item(0);

if (GetCookie("tamanoTabla") != null) {
  document.getElementById("formularioTabla").remove();
  let tamanoTabla = GetCookie("tamanoTabla");
  tamanoTabla = tamanoTabla.split(":");
  columna.value = tamanoTabla[0];
  fila.value = tamanoTabla[1];
  CrearTabla();
}

function CrearTabla() {
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
  
  if (GetCookie("tamanoTabla") === null ) {
    SetCookie("tamanoTabla", columna.value + ":" + fila.value, 3);    
  }
  document.getElementById("formularioTabla").remove();
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
      case fuenteFantasy:
        e.style.fontFamily = fuenteFantasy;
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
  };
}

function GetCookie(name) {
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

function SetCookie(name, value, exdays) {
  let date = new Date();
  date.setTime(date.getTime() + (exdays * 24 * 60 * 60 * 1000));
  let expires = "expires" + "=" + date.toUTCString();
  document.cookie = name + "=" + encodeURIComponent(value) + ";" + expires + ";path=" + window.location.href + ";";
}

document.getElementById("genTabla").addEventListener("click", CrearTabla);