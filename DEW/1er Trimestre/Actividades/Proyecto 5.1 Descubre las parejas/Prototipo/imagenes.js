let coches = [];
let frutas = [];
let pokemon = [];

function cargarImagenes() {

	coches[0] = "coches/alfaromeogiulia.jpg";
	coches[1] = "coches/alfaromeogiulieta.jpg";
	coches[2] = "coches/audia4.jpg";
	coches[3] = "coches/audia6.jpg";
	coches[4] = "coches/bmwserie5.jpg";
	coches[5] = "coches/bmwx3.jpg";
	coches[6] = "coches/citroencactus.jpg";
	coches[7] = "coches/citroenpicasso.jpg";
	coches[8] = "coches/ds3.jpg";
	coches[9] = "coches/ds5.jpeg";
	coches[10] = "coches/fiat500.jpg";
	coches[11] = "coches/fiatpanda.jpg";
	coches[12] = "coches/fordfiesta.jpg";
	coches[13] = "coches/fordfocus.jpg";
	coches[14] = "coches/hyundaii30.jpg";
	coches[15] = "coches/hyundaitucson.jpg";
	coches[16] = "coches/kiario.jpg";
	coches[17] = "coches/kiasportage.jpg";
	coches[18] = "coches/mazda2.jpg";
	coches[19] = "coches/mazda3.jpg";
	coches[20] = "coches/mercedesclasee.jpg";
	coches[21] = "coches/mercedesclases.jpg";
	coches[22] = "coches/nissanleaf.png";
	coches[23] = "coches/nissanqashqai.jpg";
	coches[24] = "coches/opelcorsa.jpg";
	coches[25] = "coches/opelinsignia.jpg";
	coches[26] = "coches/peugeot5008.jpg";
	coches[27] = "coches/peugeot508.jpg";
	coches[28] = "coches/porsche911.jpg";
	coches[29] = "coches/porschecayenne.jpg";
	coches[30] = "coches/renault captur.jpg";
	coches[31] = "coches/renault kadjar.jpeg";
	coches[32] = "coches/seatleon.jpg";
	coches[33] = "coches/seattarraco.jpg";
	coches[34] = "coches/skodakaroq.jpg";
	coches[35] = "coches/skodaoctavia.jpg";
	coches[36] = "coches/toyotaauris.jpg";
	coches[37] = "coches/toyotaprius.jpg";
	coches[38] = "coches/volkswagenpolo.jpeg";
	coches[39] = "coches/volkswagentroc.jpg";
	coches[40] = "coches/volvov40.jpg";
	coches[41] = "coches/volvoxc40.jpg";

	frutas[0] = "frutas/aguacate.jpg";
	frutas[1] = "frutas/ajo.jpg";
	frutas[2] = "frutas/alcachofa.jpg";
	frutas[3] = "frutas/apio.jpg";
	frutas[4] = "frutas/apio.png";
	frutas[5] = "frutas/calabaza.png";
	frutas[6] = "frutas/cebolla.jpg";
	frutas[7] = "frutas/cereza.jpg";
	frutas[8] = "frutas/coco.jpg";
	frutas[9] = "frutas/frambuesa.png";
	frutas[10] = "frutas/fresa.png";
	frutas[11] = "frutas/granada.jpeg";
	frutas[12] = "frutas/jengibre.jpg";
	frutas[13] = "frutas/kiwi.jpg";
	frutas[14] = "frutas/lechuga.jpeg";
	frutas[15] = "frutas/lechugaiceberg.png";
	frutas[16] = "frutas/lima.jpg";
	frutas[17] = "frutas/limon.jpeg";
	frutas[18] = "frutas/mandarina.jpeg";
	frutas[19] = "frutas/manzanaroja.jpg";
	frutas[20] = "frutas/manzanaverde.jpg";
	frutas[21] = "frutas/melocoton.png";
	frutas[22] = "frutas/melon.jpeg";
	frutas[23] = "frutas/millo.png";
	frutas[24] = "frutas/mora.jpeg";
	frutas[25] = "frutas/naranja.png";
	frutas[26] = "frutas/papa.jpg";
	frutas[27] = "frutas/pepino.jpeg";
	frutas[28] = "frutas/pepino.png";
	frutas[29] = "frutas/pera.jpg";
	frutas[30] = "frutas/pimientoamarillo.jpeg";
	frutas[31] = "frutas/pimientorojo.png";
	frutas[32] = "frutas/piña.jpeg";
	frutas[33] = "frutas/platano.jpeg";
	frutas[34] = "frutas/puerro.png";
	frutas[35] = "frutas/remolacha.jpg";
	frutas[36] = "frutas/sandia.png";
	frutas[37] = "frutas/tomate.png";
	frutas[38] = "frutas/uvablanca.jpg";
	frutas[39] = "frutas/uvaroja.jpg";
	frutas[40] = "frutas/zanahoria.png";
	frutas[41] = "frutas/uvaazul.jpeg";

	pokemon[0] = "pokemon/aerodactyl.png";
	pokemon[1] = "pokemon/arcanine.png";
	pokemon[2] = "pokemon/banette.png";
	pokemon[3] = "pokemon/blastoise.jpg";
	pokemon[4] = "pokemon/buterfree.jpg";
	pokemon[5] = "pokemon/charizard.png";
	pokemon[6] = "pokemon/cyndaquil.jpg";
	pokemon[7] = "pokemon/ditto.png";
	pokemon[8] = "pokemon/doduo.png";
	pokemon[9] = "pokemon/eevee.png";
	pokemon[10] = "pokemon/electabuzz.png";
	pokemon[11] = "pokemon/exeggcute.png";
	pokemon[12] = "pokemon/gastly.png";
	pokemon[13] = "pokemon/graveler.jpg";
	pokemon[14] = "pokemon/gyarados.png";
	pokemon[15] = "pokemon/hitmonchan.png";
	pokemon[16] = "pokemon/horsea.png";
	pokemon[17] = "pokemon/jigglypuff.png";
	pokemon[18] = "pokemon/jynx.png";
	pokemon[19] = "pokemon/kangaskhan.png";
	pokemon[20] = "pokemon/machoke.png";
	pokemon[21] = "pokemon/magikarp.png";
	pokemon[22] = "pokemon/magmar.png";
	pokemon[23] = "pokemon/marowak.png";
	pokemon[24] = "pokemon/meowth.png";
	pokemon[25] = "pokemon/mew.jpg";
	pokemon[26] = "pokemon/mewtwo.png";
	pokemon[27] = "pokemon/mrmime.jpg";
	pokemon[28] = "pokemon/nidoran.png";
	pokemon[29] = "pokemon/ninetales.png";
	pokemon[30] = "pokemon/oddish.jpg";
	pokemon[31] = "pokemon/omanyte.gif";
	pokemon[32] = "pokemon/onix.png";
	pokemon[33] = "pokemon/persian.png";
	pokemon[34] = "pokemon/pichu.png";
	pokemon[35] = "pokemon/pikachu.png";
	pokemon[36] = "pokemon/pinsir.png";
	pokemon[37] = "pokemon/porygon.png";
	pokemon[38] = "pokemon/psyduck.png";
	pokemon[39] = "pokemon/rhydon.png";
	pokemon[40] = "pokemon/seadra.png";
	pokemon[41] = "pokemon/seel.png";
	pokemon[42] = "pokemon/shinx.jpg";
	pokemon[43] = "pokemon/slowbro.png";
	pokemon[44] = "pokemon/snorlax.png";
	pokemon[45] = "pokemon/squirtle.png";
	pokemon[46] = "pokemon/tauros.png";
	pokemon[47] = "pokemon/vaporeon.png";
	pokemon[48] = "pokemon/venomoth.jpg";
	pokemon[49] = "pokemon/voltorb.png";
	pokemon[50] = "pokemon/wailmer.png";
	pokemon[51] = "pokemon/weedle.png";
	pokemon[52] = "pokemon/weezing.jpg";
	pokemon[53] = "pokemon/zapdos.png";

}

cargarImagenes();
let imagenesJuntas = [];
imagenesJuntas = imagenesJuntas.concat(coches);
imagenesJuntas = imagenesJuntas.concat(frutas);
imagenesJuntas = imagenesJuntas.concat(pokemon);

let imagenesArray = new Array(32*2);

//Obtener imagenes pares aleatorias
let random;
for (let i = 0; i < imagenesArray.length; i++) {
	random = Math.floor(Math.random() * imagenesJuntas.length);
	if (imagenesArray.find(imagen => imagen === imagenesJuntas[random]) === undefined) {
		imagenesArray[i] = imagenesJuntas[random];
		imagenesArray[i + 1] = imagenesJuntas[random];
		i++;
	} else {
		i -= 2;
	}
}

//ordenarlas aleatoriamente
let aux;
for (let i = 0; i < imagenesArray.length; i++) {
	random = Math.floor(Math.random() * imagenesArray.length);
	aux = imagenesArray[i];
	imagenesArray[i] = imagenesArray[random];
	imagenesArray[random] = aux;
}

/* 
console.log(imagenesArray); */

let container = document.getElementById("container");
let reverso = "reverso.png";

for (let i = 0; i < imagenesArray.length; i++) {
	let div = document.createElement("div");
	let img = document.createElement("img");
	/* img.setAttribute("src", imagenesArray[i]); */
	div.setAttribute("onclick", "MostrarCarta(this)");
	img.setAttribute("id", i);
	img.setAttribute("src", reverso);
	img.setAttribute("class", imagenesArray[i]);
	div.appendChild(img);
	container.appendChild(div);
}

let mostradas = 0;
let idImagen1, idImagen2;
let imagen1, imagen2;
let localizacionPath = document.location.pathname;
localizacionPath = localizacionPath.substr(1, location.length);
localizacionPath = localizacionPath.replace("index.html", "");
function MostrarCarta(e) {
	e.firstChild.src = localizacionPath.concat(imagenesArray[e.firstChild.id]);
	mostradas++;
	if (mostradas === 1) {
		idImagen1 = e.firstChild.id;
		imagen1 = e.firstChild.src;
	} else {
		idImagen2 = e.firstChild.id;
		imagen2 = e.firstChild.src;
	}
	if (mostradas === 2) {
		if (imagen1 === imagen2) {
			console.log("SIISISISISISIS");
			document.getElementById(idImagen1).parentElement.removeAttribute("onclick");
			document.getElementById(idImagen2).parentElement.removeAttribute("onclick");
		} else {
			setTimeout(function() {
				console.log("NONONONONO");
				document.getElementById(idImagen1).src = localizacionPath.concat("reverso.png");
				document.getElementById(idImagen2).src = localizacionPath.concat("reverso.png");
			}, 180);

		}
		mostradas = 0;
	}
}
