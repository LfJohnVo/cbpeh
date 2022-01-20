$(document).ready(function() {	
	$('#adicionar').click(function() {
		var accion = document.getElementById("numExpedienteLD").value;
		
		if (accion !== '') {
		let index =arrayLugares.indexOf(""+accion);
		 arrayLugares.push(accion);
			console.log("array:"+arrayLugares);
			var fila = '<tr id="fila' + accion + '"><td>' + accion + '</td><td><button type="button" onclick=eliminarInstitucion("'+accion+'") class="btn btn-danger btn-circle"><span class="fa fa-trash"></span></button></td></tr>';

			$('#mytable tr:first').after(fila);
			var nFilas = $("#mytable tr").length;
			$("#adicionados").append(nFilas - 1);	//le resto 1 para no contar la fila del header
			document.getElementById("numExpedienteLD").value = "";
			document.getElementById("numExpedienteLD").focus();

		}
		validaExporta();
	});	
});

var arrayLugares = [];

function eliminarInstitucion(id){
	console.log(arrayLugares);
	console.log(id);
	$('#fila'+id).remove(); //borra la fila
	
	let indexElemento =arrayLugares.indexOf(""+id);
	console.log("indice:"+indexElemento);
	arrayLugares.splice(indexElemento,1);
	console.log(arrayLugares);
	validaExporta();
}


$(function() {
	$('#formLargaData').on('submit', guardarLargaData);
});

function guardarLargaData(event) {


	event.stopPropagation();
	event.preventDefault();
	var form = document.getElementById('formLargaData');
	var formData = new FormData(form);
	formData.set("lugaresBusqueda",arrayLugares);
	var estatusLD =  filtrarId("estatusLD");
	var municipioLargaData =  filtrarId("municipioLargaData");
	var cpLargaData =  filtrarId("cpLargaData");
	var coloniaLargaData =  filtrarId("coloniaLargaData");
	//console.log(estatusAb+"/"+municipioAb+"/"+cpAb+"/"+coloniaAb);
	formData.set("estatusLD",estatusLD);
	formData.set("municipioLargaData",municipioLargaData);
	formData.set("cpLargaData",cpLargaData);
	formData.set("coloniaLargaData",coloniaLargaData);
	
	
document.getElementById('alertExito').style.display = 'none';
document.getElementById('alertELocalizacion').style.display = 'none';
document.getElementById('alertFBusqueda').style.display = 'none';
var fechaLD = document.getElementById("fechaLD").value;
var estatusLD = document.getElementById("estatusLD").value;
	if (fechaLD != "" && estatusLD != "") {
	
	$.ajax({
		url :  'accionesbusqueda/guardarLargaData',
		type : 'POST',
		data : formData,
		cache : false,
		dataType : 'json',
		processData : false,
		contentType : false,
		success : function() {
			alert("ok");
			resetLargaData();
		},
		error : function() {
			monstrarAlerta({message:"Ocurrio un inconveniente al realizar la peticion", class:"danger"});
		}
	});
	
	$('#limpiarLD').click();	
	document.getElementById('alertExito').style.display = 'block';	
	} else {
	
	if (fechaLD === "") {
		document.getElementById('alertFBusqueda').style.display = 'block';
	}
	if (estatusLD === "") {
	document.getElementById('alertELocalizacion').style.display = 'block';
	}		
		//showAlertReportante("Se requiere llenar el campo teléfono para registrar un declarante anónimo");
	 }
}

//LargaData
function exportPdfLargaData(){
	var tituloAux=document.title;	
	console.log(tituloAux)
	if(arrayLugares.length>0){
		let namePdf="";
		document.title="LargaData_"+arrayLugares.toString()+".pdf";
		//$("#sidebarToggle").click();
		//$(".sidebar").toggleClass("toggled");
		setTimeout(function () {
			window.print()
			document.title= tituloAux;
		}, 500);
	}else{
		monstrarAlerta({message: "Seleccione un expediente primero.", class:"info"});
	}
}
function validaExporta(){
	if(arrayLugares.length>0){
  		$('#btnExportarLd').prop("disabled", false);
	}else{
		$("#btnExportarLd").prop("disabled", true);
	}
}

function resetLargaData(){
	document.getElementById("formLargaData").reset();
	$('.custom-select').val('').trigger('change'); // Reset select2
	$("#btnExportarLd").prop("disabled", true);
	arrayLugares = [];
}