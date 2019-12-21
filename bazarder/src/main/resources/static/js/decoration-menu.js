/*----------------------------------------------*/
/*----------Déclaration variables --------------*/
/*----------------------------------------------*/

var couleurSurvol = "#ee8472";
var couleurNormal = 'grey';

/*----------------------------------------------*/
/*------------------------------------------------
Objectif : On change la couleur et la graisse 
du menu si la zone concerné est survolé.
------------------------------------------------*/
/*----------------------------------------------*/


// etape 1 survol
$("#etape1").mouseover(function(){
	$('.link-etape1').css({
		color : couleurSurvol,
	    'font-weight' : 'bold' 
	});
});

// etape 1 normal
$("#etape1").mouseout(function(){
	$('.link-etape1').css({
		color : couleurNormal,
	    'font-weight' : 'normal' 
	});
});

// etape 2 survol
$("#etape2").mouseover(function(){
	$('.link-etape2').css({
		color : couleurSurvol,
	    'font-weight' : 'bold' 
	});
});

// etape 2 normal
$("#etape2").mouseout(function(){
	$('.link-etape2').css({
		color : couleurNormal,
    	'font-weight' : 'normal' 
	});
});

// etape 3 survol
$("#etape3").mouseover(function(){
	$('.link-etape3').css({
		color : couleurSurvol,
	    'font-weight' : 'bold' 
	});
});

// etape 3 normal

$("#etape3").mouseout(function(){
	$('.link-etape3').css({
		color : couleurNormal,
    	'font-weight' : 'normal' 
	});
});

