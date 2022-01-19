<form id="formEditarComunicado" name="formEditarComunicado" enctype="multipart/form-data">
	
	<!-- The Modal -->
	<div class="modal" id="EditarSlider">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Editar comunicado</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
              <div id="alert2"></div>
				<!-- Modal body -->
				<div class="modal-body">
				
					<div class="card o-hidden border-0 shadow-lg my-3">

						<div class="col-lg-12">

							<div class="p-2">

								<div class="row">

									<div class="card-body">
									
									<input type="hidden" id="idComunicado" name="idComunicado" value="0"/>

										<div class="form-group row">


											<div class="col-sm-6 mb-0 mb-sm-0">
												<label for="idTipoComunicadoE">Tipo de comunicado</label> <select
													class="custom-select d-block w-100" id="idTipoComunicadoE"
													name="idTipoComunicadoE" required="required">
													<option value="">Selecciona...</option>
													<%
														for (int a = 0; a < tipoComunicado.size(); a++) {
													%>
													<option
														value="<%=tipoComunicado.get(a).getIdTipoComunicado()%>">
														<%=tipoComunicado.get(a).getTipoComunicadoDetalle()%></option>

													<%
														}
													%>

												</select>
											</div>

											<div class="col-lg-6 mb-0 col-md-0">
												<label for="imagenE">Imagen</label>
												<div class="custom-file">

													<input type="file" class="form-control custom-file-input"
														id="imagenE" name="imagenE" required="required"
														accept="image/png"> <label
														class="form-control custom-file-label"
														for="imagenE" data-browse="Adjuntar">Selecciona
														el archivo</label>
												</div>
											</div>
										</div>

										<div class="form-group row">
											<div class="col-sm-6 mb-0 mb-sm-0">
												<label for="tituloE">Titulo</label> <input type="text"
													class="form-control text-uppercase" id="tituloE"
													name="tituloE" required="required">
											</div>
											<div class="col-sm-6 mb-0 mb-sm-0">
												<label for="urlE">URL</label> <input type="text"
													class="form-control text-uppercase" id="urlE" name="urlE">
											</div>

										</div>

										<div class="form-group row">
											<div class="col-6 mb-0 col-md-0">
												<label for="idEstatusE">Estatus</label> <select
													class="custom-select d-block w-100" id="idEstatusE"
													name="idEstatusE" required>
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
											<div class="col-12 mb-0 col-md-0">
												<label for="descripcionE">Descripci&oacute;n</label>
												<textarea class="form-control text-uppercase" rows="5"
													id="descripcionE" name="descripcionE" required="required"></textarea>
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
						data-target="#editarInfoComunicado">Guardar</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
				</div>

			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="editarInfoComunicado" tabindex="-1" role="dialog"
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
					<button type="submit" class="btn btn-primary">Confirmar</button>
				</div>
			</div>
		</div>
	</div>
</form>