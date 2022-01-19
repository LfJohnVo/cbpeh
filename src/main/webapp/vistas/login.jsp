<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>

	<title>Login</title>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/recursos/img/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/recursos/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/recursos/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/recursos/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/recursos/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/recursos/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/recursos/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/recursos/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/recursos/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/recursos/css/util.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/recursos/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	<% String error = "";
	          error = request.getParameter("error");   
	          
	          
	%>
	<div class="limiter">
		<div class="container-login100" >
			<div class="wrap-login100">
			
			
				<form name="login" class="login100-form validate-form p-l-55 p-r-55 p-t-158" action="login" method='POST'>
				<div id="alert"></div>
				<span class="login100-form-logo" style="background-color: #F0F0F0;">
						<i class="zmdi zmdi-account"></i>
					</span>
					<span class="login100-form-title">
						Iniciar Sesi&oacute;n
					</span>
					<br>
					<br>
					<div class="wrap-input100 validate-input m-b-16" data-validate="por favor ingrese el usuario">
						<input class="input100" type="text" id="username" name="username" placeholder="Usuario">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Por favor ingrese la contrase&ntilde;a">
						<input class="input100" type="password" name="password" id="password" placeholder="Contrase&ntilde;a">
					<span class="focus-input100" data-placeholder="&#xf191;"></span>
					</div>

						<div class="text-right p-t-13 p-b-23">
						<span class="txt1">
							
						</span>

						
					</div>
						<br>
					<div class="container-login100-form-btn">
						<button type="submit" class="login100-form-btn">
							Entrar
						</button>
					</div>

					<div class="flex-col-c p-t-70 p-b-20">
						

						<a href="<%=request.getContextPath()%>/" class="txt3">
							Ir al Inicio
						</a>
					</div>
					
				</form>
			
			</div>
		</div>
	</div>
	
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/recursos/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/recursos/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/recursos/vendor/bootstrap/js/popper.js"></script>
	<script src="<%=request.getContextPath()%>/recursos/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/recursos/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/recursos/vendor/daterangepicker/moment.min.js"></script>
	<script src="<%=request.getContextPath()%>/recursos/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/recursos/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/recursos/js/main.js"></script>
	<% if(error != null ) { %>
<script type="text/javascript">


    var html = '<div class="alert alert-danger alert-dismissible" role="alert">'+
        '   <strong>El usuario o password es incorrecto, intentelo nuevamente.</strong>'+
        '       <button class="close" type="button" data-dismiss="alert" aria-label="Close">'+
        '           <span aria-hidden="true"> X </span>'+
        '       </button>'
        '   </div>';

    $('#alert').html(html);
    
     $("#alert").fadeTo(2000, 500).slideUp(500, function(){ 
          $("#alert").text("");
     $("#alert").alert('close'); 
     }); 

</script>

<%} %>
</body>
</html>