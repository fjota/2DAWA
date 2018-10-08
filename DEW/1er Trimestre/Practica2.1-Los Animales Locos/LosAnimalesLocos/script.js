class Tortuga {

  constructor(nombre, imagen, ventaja, handicap, posicion, numeroPosicion) {
    this._nombre = nombre;
    this._imagen = imagen;
    this._ventaja = ventaja;
    this._handicap = handicap;
    this._posicion = posicion;
    this._numeroPosicion = numeroPosicion;
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

}

class Juego {

  constructor(tortuga, liebre, colibri, meta = 200, ronda = 0) {
    this._meta = meta;
    this._ronda = ronda;
    this._tortuga = tortuga;
    this._liebre = liebre;
    this._colibri = colibri;    
  }

  MostrarRonda() {    
    document.write(`<h3 style="text-align: center">Número de ronda: ${this._ronda}</h3>`);
    document.write("<br>");
    document.write(`${this._tortuga._posicion}<img src="${this._tortuga._imagen}">${this._tortuga._numeroPosicion}`);
    document.write("<br>");
    document.write(`${this._liebre._posicion}<img src="${this._liebre._imagen}">${this._liebre._numeroPosicion}`);
    document.write("<br>");
    document.write(`${this._colibri._posicion}<img src="${this._colibri._imagen}">${this._colibri._numeroPosicion}`);
    document.write("<br>");
  }

  MostrarGanador(nombre) {
    document.write(`<h3 style="text-align: center">El ganador de la gran carrera es: ${nombre}</h3>`);
  }

  CalculoPosibilidad() {
    let random = Math.random(1, 100) * 100;
    if(random >= 60) {
      this._tortuga._numeroPosicion = this._tortuga._numeroPosicion + this._tortuga._ventaja;
      this._liebre._numeroPosicion = this._liebre._numeroPosicion + this._liebre._ventaja;
      this._colibri._numeroPosicion = this._colibri._numeroPosicion + this._colibri._ventaja;
    }
    else if (random <= 40) {
      this._tortuga._numeroPosicion = this._tortuga._numeroPosicion - this._tortuga._handicap;
      this._liebre._numeroPosicion = this._liebre._numeroPosicion - this._liebre._handicap;
      this._colibri._numeroPosicion = this._colibri._numeroPosicion - this._colibri._handicap;
    }
  }
  

}

let tortuga = new Tortuga("Tortuga", "img/tortuga.png", 12, 0, "", 0);
let liebre = new Liebre("Liebre", "img/liebre.png", 24, -4, "", 0);
let colibri = new Colibri("Colibri", "img/colibri.png", 48, -3, "", 0);

let juego = new Juego(tortuga, liebre, colibri);


while (juego._ronda < 10) {
  juego.MostrarRonda(tortuga, liebre, colibri);
  juego.CalculoPosibilidad();
  juego._ronda++;
}




