$(document).ready(function() {
	
	$("#mAdminUsuarios").click(function() {
	
		$("#container-fluid").load(pathGlobal+"/vistas/adminUsuarios.jsp");
	});

	$("#mAdminCtls").click(function() {
		$("#container-fluid").load(pathGlobal+"/vistas/adminCtls.jsp");
	});
		
	$("#mAdminSliders").click(function() {
		$("#container-fluid").load(pathGlobal+"/vistas/adminSliders.jsp");
	});
	$("#mAdminEscanearQR").click(function() {
		$("#container-fluid").load(pathGlobal+"/vistas/codigoqr.jsp");
	});
	
});

var idUsuarioEditar = 0;
var idComunicadoEditar = 0;
var indexTU = 0;
var idComunicadoEditar = 0;
var idElementoEliminar = 0;

function setEditarComunicado(idComunicado,idTipoComunicado,tituloC,imagenC,urlC,idEstatus,descripcionC)

{
 document.getElementById('idComunicado').value = idComunicado;
 document.getElementById('idTipoComunicadoE').value = idTipoComunicado;
 document.getElementById('tituloE').value = tituloC; 
 document.getElementById('urlE').value = urlC;
 document.getElementById('idEstatusE').value = idEstatus;
 document.getElementById('descripcionE').value = descripcionC;
 //document.getElementById('imagenE').value = imagenC;

}

function setEditarUsuario(idUsuario,nombreU,aPaterno,aMaterno,password,idPerfil,idDireccion,idArea,idPuesto,idEstatus,aplica2fa,eMail)

{
 document.getElementById('idUsuarioE').value = idUsuario;
 document.getElementById('nombreE').value = nombreU;
 document.getElementById('aPaternoE').value = aPaterno;
 document.getElementById('aMaternoE').value = aMaterno;
 document.getElementById('passwordE').value = password;
 document.getElementById('idPerfilE').value = idPerfil;
 document.getElementById('idDireccionE').value = idDireccion;
 document.getElementById('idAreaE').value = idArea;
 document.getElementById('idPuestoE').value = idPuesto;
 document.getElementById('idEstatusE').value = idEstatus;
 document.getElementById('correoE').value = eMail;

 
 if(aplica2fa === 'true') { 
 
    document.getElementById('aplica2FA1E').checked = true;  
  //document.getElementById('aplica2FA2E').checked = false;
  }
 else{
 
    //document.getElementById('aplica2FA1E').checked = false; 
    document.getElementById('aplica2FA2E').checked = true;
}
}
  $(function() {
  
  //Funciones para administracion de usuarios
     $('#formNuevoUsuario').on('submit', guardarUsuario); 
     $('#formEditarUsuario').on('submit', editarUsuario);         
     $('#formUsuarios').on('submit', eliminarUsuario);
               
  //Funciones para administracion de catalogos   
  
   $('#formNuevoComunicado').on('submit', guardarComunicado); 
   $('#formEditarComunicado').on('submit', editarComunicado);  
   $('#formComunicado').on('submit', eliminarComunicado);          
             
  });
    

     //Para guardar usuario

        function guardarUsuario(event) {
         
            event.stopPropagation();
            event.preventDefault();
            var form = document.getElementById('formNuevoUsuario');
            var data = new FormData(form);
            postGuardarUsuario(data,form);
            
}

    //Para nuevo comunicado

        function guardarComunicado(event) {
        
            event.stopPropagation();
            event.preventDefault();
            var form = document.getElementById('formNuevoComunicado');
            var data = new FormData(form);
            postGuardarComunicado(data,form);
            
}
   //Para editar usuario

        function editarUsuario(event) {
        
            event.stopPropagation();
            event.preventDefault();
            var form = document.getElementById('formEditarUsuario');
            var data = new FormData(form);
            postEditarUsuario(data,form);
            
}
//Para editar comunicado

        function editarComunicado(event) {
        
            event.stopPropagation();
            event.preventDefault();
            var form = document.getElementById('formEditarComunicado');
            var data = new FormData(form);
            postEditarComunicado(data,form);
            
}

 //Para eliminar usuario

        function eliminarUsuario(event) {
         $('#eliminarUsuario').modal('hide');
            event.stopPropagation();
            event.preventDefault();
            var form = document.getElementById('formUsuarios');
            var data = new FormData(form);
            postEliminarUsuario(idUsuarioEditar,form);
            
}

        function eliminarComunicado(event) {
         $('#eliminarComunicado').modal('hide');
            event.stopPropagation();
            event.preventDefault();
            var form = document.getElementById('formComunicado');
            var data = new FormData(form);
            postEliminarComunicado(idComunicadoEditar,form);
            
}

function postGuardarUsuario(data,form) {

            $.ajax({
                url :  'admin/acciones/guardar-usuario',
                type : 'POST',
                data : data,
                cache : false,
                dataType : 'json',
                processData : false,
                contentType : false,
                success : function(data, textStatus, jqXHR) {
                $("#guardarInfoUsuario").modal('hide');  
                    if(data.estatus === 1)    {   
                    initUsuarios();
                    var usuarioDB = data.usuario;
                    var estatus = data.usuario.catEstatus.idEstatus;
              	showAlert({message: data.descripcion, class:"success"});
              	document.getElementById("formNuevoUsuario").reset();       
              
           } else if(data.estatus <= 0)    {
           showAlert({message: data.descripcion, class:"danger"});
           } 
           
           else   showAlert({message: data.descripcion, class:"warning"});
             
                },
                error : function(jqXHR, textStatus, errorThrown) {
                    console.log('ERRORS: ' + textStatus);
                     showAlert({message: 'Se genero un error al intentar guardar la información.', class:"danger"});
                }
            });
        }
        
        function postGuardarComunicado(data,form) {
        
         $("#guardarInfoComunicado").modal('hide');
            $.ajax({
                url :  'admin/acciones/guardar-comunicado',
                type : 'POST',
                data : data,
               cache : false,
                dataType : 'json',
                processData : false,
                contentType : false,
                success : function(data, textStatus, jqXHR) {
                    if(data.estatus === 1)    {   
                    initComunicados();
                    document.getElementById("formNuevoComunicado").reset();
                       
              showAlert({message: data.descripcion, class:"success"}); 
            
             // $(form).get(0).reset(); 
              
           } else if(data.estatus <= 0)    {
           showAlert({message: data.descripcion, class:"danger"});
           } 
           
           else   showAlert({message: data.descripcion, class:"warning"});
             
                },
                error : function(jqXHR, textStatus, errorThrown) {
                    console.log('ERRORS: ' + textStatus);
                     showAlert({message: 'Se genero un error al intentar guardar la información.', class:"danger"});
                }
            });
        }
        
        function postEditarUsuario(data,form) {
        
            $("#editarInfoUsuario").modal('hide');
           // $("#EditarUsuarios").modal('hide');
                    
            $.ajax({
                url :  'admin/acciones/editar-usuario',
                type : 'POST',
                data : data,
                cache : false,
                dataType : 'json',
                processData : false,
                contentType : false,
                success : function(data, textStatus, jqXHR) {
                    if(data.estatus === 1)    {
                    initUsuarios();
                    document.getElementById("formEditarUsuario").reset();
                    $('#EditarUsuarios').modal('hide');
           			showAlert({message: data.descripcion, class:"success"});           
           
           //window.location.href = 'admin/';          
              
           } else if(data.estatus <= 0)    {
           
           showAlert2({message: data.descripcion, class:"danger"});
           
           } 
           
           else   showAlert2({message: data.descripcion, class:"warning"});
             
                },
                error : function(jqXHR, textStatus, errorThrown) {
                    console.log('ERRORS: ' + textStatus);
                     showAler2({message: 'Se genero un error al intentar guardar la información.', class:"danger"});
                }
            });
            
          
        }
        
        function postEditarComunicado(data,form) {
        
         $("#editarInfoComunicado").modal('hide');
        //  $("#EditarSlider").modal('hide');
        
            $.ajax({
                url :  'admin/acciones/editar-comunicado',
                type : 'POST',
                data : data,
                cache : false,
                dataType : 'json',
                processData : false,
                contentType : false,
                 success : function(data, textStatus, jqXHR) {
                    if(data.estatus === 1)    {   
                    $('#EditarSlider').modal('hide');
                    showAlert2({message: data.descripcion, class:"success"}); 
            		initComunicados();
           
              
           } else if(data.estatus <= 0)    {
           showAlert2({message: data.descripcion, class:"danger"});
           } 
           
           else   showAlert2({message: data.descripcion, class:"warning"});
             
                },
                error : function(jqXHR, textStatus, errorThrown) {
                    console.log('ERRORS: ' + textStatus);
                     showAlert2({message: 'Se genero un error al intentar guardar la información.', class:"danger"});
                }
            });
        }
                
       function postEliminarUsuario(data,form) {
           
            $.ajax({
                url :  'admin/acciones/eliminar-usuario',
                type : 'GET',
                data : 'idUsuario='+data,
                cache : false,
                dataType : 'json',
                processData : false,
                contentType : false,
                success : function(data, textStatus, jqXHR) {
                    if(data.estatus === 1)    {   
                    initUsuarios();
                      
              		showAlert({message: data.descripcion, class:"success"}); 
           //document.getElementById("dtUsuarios").deleteRow(0); 
           
           //$('#row-'+data).html('<a class="btn btn-danger btn-circle"> <i class="fas fa-toggle-off"></i></a>');           
              
           } else if(data.estatus <= 0)    {
           showAlert({message: data.descripcion, class:"danger"});
           } 
           
           else   showAlert({message: data.descripcion, class:"warning"});
             
                },
                error : function(jqXHR, textStatus, errorThrown) {
                    console.log('ERRORS: ' + textStatus);
                     showAlert({message: 'Se genero un error al intentar guardar la información.', class:"danger"});
                }
            });
        }
        
        //Eliminar comunicado
        
        function postEliminarComunicado(data,form) {
           
            $.ajax({
                url :  'admin/acciones/eliminar-comunicado',
                type : 'GET',
                data : 'idComunicado='+data,
                cache : false,
                dataType : 'json',
                processData : false,
                success : function(data, textStatus, jqXHR) {
                    if(data.estatus === 1)    {
                    $('#eliminarComunicado').modal('hide');
                    showAlert({message: data.descripcion, class:"success"});
            		initComunicados();
                      
              
           //document.getElementById("dtUsuarios").deleteRow(0); 
           
           $('#row-'+data).html('<a class="btn btn-danger btn-circle"> <i class="fas fa-toggle-off"></i></a>');           
              
           } else if(data.estatus <= 0)    {
           showAlert({message: data.descripcion, class:"danger"});
           } 
           
           else   showAlert({message: data.descripcion, class:"warning"});
             
                },
                error : function(jqXHR, textStatus, errorThrown) {
                    console.log('ERRORS: ' + textStatus);
                     showAlert({message: 'Se genero un error al intentar guardar la información.', class:"danger"});
                }
            });
        }
       
       function setEliminarUsuario(idUsuario){
        
       idUsuarioEditar = idUsuario;
       }
       
       function setEliminarComunicado(idComunicado){
        
       idComunicadoEditar = idComunicado;
       }

function initComunicados(){
	refrescarComunicados();
}


function refrescarComunicados(){
	$('#bodyComunicados').html("");
	$.ajax({
	 	url: "admin/acciones/refrescar-comunicado",
		type: 'GET',
		success: function(respuesta) {
			let bodyTabla = $("#bodyComunicados");
			$('#bodyComunicados').html("");
			if(respuesta.estatus===1){
				$.each(respuesta.elemento, function(index, elemento) {
					let btnEstatus=(elemento.catEstatus.idEstatus === 1? '<a href="#" class="btn btn-success btn-circle"><i class="fas fa-toggle-on"></i></a>' : '<a href="#" class="btn btn-danger btn-circle"> <i class="fas fa-toggle-off"></i></a>'  );
					bodyTabla.append(' <tr><td class="text-center">' + milisegundosToFecha(elemento.fechaCarga) + '</td><td>' + elemento.titulo + '</td><td>' + btnEstatus + '</td><td class="text-center">' +  '<a href="#" class="btn btn-info btn-circle"  data-toggle="modal" onclick="setEditarComunicado('+elemento.idComunicado+','+elemento.catTipoComunicado.idTipoComunicado+',`'+elemento.titulo+'`,`'+elemento.imagen+'`,`'+elemento.url+'`,'+elemento.catEstatus.idEstatus+',`'+elemento.descripcion+'`);" data-target="#EditarSlider">  <i class="fas fa-edit"></i>' + '</td><td class="text-center">' + '<a href="#" onclick="setEliminarComunicado('+elemento.idComunicado+')" data-toggle="modal" data-target="#eliminarComunicado" class="btn btn-danger btn-circle"> <i class="fas fa-trash"></i>'+ '</td></tr>');
				});
			}else if(respuesta.estatus===-3){
				monstrarAlerta({message: respuesta.descripcion, class:"info"});
			}
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});	
}

function refrescarElemCatalogo(){
	$('#bodyCatalogos').html("");
	$.ajax({
		url: "admin/acciones/buscarCatalogo?"+data,
		type: 'GET',
		success: function(respuesta) {
			let bodyTabla = $("#bodyComunicados");
			$('#bodyComunicados').html("");
			if(respuesta.estatus===1){
				$.each(respuesta.elemento, function(index, elemento) {
					let btnEstatus=(elemento.catEstatus.idEstatus === 1? '<a href="#" class="btn btn-success btn-circle"><i class="fas fa-toggle-on"></i></a>' : '<a href="#" class="btn btn-danger btn-circle"> <i class="fas fa-toggle-off"></i></a>'  );
					bodyTabla.append(' <tr><td class="text-center">' + milisegundosToFecha(elemento.fechaCarga) + '</td><td>' + elemento.titulo + '</td><td>' + btnEstatus + '</td><td class="text-center">' +  '<a href="#" class="btn btn-info btn-circle"  data-toggle="modal" onclick="setEditarComunicado('+elemento.idComunicado+','+elemento.catTipoComunicado.idTipoComunicado+',`'+elemento.titulo+'`,`'+elemento.imagen+'`,`'+elemento.url+'`,'+elemento.catEstatus.idEstatus+',`'+elemento.descripcion+'`);" data-target="#EditarSlider">  <i class="fas fa-edit"></i>' + '</td><td class="text-center">' + '<a href="#" onclick="setEliminarComunicado('+elemento.idComunicado+')" data-toggle="modal" data-target="#eliminarComunicado" class="btn btn-danger btn-circle"> <i class="fas fa-trash"></i>'+ '</td></tr>');
				});
			}else if(respuesta.estatus===-3){
				monstrarAlerta({message: respuesta.descripcion, class:"info"});
			}
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});	
}
function initUsuarios(){
	refrescarUsuarios();
}
function refrescarUsuarios(){
	$('#bodyUsuarios').html("");
	$.ajax({
	 	url: "admin/acciones/refrescar-usuario",
		type: 'GET',
		success: function(respuesta) {
			let bodyTabla = $("#bodyUsuarios");
			$('#bodyUsuarios').html("");
			if(respuesta.estatus===1){
				$.each(respuesta.elemento, function(index, elemento) {
					let btnEstatus=(elemento.catEstatus.idEstatus === 1? '<a class="btn btn-success btn-circle"> <i class="fas fa-toggle-on"></i></a>' : '<a class="btn btn-danger btn-circle"> <i class="fas fa-toggle-off"></i></a>'  );
					bodyTabla.append(' <tr><td class="text-center">' +elemento.idUsuario+ '</td><td>' +elemento.nombre+' '+elemento.apaterno+' '+elemento.amaterno+'</td><td>'+elemento.catArea.areaDetalle+'</td><td>' + btnEstatus + '</td><td class="text-center">' +  '<a href="#" class="btn btn-info btn-circle"  data-toggle="modal" onclick="setEditarUsuario(`'+elemento.idUsuario+'`,`'+elemento.nombre+'`,`'+elemento.apaterno+'`,`'+elemento.amaterno+'`,`'+elemento.contrasenia+'`,'+elemento.perfil.idPerfil+','+elemento.catDireccion.idDireccion+','+elemento.catArea.idArea+','+elemento.catPuesto.idPuesto+','+elemento.catEstatus.idEstatus+','+elemento.aplica2fa+',`'+elemento.correoElectronico+'`);" data-target="#EditarUsuarios">  <i class="fas fa-edit"></i>' + '</td><td class="text-center">' + '<a href="#" onclick="setEliminarUsuario(`'+elemento.idUsuario+'`)" data-toggle="modal" data-target="#eliminarUsuario" class="btn btn-danger btn-circle"> <i class="fas fa-trash"></i>'+ '</td></tr>');
				});
			}else if(respuesta.estatus===-3){
				monstrarAlerta({message: respuesta.descripcion, class:"info"});
			}
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});	
}

function consultarCatalogo(){
	let idCatalogo = document.getElementById("idCatalogo").value;
	let data ='idCatalogo='+idCatalogo;
	$.ajax({
		url: "admin/acciones/buscarCatalogo?"+data,
		type: 'GET',
		success: function(respuesta) {
			let bodyTabla = $("#bodyCatalogos");
			$('#bodyCatalogos').html("");
			if(respuesta.estatus===1){
				$.each(respuesta.elemento, function(index, elemento) {
					let btnEstatus=(elemento.estatus === 1? '<a class="btn btn-success btn-circle"> <i class="fas fa-toggle-on"></i></a>' : '<a class="btn btn-danger btn-circle"> <i class="fas fa-toggle-off"></i></a>'  );
					bodyTabla.append(' <tr><td class="text-center">' +(index +1)+ '</td><td>' +elemento.detalle+'</td><td>' + btnEstatus + '</td><td class="text-center">' +  '<a href="#" class="btn btn-info btn-circle"  data-toggle="modal" onclick="editarElemCatalogo('+idCatalogo+','+elemento.idCatalogo+',`'+elemento.detalle+'`,'+elemento.estatus+');" data-target="#EditarCtls">  <i class="fas fa-edit"></i>' + '</td><td class="text-center">' + '<a href="#" onclick="eliminarElem('+elemento.idCatalogo+')" data-toggle="modal" data-target="#eliminarElemCatalogo" class="btn btn-danger btn-circle"> <i class="fas fa-trash"></i>'+ '</td></tr>');
				});
			}else if(respuesta.estatus===-2){
				monstrarAlerta({message: respuesta.descripcion, class:"info"});
			}else if(respuesta.estatus===-3){
				monstrarAlerta({message: respuesta.descripcion, class:"info"});
			}				
		},
		error: function() {
		 monstrarAlerta({message: "No se ha podido obtener la informacion", class:"danger"});
		}
	});
}

function guardarElemCatalogo() {

    let detalleCat =document.getElementById("detalleCat").value;
    let estatusCat =document.getElementById("estatusCat").value;    
    let idCatalogo= document.getElementById("idCatalogo").value;
    var json= JSON.stringify({ 'idCatalogo': parseInt(idCatalogo, 10), 'dto' : { 'detalle': detalleCat, 'estatus': parseInt(estatusCat, 10)  } });
            $.ajax({
                url :  "admin/acciones/editarGuardarCatalogo",
                type : 'POST',
                data : json,
                cache : false,
                dataType : 'json',
                contentType: "application/json; charset=utf-8",
                success : function(data, textStatus, jqXHR) {
                $("#guardarInfo").modal('hide');  
					if(data.estatus === 1){
					    consultarCatalogo();
						showAlert({message: data.descripcion, class:"success"});
						document.getElementById("formNuevoElemCatalogo").reset();              
					}else if(data.estatus===-3){
						monstrarAlerta({message: respuesta.descripcion, class:"info"});
					}else if(data.estatus===-2){
						showAlert({message: data.descripcion, class:"info"});
					}
             
                },
                error : function(jqXHR, textStatus, errorThrown) {
                    console.log('ERRORS: ' + textStatus);
                     showAlert({message: 'Se genero un error al intentar guardar la información.', class:"danger"});
                }
            });
        }
        
function eliminarElemCatalogo() {
	let idCatalogo= document.getElementById("idCatalogo").value;
    let queryParam= "idCatalogo="+idCatalogo+"&idElemCatalogo="+idElementoEliminar;
            $.ajax({
                url :  "admin/acciones/eliminarCatalogo",
                type : 'GET',
                data : queryParam,
                cache : false,
                dataType : 'json',
                
                success : function(data, textStatus, jqXHR) {
                $("#eliminarElemCatalogo").modal('hide');  
					if(data.estatus === 1){
					    consultarCatalogo();
						showAlert({message: data.descripcion, class:"success"});
						document.getElementById("formNuevoElemCatalogo").reset();              
					}else if(data.estatus===-3){
						monstrarAlerta({message: respuesta.descripcion, class:"info"});
					}
             
                },
                error : function(jqXHR, textStatus, errorThrown) {
                    console.log('ERRORS: ' + textStatus);
                     showAlert({message: 'Se genero un error al intentar guardar la información.', class:"danger"});
                }
            });
}

function eliminarElem(idElemento){
	idElementoEliminar=idElemento;
}

function editarElemCatalogo(idCatalogo,idElemCatalogo,detalle,estatus){
 document.getElementById('idCatalogo').value = idCatalogo;
 document.getElementById('idElemCatalogo').value = idElemCatalogo;
 document.getElementById('descripcionCtl').value = detalle;
 document.getElementById('estatusCtl').value = estatus;
}

function postEditarElemCatalogo() {
       
    let idCatalogo= document.getElementById("idCatalogo").value;
    let idElemCatalogo= document.getElementById("idElemCatalogo").value;
    let detalleCat =document.getElementById("descripcionCtl").value;
    let estatusCat =document.getElementById("estatusCtl").value; 
    var json= JSON.stringify({ 'idCatalogo': parseInt(idCatalogo, 10), 'dto' : { 'idCatalogo': parseInt(idElemCatalogo, 10),'detalle': detalleCat, 'estatus': parseInt(estatusCat, 10)  } });
            $.ajax({
                url :  "admin/acciones/editarGuardarCatalogo",
                type : 'POST',
                data : json,
                cache : false,
                dataType : 'json',
                contentType: "application/json; charset=utf-8",
                success : function(data, textStatus, jqXHR) {
                $("#editarElemCatalogo").modal('hide');
                document.getElementById("formEditarElemCatalogo").reset();
                $("#EditarCtls").modal('hide');  
					if(data.estatus === 1){
					    consultarCatalogo();
						showAlert({message: data.descripcion, class:"success"});
						document.getElementById("formNuevoElemCatalogo").reset();              
					}else if(data.estatus===-3){
						monstrarAlerta({message: data.descripcion, class:"info"});
					}
             
                },
                error : function(jqXHR, textStatus, errorThrown) {
                    console.log('ERRORS: ' + textStatus);
                     showAlert({message: 'Se genero un error al intentar guardar la información.', class:"danger"});
                }
            });
        }
        