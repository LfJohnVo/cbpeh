<%@page import="mx.gob.cbpeh.bpd.modelo.Perfil"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatArea"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatPuesto"%>
<%@page import="java.util.List"%>

<form id="formEditarUsuario" name="formEditarUsuario" enctype="multipart/form-data">
	
	<!-- The Modal -->
	<div class="modal" id="EditarUsuarios">
	
	
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
              
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Editar usuarios</h4>
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

										<div class="form-group row">
											<div class="col-sm-4 mb-0 mb-sm-0">
												<label for="nombreE">Nombre</label> <input type="text"
													class="form-control text-uppercase" id="nombreE" name="nombreE" required="required">
											</div>
											<div class="col-sm-4 mb-0 mb-sm-0">
												<label for="aPaternoE">Apellido paterno</label> <input
													type="text" class="form-control text-uppercase"
													id="aPaternoE" name="aPaternoE" required="required">
											</div>
											<div class="col-sm-4 mb-0 mb-sm-0">
												<label for="aMaternoE">Apellido materno</label> <input
													type="text" class="form-control text-uppercase"
													id="aMaternoE" name="aMaternoE">
											</div>
										</div>

										<div class="form-group row">
											<div class="col-sm-4 mb-0 mb-sm-0">
												<label for="idUsuarioE">Usuario</label> <input type="text"
													class="form-control text-uppercase" id="idUsuarioE" name="idUsuarioE" required="required" readonly="readonly">
											</div>
											<div class="col-sm-4 mb-0 mb-sm-0">
												<label for="passwordE">Contraseña</label> 
												<input type="password" class="form-control text-uppercase"
													id="passwordE" name="passwordE" required="required">
											</div>
											<div class="col-sm-4 mb-0 mb-sm-0">
												<label for="idPerfilE">Perfil</label> <select
													class="custom-select d-block w-100" id="idPerfilE" name="idPerfilE" required="required">
													<option value="">Selecciona...</option>
													<%
														for (int a = 0; a < perfiles.size(); a++) {
													%>
													<option value="<%=perfiles.get(a).getIdPerfil()%>">
														<%=perfiles.get(a).getPerfilDetalle()%></option>

													<%
														}
													%>
												</select>
											</div>
										</div>

										<div class="form-group row">
											<div class="col-sm-4 mb-0 mb-sm-0">

												<label for="idDireccionE">Direcci&oacute;n</label> <select
													class="custom-select d-block w-100" id="idDireccionE"
													name="idDireccionE" required="required">
													<option value="">Selecciona...</option>
													<%
														for (int a = 0; a < direccion.size(); a++) {
													%>
													<option value="<%=direccion.get(a).getIdDireccion()%>">
														<%=direccion.get(a).getDireccionDetalle()%></option>

													<%
														}
													%>
												</select>
											</div>
											<div class="col-sm-4 mb-0 mb-sm-0">
												<label for="idAreaE">&Aacute;rea</label> <select
													class="custom-select d-block w-100" id="idAreaE"
													name="idAreaE"  required="required">
													<option value="">Selecciona...</option>
													<%
														for (int b = 0; b < areas.size(); b++) {
													%>
													<option value="<%=areas.get(b).getIdArea()%>">
														<%=areas.get(b).getAreaDetalle()%></option>

													<%
														}
													%>
												</select>
											</div>
											<div class="col-sm-4 mb-0 mb-sm-0">
												<label for="idPuestoE">Puesto</label> <select
													class="custom-select d-block w-100" id="idPuestoE"
													name="idPuestoE"  required="required">
													<option value="">Selecciona...</option>
													<%
														for (int c = 0; c < puestos.size(); c++) {
													%>
													<option value="<%=puestos.get(c).getIdPuesto()%>">
														<%=puestos.get(c).getPuestoDetalle()%></option>

													<%
														}
													%>

												</select>
											</div>
										</div>


										<div class="form-group row">
											<div class="col-4 mb-0 col-md-0">
												<label for="idEstatusE">Estatus</label> <select
													class="custom-select d-block w-100" id="idEstatusE" name="idEstatusE" required="required">
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

											<div class="col-sm-4 mb-0 mb-sm-0">
												<label for="correoE">Correo</label> <input type="text"
													class="form-control text-uppercase" id="correoE"
													name="correoE" required="required">
											</div>
											<div class="col-sm-4 mb-0 mb-sm-0">
												<label for="aplica2FAE">Aplicar 2FA</label>
												<div class="form-check">
													<input class="form-check-input" type="radio"
														name="aplica2FAE" id="aplica2FA1E" value="true" checked>
													<label class="form-check-label" for="aplica2FA1E">
														Si </label>
														</div>
														<div class="form-check">
														 <input class="form-check-input" type="radio"
														name="aplica2FAE" id="aplica2FA2E" value="false"> <label
														class="form-check-label" for="aplica2FA2E"> No </label>
												</div>
											</div>
										</div>
										
											<div class="form-group row">
								<div class="col-11 col-md-0">
									<div class="d-flex flex-row-reverse">
										<div class="col-2 p-4">
											<!-- <button type="submit" class="btn btn-primary" >Guardar</button> -->
											<button type="button" class="btn btn-primary fas fa-save"
												data-toggle="modal" data-target="#editarInfoUsuario">
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
						</div>

					</div>

				</div>

				

			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id=editarInfoUsuario tabindex="-1" role="dialog"
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