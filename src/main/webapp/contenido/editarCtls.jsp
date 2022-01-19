<form id="formEditarElemCatalogo" name="formEditarElemCatalogo" >
	<!-- The Modal -->
	<div class="modal" id="EditarCtls">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
	
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Editar catalogo</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
	
				<!-- Modal body -->
				<div class="modal-body">
	
					<div class="card o-hidden border-0 shadow-lg my-3">
	
						<div class="col-lg-12">
	
							<div class="p-2">
								<div class="row">
	
									<div class="card-body">
										<div class="form-group row">
											<div class="col-sm-6 mb-0 mb-sm-0">
												<input type="hidden" id="idCatalogo" name="idCatalogo" value="0"/>
												<input type="hidden" id="idElemCatalogo" name="idElemCatalogo" value="0"/>
												<label for="descripcionCtl">Descripcion</label> <input
													type="text" class="form-control text-uppercase"
													id="descripcionCtl">
											</div>
	
											<div class="col-6 mb-0 col-md-0">
												<label for="estatusCtl">Estatus</label> <select
													class="custom-select d-block w-100" id="estatusCtl"
													name="estatusCtl" required>
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
	
									</div>
	
	
								</div>
							</div>
						</div>
	
					</div>
	
				</div>
	
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#editarElemCatalogo">Guardar</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
				</div>
	
			</div>
		</div>
	</div>
	
		<!-- Modal -->
		<div class="modal fade" id="editarElemCatalogo" tabindex="-1" role="dialog"
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
				<div class="modal-body">Confirmar que desea actualizar la
					informaci&oacute;n del registro.</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cancelar</button>
					<button type="button" onclick="postEditarElemCatalogo()" class="btn btn-primary">Confirmar</button>
				</div>
			</div>
		</div>
	</div>
</form>