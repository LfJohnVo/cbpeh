<%@ page contentType="text/html; charset=UTF-8" %>

<%@page import="mx.gob.cbpeh.bpd.modelo.Expediente"%>
<%@page import="java.util.List"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatEstatus"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatMunicipio"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatCp"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatEstatusLocalizado"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.Expediente"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatEstado"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatEdad"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatSexo"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatMedioReporte"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatNacionalidad"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatParentesco"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatOcupacion"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatSiNo"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatEstatus"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatMunicipio"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatCp"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatEstatusLocalizado"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.Expediente"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatEstado"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatSexo"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatMedioReporte"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatNacionalidad"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatParentesco"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatOcupacion"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatSiNo"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.PersonaReporta"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatColorOjo"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatTipoOjo"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatColorCabello"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatLongitudCabello"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatTipoCabello"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatFrente"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatBoca"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatLabio"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatDentadura"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatBaseNariz"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatFormaNariz"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatTamanioNariz"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatComplexion"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatTez"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatTipoSangre"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatPeriodicidad"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatLugar"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatMedioContacto"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatEstadoCivil"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatDialecto"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatEstatusEconomico"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatTransporte"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatGrupoEtnico"%>
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
<%@page import="mx.gob.cbpeh.bpd.modelo.Expediente"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatEscolaridad"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatIdioma"%>
<%
	HttpSession session2 = request.getSession();
//List<Expediente> expedientes = (List<Expediente>) session2.getAttribute("expedientes");

List<CatEstado> estado = (List<CatEstado>) session2.getAttribute("estado");
List<CatEdad> edades = (List<CatEdad>) session2.getAttribute("edades");
List<CatSexo> sexos = (List<CatSexo>) session2.getAttribute("sexos");
List<CatMedioReporte> medios = (List<CatMedioReporte>) session2.getAttribute("medios");
List<CatNacionalidad> nacionalidades = (List<CatNacionalidad>) session2.getAttribute("nacionalidades");
List<CatParentesco> parentescos = (List<CatParentesco>) session2.getAttribute("parentescos");
List<CatOcupacion> ocupaciones = (List<CatOcupacion>) session2.getAttribute("ocupaciones");
List<CatSiNo> acompanabas = (List<CatSiNo>) session2.getAttribute("acompanabas");

List<CatColorOjo> coloresOjos = (List<CatColorOjo>) session2.getAttribute("coloresOjos");
List<CatTipoOjo> tiposOjos = (List<CatTipoOjo>) session2.getAttribute("tiposOjos");
List<CatColorCabello> coloresCabello = (List<CatColorCabello>) session2.getAttribute("coloresCabello");
List<CatLongitudCabello> longitudCabello = (List<CatLongitudCabello>) session2.getAttribute("longitudCabello");
List<CatTipoCabello> tiposCabello = (List<CatTipoCabello>) session2.getAttribute("tiposCabello");
List<CatFrente> frentes = (List<CatFrente>) session2.getAttribute("frentes");
List<CatBoca> bocas = (List<CatBoca>) session2.getAttribute("bocas");
List<CatLabio> labios = (List<CatLabio>) session2.getAttribute("labios");
List<CatDentadura> dentaduras = (List<CatDentadura>) session2.getAttribute("dentaduras");
List<PersonaReporta> declarantes = (List<PersonaReporta>) session2.getAttribute("declarantes");

List<CatBaseNariz> baseNariz = (List<CatBaseNariz>) session2.getAttribute("baseNariz");
List<CatFormaNariz> formaNariz = (List<CatFormaNariz>) session2.getAttribute("formaNariz");
List<CatTamanioNariz> tamanioNariz = (List<CatTamanioNariz>) session2.getAttribute("tamanioNariz");
List<CatComplexion> complexiones = (List<CatComplexion>) session2.getAttribute("complexiones");
List<CatTez> tez = (List<CatTez>) session2.getAttribute("tez");

List<CatTipoSangre> sangre = (List<CatTipoSangre>) session2.getAttribute("sangre");
List<CatPeriodicidad> periodicidades = (List<CatPeriodicidad>) session2.getAttribute("periodicidades");
List<CatSiNo> siNo = (List<CatSiNo>) session2.getAttribute("siNo");
List<CatLugar> lugares = (List<CatLugar>) session2.getAttribute("lugares");
List<CatMedioContacto> mediosContacto = (List<CatMedioContacto>) session2.getAttribute("mediosContacto");

List<CatEstadoCivil> estadosCiviles = (List<CatEstadoCivil>) session2.getAttribute("estadosCiviles");
List<CatDialecto> dialectos = (List<CatDialecto>) session2.getAttribute("dialectos");
List<CatEstatusEconomico> estatus = (List<CatEstatusEconomico>) session2.getAttribute("estatus");
List<CatTransporte> transportes = (List<CatTransporte>) session2.getAttribute("transportes");
List<CatGrupoEtnico> grupos = (List<CatGrupoEtnico>) session2.getAttribute("grupos");

List<Expediente> expedientes = (List<Expediente>) session2.getAttribute("expedientes");
List<CatEscolaridad> escolaridades = (List<CatEscolaridad>) session2.getAttribute("escolaridad");
List<CatTipoIdentificacion> tipoIdentificacion = (List<CatTipoIdentificacion>) session2.getAttribute("tipoIdentificacion");
List<CatIdioma> idiomas = (List<CatIdioma>) session2.getAttribute("idiomas");
List<CatGradoEstudio> gradoEstudios = (List<CatGradoEstudio>) session2.getAttribute("gradoEstudios");

List<CatEstatusLocalizado> datosEstatusLocalizado = (List<CatEstatusLocalizado>)session2.getAttribute("estatusLocalizado");
List<CatMunicipio> datosMunicipios = (List<CatMunicipio>)session2.getAttribute("municipiosHidalgo");

String expedienteConsul = (String) session2.getAttribute("expedienteConsul");
//String expedienteConsul = (String)request.getAttribute("expedienteConsul");
%>

<script type="text/javascript">
	initEstatusPersona();
</script>

<% if(expedienteConsul !=null && !expedienteConsul.equals("")){ %>	
	<script>
		setTimeout('$("#expedienteConsulta").val("<%=expedienteConsul%>")',450);
		setTimeout(function () {
			$("#expedienteConsulta").val("<%=expedienteConsul%>");
			consultarEstatusPersona();
			limpiarPath();
		}, 1000);			    
	</script>
<%	} %>


<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h4 class="h4 mb-0 text-gray-800">Consultar Expediente</h4>
</div>
<div id="alertaMsj"></div>
<hr style="height: 2px" color="#EF4B55">
<!-- Content Row -->
<form id="consultarExpedienteForm" name="consultarExpedienteForm" enctype="multipart/form-data">
	<br>
	<div class="row">
		<div class="col-xs-12 col-md-4">
			<label for="expediente">Expediente</label> <select
				class="custom-select d-block w-100" id="expedienteConsulta">
				<option value="">Selecciona...</option>
			</select>
		</div>
		<!-- <div class="col-xs-12 col-md-4">
			<div class="form-group">
				<label for="curp">CURP</label> <input type="text"
					class="form-control text-uppercase" id="curpConsulta">
			</div>
		</div> -->
		<div class="col-xs-12 col-md-8">
			<div class="d-flex flex-row-reverse pt-4">
				<div class="pl-3 pr-3 pt-2">
					<button type="button" onclick="consultarEstatusPersona()"
						class="btn btn-primary">Buscar</button>
				</div>
				<div class="pl-3 pr-3 pt-2">
					<button type="button" onclick="initEstatusPersona()" class="btn btn-primary">Limpiar</button>
				</div>
				<div class="pl-3 pr-3 pt-2">
					<button id="btnExportarExp" type="button" class="btn btn-primary" disabled onclick="exportPdf()">Exportar</button>
				</div>
			</div>
		</div>
	</div>
</form>
<br>
<div class="col-lg-12" id="dvContainer">
	<div class="p-2">
		<div class="card" id="cardReportante">
			<a href="#collapseReportante" class="d-block card-header py-3"
				data-toggle="collapse" role="button" aria-expanded="true"
				aria-controls="collapseReportante">
				<div class="m-0  text-primary">Datos de persona reportante</div>
			</a>
			<div class="collapse show" id="collapseReportante">
				<div class="card-body">
					<form id="formReportanteRead" name="formReportanteRead"
						method="post" enctype="multipart/form-data">
						<nav>
							<div class="nav nav-tabs" id="nav-tab" role="tablist">
								<a class="nav-item nav-link active" id="nav-personalRepo-tab"
									data-toggle="tab" role="tab"
									aria-controls="nav-personalRepo" aria-selected="true">
									<h5 class="h5 mb-0">Datos personales</h5>
								</a>
							</div>
						</nav>
						<div class="tab-content" id="nav-tabContent">
							<div class="tab-pane fade show active" id="nav-personalRepo"
								role="tabpanel" aria-labelledby="nav-personalRepo-tab">
								<div class="form-group row">
									<input type="hidden" id="idReportanteRead"
										name="idReportanteRead" value="">
									<div class="col-lg-4 col-md-12">
										<label for="nombreRepoRead">Nombre(s)</label> <input
											type="text" class="form-control text-uppercase"
											id="nombreRepoRead" name="nombreRepoRead" disabled
											onkeyup="mayusculas(this);">
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="apaternoRepoRead">Apellido paterno</label> <input
											type="text" class="form-control text-uppercase"
											id="apaternoRepoRead" name="apaternoRepoRead" disabled
											onkeyup="mayusculas(this);">
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="amaternoRepoRead">Apellido materno</label> <input
											type="text" class="form-control text-uppercase"
											id="amaternoRepoRead" name="amaternoRepoRead" disabled
											onkeyup="mayusculas(this);">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="estadoRepoRead">Estado</label> <select
											class="custom-select d-block w-100" id="estadoRepoRead"
											name="estadoRepoRead" onchange="cargarMunicipioRepoRead()"
											disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatEstado estados : estado) {
											%>
											<option
												value="<%=estados.getCodigoEstado()%>">
												<%=estados.getEstadoDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="municipioRepoRead">Municipio</label> <select
											class="custom-select d-block w-100" id="municipioRepoRead"
											name="municipioRepoRead" onchange="cargarCpRepoRead()"
											disabled>
											<option value="">Selecciona...</option>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="cpRepoRead">CP</label> <input
											type="text" class="form-control text-uppercase"
											id="cpRepoRead" name="cpRepoRead" disabled>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="coloniaRepoRead">Colonia</label> <input type="text"
											 id="coloniaRepoRead" class="form-control text-uppercase"
											name="coloniaRepoRead" disabled>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="calleRepoRead">Calle y número</label> <input
											type="text" class="form-control text-uppercase"
											id="calleRepoRead" name="calleRepoRead" disabled
											onkeyup="mayusculas(this);">
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="edadRepoRead">Edad</label> <select
											class="custom-select d-block w-100" id="edadRepoRead"
											name="edadRepoRead" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatEdad edad : edades) {
											%>
											<option value="<%=edad.getIdEdad()%>">
												<%=edad.getEdadDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="sexoRepoRead">Sexo</label> <select
											class="custom-select d-block w-100" id="sexoRepoRead"
											name="sexoRepoRead" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatSexo sexo : sexos) {
											%>
											<option value="<%=sexo.getIdSexo()%>">
												<%=sexo.getSexoDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="telefonoRepoRead">Teléfono</label> <input
											type="text" class="form-control text-uppercase"
											id="telefonoRepoRead" name="telefonoRepoRead" required
											disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="correoRepoRead">Correo Electrónico</label> <input
											type="text" class="form-control text-uppercase"
											id="correoRepoRead" name="correoRepoRead" disabled>
									</div>
								</div>
								<br>
							</div>
							<!--
							<div class="form-group row">
								<div class="col-12">
									<div class="d-flex flex-row-reverse">
										<div class="p-3">
											<button id="btnGuardarReportante" type=submit
												class="btn btn-primary">Guardar</button>
										</div>
										<div class="p-3">
											<button id="btnCancelarReportante" type="button"
												class="btn btn-primary" onclick="cancelarReportante()">Cancelar</button>
										</div>
										 <div class="p-3">
											<button id="btnEditarReportante" type="button"
												class="btn btn-primary" onclick="editarReportante()">Editar</button>
										</div>
									</div>
								</div>
							</div> -->
						</div>
						<nav>
							<div class="nav nav-tabs" id="nav-tab" role="tablist">
								<a class="nav-item nav-link active" id="nav-infoRepo-tab"
									data-toggle="tab" role="tab"
									aria-controls="nav-infoRepo" aria-selected="false">
									<h5 class="h5 mb-0">Información Adicional</h5>
								</a>
							</div>
						</nav>
						<div class="tab-content" id="nav-tabContent">
							<div class="tab-pane fade show active" id="nav-infoRepo" role="tabpanel"
								aria-labelledby="nav-infoRepo-tab">

								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="celular2RepoRead">Celular de un segundo
											contacto</label> <input type="text"
											class="form-control text-uppercase" id="celular2RepoRead"
											name="celular2RepoRead" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="relacionRepoRead">Relación con la persona
											desaparecida</label> <select class="custom-select d-block w-100"
											id="relacionRepoRead" name="relacionRepoRead" disabled>
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
										<label for="ocupacionRepoRead">Ocupación</label> <input type="text"
											class="form-control text-uppercase" id="ocupacionRepoRead"
											name="ocupacionRepoRead" disabled>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="medioRepoRead">Medio en que reporta</label> <select
											class="custom-select d-block w-100" id="medioRepoRead"
											name="medioRepoRead" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatMedioReporte medio : medios) {
											%>
											<option value="<%=medio.getIdMedioReporte()%>">
												<%=medio.getMedioReporteDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="nacionalidadRepoRead">Nacionalidad</label> <select
											class="custom-select d-block w-100" id="nacionalidadRepoRead"
											name="nacionalidadRepoRead" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatNacionalidad nacionalidad : nacionalidades) {
											%>
											<option value="<%=nacionalidad.getIdNacionalidad()%>">
												<%=nacionalidad.getNacionalidadDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label>Identificación Oficial</label>
										<div id="divIdentificacionRepoRead"></div>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<br>
		<div class="card" id="cardDesaparecido">
			<a href="#collapseDesaparecida" class="d-block card-header py-3"
				data-toggle="collapse" role="button" aria-expanded="true"
				aria-controls="collapseDesaparecida">
				<div class="m-0  text-primary">Datos de persona desaparecida</div>
			</a>
			<div class="collapse show" id="collapseDesaparecida">
				<div class="card-body">
					<form id="formDesaparecidoRead" name="formDesaparecidoRead">
						<nav>
							<div class="nav nav-tabs" id="nav-tab" role="tablist">
								<a class="nav-item nav-link active" id="nav-personalDesa-tab"
									data-toggle="tab" role="tab"
									aria-controls="nav-personalDesa" aria-selected="true">
									<h5 class="h5 mb-0">Datos personales</h5>
								</a>
							</div>
						</nav>
						<div class="tab-content" id="nav-tabContent">
							<div class="tab-pane fade show active" id="nav-personalDesa"
								role="tabpanel" aria-labelledby="nav-personalDesa-tab">
								<br>
								<!-- <div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="solColaboracion">Declarante</label> <select
											class="custom-select d-block w-100" id="declaranteDesa"
											name="declaranteDesa" disabled>

										</select>
									</div>
								</div> -->
								<div class="form-group row">
								<input type="hidden" id="idDesaparecidoDesa"
										name="idDesaparecidoDesa" value="">
									<div class="col-lg-4 col-md-12">
										<label for="numExpediente">Nombre(s)</label> <input
											type="text" class="form-control text-uppercase"
											id="nombreDesaparecidoDesa" name="nombreDesaparecidoDesa" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="numColaboracion">Apellido paterno</label> <input
											type="text" class="form-control text-uppercase"
											id="apellidoPaternoDesaparecidoDesa"
											name="apellidoPaternoDesaparecidoDesa" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="carpetaInves">Apellido materno</label> <input
											type="text" class="form-control text-uppercase"
											id="apellidoMaternoDesaparecidoDesa"
											name="apellidoMaternoDesaparecidoDesa" disabled>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="fechaAccion">Fecha de nacimiento</label> <input
											type="date" class="form-control text-uppercase"
											id="fechaNacimientoDesa" name="fechaNacimientoDesa" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="solColaboracion">Edad</label> <select
											class="custom-select d-block w-100" id="edadDesaparecidoDesa"
											name="edadDesaparecidoDesa" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatEdad edad : edades) {
											%>
											<option value="<%=edad.getIdEdad()%>">
												<%=edad.getEdadDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="solColaboracion">Sexo</label> <select
											class="custom-select d-block w-100" id="sexoDesaparecidoDesa"
											name="sexoDesaparecidoDesa" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatSexo sexo : sexos) {
											%>
											<option value="<%=sexo.getIdSexo()%>">
												<%=sexo.getSexoDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="folioOficio">CURP</label> <!-- <a class="float-right"
											href="https://www.gob.mx/curp/" target="_blank">obtener
											CURP</a>-->  <input type="text" class="form-control text-uppercase"
											id="curpDesa" name="curpDesa" disabled>


									</div>
									<div class="col-lg-4 col-md-12">
										<label for="folioOficio">RFC</label> <input type="text"
											class="form-control text-uppercase" id="rfcDesa" name="rfcDesa" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Estado civil</label> <select
											class="custom-select d-block w-100" id="estadoCivilDesa"
											name="estadoCivilDesa" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatEstadoCivil estadoCivil : estadosCiviles) {
											%>
											<option value="<%=estadoCivil.getIdEstadoCivil()%>">
												<%=estadoCivil.getEstadoCivil()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="busquedaCampo">Ocupación</label> <input type="text"
											class="form-control text-uppercase"
											id="ocupacionDesaparecidoDesa" name="ocupacionDesaparecidoDesa" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="folioOficio">Quiénes habitan con la
											persona</label> <input type="text"
											class="form-control text-uppercase" id="habitantesDesa"
											name="habitantesDesa" disabled>
									</div>
									<!-- <div class="col-lg-4 col-md-12">
										<label for="folioOficio">Carpeta de investigación</label> <input
											type="text" class="form-control text-uppercase"
											id="carpetaInvestigacionDesa" name="carpetaInvestigacionDesa" disabled> 
									</div> -->
									<div class="col-lg-4 col-md-12">
										<label for="busquedaCampo">Nacionalidad</label> <select
											class="custom-select d-block w-100"
											id="nacionalidadDesaparecidoDesa" name="nacionalidadDesaparecidoDesa" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatNacionalidad nacionalidad : nacionalidades) {
											%>
											<option value="<%=nacionalidad.getIdNacionalidad()%>">
												<%=nacionalidad.getNacionalidadDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Estado</label> <select
											class="custom-select d-block w-100" id="estadoDesaparecidoDesa"
											name="estadoDesaparecidoDesa"
											onchange="cargarMunicipioDesaRead()" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatEstado estados : estado) {
											%>
											<option
												value="<%=estados.getCodigoEstado()%>">
												<%=estados.getEstadoDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Municipio</label> <select
											class="custom-select d-block w-100"
											id="municipioDesaparecidoDesa" name="municipioDesaparecidoDesa"
											onchange="cargarCpDesaRead()" disabled>
											<option value="">Selecciona...</option>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">CP</label> <input
											type="text" class="form-control text-uppercase" id="cpDesaparecidoDesa"
											name="cpDesaparecidoDesa" onchange="cargarColoniaDesaRead()" disabled>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="solColaboracion">Colonia</label> <input
											type="text" class="form-control text-uppercase" id="coloniaDesaparecidoDesa"
											name="coloniaDesaparecidoDesa" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="numColaboracion">Calle y número</label> <input
											type="text" class="form-control text-uppercase"
											id="calleDesaparecidoDesa" name="calleDesaparecidoDesa" disabled>
									</div>
								</div>
							</div>

							<!-- <div class="d-flex flex-row-reverse">
								<div class="p-3">
									<button id="btnGuardarDesaparecido" type=submit
										class="btn btn-primary">Guardar</button>
								</div>
								<div class="p-3">
									<button id="btnCancelarDesaparecido" type="button"
										class="btn btn-primary" onclick="cancelarDesaparecido()">Cancelar</button>
								</div>
								<!-- <div class="p-3">
									<button id="btnEditarDesaparecido" type="button"
										class="btn btn-primary" onclick="editarDesaparecido()">Editar</button>
								</div> 
							</div> -->
						</div>
						<nav>
							<div class="nav nav-tabs" id="nav-tab" role="tablist">
								<a class="nav-item nav-link active" id="nav-fisicaDesa-tab"
									data-toggle="tab"  role="tab"
									aria-controls="nav-fisicaDesa" aria-selected="false">
									<h5 class="h5 mb-0">Descripción física</h5>
								</a>
							</div>
						</nav>
						<div class="tab-content" id="nav-tabContent">
							<div class="tab-pane fade show active" id="nav-fisicaDesa" role="tabpanel"
								aria-labelledby="nav-fisicaDesa-tab">
								<br>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="busquedaCampo">Color de ojos </label> <select
											class="custom-select d-block w-100" id="colorOjosDesa"
											name="colorOjosDesa" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatColorOjo colorOjos : coloresOjos) {
											%>
											<option value="<%=colorOjos.getIdColorOjo()%>">
												<%=colorOjos.getColorOjoDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
																		<div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Longitud de cabello</label> <select
											class="custom-select d-block w-100" id="longitudDesa"
											name="longitudDesa" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatLongitudCabello longitud : longitudCabello) {
											%>
											<option value="<%=longitud.getIdLognitudCabello()%>">
												<%=longitud.getLongitudCabelloDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Tipo de cabello</label> <select
											class="custom-select d-block w-100" id="tipoCabelloDesa"
											name="tipoCabelloDesa" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatTipoCabello tipoCabello : tiposCabello) {
											%>
											<option value="<%=tipoCabello.getIdTipoCabello()%>">
												<%=tipoCabello.getTipoCabelloDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
									<!-- <div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Tipo de ojos</label> <select
											class="custom-select d-block w-100" id="tipoOjosDesa"
											name="tipoOjosDesa" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatTipoOjo tipoOjos : tiposOjos) {
											%>
											<option value="<%=tipoOjos.getIdTipoOjo()%>">
												<%=tipoOjos.getTipoOjoDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="numExpediente">Detalle de los ojos</label> <input
											type="text" class="form-control text-uppercase" id="ojoDesa"
											name="ojoDesa" disabled>
									</div> -->

								</div>
								<div class="form-group row">
									<!-- <div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Color de cabello</label> <select
											class="custom-select d-block w-100" id="colorCabelloDesa"
											name="colorCabelloDesa" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatColorCabello colorCabello : coloresCabello) {
											%>
											<option value="<%=colorCabello.getIdColorCabello()%>">
												<%=colorCabello.getColorCabelloDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div> -->
								</div>
								<div class="form-group row">
									<!-- <div class="col-lg-4 col-md-12">
										<label for="numExpediente">Detalle del cabello</label> <input
											type="text" class="form-control text-uppercase" id="cabelloDesa"
											name="cabelloDesa" disabled>
									</div>  -->
									<div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Frente</label> <select
											class="custom-select d-block w-100" id="frenteDesa" name="frenteDesa" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatFrente frente : frentes) {
											%>
											<option value="<%=frente.getIdFrente()%>">
												<%=frente.getFrenteDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Boca</label> <select
											class="custom-select d-block w-100" id="bocaDesa" name="bocaDesa" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatBoca boca : bocas) {
											%>
											<option value="<%=boca.getIdBoca()%>">
												<%=boca.getBocaDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Labios</label> <select
											class="custom-select d-block w-100" id="labiosDesa" name="labiosDesa" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatLabio labio : labios) {
											%>
											<option value="<%=labio.getIdLabio()%>">
												<%=labio.getLabioDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
								</div>
								<div class="form-group row">
								
									<div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Dentadura</label> <select
											class="custom-select d-block w-100" id="dentaduraDesa"
											name="dentaduraDesa" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatDentadura dentadura : dentaduras) {
											%>
											<option value="<%=dentadura.getIdDentadura()%>">
												<%=dentadura.getDentaduraDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="numColaboracion">Detalle de la Dentadura</label> <input
											type="text" class="form-control text-uppercase"
											id="detalleDentaduraDesa" name="detalleDentaduraDesa" disabled>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Base de nariz</label> <select
											class="custom-select d-block w-100" id="baseNarizDesa"
											name="baseNarizDesa" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatBaseNariz base : baseNariz) {
											%>
											<option value="<%=base.getIdBaseNariz()%>">
												<%=base.getBaseNarizDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Forma de nariz</label> <select
											class="custom-select d-block w-100" id="formaDesa" name="formaDesa" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatFormaNariz forma : formaNariz) {
											%>
											<option value="<%=forma.getIdFormaNariz()%>">
												<%=forma.getFormaNarizDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
									<!-- <div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Tamaño de nariz</label> <select
											class="custom-select d-block w-100" id="tamanioDesa"
											name="tamanioDesa" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatTamanioNariz tamanio : tamanioNariz) {
											%>
											<option value="<%=tamanio.getIdTamanioNariz()%>">
												<%=tamanio.getTamanioNarizDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div> -->
									<div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Color de piel</label> <select
											class="custom-select d-block w-100" id="colorPielDesa"
											name="colorPielDesa" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatTez colorPiel : tez) {
											%>
											<option value="<%=colorPiel.getIdTez()%>">
												<%=colorPiel.getTezDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="busquedaCampo">Complexión</label> <select
											class="custom-select d-block w-100" id="complexionDesa"
											name="complexionDesa" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatComplexion complexion : complexiones) {
											%>
											<option value="<%=complexion.getIdComplexion()%>">
												<%=complexion.getComplexionDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="numExpediente"> Peso</label> <input type="text"
											class="form-control text-uppercase" id="pesoDesa" name="pesoDesa" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="numExpediente">Estatura</label> <input type="text"
											class="form-control text-uppercase" id="estaturaDesa"
											name="estaturaDesa" disabled>
									</div>
								</div>
								<div class="form-group row">

									<div class="col-8 col-md-12">
										<label for="descripcionHechos">Señas particulares</label>
										<textarea class="form-control text-uppercase" rows="6"
											id="seniasDesa" name="seniasDesa" disabled></textarea>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="evidenciaColaboracion">Fotografía de la
											persona</label>
											<div id="divFotografiaDesa"></div>
									</div>
								</div>
							</div>
						</div>
						<nav>
							<div class="nav nav-tabs" id="nav-tab" role="tablist">
								<a class="nav-item nav-link active" id="nav-saludDesa-tab"
									data-toggle="tab" role="tab"
									aria-controls="nav-detalle" aria-selected="false">
									<h5 class="h5 mb-0">Salud física</h5>
								</a>
							</div>
						</nav>
						<div class="tab-content" id="nav-tabContent">
							<div class="tab-pane fade show active" id="nav-saludDesa" role="tabpanel"
								aria-labelledby="nav-saludDesa-tab">
								<br>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="busquedaCampo">Tipo de sangre</label> <select
											class="custom-select d-block w-100" id="sangreDesa" name="sangreDesa" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatTipoSangre tipoSangre : sangre) {
											%>
											<option value="<%=tipoSangre.getIdTipoSangre()%>">
												<%=tipoSangre.getTipoSangreDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="numColaboracion">Adicciones</label> <input
											type="text" class="form-control text-uppercase"
											id="adiccionesDesa" name="adiccionesDesa" disabled>
									</div>
									<!-- <div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Periodicidad</label> <select
											class="custom-select d-block w-100" id="periodicidadDesa"
											name="periodicidadDesa" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatPeriodicidad periodicidad : periodicidades) {
											%>
											<option value="<%=periodicidad.getIdPeriodicidad()%>">
												<%=periodicidad.getPeriodicidadDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div> -->
								</div>
								<!--<div class="form-group row">
									 <div class="col-lg-4 col-md-8">
										<label for="edoColaboracion">Operaciones</label> <select
											class="custom-select d-block w-100" id="operacionesDesa"
											name="operacionesDesa"  onchange="desbloquearEdit('operacionesDesa', '#descripcionOperacionesDesa')">
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
									<div class="col-8">
										<label for="descripcionHechos">Descripcion de
											operaciones</label>
										<textarea class="form-control text-uppercase" rows="2"
											id="descripcionOperacionesDesa" name="descripcionOperacionesDesa" disabled></textarea>
									</div> 
								</div>-->
								<!-- <div class="form-group row">
									<div class="col-lg-4 col-md-8">
										<label for="edoColaboracion">Padecimientos/Discapacidad</label>
										<select class="custom-select d-block w-100" id="discapacidadDesa"
											name="discapacidadDesa"  onchange="desbloquearEdit('discapacidadDesa', '#descripcionDiscapacidadDesa')">
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
									<div class="col-8">
										<label for="descripcionHechos">Descripción de
											padecimientos/discapacidad</label>
										<textarea class="form-control text-uppercase" rows="2"
											id="descripcionDiscapacidadDesa" name="descripcionDiscapacidadDesa" disabled ></textarea>
									</div>
								</div> -->
								<div class="form-group row">
									<div class="col-lg-4 col-md-8">
										<label for="edoColaboracion">Fracturas</label> <select
											class="custom-select d-block w-100" id="fracturasDesa"
											name="fracturasDesa"  onchange="desbloquearEdit('fracturasDesa', '#descripcionFracturasDesa')" disabled>
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
									<div class="col-8">
										<label for="descripcionHechos">Descripción de
											fracturas</label>
										<textarea class="form-control text-uppercase" rows="3"
											id="descripcionFracturasDesa" name="descripcionFracturasDesa" disabled></textarea>
									</div>
								</div>
							</div>
						</div>
						<nav>
							<div class="nav nav-tabs" id="nav-tab" role="tablist">
								<a class="nav-item nav-link active" id="nav-contextoDesa-tab"
									data-toggle="tab" role="tab"
									aria-controls="nav-hechosDesa" aria-selected="false">
									<h5 class="h5 mb-0">Contexto de desaparición (Hechos)</h5>
								</a>
							</div>
						</nav>
						<div class="tab-content" id="nav-tabContent">
							<div class="tab-pane fade show active" id="nav-hechosDesa" role="tabpanel"
								aria-labelledby="nav-hechosDesa-tab">
								<br>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="fechaAccion">Fecha de desaparición</label> <input
											type="date" class="form-control text-uppercase"
											id="fechaDesaparicionDesa" name="fechaDesaparicionDesa" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="fechaAccion">Fecha de último contacto</label> <input
											type="date" class="form-control text-uppercase"
											id="fechaUltimoContactoDesa" name="fechaUltimoContactoDesa" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Lugar de desaparición</label> <input type="text"
											class="form-control text-uppercase" id="lugarDesaparicionDesa"
											name="lugarDesaparicionDesa" disabled>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Último medio de contacto</label>
										<input type="text" class="form-control text-uppercase" id="ultimoMedioDesa"
											name="ultimoMedioDesa" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Persona que la vio por
											última vez</label> <input type="text" class="form-control text-uppercase"
											id="personaQueVioUltimaVezDesa" name="personaQueVioUltimaVezDesa" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="numExpediente">A dónde se dirigía</label> <input
											type="text" class="form-control text-uppercase" id="dondeIbaDesa"
											name="dondeIbaDesa" disabled>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="numExpediente">Lugares que frecuenta</label> <input
											type="text" class="form-control text-uppercase" id="lugaresDesa"
											name="lugaresDesa" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="numExpediente">Enemistades</label> <input
											type="text" class="form-control text-uppercase"
											id="enemistadesDesa" name="enemistadesDesa" disabled>
									</div>

									<!-- <div class="col-lg-4 col-md-12">
										<label for="numExpediente">Sospechoso principal</label> <input
											type="text" class="form-control text-uppercase"
											id="sospechosoDesa" name="sospechosoDesa" disabled>
									</div>  -->
								</div>
								<div class="form-group row">
									<div class="col-12">
										<label for="descripcionHechos">Actitud extraña en su
											ausencia</label>
										<textarea class="form-control text-uppercase" rows="1"
											id="actitudDesa" name="actitudDesa" disabled></textarea>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-8">
										<label for="edoColaboracion">Ha faltado a casa</label> <select
											class="custom-select d-block w-100" id="faltasDesa" name="faltasDesa"  onchange="desbloquearEdit('faltasDesa', '#descripcionFaltasDesa')" disabled>
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
									<div class="col-8">
										<label for="descripcionHechos">Descripción de las
											faltas</label>
										<textarea class="form-control text-uppercase" rows="2"
											id="descripcionFaltasDesa" name="descripcionFaltasDesa" disabled></textarea>
									</div>
								</div>

								<div class="form-group row">
									<div class="col-lg-4 col-md-8">
										<label for="edoColaboracion">Se advirtio de algún tipo
											de violencia antes o al momento del extravío</label> <select
											class="custom-select d-block w-100" id="violenciaDesa"
											name="violenciaDesa"  onchange="desbloquearEdit('violenciaDesa', '#descripcionViolenciaDesa')" disabled>
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
									<div class="col-8">
										<label for="descripcionHechos">Detalle del tipo de
											violecia</label>
										<textarea class="form-control text-uppercase" rows="2"
											id="descripcionViolenciaDesa" name="descripcionViolenciaDesa" disabled></textarea>
									</div>

								</div>
								<div class="form-group row">
									<div class="col-12">
										<label for="descripcionHechos">Descripción general de
											los hechos</label>
										<textarea class="form-control text-uppercase" rows="8"
											id="descripcionGeneralDesa" name="descripcionGeneralDesa" disabled></textarea>
									</div>
								</div>
							</div>
						</div>
						<nav>
							<div class="nav nav-tabs" id="nav-tab" role="tablist">
								<a class="nav-item nav-link active" id="nav-detalle-tab"
									data-toggle="tab" role="tab"
									aria-controls="nav-pertenenciasDesa" aria-selected="false">
									<h5 class="h5 mb-0">Contexto de desaparición
										(Pertenencias)</h5>
								</a>
							</div>
						</nav>
						<div class="tab-content" id="nav-tabContent">
							<div class="tab-pane fade show active" id="nav-pertenenciasDesa"
								role="tabpanel" aria-labelledby="nav-pertenenciasDesa-tab">
								<br>
								<div class="form-group row">
									<div class="col-12">
										<label for="descripcionHechos">Vestimenta</label>
										<textarea class="form-control text-uppercase" rows="4"
											id="vestimentaDesa" name="vestimentaDesa" disabled></textarea>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-8">
										<label for="edoColaboracion">Lleva algún documento</label> <select
											class="custom-select d-block w-100" id="documentacionDesa"
											name="documentacionDesa"  onchange="desbloquearEdit('documentacionDesa', '#descripcionDocumentacionDesa')" disabled>
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
									<div class="col-8">
										<label for="descripcionHechos">Detalle del documento</label>
										<textarea class="form-control text-uppercase" rows="2"
											id="descripcionDocumentacionDesa" name="descripcionDocumentacionDesa" disabled></textarea>
									</div>

								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-8">
										<label for="edoColaboracion">Dejo algún documento</label> <select
											class="custom-select d-block w-100" id="documentoDesa"
											name="documentoDesa"  onchange="desbloquearEdit('documentoDesa', '#descripcionDocumentoDesa')" disabled>
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
									<div class="col-8">
										<label for="descripcionHechos">Detalle del documento</label>
										<textarea class="form-control text-uppercase" rows="2"
											id="descripcionDocumentoDesa" name="descripcionDocumentoDesa" disabled></textarea>
									</div>

								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-8">
										<label for="edoColaboracion">Hubo llamadas, cartas o
											comunicaciones telefónicas o por cualquier otro medio
											anteriores al extravío</label> <select
											class="custom-select d-block w-100" id="llamadasDesa"
											name="llamadasDesa"  onchange="desbloquearEdit('llamadasDesa', '#descripcionLlamadasDesa')" disabled>
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
									<div class="col-8">
										<label for="descripcionHechos">Detalle de las llamadas
											o comunicaciones</label>
										<textarea class="form-control text-uppercase" rows="3"
											id="descripcionLlamadasDesa" name="descripcionLlamadasDesa" disabled></textarea>
									</div>

								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-8">
										<label for="edoColaboracion">Transporte que frecuenta</label>
										<select class="custom-select d-block w-100" id="transporteDesa"
											name="transporteDesa"  onchange="desbloquearEdit('transporteDesa', '#descripcionTransporteDesa')" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatTransporte transporte : transportes) {
											%>
											<option value="<%=transporte.getIdTransporte()%>">
												<%=transporte.getTransporteDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
									<div class="col-8">
										<label for="descripcionHechos">Detalle del transporte</label>
										<textarea class="form-control text-uppercase" rows="2"
											id="descripcionTransporteDesa" name="descripcionTransporteDesa" disabled></textarea>
									</div>
								</div>
							</div>
						</div>
						<nav>
							<div class="nav nav-tabs" id="nav-tab" role="tablist">
								<a class="nav-item nav-link active" id="nav-detalle-tab"
									data-toggle="tab" href="#nav-redesDesa" role="tab"
									aria-controls="nav-redesDesa" aria-selected="false">
									<h5 class="h5 mb-0">Contexto de desaparición (Redes
										sociales)</h5>
								</a>
							</div>
						</nav>
						<div class="tab-content" id="nav-tabContent">
							<div class="tab-pane fade show active" id="nav-redesDesa" role="tabpanel"
								aria-labelledby="nav-redesDesa-tab">
								<br>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="numExpediente">Correo electrónico</label> <input
											type="text" class="form-control text-uppercase" id="correoDesa"
											name="correoDesa" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="numExpediente">Contraseña del correo
											electrónico</label> <input type="text"
											class="form-control text-uppercase" id="contraseniaCorreoDesa"
											name="contraseniaCorreoDesa" disabled>
									</div>

								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="numExpediente">Facebook</label> <input type="text"
											class="form-control text-uppercase" id="facebookDesa"
											name="facebookDesa" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="numExpediente">Contraseña de Facebook</label> <input
											type="text" class="form-control text-uppercase"
											id="contraseniaFacebookDesa" name="contraseniaFacebookDesa" disabled>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="numExpediente">Twitter</label> <input type="text"
											class="form-control text-uppercase" id="twitterDesa"
											name="twitterDesa" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="numExpediente">Contraseña de Twitter</label> <input
											type="text" class="form-control text-uppercase"
											id="contraseniaTwitterDesa" name="contraseniaTwitterDesa" disabled>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="numExpediente">Instagram</label> <input
											type="text" class="form-control text-uppercase"
											id="instagramDesa" name="instagramDesa" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="numExpediente">Contraseña de Instagram</label> <input
											type="text" class="form-control text-uppercase"
											id="contraseniaInstagramDesa" name="contraseniaInstagramDesa" disabled>
									</div>
								</div>
							</div>
						</div>
						<nav>
							<div class="nav nav-tabs" id="nav-tab" role="tablist">
								<a class="nav-item nav-link active" id="nav-detalle-tab"
									data-toggle="tab" href="#nav-infoAdicionalDesa" role="tab"
									aria-controls="nav-infoAdicionalDesa" aria-selected="false">
									<h5 class="h5 mb-0">Información Adicional</h5>
								</a>
							</div>
						</nav>
						<div class="tab-content" id="nav-tabContent">
							<div class="tab-pane fade show active" id="nav-infoAdicionalDesa"
								role="tabpanel" aria-labelledby="nav-infoAdicionalDesa-tab">
								<br>
								<div class="form-group row">
									<div class="col-lg-4 col-md-8">
										<label for="edoColaboracion">Hijos</label> <select
											class="custom-select d-block w-100" id="hijosDesa" name="hijosDesa" 
											onchange="desbloquearEdit('hijosDesa', '#descripcionHijosDesa')" disabled>
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
									<div class="col-8">
										<label for="descripcionHechos">Descripción de hijos</label>
										<textarea class="form-control text-uppercase" rows="2"
											id="descripcionHijosDesa" name="descripcionHijosDesa" disabled></textarea>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="numExpediente">Pasatiempos</label> <input
											type="text" class="form-control text-uppercase"
											id="pasatiemposDesa" name="pasatiemposDesa" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Le consta los hechos
											mencionados</label> <input type="text" class="form-control text-uppercase"
											id="constanciaDesa" name="constanciaDesa" disabled>
									</div>
									<!-- <div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Domina dialecto</label> <select
											class="custom-select d-block w-100" id="dialectoDesa"
											name="dialectoDesa" disabled>
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
									<div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Grupo Étnico</label> <select
											class="custom-select d-block w-100" id="grupoDesa" name="grupoDesa" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatGrupoEtnico grupoEtnico : grupos) {
											%>
											<option value="<%=grupoEtnico.getIdGrupoEtnico()%>">
												<%=grupoEtnico.getGrupoEtnicoDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>-->
								</div>
								<div class="form-group row">
									<!-- <div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Estatus socio económico</label> <select
											class="custom-select d-block w-100" id="estatusEconomicoDesa"
											name="estatusEconomicoDesa" disabled>
											<option value="">Selecciona...</option>
											<%
												for (CatEstatusEconomico economico : estatus) {
											%>
											<option value="<%=economico.getIdEstatusEconomico()%>">
												<%=economico.getEstatusEconomicoDetalle()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="edoColaboracion">Se autoriza difusión</label> <select
											class="custom-select d-block w-100" id="difusionDesa"
											name="difusionDesa" disabled>
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
									</div>-->
								</div>
							</div>
						</div>
					</form>

				</div>
			</div>
			
		</div>
		<br>
		<div class="card" id="cardEvidencias">
			<a href="#collapseEvidencia" class="d-block card-header py-3"
				data-toggle="collapse" role="button" aria-expanded="true"
				aria-controls="collapseEvidencia">
				<div class="m-0  text-primary">Evidencia</div>
			</a>
			<div class="collapse show" id="collapseEvidencia">
				<div class="card-body">
					<div class="table-responsive">
						<table class="table">
							<!-- table-striped-->
							<thead class="thead-light">
								<tr>
									<th scope="col">Fecha de adjunto</th>
									<th scope="col">Nombre documento</th>
									<th scope="col">Descripción</th>
									<th scope="col">Visualizar</th>
									<th scope="col">Eliminar</th>
								</tr>
							</thead>
							<tbody id="evidenciasBody">
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<br>
		<div class="card" id="cardActaEntrevista">
			<a href="#collapseActa" class="d-block card-header py-3"
				data-toggle="collapse" role="button" aria-expanded="true"
				aria-controls="collapseActa">
				<div class="m-0  text-primary">Acta entrevista</div>
			</a>
			<div class="collapse show" id="collapseActa">
				<div class="card-body">
					<form id="formActaEntrevistaRead" name="formActaEntrevistaRead" enctype="multipart/form-data" method="post">
						<nav>
							<div class="nav nav-tabs" id="nav-tab" role="tablist">
								<a class="nav-item nav-link active" id="nav-nuevo-tab"
									data-toggle="tab" href="#nav-nuevo" role="tab"
									aria-controls="nav-nuevo" aria-selected="true">
									<h5 class="h5 mb-0">Datos Entrevistado</h5>
								</a>
							</div>
						</nav>
						<br>
						<div class="tab-content" id="nav-tabContent">
							<div class="tab-pane fade show active" id="nav-nuevo" role="tabpanel"
								aria-labelledby="nav-nuevo-tab">
					
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
									<input type="hidden" id="idActaEntrevista" name="idActaEntrevista" value="">
										<label for="numExpediente">Número Expediente</label> <select
											class="custom-select d-block w-100" id="numExpedienteActaRead"
											name="numExpedienteActaRead"  disabled>
											<option value="">Selecciona...</option>
										<% for(Expediente expediente:expedientes){ %>
											<option value="<%=expediente.getIdExpediente()%>"><%=expediente.getIdExpediente() %></option>									
										<% } %>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="fechaEntrevista">Fecha</label> <input type="date"
											class="form-control text-uppercase" id="fechaActaRead"
											name="fechaActaRead" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="horaEntrevista">Hora</label> <input type="time"
											class="form-control text-uppercase" id="horaActaRead" name="horaActaRead" disabled>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="nombreEntrevistado">Nombre</label> <input type="text"
											class="form-control text-uppercase" id="nombreActaRead"
											name="nombreActaRead" onkeyup="mayusculas(this);" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="aPaterno">Apellido Paterno</label> <input type="text"
											class="form-control text-uppercase" id="aPaternoActaRead"
											name="aPaternoActaRead" onkeyup="mayusculas(this);" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="aMaterno">Apellido Materno</label> <input type="text"
											class="form-control text-uppercase" id="aMaternoActaRead"
											name="aMaternoActaRead" onkeyup="mayusculas(this);" disabled>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="fNacimiento">Fecha de Nacimiento</label> <input
											type="date" class="form-control text-uppercase"
											id="fNacimientoActaRead" name="fNacimientoActaRead" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="solColaboracion">Sexo</label> <select
											class="custom-select d-block w-100" id="sexoActaRead" name="sexoActaRead" disabled>
											<option value="">Selecciona...</option>
										<% 	for (CatSexo sexo : sexos) { %>
											<option value="<%=sexo.getIdSexo()%>"> <%=sexo.getSexoDetalle()%></option>
										<% } %>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="eCivil">Estado Civil</label> <select
											class="custom-select d-block w-100" id="eCivilActaRead"
											name="eCivilActaRead" disabled>
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
											class="custom-select d-block w-100" id="nacionalidadActaRead"
											name="nacionalidadActaRead" disabled>
											<option value="">Selecciona...</option>
											<% for (CatNacionalidad nacionalidad : nacionalidades) { %>
												<option value="<%=nacionalidad.getIdNacionalidad()%>"> <%=nacionalidad.getNacionalidadDetalle()%></option>
											<% } %>	
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="estadoActa">Estado</label> <select
											class="custom-select d-block w-100" id="estadoActaRead"
											name="estadoActaRead" onchange="cargarMunicipioActaRead()" disabled>
											<option value="">Selecciona...</option>
										<% for (CatEstado estados : estado) { %>
											<option value="<%=estados.getIdEstado() + "&" + estados.getCodigoEstado()%>"> <%=estados.getEstadoDetalle()%> </option>
										<% } %>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="municipioActa">Municipio</label> <select
											class="custom-select d-block w-100" id="municipioActaRead"
											name="municipioActaRead" onchange="cargarCpActaRead()" disabled>
											<option value="">Selecciona...</option>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="cpActa">Código Postal </label>
										<select
											class="custom-select d-block w-100" id="cpActaRead"
											name="cpActaRead" onchange="cargarColoniaActaRead()" disabled >
											<option value="">Selecciona...</option>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="coloniaActa">Colonia</label>
										<select class="custom-select d-block w-100" id="coloniaActaRead"
											name="coloniaActaRead" disabled>
											<option value="">Selecciona...</option>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="calleNum">Calle y número </label> <input type="text"
											class="form-control text-uppercase" id="calleNumActaRead"
											name="calleNumActaRead" onkeyup="mayusculas(this);" disabled>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="ocupacion">Ocupación</label> <select
											class="custom-select d-block w-100" id="ocupacionActaRead"
											name="ocupacionActaRead" disabled>
											<option value="">Selecciona...</option>
										<% for (CatOcupacion ocupacion : ocupaciones) { %>
											<option value="<%=ocupacion.getIdOcupacion()%>"> <%=ocupacion.getOcucpacionDetalle()%> 	</option>
										<% } %>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="escolaridad">Escolaridad</label> <select
											class="custom-select d-block w-100" id="escolaridadActaRead"
											name="escolaridadActaRead" disabled>
											<option value="">Selecciona...</option>
										<% for (CatEscolaridad escolaridad : escolaridades) { %>
											<option value="<%=escolaridad.getIdEscolaridad()%>"> <%=escolaridad.getEscolaridadDetalle()%> 	</option>
										<% } %>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="nacimiento">Último grado de estudios</label><select
											class="custom-select d-block w-100" id="gradoEstudioActaRead"
											name="gradoEstudioActaRead" disabled>
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
					
							<!-- <div class="d-flex flex-row-reverse">
								<div class="p-3">
									<button id="btnGuardarActa" type=submit
										class="btn btn-primary">Guardar</button>
								</div>
								<div class="p-3">
									<button id="btnCancelarActa" type="button"
										class="btn btn-primary" onclick="cancelarActa()">Cancelar</button>
								</div>
								<div class="p-3">
									<button id="btnEditarActa" type="button"
										class="btn btn-primary" onclick="editarActa()">Editar</button>
								</div>
							</div>-->
						</div>	
						<nav>
							<div class="nav nav-tabs" id="nav-tab" role="tablist">
								<a class="nav-item nav-link active" id="nav-detalle-tab" data-toggle="tab"
									 role="tab" aria-controls="nav-detalle"
									aria-selected="false">
									<h5 class="h5 mb-0">Información entrevistado</h5>
								</a>
							</div>
						</nav>
						<div class="tab-content" id="nav-tabContent">
							<div class="tab-pane fade show active" id="nav-detalle" role="tabpanel"
								aria-labelledby="nav-detalle-tab">
								<div class="form-group row">
									<div class="col-lg-4 col-md-12">
										<label for="fisico">Tatuajes / Lunares / Marcas visibles</label> <input
											type="text" class="form-control text-uppercase" id="fisicoActaRead"
											name="fisicoActaRead" onkeyup="mayusculas(this);" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="alias">Alias / Apodo </label> <input type="text"
											class="form-control text-uppercase" id="aliasActaRead"
											name="aliasActaRead" onkeyup="mayusculas(this);" disabled>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="edadActa">Edad</label> 
										<select class="custom-select d-block w-100" id="edadActaRead" name="edadActaRead" disabled>
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
										<select class="custom-select d-block w-100" id="idiomaActaRead" name="idiomaActaRead" disabled>
											<option value="">Selecciona...</option>
										<% for (CatIdioma idioma : idiomas) { %>
											<option value="<%=idioma.getIdIdioma() %>"><%=idioma.getIdiomaDetalle() %> </option>
										<% } %>
										</select>
									</div>
					
									<div class="col-lg-4 col-md-12">
										<label for="identificacion">Documento de Identificación </label> <select
											class="custom-select d-block w-100" id="identificacionActaRead"
											name="identificacionActaRead" disabled>
											<option value="">Selecciona...</option>
										<% for (CatTipoIdentificacion identi : tipoIdentificacion) { %>
											<option value="<%=identi.getIdTipoIdentificacion() %>"><%=identi.getTipoIdentificacionDetalle() %> </option>
										<% } %>
										</select>
									</div>
									<div class="col-lg-4 col-md-12">
										<label for="etnico">Grupo Étnico</label>
										<select class="custom-select d-block w-100" id="etnicoActaRead" name="etnicoActaRead" disabled>
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
											class="custom-select d-block w-100" id="leerActaRead" name="leerActaRead" disabled>
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
											class="custom-select d-block w-100" id="escribirActaRead"
											name="escribirActaRead" disabled>
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
											class="custom-select d-block w-100" id="dialectoActaRead"
											name="dialectoActaRead" disabled>
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
											class="custom-select d-block w-100" id="parentescoActaRead"
											name="parentescoActaRead" disabled>
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
											class="custom-select d-block w-100" id="lugarNacimientoActaRead"
											name="lugarNacimientoActaRead" disabled>
											<option value="">Selecciona...</option>
										<% for (CatEstado estados : estado) { %>
											<option value="<%=estados.getIdEstado() %>"> <%=estados.getEstadoDetalle()%> </option>
										<% } %>
										</select>
									</div>
					
									<div class="col-lg-4 col-md-12">
										<label for="tel">Teléfono </label> <input type="number"
											class="form-control text-uppercase" id="telefonoActaRead"
											name="telefonoActaRead" disabled>
									</div>
								</div>
							</div>
						</div>
						<nav>
							<div class="nav nav-tabs" id="nav-tab" role="tablist">
								<a class="nav-item nav-link active" id="nav-detalle-tab2" data-toggle="tab"
									 role="tab" aria-controls="nav-detalle2"
									aria-selected="false">
									<h5 class="h5 mb-0">Relato Entrevista</h5>
								</a>
							</div>
						</nav>
						<div class="tab-content" id="nav-tabContent">
							<div class="tab-pane fade show active" id="nav-detalle2" role="tabpanel"
								aria-labelledby="nav-detalle-tab">
								<div class="form-group row">
									<div class="col-md-12">
										<label for="relatoEntrevista">Relato Entrevista</label>
										<textarea class="form-control text-uppercase" rows="10"
											id="relatoEntrevistaRead" name="relatoEntrevistaRead" onkeyup="mayusculas(this);" disabled></textarea>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<br>
		<div class="card" id="cardContexto">
			<a href="#collapseContexto" class="d-block card-header py-3"
				data-toggle="collapse" role="button" aria-expanded="true"
				aria-controls="collapseContexto">
				<div class="m-0  text-primary">Analisis de contexto</div>
			</a>
			<div class="collapse show" id="collapseContexto">
				<div class="card-body">
					<div class="table-responsive">
						<table class="table">
							<!-- table-striped-->
							<thead class="thead-light">
								<tr>
									<th scope="col">Fecha de adjunto</th>
									<th scope="col">Nombre documento</th>
									<th scope="col">Descripción</th>
									<th scope="col">Visualizar</th>
									<th scope="col">Eliminar</th>
								</tr>
							</thead>
							<tbody id="evidenciasContexto">
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<br>
		<div class="card" id="cardAcciones">
			<a href="#collapseAccion" class="d-block card-header py-3"
				data-toggle="collapse" role="button" aria-expanded="true"
				aria-controls="collapseAccion">
				<div class="m-0  text-primary">Acciones Busqueda</div>
			</a>
			<div class="collapse show" id="collapseAccion">
				<div class="card-body">
					<div id="bodyAcciones">
						
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="modal" id="editarEvidencia">
	<!-- The Modal carga de evidencia -->
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<!-- Modal Header -->
				<h4 class="modal-title">Editar evidencia</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<!-- Modal body -->
				<form action="">

					<div class="form-group row">
						<div class="col-12 mb-2">
							<div class="form-group">
								<div class="custom-file">
									<input type="file" class="form-control custom-file-input"
										id="evidencia"
										accept="image/gif,image/jpeg,image/png,.pdf,.doc,.docx"
										required> <label
										class="form-control custom-file-label" for="evidencia"
										data-browse="Adjuntar">Selecciona el archivo</label>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12 mb-2">
							<label for="descripción">Descripcion de la evidencia</label>
							<textarea class="form-control text-uppercase" rows="4"
								id="descripcion" required></textarea>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12 mb-2">
							<div class="d-flex flex-row-reverse pt-4">
								<div class="p-3">
									<!-- <button type="submit" class="btn btn-primary" >Guardar</button> -->
									<button type="button" class="btn btn-primary"
										data-toggle="modal" data-target="#correcto">Guardar</button>
								</div>
								<div class="p-3">
									<button type="" class="btn btn-primary" data-dismiss="modal">Cancelar</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<div class="modal" id="eliminarEvidencia">
	<!-- The Modal carga de evidencia -->
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<!-- Modal Header -->
				<h4 class="modal-title">Aviso</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<!-- Modal body -->
				<form action="">
					<div class="form-group row">
						<p>¿Desea eliminar el registro?</p>
					</div>
					<div class="form-group row">
						<div class="col-12 mb-2">
							<div class="d-flex flex-row-reverse pt-4">
								<div class="p-3">
									<!-- <button type="submit" class="btn btn-primary" >Guardar</button> -->
									<button type="button" class="btn btn-primary" id="btnEliminar">Aceptar</button>
								</div>
								<div class="p-3">
									<button type="" class="btn btn-primary" data-dismiss="modal">Cancelar</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
