$(document).ready(function() {

	//...

	// Atencion Ciudadana
	$("#mConcentrado").click(function() {
		$("#container-fluid").load(pathGlobal + "/vistas/concentrado.jsp");
	});
	$("#mEstatusPersonaDesaparecida").click(function() {
		$("#container-fluid").load(pathGlobal + "/vistas/estatusPersonaDesaparecida.jsp");
	});
	$("#mCargaEvidenciasAT").click(function() {
		$("#container-fluid").load(pathGlobal + "/vistas/cargaEvidenciasAT.jsp");
	});
		
	$("#mEAtentasNotas").click(function() {
		$("#container-fluid").load(pathGlobal + "/vistas/eatentasNotas.jsp");
	});
	
	$("#mCAtentasNotas").click(function() {
		$("#container-fluid").load(pathGlobal + "/vistas/catentasNotas.jsp");
		buscarAtentasNotas('3');
	});
	

 	$("#personaReportante").click(function() {
		$("#container-fluid").load(pathGlobal+"/vistas/personaReportante.jsp");
		
	});
	
	$("#personaDesaparecida").click(function() {
		$("#container-fluid").load(pathGlobal+"/vistas/personaDesaparecida.jsp");
	});
	

	
	
	// Acciones de busqueda
	$("#links").click(function() {
		$("#container-fluid").load(pathGlobal + "/vistas/links.jsp");
	});
	$("#directorios").click(function() {
		$("#container-fluid").load(pathGlobal + "/vistas/directorio.jsp");
	});
	$("#mColaboracion").click(function() {
		$("#container-fluid").load(pathGlobal+"/vistas/colaboracion.jsp");
	});
	$("#mAccionBusqueda").click(function() {
		$("#container-fluid").load(pathGlobal+"/vistas/accionBusqueda.jsp");
	});
	
	$("#mregistroDiariodeBusqueda").click(function() {
		$("#container-fluid").load(pathGlobal+"/vistas/registroDiariodeBusqueda.jsp");
	});
	
	$("#mLargaData").click(function() {
		$("#container-fluid").load(pathGlobal+"/vistas/largaData.jsp");
	});
	$("#mActaEntrevista").click(function() {
		$("#container-fluid").load(pathGlobal+"/vistas/actaEntrevista.jsp");
	});
	//Fin menu acciones de busqueda	
	
	
	
	// Acceso General
	
	$("#mReportarDesaparicionInfo").click(function() {
		$("#container-fluid").load("../vistas/ReportarDesaparicionInfo.jsp");
	});
	
	$("#mConsultaExpediente").click(function() {
		$("#container-fluid").load("../vistas/consultaexpediente.jsp");
	});
	
	//Fin Acceso General
	
			$("#mLogin").click(function() {
		$("#container-fluid").load("../vistas/Login.jsp");
	});
	
});