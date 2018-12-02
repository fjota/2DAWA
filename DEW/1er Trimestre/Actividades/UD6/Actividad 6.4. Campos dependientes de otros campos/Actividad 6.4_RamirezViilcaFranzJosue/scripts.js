let vacaciones = document.getElementById("vacaciones");
let trabajo = document.getElementById("trabajo");
let container = document.getElementById("container");

vacaciones.addEventListener("click", function () {
  if (this.checked) {
    if (document.getElementById("content") != null) {
      container.removeChild(document.getElementById("content"));
    }
    crearVacaciones();
  }
});

trabajo.addEventListener("click", function () {
  if (this.checked) {
    if (document.getElementById("content") != null) {
      container.removeChild(document.getElementById("content"));
    }
    crearTrabajo();
  }
});

function crearVacaciones() {
  //content
  let content = document.createElement("div");
  content.setAttribute("id", "content");
  //br
  let br = document.createElement("br");
  //titulo
  let titulo = document.createElement("p");
  let textoTitulo = document.createTextNode("Elige tu estilo preferido de turismo");
  titulo.appendChild(textoTitulo);
  //playa
  let labelPlaya = document.createElement("label");
  let textoLabelPlaya = document.createTextNode("Playa");
  labelPlaya.appendChild(textoLabelPlaya);
  let inputPlaya = document.createElement("input");
  inputPlaya.setAttribute("type", "checkbox");
  //montaña
  let labelMontana = document.createElement("label");
  let textoLabelMontana = document.createTextNode("Montaña");
  labelMontana.appendChild(textoLabelMontana);
  let inputMontana = document.createElement("input");
  inputMontana.setAttribute("type", "checkbox");
  //urbano
  let labelUrbano = document.createElement("label");
  let textoLabelUrbano = document.createTextNode("Urbano");
  labelUrbano.appendChild(textoLabelUrbano);
  let inputUrbano = document.createElement("input");
  inputUrbano.setAttribute("type", "checkbox");
  //añadiendo  
  content.appendChild(titulo);

  content.appendChild(labelPlaya);
  content.appendChild(inputPlaya);
  content.appendChild(br.cloneNode());

  content.appendChild(labelMontana);
  content.appendChild(inputMontana);
  content.appendChild(br.cloneNode());

  content.appendChild(labelUrbano);
  content.appendChild(inputUrbano);
  content.appendChild(br.cloneNode());

  container.appendChild(content);
}

function crearTrabajo() {
  //content
  let content = document.createElement("div");
  content.setAttribute("id", "content");
  //br
  let br = document.createElement("br");
  //Pernoctas
  let pernoctasLabel = document.createElement("label");
  let textoPernoctasLabel = document.createTextNode("¿Pernoctas en fin de semana?");
  pernoctasLabel.appendChild(textoPernoctasLabel);
  let inputPernoctas = document.createElement("input");
  inputPernoctas.setAttribute("type", "checkbox");
  inputPernoctas.setAttribute("onclick", "checkPernoctas(this)");//Evnet
  //titulo
  let titulo = document.createElement("p");
  let textoTitulo = document.createTextNode("Posibles actividades de ocio");
  titulo.appendChild(textoTitulo);
  //Cine
  let labelCine = document.createElement("label");
  let textoLabelCine = document.createTextNode("Cine");
  labelCine.appendChild(textoLabelCine);
  let inputCine = document.createElement("input");
  inputCine.setAttribute("type", "checkbox");
  inputCine.setAttribute("disabled", "true");
  //montaña
  let labelTeatro = document.createElement("label");
  let textoLabelTeatro = document.createTextNode("Teatro");
  labelTeatro.appendChild(textoLabelTeatro);
  let inputTeatro = document.createElement("input");
  inputTeatro.setAttribute("type", "checkbox");
  inputTeatro.setAttribute("disabled", "true");
  //urbano
  let labelMuseos = document.createElement("label");
  let textoLabelMuseos = document.createTextNode("Museos");
  labelMuseos.appendChild(textoLabelMuseos);
  let inputMuseos = document.createElement("input");
  inputMuseos.setAttribute("type", "checkbox");
  inputMuseos.setAttribute("disabled", "true");
  //añadiendo  
  content.append(br.cloneNode());
  content.appendChild(pernoctasLabel);
  content.appendChild(inputPernoctas);

  content.appendChild(titulo);

  content.appendChild(labelCine);
  content.appendChild(inputCine);
  content.appendChild(br.cloneNode());

  content.appendChild(labelTeatro);
  content.appendChild(inputTeatro);
  content.appendChild(br.cloneNode());

  content.appendChild(labelMuseos);
  content.appendChild(inputMuseos);
  content.appendChild(br.cloneNode());

  container.appendChild(content);
}

function checkPernoctas(e) {
  for (let i = 0; i < e.parentNode.childNodes.length; i++) {
    if (e.parentNode.childNodes[i].nodeName === "INPUT") {
      if (e.parentNode.childNodes[i].attributes["onclick"] === undefined) {
        if (e.parentNode.childNodes[i].disabled === true) {
          e.parentNode.childNodes[i].disabled = false;
        } else {
          e.parentNode.childNodes[i].disabled = true;
        }
      }         
    }
  }  
}
