function mycarousel_initCallback(carousel)
	{
    // Disable autoscrolling if the user clicks the prev or next button.
    carousel.buttonNext.bind('click', function() {
        carousel.startAuto(0);
    });

    carousel.buttonPrev.bind('click', function() {
        carousel.startAuto(0);
    });

    // Pause autoscrolling if the user moves with the cursor over the clip.
    carousel.clip.hover(function() {
        carousel.stopAuto();
    }, function() {
        carousel.startAuto();
    });
	};

$(document).ready(function() {
    
	$.ajax({
			url: 'functions/getCarouselForos.php',
			type:'post',
			data: { 'id_foro' : 1 },
			dataType: 'json',
			success: function ( response ){
				var tam = response.length;
				// iniciamos el carousel
				var elementos = "";
				for ( var post in response) {
					elementos += "<li><div><input type='hidden' value='" + response[post]['id_post'] + "'/>";
					elementos += "<input type='hidden' value='" + response[post]['id_foro'] + "'/><img src='" + response[post]['recurso'] + "' width='150px' height='100px'/></div>";
					elementos += "<div style='width:150px'>"+response[post]['titulo']+"</div></li>";
				}
				$('#carouselRecetas').html(elementos);
				$('#carouselRecetas').on('click','li', cargaPost);
				$('#carouselRecetas').jcarousel({
					auto: 4, // autoscrolling cada 4 segundos
					animation: 'slow', // animación lenta
					wrap: 'circular' // movimiento circular
				});

			}
  	}); // llamada para crear carouselRecetas
	
	$.ajax({
			url: 'functions/getCarouselForos.php',
			type:'post',
			data: { 'id_foro' : 2 },
			dataType: 'json',
			success: function ( response ){
				var tam = response.length;
				// iniciamos el carousel
				var elementos = "";
				for ( var post in response) {
					elementos += "<li><div><input type='hidden' value='" + response[post]['id_post'] + "'/>";
					elementos += "<input type='hidden' value='" + response[post]['id_foro'] + "'/><img src='" + response[post]['recurso'] + "' width='150px' height='100px'/></div>";
					elementos += "<div style='width:150px'>"+response[post]['titulo']+"</div></li>";
				}
				$('#carouselRestaurantes').html(elementos);
				$('#carouselRestaurantes').on('click','li', cargaPost);
				$('#carouselRestaurantes').jcarousel({
					auto: 4, // autoscrolling cada 4 segundos
					animation: 'slow', // animación lenta
					wrap: 'circular' // movimiento circular
				});

			}
  	}); // llamada para crear carouselRestaurantes

});

function cargaPost() {
   var idPost = $(this).find('input[type=hidden]:eq(0)').val();
   var idForo = $(this).find('input[type=hidden]:eq(1)').val();
   $.ajax({
			url: 'functions/getPost.php',
			type:'post',
			data: { 'id_post' : parseInt(idPost), 'id_foro' : parseInt(idForo) },
			dataType: 'html',
			success: function ( response ){
				$("#wrapper_last_publicacion").html(response);
				
			}
  	}); // llamada para crear carouselRestaurantes

}