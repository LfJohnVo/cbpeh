$(function() {
            $('#formEstatusDesaparecido').on('submit', consultarPDesaparecida);
            });
            
        function consultarPDesaparecida(event) {
            event.stopPropagation();
            event.preventDefault();
            var form = document.getElementById('formEstatusDesaparecido');
            var data = new FormData(form);
            mostarInfoPDesaparecida(data);
            }
            
         function mostarInfoPDesaparecida(data) {
            $.ajax({
                url :  'consultaexterna/persona-desaparecida',
                type : 'POST',
                data : data,
                cache : false,
                dataType : 'json',
                processData : false,
                contentType : false,
                success : function(data, textStatus, jqXHR) {
                if(data.estatus === 1 && data.descripcion ==='OK')    {                      
              //showAlert({message: data.descripcion, class:"success"}); 
              
             // var dataAN = data.atentaNota;
              
              $('#tPersonaDesaparecida').find('tbody').html("");
               
               $("#tPersonaDesaparecida").find('tbody').append($('<tr><td><div>'+data.folioExpediente+'</div></td>'
			//+'<td><div>'+data.curp+'</div></td>'
			+'<td><div>'+data.nombre +' '+ data.apaterno +' '+  data.amaterno+'</div></td>'
			+'<td><div>'+data.fechaDesaparecion+'</div></td>'
			+'<td><div>'+data.estatusDesaparecido+'</div></td></tr>')); 
              
              
           }   else if(data.estatus === 1)    {
             
              $('#tPersonaDesaparecida').find('tbody').html("");         
             monstrarAlerta({message: data.descripcion, class:"info"}); 
              
           } else if(data.estatus < 0)    {
           
              $('#tPersonaDesaparecida').find('tbody').html("");
            monstrarAlerta({message: data.descripcion, class:"danger"});
           } 
           
           else  {
            $('#tPersonaDesaparecida').find('tbody').html("");
             monstrarAlerta({message: data.descripcion, class:"warning"});
             }
               
                },
                error : function(jqXHR, textStatus, errorThrown) {
                    console.log('ERRORS: ' + textStatus);
                       $('#tPersonaDesaparecida').find('tbody').html("");
                    monstrarAlerta({message: 'Se genero un error al intentar guardar la informacion.', class:"danger"});
                }
            });
        }
            
var pathGlobal= '';

function mayusculas(e) {
    e.value = e.value.toUpperCase();
}

function filtrarId(idElemnt) {
	var inputElemento = document.getElementById(idElemnt).value;
	var arregloValueImput = inputElemento.split("&");
	return arregloValueImput[0];
}

function filtrarValor(idElemnt) {
	var inputElemento = document.getElementById(idElemnt).value;
	var arregloValueImput = inputElemento.split("&");
	return arregloValueImput[1];
}

function monstrarAlerta(obj){
    var html = '<div class="alert alert-' + obj.class + ' alert-dismissible" role="alert">'+
        '   <strong>' + obj.message + '</strong>'+
        '  <button class="close" type="button" data-dismiss="alert" aria-label="Close">'+
        '  <span aria-hidden=true > X </span>' +
        '  </button> </div>';
 $("#alertaMsj").html(html);
   // $('#alertaMsj').append(html);
    
     $("#alertaMsj").fadeTo(5000, 500).slideUp(500, function(){ 
          $("#alertaMsj").text("");
     $("#alertaMsj").alert('close'); 

    
}); 
}

function milisegundosToFecha(milisegundos){
	var date = new Date(milisegundos);
	return date.toLocaleDateString();
}

function milisegundosToFechaISO(milisegundos){
	var date = new Date(milisegundos).toISOString().split('T')[0];
	return date;
}

function milisegundosToFecha(milisegundos){
	var date = new Date(milisegundos);
	return date.toLocaleDateString();
}
function refrescarExpedientes(idComboExpediente) {
	$.ajax({
		url: "atencionciudadana/refrescar-expedientes",
		type: 'POST',
		success: function(respuesta) {
			$('#'+idComboExpediente+'').empty();
			var comboExpediente = $('#'+idComboExpediente+'');
			comboExpediente.append('<option value="">Selecciona...</option>');
			$.each(respuesta, function(index, elemento) {
				comboExpediente.append('<option value="' + elemento.idExpediente + '">' + elemento.idExpediente + '</option>');
			});
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});
}

//
//function obtenerComunicado(idComunicado) {
//	
//	var clob ='';
//	var cadena='';	
//	$.ajax({
//		url: 'consultaexterna/obtener-comunicado?idComunicado='+idComunicado,
//		//data:'idComunicado='+idComunicado,
//		type: 'GET',
//		cache : false,
//        dataType : 'json',
//	    processData : false,
//		success: function(data, textStatus){
//		clob = data.comunicado;
//		cadena = (clob.imagen);
//		alert(cadena);
//		},
//		error: function() {
//			console.log("No se ha podido obtener la información");
//		}
//		
//		
//	});
//	
//	return cadena;
//}
