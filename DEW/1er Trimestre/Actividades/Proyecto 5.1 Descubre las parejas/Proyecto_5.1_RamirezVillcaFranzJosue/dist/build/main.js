define("imagenes", ["require", "exports"], function (require, exports) {
    "use strict";
    Object.defineProperty(exports, "__esModule", { value: true });
    var Images = /** @class */ (function () {
        function Images() {
            this.coches = [];
            this.frutas = [];
            this.pokemon = [];
        }
        Images.prototype.loadImages = function () {
            this.coches[0] = "coches/alfaromeogiulia.jpg";
            this.coches[1] = "coches/alfaromeogiulieta.jpg";
            this.coches[2] = "coches/audia4.jpg";
            this.coches[3] = "coches/audia6.jpg";
            this.coches[4] = "coches/bmwserie5.jpg";
            this.coches[5] = "coches/bmwx3.jpg";
            this.coches[6] = "coches/citroencactus.jpg";
            this.coches[7] = "coches/citroenpicasso.jpg";
            this.coches[8] = "coches/ds3.jpg";
            this.coches[9] = "coches/ds5.jpeg";
            this.coches[10] = "coches/fiat500.jpg";
            this.coches[11] = "coches/fiatpanda.jpg";
            this.coches[12] = "coches/fordfiesta.jpg";
            this.coches[13] = "coches/fordfocus.jpg";
            this.coches[14] = "coches/hyundaii30.jpg";
            this.coches[15] = "coches/hyundaitucson.jpg";
            this.coches[16] = "coches/kiario.jpg";
            this.coches[17] = "coches/kiasportage.jpg";
            this.coches[18] = "coches/mazda2.jpg";
            this.coches[19] = "coches/mazda3.jpg";
            this.coches[20] = "coches/mercedesclasee.jpg";
            this.coches[21] = "coches/mercedesclases.jpg";
            this.coches[22] = "coches/nissanleaf.png";
            this.coches[23] = "coches/nissanqashqai.jpg";
            this.coches[24] = "coches/opelcorsa.jpg";
            this.coches[25] = "coches/opelinsignia.jpg";
            this.coches[26] = "coches/peugeot5008.jpg";
            this.coches[27] = "coches/peugeot508.jpg";
            this.coches[28] = "coches/porsche911.jpg";
            this.coches[29] = "coches/porschecayenne.jpg";
            this.coches[30] = "coches/renault captur.jpg";
            this.coches[31] = "coches/renault kadjar.jpeg";
            this.coches[32] = "coches/seatleon.jpg";
            this.coches[33] = "coches/seattarraco.jpg";
            this.coches[34] = "coches/skodakaroq.jpg";
            this.coches[35] = "coches/skodaoctavia.jpg";
            this.coches[36] = "coches/toyotaauris.jpg";
            this.coches[37] = "coches/toyotaprius.jpg";
            this.coches[38] = "coches/volkswagenpolo.jpeg";
            this.coches[39] = "coches/volkswagentroc.jpg";
            this.coches[40] = "coches/volvov40.jpg";
            this.coches[41] = "coches/volvoxc40.jpg";
            this.frutas[0] = "frutas/aguacate.jpg";
            this.frutas[1] = "frutas/ajo.jpg";
            this.frutas[2] = "frutas/alcachofa.jpg";
            this.frutas[3] = "frutas/apio.jpg";
            this.frutas[4] = "frutas/apio.png";
            this.frutas[5] = "frutas/calabaza.png";
            this.frutas[6] = "frutas/cebolla.jpg";
            this.frutas[7] = "frutas/cereza.jpg";
            this.frutas[8] = "frutas/coco.jpg";
            this.frutas[9] = "frutas/frambuesa.png";
            this.frutas[10] = "frutas/fresa.png";
            this.frutas[11] = "frutas/granada.jpeg";
            this.frutas[12] = "frutas/jengibre.jpg";
            this.frutas[13] = "frutas/kiwi.jpg";
            this.frutas[14] = "frutas/lechuga.jpeg";
            this.frutas[15] = "frutas/lechugaiceberg.png";
            this.frutas[16] = "frutas/lima.jpg";
            this.frutas[17] = "frutas/limon.jpeg";
            this.frutas[18] = "frutas/mandarina.jpeg";
            this.frutas[19] = "frutas/manzanaroja.jpg";
            this.frutas[20] = "frutas/manzanaverde.jpg";
            this.frutas[21] = "frutas/melocoton.png";
            this.frutas[22] = "frutas/melon.jpeg";
            this.frutas[23] = "frutas/millo.png";
            this.frutas[24] = "frutas/mora.jpeg";
            this.frutas[25] = "frutas/naranja.png";
            this.frutas[26] = "frutas/papa.jpg";
            this.frutas[27] = "frutas/pepino.jpeg";
            this.frutas[28] = "frutas/pepino.png";
            this.frutas[29] = "frutas/pera.jpg";
            this.frutas[30] = "frutas/pimientoamarillo.jpeg";
            this.frutas[31] = "frutas/pimientorojo.png";
            this.frutas[32] = "frutas/piña.jpeg";
            this.frutas[33] = "frutas/platano.jpeg";
            this.frutas[34] = "frutas/puerro.png";
            this.frutas[35] = "frutas/remolacha.jpg";
            this.frutas[36] = "frutas/sandia.png";
            this.frutas[37] = "frutas/tomate.png";
            this.frutas[38] = "frutas/uvablanca.jpg";
            this.frutas[39] = "frutas/uvaroja.jpg";
            this.frutas[40] = "frutas/zanahoria.png";
            this.frutas[41] = "frutas/uvaazul.jpeg";
            this.pokemon[0] = "pokemon/aerodactyl.png";
            this.pokemon[1] = "pokemon/arcanine.png";
            this.pokemon[2] = "pokemon/banette.png";
            this.pokemon[3] = "pokemon/blastoise.jpg";
            this.pokemon[4] = "pokemon/buterfree.jpg";
            this.pokemon[5] = "pokemon/charizard.png";
            this.pokemon[6] = "pokemon/cyndaquil.jpg";
            this.pokemon[7] = "pokemon/ditto.png";
            this.pokemon[8] = "pokemon/doduo.png";
            this.pokemon[9] = "pokemon/eevee.png";
            this.pokemon[10] = "pokemon/electabuzz.png";
            this.pokemon[11] = "pokemon/exeggcute.png";
            this.pokemon[12] = "pokemon/gastly.png";
            this.pokemon[13] = "pokemon/graveler.jpg";
            this.pokemon[14] = "pokemon/gyarados.png";
            this.pokemon[15] = "pokemon/hitmonchan.png";
            this.pokemon[16] = "pokemon/horsea.png";
            this.pokemon[17] = "pokemon/jigglypuff.png";
            this.pokemon[18] = "pokemon/jynx.png";
            this.pokemon[19] = "pokemon/kangaskhan.png";
            this.pokemon[20] = "pokemon/machoke.png";
            this.pokemon[21] = "pokemon/magikarp.png";
            this.pokemon[22] = "pokemon/magmar.png";
            this.pokemon[23] = "pokemon/marowak.png";
            this.pokemon[24] = "pokemon/meowth.png";
            this.pokemon[25] = "pokemon/mew.jpg";
            this.pokemon[26] = "pokemon/mewtwo.png";
            this.pokemon[27] = "pokemon/mrmime.jpg";
            this.pokemon[28] = "pokemon/nidoran.png";
            this.pokemon[29] = "pokemon/ninetales.png";
            this.pokemon[30] = "pokemon/oddish.jpg";
            this.pokemon[31] = "pokemon/omanyte.gif";
            this.pokemon[32] = "pokemon/onix.png";
            this.pokemon[33] = "pokemon/persian.png";
            this.pokemon[34] = "pokemon/pichu.png";
            this.pokemon[35] = "pokemon/pikachu.png";
            this.pokemon[36] = "pokemon/pinsir.png";
            this.pokemon[37] = "pokemon/porygon.png";
            this.pokemon[38] = "pokemon/psyduck.png";
            this.pokemon[39] = "pokemon/rhydon.png";
            this.pokemon[40] = "pokemon/seadra.png";
            this.pokemon[41] = "pokemon/seel.png";
            this.pokemon[42] = "pokemon/shinx.jpg";
            this.pokemon[43] = "pokemon/slowbro.png";
            this.pokemon[44] = "pokemon/snorlax.png";
            this.pokemon[45] = "pokemon/squirtle.png";
            this.pokemon[46] = "pokemon/tauros.png";
            this.pokemon[47] = "pokemon/vaporeon.png";
            this.pokemon[48] = "pokemon/venomoth.jpg";
            this.pokemon[49] = "pokemon/voltorb.png";
            this.pokemon[50] = "pokemon/wailmer.png";
            this.pokemon[51] = "pokemon/weedle.png";
            this.pokemon[52] = "pokemon/weezing.jpg";
            this.pokemon[53] = "pokemon/zapdos.png";
        };
        return Images;
    }());
    exports.Images = Images;
});
