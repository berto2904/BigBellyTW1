$(document).ready(function(){
	sumarCombosPedido();
});
function initMap() {
	var directionsService = new google.maps.DirectionsService;
    var directionsDisplay = new google.maps.DirectionsRenderer;
    var service = new google.maps.DistanceMatrixService();
//    var d = $.Deferred();
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
	
	
	bigBelly.addListener('click', function() {
		map.setZoom(14);
		map.setCenter(bigBelly.getPosition());
	});
	
	map.addListener('click',function(e){
		placeMarker(e.latLng);
		calculateAndDisplayRoute(directionsService, directionsDisplay);
		});
	
	var marcadorUsuario;
	function placeMarker(location) {
		if (marcadorUsuario) {
			marcadorUsuario.setPosition(location);
		} else {
			marcadorUsuario = new google.maps.Marker({
				position: location,
				map: map,
				draggable: true,
				title: 'Yo'
			});
		}
		console.log("hola");
		$('#direccionUsuario').val(marcadorUsuario.getPosition());
	}
	function calculateAndDisplayRoute(directionsService, directionsDisplay) {
	    directionsService.route({
	    	origin: bigBelly.getPosition(),
	    	destination: marcadorUsuario.getPosition(),
	    	travelMode: 'DRIVING'
	    }, function(response, status) {
	    	if (status === 'OK') {
	    		directionsDisplay.setDirections(response);
	    	} else {
	    		window.alert('Directions request failed due to ' + status);
	    	}
	    });
	    service.getDistanceMatrix(
	    		{
	    			origins: [bigBelly.getPosition()],
	    			destinations: [marcadorUsuario.getPosition()],
	    			travelMode: 'DRIVING',
	    			unitSystem: google.maps.UnitSystem.METRIC,
	    			avoidHighways: false,
	    			avoidTolls: false,
	    		}, callback);
	    
	    function callback(response, status) {
	    	$('#idDistancia').html(response.rows["0"].elements["0"].distance.text)
	    	$('#idTiempo').html(response.rows["0"].elements["0"].duration.text)
	    	//	    	d.resolve(response);
//	    	return d.promise();
	    }
//	    $.getJSON('https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins='+bigBelly.getPosition().toString().replace('(','').replace(')','')+'&destinations='+marcadorUsuario.getPosition().toString().replace('(','').replace(')','')+'&key=AIzaSyBaVN-Mpu4GBrlGhDWqGYdis_ru_yhHUlE', function(data) {
//	        data;
//	    });
	    
	}

	console.log('hola');
}
function sumarCombosPedido(){
	var precioPedidoCombos = 0;
	for (var i = 0; i < $('.valorComboPedido').length; i++) {
		precioPedidoCombos += Number($('.valorComboPedido')[i].value);
	}
	$('#idPrecioPedido').html(precioPedidoCombos);
}