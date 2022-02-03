<%@page import="mx.gob.cbpeh.bpd.modelo.Expediente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%
    HttpSession session2 = request.getSession();
    List<Expediente> expedientes = (List<Expediente>)session2.getAttribute("expedientes");
%>
<script src="<%=request.getContextPath()%>/recursos/scripts/atencionPsicologica.js"></script>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h4 class="h4 mb-0 text-gray-800">Registrar Atención Psicológica</h4>
</div>
<div id="alertaMsj">
</div>
<hr style="height:2px" color="#EF4B55">
<form enctype="multipart/form-data" id="formAtencionPsicologica" method="post">
	<div class="form-group row">
        <div class="col-lg-4 col-md-12 mb-2">
            <label for="numExpedienteAb">Número de expediente</label> <select
                class="custom-select d-block w-100" id="numExpedienteAb" name="numExpedienteAb"required>
                <option value="">Selecciona...</option>
            <% for(Expediente expediente:expedientes){ %>
                <option value="<%=expediente.getIdExpediente()%>"><%=expediente.getIdExpediente()%></option>									
            <% } %>
            </select>
		</div>
		<div class="col-lg-4 col-md-12 mb-2">
			<label for="nombre">Nombre</label> <input type="text"
				class="form-control text-uppercase" id="nombre" name="nombre" onkeyup="mayusculas(this);">
		</div>
		<div class="col-lg-4 col-md-12 mb-2">
			<label for="parentesco">Parentesco</label> <input type="text"
				class="form-control text-uppercase" id="parentesco" name="parentesco" onkeyup="mayusculas(this);">
		</div>
		<div class="col-lg-4 col-md-12 mb-2">
			<label for="fecha">Fecha</label> <input type="date"
				class="form-control text-uppercase" id="fecha" name="fecha">
		</div>
        <div class="col-12">
            <label for="fecha">Observaciones</label>
            <textarea id="observaciones" class="form-control"></textarea>
        </div>
	</div>
	<div class="form-group row">
		<div class="col-6 col-md-12">
			<div class="d-flex flex-row-reverse">
				<div class="p-3">
					<!-- <button type="button" onclick="guardarAccionBusqueda()"" class="btn btn-primary">Guardar</button>  -->
					<button type=submit class="btn btn-primary" data-toggle="modal" data-target="">Guardar</button>
				</div>
				<div class="p-3">
					<button type="button" onclick="resetAtencionPsicologica()" class="btn btn-primary">Limpiar</button>
				</div>
			</div>
		</div>
	</div>
</form>
<script>
$('.custom-select').select2({
	 theme:'bootstrap4',
	 placeholder: 'Selecciona un opción',
	 allowClear: true
	})
	
</script>
