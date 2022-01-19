<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/web/thymeleaf/layout" layout:decorate="~{layout}">

<head>

	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
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
<div class="container" >
			<div class="wrap-login">
			
<div layout:fragment="container" class="container">
   
   
    <div class="row">
        <div class="col">
            <p>Escanea este c&oacute;digo QR con la aplicaci&oacute;n <a href="https://support.google.com/accounts/answer/1066447?hl=en" target="_blank">Google Authenticator</a> para obtener el c&oacute;digo del segundo factor de la autenticaci&oacute;n.</p>
            <p><img src="https://chart.googleapis.com/chart?chs=200x200&chld=M%7C0&cht=qr&chl=otpauth%3A%2F%2Ftotp%2FCBPEH%20(admin)%3Fsecret%3D6YFX5TVT76OHHNMS" /></p>
        </div>
    </div>
</div>
</div>
</div>
</body>
</html>

