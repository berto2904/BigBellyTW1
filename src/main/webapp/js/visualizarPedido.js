$(document).ready(function(){
	sumarCombosPedido();
});
function initMap() {
	var directionsService = new google.maps.DirectionsService;
    var directionsDisplay = new google.maps.DirectionsRenderer;
    var map = new google.maps.Map(document.getElementById('map'), {
		center: {lat: -34.643, lng: -58.565},
		zoom: 14
	});
	directionsDisplay.setMap(map);
	
	var bigBellyLatLng = {lat: -34.643, lng: -58.565};
	var bigBelly = new google.maps.Marker({
        position: bigBellyLatLng,
        map: map,
        title: 'BigBelly Burguer'
      });
//	var clienteLatLng = $('#direccionLocalPedido').val().replace('(',"").replace(')',"");
	var clienteLatLng = JSON.parse('{"'+$('#direccionLocalPedido').val().replace('(','lat":').replace(',',',"lng":').replace(')','')+'}');
	var cliente = new google.maps.Marker({
        position: clienteLatLng,
        map: map,
        title: 'Cliente'
      });
	
	function calculateAndDisplayRoute(directionsService, directionsDisplay) {
	    directionsService.route({
	    	origin: bigBelly.getPosition(),
	    	destination: cliente.getPosition(),
	    	travelMode: 'DRIVING'
	    }, function(response, status) {
	    	if (status === 'OK') {
	    		directionsDisplay.setDirections(response);
	    	} else {
	    		window.alert('Directions request failed due to ' + status);
	    	}
	    });
	  
	}

	calculateAndDisplayRoute(directionsService, directionsDisplay);
}
function sumarCombosPedido(){
	var precioPedidoCombos = 0;
	for (var i = 0; i < $('.valorComboPedido').length; i++) {
		precioPedidoCombos += Number($('.valorComboPedido')[i].value);
	}
	$('#idPrecioPedido').html(precioPedidoCombos);
}