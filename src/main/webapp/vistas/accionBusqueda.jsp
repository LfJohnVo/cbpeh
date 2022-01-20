<%@page import="mx.gob.cbpeh.bpd.modelo.CatEstatus"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatMunicipio"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatEstatusLocalizado"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.Expediente"%>
<%@page import="java.util.List"%>
<%
	HttpSession session2 = request.getSession();
	
	List<Expediente> expedientes = (List<Expediente>)session2.getAttribute("expedientes");
	List<CatMunicipio> datosMunicipios = (List<CatMunicipio>)session2.getAttribute("municipios");
	List<CatEstatusLocalizado> datosEstatusLocalizado = (List<CatEstatusLocalizado>)session2.getAttribute("estatusLocalizado");
	
	%>
	<script src="<%=request.getContextPath()%>/recursos/scripts/accionBusqueda.js"></script>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h4 class="h4 mb-0 text-gray-800">Registrar acción de búsqueda</h4>
</div>
<div id="alertaMsj">
</div>
<hr style="height:2px" color="#EF4B55">
<form enctype="multipart/form-data" id="formAccionBusqueda" method="post">
	<div class="form-group row">
		<div class="col-lg-4 col-md-12">
			<label for="numExpedienteAb">Número de expediente</label> <select
				class="custom-select d-block w-100" id="numExpedienteAb" name="numExpedienteAb"required>
				<option value="">Selecciona...</option>
			<% for(Expediente expediente:expedientes){ %>
				<option value="<%=expediente.getIdExpediente()%>"><%=expediente.getIdExpediente()%></option>									
			<% } %>
			</select>
		</div>
		<div class="col-lg-4 col-md-12">
			<label for="fechaAccionAb">Fecha de acción</label> <input type="date"
				class="form-control text-uppercase" id="fechaAccionAb" name="fechaAccionAb" required onkeyup="mayusculas(this);">
		</div>
		<div class="col-lg-4 col-md-12">
			<label for="estatusAb">Estatus</label> <select
				class="custom-select d-block w-100" id="estatusAb" name="estatusAb">
				<option value="">Selecciona...</option>
			<% for(CatEstatusLocalizado estatus:datosEstatusLocalizado){ %>
				<option value="<%=estatus.getIdEstatusLocalizado() %> "><%=estatus.getEstatusLocalizadoDetalle() %></option>									
			<% } %>
			</select>
		</div>
	</div>
	<div class="form-group row">
		<!-- <div class="col-lg-4 col-md-12">
            <label for="conVida">Con vida o sin vida</label>
            <select class="custom-select d-block w-100" id="conVida">                          
                <option value="">Selecciona...</option>
                <option>CON VIDA</option>
                <option>SIN VIDA</option>
            </select>
        </div>-->
		<div class="col-lg-4 col-md-12">
			<label for="municipioAb">Municipio</label> 
			<select
				class="custom-select d-block w-100" id="municipioAb"  name="municipioAb" onchange="cargaCodigoP()">
				<option value="">Selecciona...</option>
			<% for(CatMunicipio municipio:datosMunicipios){ %>
				<option value="<%=municipio.getIdMunicipio()+"&"+municipio.getCodigoMunicipio() %>"> <%= municipio.getMunicipioDetalle()%> </option>									
			<% } %>
			</select>
		</div>
		<div class="col-lg-4 col-md-12">
			<label for="cpAb">Código postal</label>
			<select class="custom-select d-block w-100" id="cpAb" name="cpAb" onchange="cargaColonias()">
				<option value="">Selecciona...</option>
			</select>
		</div>
		<div class="col-lg-4 col-md-12">
			<label for="coloniaAb">Colonia/Localidad</label> <select
				class="custom-select d-block w-100" id="coloniaAb" name="coloniaAb">
				<option value="">Selecciona...</option>
			</select>
		</div>
	</div>
	<div class="form-group row">
		<div class="col-lg-4 col-md-12">
			<label for="calleNumeroAb">Calle y número</label> <input type="text"
				class="form-control text-uppercase" id="calleNumeroAb" name="calleNumeroAb" onkeyup="mayusculas(this);">
		</div>
		<div class="col-lg-4 col-md-12">
			<label for="latitudAb">Latitud</label> <input type="text"
				class="form-control text-uppercase" id="latitudAb" name="latitudAb" placeholder="00.00000" pattern="^$|^(-?\d{1,2}\.\d{5})$" >
		</div>
		<div class="col-lg-4 col-md-12">
			<label for="longitudAb">Longitud</label> <input type="text"
				class="form-control text-uppercase" id="longitudAb" name="longitudAb" placeholder="00.00000" pattern="^$|^(-?\d{1,2}\.\d{5})$" >
		</div>
	</div>

	<div class="form-group row">
		<div class="col-12">
			<label for="reseniaAb">Descripción de los hechos</label>
			<textarea class="form-control text-uppercase" rows="5"
				id="reseniaAb" name="reseniaAb" onkeyup="mayusculas(this);"></textarea>
		</div>
	</div>

	<div class="form-group row">
		<div class="col-lg-4 col-md-12">
			<!-- <label class="">Carga de evidencia</label>
			<div class="custom-file">
				<input type="file" class="form-control custom-file-input"
					id="evidencia" accept="image/gif,image/jpeg,image/png"> <label
					class="form-control custom-file-label" for="cargaEvidencia"
					data-browse="Adjuntar">Selecciona el archivo</label>
			</div> -->
			<div class="form-group">
                <label for="evidenciaAccionAb">Carga de evidencia</label>
                <input type="file" class="form-control-file" id="evidenciaAccionAb" name="evidenciaAccionAb" accept=".pdf,.doc,.docx,.jpg,.jpeg,.png,.jfif,.mp3,.mp4,.mpeg,.opus,.wav" data-browse="adjuntar" >
           	</div>
		</div>
		<div class="col-lg-8 col-md-12 ">
			<label for="descripcionEvidenciaAb">Descripción de la evidencia</label>
			<textarea class="form-control text-uppercase" rows="2"
				id="descripcionEvidenciaAb" name="descripcionEvidenciaAb" onkeyup="mayusculas(this);"></textarea>
		</div>
	</div>
	<div class="form-group row">
		<div class="col-6 col-md-12">
			<div class="d-flex flex-row-reverse">
				<div class="p-3">
					<!-- <button type="button" onclick="guardarAccionBusqueda()"" class="btn btn-primary">Guardar</button>  -->
					<button type=submit class="btn btn-primary" data-toggle="modal" data-target="">Guardar</button>
				</div>
				<div class="p-3">
					<button type="button" onclick="resetAccionBusqueda()" class="btn btn-primary">Limpiar</button>
				</div>
				<div class="p-3">
					<button id="btnExportarExp" type="button" class="btn btn-primary" disabled onclick="exportPdfAcciones()">Exportar</button>
				</div>

			</div>
		</div>
	</div>
</form>
<script>
$('.custom-select').select2({
	 theme:'bootstrap4',
	 placeholder: 'Selecciona un opción',
	 allowClear: true
	})
	
</script>
