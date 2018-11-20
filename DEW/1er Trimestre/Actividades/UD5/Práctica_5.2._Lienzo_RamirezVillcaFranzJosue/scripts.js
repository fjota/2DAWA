let table;
let isdown = false;
let selectedColor = "black";
let colorsPalete = ["blue", "yellow", "red", "green", "DarkBlue", "Thistle",
  "SpringGreen", "SaddleBrown", "Purple", "Plum", "orange", "Maroon"];
let row = 80;
let column = 200;

//Canvas table
table = document.createElement("table");
document.body.appendChild(table);
for (let i = 0; i < row; i++) {
  let tr = document.createElement("tr");  
  table.appendChild(tr);
  for (let j = 0; j < column; j++) {
    let td = document.createElement("td");        
    td.setAttribute("onmousedown", "Active(this)");
    td.setAttribute("onmouseover", "Paint(this)");
    td.setAttribute("onmouseup", "Disable(this)");   
    tr.appendChild(td);
  }
}

//Palete color table
table = document.createElement("table");
document.body.appendChild(table);
let tr = document.createElement("tr");
table.appendChild(tr);
for (let i = 0; i < 12; i++) {
  let td = document.createElement("td");
  td.setAttribute("onclick", "GetColor(this)");
  td.style.backgroundColor = colorsPalete[i];
  tr.appendChild(td);
}

//Visor color container
let visor = document.createElement("div");
visor.setAttribute("id", "visor");
document.body.appendChild(visor);

//Paint table canvas
function Paint(e) {
  if (isdown === true) {
    e.style.backgroundColor = selectedColor;
  }
  event.preventDefault();
}

//Get color of palete
function GetColor(e) {
  document.getElementById("visor").style.backgroundColor = e.style.backgroundColor;
  selectedColor = e.style.backgroundColor;
}

//Used for simulate drag mouse
function Active(e) { 
  isdown = true;
}
function Disable(e) { 
  isdown = false;
}