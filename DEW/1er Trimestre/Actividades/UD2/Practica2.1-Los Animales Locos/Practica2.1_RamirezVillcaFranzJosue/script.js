class Animal {
  
  constructor(nombre, imagen, ventaja, handicap, posicion, numeroPosicion) {
    this._nombre = nombre;
    this._imagen = imagen;
    this._ventaja = ventaja;
    this._handicap = handicap;
    this._posicion = posicion;
    this._numeroPosicion = numeroPosicion;
  }

  get nombre() {
    return this._nombre;
  }
  get imagen() {
    return this._imagen;
  }
  get ventaja() {
    return this._ventaja;
  }
  get handicap() {
    return this._handicap;
  }
  get posicion() {
    return this._posicion;
  }
  get numeroPosicion() {
    return this._numeroPosicion;
  }
  
  set posicion(value) {
    this._posicion = value;
  }
  set numeroPosicion(value) {
    this._numeroPosicion = value;
  }

}

class Juego {

  constructor(tortuga, liebre, colibri, meta = 200, ronda = 0) {
    this._meta = meta;
    this._ronda = ronda;
    this._tortuga = tortuga;
    this._liebre = liebre;
    this._colibri = colibri;
  }

  get meta() {
    return this._meta;
  }
  get ronda() {
    return this._ronda;
  }
  get tortuga() {
    return this._tortuga;
  }
  get liebre() {
    return this._liebre;
  }
  get colibri() {
    return this._colibri;
  }

  set ronda(value) {
    this._ronda = value;
  }
  
  InicioJuego() {
    let tenemosGanador = false;

    this.MostrarRonda();

    while (!tenemosGanador) {
      this.ronda++;

      this.MovimientoProbabilidad();

      this.MostrarRonda();

      if (this.TenemosGanador()) {
        tenemosGanador = true;        
      }      

    }

  }

  /**
   * Cada parametro recibira un array de dos numeros.
   * El primer valor hara referencia a la ventaja y el segundo su probabilidad de 1-10.   
   * La probabilidad sera el número de veces que la ventaja o el handicap se escriban dentro de un array.
   * @param {number[]} arrayVentaja 
   * @param {number[]} arrayHandicap 
   */
  CalculoProbalilidad(arrayVentaja, arrayHandicap) {
    let probabilidadesNumericas = new Array();
    probabilidadesNumericas = probabilidadesNumericas.concat(Utilidades.ValorArray(arrayVentaja[0], arrayVentaja[1]), Utilidades.ValorArray(arrayHandicap[0], arrayHandicap[1]));

    let numeroProbabilidad = Math.floor(Math.random() * probabilidadesNumericas.length);
    return probabilidadesNumericas[numeroProbabilidad];
  }

  /**
   * Realiza el movimiento de los animales dependiendo de su ventaja o handicap
   */
  MovimientoProbabilidad() {
    if (this.CalculoProbalilidad([this.tortuga.ventaja, 6], [this.tortuga.handicap, 4]) === this.tortuga.ventaja) {
      this.tortuga.numeroPosicion += this.tortuga.ventaja;
      this.tortuga.posicion = Utilidades.InsertarEspacios(this.tortuga.numeroPosicion);            
    }
    else {
      this.tortuga.numeroPosicion -= this.tortuga.handicap;
      Math.sign(this.tortuga.numeroPosicion) === -1 ? this.tortuga.numeroPosicion = 0 : "";
      this.tortuga.posicion = Utilidades.InsertarEspacios(this.tortuga.numeroPosicion);
    }

    if (this.CalculoProbalilidad([this.liebre.ventaja, 4], [this.liebre.handicap, 6]) === this.liebre.ventaja) {
      this.liebre.numeroPosicion += this.liebre.ventaja;
      this.liebre.posicion = Utilidades.InsertarEspacios(this.liebre.numeroPosicion);
    }
    else {
      this.liebre.numeroPosicion -= this.liebre.handicap;
      Math.sign(this.liebre.numeroPosicion) === -1 ? this.liebre.numeroPosicion = 0 : "";
      this.liebre.posicion = Utilidades.InsertarEspacios(this.liebre.numeroPosicion);
    }

    if (this.CalculoProbalilidad([this.colibri.ventaja, 2], [this.colibri.handicap, 8]) === this.colibri.ventaja) {
      this.colibri.numeroPosicion += this.colibri.ventaja;
      this.colibri.posicion = Utilidades.InsertarEspacios(this.colibri.numeroPosicion);
    }
    else {
      this.colibri.numeroPosicion -= this.colibri.handicap;
      Math.sign(this.colibri.numeroPosicion) === -1 ? this.colibri.numeroPosicion = 0 : "";
      this.colibri.posicion = Utilidades.InsertarEspacios(this.colibri.numeroPosicion);
    }
  }

  /**
   * Verifica si hay un ganador que llego a la meta
   */
  TenemosGanador() {
    if (this.tortuga.numeroPosicion >= this.meta) {
      this.MostrarGanador(this.tortuga.nombre, this.tortuga.imagen);
      return true;
    }
    if (this.liebre.numeroPosicion >= this.meta) {
      this.MostrarGanador(this.liebre.nombre, this.liebre.imagen);
      return true;
    }
    if (this.colibri.numeroPosicion >= this.meta) {
      this.MostrarGanador(this.colibri.nombre, this.colibri.imagen);
      return true;
    }
    return false;

  }

  MostrarRonda() {
    document.write(`<h3 style="text-align: center">Número de ronda: ${this.ronda}</h3>`);
    document.write("<br>");
    document.write(`${this.tortuga.posicion}<img src="${this.tortuga.imagen}">${this.tortuga.numeroPosicion}`);
    document.write("<br>");
    document.write(`${this.liebre.posicion}<img src="${this.liebre.imagen}">${this.liebre.numeroPosicion}`);
    document.write("<br>");
    document.write(`${this.colibri.posicion}<img src="${this.colibri.imagen}">${this.colibri.numeroPosicion}`);
    document.write("<br>");
  }

  MostrarGanador(nombre, imagen) {
    document.write(`<h3 style="text-align: center">El ganador de la gran carrera es: ${nombre}</h3>`);
    document.write(`<div style="display: flex; justify-content: center;" id="ganador"><img src="${imagen}"></div>`);
  }

}

let tortuga = new Animal("Tortuga", "img/tortuga.png", 12, 0, "", 0);
let liebre = new Animal("Liebre", "img/liebre.png", 24, 4, "", 0);
let colibri = new Animal("Colibri", "img/colibri.png", 48, 3, "", 0);

let juego = new Juego(tortuga, liebre, colibri);
juego.InicioJuego();
