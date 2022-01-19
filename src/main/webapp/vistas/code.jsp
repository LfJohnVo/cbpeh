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
<div class="container-login100" >
			<div class="wrap-login100">
			
        <div class="col">
            <form th:action="@{/code}" method="post" role="form">
                <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}"/>
                <br>
                <fieldset>
                
                    <h2 class="text-center">Código de verificación</h2>
                    <% if(request.getParameter("error") != null){ %>
                    <div class="alert alert-danger">
                        Código de verificación inválido.
                    </div>
                    <% } %>
                    <br>
                    <br>
                    <div class="form-group">
                        <input type="text" id="code" name="code" class="form-control input-lg" placeholder="Código de verificación" required="true"/>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col">
                            <button class="btn btn-lg btn-success" type="submit">Verificar</button>
                        </div>
                    </div>
                    <br>
                    <br>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>
</html>