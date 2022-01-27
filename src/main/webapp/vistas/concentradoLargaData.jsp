<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%
	HttpSession session2 = request.getSession();
	List<Integer> yearsLargaData = (List<Integer>)session2.getAttribute("yearsBusquedaLargaData");
	%>
<script type="text/javascript"> initBusquedaLargaData(); </script>
 <div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h4 class="h4 mb-0 text-gray-800">Larga Data Consulta</h4>
</div>
	<div id="alertaMsj">
	</div>
  <hr style="height:2px" color="#EF4B55">                
<br>
<form name="formConcentradoLargaData" method="post" id="formConcentradoLargaData">
    <div class="row">
        <div class="col-lg-3 mb-3 col-md-12">
            <div class="form-group">
                <label for="mesBusquedaLD">Mes</label>
                <select class="custom-select d-block w-100" id="mesBusquedaLD" >                          
                    <option value="">Selecciona...</option>
                    <option value="01">ENERO</option>
                    <option value="02">FEBRERO</option>
                    <option value="03">MARZO</option>
                    <option value="04">ABRIL</option>
                    <option value="05">MAYO</option>
                    <option value="06">JUNIO</option>
                    <option value="07">JULIO</option>
                    <option value="08">AGOSTO</option>
                    <option value="09">SEPTIEMBRE</option>
                    <option value="10">OCTUBRE</option>
                    <option value="11">NOVIEMBRE</option>
                    <option value="12">DICIEMBRE</option>
                </select>
            </div>
        </div>
        <div class="col-lg-3 mb-3 col-md-12">                         
            <label for="yearBusquedaLD">Año</label>
            <select class="custom-select d-block w-100" id="yearBusquedaLD">
                <option value="">Selecciona...</option>
                <% for(int year:yearsLargaData){ %>
                    <option value="<%=year%>"> <%=year%> </option>									
                <% } %>
            </select>
        </div>
    </div>
    <div class="form-group row">
        <div class="col-12">
            <div class="d-flex flex-row-reverse">
                <div class="pl-3 pr-3">
                	<button type="button" onclick="busquedaLargaData()" class="btn btn-primary">Buscar</button>
                 </div>
                <div class="pl-3 pr-3">
                    <button type="button" class="btn btn-primary" onclick="limpiarTablaBusquedaLargaData()">Limpiar</button>
                </div>
                <div class="pl-3 pr-3">
                	<button id="btnExportarBusquedaLargaData" type="button" onclick="exportarBusquedaLargaData()" class="btn btn-primary">Exportar</button>
                 </div>
                
              </div>
        </div>
    </div>
</form>
<div class="table-responsive">
    <table class="table">
        <thead class="thead-light">
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Fecha de Búsqueda</th>
            <th scope="col">Estatus</th>
            <th scope="col">Municipio</th>
            <th scope="col">CP.</th>
            <th scope="col">Colonia</th>
            <th scope="col">Calle</th>
            <th scope="col">Latitud</th>
            <th scope="col">Longitud</th>
          </tr>
        </thead>
        <tbody id="bodyBusquedaLargaData">
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
			