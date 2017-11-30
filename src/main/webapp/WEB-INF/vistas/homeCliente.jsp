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
        <title>Big Belly</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/main.css" media="screen" type="text/css">
        <link href='http://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Playball' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/style-portfolio.css">
        <link rel="stylesheet" href="css/picto-foundry-food.css" />
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" href="jquery-confirm-master/dist/jquery-confirm.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link rel="icon" href="favicon-1.ico" type="image/x-icon">

</head>
<body>
	
	 <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="row">
                <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">${usuario.nombre} ${usuario.apellido}</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav main-nav  clear navbar-right ">
                            <li><a class="navactive color_animation" href="#top">Bienvenidos</a></li>
                            <li><a class="color_animation" href="#Nosotros">Nosotros</a></li>
							<li><a class="color_animation" href="#creahambur">Crear hamburguesa</a></li>
							<li><a class="color_animation" href="/bbtw1/cerrar-sesion">Cerrar Sesion</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div>
            </div><!-- /.container-fluid -->
        </nav>
        <div id="top" class="starter_container bg">
            <div class="follow_container">
                <div class="col-md-6 col-md-offset-3">
                    <h2 class="top-title"> Big Belly</h2>
                    <h2 class="white second-title">" Come rico "</h2>
                    <hr>
                </div>
            </div>
        </div>

        <!-- ============ About Us ============= -->

	<section id="Nosotros" class="description_content">
		<div class="text-content container">
			<div class="col-md-6">
				<h1>Nosotros</h1>
				<div class="fa fa-cutlery fa-2x"></div>
				<p class="desc-text">Big Belly es un restaurant que ofrece
					hamburguesas customizables y combos armados. Vení a conocernos y
					arma la tuya!</p>
			</div>
			<div class="col-md-6">
				<div class="img-section">
					<img src="images/h1.jpg" width="250" height="220"> <img
						src="images/h2.jpg" width="250" height="220">
					<div class="img-section-space"></div>
					<img src="images/radish.jpg" width="250" height="220"> <img
						src="images/h3.jpg" width="250" height="220">
				</div>
			</div>
		</div>
	</section>


		<!-- ============ Crear Hamburguesa  ============= -->
        <input type="hidden" class="mensaje" value="${mensaje}"/>
        <section id="creahambur" class=" description_content">
            <div  class="custom background_content">
                <h1>Arma tu propia <span>Hamburguesa</span></h1>
            </div>
            <div class="text-content container">
                <div class="row">
	                <div class="col-md-6">
	                    <h1>Crea tu propia Hamburguesa</h1>
	                    	<div class="icon-hamburger fa-2x">
		<!--                    <a href="/bbtw1/home/lista-panes"> Crear</a> -->
		                    </div>
						  <div class="form-group">
								<label>Pan</label>
								<select id="idPan" class="form-control">
									<option value="0" selected>Selecciona una opcion</option>
									<c:forEach items="${listaPanes}" var="pan">
											<option value="${pan.idIngrediente}">${pan.nombre}</option>
									</c:forEach>
								</select>
								<label>Carne</label>
								<select class="form-control" id="idCarne">
									<option value="0" selected>Selecciona una opcion</option>
									<c:forEach items="${listaCarne}" var="carne">
											<option value="${carne.idIngrediente}">${carne.nombre}</option>
									</c:forEach>
								</select>
									
								<label>Aderezos</label>
								<select class="form-control" id="idAderezos" multiple="multiple">
									<option value="0" selected>Selecciona una opcion</option>
									<c:forEach items="${listaAderezos}" var="aderezo">
											<option value="${aderezo.idIngrediente}">${aderezo.nombre}</option>
									</c:forEach>
								</select>
								<label>Vegetales</label>
								<select class="form-control" id="idVegetales" multiple="multiple">
									<option value="0" selected>Selecciona una opcion</option>
									<c:forEach items="${listaVegetales}" var="vegetal">
											<option value="${vegetal.idIngrediente}">${vegetal.nombre}</option>
									</c:forEach>
								</select>
							</div>
						  <button class="btn btn-success" id="idGuardar">Crear Combo</button>
	                    <p class="desc-text">Amamos crear. Y queremos que cada cliente experimente con sus gustos para hacer su menu ideal.</p>
	                </div>                                
	                <div class="col-md-6">                    
		                    <img src="images/ingredientes2.jpg" width="260" alt="Bread">
	                </div>
                </div>
                <div class="row">
                	<div class="panel panel-success combosCreados">
                		<div class="panel-heading ">
                			<h4>Combos Creados</h4>
                		</div>
						<div class="panel-body">
	               		<c:forEach items="${combosDeUsuario}" var="combo">
	               			<div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
				     			<div class="card">
									<img class="" src="images/combo-portfolio.png" alt="" style="width: 30%;">
									<button type="button" class="close" aria-label="Close" onclick="eliminarCombo(${combo.idCombo})">
										<span aria-hidden="true">&times;</span>
									</button>
									<div class="card-body">
					              		<h4 class="card-title">
					                		${combo.descripcion}
					              		</h4>
				              			<ul class="list-group">
				              			<c:forEach items="${combo.ingredientes}" var="ingrediente">
											<li class="list-group-item">${ingrediente.nombre}</li>
										</c:forEach>    
										</ul>
										<span>
											<h3>$ ${combo.precioFinal}</h3>
											<input type="hidden" class="valorCombo" value="${combo.precioFinal}"/>
											
										</span>
				            		</div>
	          					</div>
	       			 		</div>
						</c:forEach>
						</div>
						<div class="panel-footer" id="precioPedido">
						</div>
					</div>
         		</div>
         		<div class="row">
                	<div class="panel panel-info pedidosRealizado">
                		<div class="panel-heading ">
                			<h4>Pedidos Realizados</h4>
                		</div>
						<div class="panel-body">
	               		<c:forEach items="${pedidosDeUsuario}" var="pedido">
	               			<div class="col-lg-4 col-md-2 col-sm-6 portfolio-item">
				     			<div class="card">
									<a onclick="verPedidoUsuario(${pedido.idPedido})">
										<img class="" src="images/pedidoCombos.png" alt="" style="width: 30%;">
									</a>
									<div class="card-body">
					              		<h4 class="card-title">
					                		Pedido: Nº ${pedido.idPedido}
					              		</h4>
				              			<ul class="list-group">
											<li class="list-group-item">Estado: 
												<span> ${pedido.estado.getDescrpicion()}</span>
											</li>
										</ul>
				            		</div>
	          					</div>
	       			 		</div>
						</c:forEach>
						</div>
						<div class="panel-footer" id="pedidosRealizados">
						</div>
					</div>
         		</div>
            </div>
        </section>
        
        <!-- ============ Footer Section  ============= -->

        <footer class="sub_footer footerClass" >
            <div class="container">
                <div class="col-md-4"><p class="sub-footer-text text-center">&copy; Restaurant 2014, Theme by <a href="https://themewagon.com/">ThemeWagon</a></p></div>
                <div class="col-md-4"><p class="sub-footer-text text-center">Volver al <a href="#top">Inicio</a></p>
                </div>
                <div class="col-md-4"><p class="sub-footer-text text-center">Sitio hecho por <a href="#" target="_blank">BBG :)</a></p></div>
            </div>
        </footer>

	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
	<script src="js/bootstrap1.min.js" type="text/javascript"></script>
	
	<script type="text/javascript" src="js/jquery-1.10.2.min.js"> </script>
    <script type="text/javascript" src="js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>     
    <script type="text/javascript" src="js/jquery.mixitup.min.js" ></script>
    <script type="text/javascript" src="js/main.js" ></script>
    <script type="text/javascript" src="js/home.js" ></script>

	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="jquery-confirm-master/dist/jquery-confirm.min.js" type="text/javascript"></script>
</body>
</html>