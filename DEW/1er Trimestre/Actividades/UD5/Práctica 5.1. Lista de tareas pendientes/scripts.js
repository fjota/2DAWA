let addItemBtn = document.getElementById("add");
let listNode = document.getElementById("list");

addItemBtn.addEventListener("click", AddList);

function AddList() {
  let li = document.createElement("li");  
  let textInput = document.createElement("input");
  let deleteNode = document.createElement("span");
  let deleteNodeText = document.createTextNode("X");  
  li.appendChild(textInput);
  deleteNode.appendChild(deleteNodeText);
  deleteNode.setAttribute("onclick", DeleteItem);
  li.appendChild(deleteNode);
  listNode.appendChild(li);
}

function DeleteItem(e) {
  console.log("dasdas");
}

