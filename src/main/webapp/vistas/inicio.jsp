<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="<%=request.getContextPath()%>/recursos/vendor/jquery/jquery.min.js"></script>
	
		<!-- Bootstrap core JavaScript-->
		<script src="<%=request.getContextPath()%>/recursos/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

		<!-- Core plugin JavaScript-->
		<script src="<%=request.getContextPath()%>/recursos/vendor/jquery-easing/jquery.easing.min.js"></script>
		<script src="<%=request.getContextPath()%>/recursos/scripts/globales.js"></script>
		<script type="text/javascript">var pathGlobal = "<%=request.getContextPath()%>";</script>
		<meta http-equiv="X-UA-Compatible" content="IE=chrome">
		<!--
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		-->
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=2.0, user-scalable=yes" />
		<title>#hidalgobuscacontigo</title>
		<!-- Custom fonts for this template-->
		<link href="<%=request.getContextPath()%>/recursos/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

		<!-- Custom styles for this template-->
		<link href="<%=request.getContextPath()%>/recursos/css/sb-admin-2.min.css" rel="stylesheet">
	<!--
	</head>
	-->
    	<style>
    		.bd-placeholder-img {
       			font-size: 1.125rem;
       			text-anchor: middle;
       			-webkit-user-select: none;
       			-moz-user-select: none;
       			-ms-user-select: none;
       			user-select: none;
   			}

   			@media (min-width: 768px) {
       			.bd-placeholder-img-lg {
         			font-size: 3.5rem;
       			}
     		}
      		@media handheld, only screen and (max-width: 480px), only screen and (max-device-width: 480px)
			{
			}
    	</style>
    
  </head>
  <body>
  	<%@ include file="/contenido/incluidos/cabecera.jsp"%>
	<main role="main">
  		<!--Carousel de comunicados -->
  		<%@ include file="../vistas/Comunicados.jsp"%>
		<!--Fin Carousel de comunicados -->

  		<!--Sección Ciudadano -->	

  		<div class="container marketing">

    		<!-- Three columns of text below the carousel -->
    		<div class="row">
      			<div class="col-lg-4">
        			<!-- <img src="<%=request.getContextPath()%>/recursos/img/Reportar.svg" class="bd-placeholder-img rounded-circle"  width="140" height="140" preserveAspectRatio="xMidYMid slice" focusable="false" ><title>hola</title><rect width="100%" height="100%" fill="#777"/></svg> -->
        			<img src="<%=request.getContextPath()%>/recursos/img/Reportar.svg" class="bd-placeholder-img rounded-circle"  width="140" height="140" >
                	<h2>C&oacute;mo Reportar</h2>
        			<p><a class="btn btn-secondary" href="#reportar" role="button">Consulta Aqui</a></p>
      			</div><!-- /.col-lg-4 -->
      			<div class="col-lg-4">
        			<img src="<%=request.getContextPath()%>/recursos/img/contacto.svg" class="bd-placeholder-img rounded-circle"  width="140" height="140" preserveAspectRatio="xMidYMid slice" focusable="false" ><title>hola</title><rect width="100%" height="100%" fill="#777"/></svg>
        			<h2>Contactar</h2>
        			<p><a class="btn btn-secondary" href="#contacto" role="button">Consulta Aqui</a></p>
      			</div><!-- /.col-lg-4 -->
      			<div class="col-lg-4">
        			<img src="<%=request.getContextPath()%>/recursos/img/buscar.svg" class="bd-placeholder-img rounded-circle"  width="140" height="140" preserveAspectRatio="xMidYMid slice" focusable="false" ><title>hola</title><rect width="100%" height="100%" fill="#777"/></svg>
        			<h2>Consulta Expediente</h2>
        			<p><a class="btn btn-secondary" href="#consultarPersonaDesaparecido" role="button">Consulta Aqui</a></p>
      			</div><!-- /.col-lg-4 -->
    		</div><!-- /.row -->

    		<!-- START THE FEATURETTES -->

    		<hr class="featurette-divider">

    		<div class="row featurette" id="reportar">
      			<div class="col-md-12">
        			<h2 class="featurette-heading">¿Cómo reportar a una PERSONA DESAPARECIDA O NO LOCALIZADA?</h2>
        			<p class="lead">
					<p>La Comisión de Búsqueda de Personas del Estado de Hidalgo se encarga de determinar, ejecutar, coordinar y dar seguimiento a las acciones de búsqueda de personas cuya desaparición se encuentra vinculada al ámbito territorial del Estado de Hidalgo. El reporte de una PERSONA DESAPARECIDA O NO LOCALIZADA puede realizarse por cualquiera de las siguientes opciones:</p>
					<p>1. De manera presencial.</p>
					<p>2. V&iacute;a tel&eacute;fonica o correo electr&oacute;nico.</p>

					<p>Este servicio es completamente gratuito y accesible a cualquier persona.</p>
					<p>Para facilitar los procesos de búsqueda, se recomienda que la persona reportante pueda proporcionar la siguiente información:</p>
					<ul>
						<li>Datos generales: nombre, edad, fecha de nacimiento, CURP, nacionalidad, domicilio, género, estado civil, lugar de nacimiento.</li>
						<li>Media filiación: estatura, complexión, color de piel, forma de cara, tipo de nariz, tamaño de frente, forma de mentón, tipo de cejas, color y tamaño de ojos, tipo y color de cabello, señas particulares, cicatrices, tatuajes o cualquier información que describa a la persona.</li>
						<li>Es importante proporcionar información sobre circunstancias, fecha y lugar de la desaparición, información de redes sociales de la PERSONA DESAPARECIDA O NO LOCALIZADA, dato telefónico, bancarios y cualquier información relevante para iniciar las labores de búsqueda.</li>
      				</ul>
      			</div>
    		</div>
    		<hr class="featurette-divider">

    		<div class="row featurette" id="contacto">
      			<div class="col-md-12 order-md-2">
        			<h2 class="featurette-heading">Contacto</h2>
					<p class="lead">
						<p>La Comisi&oacute;n de B&uacute;squeda de Personas del Estado de Hidalgo dispone la siguiente informaci&oacute;n:</p>
						<ul>
							<li><Strong>Ubicaci&oacute;n: </Strong>  Blvd. Felipe &Aacute;ngeles N&uacute;m. 102, 2° piso, Col. Santa Julia, Pachuca de Soto; Hidalgo, C.P. 42080</li>
							<li><Strong>Tel&eacute;fonos: </Strong>  +52 771-349-6393 / +52 77-171-6000 Ext 8015</li>
							<li><Strong>Correo electr&oacute;nico: </Strong>comisiondebusqueda@hidalgo.gob.mx</li>
							<li><Strong>Facebook: </Strong>@CBPEHidalgo</li>
							<li><Strong>Twitter: </Strong>@CBPEHidalgo</li>
						</ul>
					<!--	</p>	-->
      			</div>

    		</div>

    		<hr class="featurette-divider">

    		<div class="row featurette" id="consultarPersonaDesapnarecido">
        		<h2 class="featurette-heading">Consultar estatus de PERSONA DESAPARECIDA O NO LOCALIZADA</h2>
  
     			<%@ include file="../vistas/consultaexpediente.jsp"%>
			</div>
     
    	</div> 

		<hr class="featurette-divider">

    	<!-- /END THE FEATURETTES -->

		<!-- </div><!-- /.container -->

  		<!-- FOOTER -->
  		<%@ include file="../contenido/incluidos/pie.jsp"%>
  
	</main>
	
  </body>
</html>