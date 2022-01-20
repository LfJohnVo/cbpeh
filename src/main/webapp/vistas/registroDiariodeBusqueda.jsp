<%@page import="mx.gob.cbpeh.bpd.modelo.CatEstatusLocalizado"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.Expediente"%>
<%@page import="java.util.List"%>

<%
	HttpSession session2 = request.getSession();
	
	List<Expediente> expedientes = (List<Expediente>)session2.getAttribute("expedientes");
	List<Integer> aniosExpedientes = (List<Integer>)session2.getAttribute("aniosExpedientes");
	List<CatEstatusLocalizado> datosEstatusLocalizado = (List<CatEstatusLocalizado>)session2.getAttribute("estatusLocalizado");
	
	%>
<script type="text/javascript"> 	initRegistroDiario(); </script>
 <div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h4 class="h4 mb-0 text-gray-800">Registro diario de búsqueda</h4>
</div>
	<div id="alertaMsj">
	</div>
  <hr style="height:2px" color="#EF4B55">                
<br>
<form name="formConsultaDiario" method="post" id="formConsultaDiario">
    <div class="row">
        <div class="col-lg-3 mb-3 col-md-12">                            
            <label for="ano">Año</label>
            <select class="custom-select d-block w-100" id="anio" >                          
              <option value="">Selecciona...</option>
				<% for(Integer anio:aniosExpedientes){ %>
					<option value="<%=anio %> "><%=anio %></option>
				<% } %>
            </select>
        </div>
        <div class="col-lg-3 mb-3 col-md-12">
            <div class="form-group">
                <label for="mes">Mes</label>
                <select class="custom-select d-block w-100" id="mes" >                          
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
            <div class="form-group">
                <label for="estatus">Estatus</label>
                <select class="custom-select d-block w-100" id="idEstatus">                          
                    <option value="">Selecciona...</option>
				<% for(CatEstatusLocalizado estatus:datosEstatusLocalizado){ %>
					<option value="<%=estatus.getIdEstatusLocalizado() %> "><%=estatus.getEstatusLocalizadoDetalle() %></option>									
				<% } %>
                </select>
            </div>
        </div>
        <div class="col-lg-3 mb-3 col-md-12">
            <div class="form-group">
                <label for="estatus">Expediente</label>
                <select class="custom-select d-block w-100" id="idExpediente" >                          
                    <option value="">Selecciona...</option>
				<% for(Expediente expediente:expedientes){ %>
					<option value="<%=expediente.getIdExpediente() %> "><%=expediente.getIdExpediente() %></option>									
				<% } %>
                  </select>
            </div>
        </div>
    </div>
    <div class="form-group row">
        <div class="col-12">
            <div class="d-flex flex-row-reverse">
                <div class="pl-3 pr-3">
                	<button type="button" onclick="buscarDiario()" class="btn btn-primary">Buscar</button>
                 </div>
                <div class="pl-3 pr-3">
                    <button type="button" class="btn btn-primary" onclick="limpiarTablaDiaria()">Limpiar</button>
                </div>
                <div class="pl-3 pr-3">
                	<button id="btnExportarRegDia" type="button" onclick="exportarRegistroDiario()" class="btn btn-primary">Exportar</button>
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
            <th scope="col">Persona desaparecida</th>
            <th scope="col">Número de Acciones</th>
            <th scope="col">Estatus</th>
          </tr>
        </thead>
        <tbody id="bodyDiario">
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
			