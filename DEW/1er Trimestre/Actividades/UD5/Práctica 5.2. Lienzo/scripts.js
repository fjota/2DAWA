let table = document.createElement("table"),
    table2 = document.createElement("table"),
    tr = document.createElement("tr"),
    tr2 = document.createElement("tr"),
    td = document.createElement("td"),
    td2 = document.createElement("td")
    visor = document.createElement("div"),
    fila = 80, //400
    columna = 150; //300

//Primera Tabla
document.body.appendChild(table);
table.appendChild(tr);
for (let i = 0; i < columna; i++) {
  tr.appendChild(td.cloneNode());
}
for (let i = 0; i < fila; i++) {
  table.appendChild(tr.cloneNode(true));
}

//Segunda Tabla
document.body.appendChild(table2);
table2.appendChild(tr2);
for (let i = 0; i < 12; i++) {
  tr2.appendChild(td2.cloneNode());
}

//Visor de color
document.body.appendChild(visor);