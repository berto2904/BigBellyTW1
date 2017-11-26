$(document).ready(function(){
	
});

function enProcesoEntrega(id){
	$.confirm({
		animation: 'scaleY',
		type: 'dark',
		title:'Procesar Pedido',
		content: '&iquest;Est&aacute;s seguro de procesar el pedido N&ordm; '+$('#idPedido_'+id)["0"].cells["0"].innerText+'?',
	    buttons: {
	        Aceptar: function () {
	        	$.ajax({
	                url: "/bbtw1/procesar-pedido-pendCoccion",
	                type:"POST",
	                data:{
	                	pedido:id
	                },
	                success: function(e) {
	                 $.alert("El pedido Nº "+$('#idPedido_'+id)["0"].cells["0"].innerText+"será procesado");
	                 $('.table').html($(e).find('.table'));
	                }
	              });
	        },
	        Cancelar: {
	            action: function () {
	            }
	        }
	    }
	});
	
}

function verPedido(id){
	$.alert("es el id: "+id);
}
