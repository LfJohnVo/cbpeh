/**
 * 
 */

$(document).ready(function() {

	$("#mCargaAnalisisContexto").click(function() {
		$("#container-fluid").load(pathGlobal + "/vistas/analisisContexto.jsp");
	});

	$("#mCargaEvidenciasAC").click(function() {
		$("#container-fluid").load(pathGlobal + "/contenido/cargaEvidencias.jsp");
	});

	$("#mEAtentasNotasAC").click(function() {
		$("#container-fluid").load(pathGlobal + "/vistas/eatentasNotas.jsp");
	});

	$("#mCAtentasNotasAC").click(function() {
		$("#container-fluid").load(pathGlobal + "/vistas/catentasNotas.jsp");
		buscarAtentasNotas();
	});

});

	//Busqueda de expediente por folio
	function buscarExpPersonaDesaparecida() {

	var folioExpediente = document.getElementById("folioExpediente");	

	$.ajax({
		type: 'POST',
		url: pathGlobal + '/analisiscontexto/busqueda-expediente',
		//dataType: "json",
		cache: false,
		data:'folioExpediente='+folioExpediente.value,
		success: function(data, textStatus, jQxhr) {
			
			console.log('textStatus : ' + textStatus);
           
			 if(data.estatus === 1 && data.descripcion ==='OK')    {    
			var personaDesaparecida = data.personaDesaparecida;
            document.getElementById("idExpediente").value = folioExpediente.value;
			document.getElementById("nombreD").value = personaDesaparecida.nombre;
			document.getElementById("apellidoPaternoD").value = personaDesaparecida.apaterno;
			document.getElementById("apellidoMaternoD").value = personaDesaparecida.amaterno;
			
			//showAlert({message: data.descripcion, class:"success"});  
           } else if(data.estatus === 1)    {
           showAlert({message: data.descripcion, class:"info"});
           } else if(data.estatus <= 0)    {
           showAlert({message: data.descripcion, class:"danger"});
           }            
           else showAlert({message: data.descripcion, class:"warning"});
		},

		error: function(jqXhr, textStatus, errorThrown) {
		showAlert({message: 'Se genero un error al consultar la informacion.', class:"danger"});
			console.log(errorThrown);
		}
	});

}

//obtener de atentas notas del area
function buscarAtentasNotas() {


	var idArea = document.getElementById("idAreaUsuario").value;	

	$.ajax({
		type: 'POST',
		url: pathGlobal + '/analisiscontexto/acciones/busqueda-atenta-notas-area',
		//dataType: "json",
		cache: false,
		data:'idArea='+idArea,
		success: function(data, textStatus, jQxhr) {
			
			console.log('textStatus : ' + textStatus);
           
			 if(data.estatus === 1 && data.descripcion ==='OK')    {
			 
			// $("#tablaAtentasNotas").find('tbody').append($('<tr>').append($('<td>').append($('<img>').attr('src', 'img.png').text('Image cell'))
				      
			 var dataAN = data.atentaNota;
			
			var idAtentaNota;
			var fecha;
			var idExpediente;
			var nombreCompleto;
			for(var i =0; i<dataAN.length; i++){
			
			 idAtentaNota=dataAN[i].idAtentaNota;
			 idExpediente=dataAN[i].idExpediente;
			 fecha=new Date(dataAN[i].fechaCreacion);
			// nombreCompleto=ataAN[i].idAtentaNota;
			
			$("#tablaAtentasNotas").find('tbody').append($('<tr><td><div>'+idAtentaNota+'</div></td>'
			+'<td><div>'+idExpediente+'</div></td>'
			+'<td><div>'+fecha.getDate()+'/'+(fecha.getMonth()+1)+'/'+fecha.getFullYear()+'</div></td>'
			+'<td><div><a href="'+pathGlobal + '/atenta-nota-pdf?idAtentaNota='+idAtentaNota+'" target="_blank" class="btn btn-info btn-circle"><i class="fas fa-file"></i></div></div></td>')); 			
			}
			//showAlert({message: data.descripcion, class:"success"});  
           } else if(data.estatus === 1)    {
           showAlert({message: data.descripcion, class:"info"});
           } else if(data.estatus <= 0)    {
           showAlert({message: data.descripcion, class:"danger"});
           } 
           
           else   showAlert({message: data.descripcion, class:"warning"});
		},

		error: function(jqXhr, textStatus, errorThrown) {
		showAlert({message: 'Se genero un error al consultar la informacion.', class:"danger"});
			console.log(errorThrown);
		}
	});

}



//alertas de notificacion

function showAlert(obj){
    var html = '<div class="alert alert-' + obj.class + ' alert-dismissible" role="alert">'+
        '   <strong>' + obj.message + '</strong>'+
        '       <button class="close" type="button" data-dismiss="alert" aria-label="Close">'+
        '       <span aria-hidden="true"> X </span>'+
        '       </button></div>';

    $('#alert').html(html);
    
     $("#alert").fadeTo(2000, 500).slideUp(500, function(){ 
          $("#alert").text("");
     $("#alert").alert('close'); 
     }); 
}
function showAlert2(obj){
    var html = '<div class="alert alert-' + obj.class + ' alert-dismissible" role="alert">'+
        '   <strong>' + obj.message + '</strong>'+
        '       <button class="close" type="button" data-dismiss="alert" aria-label="Close">'+
        '       <span aria-hidden="true"> X </span>'+
        '       </button>  </div>';

    $('#alert2').html(html);
    
        
     $("#alert2").fadeTo(2000, 500).slideUp(500, function(){ 
          $("#alert2").text("");
     $("#alert2").alert('close'); 
     }); 

}