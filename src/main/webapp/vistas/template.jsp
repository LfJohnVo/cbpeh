<%@page import="mx.gob.cbpeh.bpd.modelo.Comunicado"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String expedienteConsul = (String)request.getAttribute("expedienteConsul");
%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
 	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/recursos/vendor/jquery/jquery.min.js"></script>
	
	<!-- Bootstrap core JavaScript-->	
	<script src="<%=request.getContextPath()%>/recursos/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="<%=request.getContextPath()%>/recursos/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="<%=request.getContextPath()%>/recursos/js/sb-admin-2.min.js"></script>
	<script src="<%=request.getContextPath()%>/recursos/scripts/Menu.js"></script>
	<script src="<%=request.getContextPath()%>/recursos/scripts/accionBusqueda.js"></script>
	<script src="<%=request.getContextPath()%>/recursos/scripts/atencionCiudadana.js"></script>
	<script src="<%=request.getContextPath()%>/recursos/scripts/analisisContexto.js"></script>
	<script src="<%=request.getContextPath()%>/recursos/scripts/administracion.js"></script>
	<script src="<%=request.getContextPath()%>/recursos/scripts/globales.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/print-js/1.3.0/print.js"></script>
    <script type="text/javascript">pathGlobal = "<%=request.getContextPath()%>";</script>
<meta http-equiv="X-UA-Compatible" content="IE=chrome">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Hidalgo Busca Contigo</title>
<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/recursos/img/icons/favicon.ico"/>
<!-- Custom fonts for this template-->
<link href="<%=request.getContextPath()%>/recursos/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/recursos/vendor/bootstrap/scss/carousel.css" rel="stylesheet">
<!-- Custom styles for this template-->
<link href="<%=request.getContextPath()%>/recursos/css/sb-admin-2.min.css" rel="stylesheet">
    
<link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@ttskch/select2-bootstrap4-theme@x.x.x/dist/select2-bootstrap4.min.css">
<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
<style type="text/css">
	.select2-search__field:focus-visible {
		outline:none;	
	}
</style>
</head>

<script type="text/javascript">
	var varIdExpediente="<%=request.getAttribute("expedienteConsul")%>";
	console.log(varIdExpediente);
</script>
<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">
	
	<%
			String tipo = "";
			try {
				
				              
			tipo = (request.getParameter("tipo")!= null?request.getParameter("tipo").toString():
				    request.getAttribute("tipo")!=null?request.getAttribute("tipo").toString():"1");
		%>
		<%
			if(tipo == null || tipo.equals("1") ){
		%>
			<%@ include file="../contenido/menu/menuAdmin.jsp"%>
		<%
			} else if(tipo.equals("2")) {
		%>
			<%@ include file="../contenido/menu/menuAC.jsp"%>
		<%
			} else if(tipo.equals("3")) {
		%>
			<%@ include file="../contenido/menu/menuAccionBusqueda.jsp"%>
		<%
			}  else if(tipo.equals("4")) {
		%>
			<%@ include file="../contenido/menu/menuAtencionCiudadana.jsp"%>
		<%
			}  else if(tipo.equals("5")) {
		%>
			<%@ include file="../contenido/menu/MenuCiudadano.html"%>
		<%
			}  else if(tipo.equals("6")) {
		%>
			<%@ include file="../contenido/menu/MenuGerencia.jsp"%>
		<%
			}
		%>
		
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			
			<div id="content">

				<%@ include file="/contenido/incluidos/cabecera.jsp"%>

				<!-- Begin Page Content -->
				<div id="container-fluid" class="container-fluid">
				<% if(expedienteConsul !=null && !expedienteConsul.equals("")){ %>
					
				<script>
					$("#container-fluid").load(pathGlobal + "/vistas/estatusPersonaDesaparecida.jsp");				    
				</script>
				<%	}else{ %>
						<%@ include file="../vistas/Comunicados.jsp"%>
				<%	}	 %>				
						
				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<%@ include file="../contenido/incluidos/pie.jsp"%>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>	
	<%
    }catch(Exception e ){
	  System.out.println("Error "+ e);	
	  
	}%>
</body>
</html>