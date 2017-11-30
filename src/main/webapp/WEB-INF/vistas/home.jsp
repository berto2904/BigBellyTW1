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
                        <a class="navbar-brand" href="#">Restaurant Big Belly</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav main-nav  clear navbar-right ">
                            <li><a class="navactive color_animation" href="#top">Bienvenidos</a></li>
                            <li><a class="color_animation" href="#Nosotros">Nosotros</a></li>
                            <li><a class="color_animation" href="#pricing">Precios</a></li>
                            <li><a class="color_animation" href="#beer">Cerveza!</a></li>
                            <li><a class="color_animation" href="#bread">Pan!</a></li>
                            <li><a class="color_animation" href="#reservation">Registrate</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div>
            </div><!-- /.container-fluid -->
        </nav>

	<div id="top" class="starter_container bg">
		<div class="follow_container">
			<div class="col-md-6 col-md-offset-3">
				<h2 class="top-title">Big Belly</h2>
				<h2 class="white second-title">" Come rico "</h2>
				<hr>
			</div>
			<section class="" id="login">
				<div class="text-content container">
					<div class="row">
						<div class="col-md-6 col-md-offset-3">
							<div class="form-group">
								<form:form action="validar-login" method="POST"
									modelAttribute="usuario">
									<form:input path="email" id="email" type="email" class="form-control" />
									<form:input path="password" type="password" id="password"
										class="form-control" />
									<button class="btn btn-lg btn-success btn-block" Type="Submit" />Ingresar</button>
								</form:form>
								<c:if test="${not empty error}">
									<h4>
										<span>${error}</span>
									</h4>
									<br>
									<hr class="colorgraph" />
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</div>
	<!-- ============ Login  ============= -->

	
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
	
	<!-- ============ Pricing  ============= -->

        <section id ="pricing" class="description_content">
             <div class="pricing background_content">
                <h1><span>Precios</span> cuidados</h1>
             </div>
            <div class="text-content container"> 
                <div class="container">
                    <div class="row">
                        <div id="w">
                            <ul id="filter-list" class="clearfix">
                                <li class="filter" data-filter="all">Todo</li>
                                <li class="filter" data-filter="breakfast">Desayuno</li>
                                <li class="filter" data-filter="special">Special</li>
                                <li class="filter" data-filter="desert">Desert</li>
                                <li class="filter" data-filter="dinner">Cena</li>
                            </ul><!-- @end #filter-list -->    
                            <ul id="portfolio">
                                <li class="item breakfast"><img src="images/food_icon01.jpg" alt="Food" >
                                    <h2 class="white">$20</h2>
                                </li>

                                <li class="item dinner special"><img src="images/food_icon02.jpg" alt="Food" >
                                    <h2 class="white">$20</h2>
                                </li>
                                <li class="item dinner breakfast"><img src="images/food_icon03.jpg" alt="Food" >
                                    <h2 class="white">$18</h2>
                                </li>
                                <li class="item special"><img src="images/food_icon04.jpg" alt="Food" >
                                    <h2 class="white">$15</h2>
                                </li>
                                <li class="item dinner"><img src="images/food_icon05.jpg" alt="Food" >
                                    <h2 class="white">$20</h2>
                                </li>
                                <li class="item special"><img src="images/food_icon06.jpg" alt="Food" >
                                    <h2 class="white">$22</h2>
                                </li>
                                <li class="item desert"><img src="images/food_icon07.jpg" alt="Food" >
                                    <h2 class="white">$32</h2>
                                </li>
                                <li class="item desert breakfast"><img src="images/food_icon08.jpg" alt="Food" >
                                    <h2 class="white">$38</h2>
                                </li>
                            </ul><!-- @end #portfolio -->
                        </div><!-- @end #w -->
                    </div>
                </div>
            </div>  
        </section>


        <!-- ============ Our Beer  ============= -->


        <section id ="beer" class="description_content">
            <div  class="beer background_content">
                <h1>Un gran Lugar para <span>disfrutar</span></h1>
            </div>
            <div class="text-content container"> 
                <div class="col-md-5">
                   <div class="img-section">
                       <img src="images/beer_spec.jpg" width="100%">
                   </div>
                </div>
                <br>
                <div class="col-md-6 col-md-offset-1">
                    <h1>Nuestra cerveza</h1>
                    <div class="icon-beer fa-2x"></div>
                    <p class="desc-text">
Aquí, en el restaurante, nos gusta el amor por la cerveza. Sabores nuevos y audaces ingresan a nuestras puertas todas las semanas, y no podemos evitar mostrarlos. Mientras disfrutamos de los clásicos, siempre nos apasiona descubrir algo nuevo, así que ven y experimenta nuestro oficio en su mejor momento.</p>
                </div>
            </div>
        </section>


       <!-- ============ Our Bread  ============= -->


        <section id="bread" class=" description_content">
            <div  class="bread background_content">
                <h1>Nuestros  <span>desayunos</span></h1>
            </div>
            <div class="text-content container"> 
                <div class="col-md-6">
                    <h1>Nuestro Pan</h1>
                    <div class="icon-bread fa-2x"></div>
                    <p class="desc-text">Amamos el aroma del pan recien hecho. Cada pan se hace a mano al romper el alba, utilizando solo los ingredientes más simples para resaltar los olores y sabores que atraen a todo el bloque. Pase por aquí en cualquier momento y experimente la simplicidad en su máxima expresión.</p>
                </div>
                <div class="col-md-6">
                    <img src="images/bread1.jpg" width="260" alt="Bread">
                    <img src="images/bread1.jpg" width="260" alt="Bread">
                </div>
            </div>
        </section>


        
        
		



	<!-- ============ Featured Dish  ============= -->

        <section id="featured" class="description_content">
            <div  class="featured background_content">
                <h1>Cocina de  <span>autor</span></h1>
            </div>
            <div class="text-content container"> 
                <div class="col-md-6">
                    <h1>Que rico menú!</h1>
                    <div class="icon-hotdog fa-2x"></div>
                    <p class="desc-text">
                     Cada comida es hecha a mano al amanecer, utilizando solo los ingredientes más simples para resaltar los olores y sabores que atraen a todo el bloque. Pase por aquí en cualquier momento y experimente la simplicidad en su máxima expresión.</p>
                </div>
                <div class="col-md-6">
                    <ul class="image_box_story2">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <!-- Indicators -->
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>

                            <!-- Wrapper for slides -->
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img src="images/slider1.jpg"  alt="...">
                                    <div class="carousel-caption">
                                        
                                    </div>
                                </div>
                                <div class="item">
                                    <img src="images/slider2.jpg" alt="...">
                                    <div class="carousel-caption">
                                        
                                    </div>
                                </div>
                                <div class="item">
                                    <img src="images/slider3.JPG" alt="...">
                                    <div class="carousel-caption">
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                    </ul>
                </div>
            </div>
        </section>

        <!-- ============ Reservation  ============= -->

        <section  id="reservation"  class="description_content">
            <div class="featured background_content">
                <h1>Registrate!</h1>
            </div>
            <div class="text-content container"> 
                <div class="inner contact">
                    <!-- Form Area -->
                    <div class="contact-form">
                        <!-- Form -->
                        <form:form id="contact-us" method="POST" action="crear-usuario-cliente" modelAttribute="usuarioNuevo">
                            <div class="container">
                                <div class="row">
                                    <div class="col-lg-8 col-md-6 col-xs-12">
                                        <div class="row">
                                            <div class="col-lg-6 col-md-6 col-xs-6">
												<form:input path="nombre" type="text"  required="required" class="form" placeholder="Nombre"/>
                                                <form:input path="apellido" type="text"  required="required" class="form" placeholder="Apellido"/>
                                                <form:input path="celular" type="tel"  required="required" class="form" placeholder="Celular"/>
                                            </div>

                                            <div class="col-lg-6 col-md-6 col-xs-6">
                                                <form:input path="email" type="email"  required="required" class="form" placeholder="E-Mail"/>
                                                 <form:input path="password" type="password"  required="required" class="form" placeholder="Contraseña"/>
                                            </div>

                                            <div class="col-xs-6 ">
												<button class="text-center form-btn form-btn" Type="Submit" id="ingresar"/>Quiero ser BigBelly</button>
                                            </div>
                                            
                                        </div>
                                    </div>
                                    
                                    <div class="col-lg-4 col-md-6 col-xs-12">
                                        <div class="right-text">
                                            <h2>Horarios</h2><hr>
                                            <p>Lunes a Viernes: 7:30 AM - 11:30 AM</p>
                                            <p>Sábados & Domingos: 8:00 AM - 9:00 AM</p>
                                            <p>Lunes a Viernes: 12:00 PM - 5:00 PM</p>
                                            <p>Lunes a Sábados: 6:00 PM - 1:00 AM</p>
                                            <p>Domingo a Lunes: 5:30 PM - 12:00 AM</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="clear"></div>
                        </form:form>
                    </div><!-- End Contact Form Area -->
                </div><!-- End Inner -->
            </div>
        </section>

        <!-- ============ Social Section  ============= -->
      
        <section class="social_connect">
            <div class="text-content container"> 
                <div class="col-md-6">
                    <span class="social_heading">Seguinos</span>
                    <ul class="social_icons">
                        <li><a class="icon-twitter color_animation" href="#" target="_blank"></a></li>
                        <li><a class="icon-github color_animation" href="#" target="_blank"></a></li>
                        <li><a class="icon-linkedin color_animation" href="#" target="_blank"></a></li>
                        <li><a class="icon-mail color_animation" href="#"></a></li>
                    </ul>
                </div>
                <div class="col-md-4">
                    <span class="social_heading">Contacto</span>
                    <span class="social_info"><a class="color_animation" href="tel:883-335-6524">(941) 883-335-6524</a></span>
                </div>
            </div>
        </section>

        <!-- ============ Contact Section  ============= -->

        <section id="contact">
            <div class="map">
<!--                 <iframe src="https://www.google.com.ar/maps/place/Muu+Lecher%C3%ADa+Ramos+Mej%C3%ADa/@-34.6430811,-58.567174,17z/data=!4m12!1m6!3m5!1s0x95bcc62cc3ef7083:0x8867107f425fade5!2sUniversidad+Nacional+de+La+Matanza!8m2!3d-34.6704143!4d-58.5629288!3m4!1s0x95bcc7ef9714870f:0xf7332eda22c3ab24!8m2!3d-34.6423728!4d-58.5669163" width="100%" height="450" frameborder="0" style="border:0" allowfullscreen></iframe> -->
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="inner contact">
                            <!-- Form Area -->
                            <div class="contact-form">
                                <!-- Form -->
                                <form id="contact-us" method="post" action="contact.php">
                                    <!-- Left Inputs -->
                                    <div class="col-md-6 ">
                                        <!-- Name -->
                                        <input type="text" name="name" id="name" required="required" class="form" placeholder="Nombre" />
                                        <!-- Email -->
                                        <input type="email" name="email" id="email" required="required" class="form" placeholder="Email" />
                                        <!-- Subject -->
                                        <input type="text" name="subject" id="subject" required="required" class="form" placeholder="Titulo" />
                                    </div><!-- End Left Inputs -->
                                    <!-- Right Inputs -->
                                    <div class="col-md-6">
                                        <!-- Message -->
                                        <textarea name="message" id="message" class="form textarea"  placeholder="Mensage"></textarea>
                                    </div><!-- End Right Inputs -->
                                    <!-- Bottom Submit -->
                                    <div class="relative fullwidth col-xs-12">
                                        <!-- Send Button -->
                                        <button type="submit" id="submit" name="submit" class="form-btn">Enviar Mensage</button> 
                                    </div><!-- End Bottom Submit -->
                                    <!-- Clear -->
                                    <div class="clear"></div>
                                </form>
                            </div><!-- End Contact Form Area -->
                        </div><!-- End Inner -->
                    </div>
                </div>
            </div>
        </section>

        <!-- ============ Footer Section  ============= -->

        <footer class="sub_footer">
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