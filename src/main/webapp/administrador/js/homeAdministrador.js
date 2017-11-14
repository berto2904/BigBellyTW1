$(document).ready(function(){
	
});

function editarPan(id){
	var nombre = $('#idPan_'+id)["0"].cells["0"].innerText;
	var stock =  $('#idPan_'+id)["0"].cells["1"].innerText;
	var precio = $('#idPan_'+id)["0"].cells["2"].innerText;
	
	$('#nombrePan').val(nombre);
	$('#stockPan').val(stock);
	$('#precioPan').val(precio);
}

function limpiarPan(){
	$('#nombrePan').val("");
	$('#stockPan').val("");
	$('#precioPan').val("");
}


function eliminarPan(id){
	$.ajax({
        url: "/bbtw1/eliminarPan",
        type:"POST",
        data:{
        	pan:id
        },
        success: function(e) {
         alert("Se ha eliminado el pan " + $('#idPan_'+id)["0"].cells["0"].innerText);
         $('.table').html($(e).find('.table'));
        }
      });
}

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

