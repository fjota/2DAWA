// JavaScript Document

$(function(){
    $("section article div p:first-child").on("click", function(){
        $(this).parent().toggleClass("animar");

        /*Hace rotar el icono de flecha*/
        $(this).toggleClass("rotateIcon");

        /*Colapsa el titulo de las fotos*/
        $(this).parent().parent().children("h1").slideToggle("slow");
    })
});