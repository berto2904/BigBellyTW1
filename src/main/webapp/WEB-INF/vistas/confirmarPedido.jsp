<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<!-- Bootstrap core CSS -->
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<!-- Bootstrap theme -->
	<link href="css/bootstrap-theme.min.css" rel="stylesheet">
	
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/normalize.css">
	<link rel="stylesheet" href="css/main.css" media="screen" type="text/css">
	<link rel="stylesheet" href="css/confirmarPedido.css" media="screen"type="text/css">
	<link href='http://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Playball' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/style-portfolio.css">
	<link rel="stylesheet" href="css/picto-foundry-food.css" />
	<link rel="stylesheet" href="css/jquery-ui.css">
	<link rel="stylesheet"href="jquery-confirm-master/dist/jquery-confirm.min.css">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link rel="icon" href="favicon-1.ico" type="image/x-icon">
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
		<div class="container">
			<div class="row">
				<div class="navbar-header">
					<span class="navbar-brand">Tu pedido</span>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<!-- /.navbar-collapse -->
			</div>
		</div>
		<!-- /.container-fluid -->
	</nav>
	<div class="row">
		<div class="col-md-6">
			<h4>¿A donde te lo enviamos?</h4>
			<div id="map"></div>
		</div>
		<div class="col-md-6"></div>
	</div>

	<footer class="sub_footer">
		<div class="container">
		</div>
	</footer>

	<!-- Placed at the end of the document so the pages load faster -->
	
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDYWgU_Wmwa0lFOeaJRXftCqaYU9PralPI&callback=initMap"></script>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
	<script src="js/bootstrap1.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery-1.10.2.min.js"> </script>
    <script type="text/javascript" src="js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>     
    <script type="text/javascript" src="js/jquery.mixitup.min.js" ></script>
    <script type="text/javascript" src="js/main.js" ></script>
    <script type="text/javascript" src="js/confirmarPedido.js" ></script>
    <script type="text/javascript" src="js/home.js" ></script>
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="jquery-confirm-master/dist/jquery-confirm.min.js" type="text/javascript"></script>
</body>
</html>