$(document).ready(function(){
	sumarCombos();
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
        	$('.combosCreados').html($(e).find('.combosCreados'));
        	sumarCombos();
        }
	});
}


function sumarCombos(){
	var precioPedido = 0;
	for (var i = 0; i < $('.valorCombo').length; i++) {
		precioPedido += Number($('.valorCombo')[i].value);
	}
	if (precioPedido != 0) {
		$('#precioPedido').html('<button class="btn btn-success pull-right btn-md" id="crearPedido">Crear Pedido<span class="glyphicon glyphicon-send" aria-hidden="true"></span></button><h4>Total: $'+precioPedido+'</h4>');
		$('#crearPedido').on('click',function(){
//			crearPedido();
			confirmarPedido();
		});
	}
}

function crearPedido(){
	$.ajax({
		url: "/bbtw1/crear-pedido-cliente",
		type:"POST",
		success: function(e) {
			$('.combosCreados').html($(e).find('.combosCreados'));
		}
	});
}

function confirmarPedido(){
	$.confirm({
		icon: 'fa fa-spinner fa-spin',
		type:'dark',
		title: '',
		columnClass: 'xlarge',
		buttons:{
			Aceptar: function(){
				crearPedido();
				location.reload();
				
			},
			Cancelar: function(){
				location.reload();
			},
		},
		content: function(){
	        var self = this;
	        return $.ajax({
	            url: '/bbtw1/confirmar-pedido-cliente',
	            method: 'POST'
	        }).done(function (response) {
	            self.setContentAppend(response);
	        }).fail(function(){
	            self.setContentAppend('<div>Fail!</div>');
	        });
	    }
	    
	});
}