$(function () {
	$('#formAtencionPsicologica').on('submit', guardarAtencionPsicologica);
	//$('#formLargaData').on('submit', uploadEvidence);
});

function guardarAtencionPsicologica(event) {
	event.stopPropagation();
	event.preventDefault();
	var form = document.getElementById('formAtencionPsicologica');
	var formData = new FormData(form);
	let nombre = document.getElementById('nombre').value;
	let parentesco = document.getElementById('parentesco').value;
	let fecha = document.getElementById('fecha').value;
	let observaciones = document.getElementById('observaciones').value;
	let numExpedienteAb = document.getElementById('numExpedienteAb').value;
	formData.set("nombre", nombre);
	formData.set("parentesco", parentesco);
	formData.set("fecha", fecha);
	formData.set("observaciones", observaciones);
	formData.set("numExpedienteAb", numExpedienteAb);
	postDataServer(formData);
}

function postDataServer(formData) {
	$.ajax({
		url: 'atencion-psicologica/guardar',
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
				document.getElementById("formAtencionPsicologica").reset();
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

function resetAccionBusqueda() {
	document.getElementById("formAtencionPsicologica").reset();
	$('.custom-select').val('').trigger('change'); // Reset select2
	$("#btnExportarExp").prop("disabled", true);
}

