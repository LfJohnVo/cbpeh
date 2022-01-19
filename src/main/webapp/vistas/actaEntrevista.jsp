
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatSexo"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatEstadoCivil"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatNacionalidad"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatOcupacion"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatEstado"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatTipoIdentificacion"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatGrupoEtnico"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatSiNo"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatGradoEstudio"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatDialecto"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatParentesco"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatEdad"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.Expediente"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatEscolaridad"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatIdioma"%>



<%
HttpSession session2 = request.getSession();
List<Expediente> expedientes = (List<Expediente>) session2.getAttribute("expedientes");
List<CatEdad> edades = (List<CatEdad>) session2.getAttribute("edades");
List<CatSexo> sexos = (List<CatSexo>) session2.getAttribute("sexos");
List<CatEstadoCivil> estadosCiviles = (List<CatEstadoCivil>) session2.getAttribute("estadosCiviles");
List<CatNacionalidad> nacionalidades = (List<CatNacionalidad>) session2.getAttribute("nacionalidades");
List<CatOcupacion> ocupaciones = (List<CatOcupacion>) session2.getAttribute("ocupaciones");
List<CatEstado> estado = (List<CatEstado>) session2.getAttribute("estado");
List<CatEscolaridad> escolaridades = (List<CatEscolaridad>) session2.getAttribute("escolaridad");
List<CatTipoIdentificacion> tipoIdentificacion = (List<CatTipoIdentificacion>) session2.getAttribute("tipoIdentificacion");
List<CatGrupoEtnico> grupos = (List<CatGrupoEtnico>) session2.getAttribute("grupos");
List<CatSiNo> siNo = (List<CatSiNo>) session2.getAttribute("acompanabas");
List<CatDialecto> dialectos = (List<CatDialecto>) session2.getAttribute("dialectos");
List<CatParentesco> parentescos = (List<CatParentesco>) session2.getAttribute("parentescos");
List<CatIdioma> idiomas = (List<CatIdioma>) session2.getAttribute("idiomas");
List<CatGradoEstudio> gradoEstudios = (List<CatGradoEstudio>) session2.getAttribute("gradoEstudios");


%>
<script src="<%=request.getContextPath()%>/recursos/scripts/atencionCiudadana.js"></script>
<!--Acta Entrevista -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h4 class="h4 mb-0 text-gray-800">Acta Entrevista</h4>

</div>
<div id="alertaMsj"></div>
<hr style="height: 2px" color="#EF4B55">
<br>
<form id="formActaEntrevista" name="formActaEntrevista" enctype="multipart/form-data" method="post">
	<nav>
		<div class="nav nav-tabs" id="nav-tab" role="tablist">
			<a class="nav-item nav-link active" id="nav-nuevo-tab"
				data-toggle="tab" href="#nav-nuevo" role="tab"
				aria-controls="nav-nuevo" aria-selected="true">
				<h5 class="h5 mb-0">Datos Entrevistado</h5>
			</a> <a class="nav-item nav-link" id="nav-detalle-tab" data-toggle="tab"
				href="#nav-detalle" role="tab" aria-controls="nav-detalle"
				aria-selected="false">
				<h5 class="h5 mb-0">Información entrevistado</h5>
			</a> <a class="nav-item nav-link" id="nav-detalle-tab2" data-toggle="tab"
				href="#nav-detalle2" role="tab" aria-controls="nav-detalle2"
				aria-selected="false">
				<h5 class="h5 mb-0">Relato Entrevista</h5>
			</a>
		</div>
	</nav>
	<br>
	<div class="tab-content" id="nav-tabContent">
		<div class="tab-pane fade show active" id="nav-nuevo" role="tabpanel"
			aria-labelledby="nav-nuevo-tab">

			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="numExpediente">Número Expediente</label> <select
						class="custom-select d-block w-100" id="numExpedienteActa"
						name="numExpedienteActa" required>
						<option value="">Selecciona...</option>
					<% for(Expediente expediente:expedientes){ %>
						<option value="<%=expediente.getIdExpediente() %> "><%=expediente.getIdExpediente() %></option>									
					<% } %>
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="fechaEntrevista">Fecha</label> <input type="date"
						class="form-control text-uppercase" id="fechaActa"
						name="fechaActa">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="horaEntrevista">Hora</label> <input type="time"
						class="form-control text-uppercase" id="horaActa" name="horaActa">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="nombreEntrevistado">Nombre</label> <input type="text"
						class="form-control text-uppercase" id="nombreActa"
						name="nombreActa" onkeyup="mayusculas(this);">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="aPaterno">Apellido Paterno</label> <input type="text"
						class="form-control text-uppercase" id="aPaternoActa"
						name="aPaternoActa" onkeyup="mayusculas(this);">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="aMaterno">Apellido Materno</label> <input type="text"
						class="form-control text-uppercase" id="aMaternoActa"
						name="aMaternoActa" onkeyup="mayusculas(this);">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="fNacimiento">Fecha de Nacimiento</label> <input
						type="date" class="form-control text-uppercase"
						id="fNacimientoActa" name="fNacimientoActa">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="solColaboracion">Sexo</label> <select
						class="custom-select d-block w-100" id="sexoActa" name="sexoActa">
						<option value="">Selecciona...</option>
					<% 	for (CatSexo sexo : sexos) { %>
						<option value="<%=sexo.getIdSexo()%>"> <%=sexo.getSexoDetalle()%></option>
					<% } %>
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="eCivil">Estado Civil</label> <select
						class="custom-select d-block w-100" id="eCivilActa"
						name="eCivilActa">
						<option value="">Selecciona...</option>
						<% for (CatEstadoCivil estadoCivil : estadosCiviles) { %>
							<option value="<%=estadoCivil.getIdEstadoCivil()%>"> <%=estadoCivil.getEstadoCivil()%></option>
						<% } %>						
					</select>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="nacionalidad">Nacionalidad</label> <select
						class="custom-select d-block w-100" id="nacionalidadActa"
						name="nacionalidadActa">
						<option value="">Selecciona...</option>
						<% for (CatNacionalidad nacionalidad : nacionalidades) { %>
							<option value="<%=nacionalidad.getIdNacionalidad()%>"> <%=nacionalidad.getNacionalidadDetalle()%></option>
						<% } %>	
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="estadoActa">Estado</label> <select
						class="custom-select d-block w-100" id="estadoActa"
						name="estadoActa" onchange="cargarMunicipioActa()">
						<option value="">Selecciona...</option>
					<% for (CatEstado estados : estado) { %>
						<option value="<%=estados.getIdEstado() + "&" + estados.getCodigoEstado()%>"> <%=estados.getEstadoDetalle()%> </option>
					<% } %>
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="municipioActa">Municipio</label> <select
						class="custom-select d-block w-100" id="municipioActa"
						name="municipioActa" onchange="cargarCpActa()">
						<option value="">Selecciona...</option>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="cpActa">Código Postal </label>
					<select
						class="custom-select d-block w-100" id="cpActa"
						name="cpActa" onchange="cargarColoniaActa()" >
						<option value="">Selecciona...</option>
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="coloniaActa">Colonia</label>
					<select class="custom-select d-block w-100" id="coloniaActa"
						name="coloniaActa" >
						<option value="">Selecciona...</option>
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="calleNum">Calle y número </label> <input type="text"
						class="form-control text-uppercase" id="calleNumActa"
						name="calleNumActa" onkeyup="mayusculas(this);">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="ocupacion">Ocupación</label> <select
						class="custom-select d-block w-100" id="ocupacionActa"
						name="ocupacionActa">
						<option value="">Selecciona...</option>
					<% for (CatOcupacion ocupacion : ocupaciones) { %>
						<option value="<%=ocupacion.getIdOcupacion()%>"> <%=ocupacion.getOcucpacionDetalle()%> 	</option>
					<% } %>
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="escolaridad">Escolaridad</label> <select
						class="custom-select d-block w-100" id="escolaridadActa"
						name="escolaridadActa">
						<option value="">Selecciona...</option>
					<% for (CatEscolaridad escolaridad : escolaridades) { %>
						<option value="<%=escolaridad.getIdEscolaridad()%>"> <%=escolaridad.getEscolaridadDetalle()%> 	</option>
					<% } %>
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="nacimiento">Último grado de estudios</label><select
						class="custom-select d-block w-100" id="gradoEstudioActa"
						name="gradoEstudioActa">
						<option value="">Selecciona...</option>
						<%
							for (CatGradoEstudio grado : gradoEstudios) {
						%>
						<option value="<%=grado.getIdGradoEstudio()%>">
							<%=grado.getGradoEstudioDetalle()%>
						</option>
						<% } %>
					</select>
				</div>
			</div>
		</div>

		<!--Segundo tab -->
		<div class="tab-pane fade" id="nav-detalle" role="tabpanel"
			aria-labelledby="nav-detalle-tab">
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="fisico">Tatuajes / Lunares / Marcas visibles</label> <input
						type="text" class="form-control text-uppercase" id="fisicoActa"
						name="fisicoActa" onkeyup="mayusculas(this);">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="alias">Alias / Apodo </label> <input type="text"
						class="form-control text-uppercase" id="aliasActa"
						name="aliasActa" onkeyup="mayusculas(this);">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="edadActa">Edad</label> 
					<select class="custom-select d-block w-100" id="edadActa" name="edadActa">
						<option value="">Selecciona...</option>
					<% for (CatEdad edad : edades) { %>
						<option value="<%=edad.getIdEdad()%>"><%=edad.getEdadDetalle()%> </option>
					<% } %>
					</select>						
				</div>


			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="idioma">Idioma</label> 
					<select class="custom-select d-block w-100" id="idiomaActa" name="idiomaActa">
						<option value="">Selecciona...</option>
					<% for (CatIdioma idioma : idiomas) { %>
						<option value="<%=idioma.getIdIdioma() %>"><%=idioma.getIdiomaDetalle() %> </option>
					<% } %>
					</select>
				</div>

				<div class="col-lg-4 col-md-12">
					<label for="identificacion">Documento de Identificación </label> <select
						class="custom-select d-block w-100" id="identificacionActa"
						name="identificacionActa">
						<option value="">Selecciona...</option>
					<% for (CatTipoIdentificacion identi : tipoIdentificacion) { %>
						<option value="<%=identi.getIdTipoIdentificacion() %>"><%=identi.getTipoIdentificacionDetalle() %> </option>
					<% } %>
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="etnico">Grupo Étnico</label>
					<select class="custom-select d-block w-100" id="etnicoActa" name="etnicoActa">
						<option value="">Selecciona...</option>
					<% for (CatGrupoEtnico grupoEtnico : grupos) { %>
					<option value="<%=grupoEtnico.getIdGrupoEtnico()%>"> <%=grupoEtnico.getGrupoEtnicoDetalle()%> </option>
					<% } %>
						</select>
				</div>
			</div>
			<div class="form-group row">

				<div class="col-lg-4 col-md-12">
					<label for="leer">¿Sabe leer?</label> <select
						class="custom-select d-block w-100" id="leerActa" name="leerActa">
						<option value="">Selecciona...</option>
						<%
							for (CatSiNo si : siNo) {
						%>
						<option value="<%=si.getIdSiNo()%>">
							<%=si.getSiNoDetalle()%>
						</option>
						<%
							}
						%>
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="escribir">¿Sabe escribir?</label> <select
						class="custom-select d-block w-100" id="escribirActa"
						name="escribirActa">
						<option value="">Selecciona...</option>
						<%
							for (CatSiNo si : siNo) {
						%>
						<option value="<%=si.getIdSiNo()%>">
							<%=si.getSiNoDetalle()%>
						</option>
						<%
							}
						%>
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="dialecto">¿Habla algún dialecto? </label> <select
						class="custom-select d-block w-100" id="dialectoActa"
						name="dialectoActa">
						<option value="">Selecciona...</option>
						<%
							for (CatDialecto dialecto : dialectos) {
						%>
						<option value="<%=dialecto.getIdDialecto()%>">
							<%=dialecto.getDialectoDetalle()%>
						</option>
						<%
							}
						%>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="parentesco">Parentesco</label> <select
						class="custom-select d-block w-100" id="parentescoActa"
						name="parentescoActa">
						<option value="">Selecciona...</option>
						<%
							for (CatParentesco parentesco : parentescos) {
						%>
						<option value="<%=parentesco.getIdParentesco()%>">
							<%=parentesco.getParentescoDetalle()%>
						</option>
						<%
							}
						%>
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="lugarNacimientoActa">Lugar de Nacimiento </label> 
					<select
						class="custom-select d-block w-100" id="lugarNacimientoActa"
						name="lugarNacimientoActa" >
						<option value="">Selecciona...</option>
					<% for (CatEstado estados : estado) { %>
						<option value="<%=estados.getIdEstado() %>"> <%=estados.getEstadoDetalle()%> </option>
					<% } %>
					</select>
				</div>

				<div class="col-lg-4 col-md-12">
					<label for="tel">Teléfono </label> <input type="number"
						class="form-control text-uppercase" id="telefonoActa"
						name="telefonoActa">
				</div>
			</div>
		</div>
		<!--tercer tab -->

		<div class="tab-pane fade" id="nav-detalle2" role="tabpanel"
			aria-labelledby="nav-detalle-tab">
			<div class="form-group row">
				<div class="col-md-12">
					<label for="relatoEntrevista">Relato Entrevista</label>
					<textarea class="form-control text-uppercase" rows="10"
						id="relatoEntrevista" name="relatoEntrevista" onkeyup="mayusculas(this);"></textarea>
				</div>
			</div>
		</div>
		<div class="form-group row">
			<div class="col-12">
				<div class="d-flex flex-row-reverse">
					<div class="p-3">
						<button type="submit" class="btn btn-primary">Guardar</button>
					</div>
					<div class="p-3">
						<button type="reset" class="btn btn-primary">Limpiar</button>
					</div>
				</div>
			</div>
		</div>
</form>
<!-- Acta entrevista-->