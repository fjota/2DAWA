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

class Tortuga extends Animal {
  constructor(nombre, imagen, ventaja, handicap, posicion, numeroPosicion) {
    super(nombre, imagen, ventaja, handicap, posicion, numeroPosicion);
  }
}

class Liebre extends Animal {
  constructor(nombre, imagen, ventaja, handicap, posicion, numeroPosicion) {
    super(nombre, imagen, ventaja, handicap, posicion, numeroPosicion)
  }
}

class Colibri extends Animal {
  constructor(nombre, imagen, ventaja, handicap, posicion, numeroPosicion) {
    super(nombre, imagen, ventaja, handicap, posicion, numeroPosicion);
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
   * Los parametros recibiran un array de dos numeros.
   * El primer valor hara referencia a la ventaja y su probabilidad en base a 1-10.
   * El segundo valor hara referencia al handicap y su probabilidad en base a 1-10.
   * La probabilidad sera el número de veces que la ventaja o el handicap se escriban dentro de un array.
   * @param {number[]} arrayVentaja 
   * @param {number[]} arrayHandicap 
   */
  CalculoProbalilidad(arrayVentaja, arrayHandicap) {
    let probabilidadesNumericas = new Array();
    probabilidadesNumericas = probabilidadesNumericas.concat(Utilidades.ValorArray(arrayVentaja[0], arrayVentaja[1]), Utilidades.ValorArray(arrayHandicap[0], arrayHandicap[1]));

    let numeroProbabilida = Math.floor(Math.random() * probabilidadesNumericas.length);
    return probabilidadesNumericas[numeroProbabilida];
  }

  /**
   * Realiza el movimiento de los animales dependiendo de su ventaja o handicap
   */
  MovimientoProbabilidad() {
    if (this.CalculoProbalilidad([this.tortuga.ventaja, 6], [this.tortuga.handicap, 4]) === this.tortuga.ventaja) {
      tortuga.numeroPosicion += tortuga.ventaja;
      tortuga.posicion = Utilidades.InsertarEspacios(tortuga.numeroPosicion);            
    }
    else {
      tortuga.numeroPosicion -= tortuga.handicap;
      Math.sign(tortuga.numeroPosicion) === -1 ? tortuga.numeroPosicion = 0 : tortuga.numeroPosicion;
      tortuga.posicion = Utilidades.InsertarEspacios(tortuga.numeroPosicion);
    }

    if (this.CalculoProbalilidad([this.liebre.ventaja, 4], [this.liebre.handicap, 6]) === this.liebre.ventaja) {
      liebre.numeroPosicion += liebre.ventaja;
      liebre.posicion = Utilidades.InsertarEspacios(liebre.numeroPosicion);
    }
    else {
      liebre.numeroPosicion -= liebre.handicap;
      Math.sign(liebre.numeroPosicion) === -1 ? liebre.numeroPosicion = 0 : liebre.numeroPosicion;
      liebre.posicion = Utilidades.InsertarEspacios(liebre.numeroPosicion);
    }

    if (this.CalculoProbalilidad([this.colibri.ventaja, 2], [this.colibri.handicap, 8]) === this.colibri.ventaja) {
      colibri.numeroPosicion += colibri.ventaja;
      colibri.posicion = Utilidades.InsertarEspacios(colibri.numeroPosicion);
    }
    else {
      colibri.numeroPosicion -= colibri.handicap;
      Math.sign(colibri.numeroPosicion) === -1 ? colibri.numeroPosicion = 0 : colibri.numeroPosicion;
      colibri.posicion = Utilidades.InsertarEspacios(colibri.numeroPosicion);
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

let tortuga = new Tortuga("Tortuga", "img/tortuga.png", 12, 0, "", 0);
let liebre = new Liebre("Liebre", "img/liebre.png", 24, 4, "", 0);
let colibri = new Colibri("Colibri", "img/colibri.png", 48, 3, "", 0);

let juego = new Juego(tortuga, liebre, colibri);
juego.InicioJuego();
