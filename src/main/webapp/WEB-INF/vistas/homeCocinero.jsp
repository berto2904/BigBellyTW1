<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<!-- Bootstrap core CSS -->

<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">

        <meta charset="UTF-8">
        <title>Big Belly</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="administrador/css/main.css" media="screen" type="text/css">
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
                        <a class="navbar-brand" href="#">Big Belly Burger</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav main-nav  clear navbar-right ">
                            <li><a class="navactive color_animation" href="#aCocinar">Pendientes de Coccion</a></li>
                            <li><a class="color_animation" href="/bbtw1/cerrar-sesion">Cerrar Sesion</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div>
            </div><!-- /.container-fluid -->
        </nav>
        
	<!-- ============ Pan Section  ============= -->
      <div class="titulo jumbotron" id="aCocinar">
      	<div class="container">
      		<h2>Pedidos</h2>
      	</div>
      </div>
      <div class="container">
       <div class="row">
       	<div class="col-md-12">
       		<table class="table table-hover">
				<thead>
					<tr>
						<th>NºPedido</th>
						<th>Descripcion</th>
						<th>Fecha y hora</th>
						<th>Cliente</th>
						<th>Procesar</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listaPedidos}" var="pedido">
						<tr id="idPedido_${pedido.idPedido}" >
							<td><c:out value="${pedido.idPedido}" />&nbsp;
								<a class="btn btn-primary btn-sm" onclick="verPedido(${pedido.idPedido})" role="button">
									<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
								</a>
							</td>
							<td><c:out value="${pedido.descripcion}"/></td>
							<td><c:out value="${pedido.fechaHora}"/></td>
							<td><c:out value="${pedido.usuario.getNombre()}"/></td>
							<td><a class="btn btn-success btn-sm" onclick="enProcesoEntrega(${pedido.idPedido})" role="button">Pendiente de entrega <span class="glyphicon glyphicon-export" aria-hidden="true"></span></a></td>
						</tr>
					</c:forEach>
				</tbody> 
			</table>
       	</div>
      </div> 
	</div>
<hr>
<!-- ============ Footer Section  ============= -->
	
	<footer class="sub_footer footerClass">
	<div class="container">
		<div class="col-md-4">
			<p class="sub-footer-text text-center">&copy; BigBelly 2018</p>
		</div>
	</div>
	</footer>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
	<script src="js/bootstrap1.min.js" type="text/javascript"></script>
	
	<script type="text/javascript" src="js/jquery-1.10.2.min.js"> </script>
    <script type="text/javascript" src="js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>     
    <script type="text/javascript" src="js/jquery.mixitup.min.js" ></script>
    <script type="text/javascript" src="js/main.js" ></script>
    <script type="text/javascript" src="js/homeCocinero.js" ></script>

	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="jquery-confirm-master/dist/jquery-confirm.min.js" type="text/javascript"></script>
	</body>
</html>