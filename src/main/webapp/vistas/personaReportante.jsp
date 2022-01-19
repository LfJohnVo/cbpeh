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
<%@page import="java.util.List"%>
<%
	HttpSession session2 = request.getSession();
	
	List<CatEstado> estado = (List<CatEstado>)session2.getAttribute("estado");
	List<CatEdad> edades = (List<CatEdad>)session2.getAttribute("edades");
	List<CatSexo> sexos = (List<CatSexo>)session2.getAttribute("sexos");
	List<CatMedioReporte> medios = (List<CatMedioReporte>)session2.getAttribute("medios");
	List<CatNacionalidad> nacionalidades = (List<CatNacionalidad>)session2.getAttribute("nacionalidades");
	List<CatParentesco> parentescos = (List<CatParentesco>)session2.getAttribute("parentescos");
	List<CatOcupacion> ocupaciones = (List<CatOcupacion>)session2.getAttribute("ocupaciones");
	List<CatSiNo> acompanabas = (List<CatSiNo>)session2.getAttribute("acompanabas");	
	%>

<script
	src="<%=request.getContextPath()%>/recursos/scripts/atencionCiudadana.js"></script>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h4 class="h4 mb-0 text-gray-800">Registrar persona declarante</h4>
</div>
<hr style="height: 2px" color="#EF4B55">
<form id="formReportante" name="formReportante"
	enctype="multipart/form-data">
	<div id="alertTelefono" class="alert  alert-info alert-dismissible"
		style="display: none;" role="alert">
		<strong>Se requiere llenar el campo teléfono para registrar
			un declarante anónimo</strong>

	</div>
	<div id="alertExito" class="alert  alert-info alert-dismissible"
		style="display: none;" role="alert">
		<strong>La persona declarante ha sido registrada con éxito</strong>

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
				<h5 class="h5 mb-0">Información Adicional</h5>
			</a>
		</div>
	</nav>
	<br>
	<div class="tab-content" id="nav-tabContent">
		<div class="tab-pane fade show active" id="nav-nuevo" role="tabpanel"
			aria-labelledby="nav-nuevo-tab">

			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="numExpediente">Nombre(s)</label> <input type="text"
						class="form-control text-uppercase" id="nombre" name="nombre">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="numColaboracion">Apellido paterno</label> <input
						type="text" class="form-control text-uppercase"
						id="apellidoPaterno" name="apellidoPaterno">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="carpetaInves">Apellido materno</label> <input
						type="text" class="form-control text-uppercase"
						id="apellidoMaterno" name="apellidoMaterno">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="edoColaboracion">Estado</label> <select
						class="custom-select d-block w-100" id="estado" name="estado"
						onchange="cargaMunicipio()">
						<option value="">Selecciona...</option>
						<% for(CatEstado estados:estado){ %>
						<option
							value="<%=estados.getIdEstado() + "&" + estados.getCodigoEstado() %>">
							<%= estados.getEstadoDetalle()%>
						</option>
						<% } %>
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="edoColaboracion">Municipio</label> <select
						class="custom-select d-block w-100" id="municipio"
						name="municipio" onchange="cargaCp()">
						<option value="">Selecciona...</option>
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="edoColaboracion">CP</label> <select
						class="custom-select d-block w-100" id="cp" name="cp"
						onchange="cargaColonia()">
						<option value="">Selecciona...</option>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="solColaboracion">Colonia</label> <select
						class="custom-select d-block w-100" id="colonia" name="colonia">
						<option value="">Selecciona...</option>
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="numColaboracion">Calle y número</label> <input
						type="text" class="form-control text-uppercase" id="calle"
						name="calle">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="solColaboracion">Edad</label> <select
						class="custom-select d-block w-100" id="edad" name="edad">
						<option value="">Selecciona...</option>
						<% for(CatEdad edad:edades){ %>
						<option value="<%=edad.getIdEdad() %>">
							<%= edad.getEdadDetalle()%>
						</option>
						<% } %>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="solColaboracion">Sexo</label> <select
						class="custom-select d-block w-100" id="sexo" name="sexo">
						<option value="">Selecciona...</option>
						<% for(CatSexo sexo:sexos){ %>
						<option value="<%=sexo.getIdSexo()%>">
							<%= sexo.getSexoDetalle()%>
						</option>
						<% } %>
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="folioOficio">Teléfono</label> <input type="text"
						class="form-control text-uppercase" id="telefono" name="telefono">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="turno">Correo Electrónico</label> <input type="text"
						class="form-control text-uppercase" id="correo" name="correo">
				</div>
			</div>
			<br>
		</div>
		<div class="tab-pane fade" id="nav-detalle" role="tabpanel"
			aria-labelledby="nav-detalle-tab">
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="acciones">Celular de un segundo contacto</label> <input
						type="text" class="form-control text-uppercase" id="celular"
						name="celular">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="busquedaCampo">Relación con la persona
						desaparecida</label> <select class="custom-select d-block w-100"
						id="relacion" name="relacion">
						<option value="">Selecciona...</option>
						<% for(CatParentesco parentesco:parentescos){ %>
						<option value="<%=parentesco.getIdParentesco()%>">
							<%= parentesco.getParentescoDetalle()%>
						</option>
						<% } %>
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="busquedaCampo">Ocupación</label> <select
						class="custom-select d-block w-100" id="ocupacion"
						name="ocupacion">
						<option value="">Selecciona...</option>
						<% for(CatOcupacion ocupacion:ocupaciones){ %>
						<option value="<%=ocupacion.getIdOcupacion()%>">
							<%= ocupacion.getOcucpacionDetalle()%>
						</option>
						<% } %>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="busquedaCampo">Medio en que reporta</label> <select
						class="custom-select d-block w-100" id="medio" name="medio">
						<option value="">Selecciona...</option>
						<% for(CatMedioReporte medio:medios){ %>
						<option value="<%=medio.getIdMedioReporte()%>">
							<%= medio.getMedioReporteDetalle()%>
						</option>
						<% } %>
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="busquedaCampo">Nacionalidad</label> <select
						class="custom-select d-block w-100" id="nacionalidad"
						name="nacionalidad">
						<option value="">Selecciona...</option>
						<% for(CatNacionalidad nacionalidad:nacionalidades){ %>
						<option value="<%=nacionalidad.getIdNacionalidad()%>">
							<%= nacionalidad.getNacionalidadDetalle()%>
						</option>
						<% } %>
					</select>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="evidenciaColaboracion">Identificación Oficial</label> <input
						type="file" class="form-control-file" id="identificacion"
						name="identificacion"
						accept=".pdf,.doc,.docx,.png,.jpeg,.jpg,.jfif">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="busquedaCampo">Acompañaba al no localizado al
						momento de los hechos</label> <select class="custom-select d-block w-100"
						id="acompanaba" name="acompanaba">
						<option value="">Selecciona...</option>
						<% for(CatSiNo acompanaba:acompanabas){ %>
						<option value="<%=acompanaba.getIdSiNo()%>">
							<%= acompanaba.getSiNoDetalle()%>
						</option>
						<% } %>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-12">
					<div class="d-flex flex-row-reverse">
						<div class="p-3">
							<!-- <button type="submit" class="btn btn-primary" >Guardar</button> -->
							<button type="submit" class="btn btn-primary">Guardar</button>
						</div>
						<div class="p-3">
							<button type="reset" id="limpiar" class="btn btn-primary">Limpiar</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>