let claveInut = document.getElementById("clave");
let valorInut = document.getElementById("valor");
let listNode = document.getElementById("list");
let selectChart = document.getElementById("chart")
let chartElement = document.getElementById("chart_div");
let dataArray = [["dato", "valor"]];

valorInut.addEventListener("blur", AddList);

function AddList() {
  if (claveInut.value.length > 0 && valorInut.value.length > 0 && !isNaN(valorInut.value)) {
    //Datos
    dataArray.push([claveInut.value, parseInt(valorInut.value)]);
  
    //Create element
    let li = document.createElement("li");
    let liText = document.createTextNode(claveInut.value + "-" + valorInut.value);
    li.appendChild(liText);
    li.setAttribute("ondblclick", "EditTask(this)");
    let deleteNode = document.createElement("span");
    let deleteNodeText = document.createTextNode(" X");
    deleteNode.style.color = "red";
    deleteNode.setAttribute("onclick", "DeleteItem(this)");
    deleteNode.appendChild(deleteNodeText);
    li.appendChild(deleteNode);
    listNode.appendChild(li);
    
  }

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
}

function divideText(text) {
  return text.split("-");
}

//Delete list note
function DeleteItem(e) {
  if (event.type === "blur") {
    if (e.parentNode.childNodes[0].value.length === 0 && e.parentNode.childNodes[1].value.length === 0) {
      e.parentNode.remove();
    }
    if (e.parentNode.childNodes[0].value.length > 0 && e.parentNode.childNodes[1].value.length > 0) {
      ToParagraphHTML(e)
      LoadDataArray();
    }
  }
  if (event.type === "click") {
    e.parentNode.remove();
    LoadDataArray()
  }
}

function ToParagraphHTML(e) {
  let valueText = e.parentNode.childNodes[0].value + "-" + e.parentNode.childNodes[1].value;
  let paragraphNode = document.createElement("p");
  paragraphNode.setAttribute("ondblclick", "EditTask(this)");
  let paragraphText = document.createTextNode(valueText);
  paragraphNode.appendChild(paragraphText);
  e.removeAttribute("onblur");

  e.parentNode.parentNode.replaceChild(paragraphNode, e.parentNode);
}

function LoadDataArray() {
  dataArray = []
  for (let i = 0; i < listNode.children.length; i++) {
    dataArray.push([listNode.children[i].firstChild.nodeValue.split("-")[0], parseInt(listNode.children[i].firstChild.nodeValue.split("-")[1])])
  }
  dataArray.unshift(["dato", "valor"])
}

selectChart.addEventListener("change", function () {

  switch (selectChart.value) {
    case "PieChart":
      PieChart();
      break;
    case "DonutChart":
      DonutChart();
      break;
    case "BarChart":
      BarChart();
      break;
  }
})

function PieChart() {
  chartElement.firstChild ? chartElement.firstChild.remove() : "";
  google.charts.load('current', { 'packages': ['corechart'] });
  google.charts.setOnLoadCallback(drawChart);

  function drawChart() {

    var data = google.visualization.arrayToDataTable(dataArray);

    var options = {
      title: 'Mis datos'
    };

    var chart = new google.visualization.PieChart(chartElement);

    chart.draw(data, options);
  }
}

function DonutChart() {
  chartElement.firstChild ? chartElement.firstChild.remove() : "";
  google.charts.load("current", { packages: ["corechart"] });
  google.charts.setOnLoadCallback(drawChart);
  function drawChart() {
    var data = google.visualization.arrayToDataTable(dataArray);

    var options = {
      title: 'Mis datos',
      pieHole: 0.4,
    };

    var chart = new google.visualization.PieChart(chartElement);
    chart.draw(data, options);
  }
}

function BarChart() {
  chartElement.firstChild ? chartElement.firstChild.remove() : "";
  google.charts.load('current', { 'packages': ['corechart'] });
  google.charts.setOnLoadCallback(drawChart);

  function drawChart() {
    var data = google.visualization.arrayToDataTable(dataArray);

    var options = {
      title: 'Mis datos',
      legend: 'none'
    };

    var chart = new google.visualization.ScatterChart(chartElement);

    chart.draw(data, options);
  }
}