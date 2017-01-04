/**
 *  atalho para contagem, usabilidade
 */

var pressedSift = false;
var shift = 16;
var d = 68; 
var t = 84;

$(document).keyup(function (e) {
	if(e.which == shift)
		pressedSift=false; 
})

$(document).keydown(function (e) {
	if(e.which == shift) 
		pressedSift = true; 

	if(e.which == d && pressedSift == true) { 
		//Aqui vai o código e chamadas de funções para o shift+d
		//alert("SHIFT + D pressionados");
		$(this).find('#shiftD').click();
	}
	if(e.which == t && pressedSift == true) { 
		//Aqui vai o código e chamadas de funções para o sift+t
		//alert("SHIFT + T pressionados");
		$(this).find('#shiftT').click();
	}
});
 