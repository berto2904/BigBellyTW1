$(document).ready(function(){
	
});

$('#idGuardar').on('click',function(){
	
});

function seleccionarPan(id){
	$.ajax({
        url: "/bbtw1/agregarCombo?panValue="+id,
        type:"GET",
        success: function(e) {
         alert("seleccionado " + id);
        }
      });
}