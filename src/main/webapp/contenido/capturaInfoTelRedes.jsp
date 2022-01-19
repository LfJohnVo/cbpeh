<!-- <body class="bg-gradient-light"> -->
<!-- 	<div class="container"> -->
<!-- 		<div class="card o-hidden border-0 shadow-lg my-3"> -->
		<div id="alert2"></div>
			<div class="card-body p-0">
			<hr style="height:2px" color="#EF4B55">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-12">
						<div class="p-2">

<form id="formPersonaVinculada" name="formPersonaVinculada"   enctype="multipart/form-data"> 

                     <input id="idExpediente" name="idExpediente" type="hidden" value="">
								<div class="form-group row">
									<div class="col-sm-4 mb-0 mb-sm-0">
									  <label for="nombre">Nombre</label>
										<input type="text" class="form-control  text-uppercase"
											id="nombre" name="nombre">
									</div>
									<div class="col-sm-4 mb-0 mb-sm-0">
									  <label for="apellidoP">Apellido paterno</label>
										<input type="text" class="form-control  text-uppercase"
											id="apellidoP" name="apellidoP">
									</div>
									<div class="col-sm-4 mb-0 mb-sm-0">
									  <label for="apellidoMaterno">Apellido materno</label>
										<input type="text" class="form-control  text-uppercase"
											id="apellidoM" name="apellidoM">
									</div>
								</div>

								
								<div class="form-group row">
									<div class="col-sm-4 mb-0 mb-sm-0">
									  <label for="patentesco">Parentesco</label>
											<select id="parentesco" name="parentesco"  class="form-control custom-select" required="required">
  										 <option value="">Selecciona...</option>
  										   <% for(int a=0; a<parentesco.size();a++){ %>
								<option value="<%=parentesco.get(a).getIdParentesco()%>">
								<%=parentesco.get(a).getParentescoDetalle()%></option>
									
											<% } %>
										</select>
										<div class="invalid-feedback">
                                  Por favor selecciona el tipo de parentesco.
                                </div>
									</div>
									<div class="col-sm-4 mb-0 mb-sm-0">
									  <label for="telefonoFijo">Tel&eacute;fono fijo</label>
										<input type="number" class="form-control"
											id="telefonoFijo" name="telefonoFijo">
									</div>
									<div class="col-sm-4 mb-0 mb-sm-0">
									  <label for="telefonoCelular">Tel&eacute;fono celular</label>
										<input type="number" class="form-control"
											id="telefonoCelular" name="telefonoCelular">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-4 mb-0 mb-sm-0">
									  <label for="companiaTel">Compañia tel&eacute;fonica</label>
										<select id="companiaTel" name="companiaTel" class="form-control custom-select" required="required">
  										 <option value="">Selecciona...</option>
  										   <% for(int a=0; a<companiaTelefonos.size();a++){ %>
								<option value="<%=companiaTelefonos.get(a).getIdCompaniaTelefono()%>">
								<%=companiaTelefonos.get(a).getCompaniaTelefonoDetalle()%></option>
									
											<% } %>
										</select>
									</div>
									<div class="col-sm-4 mb-0 mb-sm-0">
									  <label for="correoPersonal">Correo personal</label>
										<input type="text" class="form-control text-uppercase"
											id="correoPersonal" name="correoPersonal">
									</div>
									<div class="col-sm-4 mb-0 mb-sm-0">
									  <label for="correoOpcional">Correo opcional</label>
										<input type="text" class="form-control text-uppercase"
											id="correoOpcional" name="correoOpcional">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-4 mb-0 mb-sm-0">
									  <label for="facebook">Facebook personal</label>
										<input type="text" class="form-control text-uppercase"
											id="facebook" name="facebook">
									</div>
									<div class="col-sm-4 mb-0 mb-sm-0">
									  <label for="instagram" >Instagram Personal</label>
										<input type="text" class="form-control text-uppercase"
											id="instagram" name="instagram">
									</div>
									<div class="col-sm-4 mb-0 mb-sm-0">
									  <label for="twitter">Twitter personal</label>
										<input type="text" class="form-control text-uppercase"
											id="twitter" name="twitter">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-4 mb-0 mb-sm-0">
									  <label for="administraRedes">Administra redes sociales</label>
										<select id="administraRedes" name="administraRedes" class="form-control custom-select" required="required">
  										 <option value="">Selecciona...</option>
  										   <% for(int a=0; a<siNo.size();a++){ %>
								<option value="<%=siNo.get(a).getIdSiNo()%>">
								<%=siNo.get(a).getSiNoDetalle()%></option>
									
											<% } %>
  										</select>
  										<div class="invalid-feedback">
                                  Por favor selecciona una opciones.
                                </div>
									</div>
									<div class="col-sm-4 mb-0 mb-sm-0">
									  <label for="correoEmpresarial">Correo electr&oacute;nico empresarial</label>
										<input type="text" class="form-control text-uppercase"
											id="correoEmpresarial" name="correoEmpresarial">
									</div>
									<div class="col-sm-4 mb-0 mb-sm-0">
									  <label for="telefonoEmpresarial">Tel&eacute;fono empresarial</label>
										<input type="number" class="form-control"
											id="telefonoEmpresarial" name="telefonoEmpresarial">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-4 mb-0 mb-sm-0">
									  <label for="instagramEmpresarial">Instagram empresarial</label>
										<input type="text" class="form-control text-uppercase"
											id="instagramEmpresarial" name="instagramEmpresarial">
									</div>
									<div class="col-sm-4 mb-0 mb-sm-0">
									  <label for="twitterEmpresarial">Twitter empresarial</label>
										<input type="text" class="form-control text-uppercase"
											id="twitterEmpresarial" name="twitterEmpresarial">
									</div>
									<div class="col-sm-4 mb-0 mb-sm-0">
									  <label for="facebookEmpresarial">Facebook empresarial</label>
										<input type="text" class="form-control text-uppercase"
											id="facebookEmpresarial" name="facebookEmpresarial">
									</div>
								</div>

								<div class="form-group row">

									<div class="col-sm-11 mb-0">
									<div class="d-flex flex-row-reverse">
									 <div class="col-2 p-0">
                                       <!-- <button type="submit" class="btn btn-primary"  data-target="#guardarInfo2" >Guardar</button> -->
                                        <button type="submit" id="btnGuardarInfoTelRedesAC" name="btnGuardarInfoTelRedesAC" class="btn btn-primary fas fa-save"> Guardar</button>
                                    </div>
                                    <div class="col-2 p-0">
                                        <button type="reset" class="btn btn-primary far fa-window-close"> Cancelar</button>
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
<div class="modal fade" id=guardarInfo2 tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalCenterTitle">Notificacion</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Cerrar">
          <span aria-hidden="true">×</span>
        </button>
      </div>
      <div class="modal-body">
        Por favor de confirma que desea guardar la información.
      </div>
      <div class="modal-footer">
        <button type="reset" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
        <button type="button" class="btn btn-primary">Confirmar</button>
      </div>
    </div>
  </div>
</div>
<!-- 	</div> -->
<!-- </body> -->
