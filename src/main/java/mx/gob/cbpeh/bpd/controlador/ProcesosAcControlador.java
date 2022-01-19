package mx.gob.cbpeh.bpd.controlador;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import mx.gob.cbpeh.bpd.dto.AtentaNotaDto;
import mx.gob.cbpeh.bpd.dto.CommonResponse;
import mx.gob.cbpeh.bpd.dto.ExpedienteDto;
import mx.gob.cbpeh.bpd.dto.UsuarioDto;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.ArchivoExpediente;
import mx.gob.cbpeh.bpd.modelo.AtentaNota;
import mx.gob.cbpeh.bpd.modelo.CatArea;
import mx.gob.cbpeh.bpd.modelo.CatCompaniaTelefono;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.modelo.CatParentesco;
import mx.gob.cbpeh.bpd.modelo.CatRedSocial;
import mx.gob.cbpeh.bpd.modelo.CatTipoArchivo;
import mx.gob.cbpeh.bpd.modelo.CatTipoNota;
import mx.gob.cbpeh.bpd.modelo.CatTipoUso;
import mx.gob.cbpeh.bpd.modelo.Expediente;
import mx.gob.cbpeh.bpd.modelo.PersonaDesaparecida;
import mx.gob.cbpeh.bpd.modelo.PersonaVinculada;
import mx.gob.cbpeh.bpd.modelo.Usuario;
import mx.gob.cbpeh.bpd.modelo.VinculoRedSocial;
import mx.gob.cbpeh.bpd.modelo.VinculoTelefono;
import mx.gob.cbpeh.bpd.servicio.ArchivoExpedienteServicio;
import mx.gob.cbpeh.bpd.servicio.AtentaNotaServicio;
import mx.gob.cbpeh.bpd.servicio.CatTipoArchivoServicio;
import mx.gob.cbpeh.bpd.servicio.ExpedienteServicio;
import mx.gob.cbpeh.bpd.servicio.PersonaDesaparecidaServicio;
import mx.gob.cbpeh.bpd.servicio.PersonaVinculadaServicio;
import mx.gob.cbpeh.bpd.servicio.UsuarioServicio;
import mx.gob.cbpeh.bpd.servicio.VinculoRedSocialServicio;
import mx.gob.cbpeh.bpd.servicio.VinculoTelefonoServicio;

@RestController
@RequestMapping(value = "/analisiscontexto")
public class ProcesosAcControlador {

	private static final Logger LOG = LoggerFactory.getLogger(ProcesosAcControlador.class);
	@Autowired
	ExpedienteServicio expedienteServicios;
	@Autowired
	PersonaDesaparecidaServicio personaDesaparecidaServicio;
	@Autowired
	ArchivoExpedienteServicio archivoExpedienteServicio;
	@Autowired
	CatTipoArchivoServicio tipoArchivoServicio;
	@Autowired
	PersonaVinculadaServicio vinculadaServicio;
	@Autowired
	VinculoRedSocialServicio redSocialServicio;
	@Autowired
	VinculoTelefonoServicio vinculoTelefonoServicio;
	@Autowired
	AtentaNotaServicio atentaNotaServicio;
	@Autowired
	UsuarioServicio usuarioServicio;
	

	/* Obtiene el expediente por idExpediente */
	@RequestMapping(value = "/busqueda-expediente", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<ExpedienteDto> buscarExpediente(@RequestParam("folioExpediente") String folioExpediente)
			throws ResourceNotFoundException {

		ExpedienteDto response = new ExpedienteDto();
		Expediente expediente = new Expediente();
		try {			

			if (folioExpediente.isEmpty() || folioExpediente.trim().equals("")) {
				response.setEstatus(-1);
				response.setDescripcion("La informacion ingresada es invalida.");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}

			expediente = expedienteServicios.getExpediente(folioExpediente);

			if (expediente == null || expediente.equals(null)) {
				response.setEstatus(1);
				response.setDescripcion("No se encontraron registros.");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}

			Integer idPersonaDesaparecida = expediente.getIdPersonaDesaparecida();

			PersonaDesaparecida personaDesaparecida = personaDesaparecidaServicio
					.getPersonaDesaparecida(idPersonaDesaparecida);

			if (personaDesaparecida == null) {
				response.setEstatus(-2);
				response.setDescripcion("Informacion invalida.");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}

			response.setIdExpediente(folioExpediente);
			response.setCatEstatus(expediente.getCatEstatus());
			response.setObservacion(expediente.getObservacion());
			response.setPersonaDesaparecida(personaDesaparecida);
			response.setEstatus(1);
			response.setDescripcion("OK");

		} catch (Exception e) {
			// TODO: handle exception
			LOG.error("Error en buscarPorExpediente : " + e);
			 response.setEstatus(-3);
	     		response.setDescripcion("Se genero un error en la busqueda.");
	     		return new ResponseEntity<>(response, HttpStatus.OK);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	/* Obtiene atenta notas por area */
	@RequestMapping(value = "/acciones/busqueda-atenta-notas", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<AtentaNotaDto> busquedaAtentaNotas(@RequestParam("folioExpediente") String folioExpediente,
			@RequestParam("folioAtentasNotas") String folioAtentasNotas,
			@RequestParam("fechaInicio") String fechaInicio,
			@RequestParam("fechaFin") String fechaFin,
			@RequestParam("tipoNota") String tipoNota)
			 {

		AtentaNotaDto response = new AtentaNotaDto();
		
		try {			
			List<AtentaNota> atentaNotas = new ArrayList<>();
			if ( (!folioExpediente.trim().equals("") || !folioExpediente.isEmpty()) &&
				  (folioAtentasNotas.trim().equals("") || folioAtentasNotas.isEmpty())  && 
				  (tipoNota.trim().equals("")|| tipoNota.isEmpty())) {				
				 LOG.info("ENTRA 1");
				//Expediente expediente = new Expediente();
		         //   expediente.setIdExpediente(folioExpediente.toUpperCase());
				atentaNotas = atentaNotaServicio.getAtentaNotasPorIdExpediente(folioExpediente.toUpperCase());				
			}
			
			else if ( (folioExpediente.trim().equals("") || folioExpediente.isEmpty()) &&
					(!folioAtentasNotas.trim().equals("") || !folioAtentasNotas.isEmpty()) 
					  && (tipoNota.trim().equals("")|| tipoNota.isEmpty())) {				
				LOG.info("ENTRA 2 "+ folioAtentasNotas);
				AtentaNota nota = atentaNotaServicio.getAtentaNotaPorIdAtentaNota(folioAtentasNotas.trim());
				LOG.info("ENTRA 2.2  "+ nota.getIdAtentaNota());
				atentaNotas.add(nota);
				
			} else if ( (folioExpediente.trim().equals("") || folioExpediente.isEmpty()) && 
					(folioAtentasNotas.trim().equals("") || folioAtentasNotas.isEmpty()) 
					  && (!tipoNota.trim().equals("")|| !tipoNota.isEmpty())) {
				LOG.info("ENTRA 3");
				 CatTipoNota tipo = new CatTipoNota();
				 tipo.setIdTipoNota(Integer.parseInt(tipoNota));
				atentaNotas = atentaNotaServicio.getAtentaNotasPorTipoNota(tipo);
			}
			
			else if ( (!folioExpediente.trim().equals("") || !folioExpediente.isEmpty()) && 
					(!folioAtentasNotas.trim().equals("") || !folioAtentasNotas.isEmpty()) 
					 && (tipoNota.trim().equals("")|| tipoNota.isEmpty())) {
				LOG.info("ENTRA 4");
				//Expediente expediente = new Expediente();
	            //expediente.setIdExpediente(folioExpediente.toUpperCase());
				 
				atentaNotas = atentaNotaServicio.getAtentaNotasPorAtentaNotaIdExpediente(folioAtentasNotas, folioExpediente.toUpperCase());
			}
			
			else if ( (!fechaInicio.trim().equals("") || !fechaInicio.isEmpty()) && 
					(!fechaFin.trim().equals("") || !fechaFin.isEmpty())) {
				LOG.info("ENTRA 5 "+fechaInicio+" "+fechaFin);
				Expediente expediente = new Expediente();
	            expediente.setIdExpediente(folioExpediente.toUpperCase());
				 
				atentaNotas = atentaNotaServicio.getAtentaNotasPorFechas(new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicio),
						new SimpleDateFormat("yyyy-MM-dd").parse(fechaFin));
			}	
			         

			if (atentaNotas == null || atentaNotas.size()==0) {
				response.setEstatus(1);
				response.setDescripcion("No se encontraron registros.");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
		

			response.setAtentaNota(atentaNotas);
			response.setEstatus(1);
			response.setDescripcion("OK");

		} catch (Exception e) {
			// TODO: handle exception
			LOG.error("Error en carga atentas notas por area : " + e);
			 response.setEstatus(-3);
	     		response.setDescripcion("Se genero un error al cargar la informacion.");
	     		return new ResponseEntity<>(response, HttpStatus.OK);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
	/* Obtiene el expediente por idExpediente */
	@RequestMapping(value = "/acciones/obtener-direccion-puesto", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<UsuarioDto> obtenerUsuario(@RequestParam("idUsuario") String idUsuario)
			throws ResourceNotFoundException {

		UsuarioDto response = new UsuarioDto();
		Usuario usuario = new Usuario();
		try {			

			if (idUsuario.isEmpty() || idUsuario.trim().equals("")) {
				response.setEstatus(-1);
				response.setDescripcion("La informacion seleccionada es invalida.");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}

			usuario = usuarioServicio.getUsuario(idUsuario);

			if (usuario == null || usuario.equals(null)) {
				response.setEstatus(1);
				response.setDescripcion("No se encontraron registros.");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}

			
			response.setCatArea(usuario.getCatArea());
			response.setIdDireccion(usuario.getCatDireccion().getIdDireccion());
			response.setIdPuesto(usuario.getCatPuesto().getIdPuesto());
			
			response.setEstatus(1);
			response.setDescripcion("OK");

		} catch (Exception e) {
			// TODO: handle exception
			LOG.error("Error en obtenerUsuario : " + e);
			 response.setEstatus(-3);
	     		response.setDescripcion("Se genero un error en obtener Usuario.");
	     		return new ResponseEntity<>(response, HttpStatus.OK);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	
	/* Obtiene atenta notas por area */
	@RequestMapping(value = "/acciones/busqueda-atenta-notas-area", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<AtentaNotaDto> obtenerAtentasNotasPorArea(@RequestParam("idArea") Integer idArea)
			throws ResourceNotFoundException {

		AtentaNotaDto response = new AtentaNotaDto();
		
		try {			

			if ( idArea.equals(null)) {
				response.setEstatus(-1);
				response.setDescripcion("La informacion ingresada es invalida.");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			
            CatArea catArea = new CatArea();
            		catArea.setIdArea(idArea);
		List<AtentaNota>	atentaNotas = atentaNotaServicio.getAtentaNotasPorArea(catArea);

			if (atentaNotas == null || atentaNotas.equals(null)) {
				response.setEstatus(1);
				response.setDescripcion("No se encontraron registros.");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
		

			response.setAtentaNota(atentaNotas);
			response.setEstatus(1);
			response.setDescripcion("OK");

		} catch (Exception e) {
			// TODO: handle exception
			LOG.error("Error en carga atentas notas por area : " + e);
			 response.setEstatus(-3);
	     		response.setDescripcion("Se genero un error al cargar la informacion.");
	     		return new ResponseEntity<>(response, HttpStatus.OK);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
	/* Realiza una consulta y devuelve una cadena en texto plano */
	@RequestMapping(value = "/prueba", method = RequestMethod.GET)
	public @ResponseBody String metodoPrueba(@RequestParam(value = "grupo", required = true) String grupo) {

		Expediente expediente = null;
		try {

			LOG.info("Entra metodo en metodoPrueba : " + grupo);
			expediente = expedienteServicios.getExpediente(grupo);
			LOG.info("Salida en metodoPrueba " + expediente.getIdPersonaDesaparecida());

		} catch (Exception e) {
			// TODO: handle exception
			LOG.error("Error en metodoPrueba : ", e.getMessage() + " CAUSA : " + e.getCause());
		}
		return expediente.getIdPersonaDesaparecida().toString();
	}

	/* Guarda informacion perfil de analisis de contexto */
	@RequestMapping(value = "/guardar-evidencia", method = RequestMethod.POST)
	public ResponseEntity<CommonResponse> guardarPerfilAC(@RequestParam("cargaEvidencia") MultipartFile file,
			@RequestParam("folioExpediente") String idExpediente,
			@RequestParam("descripcionEvidencia") String descripcionEvidencia)
			 {
		
		CommonResponse commonResponse= new CommonResponse();
         try {
			
		
		
		String nombreArchivo = file.getOriginalFilename();
		String extension = nombreArchivo.substring(nombreArchivo.lastIndexOf(".") + 1, nombreArchivo.length());
		
		CatTipoArchivo catTipoArchivo = tipoArchivoServicio.getCatTipoArchivo(extension.toUpperCase());
		ArchivoExpediente archivoExpediente = new ArchivoExpediente();
		archivoExpediente.setArchivo(file.getBytes());
		archivoExpediente.setIdEstatusExpediente(1);
        archivoExpediente.setArchivoDescripcion(descripcionEvidencia);
		archivoExpediente.setCatTipoArchivo(catTipoArchivo);
		archivoExpediente.setIdExpediente(idExpediente.toUpperCase());
		archivoExpediente.setFechaCarga(new Date());
		archivoExpediente.setHoraCarga(new Time(00, 00, 00));
		archivoExpediente.setNombreArchivo(nombreArchivo);
		archivoExpediente.setIdPerfilCarga(2);//2 analisis contexto
		archivoExpediente.setIdUsuarioCarga(getNameUser());

		archivoExpedienteServicio.saveArchivoExpediente(archivoExpediente);
		
         } catch (Exception e) {
 			// TODO: handle exception
        	 commonResponse.setEstatus(-3);
     		commonResponse.setDescripcion("Se genero un error al guardar la informacion.");
     		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
 		}
         
         commonResponse.setEstatus(1);
 		commonResponse.setDescripcion("La informacion se guardo correctamente.");
 		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}

	/* Guarda  informacion de persona vinculada e informacion telefonica y redes de analisis de contexto */
	@PostMapping(value = "/guardar-info-tel-red", produces = "application/json")
	public ResponseEntity<CommonResponse> guardarInfoTelefonicaRedes(@RequestParam("idExpediente") String folioExpediente,
			@RequestParam("nombre") String nombre, @RequestParam("apellidoP") String apellidoP,
			@RequestParam("apellidoM") String apellidoM, @RequestParam("parentesco") Integer idParentesco,
			@RequestParam("telefonoFijo") String telefonoFijo, @RequestParam("telefonoCelular") String telefonoCelular,
			@RequestParam("companiaTel") Integer companiaTel, @RequestParam("correoPersonal") String correoPersonal,
			@RequestParam("correoOpcional") String correoOpcional, @RequestParam("facebook") String facebook,
			@RequestParam("instagram") String instagram, @RequestParam("twitter") String twitter,
			@RequestParam("administraRedes") String administraRedes,
			@RequestParam("correoEmpresarial") String correoEmpresarial,
			@RequestParam("telefonoEmpresarial") String telefonoEmpresarial,
			@RequestParam("instagramEmpresarial") String instagramEmpresarial,
			@RequestParam("twitterEmpresarial") String twitterEmpresarial,
			@RequestParam("facebookEmpresarial") String facebookEmpresarial) {

		CommonResponse response = new CommonResponse();

		LOG.info("expediente :" + folioExpediente + " " + correoPersonal + " " + correoEmpresarial + " " + facebook + " "
				+ instagram + " " + twitter);
		
		try {
			
			if (folioExpediente.isEmpty() || folioExpediente.trim().equals("")) {
				response.setEstatus(-1);
				response.setDescripcion("La informacion ingresada es invalida, se requiere el folio expediente.");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}

		PersonaVinculada personaVinculada = new PersonaVinculada();
		personaVinculada.setNombre(nombre);
		personaVinculada.setAmaterno(apellidoM);
		personaVinculada.setApaterno(apellidoP);
		CatEstatus catEstatus = new CatEstatus();
		catEstatus.setIdEstatus(1);
		personaVinculada.setCatEstatus(catEstatus);
		CatParentesco catParentesco = new CatParentesco();
		catParentesco.setIdParentesco(idParentesco);
		personaVinculada.setCatParentesco(catParentesco);
		Expediente expediente = new Expediente();
		expediente.setIdExpediente(folioExpediente.toUpperCase());
		personaVinculada.setExpediente(expediente);
		personaVinculada.setFechaAlta(new Date());
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(getNameUser());
		personaVinculada.setUsuario2(usuario);

		PersonaVinculada personaV = vinculadaServicio.saveAndGetPersonaVinculada(personaVinculada);

		if (!correoPersonal.trim().equals("") || !correoPersonal.isEmpty()) {
			LOG.info("1");
			VinculoRedSocial redSocial = new VinculoRedSocial();
			redSocial.setCatEstatus(catEstatus);
			redSocial.setFechaAlta(new Date());
			redSocial.setPersonaVinculada(personaV);
			redSocial.setUsuario2(usuario);
			CatRedSocial catRedSocial = new CatRedSocial();
			CatTipoUso catTipoUso = new CatTipoUso();
			catRedSocial.setIdRedSocial(1);
			redSocial.setCatRedSocial(catRedSocial);
			catTipoUso.setIdTipoUso(3);
			redSocial.setCatTipoUso(catTipoUso);
			redSocial.setDatoRedSocial(correoPersonal);
			redSocialServicio.saveVinculoRedSocial(redSocial);
		}
		if (!correoOpcional.trim().equals("") || !correoOpcional.isEmpty()) {
			LOG.info("2");
			VinculoRedSocial redSocial2 = new VinculoRedSocial();
			redSocial2.setCatEstatus(catEstatus);
			redSocial2.setFechaAlta(new Date());
			redSocial2.setPersonaVinculada(personaV);
			redSocial2.setUsuario2(usuario);
			CatRedSocial catRedSocial = new CatRedSocial();
			CatTipoUso catTipoUso = new CatTipoUso();
			catRedSocial.setIdRedSocial(1);
			redSocial2.setCatRedSocial(catRedSocial);
			catTipoUso.setIdTipoUso(3);
			redSocial2.setCatTipoUso(catTipoUso);
			redSocial2.setDatoRedSocial(correoOpcional);
			redSocialServicio.saveVinculoRedSocial(redSocial2);

		}

		if (!correoEmpresarial.trim().equals("") || !correoEmpresarial.isEmpty()) {
			LOG.info("3");
			VinculoRedSocial redSocial3 = new VinculoRedSocial();
			redSocial3.setCatEstatus(catEstatus);
			redSocial3.setFechaAlta(new Date());
			redSocial3.setPersonaVinculada(personaV);
			redSocial3.setUsuario2(usuario);
			CatRedSocial catRedSocial = new CatRedSocial();
			CatTipoUso catTipoUso = new CatTipoUso();
			catRedSocial.setIdRedSocial(1);
			redSocial3.setCatRedSocial(catRedSocial);
			catTipoUso.setIdTipoUso(4);
			redSocial3.setCatTipoUso(catTipoUso);
			redSocial3.setDatoRedSocial(correoEmpresarial);
			redSocialServicio.saveVinculoRedSocial(redSocial3);

		}
		// Personal
		if (!facebook.trim().equals("") || !facebook.isEmpty()) {
			LOG.info("4");
			VinculoRedSocial redSocial4 = new VinculoRedSocial();
			redSocial4.setCatEstatus(catEstatus);
			redSocial4.setFechaAlta(new Date());
			redSocial4.setPersonaVinculada(personaV);
			redSocial4.setUsuario2(usuario);
			CatRedSocial catRedSocial = new CatRedSocial();
			CatTipoUso catTipoUso = new CatTipoUso();
			catRedSocial.setIdRedSocial(2);
			redSocial4.setCatRedSocial(catRedSocial);
			catTipoUso.setIdTipoUso(3);
			redSocial4.setCatTipoUso(catTipoUso);
			redSocial4.setDatoRedSocial(facebook);
			redSocialServicio.saveVinculoRedSocial(redSocial4);

		}

		if (!instagram.trim().equals("") || !instagram.isEmpty()) {

			LOG.info("5");
			VinculoRedSocial redSocial5 = new VinculoRedSocial();
			redSocial5.setCatEstatus(catEstatus);
			redSocial5.setFechaAlta(new Date());
			redSocial5.setPersonaVinculada(personaV);
			redSocial5.setUsuario2(usuario);
			CatRedSocial catRedSocial = new CatRedSocial();
			CatTipoUso catTipoUso = new CatTipoUso();
			catRedSocial.setIdRedSocial(3);
			redSocial5.setCatRedSocial(catRedSocial);
			catTipoUso.setIdTipoUso(3);
			redSocial5.setCatTipoUso(catTipoUso);
			redSocial5.setDatoRedSocial(instagram);
			redSocialServicio.saveVinculoRedSocial(redSocial5);

		}
		if (!twitter.trim().equals("") || !twitter.isEmpty()) {

			LOG.info("6");
			VinculoRedSocial redSocial6 = new VinculoRedSocial();
			redSocial6.setCatEstatus(catEstatus);
			redSocial6.setFechaAlta(new Date());
			redSocial6.setPersonaVinculada(personaV);
			redSocial6.setUsuario2(usuario);
			CatRedSocial catRedSocial = new CatRedSocial();
			CatTipoUso catTipoUso = new CatTipoUso();
			catRedSocial.setIdRedSocial(7);
			redSocial6.setCatRedSocial(catRedSocial);
			catTipoUso.setIdTipoUso(3);
			redSocial6.setCatTipoUso(catTipoUso);
			redSocial6.setDatoRedSocial(twitter);
			redSocialServicio.saveVinculoRedSocial(redSocial6);

		}

//Empresarial o Laboral
		if (!facebookEmpresarial.trim().equals("") || !facebookEmpresarial.isEmpty()) {
			LOG.info("7");
			VinculoRedSocial redSocial7 = new VinculoRedSocial();
			redSocial7.setCatEstatus(catEstatus);
			redSocial7.setFechaAlta(new Date());
			redSocial7.setPersonaVinculada(personaV);
			redSocial7.setUsuario2(usuario);
			CatRedSocial catRedSocial = new CatRedSocial();
			CatTipoUso catTipoUso = new CatTipoUso();
			catRedSocial.setIdRedSocial(2);
			redSocial7.setCatRedSocial(catRedSocial);
			catTipoUso.setIdTipoUso(4);
			redSocial7.setCatTipoUso(catTipoUso);
			redSocial7.setDatoRedSocial(facebookEmpresarial);
			redSocialServicio.saveVinculoRedSocial(redSocial7);

		}

		if (!instagramEmpresarial.trim().equals("") || !instagramEmpresarial.isEmpty()) {
			LOG.info("8");
			VinculoRedSocial redSocial8 = new VinculoRedSocial();
			redSocial8.setCatEstatus(catEstatus);
			redSocial8.setFechaAlta(new Date());
			redSocial8.setPersonaVinculada(personaV);
			redSocial8.setUsuario2(usuario);
			CatRedSocial catRedSocial = new CatRedSocial();
			CatTipoUso catTipoUso = new CatTipoUso();
			catRedSocial.setIdRedSocial(3);
			redSocial8.setCatRedSocial(catRedSocial);
			catTipoUso.setIdTipoUso(4);
			redSocial8.setCatTipoUso(catTipoUso);
			redSocial8.setDatoRedSocial(instagramEmpresarial);
			redSocialServicio.saveVinculoRedSocial(redSocial8);

		}
		if (!twitterEmpresarial.trim().equals("") || !twitterEmpresarial.isEmpty()) {
			LOG.info("9");

			VinculoRedSocial redSocial9 = new VinculoRedSocial();
			redSocial9.setCatEstatus(catEstatus);
			redSocial9.setFechaAlta(new Date());
			redSocial9.setPersonaVinculada(personaV);
			redSocial9.setUsuario2(usuario);
			CatRedSocial catRedSocial = new CatRedSocial();
			CatTipoUso catTipoUso = new CatTipoUso();
			catRedSocial.setIdRedSocial(7);
			redSocial9.setCatRedSocial(catRedSocial);
			catTipoUso.setIdTipoUso(4);
			redSocial9.setCatTipoUso(catTipoUso);
			redSocial9.setDatoRedSocial(twitterEmpresarial);
			redSocialServicio.saveVinculoRedSocial(redSocial9);

		}
        
		if(!telefonoFijo.trim().equals("")  ||!telefonoFijo.isEmpty()) {
			System.out.println("Entra 1");
			LOG.info("Entra 1");
		VinculoTelefono vinculoTelefono = new VinculoTelefono();
		CatCompaniaTelefono catCompaniaTelefono= new CatCompaniaTelefono();
		catCompaniaTelefono.setIdCompaniaTelefono(15);
		vinculoTelefono.setCatCompaniaTelefono(catCompaniaTelefono);
		                vinculoTelefono.setCatEstatus(catEstatus);
		                CatTipoUso catTipoUso = new CatTipoUso();
		                catTipoUso.setIdTipoUso(3);
		                vinculoTelefono.setCatTipoUso(catTipoUso);
		                vinculoTelefono.setFechaAlta(new Date());
		                vinculoTelefono.setPersonaVinculada(personaVinculada);
		                vinculoTelefono.setTelefono(Long.parseLong(telefonoFijo));
		                vinculoTelefono.setUsuario2(usuario);
		                vinculoTelefono.setFechaActualiza(new Date());
		                vinculoTelefonoServicio.saveVinculoTelefono(vinculoTelefono);
		                
		}
		
		if(!telefonoCelular.trim().equals("")  || !telefonoCelular.isEmpty()) {
			System.out.println("Entra 2");
			LOG.info("Entra 2");
			VinculoTelefono vinculoTelefono = new VinculoTelefono();
			CatCompaniaTelefono catCompaniaTelefono= new CatCompaniaTelefono();
			catCompaniaTelefono.setIdCompaniaTelefono(companiaTel);
							vinculoTelefono.setCatCompaniaTelefono(catCompaniaTelefono);
			                vinculoTelefono.setCatEstatus(catEstatus);
			                CatTipoUso catTipoUso = new CatTipoUso();
			                catTipoUso.setIdTipoUso(3);
			                vinculoTelefono.setCatTipoUso(catTipoUso);
			                vinculoTelefono.setFechaAlta(new Date());
			                vinculoTelefono.setPersonaVinculada(personaVinculada);
			                vinculoTelefono.setTelefono(Long.parseLong(telefonoCelular));
			                vinculoTelefono.setUsuario2(usuario);
			                vinculoTelefono.setFechaActualiza(new Date());
			                vinculoTelefonoServicio.saveVinculoTelefono(vinculoTelefono);
			                
			}
		if(!telefonoEmpresarial.trim().equals("")  || !telefonoEmpresarial.isEmpty()) {
			System.out.println("Entra 3");
			LOG.info("Entra 3");
			VinculoTelefono vinculoTelefono = new VinculoTelefono();
			CatCompaniaTelefono catCompaniaTelefono= new CatCompaniaTelefono();
			catCompaniaTelefono.setIdCompaniaTelefono(15);
			vinculoTelefono.setCatCompaniaTelefono(catCompaniaTelefono);
			                vinculoTelefono.setCatEstatus(catEstatus);
			                CatTipoUso catTipoUso = new CatTipoUso();
			                catTipoUso.setIdTipoUso(4);
			                vinculoTelefono.setCatTipoUso(catTipoUso);
			                vinculoTelefono.setFechaAlta(new Date());
			                vinculoTelefono.setPersonaVinculada(personaVinculada);
			                vinculoTelefono.setTelefono(Long.parseLong(telefonoEmpresarial));
			                vinculoTelefono.setUsuario2(usuario);
			                vinculoTelefono.setFechaActualiza(new Date());
			                vinculoTelefonoServicio.saveVinculoTelefono(vinculoTelefono);
			                
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			
			response.setEstatus(-3);
			response.setDescripcion("Se genero un error al guardar la informacion.");
     		return new ResponseEntity<>(response, HttpStatus.OK);
		}
		response.setEstatus(1);
		response.setDescripcion("La informacion se guardo correctamente.");

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/* Guarda atentas notas de analisis de contexto */
	@RequestMapping(value = "/acciones/guardar-atentas-notas", method = RequestMethod.POST)
	public ResponseEntity<CommonResponse> guardarAtentaNota(
			@RequestParam("idRemitente") String idRemitente,
			//@RequestParam("idDireccion") String idDireccion,
			@RequestParam("idArea") String idArea,
			@RequestParam("idTipoNota") String idTipoNota,
			@RequestParam("folioExpediente") String idExpediente,
			@RequestParam("descripcion") String descripcion,
			@RequestParam("idDestinatario") String idDestinatario
			
			
			)
			 {
		
		String folioAtentaNota= "";
		folioAtentaNota=  atentaNotaServicio.getFolioAtentaNota(Integer.parseInt(idTipoNota), Integer.parseInt(idArea),folioAtentaNota );
		CommonResponse commonResponse= new CommonResponse();
         try {	
		
        	LOG.info(" FOLIO: "+folioAtentaNota);
     	System.out.println(" area: "+idArea);
     	System.out.println(" tipo: "+idTipoNota);
		
		AtentaNota atentaNota = new AtentaNota();
		atentaNota.setIdAtentaNota(folioAtentaNota);
		CatArea catArea = new CatArea();
		catArea.setIdArea(Integer.parseInt(idArea));
		atentaNota.setCatArea(catArea);
		CatEstatus catEstatus = new CatEstatus();
		catEstatus.setIdEstatus(1);
		atentaNota.setCatEstatus(catEstatus);
		CatTipoNota catTipoNota= new CatTipoNota();
		catTipoNota.setIdTipoNota(Integer.parseInt(idTipoNota));
		atentaNota.setCatTipoNota(catTipoNota);		
		//Expediente expediente = new Expediente();
		//expediente.setIdExpediente(idExpediente.toUpperCase());
		atentaNota.setIdExpediente(idExpediente.toUpperCase());		
		atentaNota.setFechaCreacion(new Date());
		atentaNota.setDescripcionNota(descripcion);
		
		atentaNota.setUsuarioRemitente(idRemitente);
		
		atentaNota.setUsuarioDestino(idDestinatario);

		atentaNotaServicio.saveAtentaNota(atentaNota);
		
         } catch (Exception e) {
 			// TODO: handle exception
        	 
        	   
        	 commonResponse.setEstatus(-3);
     		commonResponse.setDescripcion("Se genero un error al guardar la informacion.");
     		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
 		}
      
         commonResponse.setEstatus(1);
 		commonResponse.setDescripcion("La informacion se guardo correctamente.");
 		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}
	
	private String getNameUser() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		return currentPrincipalName;
	}

}

