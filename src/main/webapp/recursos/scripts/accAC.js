  
        $(function() {
            $('#formPerfilAC').on('submit', uploadFile);
             $('#formCargaEvidencias').on('submit', uploadFile2);
              $('#formPersonaVinculada').on('submit', cargaInformacion);
                $('#formAtentasNotas').on('submit', cargaAtentasNotas);
                 $('#formConsultaAN').on('submit', getComponents);
             
    });
    //Para guardar evidencias

        function uploadFile(event) {
            event.stopPropagation();
            event.preventDefault();
            var form = document.getElementById('formPerfilAC');
            var data = new FormData(form);
            postFilesData(data,form);
              
}

        function uploadFile2(event) {
            event.stopPropagation();
            event.preventDefault();
            var form = document.getElementById('formCargaEvidencias');
            var data = new FormData(form);
            postFilesData(data,form);
              
}

        function postFilesData(data,form) {
            $.ajax({
                url :  'analisiscontexto/guardar-evidencia',
                type : 'POST',
                data : data,
                cache : false,
                dataType : 'json',
                processData : false,
                contentType : false,
                success : function(data, textStatus, jqXHR) {
                	if (data.estatus === 1) {
						monstrarAlerta({ message: data.descripcion, class: "info" });
						if($("#formPerfilAC").length > 0) {
						  document.getElementById("formPerfilAC").reset();
						}
						if($("#formCargaEvidencias").length > 0) {
						  document.getElementById("formCargaEvidencias").reset();
						}
						
					} else if (data.estatus === -3) {
						monstrarAlerta({ message: data.descripcion, class: "danger" });
					}
                }
            });
        }
        
        ////Guadar Persona vinculada
        
     
        function cargaInformacion(event) {
            event.stopPropagation();
            event.preventDefault();
            var form = document.getElementById('formPersonaVinculada');
            var data = new FormData(form);
                guardarPersonaVinculada(data,form);
}

        function guardarPersonaVinculada(data,form) {
            $.ajax({
                url :  'analisiscontexto/guardar-info-tel-red',
                type : 'POST',
                data : data,
                cache : false,
                dataType : 'json',
                processData : false,
                contentType : false,
                success : function(data, textStatus, jqXHR) {
                   console.log('SUCCESS: ' + textStatus); 
                   if(data.estatus === 1)    {           
              showAlert2({message: data.descripcion, class:"success"});  
                //  $(form).get(0).reset(); 
           } else if(data.estatus <= 0)    {
           showAlert2({message: data.descripcion, class:"danger"});
            $('#alert2').focus();
           } 
                },
                error : function(jqXHR, textStatus, errorThrown) {
                    console.log('ERRORS: ' + textStatus);
                    showAlert2({message: 'Se genero un error al intentar guardar la informacion.', class:"danger"});
                }
            });
        }

        //Guardar antentas notas
        
              function cargaAtentasNotas(event) {
            event.stopPropagation();
            event.preventDefault();
            var form = document.getElementById('formAtentasNotas');
            var data = new FormData(form);
                guardarAtentasNotas(data,form);
}
        
         function guardarAtentasNotas(data,form) {
            $.ajax({
                url :  'analisiscontexto/acciones/guardar-atentas-notas',
                type : 'POST',
                data : data,
                cache : false,
                dataType : 'json',
                processData : false,
                contentType : false,
                success : function(data, textStatus, jqXHR) {
                   console.log('SUCCESS: ' + textStatus); 
                   if(data.estatus === 1)    {           
              showAlert({message: data.descripcion, class:"success"});  
              $('.custom-select').val('').trigger('change'); // Reset Select2
                  //$(form).get(0).reset(); 
           } else if(data.estatus <= 0)    {
           showAlert({message: data.descripcion, class:"danger"});
            $('#alert').focus();
           } 
                },
                error : function(jqXHR, textStatus, errorThrown) {
                    console.log('ERRORS: ' + textStatus);
                    showAlert({message: 'Se genero un error al intentar guardar la informacion.', class:"danger"});
                }
            });
        }
        
        
// Buscar atentas notas y mostrar resultados
     	function getComponents(event) {
            event.stopPropagation();
            event.preventDefault();
            var form = document.getElementById('formConsultaAN');
            var data = new FormData(form);
            buscarCargarAtentaNotas(data);
              
		}

  		function buscarCargarAtentaNotas(data) {
            $.ajax({
                url :  'analisiscontexto/acciones/busqueda-atenta-notas',
                type : 'POST',
                data : data,
                cache : false,
                dataType : 'json',
                processData : false,
                contentType : false,
                success : function(data, textStatus, jqXHR) {
                    if(data.estatus === 1 && data.descripcion === 'OK')    {           
              
             
              
               var dataAN = data.atentaNota;
			
			//alert('Dato '+dataAN[1].idAtentaNota);
			var idAtentaNota;
			var fecha;
			var idExpediente;
			var nombreCompleto;
			 $('#tablaAtentasNotas').find('tbody').html("");
			
			for(var i =0; i<dataAN.length; i++){
			
			 idAtentaNota=dataAN[i].idAtentaNota;
			 idExpediente=dataAN[i].idExpediente;
			 fecha=new Date(dataAN[i].fechaCreacion);
			// nombreCompleto=ataAN[i].idAtentaNota;
		   // $('#tablaAtentasNotas').find('tbody').detach();
            $("#tablaAtentasNotas").find('tbody').append($('<tr><td><div>'+idAtentaNota+'</div></td>'
			+'<td><div>'+idExpediente+'</div></td>'
			+'<td><div>'+fecha.getDate()+'/'+(fecha.getMonth()+1)+'/'+fecha.getFullYear()+'</div></td>'
			+'<td><div><a href="'+pathGlobal + '/atenta-nota-pdf?idAtentaNota='+idAtentaNota+'" target="_blank" class="btn btn-info btn-circle"><i class="fas fa-file"></i></div></td>')); 			
			}
           } else if(data.estatus === 1)    {           
              showAlert({message: data.descripcion, class:"info"});  
             
           } else if(data.estatus <= 0)    {
           showAlert({message: data.descripcion, class:"danger"});
            
           } 
           
          else if(data.estatus < 0)   showAlert({message: data.descripcion, class:"error"});
             
                },
                error : function(jqXHR, textStatus, errorThrown) {
                    console.log('ERRORS: ' + textStatus);
                     showAlert({message: 'Se genero un error al intentar guardar la informacion.', class:"danger"});
                }
            });
        }

      
       	
       	function asignarDireccionPuesto(usuario) {
       	           
       	               $.ajax({
                url :  'analisiscontexto/acciones/obtener-direccion-puesto',
                type : 'GET',
                data : 'idUsuario='+usuario,
                cache : false,
                dataType : 'json',
                processData : false,
                contentType : false,
                success : function(data, textStatus, jqXHR) {                 
                    
                    
                    if(data.estatus === 1 && data.descripcion === 'OK')    {      
                    
               document.getElementById('direccionT').value =data.idDireccion;
				document.getElementById('puestoT').value =data.idPuesto;
           } else if(data.estatus <= 0)    {
           showAlert({message: data.descripcion, class:"danger"});
           } 
           
           else   showAlert({message: data.descripcion, class:"warning"});
             
                },
                error : function(jqXHR, textStatus, errorThrown) {
                    console.log('ERRORS: ' + textStatus);
                     showAlert({message: 'Se genero un error al intentar guardar la informacion.', class:"danger"});
                }
            });
       	
       	}
       	
       