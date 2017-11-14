$(document).ready(function(){
	
});

$('#idGuardar').on('click',function(){
	crearCombo();
});

function crearCombo(){
	
	var idPan = $('#idPan').val();
	var idCarne = $('#idCarne').val();
	var idAderezos = $('#idAderezos').val();
	var idVegetales = $('#idVegetales').val();
	
	
	
	$.ajax({
        url: "/bbtw1/agregarCombo",
        type:"POST",
        data: {
        	pan:idPan,
        	carne:idCarne,
        	aderezo:idAderezos,
        	vegetales:idVegetales
        },
        success: function(e) {
        	alert("Tu combo se ha creado con exito!!");
        }
	});
}