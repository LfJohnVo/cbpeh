<%@page import="mx.gob.cbpeh.bpd.modelo.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%				
		HttpSession session2 = request.getSession();
		//session2.setAttribute("estado", request.getAttribute("estado"));
		session2.setAttribute("expedientes", request.getAttribute("expedientes"));
		session2.setAttribute("municipiosHidalgo", request.getAttribute("municipiosHidalgo"));
		session2.setAttribute("estatusLocalizado", request.getAttribute("estatusLocalizado"));	
		
		session2.setAttribute("companiaTel", request.getAttribute("companiaTel"));
		session2.setAttribute("parentesco", request.getAttribute("parentesco"));
		session2.setAttribute("areas", request.getAttribute("areas"));
		session2.setAttribute("tipoNota", request.getAttribute("tipoNota"));
		
		session2.setAttribute("nombreTitular", request.getAttribute("nombreTitular"));
		session2.setAttribute("puestoTitular", request.getAttribute("puestoTitular"));
		session2.setAttribute("direccion", request.getAttribute("direccion"));
		session2.setAttribute("usuarioSession", request.getAttribute("usuarioSession"));
		
		session2.setAttribute("estado", request.getAttribute("estado"));
		session2.setAttribute("edades", request.getAttribute("edades"));
		session2.setAttribute("sexos", request.getAttribute("sexos"));
		session2.setAttribute("medios", request.getAttribute("medios"));
		session2.setAttribute("nacionalidades", request.getAttribute("nacionalidades"));
		session2.setAttribute("parentescos", request.getAttribute("parentescos"));
		session2.setAttribute("ocupaciones", request.getAttribute("ocupaciones"));
		session2.setAttribute("acompanabas", request.getAttribute("acompanabas"));
		session2.setAttribute("declarantes", request.getAttribute("declarantes"));
		session2.setAttribute("coloresOjos", request.getAttribute("coloresOjos"));
		session2.setAttribute("tiposOjos", request.getAttribute("tiposOjos"));
		session2.setAttribute("coloresCabello", request.getAttribute("coloresCabello"));
		session2.setAttribute("longitudCabello", request.getAttribute("longitudCabello"));
		session2.setAttribute("tiposCabello", request.getAttribute("tiposCabello"));
		session2.setAttribute("frentes", request.getAttribute("frentes"));
		session2.setAttribute("bocas", request.getAttribute("bocas"));
		session2.setAttribute("labios", request.getAttribute("labios"));
		session2.setAttribute("dentaduras", request.getAttribute("dentaduras"));
		
		session2.setAttribute("baseNariz", request.getAttribute("baseNariz"));
		session2.setAttribute("formaNariz", request.getAttribute("formaNariz"));
		session2.setAttribute("tamanioNariz", request.getAttribute("tamanioNariz"));
		session2.setAttribute("complexiones", request.getAttribute("complexiones"));
		session2.setAttribute("tez", request.getAttribute("tez"));
		
		session2.setAttribute("sangre", request.getAttribute("sangre"));
		session2.setAttribute("periodicidades", request.getAttribute("periodicidades"));
		session2.setAttribute("siNo", request.getAttribute("siNo"));
		session2.setAttribute("lugares", request.getAttribute("lugares"));
		session2.setAttribute("mediosContacto", request.getAttribute("mediosContacto"));
		
		session2.setAttribute("estadosCiviles", request.getAttribute("estadosCiviles"));
		session2.setAttribute("dialectos", request.getAttribute("dialectos"));
		session2.setAttribute("estatus", request.getAttribute("estatus"));
		session2.setAttribute("transportes", request.getAttribute("transportes"));
		session2.setAttribute("grupos", request.getAttribute("grupos"));
		
		session2.setAttribute("escolaridad", request.getAttribute("escolaridad"));
		session2.setAttribute("tipoIdentificacion", request.getAttribute("tipoIdentificacion"));
		session2.setAttribute("gradoEstudios", request.getAttribute("gradoEstudios"));
		session2.setAttribute("idiomas", request.getAttribute("idiomas"));
		
		session2.setAttribute("expedienteConsul", request.getAttribute("expedienteConsul"));
		
		int idAreaUsuario= 0;
		if(request.getAttribute("usuarioSession") != null)
		{
			Usuario usuario = (Usuario)request.getAttribute("usuarioSession");
			   
			idAreaUsuario = usuario.getCatArea().getIdArea();
			
		}
		
	%>
	
	<input id="idAreaUsuario" name=idAreaUsuario type="hidden" value="<%=idAreaUsuario%>">
<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

   
    <!-- Divider -->
    <hr class="sidebar-divider my-0">
<br>
<br>
<br>

    <!-- Nav Item -->
	<li class="nav-item active justify-content-center"><a class="nav-link" href="#"> <i
            class="fas fa-fw fa-search"></i> <span>Atencion ciudadana</span></a>
    </li>
    <!-- Divider -->
    <hr class="sidebar-divider">        
    <!-- Nav Item -->
    <!-- 
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseOne"
            aria-expanded="true" aria-controls="collapseTwo">
            <i class="fas fa-fw fa-cog"></i>
            <span>Registrar desaparición</span>
        </a>
        <div id="collapseOne" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <a id="personaReportante" class="collapse-item" href="#">Persona declarante</a>   
                <a id="personaDesaparecida" class="collapse-item" href="#">Persona desaparecida</a>                        
            </div>
        </div>
        
    </li>
    -->
    <!-- Divider -->
    <!--  
    <hr class="sidebar-divider">   
    -->     
    <!-- Nav Item -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseThree"
            aria-expanded="true" aria-controls="collapseThree">
            <i class="fas fa-fw fa-cog"></i>
            <span>Seguimiento de reporte</span>
        </a>
        <div id="collapseThree" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <!-- <h6 class="collapse-header">Analisis de contexto</h6> -->
                <a id="mEstatusPersonaDesaparecida" class="collapse-item" href="#">Consultar expediente</a>
                <a id="mCargaEvidenciasAT" class="collapse-item" href="#">Carga de Evidencias</a>
                
            </div>
        </div>
    </li>
    <!-- Divider -->
    <hr class="sidebar-divider">        
    <!-- Nav Item -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
            aria-expanded="true" aria-controls="collapseTwo">
            <i class="fas fa-fw fa-cog"></i>
            <span>Reportes</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <!-- <h6 class="collapse-header">Analisis de contexto</h6> -->
                <a id="mConcentrado" class="collapse-item" href="#">Concentrado</a>                
            </div>
        </div>
    </li>
    <!-- Divider -->
    <hr class="sidebar-divider">
    <!-- Nav Item -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
            aria-expanded="true" aria-controls="collapseUtilities">
            <i class="fas fa-fw fa-wrench"></i>
            <span>Notificaciones</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
            data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <!--<h6 class="collapse-header">Custom Utilities:</h6> -->
                <a id="mEAtentasNotas" class="collapse-item" href="#">Enviar atentas notas</a>
                <a id="mCAtentasNotas" class="collapse-item" href="#">Consultar atentas notas</a>
                
            </div>
        </div>
    </li>
    <hr class="sidebar-divider">
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>
</ul>
<!-- End of Sidebar -->
