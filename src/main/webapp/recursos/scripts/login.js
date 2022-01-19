$(document).ready(function() {
  
	$("#mLogin").click(function() {
	
	alert(pathGlobal);
		$("#container-fluid").load(pathGlobal + "/vistas/Login.jsp");
	});

	});