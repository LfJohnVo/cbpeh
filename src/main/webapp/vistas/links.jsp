<%@page import="mx.gob.cbpeh.bpd.modelo.Expediente"%>
<%@page import="java.util.List"%>

<script src="<%=request.getContextPath()%>/recursos/scripts/atencionCiudadana.js"></script>

<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h4 class="h4 mb-0 text-gray-800">Link de interés</h4>
</div>
<div id="alertaMsj">
</div>
<hr style="height: 2px" color="#EF4B55">
<!-- Content Row -->
<div class="row row-cols-1 row-cols-md-3 mb-3 text-center">
	<div class="col">
	    <div class="card mb-4 rounded-3 shadow-sm">
	      <div class="card-header py-3">
	        <h4 class="my-0 fw-normal">RND-SSPC</h4>
	      </div>
	      <div class="card-body">
	        <ul class="list-unstyled mt-3 mb-4">
	          <li>Registro Nacional de Detenciones - Secretaría de Seguridad y Protección Ciudadana</li>
	        </ul>
	         <a class="w-100 btn btn-lg btn-primary" target="_blank" href="https://consultasdetenciones.sspc.gob.mx/" role="button">Abrir</a>
	      </div>
	    </div>
 	</div>
	<div class="col">
	    <div class="card mb-4 rounded-3 shadow-sm">
	      <div class="card-header py-3">
	        <h4 class="my-0 fw-normal">RNPDNL</h4>
	      </div>
	      <div class="card-body">
	        <ul class="list-unstyled mt-3 mb-4">
	          <li>Registro Nacional de PERSONAS DESAPARECIDAS o NO LOCALIZADAS</li>
	          <li> &#160; </li>
	        </ul>
	        <a class="w-100 btn btn-lg btn-primary" target="_blank" href="http://suiti.segob.gob.mx/busqueda" role="button">Abrir</a>
	      </div>
	    </div>
 	</div>
 	<div class="col">
	    <div class="card mb-4 rounded-3 shadow-sm">
	      <div class="card-header py-3">
	        <h4 class="my-0 fw-normal">REPUVE</h4>
	      </div>
	      <div class="card-body">
	        <ul class="list-unstyled mt-3 mb-4">
	          <li>Registro Público Vehicular</li>
	          <li> &#160; </li>
	          <li> &#160; </li>
	        </ul>
	        <a class="w-100 btn btn-lg btn-primary" target="_blank" href="http://www2.repuve.gob.mx:8080/ciudadania/consulta/" role="button">Abrir</a>
	      </div>
	    </div>
 	</div>
 	<div class="col">
	    <div class="card mb-4 rounded-3 shadow-sm">
	      <div class="card-header py-3">
	        <h4 class="my-0 fw-normal">DGIS</h4>
	      </div>
	      <div class="card-body">
	        <ul class="list-unstyled mt-3 mb-4">
	          <li>Dirección General de Información en Salud- Defunciones</li>
	          <li> &#160; </li>
	        </ul>
	        <a class="w-100 btn btn-lg btn-primary" target="_blank" href="http://www.dgis.salud.gob.mx/contenidos/basesdedatos/da_defunciones_gobmx.html" role="button">Abrir</a>
	      </div>
	    </div>
 	</div>
  	<div class="col">
	    <div class="card mb-4 rounded-3 shadow-sm">
	      <div class="card-header py-3">
	        <h4 class="my-0 fw-normal">INE</h4>
	      </div>
	      <div class="card-body">
	        <ul class="list-unstyled mt-3 mb-4">
	          <li>Lista Nominal verificar Vigencia</li>
	          <li> &#160; </li>
	          <li> &#160; </li>
	        </ul>
	        <a class="w-100 btn btn-lg btn-primary" target="_blank" href="https://listanominal.ine.mx/scpln/" role="button">Abrir</a>
	      </div>
	    </div>
 	</div>
</div>