package mx.gob.cbpeh.bpd.controlador;

import java.io.BufferedOutputStream;
import java.io.File;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import mx.gob.cbpeh.bpd.dto.BusquedaLargaDataConcentradoDto;
import mx.gob.cbpeh.bpd.dto.ColaboracionesConcentradoDto;
import mx.gob.cbpeh.bpd.dto.CommonRequest;
import mx.gob.cbpeh.bpd.dto.CommonResponse;
import mx.gob.cbpeh.bpd.dto.CommonResponseListElement;
import mx.gob.cbpeh.bpd.dto.ConsultaReporteDto;
import mx.gob.cbpeh.bpd.dto.RegistroDiarioDto;
import mx.gob.cbpeh.bpd.modelo.ArchivoExpediente;
import mx.gob.cbpeh.bpd.modelo.Busqueda;
import mx.gob.cbpeh.bpd.modelo.CatColonia;
import mx.gob.cbpeh.bpd.modelo.CatCp;
import mx.gob.cbpeh.bpd.modelo.CatEstatusColaboracion;
import mx.gob.cbpeh.bpd.modelo.CatInstitucion;
import mx.gob.cbpeh.bpd.modelo.CatLugarBusqueda;
import mx.gob.cbpeh.bpd.modelo.CatMunicipio;
import mx.gob.cbpeh.bpd.modelo.CatTipoArchivo;
import mx.gob.cbpeh.bpd.modelo.Colaboracion;
import mx.gob.cbpeh.bpd.modelo.ColaboracionLugarBusqueda;
import mx.gob.cbpeh.bpd.modelo.ColaboracionLugarBusquedaPK;
import mx.gob.cbpeh.bpd.modelo.PersonaReporta;
import mx.gob.cbpeh.bpd.servicio.ArchivoExpedienteServicio;
import mx.gob.cbpeh.bpd.servicio.BusquedaServicio;
import mx.gob.cbpeh.bpd.servicio.CatColoniaServicio;
import mx.gob.cbpeh.bpd.servicio.CatCpServicio;
import mx.gob.cbpeh.bpd.servicio.CatEstadoServicio;
import mx.gob.cbpeh.bpd.servicio.CatEstatusLocalizadoServicio;
import mx.gob.cbpeh.bpd.servicio.CatEstatusServicio;
import mx.gob.cbpeh.bpd.servicio.CatInstitucionServicio;
import mx.gob.cbpeh.bpd.servicio.CatMunicipioServicio;
import mx.gob.cbpeh.bpd.servicio.CatTipoArchivoServicio;
import mx.gob.cbpeh.bpd.servicio.ColaboracionLugarBusquedaServicio;
import mx.gob.cbpeh.bpd.servicio.ColaboracionServicio;
import mx.gob.cbpeh.bpd.servicio.ConsultaService;
import mx.gob.cbpeh.bpd.servicio.ExpedienteServicio;
import mx.gob.cbpeh.bpd.servicio.PersonaReportaServicio;
import mx.gob.cbpeh.bpd.util.Utils;

@Controller
@RequestMapping(value = "/accionesbusqueda")
public class ProcesosAccionesBusquedaControlador {

	private static final Logger log = LoggerFactory.getLogger(AccionesBusquedaControlador.class);

	@Autowired
	ExpedienteServicio expedienteServicios;
	@Autowired
	private ExpedienteServicio expedienteServicio;
	@Autowired
	CatEstatusServicio catEstatusServicio;
	@Autowired
	CatMunicipioServicio catMunicipioServicio;
	@Autowired
	CatCpServicio catCpServicio;
	@Autowired
	CatColoniaServicio catColoniaServicio;
	@Autowired
	CatEstatusLocalizadoServicio catEstatusLocalizadoServicio;
	@Autowired
	CatEstadoServicio estadoServicio;
	@Autowired
	BusquedaServicio busquedaServicio;
	@Autowired
	CatTipoArchivoServicio tipoArchivoServicio;
	@Autowired
	ArchivoExpedienteServicio archivoExpedienteServicio;
	@Autowired
	PersonaReportaServicio personaReportaServicio;
	@Autowired
	ColaboracionServicio colaboracionServicio;
	@Autowired
	ColaboracionLugarBusquedaServicio colaboracionLugarBusquedaServicio;
	@Autowired
	CatInstitucionServicio catInstitucionServicio;
	@Autowired
	ConsultaService consultaService;

	/* Obtiene todos los cp del municipio que se envia */
	@RequestMapping(value = "/cp-por-estado-municipio", method = RequestMethod.POST, produces = "application/json") // @ResponseBody
	public ResponseEntity<List<CatCp>> getCpMunicipio(@RequestParam("codigoMunicipio") String codigoMunicipio) {
		List<CatCp> codigosPostales = new ArrayList<CatCp>();
		try {
			log.info("entro al metodo getCpMunicipio");
			codigosPostales = catCpServicio.getCatCpPorEstadoMunicipio("13", codigoMunicipio);
		} catch (Exception e) {
			log.error("Error en cp-por-estadoMunicipio:" + e.getMessage() + " CAUSA:" + e.getCause());
		}
		return new ResponseEntity<>(codigosPostales, HttpStatus.OK);
	}

	/* obtiene todas las colonias del cp enviado */
	@RequestMapping(value = "/colonia-por-cp", method = RequestMethod.POST, produces = "application/json") // @ResponseBody
	public ResponseEntity<List<CatColonia>> getColoniaPorCp(@RequestParam("codigoCp") String codigoCp) {
		List<CatColonia> colonias = new ArrayList<CatColonia>();
		try {
			log.info("entro al metodo getColoniaPorCp");
			colonias = catColoniaServicio.getCatColoniasPorCp(codigoCp);
		} catch (Exception e) {
			log.error("Error en colonia-por-cp:" + e.getMessage() + " CAUSA:" + e.getCause());
		}
		return new ResponseEntity<>(colonias, HttpStatus.OK);
	}

	/* Obtiene todos los cp del municipio que se envia */
	@RequestMapping(value = "/municipios-por-estado", method = RequestMethod.POST, produces = "application/json") // @ResponseBody
	public ResponseEntity<List<CatMunicipio>> getMunicipioPorEstado(@RequestParam("codigoEstado") String codigoEstado) {
		List<CatMunicipio> catMunicipio = new ArrayList<CatMunicipio>();
		try {
			log.info("entro al metodo getCpMunicipio");
			catMunicipio = catMunicipioServicio.getCatMunicipiosPorEstado(codigoEstado);
		} catch (Exception e) {
			log.error("Error en cp-por-estadoMunicipio:" + e.getMessage() + " CAUSA:" + e.getCause());
		}
		return new ResponseEntity<>(catMunicipio, HttpStatus.OK);
	}

	/* guarda la informacion de la pantalla de accciones de busqueda */
	@RequestMapping(value = "/guardar-accion-busqueda", method = RequestMethod.POST) // @ResponseBody
	public ResponseEntity<CommonResponse> guardarAccionBusqueda(
			@RequestParam("numExpedienteAb") String idExpediente,
			@RequestParam("fechaAccionAb") String fechaAccion,
			@RequestParam("estatusAb") Integer idEstatus,
			@RequestParam("municipioAb") Integer idMunicipio,
			@RequestParam("cpAb") Integer idCp,
			@RequestParam("coloniaAb") Integer idColonia,
			@RequestParam("calleNumeroAb") String calleNumero,
			@RequestParam("latitudAb") Float latitud,
			@RequestParam("longitudAb") Float longitud,
			@RequestParam("reseniaAb") String resenia,
			@RequestParam("descripcionEvidenciaAb") String archivoDescripcion,
			@RequestParam("evidenciaAccionAb") MultipartFile file) {

		CommonResponse commonResponse = new CommonResponse();
		commonResponse.setEstatus(-3);
		commonResponse.setDescripcion("Se genero un inconveniente al guardar la informacion.");
		ArchivoExpediente archivoExpediente = new ArchivoExpediente();

		try {

			log.info("entro al metodo guardarAccionBusqueda");
			Busqueda busqueda = new Busqueda();
			busqueda.setExpediente(idExpediente);
			LocalDate dateFechaAccion = LocalDate.parse(fechaAccion);
			busqueda.setFechaBusqueda(dateFechaAccion);
			busqueda.setIdEstatusLocalizado(idEstatus);
			busqueda.setIdMunicipio(idMunicipio);
			busqueda.setIdCp(idCp);
			busqueda.setIdColonia(idColonia);
			busqueda.setCalle(calleNumero);
			busqueda.setLatitud(latitud);
			busqueda.setLongitud(longitud);
			busqueda.setResenia(resenia);
			busqueda.setFechaAlta(new Date());
			busqueda.setUsuarioAlta(getNameUser());
			busqueda.setIdEstatus(1);
			busqueda = busquedaServicio.saveBusqueda(busqueda);
			if (busqueda != null && busqueda.getIdBusqueda() > 0) { // guardo busqueda ?
				System.out.println("idBusqueda:" + busqueda.getIdBusqueda());
				if (file.getSize() > 0) {
					String nombreArchivo = file.getOriginalFilename();
					String extension = nombreArchivo.substring(nombreArchivo.lastIndexOf(".") + 1,
							nombreArchivo.length()); // String extension =file.substring(file.lastIndexOf(".")+1,
														// file.length());
					log.info("Extension: " + extension);
					CatTipoArchivo catTipoArchivo = tipoArchivoServicio.getCatTipoArchivo(extension.toUpperCase());

					archivoExpediente.setIdExpediente(idExpediente);
					archivoExpediente.setCatTipoArchivo(catTipoArchivo);
					archivoExpediente.setFechaCarga(new Date());
					LocalTime localTime = LocalTime.now();
					archivoExpediente.setHoraCarga(Time.valueOf(localTime));
					archivoExpediente.setIdUsuarioCarga(getNameUser());
					archivoExpediente.setNombreArchivo(nombreArchivo);
					archivoExpediente.setArchivo(file.getBytes());
					archivoExpediente.setArchivoDescripcion(archivoDescripcion);
					archivoExpediente.setIdPerfilCarga(3);// acciones busqueda
					archivoExpediente.setIdBusqueda(busqueda.getIdBusqueda());
					archivoExpediente.setIdEstatusExpediente(1);
					archivoExpediente = archivoExpedienteServicio.saveArchivoExpediente(archivoExpediente);
					if (archivoExpediente != null && archivoExpediente.getIdArchivoExpediente() > 0) {// guardo el
																										// archivo?
						log.info("Archivo guardado:" + archivoExpediente.getIdArchivoExpediente());
						commonResponse.setEstatus(1);
						commonResponse.setDescripcion("La informacion se guardo correctamente.");
					}
				} else if (busqueda != null && busqueda.getIdBusqueda() > 0 && file.getSize() == 0) {// busqueda sin
																										// archivo
					commonResponse.setEstatus(1);
					commonResponse.setDescripcion("La informacion se guardo correctamente.");
				}
			}

			if (idEstatus == 2) {
				try {
					CommonRequest commonResponses = expedienteServicio.doActualizarEstatusLocalizadoHVA(idExpediente);
					log.info("Cambio estatus: " + commonResponses.getEstatus().toString());
					commonResponse.setEstatus(1);
					commonResponse.setDescripcion(
							"La informacion se guardo correctamente,expediente previamente actualizado a localizado");
					/*
					 * if(!commonResponses.getEstatus().contains("Estatus cambiado")) {
					 * commonResponse.setEstatus(-5);
					 * commonResponse.setDescripcion("Ocurrio un inconveniente de comunicaci�n.");
					 * busquedaServicio.deleteBusqueda(busqueda.getIdBusqueda());
					 * if(archivoExpediente.getIdArchivoExpediente()>0) {
					 * archivoExpedienteServicio.deleteArchivoExpediente(archivoExpediente.
					 * getIdArchivoExpediente());
					 * }
					 * if(commonResponses.getEstatus().contains("no encontrada")) {
					 * commonResponse.setDescripcion(commonResponses.getEstatus());
					 * }
					 * }
					 */
				} catch (Exception e) {
					commonResponse.setEstatus(-4);
					commonResponse.setDescripcion("Ocurrio un inconveniente de comunicaci�n.");
					busquedaServicio.deleteBusqueda(busqueda.getIdBusqueda());
					if (archivoExpediente.getIdArchivoExpediente() > 0) {
						archivoExpedienteServicio.deleteArchivoExpediente(archivoExpediente.getIdArchivoExpediente());
					}
				}
			}
		} catch (Exception e) {
			log.error("Ocurrio un inconveniente al guardar accionBusqueda:" + e.getMessage());
			return new ResponseEntity<>(commonResponse, HttpStatus.OK);
		}
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}

	/* Obtiene todos los cp del municipio que se envia */
	@RequestMapping(value = "/cp-por-estado-municipios", method = RequestMethod.POST, produces = "application/json") // @ResponseBody
	public ResponseEntity<List<CatCp>> getCpMunicipios(@RequestParam("codigoEstado") String codigoEstado,
			@RequestParam("codigoMunicipio") String codigoMunicipio) {
		List<CatCp> codigosPostales = new ArrayList<CatCp>();
		try {
			log.info("entro al metodo getCpMunicipio");
			codigosPostales = catCpServicio.getCatCpPorEstadoMunicipio(codigoEstado, codigoMunicipio);
		} catch (Exception e) {
			log.error("Error en cp-por-estadoMunicipio:" + e.getMessage() + " CAUSA:" + e.getCause());
		}
		return new ResponseEntity<>(codigosPostales, HttpStatus.OK);
	}

	/* obtiene todas las colonias del cp enviado */
	@RequestMapping(value = "/reportantes", method = RequestMethod.POST, produces = "application/json") // @ResponseBody
	public ResponseEntity<List<PersonaReporta>> getReportantes() {
		List<PersonaReporta> reportantes = new ArrayList<PersonaReporta>();
		try {
			log.info("entro al metodo getReportantes");
			reportantes = personaReportaServicio.getPersonaReportas();
		} catch (Exception e) {
			log.error("Error en getReportantes:" + e.getMessage() + " CAUSA:" + e.getCause());
		}
		return new ResponseEntity<>(reportantes, HttpStatus.OK);
	}

	private String getNameUser() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		return currentPrincipalName;
	}

	@RequestMapping(value = "/guardar-colaboracion", method = RequestMethod.POST) // @ResponseBody
	public ResponseEntity<CommonResponse> guardarColaboracion(
			@RequestParam("numPeticion") String numPeticion,
			@RequestParam("fechaPeticion") String fechaPeticion,
			@RequestParam("solColaboracion") Integer solColaboracion,
			@RequestParam("nombreFirma") String nombreFirma,
			@RequestParam("nombres") String nombres,
			@RequestParam("aPaterno") String aPaterno,
			@RequestParam("aMaterno") String aMaterno,
			@RequestParam("estatusColaboracion") Integer estatusColaboracion,
			@RequestParam("lugaresBusqueda") List<Integer> lugaresBusqueda) {

		CommonResponse commonResponse = new CommonResponse();
		commonResponse.setEstatus(-3);
		commonResponse.setDescripcion("Se genero un inconveniente al guardar la informacion.");
		CatInstitucion institucion = null;
		Utils util = new Utils();
		String folio = "";
		try {
			log.info("entro al metodo guardarAccionBusqueda");
			Colaboracion colaboracion = new Colaboracion();

			if (null != numPeticion && !numPeticion.equals("")) {
				colaboracion.setNumeroOfficioPeticion(numPeticion.toUpperCase());
			}
			if (null != fechaPeticion && !fechaPeticion.equals("")) {
				colaboracion.setFechaPeticion(java.sql.Date.valueOf(fechaPeticion));
			}
			if (null != solColaboracion && !solColaboracion.equals("")) {

				Optional<CatInstitucion> optional = catInstitucionServicio.getCatInstitucion(solColaboracion);
				institucion = optional.get();
				colaboracion.setCatInstitucion(institucion);
			}
			colaboracion.setFirmadoPor(nombreFirma.toUpperCase());
			colaboracion.setNombre(nombres);
			if (null != aPaterno && !aPaterno.equals("")) {
				colaboracion.setApaterno(aPaterno.toUpperCase());
			}
			if (null != aMaterno && !aMaterno.equals("")) {
				colaboracion.setAmaterno(aMaterno.toUpperCase());
			}

			CatEstatusColaboracion estatus = new CatEstatusColaboracion();
			estatus.setIdEstatusColaboracion(estatusColaboracion);
			colaboracion.setCatEstatusColaboracion(estatus);

			colaboracion.setFechaAlta(new Date());
			colaboracion.setUsuarioAlta(getNameUser());
			colaboracion.setEstatusExpedienteColaboracion(1);
			folio = colaboracionServicio.getFolioColaboracion(institucion.getAbreviaturaInstitucion(),
					util.getIniciales(nombres, aPaterno, aMaterno));
			colaboracion.setIdExpedienteColaboracion(folio);
			colaboracion = colaboracionServicio.saveColaboracion(colaboracion);
			if (colaboracion != null && colaboracion.getIdExpedienteColaboracion() != null) {
				if (lugaresBusqueda.size() > 0) {
					for (Integer idLugar : lugaresBusqueda) {
						ColaboracionLugarBusqueda colaboracionLugar = new ColaboracionLugarBusqueda();
						ColaboracionLugarBusquedaPK llave = new ColaboracionLugarBusquedaPK();

						llave.setIdExpedienteColaboracion(colaboracion.getIdExpedienteColaboracion());
						llave.setIdLugarBusqueda(idLugar);
						colaboracionLugar.setId(llave);

						CatLugarBusqueda lugar = new CatLugarBusqueda();
						lugar.setIdLugarBusqueda(idLugar);

						colaboracionLugar.setCatLugarBusqueda(lugar);
						colaboracionLugar.setColaboracion(colaboracion);
						colaboracionLugar.setIdEstatus(1);
						colaboracionLugarBusquedaServicio.saveColaboracionLugarBusqueda(colaboracionLugar);
					}
				}
				commonResponse.setEstatus(1);
				commonResponse.setDescripcion("Se registro la colaboracion con folio:" + folio);
			}
		} catch (Exception e) {
			log.error("Ocurrio un inconveniente al guardar accionBusqueda:" + e.getMessage());
			return new ResponseEntity<>(commonResponse, HttpStatus.OK);
		}
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/buscar-registro-diario", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<CommonResponseListElement<RegistroDiarioDto>> buscarDiario(
			@RequestParam("anio") Integer anio,
			@RequestParam("mes") Integer mes,
			@RequestParam("idEstatus") Integer idEstatus,
			@RequestParam("idExpediente") String idExpediente) {

		List<RegistroDiarioDto> registrosDiarios = new ArrayList<RegistroDiarioDto>();
		CommonResponseListElement<RegistroDiarioDto> response = new CommonResponseListElement<RegistroDiarioDto>();
		response.setDescripcion("Se genero un inconveniente al buscar la informacion.");
		response.setEstatus(-3);

		try {
			registrosDiarios = consultaService.buscarRegistroDiario(anio, mes, idEstatus, idExpediente);

			if (registrosDiarios.size() == 0) {
				response.setEstatus(2);
				response.setDescripcion("No se encontraron registros.");
				response.setElementos(registrosDiarios);
			} else if (registrosDiarios.size() > 0) {
				response.setEstatus(1);
				response.setDescripcion("OK");
				response.setElementos(registrosDiarios);
			}
		} catch (Exception e) {
			log.error("Inconveniente al consultar registro diario:" + e.getMessage());
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/exportar-registro-diario-busqueda", method = RequestMethod.GET)
	public @ResponseBody String buscarAccionesBusqueda(HttpServletRequest request, HttpServletResponse response,
			Integer anio, Integer mes, Integer idEstatus, String idExpediente) {
		String json = null, msg = null;
		File fileInd = null;
		response.setContentType("APPLICATION/json"); // en caso de error

		try {
			fileInd = consultaService.generarRegistrodiario(anio, mes, idEstatus, idExpediente);
			if (fileInd != null) {

				String fecha = Utils.dateToString(new Date(), "ddMMyyyy hh:mm");
				response.setContentType("APPLICATION/OCTET-STREAM");
				response.addHeader("Content-Disposition",
						"attachment; filename=RegistroDiarioBusqueda_" + fecha + ".xls");
				byte[] byteArray = FileUtils.readFileToByteArray(fileInd);
				BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
				bos.write(byteArray);
				bos.flush();
				bos.close();
				log.info("exportacion correcta");
			} else {
				msg = "La informacion no se exporto correctamente";
				log.info(msg);
				json = "{" + msg + "}";
			}
			if (fileInd != null && fileInd.exists()) {
				fileInd.delete();
				log.info("Archivo eliminado Xls de tomcat.");
			}
		} catch (Exception e) {
			msg = "Ocurrio un inconveniente al exportar registro diario:" + e.getMessage();
			json = "{" + msg + "}";
		}
		return null;
	}

	@RequestMapping(value = "/buscar-colaboraciones", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<CommonResponseListElement<ColaboracionesConcentradoDto>> buscarColaboraciones(
			@RequestParam("idExpedienteColaboracion") String idExpedienteColaboracion,
			@RequestParam("fechaPeticion") String fechaPeticion,
			@RequestParam("idInstitucion") String idInstitucion,
			@RequestParam("idEstatusColaboracion") String idEstatusColaboracion) {
		List<ColaboracionesConcentradoDto> colaboraciones = new ArrayList<ColaboracionesConcentradoDto>();
		CommonResponseListElement<ColaboracionesConcentradoDto> response = new CommonResponseListElement<ColaboracionesConcentradoDto>();
		response.setDescripcion("Se genero un inconveniente al buscar la informacion.");
		response.setEstatus(-3);
		try {
			colaboraciones = consultaService.buscarColaboracion(idExpedienteColaboracion, fechaPeticion, idInstitucion,
					idEstatusColaboracion);
			response.setDescripcion(String.valueOf(colaboraciones.size()));
			if (colaboraciones.size() == 0) {
				response.setEstatus(2);
				response.setDescripcion("No se encontraron registros.");
				response.setElementos(colaboraciones);
			} else if (colaboraciones.size() > 0) {
				response.setEstatus(1);
				response.setDescripcion("OK");
				response.setElementos(colaboraciones);
			}
		} catch (Exception e) {
			log.error("Inconveniente al consultar registro diario:" + e.getMessage());
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/exportar-concentrado-colaboraciones", method = RequestMethod.GET)
	public @ResponseBody String exportarConcentradoColaboraciones(HttpServletRequest request,
			HttpServletResponse response, String idExpedienteColaboracion, String fechaPeticion,
			String idInstitucion, String idEstatusColaboracion) {
		String json = null, msg = null;
		File fileInd = null;
		response.setContentType("APPLICATION/json"); // en caso de error

		try {
			fileInd = consultaService.generarColaboraciones(idExpedienteColaboracion, fechaPeticion, idInstitucion,
					idEstatusColaboracion);
			if (fileInd != null) {

				String fecha = Utils.dateToString(new Date(), "ddMMyyyy hh:mm");
				response.setContentType("APPLICATION/OCTET-STREAM");
				response.addHeader("Content-Disposition",
						"attachment; filename=ConcentradoColaboraciones_" + fecha + ".xls");
				byte[] byteArray = FileUtils.readFileToByteArray(fileInd);
				BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
				bos.write(byteArray);
				bos.flush();
				bos.close();
				log.info("exportacion correcta");
			} else {
				msg = "La informacion no se exporto correctamente";
				log.info(msg);
				json = "{" + msg + "}";
			}
			if (fileInd != null && fileInd.exists()) {
				fileInd.delete();
				log.info("Archivo eliminado Xls de tomcat.");
			}
		} catch (Exception e) {
			msg = "Ocurrio un inconveniente al exportar el concentrado de colaboraciones:" + e.getMessage();
			json = "{" + msg + "}";
		}
		return null;
	}

	@RequestMapping(value = "/buscar-busqueda-larga-data", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<CommonResponseListElement<BusquedaLargaDataConcentradoDto>> buscarBusquedaLargaData(
			@RequestParam("mesBusquedaLD") String mesBusquedaLD,
			@RequestParam("yearBusquedaLD") String yearBusquedaLD) {
		List<BusquedaLargaDataConcentradoDto> largaDatas = new ArrayList<BusquedaLargaDataConcentradoDto>();
		CommonResponseListElement<BusquedaLargaDataConcentradoDto> response = new CommonResponseListElement<BusquedaLargaDataConcentradoDto>();
		response.setDescripcion("Se genero un inconveniente al buscar la informacion.");
		response.setEstatus(-3);
		try {
			largaDatas = consultaService.busquedaLargaData(mesBusquedaLD, yearBusquedaLD);
			response.setDescripcion(String.valueOf(largaDatas.size()));
			if (largaDatas.size() == 0) {
				response.setEstatus(2);
				response.setDescripcion("No se encontraron registros.");
				response.setElementos(largaDatas);
			} else if (largaDatas.size() > 0) {
				response.setEstatus(1);
				response.setDescripcion("OK");
				response.setElementos(largaDatas);
			}
		} catch (Exception e) {
			log.error("Inconveniente al consultar larga data:" + e.getMessage());
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
