//Load images
let images = [
  /*  "assets/img/coches/alfaromeogiulia.jpg",
   "assets/img/coches/alfaromeogiulieta.jpg",
   "assets/img/coches/audia4.jpg",
   "assets/img/coches/audia6.jpg",
   "assets/img/coches/bmwserie5.jpg",
   "assets/img/coches/bmwx3.jpg",
   "assets/img/coches/citroencactus.jpg",
   "assets/img/coches/citroenpicasso.jpg",
   "assets/img/coches/ds3.jpg",
   "assets/img/coches/ds5.jpeg",
   "assets/img/coches/fiat500.jpg",
   "assets/img/coches/fiatpanda.jpg",
   "assets/img/coches/fordfiesta.jpg",
   "assets/img/coches/fordfocus.jpg",
   "assets/img/coches/hyundaii30.jpg",
   "assets/img/coches/hyundaitucson.jpg",
   "assets/img/coches/kiario.jpg",
   "assets/img/coches/kiasportage.jpg",
   "assets/img/coches/mazda2.jpg",
   "assets/img/coches/mazda3.jpg",
   "assets/img/coches/mercedesclasee.jpg",
   "assets/img/coches/mercedesclases.jpg",
   "assets/img/coches/nissanleaf.png",
   "assets/img/coches/nissanqashqai.jpg",
   "assets/img/coches/opelcorsa.jpg",
   "assets/img/coches/opelinsignia.jpg",
   "assets/img/coches/peugeot5008.jpg",
   "assets/img/coches/peugeot508.jpg",
   "assets/img/coches/porsche911.jpg",
   "assets/img/coches/porschecayenne.jpg",
   "assets/img/coches/renault captur.jpg",
   "assets/img/coches/renault kadjar.jpeg",
   "assets/img/coches/seatleon.jpg",
   "assets/img/coches/seattarraco.jpg",
   "assets/img/coches/skodakaroq.jpg",
   "assets/img/coches/skodaoctavia.jpg",
   "assets/img/coches/toyotaauris.jpg",
   "assets/img/coches/toyotaprius.jpg",
   "assets/img/coches/volkswagenpolo.jpeg",
   "assets/img/coches/volkswagentroc.jpg",
   "assets/img/coches/volvov40.jpg",
   "assets/img/coches/volvoxc40.jpg", */
  "assets/img/frutas/aguacate.jpg",
  "assets/img/frutas/ajo.jpg",
  "assets/img/frutas/alcachofa.jpg",
  "assets/img/frutas/apio.jpg",
  "assets/img/frutas/apio.png",
  "assets/img/frutas/calabaza.png",
  "assets/img/frutas/cebolla.jpg",
  "assets/img/frutas/cereza.jpg",
  "assets/img/frutas/coco.jpg",
  "assets/img/frutas/frambuesa.png",
  "assets/img/frutas/fresa.png",
  "assets/img/frutas/granada.jpeg",
  "assets/img/frutas/jengibre.jpg",
  "assets/img/frutas/kiwi.jpg",
  "assets/img/frutas/lechuga.jpeg",
  "assets/img/frutas/lechugaiceberg.png",
  "assets/img/frutas/lima.jpg",
  "assets/img/frutas/limon.jpeg",
  "assets/img/frutas/mandarina.jpeg",
  "assets/img/frutas/manzanaroja.jpg",
  "assets/img/frutas/manzanaverde.jpg",
  "assets/img/frutas/melocoton.png",
  "assets/img/frutas/melon.jpeg",
  "assets/img/frutas/millo.png",
  "assets/img/frutas/mora.jpeg",
  "assets/img/frutas/naranja.png",
  "assets/img/frutas/papa.jpg",
  "assets/img/frutas/pepino.jpeg",
  "assets/img/frutas/pepino.png",
  "assets/img/frutas/pera.jpg",
  "assets/img/frutas/pimientoamarillo.jpeg",
  "assets/img/frutas/pimientorojo.png",
  "assets/img/frutas/piña.jpeg",
  "assets/img/frutas/platano.jpeg",
  "assets/img/frutas/puerro.png",
  "assets/img/frutas/remolacha.jpg",
  "assets/img/frutas/sandia.png",
  "assets/img/frutas/tomate.png",
  "assets/img/frutas/uvablanca.jpg",
  "assets/img/frutas/uvaroja.jpg",
  "assets/img/frutas/zanahoria.png",
  "assets/img/frutas/uvaazul.jpeg",
  "assets/img/pokemon/aerodactyl.png",
  "assets/img/pokemon/arcanine.png",
  "assets/img/pokemon/banette.png",
  "assets/img/pokemon/blastoise.jpg",
  "assets/img/pokemon/buterfree.jpg",
  "assets/img/pokemon/charizard.png",
  "assets/img/pokemon/cyndaquil.jpg",
  "assets/img/pokemon/ditto.png",
  "assets/img/pokemon/doduo.png",
  "assets/img/pokemon/eevee.png",
  "assets/img/pokemon/electabuzz.png",
  "assets/img/pokemon/exeggcute.png",
  "assets/img/pokemon/gastly.png",
  "assets/img/pokemon/graveler.jpg",
  "assets/img/pokemon/gyarados.png",
  "assets/img/pokemon/hitmonchan.png",
  "assets/img/pokemon/horsea.png",
  "assets/img/pokemon/jigglypuff.png",
  "assets/img/pokemon/jynx.png",
  "assets/img/pokemon/kangaskhan.png",
  "assets/img/pokemon/machoke.png",
  "assets/img/pokemon/magikarp.png",
  "assets/img/pokemon/magmar.png",
  "assets/img/pokemon/marowak.png",
  "assets/img/pokemon/meowth.png",
  "assets/img/pokemon/mew.jpg",
  "assets/img/pokemon/mewtwo.png",
  "assets/img/pokemon/mrmime.jpg",
  "assets/img/pokemon/nidoran.png",
  "assets/img/pokemon/ninetales.png",
  "assets/img/pokemon/oddish.jpg",
  "assets/img/pokemon/omanyte.gif",
  "assets/img/pokemon/onix.png",
  "assets/img/pokemon/persian.png",
  "assets/img/pokemon/pichu.png",
  "assets/img/pokemon/pikachu.png",
  "assets/img/pokemon/pinsir.png",
  "assets/img/pokemon/porygon.png",
  "assets/img/pokemon/psyduck.png",
  "assets/img/pokemon/rhydon.png",
  "assets/img/pokemon/seadra.png",
  "assets/img/pokemon/seel.png",
  "assets/img/pokemon/shinx.jpg",
  "assets/img/pokemon/slowbro.png",
  "assets/img/pokemon/snorlax.png",
  "assets/img/pokemon/squirtle.png",
  "assets/img/pokemon/tauros.png",
  "assets/img/pokemon/vaporeon.png",
  "assets/img/pokemon/venomoth.jpg",
  "assets/img/pokemon/voltorb.png",
  "assets/img/pokemon/wailmer.png",
  "assets/img/pokemon/weedle.png",
  "assets/img/pokemon/weezing.jpg",
  "assets/img/pokemon/zapdos.png"
];

//Game menu scripts
let menuContainer = document.getElementById("menu");
let gameContainer = document.getElementById("game");
let btnStart = document.getElementById("start");
let imagesToShow;
let reversoImg = "assets/img/reverso.png";
let numImages;
let difficulty;
let centesimas = 0;
let segundos = 0;
let minutos = 0;
let points = 0;
let maxScore, numGamesPlayed;
let arrayScores = [];

btnStart.addEventListener("click", function () {
  menuContainer.style.display = "none";
  gameContainer.classList.add("grid-container-show");
  difficulty = document.getElementById("difficulty").value;
  switch (difficulty) {
    case "4":
      numImages = 8 * 2;
      break;
    case "6":
      numImages = 18 * 2;
      break;
    case "8":
      numImages = 32 * 2;
      break;
  }
  startGame(difficulty, numImages - 1);
});

//Game start
function startGame(difficulty, numImages) {
  restartGame();
  imagesToShow = new Array(Math.floor(numImages / 2) + 1);
  let random;
  //Load random and unique images    
  for (let i = 0; i < imagesToShow.length; i++) {
    random = Math.floor(Math.random() * images.length);
    if (imagesToShow.find(image => image === images[random]) === undefined) {
      imagesToShow[i] = images[random];
    } else {
      i--;
    }
  }

  //Clone array for double pairs
  imagesToShow = imagesToShow.concat(imagesToShow);

  //Random order images
  let aux;
  for (let i = 0; i < imagesToShow.length; i++) {
    random = Math.floor(Math.random() * imagesToShow.length);
    aux = imagesToShow[i];
    imagesToShow[i] = imagesToShow[random];
    imagesToShow[random] = aux;
  }

  showImages(imagesToShow, difficulty);
}

let controlTimer;
function showImages(imagesToShow, difficulty) {
  let gridContainer = document.getElementById("gridContainer");
  document.documentElement.style.setProperty("--rowNum", difficulty);
  document.documentElement.style.setProperty("--colNum", difficulty);
  for (let i = 0; i < imagesToShow.length; i++) {
    let item = document.createElement("div");
    let img = document.createElement("img");
    item.setAttribute("onclick", "showCard(this)");
    item.setAttribute("class", "grid-item");
    img.setAttribute("id", i);
    img.setAttribute("src", reversoImg);
    img.setAttribute("onmouseover", "showBorder(this)");
    img.setAttribute("onmouseout", "hideBorder(this)");
    item.appendChild(img);
    gridContainer.appendChild(item);
  }
  //Init timer
  controlTimer = setInterval(timer, 10);
}

let cardsShowed = 0;
let cardsWin = 0;
let idImage1, idImage2, image1, image2;
let localizacionPath = document.location.pathname;
localizacionPath = localizacionPath.substr(1, location.length);
localizacionPath = localizacionPath.replace("index.html", "");

function showCard(e) {
  if (cardsShowed < 2) {
    e.firstChild.src = localizacionPath.concat(imagesToShow[e.firstChild.id]);
    e.classList.add("flip-image");
  }
  cardsShowed++;
  if (cardsShowed === 1) {
    idImage1 = e.firstChild.id;
    image1 = e.firstChild.src;
  }
  if (cardsShowed === 2) {
    idImage2 = e.firstChild.id;
    image2 = e.firstChild.src;
    if (image1 === image2 && idImage1 != idImage2) {
      infoGame(10);
      document.getElementById(idImage1).parentElement.removeAttribute("onclick");
      document.getElementById(idImage2).parentElement.removeAttribute("onclick");
      document.getElementById(idImage1).parentElement.classList.remove("flip-image");
      document.getElementById(idImage2).parentElement.classList.remove("flip-image");
      cardsShowed = 0;
      cardsWin++;
    } else {
      setTimeout(function () {
        infoGame(-1);
        document.getElementById(idImage1).src = localizacionPath.concat(reversoImg);
        document.getElementById(idImage2).src = localizacionPath.concat(reversoImg);
        document.getElementById(idImage1).parentElement.classList.remove("flip-image");
        document.getElementById(idImage2).parentElement.classList.remove("flip-image");
        cardsShowed = 0;
      }, 550) //50ms plus to animation
    }
  }
  if (cardsWin * 2 === numImages) {
    gameWin();
  }
}

function timer() {
  if (centesimas < 99) {
    centesimas++;
    if (centesimas < 10) { centesimas = "0" + centesimas }
  }
  if (centesimas == 99) {
    centesimas = -1;
  }
  if (centesimas == 0) {
    segundos++;
    if (segundos < 10) { segundos = "0" + segundos }
    document.getElementsByClassName("info-game")[0].lastElementChild.innerHTML = `${minutos}:${segundos}`;
  }
  if (segundos == 59) {
    segundos = -1;
  }
  if ((centesimas == 0) && (segundos == 0)) {
    minutos++;
    if (minutos < 10) { minutos = "0" + minutos }
    document.getElementsByClassName("info-game")[0].lastElementChild.innerHTML = `${minutos}:${segundos}`;
  }
  if (minutos == 59) {
    minutos = -1;
  }
}

function gameWin() {
  clearInterval(controlTimer);
  document.getElementsByClassName("game-win").item(0).innerHTML = `
  <h2>Has ganado</h2>    
  <p>Introduce tu nombre:</p>
  <input type="text" id="nombreUsuario">
  <input type='button' onclick='saveGame(this)' value='Guardar partida'/>
  <input type='button' onclick='startGame(${difficulty}, ${numImages - 1})' value='Reiniciar juego'/>
  `;
}


function saveGame(e) {
  localStorage.setItem(document.getElementById("nombreUsuario").value,
    document.getElementById("nombreUsuario").value + ";" +
    new Date().toLocaleString() + ";" +
    points + ";" +
    document.getElementsByClassName("info-game")[0].lastElementChild.innerHTML);
}

function restartGame() {
  if (document.getElementById("gridContainer").childElementCount > 0) {
    while (document.getElementById("gridContainer").firstChild) {
      document.getElementById("gridContainer").removeChild(document.getElementById("gridContainer").firstChild);
    }
  }
  document.getElementsByClassName("game-win").item(0).innerHTML = "";
  centesimas = 0, segundos = 0, minutos = 0, points = 0, cardsWin = 0;
}

function showBorder(e) {
  e.style.border = "2px solid black";
}

function hideBorder(e) {
  e.style.border = "none";
}

//MODAL SCORES
let scoresBtn = document.getElementById("scores");
let modal = document.getElementById("settings-modal");
let closeModalBtn = document.getElementsByClassName("close").item(0);

scoresBtn.addEventListener("click", showModal);
closeModalBtn.addEventListener("click", closeModal);


loadScores();
function showModal() {
  modal.style.display = "block";
}

function loadScores() {  
  let listScores = document.getElementById("listScores");
  for (var i = 0; i < localStorage.length; i++) {
    var key = localStorage.key(i);
    var value = localStorage.getItem(key);
    arrayScores.push(value.split(";"));
  }
  //Order array
  arrayScores = arrayScores.sort(orderArrayScores);
  numGamesPlayed = arrayScores.length;
  maxScore = arrayScores[0][2];
  //Show all scores
  let arrayOrdenado = [];
  let oneScore = "";
  for (let j = 0; j < arrayScores.length; j++) {
    for (let i = 0; i < arrayScores[j].length; i++) {
      oneScore += arrayScores[j][i] + " - ";
    }
    let listItem = document.createElement("li");
    let listTextItem = document.createTextNode(oneScore);
    listItem.appendChild(listTextItem);
    listScores.appendChild(listItem);
    oneScore = "";
  }
}

function orderArrayScores(a, b) {
  if (a[2] > b[2]) {
    return -1;
  }
  if (a[2] < b[2]) {
    return 1;
  }
  if (a[2] === b[2]) {
    if (a[3] > b[3]) {
      return 1;
    }
    if (a[3] < b[3]) {
      return -1;
    }
  }
  if (a[2] === b[2] && a[3] === b[3]) {
    if (a[1] > b[1]) {
      return 1;
    }
    if (a[1] < b[1]) {
      return -1;
    }
  }
}

function closeModal() {
  modal.style.display = "none";
}

window.onclick = function (event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
infoGame(0);
function infoGame(num) {
  points += num;
  if (points < 0) {
    points = 0;
  }
  document.getElementsByClassName("info-game")[0].firstElementChild.innerHTML = `${points} puntos`;
  document.getElementsByClassName("info-game")[0].firstElementChild.nextElementSibling.innerHTML= `Numero de partidas jugadas: ${numGamesPlayed} - Maxima puntuacion global: ${maxScore}`;
}
