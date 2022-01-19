<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="mx.gob.cbpeh.bpd.modelo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=chrome">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<%
	HttpSession session2 = request.getSession();

List<Perfil> perfiles = (List<Perfil>) session2.getAttribute("perfiles");
List<CatPuesto> puestos = (List<CatPuesto>) session2.getAttribute("puestos");
List<CatArea> areas = (List<CatArea>) session2.getAttribute("areas");
List<CatEstatus> estatus = (List<CatEstatus>) session2.getAttribute("estatus");
List<Usuario> usuarios = (List<Usuario>) session2.getAttribute("adminUsuarios");
List<CatDireccion> direccion = (List<CatDireccion>) session2.getAttribute("direccion");
%>
 <script src="<%=request.getContextPath()%>/recursos/scripts/administracion.js"></script>
 <script type="text/javascript">
 initUsuarios();
</script>
<div class="form-group row">
	<div class="p-0">
		<!-- Page Heading -->
		<div class="d-sm-flex align-items-center justify-content-between mb-0">
			<h4 class="h4 mb-0 col-md-12 text-gray-800">Usuarios</h4>
		</div>
		<!-- 				Nested Row within Card Body -->

	</div>
</div>

<!-- <div class="card o-hidden border-0 shadow-lg my-3"> -->

<div class="card-body p-0">


	<hr style="height: 2px" color="#EF4B55">


	<div class="col-lg-12">

		<div class="p-2">
			<form id="formNuevoUsuario" name="formNuevoUsuario" enctype="multipart/form-data">
			<div id="alert"></div>
				<!-- Collapsable Card Example -->
				<div class="card shadow mb-4">
					<!-- Card Header - Accordion -->
					<a href="#collapseCardExample" class="d-block card-header py-3"
						data-toggle="collapse" role="button" aria-expanded="true"
						aria-controls="collapseCardExample">
						<h6 class="m-0 font-weight-bold text-primary">Registrar nuevo
							usuario</h6>
					</a>
					<!-- Card Content - Collapse -->
					<div class="collapse" id="collapseCardExample">

						<div class="card-body">
							<div class="form-group row">
								<div class="col-sm-4 mb-0 mb-sm-0">
									<label for="nombre">Nombre</label> <input type="text"
										class="form-control text-uppercase" id="nombre" name="nombre" required="required">
								</div>
								<div class="col-sm-4 mb-0 mb-sm-0">
									<label for="aPaterno">Apellido paterno</label> <input
										type="text" class="form-control text-uppercase" id="aPaterno"
										name="aPaterno" required="required">
								</div>
								<div class="col-sm-4 mb-0 mb-sm-0">
									<label for="aMaterno">Apellido materno</label> <input
										type="text" class="form-control text-uppercase" id="aMaterno"
										name="aMaterno">
								</div>
							</div>

							<div class="form-group row">
								<div class="col-sm-4 mb-0 mb-sm-0">
									<label for="idUsuario">Usuario</label> <input type="text"
										class="form-control text-uppercase" id="idUsuario"
										name="idUsuario" required="required" >
								</div>
								<div class="col-sm-4 mb-0 mb-sm-0">
									<label for="password">Contraseña</label> <input type="password"
										name="password" class="form-control text-uppercase"
										id="password" required="required">
								</div>
								<div class="col-sm-4 mb-0 mb-sm-0">
									<label for="idPerfil">Perfil</label> <select
										class="custom-select d-block w-100" id="idPerfil"
										name="idPerfil" required>
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

									<label for="idDireccion">Direcci&oacute;n</label> <select
										class="custom-select d-block w-100" id="idDireccion"
										name="idDireccion" required>
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
									<label for="idArea">&Aacute;rea</label> <select
										class="custom-select d-block w-100" id="idArea" name="idArea"
										required>
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
									<label for="idPuesto">Puesto</label> <select
										class="custom-select d-block w-100" id="idPuesto"
										name="idPuesto" required>
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
								<div class="col-sm-4 mb-0 mb-sm-0">
									<label for="correo">Correo</label> <input type="text"
										class="form-control text-uppercase" id="correo" name="correo" required="required">
								</div>
								<div class="col-sm-4 mb-0 mb-sm-0">
									<label for="aplica2FA">Aplicar 2FA</label> 
<div class="form-check">
          <input class="form-check-input" type="radio" name="aplica2FA" id="aplica2FA1" value="1" checked>
          <label class="form-check-label" for="aplica2FA2">
            Si
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="aplica2FA" id="aplica2FA2" value="0">
          <label class="form-check-label" for="aplica2FA2">
            No
          </label>
        </div>
								</div>
							</div>

							<div class="form-group row">
								<div class="col-11 col-md-0">
									<div class="d-flex flex-row-reverse">
										<div class="col-2 p-4">
											<!-- <button type="submit" class="btn btn-primary" >Guardar</button> -->
											<button type="button" class="btn btn-primary fas fa-save"
												data-toggle="modal" data-target="#guardarInfoUsuario">
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
<div class="modal fade" id="guardarInfoUsuario" tabindex="-1" role="dialog"
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
			<div class="modal-body">Por favor de confirma que desea guardar
				la información.</div>
			<div class="modal-footer">
				<button type="button" id="btnGCancelar" name="btnGCancelar" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
				<button type="submit" id="btnGguardar" name="btnGguardar" class="btn btn-primary">Confirmar</button>
			</div>
		</div>
	</div>
</div>
			</form>
			<form id="formUsuarios" name="formUsuarios" enctype="multipart/form-data">
				<!-- Basic Card Example -->
				<div class="card shadow mb-4">

					<div class="card-header py-3">

						<h6 class="m-0 font-weight-bold text-primary">Usuarios
							registrados</h6>
					</div>
					<!-- DataTales Example -->
					<div class="card shadow mb-4">

						<div class="card-body">

							<div class="table-responsive">
								<table class="table table-bordered" id="dtUsuarios" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th class="text-center">Usuario</th>
											<th class="text-center">Nombre completo</th>
											<th class="text-center">&Aacute;rea</th>
											<th class="text-center">Estatus</th>
											<th class="text-center">Editar</th>
											<th class="text-center">Eliminar</th>

										</tr>
									</thead>
									<tbody id="bodyUsuarios">
									<!-- 
										<%
										 
											for (Usuario usuario : usuarios) {
										%>
										<tr>
											<td class=""><%=usuario.getIdUsuario()%></td>
											<td class=""><%=usuario.getNombre() + " " + usuario.getApaterno() + " " + usuario.getAmaterno()%></td>
											<td class=""><%=usuario.getCatArea().getAreaDetalle()%></td>
											<td class="text-center" id="row-<%=usuario.getIdUsuario()%>">
												<%
													if (usuario.getCatEstatus().getIdEstatus().equals(1)) { %> 
													<a class="btn btn-success btn-circle"> <i class="fas fa-toggle-on"></i></a> 
													<% 	} else { %>
													<a class="btn btn-danger btn-circle"> <i class="fas fa-toggle-off"></i></a> 
 <% 	} %>
											</td>
											<td class="text-center"><a href="#"
												class="btn btn-info btn-circle" data-toggle="modal"
												data-target="#EditarUsuarios" onclick="setEditarUsuario('<%=usuario.getIdUsuario()%>','<%=usuario.getNombre()%>','<%=usuario.getApaterno()%>','<%=usuario.getAmaterno()%>','<%=usuario.getContrasenia()%>','<%=usuario.getPerfil().getIdPerfil()%>','<%=usuario.getCatDireccion().getIdDireccion()%>','<%=usuario.getCatArea().getIdArea()%>' ,'<%=usuario.getCatPuesto().getIdPuesto()%>','<%=usuario.getCatEstatus().getIdEstatus()%>','<%=usuario.getAplica2fa()%>','<%=usuario.getCorreoElectronico()%>')"> <i class="fas fa-edit"></i>
											</a></td>
											<td class="text-center"><a href="#" onclick="setEliminarUsuario('<%=usuario.getIdUsuario()%>')" data-toggle="modal" data-target="#eliminarUsuario"
												class="btn btn-danger btn-circle"> <i  
													class="fas fa-trash"></i>
											</a></td>

										</tr>
										<%
										
											}
										%>


 									-->
									</tbody>
								</table>
							</div>

						</div>
					</div>

				</div>
				
				<!-- Modal -->
<div class="modal fade" id="eliminarUsuario" tabindex="-1" role="dialog"
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
			<div class="modal-body">¿Esta seguro que desea eliminar al usuario?</div>
			<div class="modal-footer">
				<button type="button" id="btnECancelar" name="btnECancelar" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
				<button type="submit" id="btnEguardar" name="btnEguardar" class="btn btn-primary">Confirmar</button>
			</div>
		</div>
	</div>
</div>
				
			</form>
		</div>

	</div>
</div>

<!-- 	</div> -->



<%@ include file="../contenido/editarUsuario.jsp"%>
</html>