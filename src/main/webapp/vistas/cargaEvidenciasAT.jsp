<%@page import="mx.gob.cbpeh.bpd.modelo.Expediente"%>
<%@page import="java.util.List"%>
<%
	HttpSession session2 = request.getSession();	
	List<Expediente> expedientes = (List<Expediente>)session2.getAttribute("expedientes");	
%>
<script src="<%=request.getContextPath()%>/recursos/scripts/atencionCiudadana.js"></script>

<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h4 class="h4 mb-0 text-gray-800">Carga de evidencias</h4>
</div>
<div id="alertaMsj">
</div>
<hr style="height: 2px" color="#EF4B55">
<!-- Content Row -->

<form enctype="multipart/form-data" id="formCargaEvidenciaAt" method="post">
	<div class="form-group row">
		<div class="col-lg-6 mb-3 col-md-12">
			<label for="expedienteEviAt">Expediente</label> 
			<select
				class="custom-select d-block w-100" id="expedienteEviAt" name="expedienteEviAt" required>
				<option value="">Selecciona...</option>
			<% for(Expediente expediente:expedientes){ %>
				<option value="<%=expediente.getIdExpediente() %> "><%=expediente.getIdExpediente() %></option>									
			<% } %>
			</select>
		</div>
		<div class="col-lg-6 mb-3 col-md-12">
			<div class="form-group">
                <label for="evidenciaEviAt">Evidencia</label>
                <input type="file" class="form-control-file" id="evidenciaEviAt" name="evidenciaEviAt" accept=".pdf,.doc,.docx,.jpg,.jpeg,.png,.jfif,.mp3,.mp4,.mpeg,.opus,.wav,.pptx" data-browse="adjuntar" required>
           	</div>
		</div>
	</div>
	<div class="form-group row">
		<div class="col-12 mb-3">
			<label for="descripcionEviAt">Descripcion de la evidencia</label>
			<textarea class="form-control text-uppercase" rows="8"
				id="descripcionEviAt" name="descripcionEviAt" onkeyup="mayusculas(this);"></textarea>
		</div>
	</div>
	<div class="form-group row">
		<div class="col-12">
			<div class="d-flex flex-row-reverse">
				<div class="p-3">
					<button type="submit" class="btn btn-primary" data-toggle="modal"
						data-target="">Guardar</button>
				</div>
				<div class="p-3">
					<button type="reset" class="btn btn-primary">Limpiar</button>
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
document.querySelector('[type="reset"]').addEventListener('click',()=>{
	$('.custom-select').val('').trigger('change'); // Se resetea también select2
})

</script>
