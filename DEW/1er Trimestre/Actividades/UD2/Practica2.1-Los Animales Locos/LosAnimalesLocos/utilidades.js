class Utilidades {

  /**
   * Inserta n espacios pasados por parametro
   * @param {number} numeroEspacios 
   */
  static InsertarEspacios(numeroEspacios){
    let espacios = "";
    for (let i = 0; i < numeroEspacios; i++) {
      espacios += "&nbsp;";
    }
    return espacios;
  }

  /**
   * Convierte valores a un array.
   * El primer parametro es el que se escribira en el array.
   * El segundo parametro es el numero de veces que se escribira el primer valor.
   * @param {number} valor1 
   * @param {number} valor2 
   */
  static ValorArray(valor1, valor2) {
    let nuevoArray = new Array();
    for (let i = 0; i < valor2; i++) {      
      nuevoArray.push(valor1);
    }
    return nuevoArray;
  }  

}