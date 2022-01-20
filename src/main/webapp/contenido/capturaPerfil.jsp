
<!-- 		<div class="card o-hidden border-0 shadow-lg my-3"> -->
		<div id="alertaMsj"></div>
			<div class="card-body p-0">
<!-- 				Nested Row within Card Body -->
		<hr style="height:2px" color="#EF4B55">
				<div class="row">

					<div class="col-lg-12">
						<div class="p-2">

							<form id="formPerfilAC" name="formPerfilAC"  enctype="multipart/form-data"> 

								<div class="form-group row">
									<div class="col-sm-4 mb-0 mb-sm-0">
									  <label for="bFolioExpediente">Expediente CBPEH</label>
						  				<select class="custom-select d-block w-100" id="folioExpediente" name="folioExpediente" required>
											<option value="">Selecciona...</option>
										<% for(Expediente expediente:expedientes){ %>
											<option value="<%=expediente.getIdExpediente() %> "><%=expediente.getIdExpediente() %></option>									
										<% } %>
										</select>
									</div>
									<div class="col-sm-6 mb-0 mb-sm-0 d-flex flex-column-reverse" >
									<div class="">

                             <button type="button" onclick="buscarExpPersonaDesaparecida()" class="btn btn-primary">Buscar</button>

									
										 <!-- <input type="button" value="Limpiar"	class="btn btn-primary" id="limpiar">  -->
									</div>
									</div>
								</div>
								<input id="idExpediente" name="idExpediente" type="hidden" value="">
								<div class="form-group row">
									<div class="col-sm-4 mb-0 mb-sm-0">
									<label for="nombreD">Nombre</label>
										<input type="text" class="form-control text-uppercase"
											id="nombreD" readonly="readonly">
									</div>
									<div class="col-sm-4 mb-0 mb-sm-0">
									<label for="apellidoPaternoD">Apellido paterno</label>
										<input type="text" class="form-control text-uppercase"
											id="apellidoPaternoD" readonly="readonly" >
									</div>
									<div class="col-sm-4 mb-0 mb-sm-0">
									<label for="apellidoMaternoD">Apellido materno</label>
										<input type="text" class="form-control text-uppercase"
											id="apellidoMaternoD" readonly="readonly">
									</div>
								</div>

								<div class="form-group row">
									<div class="col-sm-4 mb-0 mb-sm-0">
										<div class="form-group">
							                <label for="cargaEvidencia">Evidencia</label>
							                <input type="file" class="form-control-file" id="cargaEvidencia" name="cargaEvidencia" accept=".pdf,.doc,.docx,.jpg,.jpeg,.png,.jfif,.mp3,.mp4,.mpeg,.opus,.wav,.pptx" data-browse="adjuntar" required>
							           	</div>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-8 mb-0 mb-sm-0">
										
											<label for="descripcionEvidencia">Descripci&oacute;n
												del reporte</label>
											<textarea class="form-control text-uppercase rounded-0"
												id="descripcionEvidencia" name="descripcionEvidencia" rows="4"></textarea>
										
									</div>

								</div>

								<div class="form-group row">

									<div class="col-sm-11 mb-0 mb-sm-0">
									  <div class="d-flex flex-row-reverse">
									 <div class="col-2 p-0">
                                       <!-- <button type="submit" class="btn btn-primary" >Guardar</button> -->
                                        <button type="submit" id="btnGuardarPerfilAC" name="btnGuardarPerfilAC" class="btn btn-primary fas fa-save">Guardar</button>
                                    </div>
                                    <div class="col-2 p-0">
                                        <button type="reset" class="btn btn-primary far fa-window-close" > Cancelar</button>
                                    </div>
                                   
                                    </div>
									</div>
								</div>
							</form>

						</div>
					</div>
				</div>
			</div>
<!-- 		</div> -->
		
		<!-- Modal -->
<div class="modal fade" id=guardarInfo tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalCenterTitle">Notificaci&oacute;n</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Cerrar">
          <span aria-hidden="true">×</span>
        </button>
      </div>
      <div class="modal-body">
        Por favor de confirma que desea guardar la informaci&oacute;n.
      </div>
      <div class="modal-footer">
        <button type="reset" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
        <button type="button" class="btn btn-primary">Confirmar</button>
      </div>
    </div>
  </div>
</div>
<script>
	$('.custom-select').select2({
	 theme:'bootstrap4',
	 placeholder: 'Selecciona un expediente',
	})
	
</script>
<!-- 	</div> -->
<!-- 	</body> -->