$(document).ready(function(){

	// Guardar ancho de cada elemento del slider
	width_slide = 150;

	slider = $('#slider_header ul');
	
	// Obtener numero de slides y ancho total
	var num_slides = slider.children('li').length;
	width_total_slides = ( num_slides ) * width_slide;

	// Clonar los 3 ultimos slides y añadirlos antes del primero
	var last_slide = slider.children('li:gt(' + (num_slides - 4) + ')').clone();
	slider.children('li:first-child').before( last_slide );


	// Mover el slider para que se vea el primer slide original
	// los slides clonados que estan al principio quedan ocultos
	slider.css('left','-' + (width_slide * 3) +'px');

	// Mover slider cada 4 segundos
	setInterval("moveSlider()",4000);

});

function moveSlider(){

	// Obtener posicion izquierda del slider y restarle el ancho de un slide
	var left = (slider.position().left - width_slide);

	// Mover slider
	slider.animate({
		
		'left': left + 'px'
	
	}, 1000, function(){
		
		// Si la posicion del slider muestra los tres ultimos slide moverlo al inicio
		if ( slider.position().left < -(width_total_slides - width_slide ) ){
			slider.css('left','0px');
		}

	});
}