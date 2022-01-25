<%@page import="mx.gob.cbpeh.bpd.modelo.Colaboracion"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatInstitucion"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatEstatusColaboracion"%>
<%@page import="java.util.List"%>
<%-- 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %> --%>
<%
	HttpSession session2 = request.getSession();
	List<Colaboracion> colaboraciones = (List<Colaboracion>)session2.getAttribute("colaboraciones");
	List<CatInstitucion> instituciones = (List<CatInstitucion>)session2.getAttribute("instituciones");
	List<CatEstatusColaboracion> estatusColaboracion = (List<CatEstatusColaboracion>)session2.getAttribute("estatusColaboracion");
	
	%>
<script type="text/javascript"> initColaboraciones(); </script>
 <div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h4 class="h4 mb-0 text-gray-800">Registro diario de búsqueda</h4>
</div>
	<div id="alertaMsj">
	</div>
  <hr style="height:2px" color="#EF4B55">                
<br>
<form name="formConcentradoColaboraciones" method="post" id="formConcentradoColaboraciones">
    <div class="row">
        <div class="col-lg-3 mb-3 col-md-12">                            
            <label for="idExpedienteColaboracion">Número de expediente</label>
            <select class="custom-select d-block w-100" id="idExpedienteColaboracion" >                          
              <option value="">Selecciona...</option>
				<% for(Colaboracion colaboracion:colaboraciones){ %>
					<option value="<%=colaboracion.getIdExpedienteColaboracion() %> "><%=colaboracion.getIdExpedienteColaboracion() %></option>
				<% } %>
            </select>
        </div>
        <div class="col-lg-3 mb-3 col-md-12">                            
            <label for="fechaPeticion">Fecha Petición</label>
            <input type="date" class="form-control" id="fechaPeticion" />
        </div>
        <div class="col-lg-3 mb-3 col-md-12">                            
            <label for="idInstitucion">Institución</label>
            <select class="custom-select d-block w-100" id="idInstitucion" >                          
              <option value="">Selecciona...</option>
				<% for(CatInstitucion institucion:instituciones){ %>
					<option value="<%=institucion.getIdInstitucion() %> "><%=institucion.getInstitucionDetalle() %></option>
				<% } %>
            </select>
        </div>
        <div class="col-lg-3 mb-3 col-md-12">                            
            <label for="idEstatusColaboracion">Estatus</label>
            <select class="custom-select d-block w-100" id="idEstatusColaboracion" >                          
              <option value="">Selecciona...</option>
				<% for(CatEstatusColaboracion estatus:estatusColaboracion){ %>
					<option value="<%=estatus.getIdEstatusColaboracion() %> "><%=estatus.getEstatusColaboracionDetalle() %></option>
				<% } %>
            </select>
        </div>
    </div>
    <div class="form-group row">
        <div class="col-12">
            <div class="d-flex flex-row-reverse">
                <div class="pl-3 pr-3">
                	<button type="button" onclick="buscarColaboraciones()" class="btn btn-primary">Buscar</button>
                 </div>
                <div class="pl-3 pr-3">
                    <button type="button" class="btn btn-primary" onclick="limpiarTablaColaboraciones()">Limpiar</button>
                </div>
                <div class="pl-3 pr-3">
                	<button id="btnExportarColaboraciones" type="button" onclick="exportarColaboraciones()" class="btn btn-primary">Exportar</button>
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
            <th scope="col">Número de Oficio</th>
            <th scope="col">Institución</th>
            <th scope="col">Firmado Por</th>
            <th scope="col">Persona Desaparecida</th>
            <th scope="col">Estatus</th>
          </tr>
        </thead>
        <tbody id="bodyColaboraciones">
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
			