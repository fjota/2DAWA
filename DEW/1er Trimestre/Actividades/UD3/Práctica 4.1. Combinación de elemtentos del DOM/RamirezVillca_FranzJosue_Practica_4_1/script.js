let columna = document.getElementById("columna");
let fila = document.getElementById("fila");
let tabla = document.getElementsByTagName("table").item(0);

let nodeTR = document.createElement("tr");
let nodeTD = document.createElement("td");
nodeTD.setAttribute("onclick", "ShowTextFormated(this)");
let nodeTDText = document.createTextNode("");
nodeTD.appendChild(nodeTDText);

document.getElementById("genTabla").addEventListener("click", function () {
  for (let i = 0; i < parseInt(columna.value); i++) {
    tabla.appendChild(nodeTR);
    nodeTR.appendChild(nodeTD.cloneNode(true));
  }
  for (let i = 0; i < parseInt(fila.value) - 1; i++) {
    tabla.appendChild(nodeTR.cloneNode(true));
  }
});

function ShowTextFormated(e) {
  var data = new FormData(document.getElementsByTagName("form").item(0));
  var output = "";
  for (const entry of data) {
    output = entry[0] + "=" + entry[1] + "\r";
  };
  e.innerText = output;
  event.preventDefault()
}