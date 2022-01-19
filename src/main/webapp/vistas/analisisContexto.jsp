<%@page import="mx.gob.cbpeh.bpd.modelo.CatParentesco"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatTipoNota"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatSiNo"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatArea"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatCompaniaTelefono"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.Expediente"%>
<%@page import="java.util.List"%>
<%
	HttpSession session2 = request.getSession();
	
	 List<Expediente> expedientes = (List<Expediente>)session2.getAttribute("expedientes");
	List<CatCompaniaTelefono> companiaTelefonos = (List<CatCompaniaTelefono>)session2.getAttribute("companiaTel");
	List<CatParentesco> parentesco = (List<CatParentesco>)session2.getAttribute("parentesco");
	List<CatArea> areas = (List<CatArea>)session2.getAttribute("areas");
	List<CatSiNo> siNo = (List<CatSiNo>)session2.getAttribute("siNo");
	List<CatTipoNota> tipoNotas = (List<CatTipoNota>)session2.getAttribute("tipoNota");	
	
	%>
 <script src="<%=request.getContextPath()%>/recursos/scripts/accAC.js"></script>
<nav>
 <div class="nav nav-tabs" id="nav-tab" role="tablist">
 
 <a class="nav-item nav-link active" id="nav-perfil-tab" data-toggle="tab"         href="#nav-perfil" role="tab"
  aria-controls="nav-perfil" aria-selected="true"><h5 class="h5 mb-0">Perfil</h5></a>
                         
 <!-- <a class="nav-item nav-link"        id="nav-info-tel-redes-tab" data-toggle="tab" href="#nav-info-tel-redes" role="tab"
  aria-controls="nav-info-tel-redes" aria-selected="false"><h5 class="h5 mb-0">Informaci&oacute;n telef&oacute;nica y redes sociales</h5></a>
  </div>  -->
</nav>
    <div class="tab-content" id="nav-tabContent">                    
<div class="tab-pane fade show active" id="nav-perfil" role="tabpanel" aria-labelledby="nav-perfil-tab">
                                
 <%@ include file="../contenido/capturaPerfil.jsp" %>
 
 </div>
                           
<!-- <div class="tab-pane fade" id="nav-info-tel-redes" role="tabpanel" aria-labelledby="nav-info-tel-redes-tab"> -->
                             
<!--  < include file="../contenido/capturaInfoTelRedes.jsp" %>  -->
                                
</div>
</div>
 