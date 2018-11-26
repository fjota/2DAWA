let addItemBtn = document.getElementById("add");
let listNode = document.getElementById("list");

addItemBtn.addEventListener("click", AddList);

function AddList() {
  //Create element
  let li = document.createElement("li");
  let textInput = document.createElement("input");
  let deleteNode = document.createElement("span");
  let deleteNodeText = document.createTextNode("X");
  textInput.setAttribute("value", "");
  textInput.setAttribute("onblur", "DeleteItem(this)");
  textInput.setAttribute("onkeyup", "ItemAdded(this)");
  li.appendChild(textInput);
  deleteNode.style.color = "red";
  deleteNode.setAttribute("onclick", "DeleteItem(this)");
  deleteNode.appendChild(deleteNodeText);
  li.appendChild(deleteNode);
  listNode.appendChild(li);
  textInput.focus();
}

//Add task
function ItemAdded(e) {
  event.preventDefault();
  if (event.keyCode === 13) {
    if (e.value.length > 0) {
      ToParagraphHTML(e);      
    } else {
      e.removeAttribute("onblur");
      e.parentNode.remove();
    }
  }
}

//Edit Task
function EditTask(e) {
  let valueText = e.innerHTML;
  let textInput = document.createElement("input");
  textInput.setAttribute("value", valueText);
  textInput.setAttribute("onblur", "DeleteItem(this)");
  textInput.setAttribute("onkeyup", "ItemAdded(this)");
  e.parentNode.replaceChild(textInput, e);
  textInput.focus();
}

//Delete list note
function DeleteItem(e) {
  if (event.type === "blur") {
    if (e.value.length === 0)
      e.parentNode.remove();
    if (e.value.length > 0) 
      ToParagraphHTML(e)    
  }
  if (event.type === "click")
    e.parentNode.remove();
}

function ToParagraphHTML(e) {
  let valueText = e.value;
  let paragraphNode = document.createElement("p");
  paragraphNode.setAttribute("ondblclick", "EditTask(this)");
  let paragraphText = document.createTextNode(valueText);
  paragraphNode.appendChild(paragraphText);
  e.removeAttribute("onblur");
  e.parentNode.replaceChild(paragraphNode, e);
}