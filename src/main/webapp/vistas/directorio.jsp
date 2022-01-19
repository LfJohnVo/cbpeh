<%@page import="mx.gob.cbpeh.bpd.modelo.Expediente"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.AsociacionesHidalgo"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.BusquedaInmediata"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CentrosRehabilitacion"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.ComisionesEstatales"%>
<%@page import="java.util.List"%>

<%
HttpSession session2 = request.getSession();
List<AsociacionesHidalgo> asociacionesHidalgo = (List<AsociacionesHidalgo>) session2.getAttribute("asociacionesHidalgo");
List<BusquedaInmediata> busquedaInmediata = (List<BusquedaInmediata>) session2.getAttribute("busquedaInmediata");
List<CentrosRehabilitacion> centroRehabilitacion = (List<CentrosRehabilitacion>) session2.getAttribute("centroRehabilitacion");
List<ComisionesEstatales> comisionEstatal = (List<ComisionesEstatales>) session2.getAttribute("comisionEstatal");

%>

<script src="<%=request.getContextPath()%>/recursos/scripts/atencionCiudadana.js"></script>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h4 class="h4 mb-0 text-gray-800">Directorio</h4>
</div>

<hr style="height: 2px" color="#EF4B55">
<!-- Content Row -->

	<nav>
		<div class="nav nav-tabs" id="nav-tab" role="tablist">
			<a class="nav-item nav-link active" id="nav-comisionEstatal-tab"
				data-toggle="tab" href="#nav-comisionEstatal" role="tab"
				aria-controls="nav-comisionEstatal" aria-selected="true">
				<h5 class="h5 mb-0">Comisiones Estatales</h5>
			</a>
			<a class="nav-item nav-link" id="nav-inmediata-tab" data-toggle="tab"
				href="#nav-inmediata" role="tab" aria-controls="nav-inmediata"
				aria-selected="false">
				<h5 class="h5 mb-0">Búsqueda Inmediata</h5>
			</a>
			<a class="nav-item nav-link" id="nav-asociaciones-tab" data-toggle="tab"
				href="#nav-asociaciones" role="tab" aria-controls="nav-asociaciones"
				aria-selected="false">
				<h5 class="h5 mb-0">Asociaciones Hidalgo</h5>
			</a>
			<a class="nav-item nav-link" id="nav-rehabilitacion-tab" data-toggle="tab"
				href="#nav-rehabilitacion" role="tab" aria-controls="nav-rehabilitacion"
				aria-selected="false">
				<h5 class="h5 mb-0">Centros Rehabilitación</h5>
			</a>
		</div>
	</nav>
	<br>
	<div class="tab-content" id="nav-tabContent">
		<div class="tab-pane fade show active" id="nav-comisionEstatal" role="tabpanel"
			aria-labelledby="nav-comisionEstatal-tab">
			<div class="form-group row">
				<div class=" table-responsive">
					<table class="table">
					  <thead class="thead-dark">
					    <tr>
					      <th scope="col">#</th>
					      <th scope="col">Entidad Federativa</th>
					      <th >Nombre Oficial</th>
					      <th scope="col">Titular</th>
					      <th scope="col">Domicilio</th>
					      <th scope="col">Teléfono Comisión</th>
					      <th scope="col">Correo Oficial</th>
					      <th scope="col">Tel Móvil Titular</th>
					      <th scope="col">Correo Titular</th>
					      <th scope="col">Enlace</th>
					      <th scope="col">Teléfono Enlace</th>
					      <th scope="col">Correo Alterno</th>
					    </tr>
					  </thead>
					  <tbody>
 						<% for (ComisionesEstatales elemnt : comisionEstatal) { %>
					  	<tr>
					      <td><%=elemnt.getIdComisiones()%> </td>
					      <td><%=elemnt.getCatEstado().getEstadoDetalle()%></td>
					      <td><% if(null !=elemnt.getComision()){%> <%=elemnt.getComision()%> <% }else{ %> &#160; <%}%></td>
					      <td><% if(null !=elemnt.getTitular()){%> <%=elemnt.getTitular()%> <% }else{ %> &#160; <%}%></td>
						  <td><% if(null !=elemnt.getDomicilio()){%><%=elemnt.getDomicilio()%><% }else{ %> &#160; <%}%></td>
						  <td><% if(null !=elemnt.getTelefonoComision()){%><%=elemnt.getTelefonoComision()%><% }else{ %> &#160; <%}%></td>
						  <td><% if(null !=elemnt.getCorreoOficial()){%><%=elemnt.getCorreoOficial()%><% }else{ %> &#160; <%}%> </td>
						  <td><% if(null !=elemnt.getTelefonoTitular()){%><%=elemnt.getTelefonoTitular()%><% }else{ %> &#160; <%}%> </td>
						  <td><% if(null !=elemnt.getCorreoTitular()){%><%=elemnt.getCorreoTitular()%><% }else{ %> &#160; <%}%> </td>
						  <td><% if(null !=elemnt.getEnlace()){%><%=elemnt.getEnlace()%><% }else{ %> &#160; <%}%></td>
						  <td><% if(null !=elemnt.getTelefonoEnlace()){%><%=elemnt.getTelefonoEnlace()%><% }else{ %> &#160; <%}%></td>
						  <td><% if(null !=elemnt.getCorreoEnlace()){%><%=elemnt.getCorreoEnlace()%><% }else{ %> &#160; <%}%></td>
					    </tr>
						<% } %>	
				      </tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="tab-pane fade" id="nav-inmediata" role="tabpanel"
			aria-labelledby="nav-inmediata-tab">
			<div class="form-group row">
				<div class=" table-responsive">
					<table class="table">
					  <thead class="thead-dark">
					    <tr> 
					      <th scope="col">#</th>
					      <th scope="col">Tipo Dependencia</th>
					      <th scope="col">Dependencia</th>
					      <th scope="col">Teléfonos</th>
					    </tr>
					  </thead>
					  <tbody>
  						<% for (BusquedaInmediata elemnt : busquedaInmediata) { %>
					  	<tr>
					      <td><%=elemnt.getIdDependencia()%> </td>
					      	<td>
					      	<% if(null !=elemnt.getCatTipodependencia()){%>
					    	<%=elemnt.getCatTipodependencia().getTipoDependencia()%>
					      	<%	}else{%>
					    	  Dependencia
					      	<%	} %>
					      	</td>
					      <td><%=elemnt.getDependencia()%></td>
					      <td><%=elemnt.getTelefonos()%></td>
					    </tr>
						<% } %>
				      </tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="tab-pane fade" id="nav-asociaciones" role="tabpanel"
			aria-labelledby="nav-asociaciones-tab">
			<div class="form-group row">
				<div class=" table-responsive">
					<table class="table">
					  <thead class="thead-dark">
					    <tr>
					      <th scope="col">#</th>
					      <th scope="col">Asociación</th>
					      <th scope="col">Presidenta y/o representante legal</th>
					      <th scope="col">Celular</th>
					      <th scope="col">Teléfono</th>
					      <th scope="col">Correo</th>
					    </tr>
					  </thead>
					  <tbody>
  						<% for (AsociacionesHidalgo elemnt : asociacionesHidalgo) { %>
					  	<tr>
					      <td><%=elemnt.getIdAsociaciones()%> </td>
					      <td><%=elemnt.getAsociacion()%></td>
					      <td><%=elemnt.getPresidente_representanteLegal()%></td>
					      <td><%=elemnt.getTelefonoMovil()%></td>
					      <td>
					      	<% if(null !=elemnt.getTelefonoFijo()){%>
					      	<%=elemnt.getTelefonoFijo()%>
					      	<% }else{ %> &#160; <%}%>
					      </td>
					      <td><%=elemnt.getCorreoElectronico()%></td>
					    </tr>
						<% } %>
				      </tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="tab-pane fade" id="nav-rehabilitacion" role="tabpanel"
			aria-labelledby="nav-rehabilitacion-tab">
			<div class="form-group row">
				<div class=" table-responsive">
					<table class="table">
					  <thead class="thead-dark">
					    <tr>
					      <th scope="col">#</th>
					      <th scope="col">Nombre</th>
					      <th scope="col">Teléfono</th>
					      <th scope="col">Correo</th>
					      <th scope="col">Municipio</th>
					      <th scope="col">Domicilio</th>
					      <th scope="col">H</th>
					    </tr>
					  </thead>
					  <tbody>
   						<% for (CentrosRehabilitacion elemnt : centroRehabilitacion) { %>
					  	<tr>
					      <td><%=elemnt.getIdCentroRehabilitacion()%> </td>
					      <td><%=elemnt.getCentroRehabilitacion()%></td>
					      <td><%=elemnt.getTelefono()%></td>
   					      <td>
					      	<% if(null !=elemnt.getCorreoElectronico()){%><%=elemnt.getCorreoElectronico()%><% }else{ %> &#160; <%}%>
					      </td>
					      <td><%=elemnt.getIdMunicipio()%></td>
					      <td><%=elemnt.getDomicilio()%></td>
					      <td>
    					    <% if(null !=elemnt.getCatTipoCentrorehabilitacion()){%>
					    	<%=elemnt.getCatTipoCentrorehabilitacion().getTipoCentro()%>
					      	<%	}else{%>
					    	  &#160;
					      	<%	} %>
					    </tr>
						<% } %>
				      </tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
