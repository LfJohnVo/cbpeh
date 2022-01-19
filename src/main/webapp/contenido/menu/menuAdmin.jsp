<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatCatalogosDB"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
				
		HttpSession session2 = request.getSession();
		session2.setAttribute("perfiles", request.getAttribute("perfiles"));
		session2.setAttribute("puestos", request.getAttribute("puestos"));
		session2.setAttribute("areas", request.getAttribute("areas"));
		session2.setAttribute("direccion", request.getAttribute("direccion"));
		session2.setAttribute("tipoComunicados", request.getAttribute("tipoComunicado"));
		session2.setAttribute("estatus", request.getAttribute("estatus"));
		session2.setAttribute("adminUsuarios", request.getAttribute("usuarios"));
		session2.setAttribute("comunicados", request.getAttribute("comunicados"));	
	    session2.setAttribute("catCatalogos", request.getAttribute("catCatalogos"));
	   
		
	%>
	
	                      
<!-- Sidebar -->
<ul	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<div class="sidebar-brand d-flex align-items-center justify-content-center">

		
		<div class="sidebar-brand-text mx-3">Menu</div>
	</div>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item -->
	<li class="nav-item active"><a class="nav-link" href="#"> <i
			class="fas fa-fw fa-tachometer-alt"></i> <span>Administrador</span></a></li>

	<!-- Divider -->
	<hr class="sidebar-divider">


	<!-- Nav Item -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseOne" aria-expanded="true"
		aria-controls="collapseOne"> <i class="fas fa-fw fa-cog"></i> <span>Administracion</span>
	</a>
		<div id="collapseOne" class="collapse" aria-labelledby="headingOne"
			data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<!-- <h6 class="collapse-header">Analisis de contexto</h6> -->
				<a id="mAdminUsuarios" class="collapse-item" href="#">Administrar
					usuarios</a>
					 <a id="mAdminCtls" class="collapse-item" href="#">Administrar
					catalogos</a>
					 <a id="mAdminSliders" class="collapse-item" href="#">Administrar
					comunicados</a>


			</div>
		</div>
		<a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true"
		aria-controls="collapseTwo"> <i class="fas fa-fw fa-cog"></i> <span>Seguridad 2FA</span>
	</a>
		<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
			data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<!-- <h6 class="collapse-header">Analisis de contexto</h6> -->
				<a id="mAdminEscanearQR" class="collapse-item" href="#">Escanear QR</a>
					


			</div>
		</div>
		
		</li>
	<!-- Divider -->
	<hr class="sidebar-divider">



	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>
</ul>
<!-- End of Sidebar -->
