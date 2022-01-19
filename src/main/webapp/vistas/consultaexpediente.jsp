<!--Info  -->
<form id="formEstatusDesaparecido" name="formEstatusDesaparecido" >
	<div id="alertaMsj"></div>
	<div class="form-group row">
    	<div class="col-lg-4 col-md-12">
        	<label for="numExpediente">Folio Expediente</label>
            <input type="text" class="form-control text-uppercase" name="folioExpediente" id="folioExpediente">
        </div>
        <div class="col-lg-4 col-md-12">
        	<label for="curp">CURP</label>
            <input type="text" class="form-control text-uppercase" name="curp" id="curp">
        </div>
        <div class="col-lg-4 col-md-12">
        	<label for="nombres">Nombre</label>
            <input type="text" class="form-control text-uppercase" name="nombre" id="nombre">
        </div>
        <div class="col-lg-4 col-md-12">
        	<label for="apaterno">Apellido Paterno</label>
            <input type="text" class="form-control text-uppercase" name="apaterno" id="apaterno">
        </div>
        <div class="col-lg-4 col-md-12">
        	<label for="amaterno">Apellido Materno</label>
            <input type="text" class="form-control text-uppercase" name="amaterno" id="amaterno">
        </div>
	</div>
    <br>
                                    
    <div class="form-group row">
    	<div class="col-6 col-md-12">
        	<div class="d-flex flex-row-reverse">
            	<div class="p-3">
                	<button type="submit" class="btn btn-primary" >Buscar</button> 
                    <!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Guardar</button>-->
                </div>
                <div class="p-3">
                	<button type="reset" class="btn btn-primary" >Cancelar</button>
                </div>
                    
            </div>
        </div>
    </div> 

</form>
<div class="table-responsive">
	<table id="tPersonaDesaparecida" name="tPersonaDesaparecida" class="table"><!-- table-striped-->
    	<thead class="thead-light">
        	<tr>
            	<th scope="col">Folio expediente</th>
            	<th scope="col">Nombre completo</th>
            	<th scope="col">Fecha desaparici&oacute;n</th>
            	<th scope="col">Estatus</th>
          	</tr>
        </thead>
        <tbody>
        
        </tbody>
    </table>
</div>
<!-- Info-->