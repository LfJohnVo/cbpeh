package mx.gob.cbpeh.bpd.controlador;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.gob.cbpeh.bpd.dto.Comunicado2;
import mx.gob.cbpeh.bpd.dto.ComunicadosDto;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.ArchivoLargaData;
import mx.gob.cbpeh.bpd.modelo.BusquedaLargaData;
import mx.gob.cbpeh.bpd.modelo.BusquedaLargaDataExpediente;
import mx.gob.cbpeh.bpd.modelo.CatColonia;
import mx.gob.cbpeh.bpd.modelo.CatCp;
import mx.gob.cbpeh.bpd.modelo.CatMunicipio;
import mx.gob.cbpeh.bpd.modelo.CatTipoComunicado;
import mx.gob.cbpeh.bpd.modelo.Comunicado;
import mx.gob.cbpeh.bpd.servicio.ArchivoLargaDataServicio;
import mx.gob.cbpeh.bpd.servicio.BusquedaLargaDataExpedienteServicio;
import mx.gob.cbpeh.bpd.servicio.BusquedaLargaDataServicio;
import mx.gob.cbpeh.bpd.servicio.CatAreaServicio;
import mx.gob.cbpeh.bpd.servicio.CatBaseNarizServicio;
import mx.gob.cbpeh.bpd.servicio.CatBocaServicio;
import mx.gob.cbpeh.bpd.servicio.CatColoniaServicio;
import mx.gob.cbpeh.bpd.servicio.CatColorCabelloServicio;
import mx.gob.cbpeh.bpd.servicio.CatColorOjoServicio;
import mx.gob.cbpeh.bpd.servicio.CatCompaniaTelefonoServicio;
import mx.gob.cbpeh.bpd.servicio.CatComplexionServicio;
import mx.gob.cbpeh.bpd.servicio.CatCpServicio;
import mx.gob.cbpeh.bpd.servicio.CatDentaduraServicio;
import mx.gob.cbpeh.bpd.servicio.CatDialectoServicio;
import mx.gob.cbpeh.bpd.servicio.CatDireccionServicio;
import mx.gob.cbpeh.bpd.servicio.CatEdadServicio;
import mx.gob.cbpeh.bpd.servicio.CatEscolaridadServicio;
import mx.gob.cbpeh.bpd.servicio.CatEstadoCivilServicio;
import mx.gob.cbpeh.bpd.servicio.CatEstadoServicio;
import mx.gob.cbpeh.bpd.servicio.CatEstatusColaboracionServicio;
import mx.gob.cbpeh.bpd.servicio.CatEstatusEconomicoServicio;
import mx.gob.cbpeh.bpd.servicio.CatEstatusLocalizadoServicio;
import mx.gob.cbpeh.bpd.servicio.CatEstatusServicio;
import mx.gob.cbpeh.bpd.servicio.CatFormaNarizServicio;
import mx.gob.cbpeh.bpd.servicio.CatFrenteServicio;
import mx.gob.cbpeh.bpd.servicio.CatGradoEstudioServicio;
import mx.gob.cbpeh.bpd.servicio.CatGrupoEtnicoServicio;
import mx.gob.cbpeh.bpd.servicio.CatIdiomaServicio;
import mx.gob.cbpeh.bpd.servicio.CatInstitucionServicio;
import mx.gob.cbpeh.bpd.servicio.CatLabioServicio;
import mx.gob.cbpeh.bpd.servicio.CatLongitudCabelloServicio;
import mx.gob.cbpeh.bpd.servicio.CatLugarBusquedaServicio;
import mx.gob.cbpeh.bpd.servicio.CatLugarServicio;
import mx.gob.cbpeh.bpd.servicio.CatMedioContactoServicio;
import mx.gob.cbpeh.bpd.servicio.CatMedioReporteServicio;
import mx.gob.cbpeh.bpd.servicio.CatMunicipioServicio;
import mx.gob.cbpeh.bpd.servicio.CatNacionalidadServicio;
import mx.gob.cbpeh.bpd.servicio.CatOcupacionServicio;
import mx.gob.cbpeh.bpd.servicio.CatParentescoServicio;
import mx.gob.cbpeh.bpd.servicio.CatPeriodicidadServicio;
import mx.gob.cbpeh.bpd.servicio.CatPuestoServicio;
import mx.gob.cbpeh.bpd.servicio.CatSexoServicio;
import mx.gob.cbpeh.bpd.servicio.CatSiNoServicio;
import mx.gob.cbpeh.bpd.servicio.CatTamanioNarizServicio;
import mx.gob.cbpeh.bpd.servicio.CatTezServicio;
import mx.gob.cbpeh.bpd.servicio.CatTipoCabelloServicio;
import mx.gob.cbpeh.bpd.servicio.CatTipoIdentificacionServicio;
import mx.gob.cbpeh.bpd.servicio.CatTipoNotaServicio;
import mx.gob.cbpeh.bpd.servicio.CatTipoOjoServicio;
import mx.gob.cbpeh.bpd.servicio.CatTipoSangreServicio;
import mx.gob.cbpeh.bpd.servicio.CatTransporteServicio;
import mx.gob.cbpeh.bpd.servicio.ComunicadoServicio;
import mx.gob.cbpeh.bpd.servicio.DirectorioService;
import mx.gob.cbpeh.bpd.servicio.ExpedienteIncompetenciaServicio;
import mx.gob.cbpeh.bpd.servicio.ExpedienteServicio;
import mx.gob.cbpeh.bpd.servicio.PersonaIncompetenciaServicio;
import mx.gob.cbpeh.bpd.servicio.PersonaReportaServicio;
import mx.gob.cbpeh.bpd.servicio.UsuarioServicio;

@Controller
@RequestMapping(value = "/accionesbusqueda")
public class AccionesBusquedaControlador {
	
	private static final Logger log = LoggerFactory.getLogger(AccionesBusquedaControlador.class);
	
	@Autowired
	ExpedienteServicio expedienteServicios;
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
	CatCompaniaTelefonoServicio companiaTelefonoServicio;
	@Autowired
	CatParentescoServicio parentescoServicio;
	@Autowired
	CatSiNoServicio siNoServicio;
	@Autowired
	private CatAreaServicio areaServicio;
	@Autowired
	private CatTipoNotaServicio tipoNotaServicio;
	@Autowired
	private UsuarioServicio usuarioServicio;
	@Autowired
	private CatDireccionServicio direccionServicio;
	@Autowired
	private CatPuestoServicio puestoServicio;
	@Autowired
	private CatEstadoServicio catEstadoServicio;
	@Autowired
	private BusquedaLargaDataServicio busquedaLargaDataServicio;
	@Autowired
	private ArchivoLargaDataServicio archivoLargaDataServicio;
	@Autowired
	private BusquedaLargaDataExpedienteServicio busquedaLargaDataExpedienteServicio;
	@Autowired
	private CatInstitucionServicio catInstitucionServicio;
	@Autowired
	private CatEstatusColaboracionServicio catEstatusColaboracionServicio;
	@Autowired
	private CatLugarBusquedaServicio catLugarBusquedaServicio;	
	@Autowired
	private ComunicadoServicio comunicadoServicio;
	@Autowired
	DirectorioService directorioService;
	
	@Autowired
	CatEdadServicio edadesServicio;
	@Autowired
	CatSexoServicio sexosServicio;
	@Autowired
	CatMedioReporteServicio mediosServicio;
	@Autowired
	CatNacionalidadServicio nacionalidadesServicio;
	@Autowired
	CatOcupacionServicio ocupacionServicio;
	@Autowired
	CatSiNoServicio acompanabaServicio;
	@Autowired
	CatColorOjoServicio colorOjoServicio;
	@Autowired
	CatTipoOjoServicio tipoOjoServicio;
	@Autowired
	CatColorCabelloServicio colorCabelloServicio;
	@Autowired
	CatLongitudCabelloServicio longitudCabelloServicio;
	@Autowired
	CatTipoCabelloServicio tiposCabelloServicio;
	@Autowired
	CatFrenteServicio frentesServicio;
	@Autowired
	CatBocaServicio bocasServicio;
	@Autowired
	CatLabioServicio labiosServicio;
	@Autowired
	CatDentaduraServicio denturasServicio;
	@Autowired
	CatBaseNarizServicio baseNarizServicio;
	@Autowired
	CatFormaNarizServicio formaNarizServicio;
	@Autowired
	CatTamanioNarizServicio tamanioNarizServicio;
	@Autowired
	CatComplexionServicio complexionServicio;
	@Autowired
	CatTezServicio tezServicio;
	@Autowired
	CatTipoSangreServicio sangreServicio;
	@Autowired
	CatPeriodicidadServicio operacionesServicio;
	@Autowired
	CatLugarServicio lugarServicio;
	@Autowired
	CatMedioContactoServicio mediosContactoServicio;
	@Autowired
	CatEstadoCivilServicio estadoCivilServicio;
	@Autowired
	CatDialectoServicio dialectoServicio;
	@Autowired
	CatEstatusEconomicoServicio estatusEconomicosServicio;
	@Autowired
	CatTransporteServicio transporteServicio;
	@Autowired
	CatGrupoEtnicoServicio etnicoServicio;
	@Autowired
	ExpedienteIncompetenciaServicio expedienteIncompetenciaServicios;
	@Autowired
	PersonaReportaServicio personaReportaServicio;	
	@Autowired
	PersonaIncompetenciaServicio personaIncompetenciaServicios;
	@Autowired
	CatEscolaridadServicio catEscolaridadServicio;
	@Autowired
	CatTipoIdentificacionServicio catTipoIdentificacionServicio;
	@Autowired
	CatGradoEstudioServicio catGradoEstudioServicio;
	@Autowired
	CatIdiomaServicio catIdiomaServicio;
	
	@GetMapping
	private ModelAndView showUserView(@RequestParam Map<String, String> reqParam) throws ResourceNotFoundException, JsonProcessingException{
		
		ModelAndView mav = new ModelAndView("template");
		log.info("Ingreso al controller de /accionesbusqueda ");
		System.out.println("Ingreso al controller de /accionesbusqueda ");

		String expedienteConsul  = reqParam.get("idExpediente");
		mav.addObject("expedienteConsul", expedienteConsul);
		
		mav.addObject("expedientes", expedienteServicios.getExpedientes());
	//	mav.addObject("estatus", catEstatusServicio.getCatEstatus());
		mav.addObject("municipios", catMunicipioServicio.getCatMunicipiosPorEstado("13"));// estado 13 hidalgo
		mav.addObject("estatusLocalizado", catEstatusLocalizadoServicio.getCatEstatusLocalizados());
		
		mav.addObject("estados", catEstadoServicio.getCatEstados());		
		
		mav.addObject("companiaTel", companiaTelefonoServicio.getCatCompaniaTelefonos());
		mav.addObject("parentesco", parentescoServicio.getCatParentescos());
		mav.addObject("areas", areaServicio.getCatAreas());
		mav.addObject("siNo", siNoServicio.getCatSiNo());
		mav.addObject("tipoNota", tipoNotaServicio.getCatTipoNotas());
		mav.addObject("nombreTitular", usuarioServicio.getUsuarios());
		mav.addObject("direccion", direccionServicio.getCatDirecciones());
		mav.addObject("puestoTitular", puestoServicio.getCatPuestos());
		mav.addObject("usuarioSession", usuarioServicio.getUsuario(getNameUser()));
		CatTipoComunicado catTipoComunicado = new CatTipoComunicado();
		  catTipoComunicado.setIdTipoComunicado(2);
		 ComunicadosDto comunicadosDto = new ComunicadosDto();
		 List<Comunicado> comunicados = comunicadoServicio.getComunicados(catTipoComunicado);
		 
		 for(Comunicado comunicado2: comunicados) {
			 
			Comunicado2 comunicado22 = new Comunicado2();
			            comunicado22.setIdComunicado(comunicado2.getIdComunicado());
			            comunicado22.setTitulo(comunicado2.getTitulo());
			            comunicado22.setDescripcion(comunicado2.getDescripcion());
			            comunicado22.setUrl(comunicado2.getUrl());
			            comunicado22.setImagen(comunicado2.getImagen());
			            comunicado22.setImagenDetalle(comunicado2.getImagen().toString());
			            
			            comunicadosDto.getComunicados().add(comunicado22);
			}
				   
		  //Object mapper instance
		  ObjectMapper mapper = new ObjectMapper();
		   
		  //Convert POJO to JSON
		  String json = mapper.writeValueAsString(comunicadosDto);
		  
		 // model.addObject("comunicadosCarrusel", comunicado.getComunicados());
		  mav.addObject("json", json);
		mav.addObject("tipo", 3);
		mav.addObject("nameUser", getNameUser());
		
		mav.addObject("instituciones", catInstitucionServicio.getCatInstitucion());
		mav.addObject("estatusColaboracion", catEstatusColaboracionServicio.getCatEstatusColaboracions());
		mav.addObject("lugaresBusqueda", catLugarBusquedaServicio.getCatLugarBusqueda());
		mav.addObject("aniosExpedientes", expedienteServicios.obtenerAniosExpedientes());
		
		mav.addObject("asociacionesHidalgo", directorioService.getAsociacionesHidalgo());
		mav.addObject("busquedaInmediata", directorioService.getBusquedaInmediatas());
		mav.addObject("centroRehabilitacion", directorioService.getCentrosRehabilitacion());
		mav.addObject("comisionEstatal", directorioService.getComisionesEstatales());
		// para pantalla consultar expediente
		mav.addObject("estado", catEstadoServicio.getCatEstados());
		mav.addObject("edades", edadesServicio.getCatEdades());
		mav.addObject("sexos", sexosServicio.getCatSexo());
		mav.addObject("medios", mediosServicio.getCatMedioReportes());
		mav.addObject("nacionalidades", nacionalidadesServicio.getCatNacionalidad());
		mav.addObject("parentescos", parentescoServicio.getCatParentescos());
		mav.addObject("ocupaciones", ocupacionServicio.getCatOcupacion());
		mav.addObject("acompanabas", acompanabaServicio.getCatSiNo());
		mav.addObject("coloresOjos", colorOjoServicio.getCatColorOjos());
		mav.addObject("tiposOjos", tipoOjoServicio.getCatTipoOjos());
		mav.addObject("coloresCabello", colorCabelloServicio.getCatColorCabellos());
		mav.addObject("longitudCabello", longitudCabelloServicio.getCatLongitudCabello());
		mav.addObject("tiposCabello", tiposCabelloServicio.getCatTipoCabello());
		mav.addObject("frentes", frentesServicio.getCatFrente());
		mav.addObject("bocas", bocasServicio.getCatBocas());
		mav.addObject("labios", labiosServicio.getCatLabios());
		mav.addObject("dentaduras", denturasServicio.getCatDentaduras());
		mav.addObject("baseNariz", baseNarizServicio.getCatBaseNariz());
		mav.addObject("formaNariz", formaNarizServicio.getCatFormaNariz());
		mav.addObject("tamanioNariz", tamanioNarizServicio.getCatTamanioNariz());
		mav.addObject("complexiones", complexionServicio.getCatComplexiones());
		mav.addObject("tez", tezServicio.getCatTez());
		mav.addObject("sangre", sangreServicio.getCatTipoSangre());
		mav.addObject("periodicidades", operacionesServicio.getCatPeriodicidad());
		mav.addObject("siNo", siNoServicio.getCatSiNo());
		mav.addObject("lugares", lugarServicio.getCatLugar());
		mav.addObject("mediosContacto", mediosContactoServicio.getCatMedioContactos());
		mav.addObject("expedientes", expedienteServicios.getExpedientes());
		mav.addObject("estadosCiviles", estadoCivilServicio.getCatEstadoCivil());
		mav.addObject("dialectos", dialectoServicio.getCatDialectos());
		mav.addObject("estatus", estatusEconomicosServicio.getCatEstatusEconomicos());
		mav.addObject("transportes", transporteServicio.getCatTransportes());
		mav.addObject("grupos", etnicoServicio.getCatGrupoEtnicos());
		List<CatMunicipio> munHidalgo = catMunicipioServicio.getCatMunicipiosPorEstado("13");
		mav.addObject("municipiosHidalgo", munHidalgo);
		mav.addObject("estatusLocalizado", catEstatusLocalizadoServicio.getCatEstatusLocalizados());
		mav.addObject("escolaridad", catEscolaridadServicio.getCatEscolaridad());
		mav.addObject("tipoIdentificacion", catTipoIdentificacionServicio.getCatTipoIdentificacion());
		mav.addObject("gradoEstudios", catGradoEstudioServicio.getCatGradoEstudio());
		mav.addObject("idiomas", catIdiomaServicio.getCatIdiomas());
		
		return mav;
	}
	
	private String getNameUser() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		return currentPrincipalName;
	}
	
	@RequestMapping(value = "/guardarLargaData", method = RequestMethod.POST)
	public void guardarLargaData(@RequestParam("numExpedienteLD") String numExpedienteLD,
			@RequestParam("fechaLD") String fechaLD, @RequestParam("estatusLD") String estatusLD,
			@RequestParam("municipioLargaData") String municipioLargaData,
			@RequestParam("cpLargaData") String cpLargaData, @RequestParam("coloniaLargaData") String coloniaLargaData,
			@RequestParam("calleLargaData") String calleLargaData,
			@RequestParam("latitudLargaData") String latitudLargaData,
			@RequestParam("longitudLargaData") String longitudLargaData,
			@RequestParam("observacionesLargaData") String observacionesLargaData,
			@RequestParam("evidenciaLargaData") MultipartFile evidenciaLargaData,
			@RequestParam("descripcionLargaData") String descripcionLargaData,
			@RequestParam("lugaresBusqueda") List<String> lugaresBusqueda)
			throws ResourceNotFoundException, IOException {

		BusquedaLargaData busquedaLD = new BusquedaLargaData();
		ArchivoLargaData archivoLargaData = new ArchivoLargaData();

		busquedaLD.setIdBusquedaLargaData("CBPEH-LD-006-2020");
		busquedaLD.setCalle(calleLargaData);
		busquedaLD.setEstatusBusquedaLargaData((byte) 1);
		
		CatMunicipio catMunicipio = new CatMunicipio();
		if (!municipioLargaData.equals("")) {
			catMunicipio.setIdMunicipio(Integer.parseInt(municipioLargaData));
			busquedaLD.setCatMunicipio(catMunicipio);
		}
		CatCp catCp = new CatCp();
		if (!cpLargaData.equals("")) {
			catCp.setIdCp(Integer.parseInt(cpLargaData));
			busquedaLD.setCatCp(catCp);
		}
		CatColonia catColonia = new CatColonia();
		if (!coloniaLargaData.equals("")) {
			catColonia.setIdColonia(Integer.parseInt(coloniaLargaData));
			busquedaLD.setCatColonia(catColonia);
		}
		LocalDate dates = LocalDate.now();
		busquedaLD.setFechaAlta(Date.valueOf(dates));
		busquedaLD.setFechaBusqueda(Date.valueOf(fechaLD));
		// busquedaLD.setIdBusquedaLargaData(idBusquedaLargaData);

		int estatus = Integer.parseInt(estatusLD);
		busquedaLD.setIdEstatusLocalizado((byte) estatus);

		if (!latitudLargaData.equals("")) {
			busquedaLD.setLatitud(Float.parseFloat(latitudLargaData));
		}
		if (!longitudLargaData.equals("")) {
			busquedaLD.setLongitud(Float.parseFloat(longitudLargaData));
		}
		busquedaLD.setResenia(descripcionLargaData);
		busquedaLD.setIdUsuarioAlta(getNameUser());

		busquedaLargaDataServicio.saveBusquedaLargaData(busquedaLD);

		if (lugaresBusqueda.size() >= 0) {
			for (String idExpediente : lugaresBusqueda) {
				BusquedaLargaDataExpediente busquedaLDE = new BusquedaLargaDataExpediente();
				BusquedaLargaData busquedaLDES = new BusquedaLargaData();
				busquedaLDES.setIdBusquedaLargaData("CBPEH-LD-006-2020");
				busquedaLDE.setBusquedaLargaData(busquedaLDES);
				busquedaLDE.setEstatusBusquedaLargaDataExpediente((byte) 1);
				busquedaLDE.setExpediente(idExpediente);
				busquedaLargaDataExpedienteServicio.saveBusquedaLargaDataExpediente(busquedaLDE);
			}
		}
		// busquedaLD.setArchivoLargaData(archivoLargaData);
		// busquedaLD.setBusquedaLargaDataExpedientes(busquedaLargaDataExpedientes);

		archivoLargaData.setArchivo(evidenciaLargaData.getBytes());
		archivoLargaData.setArchivoDescripcion(descripcionLargaData);
		BusquedaLargaData busquedaLDA = new BusquedaLargaData();
		busquedaLDA.setIdBusquedaLargaData("CBPEH-LD-006-2020");
		archivoLargaData.setBusquedaLargaData(busquedaLDA);
		archivoLargaData.setEstatusArchivoLargaData((byte) 1);
		archivoLargaData.setFechaCarga(Date.valueOf(dates));
		// archivoLargaData.setHoraCarga(horaCarga);		 
		archivoLargaData.setIdTipoArchivo((byte) 1);
		archivoLargaData.setIdUsuarioCarga(getNameUser());
		archivoLargaData.setNombreArchivo(evidenciaLargaData.getName());

		archivoLargaDataServicio.saveArchivoLargaData(archivoLargaData);

	}
	
}