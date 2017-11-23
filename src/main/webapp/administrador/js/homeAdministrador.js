$(document).ready(function(){
	
});

//function editarPan(id){
//	var nombre = $('#idPan_'+id)["0"].cells["0"].innerText;
//	var stock =  $('#idPan_'+id)["0"].cells["1"].innerText;
//	var precio = $('#idPan_'+id)["0"].cells["2"].innerText;
//	
//	$('#nombrePan').val(nombre);
//	$('#stockPan').val(stock);
//	$('#precioPan').val(precio);
//}
//
//function limpiarPan(){
//	$('#nombrePan').val("");
//	$('#stockPan').val("");
//	$('#precioPan').val("");
//}
//
//function eliminarPan(id){
//	$.ajax({
//        url: "/bbtw1/eliminarPan?idPan="+id,
//        type:"GET",
//        success: function(e) {
//         alert("Se ha eliminado el pan " + $('#idPan_'+id)["0"].cells["0"].innerText);
//         $('.table').html($(e).find('.table'));
//        }
//      });
//}

function editarIngrediente(id){
	var nombre = $('#idIngrediente_'+id)["0"].cells["0"].innerText;
	var stock =  $('#idIngrediente_'+id)["0"].cells["1"].innerText;
	var precio = $('#idIngrediente_'+id)["0"].cells["2"].innerText;
	
	$('#nombreIngrediente').val(nombre);
	$('#stockIngrediente').val(stock);
	$('#precioIngrediente').val(precio);
}

function limpiarIngrediente(){
	$('#nombreIngrediente').val("");
	$('#stockIngrediente').val("");
	$('#precioIngrediente').val("");
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