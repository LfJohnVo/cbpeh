<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="mx.gob.cbpeh.bpd.modelo.*"%>

<%
	HttpSession session2 = request.getSession();

	List<Comunicado> comunicados= (List<Comunicado>)session2.getAttribute("comunicados");
	List<CatTipoComunicado> tipoComunicado = (List<CatTipoComunicado>)session2.getAttribute("tipoComunicados");
	List<CatEstatus> estatus = (List<CatEstatus>)session2.getAttribute("estatus");
	
	
	%>

<html>
<script
	src="<%=request.getContextPath()%>/recursos/scripts/administracion.js"></script>
<script type="text/javascript">
 initComunicados();
</script>
<div class="form-group row">
	<div class="p-0">
		<!-- Page Heading -->
		<div class="d-sm-flex align-items-center justify-content-between mb-0">
			<h4 class="h4 mb-0 col-md-12 text-gray-800">Comunicados</h4>
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
				<form id="formComunicado" name="formComunicado"
					enctype="multipart/form-data">
					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div id="alert"></div>
						<div class="card-body">

							<div class="table-responsive">
								<table class="table table-bordered" id="tablaSlider"
									width="100%" cellspacing="0">
									<thead>
										<tr>
											<th class="text-center">Fecha carga</th>
											<th class="text-center">Titulo</th>
											<th class="text-center">Estatus</th>
											<th class="text-center">Editar</th>
											<th class="text-center">Eliminar</th>

										</tr>
									</thead>
									<tbody id="bodyComunicados">
										<!-- 
                                    <%for(Comunicado comunicado: comunicados){
                                    String btnEstatus="";
                                    
                                    btnEstatus = (comunicado.getCatEstatus().getIdEstatus().equals(1) ? "<a href='#' class='btn btn-success btn-circle'>"+
                                    "<i class='fas fa-toggle-on'></i></a>": "<a href='#' class='btn btn-danger btn-circle'> <i class='fas fa-toggle-off'></i></a>"); %>
                                        <tr>
                                            <td class="text-center"><%= comunicado.getFechaCarga() %></td>
                                            <td class=><%= comunicado.getTitulo() %></td>
                                            
                                            <td class="text-center"><%=btnEstatus %>
                                           
                                          </td>
                                            <td class="text-center"><a href="#" class="btn btn-info btn-circle"  data-toggle="modal" 
                                            onclick="setEditarComunicado('<%=comunicado.getIdComunicado()%>','<%=comunicado.getCatTipoComunicado().getIdTipoComunicado()%>','<%=comunicado.getTitulo()%>','<%=comunicado.getImagen()%>'
                                            ,'<%=comunicado.getUrl()%>','<%=comunicado.getCatEstatus().getIdEstatus()%>','<%=comunicado.getDescripcion()%>');"
                                            data-target="#EditarSlider">  <i class="fas fa-edit"></i>
                                          </a></td>
                                            <td class="text-center">  <a href="#" onclick="setEliminarComunicado('<%=comunicado.getIdComunicado()%>')" 
                                            data-toggle="modal" data-target="#eliminarComunicado" class="btn btn-danger btn-circle">
                                        <i class="fas fa-trash"></i>
                                    </a></td>
                                            
                                        </tr>
                                        <%} %> 
                                      
                                      
                                      -->
									</tbody>
								</table>
							</div>

						</div>


					</div>
					<!-- Modal -->
					<div class="modal fade" id="eliminarUsuario" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalCenterTitle"
						aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalCenterTitle">Notificaci&oacute;n</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Cerrar">
										<span aria-hidden="true">×</span>
									</button>
								</div>
								<div class="modal-body">¿Esta seguro que desea eliminar al
									usuario?</div>
								<div class="modal-footer">
									<button type="button" id="btnECancelar" name="btnECancelar"
										class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
									<button type="button" id="btnEguardar" name="btnEguardar" da
										class="btn btn-primary">Confirmar</button>
								</div>
							</div>
						</div>
					</div>

					<!-- Modal -->
					<div class="modal fade" id="eliminarComunicado" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalCenterTitle"
						aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalCenterTitle">Notificaci&oacute;n</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Cerrar">
										<span aria-hidden="true">×</span>
									</button>
								</div>
								<div class="modal-body">¿Esta seguro que desea eliminar el
									registro?</div>
								<div class="modal-footer">
									<button type="button" id="btnECancelar" name="btnECancelar"
										class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
									<button type="submit" id="btnEguardar" name="btnEguardar"
										class="btn btn-primary">Confirmar</button>
								</div>
							</div>
						</div>
					</div>
				</form>
				<form id="formNuevoComunicado" name="formNuevoComunicado"
					enctype="multipart/form-data">

					<!-- Collapsable Card Example -->
					<div class="card shadow mb-4">
						<!-- Card Header - Accordion -->
						<a href="#collapseCardExample" class="d-block card-header py-3"
							data-toggle="collapse" role="button" aria-expanded="true"
							aria-controls="collapseCardExample">
							<h6 class="m-0 font-weight-bold text-primary">Nuevo
								comunicado</h6>
						</a>
						<div id="alert"></div>
						<!-- Card Content - Collapse -->
						<div class="collapse" id="collapseCardExample">

							<div class="card-body">

								<div class="form-group row">


									<div class="col-sm-4 mb-0 mb-sm-0">
										<label for="idTipoComunicado">Tipo de comunicado</label> <select
											class="custom-select d-block w-100" id="idTipoComunicado"
											name="idTipoComunicado" required>
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

									<div class="col-lg-4 mb-0 col-md-0">
										<label for="comunicado">Imagen</label>
										<div class="custom-file">

											<input type="file" class="form-control custom-file-input"
												id="imagen" name="imagen" accept="image/png"
												required="required"> <label
												class="form-control custom-file-label" for="comunicado"
												data-browse="Adjuntar">Selecciona el archivo</label>
										</div>
									</div>
								</div>

								<div class="form-group row">
									<div class="col-sm-4 mb-0 mb-sm-0">
										<label for="titulo">Titulo</label> <input type="text"
											class="form-control text-uppercase" id="titulo" name="titulo"
											required="required">
									</div>
									<div class="col-sm-4 mb-0 mb-sm-0">
										<label for="url">URL</label> <input type="text"
											class="form-control text-uppercase" id="url" name="url">
									</div>

								</div>

								<div class="form-group row">
									<div class="col-4 mb-0 col-md-0">
										<label for="estatus">Estatus</label> <select
											class="custom-select d-block w-100" id="idEstatus"
											name="idEstatus" required>
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
									<div class="col-8 mb-3 col-md-0">
										<label for="descripción">Descripci&oacute;n</label>
										<textarea class="form-control text-uppercase" rows="6"
											id="descripcion" name="descripcion"></textarea>
									</div>
								</div>

								<div class="form-group row">
									<div class="col-11 col-md-0">
										<div class="d-flex flex-row-reverse">
											<div class="col-2 p-2">
												<!-- <button type="submit" class="btn btn-primary" >Guardar</button> -->
												<button type="button" class="btn btn-primary fas fa-save"
													data-toggle="modal" data-target="#guardarInfoComunicado">
													Guardar</button>
											</div>
											<div class="col-2 p-2">
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
					<div class="modal fade" id="guardarInfoComunicado" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalCenterTitle"
						aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalCenterTitle">Notificaci&oacute;n</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Cerrar">
										<span aria-hidden="true">×</span>
									</button>
								</div>
								<div class="modal-body">Por favor de confirma que desea
									guardar la informaci&oacute;n.</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Cancelar</button>
									<button type="submit" class="btn btn-primary">Confirmar</button>
								</div>
							</div>
						</div>
					</div>



				</form>
			</div>

		</div>
	</div>
</div>

<!-- </div> -->


<%@ include file="../contenido/editarSlider.jsp"%>
</html>