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
<%@page import="java.util.List"%>
<%
	HttpSession session2 = request.getSession();

List<CatEstado> estado = (List<CatEstado>) session2.getAttribute("estado");
List<CatEdad> edades = (List<CatEdad>) session2.getAttribute("edades");
List<CatSexo> sexos = (List<CatSexo>) session2.getAttribute("sexos");
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
%>

<script
	src="<%=request.getContextPath()%>/recursos/scripts/atencionCiudadana.js"></script>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h4 class="h4 mb-0 text-gray-800">Registrar persona desaparecida</h4>

</div>
<hr style="height: 2px" color="#EF4B55">

<form id="formDesaparecida" name="formDesaparecida"
	enctype="multipart/form-data">
	<div id="alertExitoDesaparecida"
		class="alert  alert-info alert-dismissible" role="alert"
		style="display: none;">
		<strong>La persona desaparecida ha sido registrada
			exitosamente con número de expediente: </strong> <strong
			id="expedienteGenerado"> </strong>

	</div>
	<div id="alertDeclarante"
		class="alert  alert-info alert-dismissible" role="alert"
		style="display: none;">
		<strong>Selecciona un declarante</strong>
	</div>
	<div id="alertEstado"
		class="alert  alert-info alert-dismissible" role="alert"
		style="display: none;">
		<strong>Selecciona un Estado</strong> 
	</div>
	<nav>
		<div class="nav nav-tabs" id="nav-tab" role="tablist">
			<a class="nav-item nav-link active" id="nav-nuevo-tab"
				data-toggle="tab" href="#nav-nuevo" role="tab"
				aria-controls="nav-nuevo" aria-selected="true">
				<h5 class="h5 mb-0">Datos personales</h5>
			</a> <a class="nav-item nav-link" id="nav-detalle-tab" data-toggle="tab"
				href="#nav-detalle" role="tab" aria-controls="nav-detalle"
				aria-selected="false">
				<h5 class="h5 mb-0">Descripción física</h5>
			</a> <a class="nav-item nav-link" id="nav-detalle-tab" data-toggle="tab"
				href="#nav-Salud" role="tab" aria-controls="nav-detalle"
				aria-selected="false">
				<h5 class="h5 mb-0">Salud física</h5>
			</a> <a class="nav-item nav-link" id="nav-detalle-tab" data-toggle="tab"
				href="#nav-Contexto" role="tab" aria-controls="nav-detalle"
				aria-selected="false">
				<h5 class="h5 mb-0">Contexto de desaparición (Hechos)</h5>
			</a> <a class="nav-item nav-link" id="nav-detalle-tab" data-toggle="tab"
				href="#nav-ContextoPertenencias" role="tab"
				aria-controls="nav-detalle" aria-selected="false">
				<h5 class="h5 mb-0">Contexto de desaparición (Pertenencias)</h5>
			</a> <a class="nav-item nav-link" id="nav-detalle-tab" data-toggle="tab"
				href="#nav-ContextoRedes" role="tab" aria-controls="nav-detalle"
				aria-selected="false">
				<h5 class="h5 mb-0">Contexto de desaparición (Redes sociales)</h5>
			</a> <a class="nav-item nav-link" id="nav-detalle-tab" data-toggle="tab"
				href="#nav-informacion-adicional" role="tab"
				aria-controls="nav-detalle" aria-selected="false">
				<h5 class="h5 mb-0">Información Adicional</h5>
			</a>
		</div>
	</nav>
	<div class="tab-content" id="nav-tabContent">
		<div class="tab-pane fade show active" id="nav-nuevo" role="tabpanel"
			aria-labelledby="nav-nuevo-tab">
			<br>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="solColaboracion">Declarante</label> <select
						class="custom-select d-block w-100" id="declarante"
						name="declarante">

					</select>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="numExpediente">Nombre(s)</label> <input type="text"
						class="form-control text-uppercase" id="nombreDesaparecido"
						name="nombreDesaparecido">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="numColaboracion">Apellido paterno</label> <input
						type="text" class="form-control text-uppercase"
						id="apellidoPaternoDesaparecido"
						name="apellidoPaternoDesaparecido">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="carpetaInves">Apellido materno</label> <input
						type="text" class="form-control text-uppercase"
						id="apellidoMaternoDesaparecido"
						name="apellidoMaternoDesaparecido">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="fechaAccion">Fecha de nacimiento</label> <input
						type="date" class="form-control text-uppercase"
						id="fechaNacimiento" name="fechaNacimiento">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="solColaboracion">Edad</label> <select
						class="custom-select d-block w-100" id="edadDesaparecido"
						name="edadDesaparecido">
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
						class="custom-select d-block w-100" id="sexoDesaparecido"
						name="sexoDesaparecido">
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
					<label for="folioOficio">CURP</label> <a class="float-right"
						href="https://www.gob.mx/curp/" target="_blank">obtener CURP</a> <input
						type="text" class="form-control text-uppercase" id="curp"
						name="curp">


				</div>
				<div class="col-lg-4 col-md-12">
					<label for="folioOficio">RFC</label> <input type="text"
						class="form-control text-uppercase" id="rfc" name="rfc">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="edoColaboracion">Estado civil</label> <select
						class="custom-select d-block w-100" id="estadoCivil"
						name="estadoCivil">
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
					<label for="busquedaCampo">Ocupación</label> <select
						class="custom-select d-block w-100" id="ocupacionDesaparecido"
						name="ocupacionDesaparecido">
						<option value="">Selecciona...</option>
						<%
							for (CatOcupacion ocupacion : ocupaciones) {
						%>
						<option value="<%=ocupacion.getIdOcupacion()%>">
							<%=ocupacion.getOcucpacionDetalle()%>
						</option>
						<%
							}
						%>
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="folioOficio">Quiénes habitan con la persona</label> <input
						type="text" class="form-control text-uppercase" id="habitantes"
						name="habitantes">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="folioOficio">Carpeta de investigación</label> <input
						type="text" class="form-control text-uppercase"
						id="carpetaInvestigacion" name="carpetaInvestigacion">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="busquedaCampo">Nacionalidad</label> <select
						class="custom-select d-block w-100" id="nacionalidadDesaparecido"
						name="nacionalidadDesaparecido">
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
					<label for="edoColaboracion">Estado</label> <select
						class="custom-select d-block w-100" id="estadoDesaparecido"
						name="estadoDesaparecido" onchange="cargaMunicipioDesaparecido()">
						<option value="">Selecciona...</option>
						<%
							for (CatEstado estados : estado) {
						%>
						<option
							value="<%=estados.getIdEstado() + "&" + estados.getCodigoEstado()%>">
							<%=estados.getEstadoDetalle()%>
						</option>
						<%
							}
						%>
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="edoColaboracion">Municipio</label> <select
						class="custom-select d-block w-100" id="municipioDesaparecido"
						name="municipioDesaparecido" onchange="cargaCpDesaparecido()">
						<option value="">Selecciona...</option>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="edoColaboracion">CP</label> <select
						class="custom-select d-block w-100" id="cpDesaparecido"
						name="cpDesaparecido" onchange="cargaColoniaDesaparecido()">
						<option value="">Selecciona...</option>
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="solColaboracion">Colonia</label> <select
						class="custom-select d-block w-100" id="coloniaDesaparecido"
						name="coloniaDesaparecido">
						<option value="">Selecciona...</option>
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="numColaboracion">Calle y número</label> <input
						type="text" class="form-control text-uppercase"
						id="calleDesaparecido" name="calleDesaparecido">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-12">
					<div class="d-flex flex-row-reverse">

					</div>
				</div>
			</div>
		</div>
		<div class="tab-pane fade" id="nav-detalle" role="tabpanel"
			aria-labelledby="nav-detalle-tab">
			<br>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="busquedaCampo">Color de ojos </label> <select
						class="custom-select d-block w-100" id="colorOjos"
						name="colorOjos">
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
					<label for="edoColaboracion">Tipo de ojos</label> <select
						class="custom-select d-block w-100" id="tipoOjos" name="tipoOjos">
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
						type="text" class="form-control text-uppercase" id="ojo"
						name="ojo">
				</div>

			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="edoColaboracion">Color de cabello</label> <select
						class="custom-select d-block w-100" id="colorCabello"
						name="colorCabello">
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
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="edoColaboracion">Longitud de cabello</label> <select
						class="custom-select d-block w-100" id="longitud" name="longitud">
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
						class="custom-select d-block w-100" id="tipoCabello"
						name="tipoCabello">
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
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="numExpediente">Detalle del cabello</label> <input
						type="text" class="form-control text-uppercase" id="cabello"
						name="cabello">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="edoColaboracion">Frente</label> <select
						class="custom-select d-block w-100" id="frente" name="frente">
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
						class="custom-select d-block w-100" id="boca" name="boca">
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
			</div>
			<div class="form-group row">				
				<div class="col-lg-4 col-md-12">
					<label for="edoColaboracion">Labios</label> <select
						class="custom-select d-block w-100" id="labios" name="labios">
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
				<div class="col-lg-4 col-md-12">
					<label for="edoColaboracion">Dentadura</label> <select
						class="custom-select d-block w-100" id="dentadura"
						name="dentadura">
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
						id="detalleDentadura" name="detalleDentadura">
				</div>
			</div>
			<div class="form-group row">			
				<div class="col-lg-4 col-md-12">
					<label for="edoColaboracion">Base de nariz</label> <select
						class="custom-select d-block w-100" id="baseNariz"
						name="baseNariz">
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
						class="custom-select d-block w-100" id="forma" name="forma">
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
				<div class="col-lg-4 col-md-12">
					<label for="edoColaboracion">Tamaño de nariz</label> <select
						class="custom-select d-block w-100" id="tamanio" name="tamanio">
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
				</div>
			</div>
			<div class="form-group row">				
				
				<div class="col-lg-4 col-md-12">
					<label for="busquedaCampo">Complexión</label> <select
						class="custom-select d-block w-100" id="complexion"
						name="complexion">
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
						class="form-control text-uppercase" id="peso" name="peso">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="numExpediente">Estatura</label> <input type="text"
						class="form-control text-uppercase" id="estatura" name="estatura">
				</div>
			</div>
			<div class="form-group row">				
				
				<div class="col-lg-4 col-md-12">
					<label for="edoColaboracion">Color de piel</label> <select
						class="custom-select d-block w-100" id="colorPiel"
						name="colorPiel">
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
				<div class="col-8">
					<label for="descripcionHechos">Señas particulares</label>
					<textarea class="form-control text-uppercase" rows="1" id="senias"
						name="senias"></textarea>
				</div>					
			</div>
			<div class="form-group row">
			<div class="col-lg-4 col-md-12">
					<label for="evidenciaColaboracion">Fotografía de la persona</label>
					<input type="file" class="form-control-file" id="fotografia"
						name="fotografia" accept=".pdf,.doc,.docx,.png,.jpeg,.jpg,.jfif">
				</div>
							
			</div>
			<div class="form-group row">
				<div class="col-12">
					<div class="d-flex flex-row-reverse">
					</div>
				</div>
			</div>
		</div>
		<div class="tab-pane fade" id="nav-Salud" role="tabpanel"
			aria-labelledby="nav-detalle-tab">
			<br>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="busquedaCampo">Tipo de sangre</label> <select
						class="custom-select d-block w-100" id="sangre" name="sangre">
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
					<label for="numColaboracion">Adicciones</label> <input type="text"
						class="form-control text-uppercase" id="adicciones"
						name="adicciones">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="edoColaboracion">Periodicidad</label> <select
						class="custom-select d-block w-100" id="periodicidad"
						name="periodicidad">
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
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-8">
					<label for="edoColaboracion">Operaciones</label> <select
						class="custom-select d-block w-100" id="operaciones"
						name="operaciones" onchange="desbloquear('operaciones', '#descripcionOperaciones')">
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
					<label for="descripcionHechos">Descripcion de operaciones</label>
					<textarea class="form-control text-uppercase" rows="2"
						id="descripcionOperaciones" name="descripcionOperaciones" disabled></textarea>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-8">
					<label for="edoColaboracion">Padecimientos/Discapacidad</label> <select
						class="custom-select d-block w-100" id="discapacidad"
						name="discapacidad" onchange="desbloquear('discapacidad', '#descripcionDiscapacidad')">
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
						id="descripcionDiscapacidad" name="descripcionDiscapacidad" disabled></textarea>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-8">
					<label for="edoColaboracion">Fracturas</label> <select
						class="custom-select d-block w-100" id="fracturas"
						name="fracturas" onchange="desbloquear('fracturas', '#descripcionFracturas')">
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
					<label for="descripcionHechos">Descripción de fracturas</label>
					<textarea class="form-control text-uppercase" rows="3"
						id="descripcionFracturas" name="descripcionFracturas" disabled></textarea>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-12">
					<div class="d-flex flex-row-reverse">

					</div>
				</div>
			</div>
		</div>
		<div class="tab-pane fade" id="nav-Contexto" role="tabpanel"
			aria-labelledby="nav-detalle-tab">
			<br>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="fechaAccion">Fecha de desaparición</label> <input
						type="date" class="form-control text-uppercase"
						id="fechaDesaparicion" name="fechaDesaparicion">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="fechaAccion">Fecha de último contacto</label> <input
						type="date" class="form-control text-uppercase"
						id="fechaUltimoContacto" name="fechaUltimoContacto">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="edoColaboracion">Lugar de desaparición</label> <select
						class="custom-select d-block w-100" id="lugarDesaparicion"
						name="lugarDesaparicion">
						<option value="">Selecciona...</option>
						<%
							for (CatLugar lugar : lugares) {
						%>
						<option value="<%=lugar.getIdLugar()%>">
							<%=lugar.getLugarDetalle()%>
						</option>
						<%
							}
						%>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="edoColaboracion">Último medio de contacto</label> <select
						class="custom-select d-block w-100" id="ultimoMedio"
						name="ultimoMedio">
						<option value="">Selecciona...</option>
						<%
							for (CatMedioContacto medio : mediosContacto) {
						%>
						<option value="<%=medio.getIdMedioContacto()%>">
							<%=medio.getMedioContactoDetalle()%>
						</option>
						<%
							}
						%>
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="edoColaboracion">Persona que la vio por última
						vez</label> <select class="custom-select d-block w-100"
						id="personaQueVioUltimaVez" name="personaQueVioUltimaVez">
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
					<label for="numExpediente">A dónde se dirigía</label> <input
						type="text" class="form-control text-uppercase" id="dondeIba"
						name="dondeIba">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="numExpediente">Lugares que frecuenta</label> <input
						type="text" class="form-control text-uppercase" id="lugares"
						name="lugares">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="numExpediente">Enemistades</label> <input type="text"
						class="form-control text-uppercase" id="enemistades"
						name="enemistades">
				</div>

				<div class="col-lg-4 col-md-12">
					<label for="numExpediente">Sospechoso principal</label> <input
						type="text" class="form-control text-uppercase" id="sospechoso"
						name="sospechoso">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-12">
					<label for="descripcionHechos">Actitud extraña en su
						ausencia</label>
					<textarea class="form-control text-uppercase" rows="1" id="actitud"
						name="actitud"></textarea>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-8">
					<label for="edoColaboracion">Ha faltado a casa</label> <select
						class="custom-select d-block w-100" id="faltas" name="faltas" onchange="desbloquear('faltas', '#descripcionFaltas')">
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
					<label for="descripcionHechos">Descripción de las faltas</label>
					<textarea class="form-control text-uppercase" rows="2"
						id="descripcionFaltas" name="descripcionFaltas" disabled></textarea>
				</div>
			</div>

			<div class="form-group row">
				<div class="col-lg-4 col-md-8">
					<label for="edoColaboracion">Se advirtio de algún tipo de
						violencia antes o al momento del extravío</label> <select
						class="custom-select d-block w-100" id="violencia"
						name="violencia" onchange="desbloquear('violencia', '#descripcionViolencia')">
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
					<label for="descripcionHechos">Detalle del tipo de violecia</label>
					<textarea class="form-control text-uppercase" rows="2"
						id="descripcionViolencia" name="descripcionViolencia" disabled></textarea>
				</div>

			</div>
			<div class="form-group row">
				<div class="col-12">
					<label for="descripcionHechos">Descripción general de los
						hechos</label>
					<textarea class="form-control text-uppercase" rows="3"
						id="descripcionGeneral" name="descripcionGeneral"></textarea>
				</div>
			</div>

			<div class="form-group row">
				<div class="col-12">
					<div class="d-flex flex-row-reverse">

					</div>
				</div>
			</div>
		</div>
		<div class="tab-pane fade" id="nav-ContextoPertenencias"
			role="tabpanel" aria-labelledby="nav-detalle-tab">
			<br>
			<div class="form-group row">
				<div class="col-12">
					<label for="descripcionHechos">Vestimenta</label>
					<textarea class="form-control text-uppercase" rows="1"
						id="vestimenta" name="vestimenta"></textarea>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-8">
					<label for="edoColaboracion">Lleva algún documento</label> <select
						class="custom-select d-block w-100" id="documentacion"
						name="documentacion" onchange="desbloquear('documentacion', '#descripcionDocumentacion')">
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
						id="descripcionDocumentacion" name="descripcionDocumentacion" disabled></textarea>
				</div>

			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-8">
					<label for="edoColaboracion">Dejo algún documento</label> <select
						class="custom-select d-block w-100" id="documento"
						name="documento" onchange="desbloquear('documento', '#descripcionDocumento')">
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
						id="descripcionDocumento" name="descripcionDocumento" disabled></textarea>
				</div>

			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-8">
					<label for="edoColaboracion">Hubo llamadas, cartas o
						comunicaciones telefónicas o por cualquier otro medio anteriores
						al extravío</label> <select class="custom-select d-block w-100"
						id="llamadas" name="llamadas" onchange="desbloquear('llamadas', '#descripcionLlamadas')">
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
					<label for="descripcionHechos">Detalle de las llamadas o
						comunicaciones</label>
					<textarea class="form-control text-uppercase" rows="3"
						id="descripcionLlamadas" name="descripcionLlamadas" disabled></textarea>
				</div>

			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-8">
					<label for="edoColaboracion">Transporte que frecuenta</label> <select
						class="custom-select d-block w-100" id="transporte"
						name="transporte" onchange="desbloquear('transporte', '#descripcionTransporte')">
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
						id="descripcionTransporte" name="descripcionTransporte" disabled></textarea>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-12">
					<div class="d-flex flex-row-reverse">

					</div>
				</div>
			</div>
		</div>
		<div class="tab-pane fade" id="nav-ContextoRedes" role="tabpanel"
			aria-labelledby="nav-detalle-tab">
			<br>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="numExpediente">Correo electrónico</label> <input
						type="text" class="form-control text-uppercase" id="correo"
						name="correo">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="numExpediente">Contraseña del correo
						electrónico</label> <input type="text" class="form-control text-uppercase"
						id="contraseniaCorreo" name="contraseniaCorreo">
				</div>

			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="numExpediente">Facebook</label> <input type="text"
						class="form-control text-uppercase" id="facebook" name="facebook">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="numExpediente">Contraseña de Facebook</label> <input
						type="text" class="form-control text-uppercase"
						id="contraseniaFacebook" name="contraseniaFacebook">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="numExpediente">Twitter</label> <input type="text"
						class="form-control text-uppercase" id="twitter" name="twitter">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="numExpediente">Contraseña de Twitter</label> <input
						type="text" class="form-control text-uppercase"
						id="contraseniaTwitter" name="contraseniaTwitter">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="numExpediente">Instagram</label> <input type="text"
						class="form-control text-uppercase" id="instagram"
						name="instagram">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="numExpediente">Contraseña de Instagram</label> <input
						type="text" class="form-control text-uppercase"
						id="contraseniaInstagram" name="contraseniaInstagram">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-12">
					<div class="d-flex flex-row-reverse">
						
					</div>
				</div>
			</div>
		</div>
		<div class="tab-pane fade" id="nav-informacion-adicional"
			role="tabpanel" aria-labelledby="nav-detalle-tab">
			<br>
			<div class="form-group row">
				<div class="col-lg-4 col-md-8">
					<label for="edoColaboracion">Hijos</label> <select
						class="custom-select d-block w-100" id="hijos" name="hijos" onchange="desbloquear('hijos', '#descripcionHijos')">
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
						id="descripcionHijos" name="descripcionHijos" disabled></textarea>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="numExpediente">Pasatiempos</label> <input type="text"
						class="form-control text-uppercase" id="pasatiempos"
						name="pasatiempos">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="edoColaboracion">Domina dialecto</label> <select
						class="custom-select d-block w-100" id="dialecto" name="dialecto">
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
						class="custom-select d-block w-100" id="grupo" name="grupo">
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
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="edoColaboracion">Estatus socio económico</label> <select
						class="custom-select d-block w-100" id="estatusEconomico"
						name="estatusEconomico">
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
						class="custom-select d-block w-100" id="difusion" name="difusion">
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
					<label for="edoColaboracion">Le consta los hechos
						mencionados</label> <select class="custom-select d-block w-100"
						id="constancia" name="constancia">
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
			</div>
			<div class="form-group row">
				<div class="col-12">
					<div class="d-flex flex-row-reverse">

					</div>
				</div>
			</div>
		</div>
		<div class="d-flex flex-row-reverse">

			<div class="p-2">
				<!-- <button type="submit" class="btn btn-primary" >Guardar</button> -->
				<button type="submit" id="guardarDesaparecido"
					class="btn btn-primary">Guardar</button>
			</div>
			<div class="p-2">			
				<button type="reset" id="cancelar" class="btn btn-primary" onclick="bloquearTextAreas()">Cancelar</button>
			</div>
		</div>
	</div>
</form>