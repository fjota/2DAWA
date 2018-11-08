let columna = document.getElementById("columna");
let fila = document.getElementById("fila");
let tabla = document.getElementsByTagName("table").item(0);
let formulario = document.getElementsByTagName("form").item(0);

//Elimina el formulario por el cual se especifica el tamaño de la tabla, si ya se guardo en las cookies
if (ObtenerCookie("tamanoTabla") != null) {
  document.getElementById("formularioTabla").remove();
  let tamanoTabla = ObtenerCookie("tamanoTabla");
  tamanoTabla = tamanoTabla.split(":");
  columna.value = tamanoTabla[0];
  fila.value = tamanoTabla[1];
  CrearTabla();
}

/* Evento para generar la tabla */
if (document.getElementById("genTabla") != null) {
  document.getElementById("genTabla").addEventListener("click", CrearTabla);
}
/* Evento para Escribir dentro del td que clicamos */
document.querySelector("#tabla").addEventListener("click", MostrarTexto);

function CrearTabla() {
  if (TryParseInt(columna.value) === false || TryParseInt(fila.value) === false) {
    columna.style.borderColor = "red";
    fila.style.borderColor = "red";
  } else {
    let nodeTR = document.createElement("tr");
    let nodeTD = document.createElement("td");
    /* nodeTD.setAttribute("onclick", "MostrarTexto(this)"); */
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
  if (e.target.id != "tabla") {
    let datos = new FormData(formulario);
    e.target.innerText = "X";
    for (const item of datos) {
      switch (item[0].toString()) {
        case "color":
          e.target.style.color = item[1].toString();
          break;
        case "fuente":
          e.target.style.fontFamily = item[1].toString();
          break;
        case "estiloTexto":
          e.target.style.fontWeight = item[1].toString();
          break;
        case "estiloFuente":
          e.target.style.fontStyle = item[1].toString();
          break;
        case "decoracionTexto":
          e.target.style.textDecoration = item[1].toString();
          break;
      }
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


