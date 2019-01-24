let introduceMensual = false;
let campoBruto = $("#bruto");
let campoBrutoMes = $("#brutoMes");
let campoNivelProfesional = $("#nivelProfesional");
let campoSegSocial = $("#seguridadSocial");
let campoTipoRetencion = $("#irpf");
let campoNeto = $("#neto");
let campoNetoMes = $("#netoMes");
let campoPagas = $("#numPagas");

$(document).ready(function () {
	$(".noEditable").prop("readonly", true);

	$("#bruto").on("input", rellenarCampos);
	$("#brutoMes").on("input", rellenarCampos);
	$("#nivelProfesional").on("change", rellenarCampos);
	$("#numPagas").on("change", cambiaPagas);
});

function cambiaPagas(e) {

	if (!introduceMensual) {
		campoBrutoMes.val(redondea(+campoBruto.val() / campoPagas.val(), 2));
	}
	else {
		campoBruto.val(+campoBrutoMes.val() * campoPagas.val());
	}
}

function rellenarCampos(e) {

	if (e.target.value == "") {
		campoBruto.val("");
		campoBrutoMes.val("");
		campoSegSocial.val("");
		campoTipoRetencion.val("");
		campoNeto.val("");
		campoNetoMes.val("");
	}

	if (e.target.id == "brutoMes") {	
		campoBruto.val(+e.target.value * campoPagas.val());
		introduceMensual = true;
	} else if (e.target.id == "bruto") {
		introduceMensual = false;
	}

	if (campoBruto.val() != "") {

		let bruto = +campoBruto.val();
		let nivelProfesional = Number(campoNivelProfesional[0].selectedIndex);
		let pagas = campoPagas.val();
		let brutoMensual = +campoBrutoMes.val();

		let cotiza = cotizaciones(brutoMensual, nivelProfesional);
		campoSegSocial.val(redondea(cotiza, 2));

		let irpf = calculoIRPF(bruto, cotiza);
		let tipoIrpf = redondea(irpf / bruto * 100, 2);
		campoTipoRetencion.val(tipoIrpf + "%");

		let sueldoNeto = bruto - cotiza - irpf;

		campoNeto.val(redondea(sueldoNeto, 2));
		let netoMensual = sueldoNeto / pagas;
		campoNetoMes.val(redondea(netoMensual, 2));
	}

}

function redondea(valor, decimales) {

	let base = Math.pow(10, decimales);
	return Math.round(valor * base) / base;

}

function cotizaciones(salario, nivelLaboral) {

	// Se calcula primero la base, luego se sustituye por la mínima si es necesario. 
	// Si supera la máxima se reemplaza por ésta.
	let importe = Math.min(4070, Math.max(salario, retenciones(nivelLaboral))) * 0.0635;

	return importe;
}

function calculoIRPF(salario, cotizaciones) {

	const minFamiliar = 5550;

	let tramos = [60000, 35200, 20200, 12450, 0];
	let tipos = [0.45, 0.37, 0.3, 0.24, 0.19];

	// Se calcula la base liquidable
	let baseLiquidable = salario - cotizaciones - minFamiliar;

	if (baseLiquidable <= 0) {
		return 0;
	}

	let retencion = 0;

	// Se recorren los tramos, aplicando el tipo a cada uno de ellos
	for (let i = 0; i < tramos.length; i++) {
		if (baseLiquidable > tramos[i]) {
			retencion += (baseLiquidable - tramos[i]) * tipos[i];
			baseLiquidable = tramos[i];
		}
	}

	return retencion;

}


/* Para cada nivel se establece un mínimo de cotizacion: 

- Licenciados...: 1.466,50 euros/mes.
- Diplomados...: 1.215,90 euros/mes.
- Bachiller y FP GS...: 1.057,80 euros/mes.
- ESO y FP GM...: 1.050,00 euros/mes.
- No cualificados...: 1.050,00 euros/mes.

Para todos la base máxima es 4.070,00 eur/mes

*/
function retenciones(nivel) {

	let minimos = [1466.5, 1215.9, 1057.8, 1050, 1050];

	return minimos[nivel];

}