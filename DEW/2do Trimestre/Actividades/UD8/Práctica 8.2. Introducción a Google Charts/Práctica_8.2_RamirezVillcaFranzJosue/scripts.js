let claveInut = document.getElementById("clave");
let valorInut = document.getElementById("valor");
let listNode = document.getElementById("list");

valorInut.addEventListener("blur", AddList);


function AddList() {
  //Create element
  let li = document.createElement("li");
  let liText = document.createTextNode(claveInut.value + "-" + valorInut.value);
  li.appendChild(liText);
  li.setAttribute("ondblclick", "EditTask(this)");
  let deleteNode = document.createElement("span");
  let deleteNodeText = document.createTextNode("X");
  deleteNode.style.color = "red";
  deleteNode.setAttribute("onclick", "DeleteItem(this)");
  deleteNode.appendChild(deleteNodeText);
  li.appendChild(deleteNode);
  listNode.appendChild(li);
  
}


//Edit Task
function EditTask(e) {
  let valueText = e.firstChild.nodeValue;
  let containerParent = document.createElement("span")
  //UNO
  let claveInputE = document.createElement("input");  
  claveInputE.setAttribute("value", divideText(valueText)[0]);
  claveInputE.setAttribute("onblur", "DeleteItem(this)");
  containerParent.appendChild(claveInputE)
 

  //DOS
  let claveInputE2 = document.createElement("input");  
  claveInputE2.setAttribute("value", divideText(valueText)[1]);
  claveInputE2.setAttribute("onblur", "DeleteItem(this)");
  containerParent.appendChild(claveInputE2)


  e.parentNode.replaceChild(containerParent, e);

  //claveInputE.focus();
}

function divideText(text) {
  return text.split("-");
}

//Delete list note
function DeleteItem(e) {
  if (event.type === "blur") {
    if (e.childNodes[0].value === 0 && e.childNodes[1].value === 0) {
      e.parentNode.remove();
    }
    if (e.childNodes[0].value > 0 && e.childNodes[1].value > 0) 
      ToParagraphHTML(e)    
  }
  if (event.type === "click")
    e.parentNode.remove();
}

function ToParagraphHTML(e) {
  let valueText = e.childNodes[0].value + "-" + e.childNodes[1].value;
  let paragraphNode = document.createElement("p");
  paragraphNode.setAttribute("ondblclick", "EditTask(this)");
  let paragraphText = document.createTextNode(valueText);
  paragraphNode.appendChild(paragraphText);
  e.removeAttribute("onblur");
  e.parentNode.replaceChild(paragraphNode, e);
}