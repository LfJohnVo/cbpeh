<%@page import="mx.gob.cbpeh.bpd.modelo.Expediente"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatSexo"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatEdad"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatMunicipio"%>
<%@page import="mx.gob.cbpeh.bpd.modelo.CatEstatusLocalizado"%>
<%@page import="java.util.List"%>
<%
	HttpSession session2 = request.getSession();	
	//List<Expediente> expedientes = (List<Expediente>)session2.getAttribute("expedientes");
	List<CatSexo> datosSexos = (List<CatSexo>)session2.getAttribute("sexos");
	List<CatEdad> datosEdades = (List<CatEdad>)session2.getAttribute("edades");
	List<CatMunicipio> datosMunicipiosHidalgo = (List<CatMunicipio>)session2.getAttribute("municipiosHidalgo");
	List<CatEstatusLocalizado> datosEstatusLocalizado = (List<CatEstatusLocalizado>)session2.getAttribute("estatusLocalizado");
%>
<script type="text/javascript"> 	initConcentrado(); </script>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h4 class="h4 mb-0 text-gray-800">Concentrado</h4>
</div>
	<div id="alertaMsj">
	</div>
<hr style="height:2px" color="#EF4B55">
<!-- Content Row -->
<form name="formConcentradoAt" method="post" id="formConcentradoAt">
    <div class="row">
        <div class="col-lg-3 col-md-12">                            
            <label for="expediente">Expediente</label>
            <select class="custom-select d-block w-100" id="expediente" >                          
              <option value="">Selecciona...</option>
            </select>
        </div>
        <div class="col-lg-2 col-md-12">
            <div class="form-group">
                <label for="sexo">Sexo</label>
                <select class="custom-select d-block w-100" id="sexo" >                          
                    <option value="">Selecciona...</option>
				<% for(CatSexo element:datosSexos){ %>
					<option value="<%=element.getIdSexo()%>"> <%= element.getSexoDetalle()%> </option>									
				<% } %>
                  </select>
            </div>
        </div>
        <div class="col-lg-2 col-md-12">
            <div class="form-group">
                <label for="sexo">Edad</label>
                <select class="custom-select d-block w-100" id="edad" >                          
                    <option value="">Selecciona...</option>
				<% for(CatEdad element:datosEdades){ %>
					<option value="<%=element.getIdEdad()%>"> <%= element.getEdadDetalle()%> </option>									
				<% } %>
                  </select>
            </div>
        </div>
        <div class="col-lg-3 col-md-12">
            <div class="form-group">
                <label for="municipio">Municipio</label>
                <select class="custom-select d-block w-100" id="municipio">                          
                    <option value="">Selecciona...</option>
				<% for(CatMunicipio municipio:datosMunicipiosHidalgo){ %>
					<option value="<%=municipio.getCodigoMunicipio()%>"> <%= municipio.getMunicipioDetalle()%> </option>									
				<% } %>
                </select>
            </div>
        </div>
        <div class="col-lg-2 col-md-12">
            <div class="form-group">
                <label for="estatus">Estatus</label>
                <select class="custom-select d-block w-100" id="estatusLocalizado" >                          
                    <option value="">Selecciona...</option>
				<% for(CatEstatusLocalizado estatus:datosEstatusLocalizado){ 
						if(	estatus.getIdEstatusLocalizado()!=1 ){ %>

					<option value="<%=estatus.getIdEstatusLocalizado() %> "><%=estatus.getEstatusLocalizadoDetalle() %></option>									
				<% 		}
					} %>
                  </select>
            </div>
        </div>
    </div>
    <div class="form-group row">
        <div class="col-12">
            <div class="d-flex flex-row-reverse">
                <div class="pl-3 pr-3">
                    <!-- <button type="submit" class="btn btn-primary" >Buscar</button>  -->
                    <button type="button" onclick="buscarConcentrado()" class="btn btn-primary">Buscar</button>
                </div>
                <div class="pl-3 pr-3">
                    <button type="button" class="btn btn-primary" onclick="limpiarTabla()">Limpiar</button>
                </div>
                <div class="pl-3 pr-3">
                	<button id="btnExportarConcentrado" type="button" onclick="exportarConcentrado()" class="btn btn-primary">Exportar</button>
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
            <th scope="col">Fecha de apertura</th>
            <th scope="col">Fecha de cierre</th>
            <th scope="col">Sexo</th>
            <th scope="col">Municipio</th>
            <th scope="col">Estatus</th>
          </tr>
        </thead>
        <tbody id="bodyConcentrados">
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