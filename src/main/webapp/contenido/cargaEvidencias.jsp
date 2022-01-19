 <%@page import="mx.gob.cbpeh.bpd.modelo.CatTipoNota"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatSiNo"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatArea"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatCompaniaTelefono"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.Expediente"%>
<%@page import="java.util.List"%>
<% HttpSession session2 = request.getSession();
	
	List<Expediente> expedientes = (List<Expediente>)session2.getAttribute("expedientes");
	
	%>
	<script src="<%=request.getContextPath()%>/recursos/scripts/accAC.js"></script>
	<div class="form-group row">
				
                               
     <div class="p-0">   
	 <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-0">
                        <h4 class="h4 mb-0 col-md-12 text-gray-800">Carga de evidencias</h4>
                    </div>
		<!-- 				Nested Row within Card Body -->
		
		</div></div>
<!-- <div class="card o-hidden border-0 shadow-lg my-3"> -->
<form id="formCargaEvidencias" name="formCargaEvidencias" enctype="multipart/form-data"> 
<div id="alertaMsj"></div>
	<div class="card-body p-0">
	
	
			
		<hr style="height: 2px" color="#EF4B55">
		<div class="row">

			<div class="col-lg-12">
				<div class="p-2">
					<div class="form-group row">
						<div class="col-lg-6 mb-3 col-md-12">
							<label for="folioExpediente">Expediente</label> 
							<select
								class="custom-select d-block w-100" id="folioExpediente" name="folioExpediente" required>
								<option value="">Selecciona...</option>
							<% for(Expediente expediente:expedientes){ %>
								<option value="<%=expediente.getIdExpediente() %> "><%=expediente.getIdExpediente() %></option>									
							<% } %>
							</select>
						</div>
						<div class="col-lg-6 mb-3 col-md-12">
							<div class="form-group">
				                <label for="evidenciaEviAt">Evidencia</label>
				                <input type="file" class="form-control-file" id="cargaEvidencia" name="cargaEvidencia" accept=".pdf,.doc,.docx,.jpg,.jpeg,.png,.jfif,.mp3,.mp4,.mpeg,.opus,.wav,.pptx" data-browse="adjuntar" required>
				           	</div>
						</div>
					</div>                       
                       <div class="form-group row">
                            <div class="col-8 mb-3 col-md-0">
                                <label for="descripción">Descripci&oacute;n de la evidencia</label>
                                <textarea class="form-control text-uppercase" rows="6" id="descripcionEvidencia" name="descripcionEvidencia" ></textarea>
                            </div>
                       </div>
                        
                        <div class="form-group row">
                            <div class="col-11 col-md-0">
                                <div class="d-flex flex-row-reverse">
                                    <div class="col-2 p-0">
                                       <!-- <button type="submit" class="btn btn-primary" >Guardar</button> -->
                                        <button type="submit" class="btn btn-primary fas fa-save"> Guardar</button>
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
