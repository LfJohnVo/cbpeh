$(document).ready(function () {	//obtenemos el valor de los input
	$('#adicionar').click(function () {
		let id = filtrarId("accionesBusqueda");
		let detalle = filtrarValor("accionesBusqueda");
		let index = arrayLugares.indexOf("" + id);

		if (detalle !== '' && detalle !== undefined && index === -1) {
			arrayLugares.push(id);
			console.log("array:" + arrayLugares);

			var fila = '<tr id="fila' + id + '"><td>' + detalle + '</td><td><button type="button"  onclick=eliminarInstitucion(' + id + ') class="btn btn-danger btn-circle"><span class="fa fa-trash"></span></button></td></tr>';

			$('#mytable tbody').append(fila);
			var nFilas = $("#mytable tr").length;
			$("#adicionados").append(nFilas - 1);	//le resto 1 para no contar la fila del header
			$('#accionesBusqueda').val(null).trigger('change');
			$('#estatusColaboracion').val(null).trigger('change');
			document.getElementById("accionesBusqueda").value = "";
			document.getElementById("accionesBusqueda").focus();
		}
	});
	$('#adicionarDesaparecido').click(function () {
		let nombre = document.getElementById("nombres").value;
		let aPaterno = document.getElementById("aPaterno").value;
		let aMaterno = document.getElementById("aMaterno").value;

		let index = arrayDesaparecidos.indexOf("" + nombre);

		if (nombre !== '' && nombre !== undefined && aPaterno !== '' && aPaterno !== undefined && index === -1) {
			arrayDesaparecidos.push({ nombre, aPaterno, aMaterno });
			var fila = '<tr id="filaDes' + nombre + '"><td>' + nombre + '</td><td>' + aPaterno + '</td><td>' + aMaterno + '</td><td><button type="button"  onclick=eliminarDesaparecido("' + nombre + '") class="btn btn-danger btn-circle"><span class="fa fa-trash"></span></button></td></tr>';

			$('#tblDesaparecidos tbody').append(fila);
			var nFilas = $("#tblDesaparecidos tr").length;
			$("#adicionados").append(nFilas - 1);	//le resto 1 para no contar la fila del header
			document.getElementById("nombres").value = "";
			document.getElementById("aPaterno").value = "";
			document.getElementById("aMaterno").value = "";
		} else {
			alert('No has llenado todos los campos');
		}
	});
});

function eliminarDesaparecido(id) {
	$('#filaDes' + id).remove(); //borra la fila
	let indexElemento = arrayDesaparecidos.indexOf(id);
	arrayDesaparecidos.splice(indexElemento, 1);
}

function eliminarInstitucion(id) {
	console.log(arrayLugares);
	console.log(id);
	$('#fila' + id).remove(); //borra la fila

	let indexElemento = arrayLugares.indexOf("" + id);
	console.log("indice:" + indexElemento);
	arrayLugares.splice(indexElemento, 1);
	console.log(arrayLugares);
}

$(function () {
	$('#formColaboracion').on('submit', guardarColaboracion);
});

var arrayLugares = [];
var arrayDesaparecidos = [];
function guardarColaboracion(event) {
	event.stopPropagation();
	event.preventDefault();

	var form = document.getElementById('formColaboracion');
	var formData = new FormData(form);
	formData.set("lugaresBusqueda", arrayLugares);
	formData.set("desaparecidos", JSON.stringify(arrayDesaparecidos));

	$.ajax({
		url: 'accionesbusqueda/guardar-colaboracion',
		type: 'POST',
		data: formData,
		cache: false,
		dataType: 'json',
		processData: false,
		contentType: false,
		success: function (data, textStatus, jqXHR) {
			if (data.estatus === 1) {
				monstrarAlerta({ message: data.descripcion, class: "info" });
				document.getElementById("formColaboracion").reset();
				$('.custom-select').val('').trigger('change'); // Reset Select2
				arrayDesaparecidos = []; // limpiamos el arreglo
				$('#tblDesaparecidos').find('tbody').detach(); // quitamos las filas agregadas
				$('#tblDesaparecidos').append($('<tbody>'));  // agregamos el cuerpo de la tabla nuevamente
				arrayLugares = []; // limpiamos el arreglo
				$('#mytable').find('tbody').detach(); // quitamos las filas agregadas
				$('#mytable').append($('<tbody>'));  // agregamos el cuerpo de la tabla nuevamente
			} else if (data.estatus === -3) {
				monstrarAlerta({ message: data.descripcion, class: "danger" });
			}
		},
		error: function (jqXHR, textStatus, errorThrown) {
			monstrarAlerta({ message: "Ocurrio un inconveniente al realizar la peticion", class: "danger" });
		}
	});
}

$(function () {
	$('#formColaboracionBuscar').on('submit', BuscarColaboracion);
});

var arrayLugares = [];

function BuscarColaboracion(event) {
	event.stopPropagation();
	event.preventDefault();
	var numeroOfficioPeticion = document.getElementById("numPeticion1").value;
	console.log(numeroOfficioPeticion);
	var fechaPeticion = document.getElementById("fechaPeticion1").value;
	var solColaboracion = document.getElementById("solColaboracion1").value;
	var data = 'numPeticion=' + 'SEGOB/CEB/5420/2020' + "&fechaPeticion=" + fechaPeticion + "&solColaboracion=" + solColaboracion;
	var form = document.getElementById('formColaboracionBuscar');
	var formData = new FormData(form);
	formData.set("lugaresBusqueda", arrayLugares);

	$.ajax({
		url: 'accionesbusqueda/buscar-colaboracion',
		type: 'GET',
		data: data,
		cache: false,
		dataType: 'json',
		processData: false,
		contentType: false,
		success: function (data, textStatus, jqXHR) {
			console.log("Si se mando", data);
			monstrarAlerta({ message: data.descripcion, class: "info" });
			document.getElementById("formColaboracionBuscar").reset();
			$('.custom-select').val('').trigger('change'); // Reset Select2
			$("#bodyConcentrados").html("");
			var bodyConcen = $("#bodyConcentrados");

			if (data.estatus === 1) {
				$.each(data.elementos, function (index, elemento) {
					bodyConcen.append(' <tr><td>' + elemento.fechaPeticion + '</td><td>' + elemento.solColaboracion + '</td><td>' + elemento.numPeticion + '</td><td>' + elemento.firmadoPor + '</td></tr>');
				});
				$("#btnExportarConcentrado").prop("disabled", false);
			} else if (data.estatus === 2) {
				monstrarAlerta({ message: data.descripcion, class: "info" });
			} else if (data.estatus === -3) {
				monstrarAlerta({ message: data.descripcion, class: "danger" });
			}
		},
		error: function (jqXHR, textStatus, errorThrown) {
			monstrarAlerta({ message: "Ocurrio un inconveniente al realizar la peticion", class: "danger" });
		}
	});
}

// Colaboracion
function exportPdfColaboracion() {
	let numPeticion = document.getElementById("numPeticion").value;
	var tituloAux = document.title;

	console.log(numPeticion)
	console.log(tituloAux)
	if (null != numPeticion) {
		document.title = numPeticion + ".pdf";
		//$("#sidebarToggle").click();
		//$(".sidebar").toggleClass("toggled");
		setTimeout(function () {
			window.print()
			document.title = tituloAux;
		}, 500);
	} else {
		monstrarAlerta({ message: "Seleccione un expediente primero.", class: "info" });
	}
}

function changeInputCol(val) {
	console.log(val)
	if (val != "") {
		$('#btnExportarColaboracion').prop("disabled", false);
	} else {
		$("#btnExportarColaboracion").prop("disabled", true);
	}
}

function resetColaboracion() {
	document.getElementById("formColaboracion").reset();
	$('.custom-select').val('').trigger('change'); // Se resetea también select2
	$("#btnExportarColaboracion").prop("disabled", true);
}

function resetColaboracionBuscar() {
	document.getElementById("formColaboracionBuscar").reset();
	$('.custom-select').val('').trigger('change'); // Se resetea también select2
	$("#btnExportarColaboracion").prop("disabled", true);
}