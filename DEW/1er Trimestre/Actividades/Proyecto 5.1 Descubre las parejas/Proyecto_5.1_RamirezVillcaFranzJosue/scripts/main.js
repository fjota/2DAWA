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

btnStart.addEventListener("click", function () {
  menuContainer.style.display = "none";
  gameContainer.style.display = "block";
  let difficulty = document.getElementById("difficulty").value;
  let numImages;
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
  startGame(difficulty, numImages-1);
});


//Game start
function startGame(difficulty, numImages) {
  console.log(numImages);
  imagesToShow = new Array(numImages);
  console.log(imagesToShow);
  let random;
  //Load random and unique images 
  for (let i = 0; i < imagesToShow.length; i++) {
    random = Math.floor(Math.random() * images.length);
    if (imagesToShow.find(image => image === images[random]) === undefined) {
      imagesToShow[i] = images[random];
      imagesToShow[i + 1] = images[random];
      i++;
    } else {
      i -= 2;
    }
  }
  /* imagesToShow = imagesToShow.slice(0); */
  
  
  //Random order images
  let aux;
  for (let i = 0; i < imagesToShow.length; i++) {
    random = Math.floor(Math.random() * imagesToShow.length);
    aux = imagesToShow[i];
    imagesToShow[i] = images[random];
    imagesToShow[random] = aux;
  }

  showImages(imagesToShow, difficulty);
}

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
    /* img.setAttribute("src", reversoImg); */
    img.setAttribute("src", imagesToShow[i]);
    img.setAttribute("class", imagesToShow[i]);
    item.appendChild(img);
    gridContainer.appendChild(item);
  }
}

let cardsShowed = 0;
let idImage1, idImage2, image1, image2;
function showCard(e) {
  let localizacionPath = document.location.pathname;
  localizacionPath = localizacionPath.substr(1, location.length);
  localizacionPath = localizacionPath.replace("index.html", "");
  e.firstChild.src = localizacionPath.concat(imagesToShow[e.firstChild.id]);
  cardsShowed++;
  if (cardsShowed === 1) {
    idImage1 = e.firstChild.id;
    image1 = e.firstChild.src;
  } else {
    idImage2 = e.firstChild.id;
    image2 = e.firstChild.src;
  }

  if (cardsShowed === 2) {
    console.log(idImage1);
    console.log(idImage2);

    if (image1 === image2) {
      console.log("ACERTASTE");
      document.getElementById(idImage1).parentElement.removeAttribute("onclick");
      document.getElementById(idImage2).parentElement.removeAttribute("onclick");
    } else {
      setTimeout(function () {
        console.log("FALLASTE COMPAÑERO");
        document.getElementById(idImage1).src = localizacionPath.concat(reversoImg);
        document.getElementById(idImage2).src = localizacionPath.concat(reversoImg);
      }, 180)
    }
    cardsShowed = 0;
  }

}

