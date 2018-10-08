class Tortuga {

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

class Liebre {

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

class Colibri {

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

  constructor(tortuga, liebre, colibri, meta = 80, ronda = 0) {
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

      if (this.CalculoPosibilidad([this.tortuga.ventaja, 6], [this.tortuga.handicap, 4]) === this.tortuga.ventaja) {
        tortuga.numeroPosicion += tortuga.ventaja;
        tortuga.posicion = Utilidades.InsertarEspacios(tortuga.numeroPosicion);
      }
      else {        
        tortuga.numeroPosicion -= tortuga.handicap;        
        Math.sign(tortuga.numeroPosicion) === -1 ? tortuga.numeroPosicion = Math.abs(tortuga.numeroPosicion) : tortuga.numeroPosicion;      
        tortuga.posicion = Utilidades.InsertarEspacios(tortuga.numeroPosicion);
      }

      if (this.CalculoPosibilidad([this.liebre.ventaja, 4], [this.liebre.handicap, 6]) === this.liebre.ventaja) {
        liebre.numeroPosicion += liebre.ventaja;
        liebre.posicion = Utilidades.InsertarEspacios(liebre.numeroPosicion);
      }
      else {
        liebre.numeroPosicion -= liebre.handicap;
        Math.sign(liebre.numeroPosicion) === -1 ? liebre.numeroPosicion = Math.abs(liebre.numeroPosicion) : liebre.numeroPosicion;    
        liebre.posicion = Utilidades.InsertarEspacios(liebre.numeroPosicion);
      }

      if (this.CalculoPosibilidad([this.colibri.ventaja, 2], [this.colibri.handicap, 8]) === this.colibri.ventaja) {
        colibri.numeroPosicion += colibri.ventaja;
        colibri.posicion = Utilidades.InsertarEspacios(colibri.numeroPosicion);
      }
      else {
        colibri.numeroPosicion -= colibri.handicap;
        Math.sign(colibri.numeroPosicion) === -1 ? colibri.numeroPosicion = Math.abs(colibri.numeroPosicion) : colibri.numeroPosicion;     
        colibri.posicion = Utilidades.InsertarEspacios(colibri.numeroPosicion);
      }

      this.MostrarRonda();      

      if (this.tortuga.numeroPosicion > this.meta) {
        tenemosGanador = true;
        this.MostrarGanador(this.tortuga.nombre, this.tortuga.imagen);
        
      }
      if (this.liebre.numeroPosicion > this.meta) {
        tenemosGanador = true;
        this.MostrarGanador(this.liebre.nombre, this.liebre.imagen);
        
      }
      if (this.colibri.numeroPosicion > this.meta) {
        tenemosGanador = true;
        this.MostrarGanador(this.colibri.nombre, this.colibri.imagen);
        
      }
   
      this.ronda++;
    }

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
    document.write(`<div style="display: flex; justify-content: center;"><img src="${imagen}"></div>`);
  }

  ProbabilidadMovimiento(animal) {
    /* if (this.CalculoPosibilidad() >= 60) {
      tortuga.numeroPosicion += tortuga.ventaja;
      tortuga.posicion = Utilidades.InsertarEspacios(tortuga.numeroPosicion);
    } */
    /*  for (let i = 0; i < 3; i++) {
 
       if (this.CalculoPosibilidad() >= 60) {
         tortuga.numeroPosicion += tortuga.ventaja;
         tortuga.posicion = Utilidades.InsertarEspacios(tortuga.numeroPosicion);
       }
       else if (this.CalculoPosibilidad() <= 40) {
         tortuga.numeroPosicion -= tortuga.handicap;
         tortuga.posicion = Utilidades.InsertarEspacios(tortuga.numeroPosicion);
       }
       if (this.CalculoPosibilidad() >= 60) {
         liebre.numeroPosicion += liebre.ventaja;
         liebre.posicion = Utilidades.InsertarEspacios(liebre.numeroPosicion);
       }
       else if (this.CalculoPosibilidad() <= 40) {
         liebre.numeroPosicion -= liebre.handicap;
         liebre.posicion = Utilidades.InsertarEspacios(liebre.numeroPosicion);
       }
       if (this.CalculoPosibilidad() >= 60) {
         colibri.numeroPosicion += colibri.ventaja;
         colibri.posicion = Utilidades.InsertarEspacios(colibri.numeroPosicion);
       }
       else if (this.CalculoPosibilidad() <= 40) {
         colibri.numeroPosicion -= colibri.handicap;
         colibri.posicion = Utilidades.InsertarEspacios(colibri.numeroPosicion);
       }
 
     } */
  }

  /**
   * Los parametros recibiran un array de dos numeros.
   * El primer número hara referencia a la ventaja y su probabilidad en base a 1-10
   * El segundo número hara referencia al handicap y su probabilidad en base a 1-10
   * @param {numero[]} numero1 
   * @param {numero[]} numero2 
   */
  CalculoPosibilidad(numero1, numero2) {

    let probabilidadesNumericas = new Array();

    for (let i = 0; i < numero1[1]; i++) {
      probabilidadesNumericas.push(numero1[0]);
    }
    for (let i = 0; i < numero2[1]; i++) {
      probabilidadesNumericas.push(numero2[0]);
    }

    let numeroProbabilida = Math.floor(Math.random() * probabilidadesNumericas.length);
    return probabilidadesNumericas[numeroProbabilida];

    //Mirar Teorema de bayes
    //https://stackoverflow.com/questions/8877249/generate-random-integers-with-probabilities
  }  


}

let tortuga = new Tortuga("Tortuga", "img/tortuga.png", 12, 0, "", 0);
let liebre = new Liebre("Liebre", "img/liebre.png", 24, 4, "", 0);
let colibri = new Colibri("Colibri", "img/colibri.png", 48, 3, "", 0);

let juego = new Juego(tortuga, liebre, colibri);
juego.InicioJuego();


