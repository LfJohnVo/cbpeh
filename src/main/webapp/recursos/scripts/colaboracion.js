$(document).ready(function() {	//obtenemos el valor de los input
	$('#adicionar').click(function() {
		let id =filtrarId("accionesBusqueda");
		let detalle =filtrarValor("accionesBusqueda");
		let index =arrayLugares.indexOf(""+id);
			
		if (detalle !== '' && detalle!== undefined && index === -1) {
		    arrayLugares.push(id);
			console.log("array:"+arrayLugares);
			
			var fila = '<tr id="fila' + id + '"><td>' + detalle + '</td><td><button type="button"  onclick=eliminarInstitucion('+id+') class="btn btn-danger btn-circle"><span class="fa fa-trash"></span></button></td></tr>';

			$('#mytable tr:first').after(fila);
			var nFilas = $("#mytable tr").length;
			$("#adicionados").append(nFilas - 1);	//le resto 1 para no contar la fila del header
			document.getElementById("accionesBusqueda").value = "";
			document.getElementById("accionesBusqueda").focus();
		}
	});
});

function eliminarInstitucion(id){
	console.log(arrayLugares);
	console.log(id);
	$('#fila'+id).remove(); //borra la fila
	
	let indexElemento =arrayLugares.indexOf(""+id);
	console.log("indice:"+indexElemento);
	arrayLugares.splice(indexElemento,1);
	console.log(arrayLugares);
}

$(function() {
	$('#formColaboracion').on('submit', guardarColaboracion);
});

var arrayLugares = [];

function guardarColaboracion(event) {
	event.stopPropagation();
	event.preventDefault();
	
	var form = document.getElementById('formColaboracion');
	var formData = new FormData(form);
	formData.set("lugaresBusqueda",arrayLugares);
	
	$.ajax({
		url :  'accionesbusqueda/guardar-colaboracion',
		type : 'POST',
		data : formData,
		cache : false,
		dataType : 'json',
		processData : false,
		contentType : false,
		success : function(data, textStatus, jqXHR) {
			if(data.estatus ===1){
				monstrarAlerta({message: data.descripcion, class:"info"});
				document.getElementById("formColaboracion").reset();
				$('.custom-select').val('').trigger('change'); // Reset Select2
			}else if(data.estatus ===-3){
				monstrarAlerta({message: data.descripcion, class:"danger"});
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			monstrarAlerta({message:"Ocurrio un inconveniente al realizar la peticion", class:"danger"});
		}
	});            
}

// Colaboracion
function exportPdfColaboracion(){
	let numPeticion = document.getElementById("numPeticion").value;
	var tituloAux=document.title;
	
	console.log(numPeticion)	
	console.log(tituloAux)
	if(null != numPeticion){
		document.title=numPeticion+".pdf";
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

function changeInputCol(val) {
	console.log(val)
	if(val !=""){
  		$('#btnExportarColaboracion').prop("disabled", false);
	}else{
		$("#btnExportarColaboracion").prop("disabled", true);
	}
}

function resetColaboracion(){
	document.getElementById("formColaboracion").reset();
	$('.custom-select').val('').trigger('change'); // Se resetea también select2
	$("#btnExportarColaboracion").prop("disabled", true);
}