<%@page import="mx.gob.cbpeh.bpd.modelo.Expediente"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatDireccion"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatTipoNota"%>
<%@page import="java.util.List"%>
<%
	HttpSession session2 = request.getSession();	
	List<CatTipoNota> tipoNotas = (List<CatTipoNota>)session2.getAttribute("tipoNota");	
	List<Expediente> expedientes = (List<Expediente>)session2.getAttribute("expedientes");
	
	%>

<!DOCTYPE html>
<html>
<script src="<%=request.getContextPath()%>/recursos/scripts/accAC.js"></script>
	<div class="form-group row">
				
                               
     <div class="p-0">   
	 <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-0">
                        <h4 class="h4 mb-0 col-md-12 text-gray-800">Consultas de atentas notas</h4>
                    </div>
		<!-- 				Nested Row within Card Body -->
		
		</div></div>
<!--      <div class="card o-hidden border-0 shadow-lg my-3"> -->

<form id="formConsultaAN" name="formConsultaAN" >
<div id="alert"></div>
	<div class="card-body p-0">
	
		
		<hr style="height: 2px" color="#EF4B55">
		<div class="row">

			<div class="col-lg-12">
				<div class="p-2">
				
				<div class="form-group row">
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
                        <div class="col-sm-4 mb-0 mb-sm-0">
									<label for="folioAtentasNotas">Folio de atentas notas</label>
										<input type="text" class="form-control text-uppercase"
											id="folioAtentasNotas" name="folioAtentasNotas">
									</div>
									
									<div class="col-lg-4 mb-0 col-md-0">                            
                                <label for="tipoNota">Tipo de nota</label>
                                <select class="custom-select d-block w-100" id="tipoNota" name="tipoNota">                          
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
                            
                            </div>
                        	                       	
                           
                            <div class="form-group row">
                            
                            <div class="col-4 mb-0 col-md-0">
                                  <label for="fechaInicio">Fecha de inicio</label>
                                <input type="date" class="form-control text-uppercase" id="fechaInicio" name="fechaInicio">
                            </div>
                            <div class="col-4 mb-0 col-md-0">
                                  <label for="fechaFin">Fecha de fin</label>
                                <input type="date" class="form-control text-uppercase" id="fechaFin" name="fechaFin">
                                </div>
                            
                            
                            
                            
                            
                            </div>   
                             <div class="form-group row">
                            <div class="col-11 col-md-0">
                                <div class="d-flex flex-row-reverse">
                                    <div class="col-2 p-2">
                                       <!-- <button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#guardarInfo">Guardar</button> -->
                                        <button type="submit" class="btn btn-primary fas fa-save" > Buscar</button>
                                    </div>
                                    <div class="col-2 p-2">
                                        <button type="reset" class="btn btn-primary far fa-window-close" > Cancelar</button>
                                    </div>
                                    
                                  </div>
                            </div>
                        </div>     
                            
                            <div class="form-group row">
                            <div class="col-11 mb-0 col-md-0">
                            
                             <div class="table-responsive">
                                <table class="table table-bordered" id="tablaAtentasNotas" width="100%" cellspacing="0">
                                     <thead class="thead-light">
                                        <tr>
                                            <th scope="col">Atenta nota</th>
                                            <th scope="col">Folio expediente</th>
                                            <th scope="col">Fecha creaci&oacute;n</th>
                                            <th scope="col">Ver</th>
                                           
                                        </tr>
                                    </thead>
<!--                                     <tfoot> -->
<!--                                         <tr> -->
<!--                                            <th>Folio expediente</th> -->
<!--                                             <th>Fecha</th> -->
<!--                                             <th>Nombre</th> -->
<!--                                         </tr> -->
<!--                                     </tfoot> -->
                                    <tbody>
                                        
                                    </tbody>
                                </table>
                            </div>
                              </div>
                              </div>           
				
				
				</div>
			</div>
		</div>
		
	</div>
</form>
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
<script>
$('.custom-select').select2({
	 theme:'bootstrap4',
	 placeholder: 'Selecciona un opción',
	 allowClear: true
})
</script>
</html>