<%@page import="mx.gob.cbpeh.bpd.modelo.Expediente"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatEstatusLocalizado"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatMunicipio"%>
<%@page import="java.util.List"%>
<%
	HttpSession session2 = request.getSession();

List<Expediente> expedientes = (List<Expediente>) session2.getAttribute("expedientes");
List<CatEstatusLocalizado> estatusLocalizado = (List<CatEstatusLocalizado>) session2.getAttribute("estatusLocalizado");
List<CatMunicipio> datosMunicipios = (List<CatMunicipio>)session2.getAttribute("municipios");
%>
<script
	src="<%=request.getContextPath()%>/recursos/scripts/largaDataExpedientes.js"></script>
	<script
	src="<%=request.getContextPath()%>/recursos/scripts/accionBusqueda.js"></script>
<!--inicio LargaData -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h4 class="h4 mb-0 text-gray-800">Larga Data</h4>

</div>
<hr style="height: 2px" color="#EF4B55">
	<form id="formLargaData" name="formLargaData"
		enctype="multipart/form-data">
		<div id="alertExito" class="alert  alert-info alert-dismissible"
		style="display: none;" role="alert">
		<strong>Larga Data registrada con éxito</strong>

		</div>
	<div id="alertFBusqueda"
		class="alert  alert-info alert-dismissible" role="alert"
		style="display: none;">
		<strong>Selecciona una fecha de búsqueda</strong>
	</div>
	<div id="alertELocalizacion"
		class="alert  alert-info alert-dismissible" role="alert"
		style="display: none;">
		<strong>Selecciona un Estatus de Localización</strong> 
	</div>
		<nav>
			<div class="nav nav-tabs" id="nav-tab" role="tablist">
				<a class="nav-item nav-link active" id="nav-nuevo-tab"
					data-toggle="tab" role="tab"
					aria-controls="nav-nuevo" aria-selected="true"><h5
						class="h5 mb-0">Larga Data</h5>
				</a>
			</div>
		</nav>
		<br>
		<div class="tab-content" id="nav-tabContent">
			<div class="tab-pane fade show active" id="nav-nuevo" role="tabpanel"
				aria-labelledby="nav-nuevo-tab">

				<div class="form-group row">
					<div class="col-lg-4 col-md-8">
						<label for="numExpediente">Número de expediente</label> <select
							class="custom-select d-block w-100" id="numExpedienteLD"
							name="numExpedienteLD">
							<option value="">Selecciona...</option>
							<%
								for (Expediente expediente : expedientes) {
							%>
							<option value="<%=expediente.getIdExpediente()%>"><%=expediente.getIdExpediente()%></option>
							<%
								}
							%>
						</select>
					</div>
					<div class="col-2">
						<label class=""></label>
						<div class="p-1">
							<button id="adicionar" type="button" class="btn btn-primary">Agregar</button>
						</div>
					</div>
					
				</div>

				<div class="form-group row">
					<div class="col-6">
						<div class="table-responsive">
							<table id="mytable" class="table">
								<!-- table-striped-->
								<thead class="thead-light">
									<tr>
										<th scope="col">Expediente agregado</th>
										<th scope="col">Eliminar</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
				</div>

				<div class="form-group row">					
					<div class="col-lg-4 col-md-12">
						<label for="fechaLarga">Fecha de Acción</label> <input type="date"
							class="form-control text-uppercase" id="fechaLD"
							name="fechaLD">
					</div>
					<div class="col-lg-4 col-md-12">
						<label for="estatus">Estatus</label> <select
							class="custom-select d-block w-100" id="estatusLD" name="estatusLD"
							>
							<option value="">Selecciona...</option>
							<%
								for (CatEstatusLocalizado estatus : estatusLocalizado) {
							%>
							<option value="<%=estatus.getIdEstatusLocalizado()%>"><%=estatus.getEstatusLocalizadoDetalle()%></option>
							<%
								}
							%>
						</select>
					</div>
					<div class="col-lg-4 col-md-12">
						<label for="edoColaboracion">Municipio</label> <select
							class="custom-select d-block w-100" id="municipioLargaData"
							name="municipioLargaData" onchange="cargaCpLargaData()">
							<option value="">Selecciona...</option>
							<% for(CatMunicipio municipio:datosMunicipios){ %>
				<option value="<%=municipio.getIdMunicipio()+"&"+municipio.getCodigoMunicipio() %>"> <%= municipio.getMunicipioDetalle()%> </option>									
			<% } %>
						</select>
					</div>
				</div>
				<div class="form-group row">					
					<div class="col-lg-4 col-md-12">
						<label for="edoColaboracion">CP</label> <select
							class="custom-select d-block w-100" id="cpLargaData"
							name="cpLargaData" onchange="cargaColoniaLargaData()">
							<option value="">Selecciona...</option>
						</select>
					</div>
					<div class="col-lg-4 col-md-12">
						<label for="solColaboracion">Colonia/Localidad</label> <select
							class="custom-select d-block w-100" id="coloniaLargaData"
							name="coloniaLargaData">
							<option value="">Selecciona...</option>
						</select>
					</div>
					<div class="col-lg-4 col-md-12">
						<label for="numColaboracion">Calle y número</label> <input
							type="text" class="form-control text-uppercase"
							id="calleLargaData" name="calleLargaData">
					</div>
				</div>
				<div class="form-group row">					
					<div class="col-lg-4 col-md-12">
						<label for="latitud">Latitud</label> <input type="text"
							class="form-control text-uppercase" id="latitudLargaData"
							name="latitudLargaData" placeholder="00.00000"
							pattern="^$|^(-?\d{1,2}\.\d{5})$">
					</div>
					<div class="col-lg-4 col-md-8">
						<label for="longitud">Longitud</label> <input type="text"
							class="form-control text-uppercase" id="longitudLargaData"
							name="longitudLargaData" placeholder="00.00000"
							pattern="^$|^(-?\d{1,2}\.\d{5})$">
					</div>
				</div>
				<div class="form-group row">					
					<div class="col-12 mb-3">
						<label for="observaciones">Detalles de los Hechos</label>
						<textarea class="form-control text-uppercase" rows="4"
							id="observacionesLargaData" name="observacionesLargaData"
							></textarea>
					</div>
				</div>
				<div class="form-group row"></div>
			</div>
			
		</div>
		<nav>
			<div class="nav nav-tabs" id="nav-tab" role="tablist">
				<a class="nav-item nav-link active"
					id="nav-detalle-tab" data-toggle="tab"
					role="tab" aria-controls="nav-detalle" aria-selected="true"><h5
						class="h5 mb-0">Cargar Evidencia</h5>
				</a>
			</div>
		</nav>
		<div class="tab-content" id="nav-tabContent">
			<div class="tab-pane fade show active" id="nav-detalle" role="tabpanel"
				aria-labelledby="nav-detalle-tab">
				<br>

				<div class="form-group row">

					<div class="col-lg-6 mb-3 col-md-8">					
						<div class="form-group">
							<label for="evidencia">Selecciona un archivo</label> <input type="file" class="form-control-file"
								id="evidenciaLargaData" name="evidenciaLargaData"
								accept=".pdf,.doc,.docx,.png,.jpeg,.jpg,.jfif" data-browse="adjuntar"
								>
						</div>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-12 mb-3">
						<label for="descripción">Descripción de la evidencia</label>
						<textarea class="form-control text-uppercase" rows="5"
							id="descripcionLargaData" name="descripcionLargaData" ></textarea>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-12">
						<div class="d-flex flex-row-reverse">
							<div class="p-3">
								<!-- <button type="submit" class="btn btn-primary" >Guardar</button> -->
								<button type="submit" id="guardarLargaData"
									class="btn btn-primary">Guardar</button>
							</div>
							<div class="p-3">
								<button type="button" onclick="resetLargaData()" id= "limpiarLD" class="btn btn-primary">Limpiar</button>
							</div>
							<div class="p-3">
								<button id="btnExportarLd" type="button" class="btn btn-primary" disabled onclick="exportPdfLargaData()">Exportar</button>
							</div>
						</div>
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
