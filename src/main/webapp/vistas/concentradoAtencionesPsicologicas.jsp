<%@page import="java.util.List"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.Expediente"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%
	HttpSession session2 = request.getSession();
    List<Expediente> expedientes = (List<Expediente>)session2.getAttribute("expedientes");
	List<Integer> yearsLargaData = (List<Integer>)session2.getAttribute("yearsBusquedaAtencionesPsicologicas");
	%>
<script type="text/javascript"> initBusquedaAtencionesPsicologicas(); </script>
 <div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h4 class="h4 mb-0 text-gray-800">Concentrado Atenciones Psicológicas</h4>
</div>
	<div id="alertaMsj">
	</div>
  <hr style="height:2px" color="#EF4B55">                
<br>
<form name="formConcentradoAtencionesPsicologicas" method="post" id="formConcentradoAtencionesPsicologicas">
    <div class="row">
        <div class="col-lg-3 mb-3 col-md-12">
           <div class="form-group">
                <label for="estatus">Expediente</label>
                <select class="custom-select d-block w-100" id="expediente" >                          
                    <option value="">Selecciona...</option>
				<% for(Expediente expediente:expedientes){ %>
					<option value="<%=expediente.getIdExpediente() %> "><%=expediente.getIdExpediente() %></option>									
				<% } %>
                  </select>
            </div>
        </div>
        <div class="col-lg-3 mb-3 col-md-12">                         
            <label for="fecha">Fecha</label>
            <input class="form-control" type="date" id="fecha" />
        </div>
    </div>
    <div class="form-group row">
        <div class="col-12">
            <div class="d-flex flex-row-reverse">
                <div class="pl-3 pr-3">
                	<button type="button" onclick="busquedaAtencionesPsicologicas()" class="btn btn-primary">Buscar</button>
                 </div>
                <div class="pl-3 pr-3">
                    <button type="button" class="btn btn-primary" onclick="limpiarTablaBusquedaAtencionesPsicologicas()">Limpiar</button>
                </div>
                <div class="pl-3 pr-3">
                	<button id="btnExportarBusquedaAtencionesPsicologicas" type="button" onclick="exportarBusquedaAtencionesPsicologicas()" class="btn btn-primary">Exportar</button>
                 </div>
                
              </div>
        </div>
    </div>
</form>
<div class="table-responsive">
    <table class="table">
        <thead class="thead-light">
          <tr>
            <th scope="col">Expediente</th>
            <th scope="col">Nombre</th>
            <th scope="col">Parentesco</th>
            <th scope="col">Fecha</th>
            <th scope="col">Observaciones</th>
          </tr>
        </thead>
        <tbody id="bodyBusquedaAtencionesPsicologicas">
        </tbody>
    </table>
</div>
<script>
	$('.custom-select').select2({
	 theme:'bootstrap4',
	 placeholder: 'Selecciona un opción',
	 allowClear: true
	})
	
</script>
			