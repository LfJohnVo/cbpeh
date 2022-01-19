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
		session2.setAttribute("municipios", request.getAttribute("municipios"));			
		session2.setAttribute("estados", request.getAttribute("estados"));
		
		session2.setAttribute("instituciones", request.getAttribute("instituciones"));
		session2.setAttribute("estatusColaboracion", request.getAttribute("estatusColaboracion"));
		session2.setAttribute("lugaresBusqueda", request.getAttribute("lugaresBusqueda"));
		session2.setAttribute("aniosExpedientes", request.getAttribute("aniosExpedientes"));
				
		int idAreaUsuario= 0;
		if(request.getAttribute("usuarioSession") != null)
		{
			Usuario usuario = (Usuario)request.getAttribute("usuarioSession");
			   
			idAreaUsuario = usuario.getCatArea().getIdArea();
			
		}
		session2.setAttribute("asociacionesHidalgo", request.getAttribute("asociacionesHidalgo"));
		session2.setAttribute("busquedaInmediata", request.getAttribute("busquedaInmediata"));
		session2.setAttribute("centroRehabilitacion", request.getAttribute("centroRehabilitacion"));
		session2.setAttribute("comisionEstatal", request.getAttribute("comisionEstatal"));
		
		session2.setAttribute("expedienteConsul", request.getAttribute("expedienteConsul"));
		
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
	<li class="nav-item active justify-content-center">
		<a class="nav-link" href="#"> 
			<i class="fas fa-fw fa-search"></i> 
            <span>Comisionado</span>
        </a>
    </li>
      
    <!-- Nav Item -->
    <hr class="sidebar-divider">
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseProtocolo1"
            aria-expanded="true" aria-controls="collapseProtocolo1">
            <i class="fas fa-fw fa-paperclip"></i>
            <span>Protocolo 1</span>
        </a>
        <div id="collapseProtocolo1" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <a id="links" class="collapse-item" href="#">Links de interés</a>
                <a id="directorios" class="collapse-item" href="#">Directorio</a>                
            </div>
        </div>
    </li>
        
    <!-- Nav Item -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseAtencion"
            aria-expanded="true" aria-controls="collapseThree">
            <i class="fas fa-fw fa-cog"></i>
            <span>Atenci&oacute;n Ciudadana</span>
        </a>
        <div id="collapseAtencion" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <!-- <h6 class="collapse-header">Analisis de contexto</h6> -->
                <a id="mEstatusPersonaDesaparecida" class="collapse-item" href="#">Consultar expediente</a>
                <a id="mCargaEvidenciasAT" class="collapse-item" href="#">Carga de Evidencias</a>
            </div>
        </div>
    </li>
    
    <!-- Nav Item -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseAnalisis"
            aria-expanded="true" aria-controls="collapseThree">
            <i class="fas fa-fw fa-cog"></i>
            <span>An&aacute;lisis de Contexto</span>
        </a>
        <div id="collapseAnalisis" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
				<a id="mCargaAnalisisContexto" class="collapse-item" href="#">An&aacute;lisis de contexto</a>
            </div>
        </div>
    </li>
    
        <!-- Nav Item -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseAcciones"
            aria-expanded="true" aria-controls="collapseThree">
            <i class="fas fa-fw fa-cog"></i>
            <span>Acciones de B&uacute;squeda</span>
        </a>
        <div id="collapseAcciones" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <!-- <h6 class="collapse-header">Analisis de contexto</h6> -->
                <a id="mActaEntrevista" class="collapse-item" href="#">Acta Entrevista</a>
				<a id="mColaboracion" class="collapse-item" href="#">Colaboraci&oacute;n</a>
                <a id="mAccionBusqueda" class="collapse-item" href="#">Acci&oacute;n de búsqueda</a>
                <a id="mLargaData" class="collapse-item" href="#">Larga Data</a>
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
                <a id="mregistroDiariodeBusqueda" class="collapse-item" href="#">Registro diario</a>                
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
