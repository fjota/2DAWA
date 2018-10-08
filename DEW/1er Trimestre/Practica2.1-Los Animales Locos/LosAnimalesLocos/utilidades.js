class Utilidades {

  static InsertarEspacios(numeroEspacios){
    let espacios = "";
    for (let i = 0; i < numeroEspacios; i++) {
      espacios += "&nbsp;";
    }
    return espacios;
  }

  /* static Wait(milliseconds) {
    let date = Date.now();

    while (Date.now() < date + milliseconds) {
      
    }

  } */

}