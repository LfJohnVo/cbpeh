$(function () {
	$('#formAccionBusqueda').on('submit', uploadFileAb);
	//$('#formLargaData').on('submit', uploadEvidence);
});

function uploadFileAb(event) {
	event.stopPropagation();
	event.preventDefault();
	var form = document.getElementById('formAccionBusqueda');
	var formData = new FormData(form);
	var estatusAb = filtrarId("estatusAb");
	var municipioAb = filtrarId("municipioAb");
	var cpAb = filtrarId("cpAb");
	var coloniaAb = filtrarId("coloniaAb");
	console.log(estatusAb + "/" + municipioAb + "/" + cpAb + "/" + coloniaAb);
	formData.set("estatusAb", estatusAb);
	formData.set("municipioAb", municipioAb);
	formData.set("cpAb", cpAb);
	formData.set("coloniaAb", coloniaAb);

	postFilesDataAb(formData);
}

/*function uploadEvidence(event) {
	event.stopPropagation();
	event.preventDefault();
	var form = document.getElementById('formLargaData');
	var formData = new FormData(form);
	var estatusLD =  filtrarId("estatusLD");
	var municipioLargaData =  filtrarId("municipioLargaData");
	var cpLargaData =  filtrarId("cpLargaData");
	var coloniaLargaData =  filtrarId("coloniaLargaData");
	//console.log(estatusAb+"/"+municipioAb+"/"+cpAb+"/"+coloniaAb);
	formData.set("estatusLD",estatusLD);
	formData.set("municipioLargaData",municipioLargaData);
	formData.set("cpLargaData",cpLargaData);
	formData.set("coloniaLargaData",coloniaLargaData);
	
	guardarLargaData(formData);              
}*/

function postFilesDataAb(formData) {
	$.ajax({
		url: 'accionesbusqueda/guardar-accion-busqueda',
		type: 'POST',
		data: formData,
		cache: false,
		dataType: 'json',
		processData: false,
		contentType: false,
		success: function (data, textStatus, jqXHR) {
			if (data.estatus === 1) {
				resetAccionBusqueda();
				monstrarAlerta({ message: data.descripcion, class: "info" });
				document.getElementById("formAccionBusqueda").reset();
				$('.custom-select').val('').trigger('change'); // Reset Select2
			} else if (data.estatus === -3) {
				monstrarAlerta({ message: data.descripcion, class: "danger" });
			} else if (data.estatus === -4) {
				monstrarAlerta({ message: data.descripcion, class: "danger" });
			}
		},
		error: function (jqXHR, textStatus, errorThrown) {
			monstrarAlerta({ message: "Ocurrio un inconveniente al realizar la peticion", class: "danger" });
		}
	});
}

/*function guardarLargaData(formData) {
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
		},
		error : function() {
			monstrarAlerta({message:"Ocurrio un inconveniente al realizar la peticion", class:"danger"});
		}
	});
	
	$('#limpiarLD').click();	
	document.getElementById('alertExito').style.display = 'block';	
}*/

function cargaCodigoP() {
	var valueMunicipio = document.getElementById("municipioAb").value;
	var arregloValueMunicipio = valueMunicipio.split("&", 2);
	$.ajax({
		url: "accionesbusqueda/cp-por-estado-municipio",
		type: 'POST',
		data: 'codigoMunicipio=' + arregloValueMunicipio[1],
		success: function (respuesta) {
			$('#cpAb').empty();
			$('#coloniaAb').empty();
			var inputCp = $("#cpAb");
			var inputColonia = $("#coloniaAb");
			inputCp.append('<option value="">Selecciona...</option>');
			inputColonia.append('<option value="">Selecciona...</option>');
			$.each(respuesta, function (index, elemento) {
				inputCp.append('<option value="' + elemento.idCp + '&' + elemento.codigoCp + '">' + elemento.codigoCp + '</option>');
			});
		},
		error: function () {
			console.log("No se ha podido obtener la información");
		}
	});
}

function cargaColonias() {
	var valueCodigoP = document.getElementById("cpAb").value;
	var arregloValueCp = valueCodigoP.split("&", 2);
	$.ajax({
		url: "accionesbusqueda/colonia-por-cp",
		type: 'POST',
		data: 'codigoCp=' + arregloValueCp[1],
		success: function (respuesta) {
			$('#coloniaAb').empty();
			var inputColonia = $("#coloniaAb");
			inputColonia.append('<option value="">Selecciona...</option>');
			$.each(respuesta, function (index, elemento) {
				inputColonia.append('<option value="' + elemento.idColonia + '&' + elemento.idColonia + '">' + elemento.coloniaDetalle + '</option>');
			});
		},
		error: function () {
			console.log("No se ha podido obtener la información");
		}
	});
}


function cargaCpLargaData() {
	var valueMunicipio = document.getElementById("municipioLargaData").value;
	var arregloValueMunicipio = valueMunicipio.split("&", 2);
	$.ajax({
		url: "accionesbusqueda/cp-por-estado-municipio",
		type: 'POST',
		data: 'codigoMunicipio=' + arregloValueMunicipio[1],
		success: function (respuesta) {
			$('#cpLargaData').empty();
			$('#coloniaLargaData').empty();
			var inputCp = $("#cpLargaData");
			var inputColonia = $("#coloniaLargaData");
			inputCp.append('<option value="">Selecciona...</option>');
			inputColonia.append('<option value="">Selecciona...</option>');
			$.each(respuesta, function (index, elemento) {
				inputCp.append('<option value="' + elemento.idCp + '&' + elemento.codigoCp + '">' + elemento.codigoCp + '</option>');
			});
		},
		error: function () {
			console.log("No se ha podido obtener la información");
		}
	});
}

function cargaColoniaLargaData() {
	var codigoP = document.getElementById("cpLargaData").value;
	var idCodigoP = codigoP.split("&", 2);
	$.ajax({
		url: "accionesbusqueda/colonia-por-cp",
		type: 'POST',
		data: 'codigoCp=' + idCodigoP[1],
		success: function (respuesta) {
			$('#coloniaLargaData').empty();
			var inputColonia = $("#coloniaLargaData");
			inputColonia.append('<option value="">Selecciona...</option>');
			$.each(respuesta, function (index, elemento) {
				inputColonia.append('<option value="' + elemento.idColonia + '&' + elemento.codigoColonia + '">' + elemento.coloniaDetalle + '</option>');
			});
		},
		error: function () {
			console.log("No se ha podido obtener la información");
		}
	});
}

function buscarDiario() {

	var anio = document.getElementById("anio").value;
	var mes = document.getElementById("mes").value;
	var idEstatus = document.getElementById("idEstatus").value;
	var idExpediente = document.getElementById("idExpediente").value;

	var data = 'anio=' + anio + '&mes=' + mes + '&idEstatus=' + idEstatus + '&idExpediente=' + idExpediente;
	$.ajax({
		url: "accionesbusqueda/buscar-registro-diario",
		type: 'GET',
		data: data,
		success: function (data) {
			$("#bodyDiario").html("");
			var bodyTabla = $("#bodyDiario");

			if (data.estatus === 1) {
				$.each(data.elementos, function (index, elemento) {
					bodyTabla.append(' <tr><td><a href="?idExpediente=' + elemento.idExpediente + '">' + elemento.idExpediente + '</a></td><td>' + elemento.personaDesaparecida + '</td><td>' + elemento.numeroAcciones + '</td><td>' + elemento.estatus + '</td></tr>');
				});
				$("#btnExportarRegDia").prop("disabled", false);
			} else if (data.estatus === 2) {
				initRegistroDiario();
				monstrarAlerta({ message: data.descripcion, class: "info" });
			} else if (data.estatus === -3) {
				initRegistroDiario();
				monstrarAlerta({ message: data.descripcion, class: "danger" });
			}
		},
		error: function () {
			monstrarAlerta({ message: "No se ha podido obtener la informacion", class: "danger" });
		}
	});
}

function limpiarTablaDiaria() {
	document.getElementById("formConsultaDiario").reset();
	$('.custom-select').val('').trigger('change'); // Se resetea también select2
	$('#bodyDiario').html("");
	initRegistroDiario();
}

function initRegistroDiario() {
	$("#btnExportarRegDia").prop("disabled", true);
}

function exportarRegistroDiario() {
	let anio = document.getElementById("anio").value;
	let mes = document.getElementById("mes").value;
	let idEstatus = document.getElementById("idEstatus").value;
	let idExpediente = document.getElementById("idExpediente").value;

	let data = 'anio=' + anio + '&mes=' + mes + '&idEstatus=' + idEstatus + '&idExpediente=' + idExpediente;
	let uriExport = "accionesbusqueda/exportar-registro-diario-busqueda?" + data;

	//const url = URL.createObjectURL();
	const a = document.createElement('a');
	a.href = uriExport;
	a.click();
}

function buscarColaboraciones() {
	var idExpedienteColaboracion = document.getElementById("idExpedienteColaboracion").value;
	var fechaPeticion = document.getElementById("fechaPeticion").value;
	var idInstitucion = document.getElementById("idInstitucion").value;
	var idEstatusColaboracion = document.getElementById("idEstatusColaboracion").value;
	var data = 'idExpedienteColaboracion=' + idExpedienteColaboracion + "&fechaPeticion=" + fechaPeticion + "&idInstitucion=" + idInstitucion + "&idEstatusColaboracion=" + idEstatusColaboracion;
	$.ajax({
		url: "accionesbusqueda/buscar-colaboraciones",
		type: 'GET',
		data: data,
		success: function (data) {
			$("#bodyColaboraciones").html("");
			var bodyTabla = $("#bodyColaboraciones");

			if (data.estatus === 1) {
				$.each(data.elementos, function (index, elemento) {
					var html = `
						<tr>
							<td><a href="#">${elemento.idExpedienteColaboracion}</a></td>
							<td>${elemento.numeroOfficioPeticion}</td>
							<td>${elemento.institucion}</td>
							<td>${elemento.firmadoPor}</td>
							<td>${elemento.personaDesaparecida}</td>
							<td>${elemento.estatusColaboracion}</td>
							<td>`
					if (elemento.archivo != null) {
						html += `
								<a class="btn btn-info btn-circle" download="${elemento.idExpedienteColaboracion}.${elemento.extension.toLowerCase()}" href="data:;base64,${elemento.archivo}"><span class="fa fa-eye"></span></button>
								`;
					} else {
						html += "No se encontró un archivo";
					}
					`</td>
						</tr>
					`;
					console.log(elemento.archivo);
					bodyTabla.append(html);
				});
				$("#btnExportarColaboraciones").prop("disabled", false);
			} else if (data.estatus === 2) {
				initColaboraciones();
				monstrarAlerta({ message: data.descripcion, class: "info" });
			} else if (data.estatus === -3) {
				initColaboraciones();
				monstrarAlerta({ message: data.descripcion, class: "danger" });
			}
		},
		error: function () {
			monstrarAlerta({ message: "No se ha podido obtener la informacion", class: "danger" });
		}
	});
}
function limpiarTablaColaboraciones() {
	document.getElementById("formConcentradoColaboraciones").reset();
	$('.custom-select').val('').trigger('change'); // Se resetea también select2
	$('#bodyColaboraciones').html("");
	initColaboraciones();
}

function initColaboraciones() {
	$("#btnExportarColaboraciones").prop("disabled", true);
}

function exportarColaboraciones() {
	var idExpedienteColaboracion = document.getElementById("idExpedienteColaboracion").value;
	var fechaPeticion = document.getElementById("fechaPeticion").value;
	var idInstitucion = document.getElementById("idInstitucion").value;
	var idEstatusColaboracion = document.getElementById("idEstatusColaboracion").value;
	var data = 'idExpedienteColaboracion=' + idExpedienteColaboracion + "&fechaPeticion=" + fechaPeticion + "&idInstitucion=" + idInstitucion + "&idEstatusColaboracion=" + idEstatusColaboracion;
	let uriExport = "accionesbusqueda/exportar-concentrado-colaboraciones?" + data;
	//const url = URL.createObjectURL();
	const a = document.createElement('a');
	a.href = uriExport;
	a.click();
}
function busquedaLargaData() {
	var mesBusquedaLD = document.getElementById("mesBusquedaLD").value;
	var yearBusquedaLD = document.getElementById("yearBusquedaLD").value;
	var data = 'mesBusquedaLD=' + mesBusquedaLD + "&yearBusquedaLD=" + yearBusquedaLD;
	$.ajax({
		url: "accionesbusqueda/buscar-busqueda-larga-data",
		type: 'GET',
		data: data,
		success: function (data) {
			$("#bodyBusquedaLargaData").html("");
			var bodyTabla = $("#bodyBusquedaLargaData");

			if (data.estatus === 1) {
				$.each(data.elementos, function (index, elemento) {
					var html = `
						<tr>
							<td><a href="#">${elemento.idBusquedaLargaData}</a></td>
							<td>${elemento.fechaBusqueda}</td>
							<td>${elemento.estatusLocalizado}</td>
							<td>${elemento.municipio}</td>
							<td>${elemento.cp}</td>
							<td>${elemento.colonia}</td>
							<td>${elemento.calle}</td>
							<td>${elemento.latitud}</td>
							<td>${elemento.longitud}</td>
						</tr>
					`;
					bodyTabla.append(html);
				});
				$("#btnExportarBusquedaLargaData").prop("disabled", false);
			} else if (data.estatus === 2) {
				limpiarTablaBusquedaLargaData();
				monstrarAlerta({ message: data.descripcion, class: "info" });
			} else if (data.estatus === -3) {
				limpiarTablaBusquedaLargaData();
				monstrarAlerta({ message: data.descripcion, class: "danger" });
			}
		},
		error: function () {
			monstrarAlerta({ message: "No se ha podido obtener la informacion", class: "danger" });
		}
	});
}
function limpiarTablaBusquedaLargaData() {
	document.getElementById("formConcentradoLargaData").reset();
	$('.custom-select').val('').trigger('change'); // Se resetea también select2
	$('#bodyBusquedaLargaData').html("");
	initColaboraciones();
}

function initBusquedaLargaData() {
	$("#btnExportarBusquedaLargaData").prop("disabled", true);
}

function exportarBusquedaLargaData() {
	var mesBusquedaLD = document.getElementById("mesBusquedaLD").value;
	var yearBusquedaLD = document.getElementById("yearBusquedaLD").value;
	var data = 'mesBusquedaLD=' + mesBusquedaLD + "&yearBusquedaLD=" + yearBusquedaLD;
	let uriExport = "accionesbusqueda/exportar-busqueda-larga-data?" + data;
	//const url = URL.createObjectURL();
	const a = document.createElement('a');
	a.href = uriExport;
	a.click();
}
//Acciones Busqueda
function exportPdfAcciones() {
	let idExpedienteNombrePdf = document.getElementById("numExpedienteAb").value;
	var tituloAux = document.title;

	console.log(idExpedienteNombrePdf)
	console.log(tituloAux)
	if (null != idExpedienteNombrePdf) {
		document.title = idExpedienteNombrePdf + ".pdf";
		$("#sidebarToggle").click();
		setTimeout(function () {
			window.print()
			document.title = tituloAux;
		}, 500);
	} else {
		monstrarAlerta({ message: "Seleccione un expediente primero.", class: "info" });
	}
}

$("#numExpedienteAb").change(function () {
	let expSeleccionado = document.getElementById('numExpedienteAb').value;
	console.log(expSeleccionado)
	if (expSeleccionado != "") {
		$('#btnExportarExp').prop("disabled", false);
	} else {
		$("#btnExportarExp").prop("disabled", true);
	}
});

function resetAccionBusqueda() {
	document.getElementById("formAccionBusqueda").reset();
	$('.custom-select').val('').trigger('change'); // Reset select2
	$("#btnExportarExp").prop("disabled", true);
}

