$(".menu-item").on("mouseover", function () {  
  $(this).find(".sub-menu").css("display", "block" );
});

$(".menu-item").on("mouseout", function () {  
  $(this).find(".sub-menu").css("display", "none" );
});

$(".menu-item").find(".sub-menu").on("mouseover", function(event) {
  $(event.target).css("background-color", "rgb(111, 99, 219)" );  
})
$(".menu-item").find(".sub-menu").on("mouseout", function(event) {  
  $(event.target).css("background-color", "rgb(66, 51, 207)" );  
})


