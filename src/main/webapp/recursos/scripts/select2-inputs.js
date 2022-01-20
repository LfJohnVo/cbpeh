document.addEventListener('DOMContentLoaded',()=>{
	console.log('select2 iniciado');
	$('.custom-select').select2({
		 theme:'bootstrap4',
		 placeholder: 'Selecciona un opción',
		 allowClear: true
	})
})
	