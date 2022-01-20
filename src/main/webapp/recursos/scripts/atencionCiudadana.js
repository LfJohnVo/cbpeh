$(document).ready(function() {
	cargaDeclarante();
	var idExpedienteNombrePdf = null;
});

function desbloquear(combo, textArea) {

	var valorCombo = document.getElementById(combo).value;
	
	if (combo !== ("transporte")) {
		if (valorCombo ==="2") {
			$(textArea).removeAttr('disabled');
		} else {
			$(textArea).attr('disabled',  'disabled');
		}
	} else {
		if (valorCombo !== "" && valorCombo !== "6") {
			$(textArea).removeAttr('disabled');
		} else {
		 $(textArea).attr('disabled',  'disabled');
		}
	}

}

$(function() {
	$('#formCargaEvidenciaAt').on('submit', guardarEvidencia);
	$('#formReportanteRead').on('submit', guardarReportantes);
	$('#formReportante').on('submit', guardarReportantes);
	$('#formDesaparecida').on('submit', guardarDesaparecidos);
	$('#formActaEntrevista').on('submit', guardarActaEntrevista);
});

function guardarEvidencia(event) {
	event.stopPropagation();
	event.preventDefault();
	var form = document.getElementById('formCargaEvidenciaAt');
	var formData = new FormData(form);
	postFilesDataEvi(formData);
}

function guardarReportantes(event) {
	
		document.getElementById('alertTelefono').style.display = 'none';
		event.stopPropagation();
		event.preventDefault();
		var form = document.getElementById('formReportante');
		var formData = new FormData(form);
		var estado = filtrarId("estado");
		var municipio = filtrarId("municipio");
		var cp = filtrarId("cp");
		var colonia = filtrarId("colonia");
		formData.set("estado", estado);
		formData.set("municipio", municipio);
		formData.set("cp", cp);
		formData.set("colonia", colonia);
		postFilesDataIdentificacion(formData);
	
}
function guardarDesaparecidos(event) {

	var operaciones = document.getElementById("descripcionOperaciones").value;
	var discapacidad = document.getElementById("descripcionDiscapacidad").value;
	var fracturas = document.getElementById("descripcionFracturas").value;
	var faltas = document.getElementById("descripcionFaltas").value;
	var violencia = document.getElementById("descripcionViolencia").value;
	var documento = document.getElementById("descripcionDocumentacion").value;
	var documentos = document.getElementById("descripcionDocumento").value;
	var llamadas = document.getElementById("descripcionLlamadas").value;
	var transporte = document.getElementById("descripcionTransporte").value;
	var hijos = document.getElementById("descripcionHijos").value;
	
	event.stopPropagation();
	event.preventDefault();
	var form = document.getElementById('formDesaparecida');
	var formData = new FormData(form);
	var estadoDesaparecido = filtrarId("estadoDesaparecido");
	var municipioDesaparecido = filtrarId("municipioDesaparecido");
	var cpDesaparecido = filtrarId("cpDesaparecido");
	var coloniaDesaparecido = filtrarId("coloniaDesaparecido");
	formData.set("estadoDesaparecido", estadoDesaparecido);
	formData.set("municipioDesaparecido", municipioDesaparecido);
	formData.set("cpDesaparecido", cpDesaparecido);
	formData.set("coloniaDesaparecido", coloniaDesaparecido);
	
	if (operaciones === null || operaciones === "") {
		formData.set("descripcionOperaciones", "");
	}
	if (discapacidad === null || discapacidad === "") {
		formData.set("descripcionDiscapacidad", "");
	}
	if (fracturas === null || fracturas === "") {
		formData.set("descripcionFracturas", "");
	}
	if (faltas === null || faltas === "") {
		formData.set("descripcionFaltas", "");
	}
	if (violencia === null || violencia === "") {
		formData.set("descripcionViolencia", "");
	}
	if (documento === null || documento === "") {
		formData.set("descripcionDocumentacion", "");
	}
	if (documentos === null || documentos === "") {
		formData.set("descripcionDocumento", "");
	}
	if (llamadas === null || llamadas === "") {
		formData.set("descripcionLlamadas", "");
	}
	if (transporte === null || transporte === "") {
		formData.set("descripcionTransporte", "");
	}
	if (hijos === null || hijos === "") {
		formData.set("descripcionHijos", "");
	}
	
	postFilesDataFotografia(formData);	

}

function postFilesDataEvi(formData) {
	$.ajax({
		url: 'atencionciudadana/guardar-evidencia-at',
		type: 'POST',
		data: formData,
		cache: false,
		dataType: 'json',
		processData: false,
		contentType: false,
		success: function(data, textStatus, jqXHR) {
			if (data.estatus === 1) {
				monstrarAlerta({ message: data.descripcion, class: "info" });
				document.getElementById("formCargaEvidenciaAt").reset();
			} else if (data.estatus === -3) {
				monstrarAlerta({ message: data.descripcion, class: "danger" });
			}
		},
		error: function(jqXHR, textStatus, errorThrown) {
			monstrarAlerta({ message: "Ocurrio un inconveniente al realizar la peticion", class: "danger" });
		}
	});
}

function postFilesDataIdentificacion(formData) {
var telefono = document.getElementById("telefono").value;
	if (telefono != "") {
	$.ajax({
		url: 'atencionciudadana/guardarReportantes',
		type: 'POST',
		data: formData,
		cache: false,
		dataType: 'json',
		processData: false,
		contentType: false,
		success: function(data) {
			//alert(data);
		}
	});
	$('#limpiar').click()
	document.getElementById('alertExito').style.display = 'block';
} else {
		document.getElementById('alertTelefono').style.display = 'block';
		document.getElementById('alertExito').style.display = 'none';
		//showAlertReportante("Se requiere llenar el campo teléfono para registrar un declarante anónimo");
	}
}

function postFilesDataFotografia(formData) {
document.getElementById('alertEstado').style.display = 'none';
document.getElementById('alertDeclarante').style.display = 'none';
document.getElementById('alertExitoDesaparecida').style.display = 'none';
var declarante = document.getElementById("declarante").value;
var estado = document.getElementById("estadoDesaparecido").value;
	if (declarante != "" && estado != "") {
	$.ajax({
		url: 'atencionciudadana/guardarDesaparecidos',
		type: 'POST',
		data: formData,
		cache: false,
		dataType: 'json',
		processData: false,
		contentType: false,
		success: function(data) {
			document.getElementById('alertExitoDesaparecida').style.display = 'block';
			document.querySelector('#expedienteGenerado').innerText = data;
			$('#cancelar').click();			
		}
	});
	
	} else {
	
	if (declarante === "") {
		document.getElementById('alertDeclarante').style.display = 'block';
	}
	if (estado === "") {
	document.getElementById('alertEstado').style.display = 'block';
	}		
		//showAlertReportante("Se requiere llenar el campo teléfono para registrar un declarante anónimo");
	 }
}

function bloquearTextAreas() {

	$("#descripcionOperaciones").attr('disabled' , 'disabled');
	$("#descripcionDiscapacidad").attr('disabled' , 'disabled');
	$("#descripcionFracturas").attr('disabled' , 'disabled');
	$("#descripcionFaltas").attr('disabled' , 'disabled');	
	$("#descripcionViolencia").attr('disabled' , 'disabled');
	$("#descripcionDocumentacion").attr('disabled' , 'disabled');
	$("#descripcionDocumento").attr('disabled' , 'disabled');
	$("#descripcionLlamadas").attr('disabled' , 'disabled');
	$("#descripcionTransporte").attr('disabled' , 'disabled');
	$("#descripcionHijos").attr('disabled' , 'disabled');
}

function buscarConcentrado() {
	var idExpediente = document.getElementById("expediente").value;
	var idSexo = document.getElementById("sexo").value;
	var idEdad = document.getElementById("edad").value;
	var idMunicipio = document.getElementById("municipio").value;
	var idEstatusLocalizado = document.getElementById("estatusLocalizado").value;
	var data ='idExpediente='+idExpediente+'&idSexo='+idSexo+'&idEdad='+idEdad+'&idMunicipio='+idMunicipio+'&idEstatusLocalizado='+idEstatusLocalizado;
	$.ajax({
		url: "atencionciudadana/buscar-concentrado",
		type: 'GET',
		data: data,
		success: function(data) {
			$("#bodyConcentrados").html("");
			var bodyConcen = $("#bodyConcentrados");

			if (data.estatus === 1) {
				$.each(data.elementos, function(index, elemento) {
				let fechaCierre=( null === elemento.fechaCierre? "" :elemento.fechaCierre);
					bodyConcen.append(' <tr><td><a href="?idExpediente='+elemento.idExpediente+'">' + elemento.idExpediente + '</td><td>' + elemento.personaDesaparecida + '</td><td>' + elemento.fechaApertura + '</td><td>' + fechaCierre + '</td><td>' + elemento.sexo + '</td><td>' + elemento.municipio + '</td><td>' + elemento.estatus + '</td></tr>');
				});
				$("#btnExportarConcentrado").prop("disabled", false);
			} else if (data.estatus === 2) {
				monstrarAlerta({ message: data.descripcion, class: "info" });
			} else if (data.estatus === -3) {
				monstrarAlerta({ message: data.descripcion, class: "danger" });
			}
		},
		error: function() {
			monstrarAlerta({ message: "No se ha podido obtener la informacion", class: "danger" });
		}
	});
}
function limpiarTabla(){
	document.getElementById("formConcentradoAt").reset();
	$('.custom-select').val('').trigger('change'); // Reset select2
	$('#bodyConcentrados').html("");
}

function cargaMunicipio() {
	var idEstado = document.getElementById("estado").value;
	var arregloValueMunicipio = idEstado.split("&", 2);
	$.ajax({
		url: "atencionciudadana/municipios-por-estado",
		type: 'POST',
		data: 'codigoEstado=' + arregloValueMunicipio[1],
		success: function(respuesta) {
			$('#cp').empty();
			$('#colonia').empty();
			$('#municipio').empty();
			var inputMunicipio = $("#municipio");
			var inputColonia = $("#colonia");
			var inputCp = $("#cp");
			inputMunicipio.append('<option value="">Selecciona...</option>');
			inputColonia.append('<option value="">Selecciona...</option>');
			inputCp.append('<option value="">Selecciona...</option>');
			$.each(respuesta, function(index, elemento) {
				inputMunicipio.append('<option value="' + elemento.idMunicipio + '&' + elemento.codigoMunicipio + '">' + elemento.municipioDetalle + '</option>');

			});
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});
}


function cargaCp() {
	var idEstado = document.getElementById("estado").value;
	var arregloEstado = idEstado.split("&", 2);
	var idMunicipio = document.getElementById("municipio").value;
	var arregloMunicipio = idMunicipio.split("&", 2);
	var datos = 'codigoEstado=' + arregloEstado[1] + '&codigoMunicipio=' + arregloMunicipio[1];
	$.ajax({
		url: "atencionciudadana/cp-por-estado-municipios",
		type: 'POST',
		data: datos,
		success: function(respuesta) {
			$('#cp').empty();
			$('#colonia').empty();
			var inputCp = $("#cp");
			var inputColonia = $("#colonia");
			inputCp.append('<option value="">Selecciona...</option>');
			inputColonia.append('<option value="">Selecciona...</option>');
			$.each(respuesta, function(index, elemento) {
				//alert(elemento.codigoCp);
				inputCp.append('<option value="' + elemento.idCp + '&' + elemento.codigoCp + '">' + elemento.codigoCp + '</option>');
			});
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});
}

function cargaColonia() {
	var codigoP = document.getElementById("cp").value;
	var idCodigoP = codigoP.split("&", 2);
	$.ajax({
		url: "atencionciudadana/colonia-por-cp",
		type: 'POST',
		data: 'codigoCp=' + idCodigoP[1],
		success: function(respuesta) {
			$('#colonia').empty();
			var inputColonia = $("#colonia");
			inputColonia.append('<option value="">Selecciona...</option>');
			$.each(respuesta, function(index, elemento) {
				inputColonia.append('<option value="' + elemento.idColonia + '&' + elemento.codigoColonia + '">' + elemento.coloniaDetalle + '</option>');
			});
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});
}

function cargaMunicipioDesaparecido() {
	var idEstado = document.getElementById("estadoDesaparecido").value;
	var arregloValueMunicipio = idEstado.split("&", 2);
	$.ajax({
		url: "atencionciudadana/municipios-por-estado",
		type: 'POST',
		data: 'codigoEstado=' + arregloValueMunicipio[1],
		success: function(respuesta) {
			$('#cpDesaparecido').empty();
			$('#coloniaDesaparecido').empty();
			$('#municipioDesaparecido').empty();
			var inputMunicipio = $("#municipioDesaparecido");
			var inputColonia = $("#coloniaDesaparecido");
			var inputCp = $("#cpDesaparecido");
			inputMunicipio.append('<option value="">Selecciona...</option>');
			inputColonia.append('<option value="">Selecciona...</option>');
			inputCp.append('<option value="">Selecciona...</option>');
			$.each(respuesta, function(index, elemento) {
				inputMunicipio.append('<option value="' + elemento.idMunicipio + '&' + elemento.codigoMunicipio + '">' + elemento.municipioDetalle + '</option>');

			});
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});
}

function cargaCpDesaparecido() {
	var idEstado = document.getElementById("estadoDesaparecido").value;
	var arregloEstado = idEstado.split("&", 2);
	var idMunicipio = document.getElementById("municipioDesaparecido").value;
	var arregloMunicipio = idMunicipio.split("&", 2);
	var datos = 'codigoEstado=' + arregloEstado[1] + '&codigoMunicipio=' + arregloMunicipio[1];
	$.ajax({
		url: "atencionciudadana/cp-por-estado-municipios",
		type: 'POST',
		data: datos,
		success: function(respuesta) {
			$('#cpDesaparecido').empty();
			$('#coloniaDesaparecido').empty();
			var inputCp = $("#cpDesaparecido");
			var inputColonia = $("#coloniaDesaparecido");
			inputCp.append('<option value="">Selecciona...</option>');
			inputColonia.append('<option value="">Selecciona...</option>');
			$.each(respuesta, function(index, elemento) {
				//alert(elemento.codigoCp);
				inputCp.append('<option value="' + elemento.idCp + '&' + elemento.codigoCp + '">' + elemento.codigoCp + '</option>');
			});
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});
}

function cargaColoniaDesaparecido() {
	var codigoP = document.getElementById("cpDesaparecido").value;
	var idCodigoP = codigoP.split("&", 2);
	$.ajax({
		url: "atencionciudadana/colonia-por-cp",
		type: 'POST',
		data: 'codigoCp=' + idCodigoP[1],
		success: function(respuesta) {
			$('#coloniaDesaparecido').empty();
			var inputColonia = $("#coloniaDesaparecido");
			inputColonia.append('<option value="">Selecciona...</option>');
			$.each(respuesta, function(index, elemento) {
				inputColonia.append('<option value="' + elemento.idColonia + '&' + elemento.codigoColonia + '">' + elemento.coloniaDetalle + '</option>');
			});
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});
}

function cargaDeclarante() {
	$.ajax({
		url: "atencionciudadana/reportantes",
		type: 'POST',
		success: function(respuesta) {
			$('#declarante').empty();
			var inputDeclarante = $("#declarante");
			inputDeclarante.append('<option value="">Selecciona...</option>');
			$.each(respuesta, function(index, elemento) {
				if(elemento.nombre==null){
					elemento.nombre= "";
				} 
				
				if (elemento.apaterno==null){
					elemento.apaterno="";
				}
				
				if (elemento.amaterno==null){
					elemento.amaterno="";
				}
				
				if (elemento.nombre=="" && elemento.apaterno== "" && elemento.amaterno== "" ){
				inputDeclarante.append('<option value="' + elemento.idPersonaReporta + '">' + elemento.telefono1 + '</option>');
				} else {				
				inputDeclarante.append('<option value="' + elemento.idPersonaReporta + '">' + elemento.nombre + ' ' + elemento.apaterno + ' ' + elemento.amaterno + '</option>');
				}
			});
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});
}



function consultarEstatusPersona(){

	var idExpediente = document.getElementById("expedienteConsulta").value;
	//var curp = document.getElementById("curpConsulta").value;

	//var data ='idExpediente='+idExpediente+'&curp='+curp;
	let data ='idExpediente='+idExpediente;
	$('#btnExportarExp').prop("disabled", true);
	$.ajax({
		url: "atencionciudadana/consultar-expediente",
		type: 'GET',
		data: data,
		success: function(data) {
		$('#cardReportante').hide();
		$('#cardDesaparecido').hide();
		$('#cardEvidencias').hide();
		$('#cardActaEntrevista').hide();
		$('#cardContexto').hide();
		$('#cardAcciones').hide();
			if(data.estatus===1){
				idExpedienteNombrePdf = document.getElementById("expedienteConsulta").value;
			
				$('#btnExportarExp').prop("disabled", false);
				if(null != data.elemento.personaDesaparecida){
					leerDesaparecido(data.elemento);
					$('#cardDesaparecido').show();
				}
				if(null != data.elemento.personaReporta){
					leerReportante(data.elemento);
					$('#cardReportante').show();
				}
				if(null != data.elemento.archivoExpediente){
					leerEvidencias(data.elemento);
					$('#cardEvidencias').show();
				}
				if(null != data.elemento.personaEntrevista){
					leerEntrevista(data.elemento);
				}
				if(null != data.elemento.accionBusqueda){
					leerAcciones(data.elemento);
					$('#cardAcciones').show();
				}
									
				$('#cardContexto').show();
				if(data.elemento.personaEntrevista){
					$('#cardActaEntrevista').show();
				}else{
					document.getElementById("formActaEntrevistaRead").reset();
					$('#cardActaEntrevista').hide();
				}
			}else if(data.estatus===2){
				monstrarAlerta({message: data.descripcion, class:"info"});
			}else if(data.estatus===-3){
				monstrarAlerta({message: data.descripcion, class:"danger"});
			}			
		},
		error: function() {
		 monstrarAlerta({message: "No se ha podido obtener la informacion", class:"danger"});
		}
	});
}

function leerReportante(elemento){
	$('#municipioRepoRead').empty();
	$('#cpRepoRead').empty();
	$('#coloniaRepoRead').empty();
					
	var inputMunicipioRepo = $("#municipioRepoRead");
	var inputcpRepo = $("#cpRepoRead");	
	var inputColoniaRepo = $("#coloniaRepoRead");
				
	inputMunicipioRepo.append('<option value="">Selecciona...</option>');
	inputcpRepo.append('<option value="">Selecciona...</option>');
	inputColoniaRepo.append('<option value="">Selecciona...</option>');
	
	if(null !== elemento.anidadosDto && null !== elemento.anidadosDto.municipiosRepo){
		$.each(elemento.anidadosDto.municipiosRepo, function(index, elemento) {
			inputMunicipioRepo.append('<option value="' + elemento.codigoMunicipio +'">' + elemento.municipioDetalle + '</option>');
		});		
	}
	if(null !== elemento.anidadosDto && null !== elemento.anidadosDto.cpsRepo){
		$.each(elemento.anidadosDto.cpsRepo, function(index, elemento) {
			inputcpRepo.append('<option value="' + elemento.codigoCp +'">' + elemento.codigoCp + '</option>');
		});		
	}
	/*if(null !== elemento.anidadosDto && null !== elemento.anidadosDto.coloniasRepo){
		$.each(elemento.anidadosDto.coloniasRepo, function(index, elemento) {
			inputColoniaRepo.append('<option value="' + elemento.idColonia +'">' + elemento.coloniaDetalle + '</option>');
		});		
	}*/
	
	$("#idReportanteRead").val( null === elemento.personaReporta.idPersonaReporta? null :elemento.personaReporta.idPersonaReporta );
	$("#nombreRepoRead").val( null === elemento.personaReporta.nombre? undefined:elemento.personaReporta.nombre );
	$("#apaternoRepoRead").val(null === elemento.personaReporta.apaterno? undefined:elemento.personaReporta.apaterno );
	$("#amaternoRepoRead").val(null === elemento.personaReporta.amaterno? undefined:elemento.personaReporta.amaterno );
	
	$("#estadoRepoRead").val( null === elemento.personaReporta.codigo_estado? undefined:elemento.personaReporta.codigo_estado);
	$("#municipioRepoRead").val( null === elemento.personaReporta.codigo_municipio? undefined:elemento.personaReporta.codigo_municipio );
	$("#cpRepoRead").val( null === elemento.personaReporta.id_cp? undefined:elemento.personaReporta.id_cp );
	$("#coloniaRepoRead").val( null === elemento.personaReporta.colonia? undefined:elemento.personaReporta.colonia);
	
	$("#calleRepoRead").val(null === elemento.personaReporta.calle? undefined:elemento.personaReporta.calle );
	$("#edadRepoRead").val(null === elemento.personaReporta.id_edad? undefined:elemento.personaReporta.id_edad );
	$("#sexoRepoRead").val(null === elemento.personaReporta.id_sexo? undefined:elemento.personaReporta.id_sexo );
	$("#telefonoRepoRead").val(null === elemento.personaReporta.telefono1? undefined:elemento.personaReporta.telefono1 );
	$("#correoRepoRead").val( null === elemento.personaReporta.correo_electronico? undefined:elemento.personaReporta.correo_electronico );
	$("#celular2RepoRead").val( null === elemento.personaReporta.telefono2? undefined:elemento.personaReporta.telefono2 );
	$("#relacionRepoRead").val( null === elemento.personaReporta.id_parentesco? undefined:elemento.personaReporta.id_parentesco );
	$("#ocupacionRepoRead").val( null === elemento.personaReporta.ocupacion? undefined:elemento.personaReporta.ocupacion );
	$("#medioRepoRead").val( null === elemento.personaReporta.medio_reporte? undefined:elemento.personaReporta.medio_reporte );
	$("#nacionalidadRepoRead").val(null === elemento.personaReporta.nacionalidad? undefined:elemento.personaReporta.nacionalidad );

//$("#acompaniaRepoRead").val(null === elemento.personaReporta.catSiNo? undefined:elemento.personaReporta.catSiNo.idSiNo );
	/*$('#divIdentificacionRepoRead').html("");
	if(null===elemento.personaReporta.identificacion){
		var htmlIdentifica = '<input type="file" class="form-control-file" id="identificacionRepoRead" name="identificacionRepoRead" accept=".jpeg,.jpg,.jfif,.pdf,.png" disabled>';
		$('#divIdentificacionRepoRead').html(htmlIdentifica);
	}else{
		var htmlIdentifica = '<a href="/cbpeh/atencionciudadana/getIdentificacion?idPersonaReporta='+elemento.personaReporta.idPersonaReporta+'" >Ver Identificacion</a>';
		$('#divIdentificacionRepoRead').html(htmlIdentifica);			
	} */
}

function leerEvidencias(elemento){
	$('#evidenciasBody').html("");
	$('#evidenciasContexto').html("");
	
	
	if(null !== elemento.archivoExpediente && elemento.archivoExpediente.length >0){		
		$.each(elemento.archivoExpediente, function(index, elemento) {
			
			var html ='<tr id="trEvi'+elemento.idArchivoExpediente+'"><td>'+milisegundosToFecha(elemento.fechaCarga)+'</td><td>'+elemento.nombreArchivo+'</td><td>'+elemento.archivoDescripcion+'</td>'+
					'	<td>'+
					'	<a href="" download="'+elemento.nombreArchivo+'" id="evi'+elemento.idArchivoExpediente+'"> <button type="button" class="btn btn-info btn-circle"><span class="fa fa-eye"></span></button> </a>'+
					'	</td>'+
					'	<td>'+
					'		<button type="button" class="btn btn-danger btn-circle"'+
					'		 onclick="eliminarArchivoEvi('+elemento.idArchivoExpediente+')">'+
					'			<span class="fa fa-trash"></span>'+
					'		</button>'+
					'</td></tr>';
				if(elemento.idPerfilCarga ===2){
					$('#evidenciasContexto').append(html);
				}else{
					$('#evidenciasBody').append(html);				
				}			
			let png64 = "data:application/octet-stream;base64," +elemento.archivo;
			$('#evi'+elemento.idArchivoExpediente+'').attr('href', png64);
		});	
	}
}

function cargarMunicipioRepoRead() {
	var valueEstado = filtrarValor("estadoRepoRead");
	$.ajax({
		url: "atencionciudadana/municipios-por-estado",
		type: 'POST',
		data: 'codigoEstado='+valueEstado,
		success: function(respuesta) {
		
			$('#municipioRepoRead').empty();
			$('#cpRepoRead').empty();
			$('#coloniaRepoRead').empty();			
			var inputMunicipioRepoRead = $("#municipioRepoRead");
			var inputCpRepoRead = $("#cpRepoRead");
			var inputColoniaRepoRead = $("#coloniaRepoRead");			
			inputMunicipioRepoRead.append('<option value="">Selecciona...</option>');
			inputCpRepoRead.append('<option value="">Selecciona...</option>');
			inputColoniaRepoRead.append('<option value="">Selecciona...</option>');
			
			$.each(respuesta, function(index, elemento) {
				inputMunicipioRepoRead.append('<option value="' +elemento.codigoMunicipio+'">' + elemento.municipioDetalle + '</option>');
			});
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});
}

function cargarCpRepoRead() {
	var valueEstado = filtrarValor("estadoRepoRead");
	var valueMunicipio = filtrarValor("municipioRepoRead");
	var datos = 'codigoEstado='+ valueEstado + '&codigoMunicipio='+ valueMunicipio;
	$.ajax({
		url: "atencionciudadana/cp-por-estado-municipios",
		type: 'POST',
		data: datos,
		success: function(respuesta) {
		
			$('#cpRepoRead').empty();
			$('#coloniaRepoRead').empty();			
			var inputCpRepoRead = $("#cpRepoRead");
			var inputColoniaRepoRead = $("#coloniaRepoRead");			
			inputCpRepoRead.append('<option value="">Selecciona...</option>');
			inputColoniaRepoRead.append('<option value="">Selecciona...</option>');
			
			$.each(respuesta, function(index, elemento) {
				inputCpRepoRead.append('<option value="' + elemento.codigoCp +'">' + elemento.codigoCp + '</option>');
			});
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});
}

/*function cargarColoniaRepoRead() {
	var valueCp = filtrarValor("cpRepoRead");
	$.ajax({
		url: "atencionciudadana/colonia-por-cp",
		type: 'POST',
		data: 'codigoCp='+valueCp,
		success: function(respuesta) {
			$('#coloniaRepoRead').empty();
			var inputColoniaRepoRead = $("#coloniaRepoRead");
			inputColoniaRepoRead.append('<option value="">Selecciona...</option>');
			$.each(respuesta, function(index, elemento) {
				inputColoniaRepoRead.append('<option value="' + elemento.idColonia +'">' + elemento.coloniaDetalle + '</option>');
			});
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});

} */

function initConcentrado(){
	refrescarExpedientes("expediente");			//combo concentrado
	$("#btnExportarConcentrado").prop("disabled", true);
}

function initEstatusPersona(){
	$('.custom-select').val('').trigger('change'); // Se resetea también select2
	refrescarExpedientes("expedienteConsulta"); //combo estatus
	//para los form editar
	$('#formReportanteRead').on('submit', saveFormReportanteEdit);
	$('#formDesaparecidoRead').on('submit', saveFormDesaparecidoEdit);
	$('#formActaEntrevistaRead').on('submit', saveFormActaEdit);
	//
	$('#cardReportante').hide();
	$('#cardDesaparecido').hide();
	$('#cardEvidencias').hide();
	$('#cardActaEntrevista').hide();  //solo para validar
	$('#cardContexto').hide();
	$('#cardAcciones').hide();
	$('#btnCancelarReportante').prop("disabled", true);
	$('#btnGuardarReportante').prop("disabled", true);
	$('#btnCancelarDesaparecido').prop("disabled", true);
	$('#btnGuardarDesaparecido').prop("disabled", true);
	
	$("#descripcionOperacionesDesa").attr('disabled' , 'disabled');
	$("#descripcionDiscapacidadDesa").attr('disabled' , 'disabled');
	$("#descripcionFracturasDesa").attr('disabled' , 'disabled');
	$("#descripcionFaltasDesa").attr('disabled' , 'disabled');	
	$("#descripcionViolenciaDesa").attr('disabled' , 'disabled');
	$("#descripcionDocumentacionDesa").attr('disabled' , 'disabled');
	$("#descripcionDocumentoDesa").attr('disabled' , 'disabled');
	$("#descripcionLlamadasDesa").attr('disabled' , 'disabled');
	$("#descripcionTransporteDesa").attr('disabled' , 'disabled');
	$("#descripcionHijosDesa").attr('disabled' , 'disabled');
	$('#btnExportarExp').prop("disabled", true);
}

function editarReportante(){
	 $("#btnCancelarReportante").prop("disabled", false);
	 $("#btnGuardarReportante").prop("disabled", false);
	 $('#btnEditarReportante').prop("disabled", true);
	 
	 $("#nombreRepoRead").prop("disabled", false);
	 $("#apaternoRepoRead").prop("disabled", false);
	 $("#amaternoRepoRead").prop("disabled", false);
	 $("#estadoRepoRead").prop("disabled", false);
	 $("#municipioRepoRead").prop("disabled", false);
	 $("#cpRepoRead").prop("disabled", false);
	 $("#coloniaRepoRead").prop("disabled", false);
	 $("#calleRepoRead").prop("disabled", false);
	 $("#edadRepoRead").prop("disabled", false);
	 $("#sexoRepoRead").prop("disabled", false);
	 $("#telefonoRepoRead").prop("disabled", false);
	 $("#correoRepoRead").prop("disabled", false);
	 $("#celular2RepoRead").prop("disabled", false);	 
	 $("#relacionRepoRead").prop("disabled", false);
	 $("#ocupacionRepoRead").prop("disabled", false);
	 $("#medioRepoRead").prop("disabled", false);
	 $("#nacionalidadRepoRead").prop("disabled", false);
	 $("#acompaniaRepoRead").prop("disabled", false);
	 if($('#identificacionRepoRead').length){
	 	$("#identificacionRepoRead").prop("disabled", false);
	 }
}

function cancelarReportante(){
	$('#btnEditarReportante').prop("disabled", false);
	$('#btnCancelarReportante').prop("disabled", true);
	$('#btnGuardarReportante').prop("disabled", true);
	
	$("#nombreRepoRead").prop("disabled", true);
	 $("#apaternoRepoRead").prop("disabled", true);
	 $("#amaternoRepoRead").prop("disabled", true);
	 $("#estadoRepoRead").prop("disabled", true);
	 $("#municipioRepoRead").prop("disabled", true);
	 $("#cpRepoRead").prop("disabled", true);
	 $("#coloniaRepoRead").prop("disabled", true);
	 $("#calleRepoRead").prop("disabled", true);
	 $("#edadRepoRead").prop("disabled", true);
	 $("#sexoRepoRead").prop("disabled", true);
	 $("#telefonoRepoRead").prop("disabled", true);
	 $("#correoRepoRead").prop("disabled", true);
	 $("#celular2RepoRead").prop("disabled", true);	 
	 $("#relacionRepoRead").prop("disabled", true);
	 $("#ocupacionRepoRead").prop("disabled", true);
	 $("#medioRepoRead").prop("disabled", true);
	 $("#nacionalidadRepoRead").prop("disabled", true);
	 $("#acompaniaRepoRead").prop("disabled", true);
	 if($('#identificacionRepoRead').length){
	 	$("#identificacionRepoRead").prop("disabled", true);
	 }
}

function saveFormReportanteEdit(event) {
	event.stopPropagation();
	event.preventDefault();
	var form = document.getElementById('formReportanteRead');
	var formData = new FormData(form);	
	var estado =  filtrarId("estadoRepoRead");
	var municipio =  filtrarId("municipioRepoRead");
	var cp =  filtrarId("cpRepoRead");
	formData.set("estadoRepoRead",estado);
	formData.set("municipioRepoRead",municipio);
	formData.set("cpRepoRead",cp);
	
	$.ajax({
		url :  'atencionciudadana/guardar-Reportante-Edit',
		type : 'POST',
		data : formData,
		cache : false,
		dataType : 'json',
		processData : false,
		contentType : false,
		success : function(data, textStatus, jqXHR) {
			if(data.estatus ===1){
				monstrarAlerta({message: data.descripcion, class:"info"});
				cancelarReportante();
			}else if(data.estatus ===-3){
				monstrarAlerta({message: data.descripcion, class:"danger"});
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			monstrarAlerta({message:"Ocurrio un inconveniente al realizar la peticion", class:"danger"});
		}
	});           
}

function eliminarArchivoEvi(idArchivoEvidencia) {
	console.info(idArchivoEvidencia);
	$('#eliminarEvidencia').modal('show');
	$("#btnEliminar").on('click',function(e){
	    $.ajax({
			url :  'atencionciudadana/eliminar-archivo-evidencia',
			type : 'post',
			data : 'idArchivoEvidencia='+idArchivoEvidencia,
			success : function(data, textStatus, jqXHR) {
				if(data.estatus ===1){		
					monstrarAlerta({message: data.descripcion, class:"info"});
				}else if(data.estatus ===-3){
					monstrarAlerta({message: data.descripcion, class:"danger"});
				}				
			},
			error : function(jqXHR, textStatus, errorThrown) {
				monstrarAlerta({message:"Ocurrio un inconveniente al realizar la peticion", class:"danger"});
			},
			complete : function(jqXHR, textStatus, errorThrown){
				$('#eliminarEvidencia').modal('hide');
				$('#trEvi'+idArchivoEvidencia+'').html("");
			}
		});
		
    });
}

/// Desaparecido

function leerDesaparecido(elemento){
	$('#municipioDesaparecidoDesa').empty();
	$('#cpDesaparecidoDesa').empty();
	$('#coloniaDesaparecidoDesa').empty();
					
	let inputMunicipioDesa = $("#municipioDesaparecidoDesa");
	let inputcpDesa = $("#cpDesaparecidoDesa");	
	let inputColoniaDesa = $("#coloniaDesaparecidoDesa");
				
	inputMunicipioDesa.append('<option value="">Selecciona...</option>');
	inputcpDesa.append('<option value="">Selecciona...</option>');
	inputColoniaDesa.append('<option value="">Selecciona...</option>');
	
	if(null !== elemento.anidadosDto && null !== elemento.anidadosDto.municipiosDesa){
		$.each(elemento.anidadosDto.municipiosDesa, function(index, elemento) {
			inputMunicipioDesa.append('<option value="' + elemento.codigoMunicipio +'">' + elemento.municipioDetalle + '</option>');
		});		
	}
	/*if(null !== elemento.anidadosDto.cpsDesa){
		$.each(elemento.anidadosDto.cpsDesa, function(index, elemento) {
			inputcpDesa.append('<option value="' + elemento.idCp +'&'+elemento.codigoCp +'">' + elemento.codigoCp + '</option>');
		});		
	}
	if(null !== elemento.anidadosDto && null !== elemento.anidadosDto.coloniasDesa){
		$.each(elemento.anidadosDto.coloniasDesa, function(index, elemento) {
			inputColoniaDesa.append('<option value="' + elemento.idColonia +'">' + elemento.coloniaDetalle + '</option>');
		});		
	} */
	
	//personal
	
//$("#idDesaparecidoDesa").val( null === elemento.personaDesaparecida.idPersonaDesaparecida? undefined:elemento.personaDesaparecida.idPersonaDesaparecida );
//$("#declaranteDesa").val( null === elemento.personaDesaparecida.personaReporta? undefined:elemento.personaDesaparecida.personaReporta.idPersonaReporta );
	$("#nombreDesaparecidoDesa").val( null === elemento.personaDesaparecida.nombre? undefined:elemento.personaDesaparecida.nombre );
	$("#apellidoPaternoDesaparecidoDesa").val( null === elemento.personaDesaparecida.apaterno? undefined:elemento.personaDesaparecida.apaterno );
	$("#apellidoMaternoDesaparecidoDesa").val( null === elemento.personaDesaparecida.amaterno? undefined:elemento.personaDesaparecida.amaterno );	
	$("#fechaNacimientoDesa").val( null === elemento.personaDesaparecida.fecha_nacimiento? undefined:elemento.personaDesaparecida.fecha_nacimiento );
	$("#edadDesaparecidoDesa").val( null === elemento.personaDesaparecida.id_edad? undefined:elemento.personaDesaparecida.id_edad );
	$("#sexoDesaparecidoDesa").val( null === elemento.personaDesaparecida.id_sexo? undefined:elemento.personaDesaparecida.id_sexo );
	$("#curpDesa").val( null === elemento.personaDesaparecida.curp? undefined:elemento.personaDesaparecida.curp );
	$("#rfcDesa").val( null === elemento.personaDesaparecida.rfc? undefined:elemento.personaDesaparecida.rfc );
	$("#estadoCivilDesa").val( null === elemento.personaDesaparecida.id_estado_civil? undefined:elemento.personaDesaparecida.id_estado_civil );
	$("#ocupacionDesaparecidoDesa").val( null === elemento.personaDesaparecida.ocupacion? undefined:elemento.personaDesaparecida.ocupacion );
	$("#habitantesDesa").val( null === elemento.personaDesaparecida.con_quien_habita? undefined:elemento.personaDesaparecida.con_quien_habita );
//$("#carpetaInvestigacionDesa").val( null === elemento.expediente.carpetaInvestigacion? undefined:elemento.expediente.carpetaInvestigacion );
	$("#nacionalidadDesaparecidoDesa").val( null === elemento.personaDesaparecida.nacionalidad? undefined:elemento.personaDesaparecida.nacionalidad );
	$("#estadoDesaparecidoDesa").val( null === elemento.personaDesaparecida.codigo_estado? undefined:elemento.personaDesaparecida.codigo_estado );
	$("#municipioDesaparecidoDesa").val( null === elemento.personaDesaparecida.codigo_municipio? undefined:elemento.personaDesaparecida.codigo_municipio );
	$("#cpDesaparecidoDesa").val( null === elemento.personaDesaparecida.id_cp? undefined:elemento.personaDesaparecida.id_cp );
	$("#coloniaDesaparecidoDesa").val( null === elemento.personaDesaparecida.catColonia? undefined:elemento.personaDesaparecida.colonia );
	$("#calleDesaparecidoDesa").val( null === elemento.personaDesaparecida.calle? undefined:elemento.personaDesaparecida.calle );
	//desc fisica
	$("#colorOjosDesa").val( null === elemento.personaDesaparecida.id_color_ojo? undefined:elemento.personaDesaparecida.id_color_ojo );
//$("#tipoOjosDesa").val( null === elemento.personaDesaparecida.catTipoOjo? undefined:elemento.personaDesaparecida.catTipoOjo.idTipoOjo );
//$("#ojoDesa").val( null === elemento.personaDesaparecida.detalleOjo? undefined:elemento.personaDesaparecida.detalleOjo );
	$("#colorCabelloDesa").val( null === elemento.personaDesaparecida.id_color_cabello? undefined:elemento.personaDesaparecida.id_color_cabello );
	$("#longitudDesa").val( null === elemento.personaDesaparecida.id_longitud_cabello? undefined:elemento.personaDesaparecida.id_longitud_cabello );
	$("#tipoCabelloDesa").val( null === elemento.personaDesaparecida.id_tipo_cabello? undefined:elemento.personaDesaparecida.id_tipo_cabello );
//$("#cabelloDesa").val( null === elemento.personaDesaparecida.descripcionCabello? undefined:elemento.personaDesaparecida.descripcionCabello );
	$("#frenteDesa").val( null === elemento.personaDesaparecida.id_frente? undefined:elemento.personaDesaparecida.id_frente );
	$("#bocaDesa").val( null === elemento.personaDesaparecida.id_boca? undefined:elemento.personaDesaparecida.id_boca );
		//$("#dBocaDesa").val( null === elemento.personaDesaparecida.dBoca? undefined:elemento.personaDesaparecida.dBoca );
	$("#labiosDesa").val( null === elemento.personaDesaparecida.id_labio? undefined:elemento.personaDesaparecida.id_labio );
	$("#dentaduraDesa").val( null === elemento.personaDesaparecida.id_dentadura? undefined:elemento.personaDesaparecida.id_dentadura );
	$("#detalleDentaduraDesa").val( null === elemento.personaDesaparecida.detalle_dentadura? undefined:elemento.personaDesaparecida.detalle_dentadura );
	$("#baseNarizDesa").val( null === elemento.personaDesaparecida.id_base_nariz? undefined:elemento.personaDesaparecida.id_base_nariz );
	$("#formaDesa").val( null === elemento.personaDesaparecida.id_forma_nariz? undefined:elemento.personaDesaparecida.id_forma_nariz );
//$("#tamanioDesa").val( null === elemento.personaDesaparecida.catTamanioNariz? undefined:elemento.personaDesaparecida.catTamanioNariz.idTamanioNariz );
//$("#dNarizDesa").val( null === elemento.personaDesaparecida.personaReporta? undefined:elemento.personaDesaparecida.personaReporta.idPersonaReporta );
	$("#complexionDesa").val( null === elemento.personaDesaparecida.id_complexion? undefined:elemento.personaDesaparecida.id_complexion );
	$("#pesoDesa").val( null === elemento.personaDesaparecida.peso? undefined:elemento.personaDesaparecida.peso );
	$("#estaturaDesa").val( null === elemento.personaDesaparecida.estatura? undefined:elemento.personaDesaparecida.estatura );
	$("#colorPielDesa").val( null === elemento.personaDesaparecida.id_tez? undefined:elemento.personaDesaparecida.id_tez );
	$("#seniasDesa").val( null === elemento.personaDesaparecida.senia_particular? undefined:elemento.personaDesaparecida.senia_particular );
	$('#divFotografiaDesa').html("");
	if(null===elemento.archivoFotoPersona){
		let htmlFotografia = 'Sin fotografia';
		$('#divFotografiaDesa').html(htmlFotografia);
	}else{
	
		let htmlFotografia = '	<a href="data:'+elemento.archivoFotoPersona.mime+';base64,'+elemento.archivoFotoPersona.archivo+'" download="'+elemento.archivoFotoPersona.nombre+elemento.archivoFotoPersona.extencion+'" id="fotoPersona'+'">Ver Fotografia <button type="button" class="btn btn-info btn-circle"><span class="fa fa-eye"></span></button> </a>';
		$('#divFotografiaDesa').html(htmlFotografia);			
	}
	
	//salud fisica
	$("#sangreDesa").val( null === elemento.personaDesaparecida.id_tipo_sangre? undefined:elemento.personaDesaparecida.id_tipo_sangre );
	$("#adiccionesDesa").val( null === elemento.personaDesaparecida.adiccion? undefined:elemento.personaDesaparecida.adiccion );
//$("#periodicidadDesa").val( null === elemento.personaDesaparecida.catPeriodicidad? undefined:elemento.personaDesaparecida.catPeriodicidad.idPeriodicidad );
//$("#operacionesDesa").val( null === elemento.personaDesaparecida.operaciones? undefined:elemento.personaDesaparecida.operaciones.idSiNo );
//$("#descripcionOperacionesDesa").val( null === elemento.personaDesaparecida.detalleOperacion? undefined:elemento.personaDesaparecida.detalleOperacion );
//$("#discapacidadDesa").val( null === elemento.personaDesaparecida.padecimientoDiscapacidad? undefined:elemento.personaDesaparecida.padecimientoDiscapacidad );
//$("#descripcionDiscapacidadDesa").val( null === elemento.personaDesaparecida.detallePadecimiento? undefined:elemento.personaDesaparecida.detallePadecimiento );
	$("#fracturasDesa").val( null === elemento.personaDesaparecida.tiene_fractura? undefined:elemento.personaDesaparecida.tiene_fractura );
  $("#descripcionFracturasDesa").val( null === elemento.personaDesaparecida.detalle_factura? undefined:elemento.personaDesaparecida.detalle_factura );
	//hechos
	$("#fechaDesaparicionDesa").val( null === elemento.personaDesaparecida.fechaDesaparcion? undefined:elemento.personaDesaparecida.fecha_desaparicion );
	$("#fechaUltimoContactoDesa").val( null === elemento.personaDesaparecida.fecha_ultimo_contacto? undefined:elemento.personaDesaparecida.fecha_ultimo_contacto );
	$("#lugarDesaparicionDesa").val( null === elemento.personaDesaparecida.lugar_desaparicion? undefined:elemento.personaDesaparecida.lugar_desaparicion );
	$("#ultimoMedioDesa").val( null === elemento.personaDesaparecida.ultimo_medio_contacto? undefined:elemento.personaDesaparecida.ultimo_medio_contacto );
	$("#personaQueVioUltimaVezDesa").val( null === elemento.personaDesaparecida.persona_vio_ultima_vez? undefined:elemento.personaDesaparecida.persona_vio_ultima_vez );
	$("#dondeIbaDesa").val( null === elemento.personaDesaparecida.a_donde_iba? undefined:elemento.personaDesaparecida.a_donde_iba );
	$("#lugaresDesa").val( null === elemento.personaDesaparecida.lugar_frecuente? undefined:elemento.personaDesaparecida.lugar_frecuente );
	$("#enemistadesDesa").val( null === elemento.personaDesaparecida.enemistad? undefined:elemento.personaDesaparecida.enemistad );
//$("#sospechosoDesa").val( null === elemento.personaDesaparecida.sospecho? undefined:elemento.personaDesaparecida.sospecho );
	$("#actitudDesa").val( null === elemento.personaDesaparecida.actitud_extrania? undefined:elemento.personaDesaparecida.actitud_extrania );
	$("#faltasDesa").val( null === elemento.personaDesaparecida.falta_a_casa? undefined:elemento.personaDesaparecida.falta_a_casa );
	$("#descripcionFaltasDesa").val( null === elemento.personaDesaparecida.detalle_falta_a_casa? undefined:elemento.personaDesaparecida.detalle_falta_a_casa );
	$("#violenciaDesa").val( null === elemento.personaDesaparecida.presento_violencia? undefined:elemento.personaDesaparecida.presento_violencia );
	$("#descripcionViolenciaDesa").val( null === elemento.personaDesaparecida.detalle_violencia? undefined:elemento.personaDesaparecida.detalle_violencia );
	$("#descripcionGeneralDesa").val( null === elemento.personaDesaparecida.hechos? undefined:elemento.personaDesaparecida.hechos );
	//pertenencias
	$("#vestimentaDesa").val( null === elemento.personaDesaparecida.vestimenta? undefined:elemento.personaDesaparecida.vestimenta );
	$("#documentacionDesa").val( null === elemento.personaDesaparecida.llevo_documento? undefined:elemento.personaDesaparecida.llevo_documento );
	$("#descripcionDocumentacionDesa").val( null === elemento.personaDesaparecida.detalle_documento? undefined:elemento.personaDesaparecida.detalle_documento );
	$("#documentoDesa").val( null === elemento.personaDesaparecida.dejo_documento? undefined:elemento.personaDesaparecida.dejo_documento );
	$("#descripcionDocumentoDesa").val( null === elemento.personaDesaparecida.detalle_dejo_documento? undefined:elemento.personaDesaparecida.detalle_dejo_documento );
	$("#llamadasDesa").val( null === elemento.personaDesaparecida.hubo_antecedente? undefined:elemento.personaDesaparecida.hubo_antecedente );
	$("#descripcionLlamadasDesa").val( null === elemento.personaDesaparecida.detalle_comunicacion? undefined:elemento.personaDesaparecida.detalle_comunicacion );
	$("#transporteDesa").val( null === elemento.personaDesaparecida.transporte_frecuente? undefined:elemento.personaDesaparecida.transporte_frecuente );
	$("#descripcionTransporteDesa").val( null === elemento.personaDesaparecida.detalle_transporte? undefined:elemento.personaDesaparecida.detalle_transporte );
	// redes
	$("#correoDesa").val( null === elemento.personaDesaparecida.correo_electronico? undefined:elemento.personaDesaparecida.correo_electronico );
	$("#contraseniaCorreoDesa").val( null === elemento.personaDesaparecida.contrasenia_correo? undefined:elemento.personaDesaparecida.contrasenia_correo );
	$("#facebookDesa").val( null === elemento.personaDesaparecida.facebook? undefined:elemento.personaDesaparecida.facebook );
	$("#contraseniaFacebookDesa").val( null === elemento.personaDesaparecida.contrasenia_facebook? undefined:elemento.personaDesaparecida.contrasenia_facebook );
	$("#twitterDesa").val( null === elemento.personaDesaparecida.twitter? undefined:elemento.personaDesaparecida.twitter );
	$("#contraseniaTwitterDesa").val( null === elemento.personaDesaparecida.contrasenia_twitter? undefined:elemento.personaDesaparecida.contrasenia_twitter );
	$("#instagramDesa").val( null === elemento.personaDesaparecida.instragram? undefined:elemento.personaDesaparecida.instragram );
	$("#contraseniaInstagramDesa").val( null === elemento.personaDesaparecida.contrasenia_instagram? undefined:elemento.personaDesaparecida.contrasenia_instagram );
	//info adicional
	$("#hijosDesa").val( null === elemento.personaDesaparecida.tiene_hijos? undefined:elemento.personaDesaparecida.tiene_hijos );
	$("#descripcionHijosDesa").val( null === elemento.personaDesaparecida.detalle_hijos? undefined:elemento.personaDesaparecida.detalle_hijos );
	$("#pasatiemposDesa").val( null === elemento.personaDesaparecida.pasatiempo? undefined:elemento.personaDesaparecida.pasatiempo );
//$("#dialectoDesa").val( null === elemento.personaDesaparecida.catDialecto? undefined:elemento.personaDesaparecida.catDialecto.idDialecto );
//$("#grupoDesa").val( null === elemento.personaDesaparecida.catGrupoEtnico? undefined:elemento.personaDesaparecida.catGrupoEtnico.idGrupoEtnico );
//$("#estatusEconomicoDesa").val( null === elemento.personaDesaparecida.catEstatusEconomico? undefined:elemento.personaDesaparecida.catEstatusEconomico.idEstatusEconomico );
//$("#difusionDesa").val( null === elemento.personaDesaparecida.difusion? undefined:elemento.personaDesaparecida.difusion );
	$("#constanciaDesa").val( null === elemento.personaDesaparecida.consta_hecho? undefined:elemento.personaDesaparecida.consta_hecho );
/*
	$("#operacionesDesa").attr('disabled' , 'disabled');
	$("#discapacidadDesa").attr('disabled' , 'disabled');
	$("#fracturasDesa").attr('disabled' , 'disabled');
	$("#faltasDesa").attr('disabled' , 'disabled');	
	$("#violenciaDesa").attr('disabled' , 'disabled');
	$("#documentacionDesa").attr('disabled' , 'disabled');
	$("#documentoDesa").attr('disabled' , 'disabled');
	$("#llamadasDesa").attr('disabled' , 'disabled');
	$("#transporteDesa").attr('disabled' , 'disabled');
	$("#hijosDesa").attr('disabled' , 'disabled');
 */
}

function editarDesaparecido(){

 $("#btnGuardarDesaparecido").prop("disabled", false);
 $("#btnCancelarDesaparecido").prop("disabled", false);
 $('#btnEditarDesaparecido').prop("disabled", true);

/// Personales
 $("#declaranteDesa").prop("disabled", false);
 $("#nombreDesaparecidoDesa").prop("disabled", false);
 $("#apellidoPaternoDesaparecidoDesa").prop("disabled", false);
 $("#apellidoMaternoDesaparecidoDesa").prop("disabled", false);
 $("#fechaNacimientoDesa").prop("disabled", false);
 $("#edadDesaparecidoDesa").prop("disabled", false);
 $("#sexoDesaparecidoDesa").prop("disabled", false);
 $("#curpDesa").prop("disabled", false);
 $("#rfcDesa").prop("disabled", false);
 $("#estadoCivilDesa").prop("disabled", false);
 $("#ocupacionDesaparecidoDesa").prop("disabled", false);
 $("#habitantesDesa").prop("disabled", false);
 $("#carpetaInvestigacionDesa").prop("disabled", false);
 $("#nacionalidadDesaparecidoDesa").prop("disabled", false);
 $("#estadoDesaparecidoDesa").prop("disabled", false);
 $("#municipioDesaparecidoDesa").prop("disabled", false);
 $("#cpDesaparecidoDesa").prop("disabled", false);
 $("#coloniaDesaparecidoDesa").prop("disabled", false);
 $("#calleDesaparecidoDesa").prop("disabled", false);
 /// Desc Fisica
 $("#colorOjosDesa").prop("disabled", false);
 $("#tipoOjosDesa").prop("disabled", false);
 $("#ojoDesa").prop("disabled", false);
 $("#colorCabelloDesa").prop("disabled", false);
 $("#longitudDesa").prop("disabled", false);
 $("#tipoCabelloDesa").prop("disabled", false);
 $("#cabelloDesa").prop("disabled", false);
 $("#frenteDesa").prop("disabled", false);
 $("#bocaDesa").prop("disabled", false);
 //$("#dBocaDesa").prop("disabled", false);
 $("#labiosDesa").prop("disabled", false);
 $("#dentaduraDesa").prop("disabled", false);
 $("#detalleDentaduraDesa").prop("disabled", false);
 $("#baseNarizDesa").prop("disabled", false);
 $("#formaDesa").prop("disabled", false);
 $("#tamanioDesa").prop("disabled", false);
 //$("#dNarizDesa").prop("disabled", false);
 $("#pesoDesa").prop("disabled", false);
 $("#complexionDesa").prop("disabled", false);
 $("#estaturaDesa").prop("disabled", false);
 $("#colorPielDesa").prop("disabled", false)
 $("#seniasDesa").prop("disabled", false);
 $("#fotografiaDesa").prop("disabled", false) 
 // salud fisica
 $("#sangreDesa").prop("disabled", false);
 $("#adiccionesDesa").prop("disabled", false);
 $("#periodicidadDesa").prop("disabled", false);
 $("#operacionesDesa").prop("disabled", false);
 $("#descripcionOperacionesDesa").prop("disabled", false);
 $("#discapacidadDesa").prop("disabled", false);
 $("#descripcionDiscapacidadDesa").prop("disabled", false);
 $("#fracturasDesa").prop("disabled", false);
 $("#descripcionFracturasDesa").prop("disabled", false);
/// hechos
 $("#fechaDesaparicionDesa").prop("disabled", false);
 $("#fechaUltimoContactoDesa").prop("disabled", false);
 $("#lugarDesaparicionDesa").prop("disabled", false);
 $("#ultimoMedioDesa").prop("disabled", false);
 $("#personaQueVioUltimaVezDesa").prop("disabled", false);
 $("#dondeIbaDesa").prop("disabled", false);
 $("#lugaresDesa").prop("disabled", false);
 $("#enemistadesDesa").prop("disabled", false);
 $("#sospechosoDesa").prop("disabled", false);
 $("#actitudDesa").prop("disabled", false);
 $("#faltasDesa").prop("disabled", false);
 $("#descripcionFaltasDesa").prop("disabled", false);
 $("#violenciaDesa").prop("disabled", false);
 $("#descripcionViolenciaDesa").prop("disabled", false);
 $("#descripcionGeneralDesa").prop("disabled", false); 
 /// pertenencias 
 $("#vestimentaDesa").prop("disabled", false);
 $("#documentacionDesa").prop("disabled", false);
 $("#descripcionDocumentacionDesa").prop("disabled", false);
 $("#documentoDesa").prop("disabled", false);
 $("#descripcionDocumentoDesa").prop("disabled", false);
 $("#llamadasDesa").prop("disabled", false);
 $("#descripcionLlamadasDesa").prop("disabled", false);
 $("#transporteDesa").prop("disabled", false);
 $("#descripcionTransporteDesa").prop("disabled", false); 
 // redes sociales
 $("#correoDesa").prop("disabled", false);
 $("#contraseniaCorreoDesa").prop("disabled", false);
 $("#facebookDesa").prop("disabled", false);
 $("#contraseniaFacebookDesa").prop("disabled", false);
 $("#twitterDesa").prop("disabled", false);
 $("#contraseniaTwitterDesa").prop("disabled", false);
 $("#instagramDesa").prop("disabled", false);
 $("#contraseniaInstagramDesa").prop("disabled", false); 
 // informacion adicional
 $("#hijosDesa").prop("disabled", false);
 $("#descripcionHijosDesa").prop("disabled", false);
 $("#pasatiemposDesa").prop("disabled", false);
 $("#dialectoDesa").prop("disabled", false);
 $("#grupoDesa").prop("disabled", false);
 $("#estatusEconomicoDesa").prop("disabled", false);
 $("#difusionDesa").prop("disabled", false);
 $("#constanciaDesa").prop("disabled", false);
 
	//activar desactivar texareas por valor combo
	desbloquearEdit("operacionesDesa","#descripcionOperacionesDesa");
	desbloquearEdit("discapacidadDesa","#descripcionDiscapacidadDesa");
	desbloquearEdit("fracturasDesa","#descripcionFracturasDesa");
	desbloquearEdit("faltasDesa","#descripcionFaltasDesa");
	desbloquearEdit("violenciaDesa","#descripcionViolenciaDesa");
	desbloquearEdit("documentacionDesa","#descripcionDocumentacionDesa");
	desbloquearEdit("documentoDesa","#descripcionDocumentoDesa");
	desbloquearEdit("llamadasDesa","#descripcionLlamadasDesa");
	desbloquearEdit("transporteDesa","#descripcionTransporteDesa");
	desbloquearEdit("hijosDesa","#descripcionHijosDesa");
 
}



function cancelarDesaparecido(){
 $("#btnGuardarDesaparecido").prop("disabled", true);
 $("#btnCancelarDesaparecido").prop("disabled", true);
 $('#btnEditarDesaparecido').prop("disabled", false);
 
 /// Personales
 $("#declaranteDesa").prop("disabled", true);
 $("#nombreDesaparecidoDesa").prop("disabled", true);
 $("#apellidoPaternoDesaparecidoDesa").prop("disabled", true);
 $("#apellidoMaternoDesaparecidoDesa").prop("disabled", true);
 $("#fechaNacimientoDesa").prop("disabled", true);
 $("#edadDesaparecidoDesa").prop("disabled", true);
 $("#sexoDesaparecidoDesa").prop("disabled", true);
 $("#curpDesa").prop("disabled", true);
 $("#rfcDesa").prop("disabled", true);
 $("#estadoCivilDesa").prop("disabled", true);
 $("#ocupacionDesaparecidoDesa").prop("disabled", true);
 $("#habitantesDesa").prop("disabled", true);
 $("#carpetaInvestigacionDesa").prop("disabled", true);
 $("#nacionalidadDesaparecidoDesa").prop("disabled", true);
 $("#estadoDesaparecidoDesa").prop("disabled", true);
 $("#municipioDesaparecidoDesa").prop("disabled", true);
 $("#cpDesaparecidoDesa").prop("disabled", true);
 $("#coloniaDesaparecidoDesa").prop("disabled", true);
 $("#calleDesaparecidoDesa").prop("disabled", true); 
 /// Desc Fisica
 $("#colorOjosDesa").prop("disabled", true);
 $("#tipoOjosDesa").prop("disabled", true);
 $("#ojoDesa").prop("disabled", true);
 $("#colorCabelloDesa").prop("disabled", true);
 $("#longitudDesa").prop("disabled", true);
 $("#tipoCabelloDesa").prop("disabled", true);
 $("#cabelloDesa").prop("disabled", true);
 $("#frenteDesa").prop("disabled", true);
 $("#bocaDesa").prop("disabled", true);
 //$("#dBocaDesa").prop("disabled", true);
 $("#labiosDesa").prop("disabled", true);
 $("#dentaduraDesa").prop("disabled", true);
 $("#detalleDentaduraDesa").prop("disabled", true);
 $("#baseNarizDesa").prop("disabled", true);
 $("#formaDesa").prop("disabled", true);
 $("#tamanioDesa").prop("disabled", true);
 //$("#dNarizDesa").prop("disabled", true);
 $("#pesoDesa").prop("disabled", true);
 $("#complexionDesa").prop("disabled", true);
 $("#estaturaDesa").prop("disabled", true);
 $("#colorPielDesa").prop("disabled", true)
 $("#seniasDesa").prop("disabled", true);
 $("#fotografiaDesa").prop("disabled", true) 
 // salud fisica
 $("#sangreDesa").prop("disabled", true);
 $("#adiccionesDesa").prop("disabled", true);
 $("#periodicidadDesa").prop("disabled", true);
 $("#operacionesDesa").prop("disabled", true);
 $("#descripcionOperacionesDesa").prop("disabled", true);
 $("#discapacidadDesa").prop("disabled", true);
 $("#descripcionDiscapacidadDesa").prop("disabled", true);
 $("#fracturasDesa").prop("disabled", true);
 $("#descripcionFracturasDesa").prop("disabled", true);
/// hechos
 $("#fechaDesaparicionDesa").prop("disabled", true);
 $("#fechaUltimoContactoDesa").prop("disabled", true);
 $("#lugarDesaparicionDesa").prop("disabled", true);
 $("#ultimoMedioDesa").prop("disabled", true);
 $("#personaQueVioUltimaVezDesa").prop("disabled", true);
 $("#dondeIbaDesa").prop("disabled", true);
 $("#lugaresDesa").prop("disabled", true);
 $("#enemistadesDesa").prop("disabled", true);
 $("#sospechosoDesa").prop("disabled", true);
 $("#actitudDesa").prop("disabled", true);
 $("#faltasDesa").prop("disabled", true);
 $("#descripcionFaltasDesa").prop("disabled", true);
 $("#violenciaDesa").prop("disabled", true);
 $("#descripcionViolenciaDesa").prop("disabled", true);
 $("#descripcionGeneralDesa").prop("disabled", true); 
 /// pertenencias 
 $("#vestimentaDesa").prop("disabled", true);
 $("#documentacionDesa").prop("disabled", true);
 $("#descripcionDocumentacionDesa").prop("disabled", true);
 $("#documentoDesa").prop("disabled", true);
 $("#descripcionDocumentoDesa").prop("disabled", true);
 $("#llamadasDesa").prop("disabled", true);
 $("#descripcionLlamadasDesa").prop("disabled", true);
 $("#transporteDesa").prop("disabled", true);
 $("#descripcionTransporteDesa").prop("disabled", true); 
 // redes sociales
 $("#correoDesa").prop("disabled", true);
 $("#contraseniaCorreoDesa").prop("disabled", true);
 $("#facebookDesa").prop("disabled", true);
 $("#contraseniaFacebookDesa").prop("disabled", true);
 $("#twitterDesa").prop("disabled", true);
 $("#contraseniaTwitterDesa").prop("disabled", true);
 $("#instagramDesa").prop("disabled", true);
 $("#contraseniaInstagramDesa").prop("disabled", true); 
 // informacion adicional
 $("#hijosDesa").prop("disabled", true);
 $("#descripcionHijosDesa").prop("disabled", true);
 $("#pasatiemposDesa").prop("disabled", true);
 $("#dialectoDesa").prop("disabled", true);
 $("#grupoDesa").prop("disabled", true);
 $("#estatusEconomicoDesa").prop("disabled", true);
 $("#difusionDesa").prop("disabled", true);
 $("#constanciaDesa").prop("disabled", true);
}

function refrescarReportantes(idComboRepo) {
	$.ajax({
		url: "atencionciudadana/reportantes",
		type: 'POST',
		success: function(respuesta) {
			$('#'+idComboRepo+'').empty();
			var comboRepo = $('#'+idComboRepo+'');
			comboRepo.append('<option value="">Selecciona...</option>');
			$.each(respuesta, function(index, elemento) {
				if(elemento.nombre==null){
					elemento.nombre= "";
				} 
				
				if (elemento.apaterno==null){
					elemento.apaterno="";
				}
				
				if (elemento.amaterno==null){
					elemento.amaterno="";
				}
				
				if (elemento.nombre=="" && elemento.apaterno== "" && elemento.amaterno== "" ){
				comboRepo.append('<option value="' + elemento.idPersonaReporta + '">' + elemento.telefono1 + '</option>');
				} else {				
				comboRepo.append('<option value="' + elemento.idPersonaReporta + '">' + elemento.nombre + ' ' + elemento.apaterno + ' ' + elemento.amaterno + '</option>');
				}
				
			});
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});
}



function saveFormDesaparecidoEdit(event) {

	event.stopPropagation();
	event.preventDefault();
	var form = document.getElementById('formDesaparecidoRead');
	var formData = new FormData(form);	
	var estado =  filtrarId("estadoDesaparecidoDesa");
	var municipio =  filtrarId("municipioDesaparecidoDesa");
	var cp =  filtrarId("cpDesaparecidoDesa");
	let idExpedienteConsulta = document.getElementById("expedienteConsulta").value;
	formData.set("estadoDesaparecidoDesa",estado);
	formData.set("municipioDesaparecidoDesa",municipio);
	formData.set("cpDesaparecidoDesa",cp);
	formData.set("idExpediente",idExpedienteConsulta);
	
	$.ajax({
		url :  'atencionciudadana/guardar-Desaparecido-Edit',
		type : 'POST',
		data : formData,
		cache : false,
		dataType : 'json',
		processData : false,
		contentType : false,
		success : function(data, textStatus, jqXHR) {
			if(data.estatus ===1){
				monstrarAlerta({message: data.descripcion, class:"info"});
				cancelarDesaparecido();
			}else if(data.estatus ===-3){
				monstrarAlerta({message: data.descripcion, class:"danger"});
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			monstrarAlerta({message:"Ocurrio un inconveniente al realizar la peticion", class:"danger"});
		}
	});        
}

function cargarMunicipioDesaRead() {
	var valueEstado = filtrarValor("estadoDesaparecidoDesa");
	$.ajax({
		url: "atencionciudadana/municipios-por-estado",
		type: 'POST',
		data: 'codigoEstado='+valueEstado,
		success: function(respuesta) {
		
			$('#municipioDesaparecidoDesa').empty();
			$('#cpDesaparecidoDesa').empty();
			$('#coloniaDesaparecidoDesa').empty();			
			var inputMunicipioDesaRead = $("#municipioDesaparecidoDesa");
			var inputCpDesaRead = $("#cpDesaparecidoDesa");
			var inputColoniaDesaRead = $("#coloniaDesaparecidoDesa");			
			inputMunicipioDesaRead.append('<option value="">Selecciona...</option>');
			inputCpDesaRead.append('<option value="">Selecciona...</option>');
			inputColoniaDesaRead.append('<option value="">Selecciona...</option>');
			
			$.each(respuesta, function(index, elemento) {
				inputMunicipioDesaRead.append('<option value="' +elemento.codigoMunicipio+'">' + elemento.municipioDetalle + '</option>');
			});
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});
}

function cargarCpDesaRead() {
	var valueEstado = filtrarValor("estadoDesaparecidoDesa");
	var valueMunicipio = filtrarValor("municipioDesaparecidoDesa");
	var datos = 'codigoEstado='+ valueEstado + '&codigoMunicipio='+ valueMunicipio;
	$.ajax({
		url: "atencionciudadana/cp-por-estado-municipios",
		type: 'POST',
		data: datos,
		success: function(respuesta) {
		
			$('#cpDesaparecidoDesa').empty();
			$('#coloniaDesaparecidoDesa').empty();			
			var inputCpDesaRead = $("#cpDesaparecidoDesa");
			var inputColoniaDesaRead = $("#coloniaDesaparecidoDesa");			
			inputCpDesaRead.append('<option value="">Selecciona...</option>');
			inputColoniaDesaRead.append('<option value="">Selecciona...</option>');
			
			$.each(respuesta, function(index, elemento) {
				inputCpDesaRead.append('<option value="' + elemento.idCp +'&'+elemento.codigoCp +'">' + elemento.codigoCp + '</option>');
			});
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});
}

function cargarColoniaDesaRead() {
	var valueCp = filtrarValor("cpDesaparecidoDesa");
	$.ajax({
		url: "atencionciudadana/colonia-por-cp",
		type: 'POST',
		data: 'codigoCp='+valueCp,
		success: function(respuesta) {
			$('#coloniaDesaparecidoDesa').empty();
			var inputColoniaDesaRead = $("#coloniaDesaparecidoDesa");
			inputColoniaDesaRead.append('<option value="">Selecciona...</option>');
			$.each(respuesta, function(index, elemento) {
				inputColoniaDesaRead.append('<option value="' + elemento.idColonia +'">' + elemento.coloniaDetalle + '</option>');
			});
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});

}

function desbloquearEdit(combo, textArea) {

	var valorCombo = document.getElementById(combo).value;
	
	if (combo !== ("transporteDesa")) {
		if (valorCombo ==="2") {
			$(textArea).removeAttr('disabled');
		} else {
			$(textArea).attr('disabled',  'disabled');
		}
	} else {
		if (valorCombo !== "" && valorCombo !== "6") {
			$(textArea).removeAttr('disabled');
		} else {
		 $(textArea).attr('disabled',  'disabled');
		}
	}

}

function cargarMunicipioActa() {
	let valueEstado = filtrarValor("estadoActa");
	$.ajax({
		url: "atencionciudadana/municipios-por-estado",
		type: 'POST',
		data: 'codigoEstado='+valueEstado,
		success: function(respuesta) {
		
			$('#municipioActa').empty();
			$('#cpActa').empty();
			$('#coloniaActa').empty();			
			let inputMunicipioRepoRead = $("#municipioActa");
			let inputCpRepoRead = $("#cpActa");
			let inputColoniaRepoRead = $("#coloniaActa");			
			inputMunicipioRepoRead.append('<option value="">Selecciona...</option>');
			inputCpRepoRead.append('<option value="">Selecciona...</option>');
			inputColoniaRepoRead.append('<option value="">Selecciona...</option>');
			
			$.each(respuesta, function(index, elemento) {
				inputMunicipioRepoRead.append('<option value="' +elemento.idMunicipio+'&'+elemento.codigoMunicipio+'">' + elemento.municipioDetalle + '</option>');
			});
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});
}

function cargarCpActa() {
	let valueEstado = filtrarValor("estadoActa");
	let valueMunicipio = filtrarValor("municipioActa");
	var datos = 'codigoEstado='+ valueEstado + '&codigoMunicipio='+ valueMunicipio;
	$.ajax({
		url: "atencionciudadana/cp-por-estado-municipios",
		type: 'POST',
		data: datos,
		success: function(respuesta) {
		
			$('#cpActa').empty();
			$('#coloniaActa').empty();			
			let inputCpRepoRead = $("#cpActa");
			let inputColoniaRepoRead = $("#coloniaActa");			
			inputCpRepoRead.append('<option value="">Selecciona...</option>');
			inputColoniaRepoRead.append('<option value="">Selecciona...</option>');
			
			$.each(respuesta, function(index, elemento) {
				inputCpRepoRead.append('<option value="' + elemento.idCp +'&'+elemento.codigoCp +'">' + elemento.codigoCp + '</option>');
			});
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});
}

function cargarColoniaActa() {
	let valueCp = filtrarValor("cpActa");
	$.ajax({
		url: "atencionciudadana/colonia-por-cp",
		type: 'POST',
		data: 'codigoCp='+valueCp,
		success: function(respuesta) {
			$('#coloniaActa').empty();
			let inputColoniaRepoRead = $("#coloniaActa");
			inputColoniaRepoRead.append('<option value="">Selecciona...</option>');
			$.each(respuesta, function(index, elemento) {
				inputColoniaRepoRead.append('<option value="' + elemento.idColonia +'">' + elemento.coloniaDetalle + '</option>');
			});
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});

}

function guardarActaEntrevista(event) {
	event.stopPropagation();
	event.preventDefault();
	
	let form = document.getElementById('formActaEntrevista');
	let formData = new FormData(form);
	let estadoActa = filtrarId("estadoActa");
	let municipioActa = filtrarId("municipioActa");
	let cpActa = filtrarId("cpActa");
	
	formData.set("estadoActa", estadoActa);
	formData.set("municipioActa", municipioActa);
	formData.set("cpActa", cpActa);
	
	$.ajax({
		url :  'atencionciudadana/guardar-acta-entrevista',
		type : 'POST',
		data : formData,
		cache : false,
		dataType : 'json',
		processData : false,
		contentType : false,
		success : function(data, textStatus, jqXHR) {
			if(data.estatus ===1){
				monstrarAlerta({message: data.descripcion, class:"info"});
				document.getElementById("formActaEntrevista").reset();
			}else if(data.estatus ===-3){
				monstrarAlerta({message: data.descripcion, class:"danger"});
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			monstrarAlerta({message:"Ocurrio un inconveniente al realizar la peticion", class:"danger"});
		}
	});            
}

// Acta Entrevista edit

function leerEntrevista(elemento){
	$('#municipioActaRead').empty();
	$('#cpActaRead').empty();
	$('#coloniaActaRead').empty();
					
	let inputMunicipio = $("#municipioActaRead");
	let inputcp = $("#cpActaRead");	
	let inputColonia = $("#coloniaActaRead");
				
	inputMunicipio.append('<option value="">Selecciona...</option>');
	inputcp.append('<option value="">Selecciona...</option>');
	inputColonia.append('<option value="">Selecciona...</option>');
	
	if(null !== elemento.anidadosDto.municipiosActa){
		$.each(elemento.anidadosDto.municipiosActa, function(index, elemento) {
			inputMunicipio.append('<option value="' + elemento.idMunicipio +'&'+elemento.codigoMunicipio +'">' + elemento.municipioDetalle + '</option>');
		});		
	}
	if(null !== elemento.anidadosDto.cpsActa){
		$.each(elemento.anidadosDto.cpsActa, function(index, elemento) {
			inputcp.append('<option value="' + elemento.idCp +'&'+elemento.codigoCp +'">' + elemento.codigoCp + '</option>');
		});		
	}
	if(null !== elemento.anidadosDto.coloniasActa){
		$.each(elemento.anidadosDto.coloniasActa, function(index, elemento) {
			inputColonia.append('<option value="' + elemento.idColonia +'">' + elemento.coloniaDetalle + '</option>');
		});		
	}
	
	if(elemento.personaEntrevista !== null){
		$("#idActaEntrevista").val( null === elemento.personaEntrevista.idEntrevista? null :elemento.personaEntrevista.idEntrevista );
		$("#numExpedienteActaRead").val( null === elemento.personaEntrevista.idExpediente? null :elemento.personaEntrevista.idExpediente );
		$("#fechaActaRead").val( null === elemento.personaEntrevista.fecha? undefined:milisegundosToFechaISO(elemento.personaEntrevista.fecha) );
		$("#horaActaRead").val( null === elemento.personaEntrevista.hora? null :elemento.personaEntrevista.hora );
		$("#nombreActaRead").val( null === elemento.personaEntrevista.nombre? null :elemento.personaEntrevista.nombre );
		$("#aPaternoActaRead").val( null === elemento.personaEntrevista.apaterno? null :elemento.personaEntrevista.apaterno );
		$("#aMaternoActaRead").val( null === elemento.personaEntrevista.amaterno? null :elemento.personaEntrevista.amaterno );
		$("#fNacimientoActaRead").val( null === elemento.personaEntrevista.fechaNacimiento? undefined:milisegundosToFechaISO(elemento.personaEntrevista.fechaNacimiento) );
		$("#sexoActaRead").val( null === elemento.personaEntrevista.idSexo? null :elemento.personaEntrevista.idSexo );
		$("#eCivilActaRead").val( null === elemento.personaEntrevista.idEstadoCivil? null :elemento.personaEntrevista.idEstadoCivil );
		$("#nacionalidadActaRead").val( null === elemento.personaEntrevista.idNacionalidad? null :elemento.personaEntrevista.idNacionalidad );
		$("#estadoActaRead").val( null === elemento.personaEntrevista.catEstado? undefined:elemento.personaEntrevista.catEstado.idEstado+"&"+elemento.personaEntrevista.catEstado.codigoEstado );
		$("#municipioActaRead").val( null === elemento.personaEntrevista.catMunicipio? undefined:elemento.personaEntrevista.catMunicipio.idMunicipio+"&"+elemento.personaEntrevista.catMunicipio.codigoMunicipio );
		$("#cpActaRead").val( null === elemento.personaEntrevista.catCp? undefined:elemento.personaEntrevista.catCp.idCp+"&"+elemento.personaEntrevista.catCp.codigoCp );
		$("#coloniaActaRead").val( null === elemento.personaEntrevista.catColonia? null :elemento.personaEntrevista.catColonia.idColonia );
		$("#calleNumActaRead").val( null === elemento.personaEntrevista.calle? null :elemento.personaEntrevista.calle );
		$("#ocupacionActaRead").val( null === elemento.personaEntrevista.idOcupacion? null :elemento.personaEntrevista.idOcupacion );
		$("#escolaridadActaRead").val( null === elemento.personaEntrevista.idEscolaridad? null :elemento.personaEntrevista.idEscolaridad );
		$("#gradoEstudioActaRead").val( null === elemento.personaEntrevista.idGradoEstudio? null :elemento.personaEntrevista.idGradoEstudio );
		
		$("#fisicoActaRead").val( null === elemento.personaEntrevista.tatuajeLunarMarca? null :elemento.personaEntrevista.tatuajeLunarMarca );
		$("#aliasActaRead").val( null === elemento.personaEntrevista.aliasApodo? null :elemento.personaEntrevista.aliasApodo );
		$("#edadActaRead").val( null === elemento.personaEntrevista.idEdad? null :elemento.personaEntrevista.idEdad );
		$("#idiomaActaRead").val( null === elemento.personaEntrevista.idIdioma? null :elemento.personaEntrevista.idIdioma );
		$("#identificacionActaRead").val( null === elemento.personaEntrevista.idTipoIdentificacion? null :elemento.personaEntrevista.idTipoIdentificacion );
		$("#etnicoActaRead").val( null === elemento.personaEntrevista.idGrupoEtnico? null :elemento.personaEntrevista.idGrupoEtnico );
		$("#leerActaRead").val( null === elemento.personaEntrevista.sabeLeer? null :elemento.personaEntrevista.sabeLeer );
		$("#escribirActaRead").val( null === elemento.personaEntrevista.sabeEscribir? null :elemento.personaEntrevista.sabeEscribir );
		$("#dialectoActaRead").val( null === elemento.personaEntrevista.idDialecto? null :elemento.personaEntrevista.idDialecto );
		$("#parentescoActaRead").val( null === elemento.personaEntrevista.idParentesco? null :elemento.personaEntrevista.idParentesco );
		$("#lugarNacimientoActaRead").val( null === elemento.personaEntrevista.lugarNacimiento? null :elemento.personaEntrevista.lugarNacimiento );
		$("#telefonoActaRead").val( null === elemento.personaEntrevista.tefono? null :elemento.personaEntrevista.tefono );
		$("#relatoEntrevistaRead").val( null === elemento.personaEntrevista.relatoEntrevista? null :elemento.personaEntrevista.relatoEntrevista );
	}
}

function leerAcciones(elemento){
	$("#bodyAcciones").html("");
	var bodyAcciones = $("#bodyAcciones");		
	$.each(elemento.accionBusqueda, function(index, accion) {
		console.log(accion.fechaBusqueda);
		let fechaBusqueda= ( null === accion.fechaBusqueda? '':accion.fechaBusqueda);
		let estatusLocalizado= (null === accion.estatusLocalizado? '' :accion.estatusLocalizado.estatusLocalizadoDetalle) ;
		let municipio= (null === accion.municipio? '' :accion.municipio.municipioDetalle) ;
		let cp= (null === accion.cp? '' :accion.cp.codigoCp );
		let colonia= (null === accion.colonia? '' :accion.colonia.coloniaDetalle );
		let calle= (null === accion.calle? '' :accion.calle );
		let latitud= ( null === accion.latitud? '' :accion.latitud );
		let longitud= ( null === accion.longitud? '' :accion.longitud );
		let resenia= ( null === accion.resenia? '' :accion.resenia );
	
		let cad =''
		+'<div>                                                                                     '                   
		+'	<hr style=\"height: 2px\" color=\"#EF4B55\">                                            '                     
		+'	<div class=\"form-group row\">                                                          '                   
		+'		<div class=\"col-lg-4 col-md-12\">                                                  '                   
		+'			<label for=\"fechaAccionAb\">Fecha de acción</label>                            '                   
		+'			<input type=\"date\" class=\"form-control \" disabled value=\"'+fechaBusqueda+'\">              '
		+'		</div>                                                                              '                 
		+'		<div class=\"col-lg-4 col-md-12\">                                                  '                   
		+'			<label for=\"estatusAb\">Estatus</label>                                        '                   
		+'			<input type=\"text\" class=\"form-control\" disabled value=\"'+estatusLocalizado+'\" >              '                                                                         
		+'		</div>                                                                              '
		+'		<div class=\"col-lg-4 col-md-12\">                                                  '                   
		+'			<label for=\"municipioAb\">Municipio</label>                                    '                   
		+'			<input type=\"text\" class=\"form-control\" disabled value=\"'+municipio+'\" >              '                                                                          
		+'		</div>                                                                              '                 
		+'	</div>                                                                                  '                 
		+'	<div class=\"form-group row\">                                                          '                   
		+'		<div class=\"col-lg-4 col-md-12\">                                                  '                   
		+'			<label for=\"cpAb\">Código postal</label>                                       '                   
		+'			<input type=\"text\" class=\"form-control\" disabled value=\"'+cp+'\" >              '                                                                        
		+'		</div>                                                                              '                 
		+'		<div class=\"col-lg-4 col-md-12\">                                                  '                   
		+'			<label for=\"coloniaAb\">Colonia</label>                                        '                   
		+'			<input type=\"text\" class=\"form-control\" disabled value=\"'+colonia+'\" >              '
		+'		</div>                                                                              '                 
		+'		<div class=\"col-lg-4 col-md-12\">                                                  '                   
		+'			<label for=\"calleNumeroAb\">Calle y número</label>                             '                   
		+'			<input type=\"text\" class=\"form-control\" disabled value=\"'+calle+'\" >              '                                  
		+'		</div>                                                                              '                 
		+'	</div>                                                                                  '                 
		+'	<div class=\"form-group row\">                                                          '                   
		+'		<div class=\"col-lg-4 col-md-12\">                                                  '                   
		+'			<label for=\"latitudAb\">Latitud</label>                                        '                   
		+'			<input type=\"text\" class=\"form-control\" disabled value=\"'+latitud+'\" >              '               
		+'		</div>                                                                              '                 
		+'		<div class=\"col-lg-4 col-md-12\">                                                  '                   
		+'			<label for=\"longitudAb\">Longitud</label>                                      '                   
		+'			<input type=\"text\" class=\"form-control\" disabled value=\"'+longitud+'\" >              '              
		+'		</div>                                                                              '                 
		+'	</div>					                                                                '                 
		+'	<div class=\"form-group row\">                                                          '                   
		+'		<div class=\"col-12\">                                                              '                   
		+'			<label for=\"reseniaAb\">Descripción de los hechos</label>                      '                   
		+'			<textarea class=\"form-control\" rows=\"5\" disabled>'+resenia+'</textarea>   '               
		+'		</div>                                                                              '                 
		+'	</div>                                                                                  '                 
		+'</div>                                                                                    ';
		bodyAcciones.append(cad);
	});
}

function editarActa(){
	 $("#btnGuardarActa").prop("disabled", false);
	 $("#btnCancelarActa").prop("disabled", false);
	 $('#btnEditarActa').prop("disabled", true);

	 $("#numExpedienteActaRead").prop("disabled", false);
	 $("#fechaActaRead").prop("disabled", false);
	 $("#horaActaRead").prop("disabled", false);
	 $("#nombreActaRead").prop("disabled", false);
	 $("#aPaternoActaRead").prop("disabled", false);
	 $("#aMaternoActaRead").prop("disabled", false);
	 $("#fNacimientoActaRead").prop("disabled", false);
	 $("#sexoActaRead").prop("disabled", false);
	 $("#eCivilActaRead").prop("disabled", false);
	 $("#nacionalidadActaRead").prop("disabled", false);
	 $("#estadoActaRead").prop("disabled", false);
	 $("#municipioActaRead").prop("disabled", false);
	 $("#cpActaRead").prop("disabled", false);
	 $("#coloniaActaRead").prop("disabled", false);
	 $("#calleNumActaRead").prop("disabled", false);
	 $("#ocupacionActaRead").prop("disabled", false);
	 $("#escolaridadActaRead").prop("disabled", false);
	 $("#gradoEstudioActaRead").prop("disabled", false);
	 
	 $("#fisicoActaRead").prop("disabled", false);
	 $("#aliasActaRead").prop("disabled", false);
	 $("#edadActaRead").prop("disabled", false);
	 $("#idiomaActaRead").prop("disabled", false);
	 $("#identificacionActaRead").prop("disabled", false);
	 $("#etnicoActaRead").prop("disabled", false);
 	 $("#leerActaRead").prop("disabled", false);
	 $("#escribirActaRead").prop("disabled", false);
	 $("#dialectoActaRead").prop("disabled", false);
	 $("#parentescoActaRead").prop("disabled", false);
	 $("#lugarNacimientoActaRead").prop("disabled", false);
	 $("#telefonoActaRead").prop("disabled", false);
	 $("#relatoEntrevistaRead").prop("disabled", false);
 }
 
 function cancelarActa(){
	 $("#btnGuardarActa").prop("disabled", true);
	 $("#btnCancelarActa").prop("disabled", true);
	 $('#btnEditarActa').prop("disabled", false);
	 
	 $("#numExpedienteActaRead").prop("disabled", true);
	 $("#fechaActaRead").prop("disabled", true);
	 $("#horaActaRead").prop("disabled", true);
	 $("#nombreActaRead").prop("disabled", true);
	 $("#aPaternoActaRead").prop("disabled", true);
	 $("#aMaternoActaRead").prop("disabled", true);
	 $("#fNacimientoActaRead").prop("disabled", true);
	 $("#sexoActaRead").prop("disabled", true);
	 $("#eCivilActaRead").prop("disabled", true);
	 $("#nacionalidadActaRead").prop("disabled", true);
	 $("#estadoActaRead").prop("disabled", true);
	 $("#municipioActaRead").prop("disabled", true);
	 $("#cpActaRead").prop("disabled", true);
	 $("#coloniaActaRead").prop("disabled", true);
	 $("#calleNumActaRead").prop("disabled", true);
	 $("#ocupacionActaRead").prop("disabled", true);
	 $("#escolaridadActaRead").prop("disabled", true);
	 $("#gradoEstudioActaRead").prop("disabled", true);
	 
	 $("#fisicoActaRead").prop("disabled", true);
	 $("#aliasActaRead").prop("disabled", true);
	 $("#edadActaRead").prop("disabled", true);
	 $("#idiomaActaRead").prop("disabled", true);
	 $("#identificacionActaRead").prop("disabled", true);
	 $("#etnicoActaRead").prop("disabled", true);
 	 $("#leerActaRead").prop("disabled", true);
	 $("#escribirActaRead").prop("disabled", true);
	 $("#dialectoActaRead").prop("disabled", true);
	 $("#parentescoActaRead").prop("disabled", true);
	 $("#lugarNacimientoActaRead").prop("disabled", true);
	 $("#telefonoActaRead").prop("disabled", true);
	 $("#relatoEntrevistaRead").prop("disabled", true);
 }
 
 function saveFormActaEdit(event) {

	event.stopPropagation();
	event.preventDefault();
	let form = document.getElementById('formActaEntrevistaRead');
	let formData = new FormData(form);	
	let estado =  filtrarId("estadoActaRead");
	let municipio =  filtrarId("municipioActaRead");
	let cp =  filtrarId("cpActaRead");
	formData.set("estadoActaRead",estado);
	formData.set("municipioActaRead",municipio);
	formData.set("cpActaRead",cp);
	
	$.ajax({
		url :  'atencionciudadana/guardar-Acta-Edit',
		type : 'POST',
		data : formData,
		cache : false,
		dataType : 'json',
		processData : false,
		contentType : false,
		success : function(data, textStatus, jqXHR) {
			if(data.estatus ===1){
				monstrarAlerta({message: data.descripcion, class:"info"});
				cancelarActa();
			}else if(data.estatus ===-3){
				monstrarAlerta({message: data.descripcion, class:"danger"});
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			monstrarAlerta({message:"Ocurrio un inconveniente al realizar la peticion", class:"danger"});
		}
	});        
}

function cargarMunicipioActaRead() {
	let valueEstado = filtrarValor("estadoActaRead");
	$.ajax({
		url: "atencionciudadana/municipios-por-estado",
		type: 'POST',
		data: 'codigoEstado='+valueEstado,
		success: function(respuesta) {
		
			$('#municipioActaRead').empty();
			$('#cpActaRead').empty();
			$('#coloniaActaRead').empty();			
			let inputMunicipio = $("#municipioActaRead");
			let inputCp = $("#cpActaRead");
			let inputColonia = $("#coloniaActaRead");			
			inputMunicipio.append('<option value="">Selecciona...</option>');
			inputCp.append('<option value="">Selecciona...</option>');
			inputColonia.append('<option value="">Selecciona...</option>');
			
			$.each(respuesta, function(index, elemento) {
				inputMunicipio.append('<option value="' +elemento.idMunicipio+'&'+elemento.codigoMunicipio+'">' + elemento.municipioDetalle + '</option>');
			});
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});
}

function cargarCpActaRead() {
	let valueEstado = filtrarValor("estadoActaRead");
	let valueMunicipio = filtrarValor("municipioActaRead");
	var datos = 'codigoEstado='+ valueEstado + '&codigoMunicipio='+ valueMunicipio;
	$.ajax({
		url: "atencionciudadana/cp-por-estado-municipios",
		type: 'POST',
		data: datos,
		success: function(respuesta) {
		
			$('#cpActaRead').empty();
			$('#coloniaActaRead').empty();			
			let inputCp = $("#cpActaRead");
			let inputColonia = $("#coloniaActaRead");			
			inputCp.append('<option value="">Selecciona...</option>');
			inputColonia.append('<option value="">Selecciona...</option>');
			
			$.each(respuesta, function(index, elemento) {
				inputCp.append('<option value="' + elemento.idCp +'&'+elemento.codigoCp +'">' + elemento.codigoCp + '</option>');
			});
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});
}

function cargarColoniaActaRead() {
	let valueCp = filtrarValor("cpActaRead");
	$.ajax({
		url: "atencionciudadana/colonia-por-cp",
		type: 'POST',
		data: 'codigoCp='+valueCp,
		success: function(respuesta) {
			$('#coloniaActaRead').empty();
			let inputColonia = $("#coloniaActaRead");
			inputColonia.append('<option value="">Selecciona...</option>');
			$.each(respuesta, function(index, elemento) {
				inputColonia.append('<option value="' + elemento.idColonia +'">' + elemento.coloniaDetalle + '</option>');
			});
		},
		error: function() {
			console.log("No se ha podido obtener la información");
		}
	});

}
function exportarConcentrado(){
	let idExpediente = document.getElementById("expediente").value;
	let idSexo = document.getElementById("sexo").value;
	let idEdad = document.getElementById("edad").value;
	let idMunicipio = document.getElementById("municipio").value;
	let idEstatusLocalizado = document.getElementById("estatusLocalizado").value;
	
	let data ='idExpediente='+idExpediente+'&idSexo='+idSexo+'&idEdad='+idEdad+'&idMunicipio='+idMunicipio+'&idEstatusLocalizado='+idEstatusLocalizado;

	let uriExport= "atencionciudadana/exportar-concentrado?"+data;
	
	//const url = URL.createObjectURL();
	const a = document.createElement('a');
    a.href = uriExport;
    a.click();
}

function printForm() {
	let idExpediente = document.getElementById("expedienteConsulta").value;
	printJS({
    printable: 'form1',
    type: 'html',
    targetStyles: ['*'],
    header: 'Expediente :'+idExpediente
 })
}

function exportPdf(){
	var tituloAux=document.title;
	
	console.log(idExpedienteNombrePdf)	
	console.log(tituloAux)
	if(null != idExpedienteNombrePdf){
		document.title=idExpedienteNombrePdf+".pdf";
		//$("#sidebarToggle").click();
		$('#collapseReportante').collapse('show');
		$('#collapseDesaparecida').collapse('show');
		$('#collapseEvidencia').collapse('show');
		$('#collapseActa').collapse('show');
		$('#collapseContexto').collapse('show');
		$('#collapseAccion').collapse('show');
		setTimeout(function () {
			window.print()
			document.title= tituloAux;
		}, 500);
	}
}

function limpiarConsultaExp(){
	document.getElementById("consultarExpedienteForm").reset();
	document.getElementById("formReportanteRead").reset();
	document.getElementById("formDesaparecidoRead").reset();
	$("#evidenciasBody").html("");
	document.getElementById("formActaEntrevistaRead").reset();
	
	$('#btnExportarExp').prop("disabled", true);
	$('#cardReportante').hide();
	$('#cardDesaparecido').hide();
	$('#cardEvidencias').hide();
	$('#cardContexto').hide();
	$('#cardActaEntrevista').hide();  //solo para validar
	$('#cardAcciones').hide();
}
	

function limpiarPath(){
	var pathname = window.location.pathname;
	if( pathname.includes("atencionciudadana") ){
		history.pushState(null, "", "atencionciudadana");	
	}else if( pathname.includes("accionesbusqueda") ){
		history.pushState(null, "", "accionesbusqueda");
	}else if( pathname.includes("gerencia") ){
		history.pushState(null, "", "gerencia");
	}
}