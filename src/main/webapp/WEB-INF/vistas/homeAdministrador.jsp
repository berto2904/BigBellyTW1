<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta charset="UTF-8">
		<title>Administrador Belly Burger</title>
		
		<link rel="stylesheet" href="administrador/css/normalize.css">
        <link rel="stylesheet" href="administrador/css/main.css" media="screen" type="text/css">
        <link rel="stylesheet" href="administrador/css/bootstrap.css">
        <link rel="stylesheet" href="administrador/css/style-portfolio.css">
        <link rel="stylesheet" href="administrador/css/picto-foundry-food.css" />
        <link rel="stylesheet" href="administrador/css/jquery-ui.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="administrador/css/font-awesome.min.css" rel="stylesheet">
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
                            <li><a class="color_animation" href="/bbtw1/administrador/lista-pedidos-entregados">Lista de pedido facturado</a></li>
                            <li><a class="navactive color_animation" href="#ingrediente">ABM Ingredientes</a></li>
                            <li><a class="navactive color_animation" href="#combos">ABM Combos</a></li>
                            <li><a class="color_animation" href="/bbtw1/cerrar-sesion">Cerrar Sesion</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div>
            </div><!-- /.container-fluid -->
        </nav>
        
        
        
        <%@include file='../../administrador/inlcudes/administracionIngrediente.jsp' %>
        <%@include file='../../administrador/inlcudes/administracionCombo.jsp' %>

        <footer class="sub_footer ">
            <div class="container">
                <div class="col-md-4"><p class="sub-footer-text text-center">&copy; BigBelly 2017</p></div>
            </div>
        </footer>
        
        <script type="text/javascript" src="administrador/js/jquery-1.10.2.min.js"> </script>
        <script type="text/javascript" src="administrador/js/bootstrap.min.js" ></script>
        <script type="text/javascript" src="administrador/js/jquery-1.10.2.js"></script>     
        <script type="text/javascript" src="administrador/js/jquery.mixitup.min.js" ></script>
        <script type="text/javascript" src="administrador/js/main.js" ></script>
        <script type="text/javascript" src="administrador/js/homeAdministrador.js" ></script>
	</body>
</html>