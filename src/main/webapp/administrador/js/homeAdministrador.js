$(document).ready(function(){
	
});

function crearCategoria(idCategoria){
	$.ajax({
		url: "/bbtw1/agregarIngrediente",
		type:"POST",
		data: {
        	id:idCategoria,
        	descripcion:descripcion;
        },
		success: function(e) {
			$('.tablaIngrediente').html($(e).find('.tablaIngrediente'));
		}
	});
}




function editarIngrediente(id){
	var nombre = $('#idIngrediente_'+id)["0"].cells["0"].innerText;
	var stock =  $('#idIngrediente_'+id)["0"].cells["1"].innerText;
	var precio = $('#idIngrediente_'+id)["0"].cells["2"].innerText;
	var tiempococcion = $('#idIngrediente_'+id)["0"].cells["3"].innerText;
	var categoria = $('#idIngrediente_'+id)["0"].cells["4"].innerText;
	
	$('#nombreIngrediente').val(nombre);
	$('#stockIngrediente').val(stock);
	$('#precioIngrediente').val(precio);
	$('#categoriaIngrediente').val(categoria);
	$('#tcIngrediente').val(tiempococcion);
}

function limpiarIngrediente(){
	$('#nombreIngrediente').val("");
	$('#stockIngrediente').val("");
	$('#precioIngrediente').val("");
	$('#categoriaIngrediente').val("");
	$('#tcIngrediente').val("");
}

function eliminarIngrediente(id){
	$.ajax({
        url: "/bbtw1/eliminarIngrediente?idIngrediente="+id,
        type:"GET",
        success: function(e) {
         alert("Se ha eliminado el ingrediente " + $('#idIngrediente_'+id)["0"].cells["0"].innerText);
         $('.table').html($(e).find('.table'));
        }
      });
}



function editarCombo(id){
	var nombre = $('#idCombo_'+id)["0"].cells["0"].innerText;
	var precio = $('#idCombo_'+id)["0"].cells["2"].innerText;
	
	$('#nombreCombo').val(descripcion);
	$('#precioCombo').val(precioFinal);
}

function limpiarCombo(){
	$('#nombreCombo').val("");
	$('#precioCombo').val("");
}

function eliminarCombo(id){
	$.ajax({
        url: "/bbtw1/eliminarComboAdmin?idCombo="+id,
        type:"GET",
        success: function(e) {
         alert("Se ha eliminado el combo " + $('#idCombo_'+id)["0"].cells["0"].innerText);
         $('.table').html($(e).find('.table'));
        }
      });
}