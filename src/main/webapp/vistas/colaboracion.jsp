<%@page import="java.util.List"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatEstado"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatSiNo"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatInstitucion"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatEstatusColaboracion"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatLugarBusqueda"%>
<%
HttpSession session2 = request.getSession();

List<CatInstitucion> instituciones = (List<CatInstitucion>) session2.getAttribute("instituciones");
List<CatEstatusColaboracion> estatusColaboracion = (List<CatEstatusColaboracion>) session2
		.getAttribute("estatusColaboracion");
List<CatLugarBusqueda> lugaresBusqueda = (List<CatLugarBusqueda>) session2.getAttribute("lugaresBusqueda");
%>
<script
	src="<%=request.getContextPath()%>/recursos/scripts/colaboracion.js"></script>
<div id="alertaMsj"></div>
<nav>
	<ul class="nav nav-tabs" id="nav-tab" role="tablist">
		<li class="nav-item" id="nav-nuevo-tab"><a
			class="nav-link active" data-toggle="tab" role="tab"
			aria-controls="nav-nuevo" aria-selected="true" data-toggle="tab"
			href="#nav-nuevo">
				<h5 class="h5 mb-0">Registrar nueva colaboración</h5>
		</a></li>
		<li class="nav-item"><a class="nav-link" data-toggle="tab"
			href="#tabs-2" role="tab">Consulta colaboración</a></li>
	</ul>
</nav>
<hr style="height: 2px" color="#EF4B55">
<div class="tab-content" id="nav-tabContent">
	<div class="tab-pane fade show active" id="nav-nuevo" role="tabpanel"
		aria-labelledby="nav-nuevo-tab">
		<form enctype="multipart/form-data" id="formColaboracion"
			method="post">
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="numColaboracion">Número de oficio de petición</label> <input
						type="text" class="form-control text-uppercase" id="numPeticion"
						name="numPeticion" onchange="changeInputCol(this.value)">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="fechaApertura">Fecha de petición</label> <input
						type="date" class="form-control text-uppercase" id="fechaPeticion"
						name="fechaPeticion">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="solColaboracion">Solicitud de colaboración de</label> <select
						class="custom-select d-block w-100" id="solColaboracion"
						name="solColaboracion" required>
						<option value="">Selecciona...</option>
						<%
						for (CatInstitucion institucion : instituciones) {
						%>
						<option value="<%=institucion.getIdInstitucion()%>">
							<%=institucion.getAbreviaturaInstitucion()%>
						</option>
						<%
						}
						%>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-12">
					<label for="nombreFirma">Firmado por</label> <input type="text"
						class="form-control text-uppercase" id="nombreFirma"
						name="nombreFirma">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="nombres">Nombres del desaparecido</label> <input
						type="text" class="form-control text-uppercase" id="nombres"
						name="nombres" required>
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="aPaterno">Apellido paterno</label> <input type="text"
						class="form-control text-uppercase" id="aPaterno" name="aPaterno">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="aMaterno">Apellido materno</label> <input type="text"
						class="form-control text-uppercase" id="aMaterno" name="aMaterno">
				</div>
			</div>

			<nav>
				<div class="nav nav-tabs" id="nav-tab" role="tablist">
					<a class="nav-item nav-link active" id="nav-detalle-tab"
						data-toggle="tab" role="tab" aria-controls="nav-detalle"
						aria-selected="true">
						<h5 class="h5 mb-0">Detalle de colaboración</h5>
					</a>
				</div>
			</nav>

			<div class="tab-content" id="nav-tabContent">
				<div class="tab-pane fade show active" id="nav-detalle"
					role="tabpanel" aria-labelledby="nav-detalle-tab">
					<div class="form-group row">
						<div class="col-lg-4 col-md-12">
							<label for="estatusColaboracion">Estatus de colaboración</label>
							<select class="custom-select d-block w-100"
								id="estatusColaboracion" name="estatusColaboracion" required>
								<option value="">Selecciona...</option>
								<%
								for (CatEstatusColaboracion estatus : estatusColaboracion) {
								%>
								<option value="<%=estatus.getIdEstatusColaboracion()%>">
									<%=estatus.getEstatusColaboracionDetalle()%>
								</option>
								<%
								}
								%>
							</select>
						</div>
						<div class="col-4">
							<label class="">Acciones de búsqueda</label> <select
								class="custom-select d-block w-100" id="accionesBusqueda">
								<option value="">Selecciona...</option>
								<%
								for (CatLugarBusqueda lugar : lugaresBusqueda) {
								%>
								<option
									value="<%=lugar.getIdLugarBusqueda()%>&<%=lugar.getLugarBusquedaDetalle()%>">
									<%=lugar.getLugarBusquedaDetalle()%>
								</option>
								<%
								}
								%>
							</select>
						</div>
						<div class="col-4">
							<label class=""></label>
							<div class="p-1">
								<button id="adicionar" type="button" class="btn btn-primary">Agregar</button>
							</div>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12">
							<div class="table-responsive">
								<table id="mytable" class="table">
									<!-- table-striped-->
									<thead class="thead-light">
										<tr>
											<th scope="col">Accion de búsqueda</th>
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
						<div class="col-12">
							<div class="d-flex flex-row-reverse">
								<div class="p-3">
									<!-- <button type="submit" class="btn btn-primary" >Guardar</button> -->
									<button type="submit" class="btn btn-primary">Guardar</button>
								</div>
								<div class="p-3">
									<button type="button" onclick="resetColaboracion()"
										class="btn btn-primary">Limpiar</button>
								</div>
								<div class="p-3">
									<button id="btnExportarColaboracion" type="button"
										class="btn btn-primary" disabled
										onclick="exportPdfColaboracion()">Exportar</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</form>
	</div>
	<div class="tab-pane" id="tabs-2" role="tabpanel">
		<form enctype="multipart/form-data" id="formColaboracionBuscar"
			method="post">
			<div class="form-group row">
				<div class="col-lg-4 col-md-12">
					<label for="numColaboracion">Número de oficio de petición</label> <input
						type="text" class="form-control text-uppercase" id="numPeticion"
						name="numPeticion" onchange="changeInputCol(this.value)">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="fechaApertura">Fecha de petición</label> <input
						type="date" class="form-control text-uppercase" id="fechaPeticion"
						name="fechaPeticion">
				</div>
				<div class="col-lg-4 col-md-12">
					<label for="solColaboracion">Solicitud de colaboración de</label> <select
						class="custom-select d-block w-100" id="solColaboracion"
						name="solColaboracion" required>
						<option value="">Selecciona...</option>
						<%
						for (CatInstitucion institucion : instituciones) {
						%>
						<option value="<%=institucion.getIdInstitucion()%>">
							<%=institucion.getAbreviaturaInstitucion()%>
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
						<div class="p-3">
							<!-- <button type="submit" class="btn btn-primary" >Guardar</button> -->
							<button type="submit" class="btn btn-primary">Guardar</button>
						</div>
						<div class="p-3">
							<button type="button" onclick="resetColaboracionBuscar()"
								class="btn btn-primary">Limpiar</button>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>

</div>

<script>
	$('.custom-select').select2({
		theme : 'bootstrap4',
		placeholder : 'Selecciona un opción',
		allowClear : true
	})
</script>