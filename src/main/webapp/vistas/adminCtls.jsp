<%@page import="mx.gob.cbpeh.bpd.modelo.CatCatalogosDB"%>
<%@page import="java.util.List"%>
<%@ page import="mx.gob.cbpeh.bpd.modelo.*"%>
<%
HttpSession session2 = request.getSession();
List<CatCatalogosDB> catCatalogos = (List<CatCatalogosDB>) session2.getAttribute("catCatalogos");
List<CatEstatus> estatus = (List<CatEstatus>)session2.getAttribute("estatus");
%>

<!DOCTYPE html>
<html>
	<div id="alertaMsj"></div>
<div class="form-group row">
	<div class="p-0">
		<!-- Page Heading -->
		<div class="d-sm-flex align-items-center justify-content-between mb-0">
			<h4 class="h4 mb-0 col-md-12 text-gray-800">Catalogos</h4>
		</div>
		<!-- 				Nested Row within Card Body -->

	</div>
</div>

<!-- <div class="card o-hidden border-0 shadow-lg my-3"> -->

<div class="card-body p-0">


	<hr style="height: 2px" color="#EF4B55">
	<div class="row">
		<div class="col-lg-12">
			<div class="p-2">
			<form>
			<div id="alert"></div>
				<div class="form-group row">
					<div class="col-md-6">
						<label for="idCatalogo">Catalogos</label> <select
							class="form-control custom-select d-block w-100" id="idCatalogo"
							required>
							<option value="">Selecciona...</option>
							<%
							for (CatCatalogosDB catalogosDB : catCatalogos) {
							%>
							<option value="<%=catalogosDB.getIdCatalogo()%>">
								<%=catalogosDB.getDescripcionCatalogo()%></option>
							<%
							}
							%>
						</select>
						<div class="invalid-feedback">Por favor selecciona
							opci&oacute;n.</div>
					</div>
					<div class="col-xs-12 col-md-6">
						<div class="d-flex flex-row-reverse pt-4">
							<div class="pl-3 pr-3 pt-2">
								<button type="button" onclick="consultarCatalogo()"
									class="btn btn-primary">Selecciona</button>
							</div>
							<div class="pl-3 pr-3 pt-2">
								<button type="reset" class="btn btn-primary">Cancela</button>
							</div>
						</div>
					</div>					
				</div>
				</form>
				<form id="formNuevoElemCatalogo" name="formNuevoElemCatalogo" >
				<!-- Collapsable Card Example -->
				<div class="card shadow mb-4">
					<!-- Card Header - Accordion -->
					<a href="#collapseCardExample" class="d-block card-header py-3"
						data-toggle="collapse" role="button" aria-expanded="true"
						aria-controls="collapseCardExample">
						<h6 class="m-0 font-weight-bold text-primary">Agregar
							registro catalogo</h6>
					</a>
					<!-- Card Content - Collapse -->
					<div class="collapse" id="collapseCardExample">

						<div class="card-body">
							<div class="form-group row">
								<div class="col-sm-4 mb-0 mb-sm-0">
									<label for="descripcionC">Descripcion</label> <input
										type="text" class="form-control text-uppercase"
										id="detalleCat" required>
								</div>
								<div class="col-sm-4 mb-0 mb-sm-0">
									<label for="estatusC">Estatus</label> 
									<select class="custom-select d-block w-100" id="estatusCat"
									name="estatusCat" required>
									<option value="">Selecciona...</option>
									<%
									for (int a = 0; a < estatus.size(); a++) {
									%>
									<option value="<%=estatus.get(a).getIdEstatus()%>">
										<%=estatus.get(a).getEstatusDetalle()%></option>

									<%
									}
									%>

								</select>
								</div>
							</div>

							<div class="form-group row">
								<div class="col-11 col-md-0">
									<div class="d-flex flex-row-reverse">
										<div class="col-2 p-4">
											<!-- <button type="submit" class="btn btn-primary" >Guardar</button> -->
											<button type="button" class="btn btn-primary fas fa-save"
												data-toggle="modal" data-target="#guardarInfo">
												Guardar</button>
										</div>
										<div class="col-2 p-4">
											<button type="reset"
												class="btn btn-primary far fa-window-close">
												Cancelar</button>
										</div>

									</div>
								</div>
							</div>

						</div>

					</div>
				</div>
				<!-- Modal -->
				<div class="modal fade" id=guardarInfo tabindex="-1" role="dialog"
					aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalCenterTitle">Notificacion</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Cerrar">
									<span aria-hidden="true">×</span>
								</button>
							</div>
							<div class="modal-body">Por favor de confirma que desea guardar
								la información.</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
								<button type="button" onclick="guardarElemCatalogo()" class="btn btn-primary">Confirmar</button>
							</div>
						</div>
					</div>
				</div>
			</form>

				<!-- Page Heading -->
				<!--                     <h1 class="h3 mb-2 text-gray-800">Tables</h1> -->

				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Elementos del
							catalogo</h6>
					</div>
					<div class="card-body">

						<div class="table-responsive">
							<table class="table table-bordered" id="tablaCatalogos"
								width="100%" cellspacing="0">
								<thead>
									<tr>
										<th class="text-center">#</th>
										<th class="text-center">Descripcion</th>
										<th class="text-center">Estatus</th>
										<th class="text-center">Editar</th>
										<th class="text-center">Eliminar</th>

									</tr>
								</thead>
								<tbody id="bodyCatalogos">
									<!-- 
									<tr>
										<td class="">Atencion ciudadana</td>
										<td class="text-center"><a href="#"
											class="btn btn-info btn-circle" data-toggle="modal"
											data-target="#EditarCtls"> <i class="fas fa-edit"></i>
										</a></td>
										<td class="text-center"><a href="#"
											class="btn btn-danger btn-circle"> <i
												class="fas fa-trash"></i>
										</a></td>
									</tr>
								 -->
								</tbody>
							</table>
						</div>

					</div>
				</div>
				<div class="modal fade" id="eliminarElemCatalogo" tabindex="-1" role="dialog"
					aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalCenterTitle">Notificaci&oacute;n</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Cerrar">
									<span aria-hidden="true">×</span>
								</button>
							</div>
							<div class="modal-body">¿Esta seguro que desea eliminar elemento seleccionado?</div>
							<div class="modal-footer">
								<button type="button" id="btnECancelar" name="btnECancelar" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
								<button type="button" onclick="eliminarElemCatalogo()" class="btn btn-primary">Confirmar</button>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>

<!-- </div> -->
<%@ include file="../contenido/editarCtls.jsp"%>
</html>