 <%@page import="mx.gob.cbpeh.bpd.modelo.CatDireccion"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatPuesto"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.Usuario"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatTipoNota"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatSiNo"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatArea"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatCompaniaTelefono"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.Expediente"%>
<%@page import="java.util.List"%>
<%
	HttpSession session2 = request.getSession();
	
	 //List<Expediente> expedientes = (List<Expediente>)session2.getAttribute("expedientes");

	List<CatArea> areas = (List<CatArea>)session2.getAttribute("areas");
	List<CatTipoNota> tipoNotas = (List<CatTipoNota>)session2.getAttribute("tipoNota");	
	List<Usuario> nombreTitular = (List<Usuario>)session2.getAttribute("nombreTitular");
	List<CatPuesto> puestoTitular = (List<CatPuesto>)session2.getAttribute("puestoTitular");
	List<CatDireccion> direccion = (List<CatDireccion>)session2.getAttribute("direccion");
	List<Expediente> expedientes = (List<Expediente>)session2.getAttribute("expedientes");
	Usuario usuario =  (Usuario) session2.getAttribute("usuarioSession");
	%>
<!DOCTYPE html>
<html>

	<script src="<%=request.getContextPath()%>/recursos/scripts/accAC.js"></script>
<form id="formAtentasNotas" name="formAtentasNotas" > 
	<div class="form-group row">
				
                               
        <div class="p-0">   
	 <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-0">
                        <h4 class="h4 mb-0 col-md-12 text-gray-800">Carga de atentas notas</h4>
                    </div>
		<!-- 				Nested Row within Card Body -->
		
		</div></div>
<!-- <div class="card o-hidden border-0 shadow-lg my-3"> -->
<div id="alert"></div>
	<div class="card-body p-0">
	
	<input id="idRemitente" name="idRemitente" type="hidden" value="<%=usuario.getIdUsuario()%>">
			
		<hr style="height: 2px" color="#EF4B55">
		<div class="row">

			<div class="col-lg-12">
				<div class="p-2">
				
				<div class="form-group row">
                            <div class="col-4 mb-0 col-md-0">
                                  <label for="remitente">Remitente</label>
										<input type="text" class="form-control text-uppercase" value="<%=usuario.getNombre()+" "+usuario.getApaterno()+" "+usuario.getAmaterno() %>"
											id="remitente" name="remitente" required readonly="readonly">
                            </div>
                        
                            <div class="col-4 mb-0 col-md-0">
                                  <label for="direccionR">Direcci&oacute;n</label>
										<input type="text" class="form-control text-uppercase" value="<%=usuario.getCatDireccion().getDireccionDetalle() %>"
											id="direccionR" name="direccionR" required readonly="readonly">
                            </div>
                        
                            <div class="col-lg-4 mb-0 col-md-0">                            
                                <label for="areaR">&Aacute;rea</label>
                                <select class="form-control custom-select d-block w-100" id="idArea" name="idArea" required readonly="readonly">                          
                                  <option>Selecciona...</option>
                                  <% for(int a=0; a<areas.size();a++){ %>
								<option value="<%=areas.get(a).getIdArea()%>">
								<%=areas.get(a).getAreaDetalle()%></option>
									
											<% } %>
                                </select>
                                <div class="invalid-feedback">
                                  Por favor selecciona opci&oacute;n.
                                </div> 
                            </div>
                            </div>
                            <div class="form-group row">
                            <div class="col-lg-4 mb-0 col-md-0">                            
                                <label for="tipoNota">Tipo de nota</label>
                                <select class="form-control custom-select d-block w-100" id="idTipoNota" name="idTipoNota" required>                          
                                  <option value="">Selecciona...</option>
                                <% for(int a=0; a<tipoNotas.size();a++){ %>
								<option value="<%=tipoNotas.get(a).getIdTipoNota()%>">
								<%=tipoNotas.get(a).getTipoNotaDetalle()%></option>
									
											<% } %>
                                </select>
                                <div class="invalid-feedback">
                                  Por favor selecciona opcion.
                                </div> 
                            </div>
                            
                             <div class="col-lg-4 mb-0 col-md-0">                            
                                <label for="folioExpediente">Expediente</label>
                                <select class="custom-select d-block w-100" id="folioExpediente" name="folioExpediente">                          
                                  <option value="">Selecciona...</option>
                                  <% for(int a=0; a<expedientes.size();a++){ %>
								<option value="<%=expedientes.get(a).getIdExpediente()%>">
								<%=expedientes.get(a).getIdExpediente()%></option>
									
											<% } %>
                                </select>
                                <div class="invalid-feedback">
                                  Por favor selecciona un expediente.
                                </div> 
                            </div>
                            </div>
                           <div class="form-group row">
									<div class="col-sm-8 mb-0 mb-sm-0">
										
											<label for="descripcionNota">Descripci&oacute;n</label>
											<textarea class="form-control text-uppercase rounded-0"
												id="descripcion" name="descripcion" rows="3"></textarea>
										
									</div>

								</div>
								
								 <div class="form-group row">
									<div class="col-sm-4 mb-0 mb-sm-0">
										
											  <label for="nombreT">Nombre titular</label>
                                <select class="form-control custom-select d-block w-100"  id="idDestinatario" name="idDestinatario" required 
                                 onchange="asignarDireccionPuesto(value)">                          
                                  <option value="">Selecciona...</option>
                                    <% for(int a=0; a<nombreTitular.size();a++){ %>
								<option  value="<%=nombreTitular.get(a).getIdUsuario()%>" >
								<%= nombreTitular.get(a).getNombre()+" "+nombreTitular.get(a).getApaterno()
							  +" "+nombreTitular.get(a).getAmaterno()%> </option>
									
											<% } %>
                                  
                                </select>
                                
                                <div class="invalid-feedback">
                                  Por favor selecciona opci&oacute;n.
                                </div>
                                </div>
                                   <div class="col-lg-4 mb-0 col-md-0"> 
                                  <label for="direccionT">Direcci&oacute;n</label>
                                <select class="form-control custom-select d-block w-100" id="direccionT" name="direccionT" required disabled="disabled">                          
                                  <option value="">Selecciona...</option>
                                   <% for(int a=0; a<direccion.size();a++){ %>
								<option value="<%=direccion.get(a).getIdDireccion()%>">
								<%= direccion.get(a).getDireccionDetalle()%> </option>
									
											<% } %> 
                                </select>
                                   
                                <div class="invalid-feedback">
                                  Por favor selecciona opci&oacute;n.
                                </div>
                                </div>
                                
                                <div class="col-lg-4 mb-0 col-md-0"> 
                                  <label for="puestoT">Puesto del titular</label>
                                <select class="form-control custom-select d-block w-100" id="puestoT" name="puestoT" required readonly="readonly" disabled="disabled">                          
                                  <option value="">Selecciona...</option>
                                      <% for(int a=0; a<puestoTitular.size();a++){ %>
								<option value="<%=puestoTitular.get(a).getIdPuesto()%>">
								<%= puestoTitular.get(a).getPuestoDetalle()%></option>
									
											<% } %> 
                                  
                                </select>
                                <div class="invalid-feedback">
                                  Por favor selecciona opci&oacute;n.
                                </div>
										
									</div>

								</div>
                        
                        <div class="form-group row">
                            <div class="col-11 col-md-0">
                                <div class="d-flex flex-row-reverse">
                                    <div class="col-2 p-0">
                                       <!-- <button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#guardarInfo">Guardar</button> -->
                                        <button type="submit" class="btn btn-primary fas fa-save" > Guardar</button>
                                    </div>
                                    <div class="col-2 p-0">
                                        <button type="reset" class="btn btn-primary far fa-window-close" > Cancelar</button>
                                    </div>
                                    
                                  </div>
                            </div>
                        </div>
                  
				
				
				</div>
			</div>
		</div>
	</div>
<!-- </div> -->

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
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
        <button type="button" class="btn btn-primary">Confirmar</button>
      </div>
    </div>
  </div>
</div>
</form>
<script type="text/javascript">
document.getElementById('idArea').value='<%=usuario.getCatArea().getIdArea()%>';
$('.custom-select').select2({
	 theme:'bootstrap4',
	 placeholder: 'Selecciona un opción',
	 allowClear: true
})
</script>

</html>