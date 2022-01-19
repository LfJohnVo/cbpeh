
package mx.gob.cbpeh.bpd.controlador;

import java.io.BufferedOutputStream;
import java.io.File;
import java.math.BigInteger;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import mx.gob.cbpeh.bpd.dto.CommonResponse;
import mx.gob.cbpeh.bpd.dto.CommonResponseElement;
import mx.gob.cbpeh.bpd.dto.CommonResponseListElement;
import mx.gob.cbpeh.bpd.dto.ConcentradoDto;
import mx.gob.cbpeh.bpd.dto.EstatusPersonaDto;
import mx.gob.cbpeh.bpd.modelo.ArchivoExpediente;
import mx.gob.cbpeh.bpd.modelo.CatBaseNariz;
import mx.gob.cbpeh.bpd.modelo.CatBoca;
import mx.gob.cbpeh.bpd.modelo.CatColonia;
import mx.gob.cbpeh.bpd.modelo.CatColorCabello;
import mx.gob.cbpeh.bpd.modelo.CatColorOjo;
import mx.gob.cbpeh.bpd.modelo.CatComplexion;
import mx.gob.cbpeh.bpd.modelo.CatCp;
import mx.gob.cbpeh.bpd.modelo.CatDentadura;
import mx.gob.cbpeh.bpd.modelo.CatDialecto;
import mx.gob.cbpeh.bpd.modelo.CatEdad;
import mx.gob.cbpeh.bpd.modelo.CatEstado;
import mx.gob.cbpeh.bpd.modelo.CatEstadoCivil;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.modelo.CatEstatusEconomico;
import mx.gob.cbpeh.bpd.modelo.CatFormaNariz;
import mx.gob.cbpeh.bpd.modelo.CatFrente;
import mx.gob.cbpeh.bpd.modelo.CatGrupoEtnico;
import mx.gob.cbpeh.bpd.modelo.CatLabio;
import mx.gob.cbpeh.bpd.modelo.CatLongitudCabello;
import mx.gob.cbpeh.bpd.modelo.CatLugar;
import mx.gob.cbpeh.bpd.modelo.CatMedioContacto;
import mx.gob.cbpeh.bpd.modelo.CatMedioReporte;
import mx.gob.cbpeh.bpd.modelo.CatMunicipio;
import mx.gob.cbpeh.bpd.modelo.CatNacionalidad;
import mx.gob.cbpeh.bpd.modelo.CatOcupacion;
import mx.gob.cbpeh.bpd.modelo.CatParentesco;
import mx.gob.cbpeh.bpd.modelo.CatPeriodicidad;
import mx.gob.cbpeh.bpd.modelo.CatSexo;
import mx.gob.cbpeh.bpd.modelo.CatSiNo;
import mx.gob.cbpeh.bpd.modelo.CatTamanioNariz;
import mx.gob.cbpeh.bpd.modelo.CatTez;
import mx.gob.cbpeh.bpd.modelo.CatTipoArchivo;
import mx.gob.cbpeh.bpd.modelo.CatTipoCabello;
import mx.gob.cbpeh.bpd.modelo.CatTipoOjo;
import mx.gob.cbpeh.bpd.modelo.CatTipoSangre;
import mx.gob.cbpeh.bpd.modelo.CatTransporte;
import mx.gob.cbpeh.bpd.modelo.Expediente;
import mx.gob.cbpeh.bpd.modelo.PersonaDesaparecida;
import mx.gob.cbpeh.bpd.modelo.PersonaEntrevista;
import mx.gob.cbpeh.bpd.modelo.PersonaReporta;
import mx.gob.cbpeh.bpd.servicio.ArchivoExpedienteServicio;
import mx.gob.cbpeh.bpd.servicio.CatColoniaServicio;
import mx.gob.cbpeh.bpd.servicio.CatCpServicio;
import mx.gob.cbpeh.bpd.servicio.CatEstadoServicio;
import mx.gob.cbpeh.bpd.servicio.CatMunicipioServicio;
import mx.gob.cbpeh.bpd.servicio.CatTipoArchivoServicio;
import mx.gob.cbpeh.bpd.servicio.ConsultaService;
import mx.gob.cbpeh.bpd.servicio.EstatusPersonaServicio;
import mx.gob.cbpeh.bpd.servicio.ExpedienteServicio;
import mx.gob.cbpeh.bpd.servicio.PersonaDesaparecidaServicio;
import mx.gob.cbpeh.bpd.servicio.PersonaEntrevistaServicio;
import mx.gob.cbpeh.bpd.servicio.PersonaReportaServicio;
import mx.gob.cbpeh.bpd.util.Utils;

@RestController
@RequestMapping(value = "/atencionciudadana")
public class ProcesosAtencionCiudadana {
	
	private static final Logger log = LoggerFactory.getLogger(ProcesosAtencionCiudadana.class);
	
	@Autowired
	ExpedienteServicio expedienteServicios;
	@Autowired
	ArchivoExpedienteServicio archivoExpedienteServicio;
	@Autowired
	CatTipoArchivoServicio tipoArchivoServicio;	
	@Autowired
	ConsultaService consultaService;
	@Autowired
	EstatusPersonaServicio estatusPersonaServicio;
	@Autowired
	PersonaReportaServicio personaReportaServicio;
	@Autowired
	PersonaDesaparecidaServicio personaDesaparecidaServicio;	
	@Autowired
	CatMunicipioServicio catMunicipioServicio;
	@Autowired
	CatCpServicio catCpServicio;
	@Autowired
	CatColoniaServicio catColoniaServicio;
	@Autowired
	CatEstadoServicio estadoServicio;
	@Autowired
	PersonaEntrevistaServicio personaEntrevistaServicio;
	
	@RequestMapping(value = "/refrescar-expedientes", method = RequestMethod.POST, produces = "application/json")//@ResponseBody
	public ResponseEntity< List<Expediente> > getExpedientes(){
		List < Expediente > expedientes = new ArrayList<Expediente>();
		try {			
			expedientes =expedienteServicios.getExpedientes();
		}catch(Exception e) {
			log.error("Ocurrio un inconveniente."+e.getMessage());	
		}
		return new ResponseEntity<>(expedientes, HttpStatus.OK);
    }
	
	/* Guarda evidencia en atencion ciudadana */
	@RequestMapping(value = "/guardar-evidencia-at", method = RequestMethod.POST)
	public ResponseEntity<CommonResponse> guardarEvidenciaAt(@RequestParam("evidenciaEviAt") MultipartFile file,
			@RequestParam("expedienteEviAt") String idExpediente,
			@RequestParam("descripcionEviAt") String archivoDescripcion) {

		CommonResponse commonResponse = new CommonResponse();
		commonResponse.setEstatus(-3);
		commonResponse.setDescripcion("Se genero un inconveniente al guardar la informacion.");
		try {
			String nombreArchivo = file.getOriginalFilename();
			String extension =nombreArchivo.substring(nombreArchivo.lastIndexOf(".")+1, nombreArchivo.length());					//String extension =file.substring(file.lastIndexOf(".")+1, file.length());
			log.info("Extension: "+extension);
			CatTipoArchivo catTipoArchivo = tipoArchivoServicio.getCatTipoArchivo(extension.toUpperCase());
			
			ArchivoExpediente archivoExpediente = new ArchivoExpediente();
			archivoExpediente.setIdExpediente(idExpediente);
			archivoExpediente.setCatTipoArchivo(catTipoArchivo);
			archivoExpediente.setFechaCarga(new Date());
			LocalTime localTime = LocalTime.now();
			archivoExpediente.setHoraCarga(Time.valueOf(localTime));
			archivoExpediente.setIdUsuarioCarga(getNameUser());
			archivoExpediente.setNombreArchivo(nombreArchivo);
			archivoExpediente.setArchivo(file.getBytes());
			archivoExpediente.setArchivoDescripcion(archivoDescripcion);
			archivoExpediente.setIdPerfilCarga(4); //atencion ciudadana
			archivoExpediente.setIdEstatusExpediente(1);
			archivoExpediente = archivoExpedienteServicio.saveArchivoExpediente(archivoExpediente);
			if(archivoExpediente!=null && archivoExpediente.getIdArchivoExpediente()>0) {// guardo el archivo?
				log.info("Archivo guardado:"+archivoExpediente.getIdArchivoExpediente());
				commonResponse.setEstatus(1);
				commonResponse.setDescripcion("La informacion se guardo correctamente.");
			}

		} catch (Exception e) {
			log.error("Ocurrio un inconveniente al guardar evidencia:"+e.getMessage());
			return new ResponseEntity<>(commonResponse, HttpStatus.OK);
		}		
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/buscar-concentrado", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity< CommonResponseListElement<ConcentradoDto> > test(
			@RequestParam("idExpediente") String idExpediente,
			@RequestParam("idSexo") String idSexo,
			@RequestParam("idEdad") String idEdad,
			@RequestParam("idMunicipio") String idMunicipio,
			@RequestParam("idEstatusLocalizado") String idEstatusLocalizado){
		
		List<ConcentradoDto> concentrados = new ArrayList<ConcentradoDto>();
		CommonResponseListElement<ConcentradoDto> response = new CommonResponseListElement<ConcentradoDto>();
		response.setDescripcion("Se genero un inconveniente al buscar la informacion.");
		response.setEstatus(-3);	
		
		try {
			concentrados=consultaService.buscarConcentrado(idExpediente, idSexo,idEdad, idMunicipio, idEstatusLocalizado);
			
			if(concentrados.size()==0) {
				response.setEstatus(2);	
				response.setDescripcion("No se encontraron registros.");
				response.setElementos(concentrados);
			}else if(concentrados.size()>0) {
				response.setEstatus(1);	
				response.setDescripcion("OK");
				response.setElementos(concentrados);
			}
		}catch(Exception e) {
			log.error("Inconveniente al consultar concentrado:"+e.getMessage());
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/consultar-expediente", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity< CommonResponseElement<EstatusPersonaDto> > consultarExpediente(
			@RequestParam("idExpediente") String idExpediente ){
			//@RequestParam("curp") String curp){
		
		EstatusPersonaDto estatusPersona = new EstatusPersonaDto();
		CommonResponseElement<EstatusPersonaDto> response = new CommonResponseElement<EstatusPersonaDto>();
		response.setDescripcion("Se genero un inconveniente al buscar la informacion.");
		response.setEstatus(-3);	
		
		try {
			//estatusPersona=estatusPersonaServicio.consultarEstatus(idExpediente, curp);
			estatusPersona=estatusPersonaServicio.consultarEstatus(idExpediente);
			
			if(estatusPersona.getPersonaReporta() ==null && estatusPersona.getPersonaDesaparecida() == null) {
				response.setEstatus(2);	
				response.setDescripcion("No se encontraron registros.");
				response.setElemento(estatusPersona);			
			}else{
				response.setEstatus(1);	
				response.setDescripcion("OK");
				response.setElemento(estatusPersona);				
			}
		}catch(Exception e) {
			log.error("Inconveniente al consultar concentrado:"+e.getMessage());
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/getArchivoExpediente", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String file(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required=true) Integer idArchivoExpediente){
		//File fileInd=null;
		try {
			
			Optional<ArchivoExpediente>  optional=archivoExpedienteServicio.getArchivoExpediente(idArchivoExpediente);
			ArchivoExpediente archivoExp = optional.get();
			/*FileOutputStream fileImput = new FileOutputStream("D:\\test.jpg");
			fileImput.write(archivoExp.getArchivo());
			fileImput.close();*/
			
			//response.setContentType("APPLICATION/OCTET-STREAM"); // agrear una funcion case que filtre rip por  defecto octeestream
			response.setContentType("image/jpeg");
			response.addHeader("Content-Disposition", "attachment; filename="+archivoExp.getNombreArchivo());

			//byte[] byteArray = FileUtils.readFileToByteArray(fileInd);
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
	        bos.write(archivoExp.getArchivo());
	        bos.flush();
	        bos.close();

		}catch(Exception e) {
			log.error("Inconveniente al consultar el archivo:"+e.getMessage());
		}
		return null;
    }
	
	@RequestMapping(value = "/getIdentificacion", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getIdentificacion(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required=true) Integer idPersonaReporta){
		try {
			Optional<PersonaReporta> optional =personaReportaServicio.getPersonaReporta(idPersonaReporta);
			PersonaReporta personaReporta = optional.get();
			
			//response.setContentType("APPLICATION/OCTET-STREAM"); // agrear una funcion case que filtre rip por  defecto octeestream
			response.setContentType("image/jpeg");
			//response.addHeader("Content-Disposition", "attachment; filename="+archivoExp.getNombreArchivo());
			//response.addHeader("Content-Disposition", "attachment; filename="+personaReporta.getCatTipoIdentificacion().getTipoIdentificacionDetalle());
			response.addHeader("Content-Disposition", "attachment; filename="+personaReporta.getNombreArchivoIdentificacion() );

			//byte[] byteArray = FileUtils.readFileToByteArray(fileInd);
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
	        bos.write(personaReporta.getIdentificacion());
	        bos.flush();
	        bos.close();

		}catch(Exception e) {
			log.error("Inconveniente al obtener identificacion:"+e.getMessage());
		}
		return null;
    }
	
	@RequestMapping(value = "/ver-Fotografia", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String verFotografia(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required=true) Integer idPersonaDesaparecida){
		try {
			PersonaDesaparecida personaDesaparecida = personaDesaparecidaServicio.getPersonaDesaparecida(idPersonaDesaparecida);
			
			response.setContentType("APPLICATION/OCTET-STREAM"); // agrear una funcion case que filtre rip por  defecto octeestream
			response.addHeader("Content-Disposition", "attachment; filename=fotoDesaparecido.jpeg" );
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
	        bos.write(personaDesaparecida.getFotoPersona());
	        bos.flush();
	        bos.close();

		}catch(Exception e) {
			log.error("Inconveniente al obtener foto:"+e.getMessage());
		}
		return null;
    }
	
	@RequestMapping(value = "/guardar-Reportante-Edit", method = RequestMethod.POST)//@ResponseBody
	public  ResponseEntity<CommonResponse>  guardarReportanteEdit(
			@RequestParam ("idReportanteRead") Integer idReportante,
			@RequestParam ("nombreRepoRead") String nombre,
			@RequestParam ("apaternoRepoRead") String apellidoPaterno,
			@RequestParam ("amaternoRepoRead") String apellidoMaterno,
			@RequestParam ("estadoRepoRead") Integer estado,
			@RequestParam ("municipioRepoRead") Integer municipio,
			@RequestParam ("cpRepoRead") Integer cp,
			@RequestParam ("coloniaRepoRead") Integer colonia,
			@RequestParam ("calleRepoRead") String calle,
			@RequestParam ("edadRepoRead") Integer edad,			
			@RequestParam ("sexoRepoRead") Integer sexo,
			@RequestParam ("telefonoRepoRead") BigInteger telefono,
			@RequestParam ("correoRepoRead") String correo,
			@RequestParam ("celular2RepoRead") BigInteger celular,			
			@RequestParam ("relacionRepoRead") Integer relacion,			
			@RequestParam ("ocupacionRepoRead") Integer ocupacion,
			@RequestParam ("medioRepoRead") Integer medio,
			@RequestParam ("nacionalidadRepoRead") Integer nacionalidad,
			@RequestParam (required = false) MultipartFile identificacionRepoRead,		
			@RequestParam ("acompaniaRepoRead") Integer acompanaba
		){
		
		CommonResponse commonResponse = new CommonResponse();
		commonResponse.setEstatus(-3);
		commonResponse.setDescripcion("Se genero un inconveniente al guardar la informacion.");
		try {
			
			Optional<PersonaReporta> optionalReporta = personaReportaServicio.getPersonaReporta(idReportante);
			PersonaReporta personaReporta = optionalReporta.get();
			if(null != personaReporta && personaReporta.getIdPersonaReporta() >0) {				
				personaReporta.setIdPersonaReporta(idReportante);
				personaReporta.setNombre(nombre.toUpperCase());
				personaReporta.setApaterno(apellidoPaterno.toUpperCase());
				personaReporta.setAmaterno(apellidoMaterno.toUpperCase());
				if(null != identificacionRepoRead && identificacionRepoRead.getSize()>0) {
					String nombreArchivo = identificacionRepoRead.getOriginalFilename();
					String extension =nombreArchivo.substring(nombreArchivo.lastIndexOf(".")+1, nombreArchivo.length());					//String extension =file.substring(file.lastIndexOf(".")+1, file.length());
					log.info("Extension: "+extension);
					CatTipoArchivo catTipoArchivo = tipoArchivoServicio.getCatTipoArchivo(extension.toUpperCase());
					
					personaReporta.setIdentificacion(identificacionRepoRead.getBytes());
					personaReporta.setNombreArchivoIdentificacion(nombreArchivo);
					personaReporta.setCatTipoArchivo(catTipoArchivo);
				}
				if(null != estado) {
					CatEstado catEstado= new CatEstado();
					catEstado.setIdEstado(estado);
					personaReporta.setCatEstado(catEstado);
				}
				if(null != municipio ) {
					CatMunicipio catMunicipio= new CatMunicipio();
					catMunicipio.setIdMunicipio(municipio);
					personaReporta.setCatMunicipio(catMunicipio);
				}
				if(null != cp ) {
					CatCp catCp= new CatCp();
					catCp.setIdCp(cp);
					personaReporta.setCatCp(catCp); 
				}
				if(null != colonia ) {
					CatColonia catColonia= new CatColonia();
					catColonia.setIdColonia(colonia);
					personaReporta.setCatColonia(catColonia);
				}
				if(null != edad ) {
					CatEdad catEdad= new CatEdad();
					catEdad.setIdEdad(edad);
					personaReporta.setCatEdad(catEdad); 
				}
				if(null != sexo) {
					CatSexo catSexo= new CatSexo();
					catSexo.setIdSexo(sexo);
					personaReporta.setCatSexo(catSexo);
				}
				if(null != medio) {
					CatMedioReporte catMedioReporte= new CatMedioReporte();
					catMedioReporte.setIdMedioReporte(medio);
					personaReporta.setCatMedioReporte(catMedioReporte);
				}
				if(null != nacionalidad) {
					CatNacionalidad catNacionalidad = new CatNacionalidad();
					catNacionalidad.setIdNacionalidad(nacionalidad);		
					personaReporta.setCatNacionalidad(catNacionalidad);}
				if(null != relacion) {
					CatParentesco catParentesco= new CatParentesco();
					catParentesco.setIdParentesco(relacion);
					personaReporta.setCatParentesco(catParentesco);
				}
				if(null != ocupacion ) {
					CatOcupacion catOcupacion= new CatOcupacion();
					catOcupacion.setIdOcupacion(ocupacion);
					personaReporta.setCatOcupacion(catOcupacion);
				}
				if(null != acompanaba) {
					CatSiNo catSiNo= new CatSiNo();
					catSiNo.setIdSiNo(acompanaba);
					personaReporta.setCatSiNo(catSiNo);
				}
				
				personaReporta.setCalle(calle.toUpperCase());
				personaReporta.setTelefono1(telefono);
				personaReporta.setCorreoElectronico(correo.toUpperCase());
				personaReporta.setTelefono2(celular);
				CatEstatus estatus = new CatEstatus();		
				estatus.setIdEstatus(1);		
				personaReporta.setCatEstatus(estatus);
				personaReporta.setUsuario1(getNameUser());
				personaReporta.setFechaAlta(new Date());
				
				personaReporta=personaReportaServicio.savePersonaReporta(personaReporta);
				if(null != personaReporta && personaReporta.getIdPersonaReporta() >0) {
					commonResponse.setEstatus(1);
					commonResponse.setDescripcion("La informacion se guardo correctamente.");				
				}
				
			}
		}catch (Exception e) {
			log.error("Ocurrio un inconveniente al guardar la informacion:"+e.getMessage());
			return new ResponseEntity<>(commonResponse, HttpStatus.OK);
		}
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/eliminar-archivo-evidencia", method = RequestMethod.POST)
	public ResponseEntity<CommonResponse> eliminarArchivoEvidencia(
			@RequestParam("idArchivoEvidencia") Integer idArchivoEvidencia) {

		CommonResponse commonResponse = new CommonResponse();
		commonResponse.setEstatus(-3);
		commonResponse.setDescripcion("Se genero un inconveniente al eliminar la informacion.");
		try {
			 archivoExpedienteServicio.deleteArchivoExpediente(Integer.valueOf(idArchivoEvidencia));
			log.info("Archivo eliminado:"+idArchivoEvidencia);
			commonResponse.setEstatus(1);
			commonResponse.setDescripcion("La informacion se guardo correctamente.");
		} catch (Exception e) {
			log.error("Ocurrio un inconveniente al eliminar evidencia:"+e.getMessage());
			return new ResponseEntity<>(commonResponse, HttpStatus.OK);
		}		
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}
	
	/* Obtiene todos los cp del municipio que se envia*/
	@RequestMapping(value = "/cp-por-estado-municipio", method = RequestMethod.POST, produces = "application/json")//@ResponseBody
	public ResponseEntity< List<CatCp> > getCpMunicipio(@RequestParam("codigoMunicipio") String codigoMunicipio){
		List<CatCp> codigosPostales = new ArrayList<CatCp>();
		try {
			log.info("entro al metodo getCpMunicipio");
			codigosPostales=catCpServicio.getCatCpPorEstadoMunicipio("13", codigoMunicipio);	
		}catch(Exception e) {
			log.error("Error en cp-por-estadoMunicipio:"+e.getMessage()+" CAUSA:"+e.getCause());
		}
		return new ResponseEntity<>(codigosPostales, HttpStatus.OK);
    }
	
	/* obtiene todas las colonias del cp enviado*/
	@RequestMapping(value = "/colonia-por-cp", method = RequestMethod.POST, produces = "application/json")//@ResponseBody
	public ResponseEntity< List<CatColonia> > getColoniaPorCp(@RequestParam("codigoCp") String codigoCp){
		List<CatColonia> colonias = new ArrayList<CatColonia>();
		try {
			log.info("entro al metodo getColoniaPorCp");
			colonias=catColoniaServicio.getCatColoniasPorCp(codigoCp);	
		}catch(Exception e) {
			log.error("Error en colonia-por-cp:"+e.getMessage()+" CAUSA:"+e.getCause());
		}
		return new ResponseEntity<>(colonias, HttpStatus.OK);
	}
	
	/* Obtiene todos los cp del municipio que se envia*/
	@RequestMapping(value = "/cp-por-estado-municipios", method = RequestMethod.POST, produces = "application/json")//@ResponseBody
	public ResponseEntity< List<CatCp> > getCpMunicipios(@RequestParam("codigoEstado") String codigoEstado, @RequestParam("codigoMunicipio") String codigoMunicipio){
		List<CatCp> codigosPostales = new ArrayList<CatCp>();
		try {
			log.info("entro al metodo getCpMunicipio");
			codigosPostales=catCpServicio.getCatCpPorEstadoMunicipio(codigoEstado, codigoMunicipio);	
		}catch(Exception e) {
			log.error("Error en cp-por-estadoMunicipio:"+e.getMessage()+" CAUSA:"+e.getCause());
		}
		return new ResponseEntity<>(codigosPostales, HttpStatus.OK);
    }	

	/* Obtiene todos los cp del municipio que se envia*/
	@RequestMapping(value = "/municipios-por-estado", method = RequestMethod.POST, produces = "application/json")//@ResponseBody
	public ResponseEntity< List<CatMunicipio> > getMunicipioPorEstado(@RequestParam("codigoEstado") String codigoEstado){
		List<CatMunicipio> catMunicipio = new ArrayList<CatMunicipio>();
		try {
			
			catMunicipio=catMunicipioServicio.getCatMunicipiosPorEstado(codigoEstado);	
		}catch(Exception e) {
			
		}
		return new ResponseEntity<>(catMunicipio, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/guardar-Desaparecido-Edit", method = RequestMethod.POST)//@ResponseBody
	public  ResponseEntity<CommonResponse>  guardarDesaparecidoEdit(
			@RequestParam ("idDesaparecidoDesa") Integer idDesaparecido,
			@RequestParam("idExpediente") String idExpediente,
			@RequestParam("declaranteDesa") String declarante,
			@RequestParam("nombreDesaparecidoDesa") String nombreDesaparecido,
			@RequestParam("apellidoPaternoDesaparecidoDesa") String apellidoPaterno,
			@RequestParam("apellidoMaternoDesaparecidoDesa") String apellidoMaterno,
			@RequestParam("fechaNacimientoDesa") String fechaNacimiento,
			@RequestParam("edadDesaparecidoDesa") String edadDesaparecido,
			@RequestParam("sexoDesaparecidoDesa") String sexoDesaparecido,
			@RequestParam("curpDesa") String curp,
			@RequestParam("rfcDesa") String rfc, 
			@RequestParam("estadoCivilDesa") String estadoCivil,
			@RequestParam("ocupacionDesaparecidoDesa") String ocupacionDesaparecido,
			@RequestParam("habitantesDesa") String habitantes,
			@RequestParam("carpetaInvestigacionDesa") String carpetaInvestigacion,
			@RequestParam("nacionalidadDesaparecidoDesa") String nacionalidadDesaparecido,
			@RequestParam("estadoDesaparecidoDesa") String estadoDesaparecido,
			@RequestParam("municipioDesaparecidoDesa") String municipioDesaparecido,
			@RequestParam("cpDesaparecidoDesa") String cpDesaparecido,
			@RequestParam("coloniaDesaparecidoDesa") String coloniaDesaparecido,
			@RequestParam("calleDesaparecidoDesa") String calleDesaparecido,
			// des fisica
			@RequestParam("colorOjosDesa") String colorOjos,
			@RequestParam("tipoOjosDesa") String tipoOjos,
			@RequestParam("ojoDesa") String ojo,
			@RequestParam("colorCabelloDesa") String colorCabello, 
			@RequestParam("longitudDesa") String longitud,
			@RequestParam("tipoCabelloDesa") String tipoCabello, 
			@RequestParam("cabelloDesa") String cabello,
			@RequestParam("frenteDesa") String frente, 
			@RequestParam("bocaDesa") String boca,
			@RequestParam("labiosDesa") String labios,
			@RequestParam("dentaduraDesa") String dentadura, 
			@RequestParam("detalleDentaduraDesa") String detalleDentadura,
			@RequestParam("baseNarizDesa") String baseNariz, 
			@RequestParam("formaDesa") String forma,
			@RequestParam("tamanioDesa") String tamanio,
			@RequestParam("complexionDesa") String complexion, 
			@RequestParam("pesoDesa") String peso,
			@RequestParam("estaturaDesa") String estatura, 
			@RequestParam("colorPielDesa") String colorPiel,
			@RequestParam("seniasDesa") String senias,
			@RequestParam (required = false) MultipartFile fotografiaDesa,
			// salud
			@RequestParam("sangreDesa") String sangre, 
			@RequestParam("adiccionesDesa") String adicciones,
			@RequestParam("periodicidadDesa") String periodicidad, 
			@RequestParam("operacionesDesa") String operaciones,
			@RequestParam(required = false ) String descripcionOperacionesDesa,
			@RequestParam("discapacidadDesa") String discapacidad,
			@RequestParam(required = false ) String descripcionDiscapacidadDesa,
			@RequestParam("fracturasDesa") String fracturas,
			@RequestParam(required = false ) String descripcionFracturasDesa,
			//hechos
			@RequestParam("fechaDesaparicionDesa") String fechaDesaparicion,
			@RequestParam("fechaUltimoContactoDesa") String fechaUltimoContacto,
			@RequestParam("lugarDesaparicionDesa") String lugarDesaparicion,
			@RequestParam("ultimoMedioDesa") String ultimoMedio,
			@RequestParam("personaQueVioUltimaVezDesa") String personaQueVioUltimaVez,
			@RequestParam("dondeIbaDesa") String dondeIba, 
			@RequestParam("lugaresDesa") String lugares,
			@RequestParam("enemistadesDesa") String enemistades,
			@RequestParam("sospechosoDesa") String sospechoso,
			@RequestParam("actitudDesa") String actitud,
			@RequestParam("faltasDesa") String faltas,
			@RequestParam(required = false) String descripcionFaltasDesa, 
			@RequestParam("violenciaDesa") String violencia,
			@RequestParam(required = false) String descripcionViolenciaDesa,
			@RequestParam("descripcionGeneralDesa") String descripcionGeneral,
			//pertenencias
			@RequestParam("vestimentaDesa") String vestimenta, 
			@RequestParam("documentacionDesa") String documentacion,
			@RequestParam(required = false) String descripcionDocumentacionDesa,
			@RequestParam("documentoDesa") String documento,
			@RequestParam(required = false) String descripcionDocumentoDesa,
			@RequestParam("llamadasDesa") String llamadas, 
			@RequestParam(required = false ) String descripcionLlamadasDesa,
			@RequestParam("transporteDesa") String transporte,
			@RequestParam(required = false ) String descripcionTransporteDesa,	
			//redes
			@RequestParam("correoDesa") String correo,
			@RequestParam("contraseniaCorreoDesa") String contraseniaCorreo, 
			@RequestParam("facebookDesa") String facebook,
			@RequestParam("contraseniaFacebookDesa") String contraseniaFacebook, 
			@RequestParam("twitterDesa") String twitter,
			@RequestParam("contraseniaTwitterDesa") String contraseniaTwitter, 
			@RequestParam("instagramDesa") String instagram,
			@RequestParam("contraseniaInstagramDesa") String contraseniaInstagram, 
			//info adicional
			@RequestParam("hijosDesa") String hijos,
			@RequestParam(required = false ) String descripcionHijosDesa, 
			@RequestParam("pasatiemposDesa") String pasatiempos,
			@RequestParam("dialectoDesa") String dialecto, 
			@RequestParam("grupoDesa") String grupo,
			@RequestParam("estatusEconomicoDesa") String estatusEconomico, 
			@RequestParam("difusionDesa") String difusion,
			@RequestParam("constanciaDesa") String constancia
		){
		
		CommonResponse commonResponse = new CommonResponse();
		commonResponse.setEstatus(-3);
		commonResponse.setDescripcion("Se genero un inconveniente al guardar la informacion.");
		try {
			PersonaDesaparecida personaDesaparece =personaDesaparecidaServicio.getPersonaDesaparecida(idDesaparecido);
			if(null != personaDesaparece && personaDesaparece.getIdPersonaDesaparecida() >0) {
				
			}
			personaDesaparece.setIdPersonaDesaparecida(idDesaparecido);
			//String tipoExpediente ="";
			
			PersonaReporta personaReporta = new PersonaReporta();
			if (!declarante.equals("")) {
				personaReporta.setIdPersonaReporta(Integer.parseInt(declarante));
				personaDesaparece.setPersonaReporta(personaReporta);
			}

			personaDesaparece.setNombre(nombreDesaparecido.toUpperCase());
			personaDesaparece.setApaterno(apellidoPaterno.toUpperCase());
			personaDesaparece.setAmaterno(apellidoMaterno.toUpperCase());

			if (!fechaNacimiento.equals("")) {
				personaDesaparece.setFechaNacimiento(java.sql.Date.valueOf(fechaNacimiento));
			}

			CatEdad catEdad = new CatEdad();
			if (!edadDesaparecido.equals("")) {
				catEdad.setIdEdad(Integer.parseInt(edadDesaparecido));
				personaDesaparece.setCatEdad(catEdad);
			}

			CatSexo catSexo = new CatSexo();
			if (!sexoDesaparecido.equals("")) {
				catSexo.setIdSexo(Integer.parseInt(sexoDesaparecido));
				personaDesaparece.setCatSexo(catSexo);
			}

			personaDesaparece.setCurp(curp.toUpperCase());
			personaDesaparece.setRfc(rfc.toUpperCase());

			CatEstadoCivil catEstadoCivil = new CatEstadoCivil();
			if (!estadoCivil.equals("")) {
				catEstadoCivil.setIdEstadoCivil(Integer.parseInt(estadoCivil));
				personaDesaparece.setCatEstadoCivil(catEstadoCivil);
			}

			CatOcupacion catOcupacion = new CatOcupacion();
			if (!ocupacionDesaparecido.equals("")) {
				catOcupacion.setIdOcupacion(Integer.parseInt(ocupacionDesaparecido));
				personaDesaparece.setCatOcupacion(catOcupacion);
			}

			personaDesaparece.setConQuienHabita(habitantes.toUpperCase());

			if (!ocupacionDesaparecido.equals("")) {
				CatNacionalidad catNacionalidad = new CatNacionalidad();
				catNacionalidad.setIdNacionalidad(Integer.parseInt(nacionalidadDesaparecido));
				personaDesaparece.setCatNacionalidad(catNacionalidad);
			}

			CatEstado catEstado = new CatEstado();
			if (!estadoDesaparecido.equals("")) {
				catEstado.setIdEstado(Integer.parseInt(estadoDesaparecido));
				personaDesaparece.setCatEstado(catEstado);
			}

			CatMunicipio catMunicipio = new CatMunicipio();
			if (!municipioDesaparecido.equals("")) {
				catMunicipio.setIdMunicipio(Integer.parseInt(municipioDesaparecido));
				personaDesaparece.setCatMunicipio(catMunicipio);
			}

			CatCp catCp = new CatCp();
			if (!cpDesaparecido.equals("")) {
				catCp.setIdCp(Integer.parseInt(cpDesaparecido));
				personaDesaparece.setCatCp(catCp);
			}

			CatColonia catColonia = new CatColonia();
			if (!coloniaDesaparecido.equals("")) {
				catColonia.setIdColonia(Integer.parseInt(coloniaDesaparecido));
				personaDesaparece.setCatColonia(catColonia);
			}

			personaDesaparece.setCalle(calleDesaparecido.toUpperCase());

			CatColorOjo catColorOjo = new CatColorOjo();
			if (!colorOjos.equals("")) {
				catColorOjo.setIdColorOjo(Integer.parseInt(colorOjos));
				personaDesaparece.setCatColorOjo(catColorOjo);
			}

			CatTipoOjo catTipoOjo = new CatTipoOjo();
			if (!tipoOjos.equals("")) {
				catTipoOjo.setIdTipoOjo(Integer.parseInt(tipoOjos));
				personaDesaparece.setCatTipoOjo(catTipoOjo);
			}
			personaDesaparece.setDetalleOjo(ojo);
			
			CatColorCabello catColorCabello = new CatColorCabello();
			if (!colorCabello.equals("")) {
				catColorCabello.setIdColorCabello(Integer.parseInt(colorCabello));
				personaDesaparece.setCatColorCabello(catColorCabello);
			}

			CatLongitudCabello catLongitudCabello = new CatLongitudCabello();
			if (!longitud.equals("")) {
				catLongitudCabello.setIdLognitudCabello(Integer.parseInt(longitud));
				personaDesaparece.setCatLongitudCabello(catLongitudCabello);
			}

			CatTipoCabello catTipoCabello = new CatTipoCabello();
			if (!tipoCabello.equals("")) {
				catTipoCabello.setIdTipoCabello(Integer.parseInt(tipoCabello));
				personaDesaparece.setCatTipoCabello(catTipoCabello);
			}

			personaDesaparece.setDescripcionCabello(cabello.toUpperCase());

			CatFrente catFrente = new CatFrente();
			if (!frente.equals("")) {
				catFrente.setIdFrente(Integer.parseInt(frente));
				personaDesaparece.setCatFrente(catFrente);
			}

			CatBoca catBoca = new CatBoca();
			if (!boca.equals("")) {
				catBoca.setIdBoca(Integer.parseInt(boca));
				personaDesaparece.setCatBoca(catBoca);
			}

			CatLabio catLabio = new CatLabio();
			if (!labios.equals("")) {
				catLabio.setIdLabio(Integer.parseInt(labios));
				personaDesaparece.setCatLabio(catLabio);
			}

			CatDentadura catDentadura = new CatDentadura();
			if (!dentadura.equals("")) {
				catDentadura.setIdDentadura(Integer.parseInt(dentadura));
				personaDesaparece.setCatDentadura(catDentadura);
			}

			personaDesaparece.setDetalleDentadura(detalleDentadura.toUpperCase());

			CatBaseNariz catBaseNariz = new CatBaseNariz();
			if (!baseNariz.equals("")) {
				catBaseNariz.setIdBaseNariz(Integer.parseInt(baseNariz));
				personaDesaparece.setCatBaseNariz(catBaseNariz);
			}

			CatFormaNariz catFormaNariz = new CatFormaNariz();
			if (!forma.equals("")) {
				catFormaNariz.setIdFormaNariz(Integer.parseInt(forma));
				personaDesaparece.setCatFormaNariz(catFormaNariz);
			}

			CatTamanioNariz catTamanioNariz = new CatTamanioNariz();
			if (!tamanio.equals("")) {
				catTamanioNariz.setIdTamanioNariz(Integer.parseInt(tamanio));
				personaDesaparece.setCatTamanioNariz(catTamanioNariz);
			}

			CatComplexion catComplexion = new CatComplexion();
			if (!complexion.equals("")) {
				catComplexion.setIdComplexion(Integer.parseInt(complexion));
				personaDesaparece.setCatComplexion(catComplexion);
			}

			if (!peso.equals("")) {
				personaDesaparece.setPeso(Float.parseFloat(peso));
			}

			if (!estatura.equals("")) {
				personaDesaparece.setEstatura(Float.parseFloat(estatura));
			}

			CatTez catTez = new CatTez();
			if (!colorPiel.equals("")) {
				catTez.setIdTez(Integer.parseInt(colorPiel));
				personaDesaparece.setCatTez(catTez);
			}

			personaDesaparece.setSeniaParticular(senias.toUpperCase());
			
			if(null != fotografiaDesa && fotografiaDesa.getSize()>0) {
				//String nombreArchivo = identificacionRepoRead.getOriginalFilename();
				//String extension =nombreArchivo.substring(nombreArchivo.lastIndexOf(".")+1, nombreArchivo.length());
				//CatTipoArchivo catTipoArchivo = tipoArchivoServicio.getCatTipoArchivo(extension.toUpperCase());				
				personaDesaparece.setFotoPersona(fotografiaDesa.getBytes());
				//personaReporta.setNombreArchivoIdentificacion(nombreArchivo);
				//personaReporta.setCatTipoArchivo(catTipoArchivo);
			}

			CatTipoSangre catTipoSangre = new CatTipoSangre();
			if (!sangre.equals("")) {
				catTipoSangre.setIdTipoSangre(Integer.parseInt(sangre));
				personaDesaparece.setCatTipoSangre(catTipoSangre);
			}

			personaDesaparece.setAdiccion(adicciones.toUpperCase());

			CatPeriodicidad catPeriodicidad = new CatPeriodicidad();
			if (!periodicidad.equals("")) {
				catPeriodicidad.setIdPeriodicidad(Integer.parseInt(periodicidad));
				personaDesaparece.setCatPeriodicidad(catPeriodicidad);
			}

			CatSiNo operacion = new CatSiNo();
			if (!operaciones.equals("")) {
				operacion.setIdSiNo(Integer.parseInt(operaciones));
				personaDesaparece.setOperaciones(operacion);
			}
			if(null != descripcionOperacionesDesa) {
				personaDesaparece.setDetalleOperacion(descripcionOperacionesDesa.toUpperCase());				
			}


			if (null != discapacidad && !discapacidad.equals("")) {
				personaDesaparece.setPadecimientoDiscapacidad(Integer.parseInt(discapacidad));
			}
			
			if(null != descripcionDiscapacidadDesa) {
				personaDesaparece.setDetallePadecimiento(descripcionDiscapacidadDesa.toUpperCase());
			}

			if (null != fracturas &&!fracturas.equals("")) {
				CatSiNo fractura = new CatSiNo();
				fractura.setIdSiNo(Integer.parseInt(fracturas));
				personaDesaparece.setFracturas(fractura);
			}

			if(null != descripcionFracturasDesa) {
				personaDesaparece.setDetalleFractura(descripcionFracturasDesa.toUpperCase());				
			}
			

			if (!fechaDesaparicion.equals("")) {
				personaDesaparece.setFechaDesaparcion(java.sql.Date.valueOf(fechaDesaparicion));
			}

			if (!fechaDesaparicion.equals("")) {
				personaDesaparece.setFechaUltimoContacto(java.sql.Date.valueOf(fechaUltimoContacto));
			}

			CatLugar catLugar = new CatLugar();
			if (!lugarDesaparicion.equals("")) {
				catLugar.setIdLugar(Integer.parseInt(lugarDesaparicion));
				personaDesaparece.setCatLugar(catLugar);
			}

			CatMedioContacto catMedioContacto = new CatMedioContacto();
			if (!ultimoMedio.equals("")) {
				catMedioContacto.setIdMedioContacto(Integer.parseInt(ultimoMedio));
				personaDesaparece.setCatMedioContacto(catMedioContacto);
			}

			CatParentesco catParentesco = new CatParentesco();
			if (!personaQueVioUltimaVez.equals("")) {
				catParentesco.setIdParentesco(Integer.parseInt(personaQueVioUltimaVez));
				personaDesaparece.setCatParentesco(catParentesco);
			}

			personaDesaparece.setaDondeIba(dondeIba.toUpperCase());
			personaDesaparece.setLugarFrecuente(lugares.toUpperCase());
			personaDesaparece.setEnemistad(enemistades.toUpperCase());
			personaDesaparece.setSospecho(sospechoso.toUpperCase());
			personaDesaparece.setActitudExtrania(actitud.toUpperCase());

			
			if (null != faltas && !faltas.equals("")) {
				CatSiNo falta = new CatSiNo();
				falta.setIdSiNo(Integer.parseInt(faltas));
				personaDesaparece.setFaltas(falta);
			}
			if (null != descripcionFaltasDesa && !descripcionFaltasDesa.equals("")) {
				personaDesaparece.setDetalleFaltaACasa(descripcionFaltasDesa.toUpperCase());
			}
			

			
			if (null != violencia && !violencia.equals("")) {
				CatSiNo violencias = new CatSiNo();
				violencias.setIdSiNo(Integer.parseInt(violencia));
				personaDesaparece.setViolencia(violencias);
			}
			if (null != descripcionViolenciaDesa && !descripcionViolenciaDesa.equals("")) {
				personaDesaparece.setDetalleViolencia(descripcionViolenciaDesa.toUpperCase());
			}
			
			personaDesaparece.setHechos(descripcionGeneral.toUpperCase());
			personaDesaparece.setVestimenta(vestimenta.toUpperCase());

			
			if (null != documentacion && !documentacion.equals("")) {
				CatSiNo llevoDocumento = new CatSiNo();
				llevoDocumento.setIdSiNo(Integer.parseInt(documentacion));
				personaDesaparece.setLlevoDocumento(llevoDocumento);
			}

			if (null != descripcionDocumentacionDesa && !descripcionDocumentacionDesa.equals("")) {
				personaDesaparece.setDetalleDocumento(descripcionDocumentacionDesa.toUpperCase());
			}
			

			if (null != documento && !documento.equals("")) {
				CatSiNo dejoDocumento = new CatSiNo();
				dejoDocumento.setIdSiNo(Integer.parseInt(documento));
				personaDesaparece.setDejoDocumento(dejoDocumento);
			}
			if (null != descripcionDocumentoDesa && !descripcionDocumentoDesa.equals("")) {
				personaDesaparece.setDetalleDejoDocumento(descripcionDocumentoDesa.toUpperCase());
			}
		
			if (null!= llamadas && !llamadas.equals("")) {
				CatSiNo antedentes = new CatSiNo();
				antedentes.setIdSiNo(Integer.parseInt(llamadas));
				personaDesaparece.setAntedentes(antedentes);
			}
			
			if (null!= descripcionLlamadasDesa && !descripcionLlamadasDesa.equals("")) {
				personaDesaparece.setDetalleComunicacion(descripcionLlamadasDesa.toUpperCase());
			}			

			CatTransporte catTransporte = new CatTransporte();
			if (null != transporte && !transporte.equals("")) {
				catTransporte.setIdTransporte(Integer.parseInt(transporte));
				personaDesaparece.setCatTransporte(catTransporte);
			}
			
			if (null != descripcionTransporteDesa && !descripcionTransporteDesa.equals("")) {
				personaDesaparece.setDetalleTransporte(descripcionTransporteDesa.toUpperCase());
			}
			
			personaDesaparece.setCorreoElectronico(correo.toUpperCase());
			personaDesaparece.setContraseniaCorreo(contraseniaCorreo.toUpperCase());
			personaDesaparece.setFacebook(facebook.toUpperCase());
			personaDesaparece.setContraseniaFacebook(contraseniaFacebook.toUpperCase());
			personaDesaparece.setTwitter(twitter.toUpperCase());
			personaDesaparece.setContraseniaTwitter(contraseniaTwitter.toUpperCase());
			personaDesaparece.setInstragram(instagram.toUpperCase());
			personaDesaparece.setContraseniaInstagram(contraseniaInstagram.toUpperCase());

			
			if (null != hijos && !hijos.equals("")) {
				CatSiNo hijo = new CatSiNo();
				hijo.setIdSiNo(Integer.parseInt(hijos));
				personaDesaparece.setHijos(hijo);
			}
			
			if (null != descripcionHijosDesa && !descripcionHijosDesa.equals("")) {
				personaDesaparece.setDetalleHijos(descripcionHijosDesa.toUpperCase());
			}
			
			personaDesaparece.setPasatiempo(pasatiempos.toUpperCase());

			CatDialecto catDialecto = new CatDialecto();
			if (!dialecto.equals("")) {
				catDialecto.setIdDialecto(Integer.parseInt(dialecto));
				personaDesaparece.setCatDialecto(catDialecto);
			}

			CatGrupoEtnico catGrupoEtnico = new CatGrupoEtnico();
			if (!grupo.equals("")) {
				catGrupoEtnico.setIdGrupoEtnico(Integer.parseInt(grupo));
				personaDesaparece.setCatGrupoEtnico(catGrupoEtnico);
			}

			CatEstatusEconomico catEstatusEconomico = new CatEstatusEconomico();
			if (!estatusEconomico.equals("")) {
				catEstatusEconomico.setIdEstatusEconomico(Integer.parseInt(estatusEconomico));
				personaDesaparece.setCatEstatusEconomico(catEstatusEconomico);
			}

			if (!difusion.equals("")) {
				personaDesaparece.setDifusion(Integer.parseInt(difusion));
			}

			CatSiNo consta = new CatSiNo();
			if (!constancia.equals("")) {
				consta.setIdSiNo(Integer.parseInt(constancia));
				personaDesaparece.setConsta(consta);
			}

			LocalDate dates = LocalDate.now();
			CatEstatus estatus = new CatEstatus();
			estatus.setIdEstatus(1);
			personaDesaparece.setCatEstatus(estatus);
			personaDesaparece.setIdUsuarioAlta(getNameUser());
			personaDesaparece.setFechaAlta(java.sql.Date.valueOf(dates));

			personaDesaparece=personaDesaparecidaServicio.savePersonaDesaparecida(personaDesaparece);
			if(null != personaDesaparece && personaDesaparece.getIdPersonaDesaparecida() >0) {
				if(null != carpetaInvestigacion && !carpetaInvestigacion.equals("")) {
					Expediente expediente =expedienteServicios.getExpediente(idExpediente);
					if(null != expediente && expediente.getIdExpediente() != null) {
						expediente.setIdExpediente(idExpediente);
						expediente.setCarpetaInvestigacion(carpetaInvestigacion);
						expediente=expedienteServicios.saveExpediente(expediente);						
					}
					//aqui iria un if que su unica funcion seria verificar si lo guardo y mostrar en logs
				}
				commonResponse.setEstatus(1);
				commonResponse.setDescripcion("La informacion se guardo correctamente.");				
			}
		}catch (Exception e) {
			log.error("Ocurrio un inconveniente al guardar la informacion:"+e.getMessage());
			return new ResponseEntity<>(commonResponse, HttpStatus.OK);
		}
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}
	
	private String getNameUser() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		return currentPrincipalName;
	}
	
	@RequestMapping(value = "/guardar-acta-entrevista", method = RequestMethod.POST)//@ResponseBody
	public  ResponseEntity<CommonResponse>  guardarActa(
			@RequestParam ("numExpedienteActa") String numExpedienteActa,
			@RequestParam ("fechaActa") String fechaActa,
			@RequestParam ("horaActa") String horaActa,
			@RequestParam ("nombreActa") String nombreActa,
			@RequestParam ("aPaternoActa") String aPaternoActa,
			@RequestParam ("aMaternoActa") String aMaternoActa,
			@RequestParam ("fNacimientoActa") String fNacimientoActa,
			@RequestParam ("sexoActa") Integer sexoActa,
			@RequestParam ("eCivilActa") Integer eCivilActa,
			@RequestParam ("nacionalidadActa") Integer nacionalidadActa,			
			@RequestParam ("ocupacionActa") Integer ocupacionActa,
			@RequestParam ("escolaridadActa") Integer escolaridadActa,
			@RequestParam ("estadoActa") Integer estadoActa,
			@RequestParam ("municipioActa") Integer municipioActa,			
			@RequestParam ("cpActa") Integer cpActa,			
			@RequestParam ("coloniaActa") Integer coloniaActa,
			@RequestParam ("calleNumActa") String calleNumActa,
			@RequestParam ("fisicoActa") String fisicoActa,
			@RequestParam ("aliasActa") String aliasActa,
			@RequestParam ("edadActa") Integer edadActa,
			@RequestParam ("idiomaActa") Integer idiomaActa,
			@RequestParam ("identificacionActa") Integer identificacionActa,		
			@RequestParam ("etnicoActa") Integer etnicoActa,
			@RequestParam ("leerActa") Integer leerActa,
			@RequestParam ("escribirActa") Integer escribirActa,
			@RequestParam ("dialectoActa") Integer dialectoActa,
			@RequestParam ("parentescoActa") Integer parentescoActa,
			@RequestParam ("lugarNacimientoActa") Integer lugarNacimientoActa,
			@RequestParam ("telefonoActa") BigInteger telefonoActa,
			@RequestParam ("gradoEstudioActa") Integer gradoEstudioActa,
			@RequestParam ("relatoEntrevista") String relatoEntrevista
		){
		
		CommonResponse commonResponse = new CommonResponse();
		commonResponse.setEstatus(-3);
		commonResponse.setDescripcion("Se genero un inconveniente al guardar la informacion.");
		try {
			Expediente expediente =expedienteServicios.getExpediente(numExpedienteActa);
			PersonaEntrevista personaEntrevista = new PersonaEntrevista();
			if(null != expediente && expediente.getIdExpediente() !=null) {
				
				personaEntrevista.setIdExpediente(expediente.getIdExpediente());
				
				if(null != fechaActa && !fechaActa.equals("")) {
					personaEntrevista.setFecha(java.sql.Date.valueOf(fechaActa));
				}				
				if(null != horaActa && !horaActa.equals("")) {
					LocalTime localTime = LocalTime.parse(horaActa);
					personaEntrevista.setHora(Time.valueOf(localTime));
				}
				if(null != nombreActa && !nombreActa.equals("")) {
					personaEntrevista.setNombre(nombreActa.toUpperCase());					
				}
				if(null != aPaternoActa && !aPaternoActa.equals("")) {
					personaEntrevista.setApaterno(aPaternoActa.toUpperCase());			
				}
				if(null != aMaternoActa && !aMaternoActa.equals("")) {
					personaEntrevista.setAmaterno(aMaternoActa.toUpperCase());			
				}			
				if(null != fNacimientoActa && !fNacimientoActa.equals("")) {
					personaEntrevista.setFechaNacimiento(java.sql.Date.valueOf(fNacimientoActa));
				}
				if(null != sexoActa) {
					personaEntrevista.setIdSexo(sexoActa);					
				}
				if(null != eCivilActa) {
					personaEntrevista.setIdEstadoCivil(eCivilActa);					
				}
				if(null != nacionalidadActa) {
					personaEntrevista.setIdNacionalidad(nacionalidadActa);
				}
				if(null != ocupacionActa) {
					personaEntrevista.setIdOcupacion(ocupacionActa);
				}
				if(null != escolaridadActa) {
					personaEntrevista.setIdEscolaridad(escolaridadActa);
				}
				if(null != estadoActa) {
					CatEstado estado = new CatEstado();
					estado.setIdEstado(estadoActa);
					personaEntrevista.setCatEstado(estado);
				}
				if(null != municipioActa) {
					CatMunicipio muni = new CatMunicipio();
					muni.setIdMunicipio(municipioActa);
					personaEntrevista.setCatMunicipio(muni);
				}
				if(null != cpActa) {
					CatCp cp = new CatCp();
					cp.setIdCp(cpActa);
					personaEntrevista.setCatCp(cp);
				}				
				if(null != coloniaActa) {
					CatColonia col = new CatColonia();
					col.setIdColonia(coloniaActa);
					personaEntrevista.setCatColonia(col);
				}
				if(null != calleNumActa && !calleNumActa.equals("")) {
					personaEntrevista.setCalle(calleNumActa.toUpperCase());			
				}
				if(null != fisicoActa && !fisicoActa.equals("")) {
					personaEntrevista.setTatuajeLunarMarca(fisicoActa.toUpperCase());		
				}
				if(null != aliasActa && !aliasActa.equals("")) {
					personaEntrevista.setAliasApodo(aliasActa.toUpperCase());			
				}
				if(null != edadActa) {
					personaEntrevista.setIdEdad(edadActa);		
				}
				if(null != idiomaActa) {
					personaEntrevista.setIdIdioma(idiomaActa);		
				}
				if(null != identificacionActa) {
					personaEntrevista.setIdTipoIdentificacion(identificacionActa);		
				}
				if(null != etnicoActa) {
					personaEntrevista.setIdGrupoEtnico(etnicoActa);			
				}
				if(null != leerActa) {
					personaEntrevista.setSabeLeer(leerActa);
				}
				if(null != escribirActa) {
					personaEntrevista.setSabeEscribir(escribirActa);			
				}				
				if(null != dialectoActa) {
					personaEntrevista.setIdDialecto(dialectoActa);			
				}
				if(null != parentescoActa) {
					personaEntrevista.setIdParentesco(parentescoActa);		
				}
				if(null != lugarNacimientoActa) {
					personaEntrevista.setLugarNacimiento(lugarNacimientoActa);		
				}
				if(null != telefonoActa) {
					personaEntrevista.setTefono(telefonoActa);			
				}
				if(null != gradoEstudioActa) {
					personaEntrevista.setIdGradoEstudio(gradoEstudioActa);		
				}
				if(null != relatoEntrevista && !relatoEntrevista.equals("") ) {
					personaEntrevista.setRelatoEntrevista(relatoEntrevista.toUpperCase());		
				}
				personaEntrevista.setIdEstatus(1);//activo
				personaEntrevista.setFechaAlta(new Date());
				personaEntrevista.setIdUsuarioAlta(getNameUser() );
				
				personaEntrevista=personaEntrevistaServicio.savePersonaEntrevista(personaEntrevista);
				if(null != personaEntrevista && personaEntrevista.getIdEntrevista() >0) {
					commonResponse.setEstatus(1);
					commonResponse.setDescripcion("La informacion se guardo correctamente.");				
				}				
			}
		}catch (Exception e) {
			log.error("Ocurrio un inconveniente al guardar la informacion:"+e.getMessage());
			return new ResponseEntity<>(commonResponse, HttpStatus.OK);
		}
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/guardar-Acta-Edit", method = RequestMethod.POST)//@ResponseBody
	public  ResponseEntity<CommonResponse>  guardarActaEdit(
			@RequestParam ("idActaEntrevista") Integer idActaEntrevista,
			@RequestParam ("numExpedienteActaRead") String numExpedienteActa,
			@RequestParam ("fechaActaRead") String fechaActa,
			@RequestParam ("horaActaRead") String horaActa,
			@RequestParam ("nombreActaRead") String nombreActa,
			@RequestParam ("aPaternoActaRead") String aPaternoActa,
			@RequestParam ("aMaternoActaRead") String aMaternoActa,
			@RequestParam ("fNacimientoActaRead") String fNacimientoActa,
			@RequestParam ("sexoActaRead") Integer sexoActa,
			@RequestParam ("eCivilActaRead") Integer eCivilActa,
			@RequestParam ("nacionalidadActaRead") Integer nacionalidadActa,			
			@RequestParam ("ocupacionActaRead") Integer ocupacionActa,
			@RequestParam ("escolaridadActaRead") Integer escolaridadActa,
			@RequestParam ("estadoActaRead") Integer estadoActa,
			@RequestParam ("municipioActaRead") Integer municipioActa,			
			@RequestParam ("cpActaRead") Integer cpActa,			
			@RequestParam ("coloniaActaRead") Integer coloniaActa,
			@RequestParam ("calleNumActaRead") String calleNumActa,
			@RequestParam ("fisicoActaRead") String fisicoActa,
			@RequestParam ("aliasActaRead") String aliasActa,
			@RequestParam ("edadActaRead") Integer edadActa,
			@RequestParam ("idiomaActaRead") Integer idiomaActa,
			@RequestParam ("identificacionActaRead") Integer identificacionActa,		
			@RequestParam ("etnicoActaRead") Integer etnicoActa,
			@RequestParam ("leerActaRead") Integer leerActa,
			@RequestParam ("escribirActaRead") Integer escribirActa,
			@RequestParam ("dialectoActaRead") Integer dialectoActa,
			@RequestParam ("parentescoActaRead") Integer parentescoActa,
			@RequestParam ("lugarNacimientoActaRead") Integer lugarNacimientoActa,
			@RequestParam ("telefonoActaRead") BigInteger telefonoActa,
			@RequestParam ("gradoEstudioActaRead") Integer gradoEstudioActa,
			@RequestParam ("relatoEntrevistaRead") String relatoEntrevista
		){
		
		CommonResponse commonResponse = new CommonResponse();
		commonResponse.setEstatus(-3);
		commonResponse.setDescripcion("Se genero un inconveniente al guardar la informacion.");
		try {
			Expediente expediente =expedienteServicios.getExpediente(numExpedienteActa);
			PersonaEntrevista personaEntrevista = new PersonaEntrevista();
			if(null != expediente && expediente.getIdExpediente() !=null) {
				personaEntrevista.setIdEntrevista( idActaEntrevista);
				personaEntrevista.setIdExpediente(expediente.getIdExpediente());
				
				if(null != fechaActa && !fechaActa.equals("")) {
					personaEntrevista.setFecha(java.sql.Date.valueOf(fechaActa));
				}				
				if(null != horaActa && !horaActa.equals("")) {
					LocalTime localTime = LocalTime.parse(horaActa);
					personaEntrevista.setHora(Time.valueOf(localTime));
				}
				if(null != nombreActa && !nombreActa.equals("")) {
					personaEntrevista.setNombre(nombreActa.toUpperCase());					
				}
				if(null != aPaternoActa && !aPaternoActa.equals("")) {
					personaEntrevista.setApaterno(aPaternoActa.toUpperCase());			
				}
				if(null != aMaternoActa && !aMaternoActa.equals("")) {
					personaEntrevista.setAmaterno(aMaternoActa.toUpperCase());			
				}			
				if(null != fNacimientoActa && !fNacimientoActa.equals("")) {
					personaEntrevista.setFechaNacimiento(java.sql.Date.valueOf(fNacimientoActa));
				}
				if(null != sexoActa) {
					personaEntrevista.setIdSexo(sexoActa);					
				}
				if(null != eCivilActa) {
					personaEntrevista.setIdEstadoCivil(eCivilActa);					
				}
				if(null != nacionalidadActa) {
					personaEntrevista.setIdNacionalidad(nacionalidadActa);
				}
				if(null != ocupacionActa) {
					personaEntrevista.setIdOcupacion(ocupacionActa);
				}
				if(null != escolaridadActa) {
					personaEntrevista.setIdEscolaridad(escolaridadActa);
				}
				if(null != estadoActa) {
					CatEstado estado = new CatEstado();
					estado.setIdEstado(estadoActa);
					personaEntrevista.setCatEstado(estado);
				}
				if(null != municipioActa) {
					CatMunicipio muni = new CatMunicipio();
					muni.setIdMunicipio(municipioActa);
					personaEntrevista.setCatMunicipio(muni);
				}
				if(null != cpActa) {
					CatCp cp = new CatCp();
					cp.setIdCp(cpActa);
					personaEntrevista.setCatCp(cp);
				}				
				if(null != coloniaActa) {
					CatColonia col = new CatColonia();
					col.setIdColonia(coloniaActa);
					personaEntrevista.setCatColonia(col);
				}
				if(null != calleNumActa && !calleNumActa.equals("")) {
					personaEntrevista.setCalle(calleNumActa.toUpperCase());			
				}
				if(null != fisicoActa && !fisicoActa.equals("")) {
					personaEntrevista.setTatuajeLunarMarca(fisicoActa.toUpperCase());		
				}
				if(null != aliasActa && !aliasActa.equals("")) {
					personaEntrevista.setAliasApodo(aliasActa.toUpperCase());			
				}
				if(null != edadActa) {
					personaEntrevista.setIdEdad(edadActa);		
				}
				if(null != idiomaActa) {
					personaEntrevista.setIdIdioma(idiomaActa);		
				}
				if(null != identificacionActa) {
					personaEntrevista.setIdTipoIdentificacion(identificacionActa);		
				}
				if(null != etnicoActa) {
					personaEntrevista.setIdGrupoEtnico(etnicoActa);			
				}
				if(null != leerActa) {
					personaEntrevista.setSabeLeer(leerActa);
				}
				if(null != escribirActa) {
					personaEntrevista.setSabeEscribir(escribirActa);			
				}				
				if(null != dialectoActa) {
					personaEntrevista.setIdDialecto(dialectoActa);			
				}
				if(null != parentescoActa) {
					personaEntrevista.setIdParentesco(parentescoActa);		
				}
				if(null != lugarNacimientoActa) {
					personaEntrevista.setLugarNacimiento(lugarNacimientoActa);		
				}
				if(null != telefonoActa) {
					personaEntrevista.setTefono(telefonoActa);			
				}
				if(null != gradoEstudioActa) {
					personaEntrevista.setIdGradoEstudio(gradoEstudioActa);		
				}
				if(null != relatoEntrevista && !relatoEntrevista.equals("") ) {
					personaEntrevista.setRelatoEntrevista(relatoEntrevista.toUpperCase());		
				}
				personaEntrevista.setIdEstatus(1);//activo
				personaEntrevista.setFechaAlta(new Date());
				personaEntrevista.setIdUsuarioAlta(getNameUser() );
				
				personaEntrevista=personaEntrevistaServicio.savePersonaEntrevista(personaEntrevista);
				if(null != personaEntrevista && personaEntrevista.getIdEntrevista() >0) {
					commonResponse.setEstatus(1);
					commonResponse.setDescripcion("La informacion se guardo correctamente.");				
				}				
			}
		}catch (Exception e) {
			log.error("Ocurrio un inconveniente al guardar la informacion:"+e.getMessage());
			return new ResponseEntity<>(commonResponse, HttpStatus.OK);
		}
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/exportar-concentrado", method = RequestMethod.GET)
	public @ResponseBody String exportarConcentrado(HttpServletRequest request, HttpServletResponse response,
			String idExpediente,String idsexo,String idEdad,String idMunicipio,String idEstatusLocalizado){
		String json = null,msg =null;
		File fileInd= null;	
		response.setContentType("APPLICATION/json");			// en caso de error
		
		try {
			fileInd =consultaService.generarConcentrado(idExpediente, idsexo, idEdad, idMunicipio, idEstatusLocalizado);
			if(fileInd != null) {

				String fecha=Utils.dateToString(new Date(),"ddMMyyyy hh:mm");
				response.setContentType("APPLICATION/OCTET-STREAM");
				response.addHeader("Content-Disposition", "attachment; filename=Concentrado_"+fecha+".xls");
				byte[] byteArray = FileUtils.readFileToByteArray(fileInd);
				BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		        bos.write(byteArray);
		        bos.flush();
		        bos.close();
		        log.info("exportacion correcta");
			}else {
				msg="La informacion no se exporto correctamente";				
				log.info(msg);
				json= "{" +msg+"}";
			}
			if (fileInd != null && fileInd.exists()) {
				fileInd.delete();
				log.info("Archivo eliminado Xls de tomcat.");
		    }
		} catch (Exception e) {
			msg="Ocurrio un inconveniente al exportar concentrado:"+e.getMessage();
			json= "{" +msg+"}";
		}
		return null;
	}
	
}
