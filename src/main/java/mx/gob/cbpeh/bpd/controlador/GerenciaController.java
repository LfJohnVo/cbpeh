package mx.gob.cbpeh.bpd.controlador;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mx.gob.cbpeh.bpd.dto.Comunicado2;
import mx.gob.cbpeh.bpd.dto.ComunicadosDto;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatMunicipio;
import mx.gob.cbpeh.bpd.modelo.CatTipoComunicado;
import mx.gob.cbpeh.bpd.modelo.Comunicado;
import mx.gob.cbpeh.bpd.servicio.ArchivoLargaDataServicio;
import mx.gob.cbpeh.bpd.servicio.AtentaNotaServicio;
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
import mx.gob.cbpeh.bpd.servicio.ColaboracionServicio;
import mx.gob.cbpeh.bpd.servicio.ComunicadoServicio;
import mx.gob.cbpeh.bpd.servicio.DirectorioService;
import mx.gob.cbpeh.bpd.servicio.ExpedienteIncompetenciaServicio;
import mx.gob.cbpeh.bpd.servicio.ExpedienteServicio;
import mx.gob.cbpeh.bpd.servicio.PersonaDesaparecidaServicio;
import mx.gob.cbpeh.bpd.servicio.PersonaIncompetenciaServicio;
import mx.gob.cbpeh.bpd.servicio.PersonaReportaServicio;
import mx.gob.cbpeh.bpd.servicio.UsuarioServicio;

@Controller
public class GerenciaController {

	private static final Logger LOG = LoggerFactory.getLogger(AtencionCiudadanaControlador.class);

	@Autowired
	ColaboracionServicio colaboracionServicio;
	@Autowired
	ArchivoLargaDataServicio archivoLargaDataServicio;
	@Autowired
	BusquedaLargaDataServicio busquedaLargaDataServicio;
	@Autowired
	PersonaReportaServicio personaReportante;
	@Autowired
	PersonaReportaServicio personaReportanteServicio;
	@Autowired
	private PersonaDesaparecidaServicio personaDesaparecida;
	@Autowired
	CatMunicipioServicio catMunicipioServicio;
	@Autowired
	CatCpServicio catCpServicio;
	@Autowired
	CatColoniaServicio catColoniaServicio;
	@Autowired
	CatEstadoServicio estadoServicio;
	@Autowired
	CatEdadServicio edadesServicio;
	@Autowired
	CatSexoServicio sexosServicio;
	@Autowired
	CatMedioReporteServicio mediosServicio;
	@Autowired
	CatNacionalidadServicio nacionalidadesServicio;
	@Autowired
	CatParentescoServicio parentescoServicio;
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
	CatSiNoServicio siNoServicio;
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
	ExpedienteServicio expedienteServicios;
	@Autowired
	ExpedienteIncompetenciaServicio expedienteIncompetenciaServicios;
	@Autowired
	CatEstatusLocalizadoServicio catEstatusLocalizadoServicio;
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
	CatCompaniaTelefonoServicio companiaTelefonoServicio;
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
	@Autowired
	private ComunicadoServicio comunicadoServicio;
	@Autowired
	private AtentaNotaServicio atentaNotaServicio;
	@Autowired
	private CatEstadoServicio catEstadoServicio;
	@Autowired
	private CatInstitucionServicio catInstitucionServicio;
	@Autowired
	private CatEstatusColaboracionServicio catEstatusColaboracionServicio;
	@Autowired
	private CatLugarBusquedaServicio catLugarBusquedaServicio;
	@Autowired
	DirectorioService directorioService;

	@GetMapping
	@RequestMapping(value = "/gerencia")
	private ModelAndView showUserView(@RequestParam Map<String, String> reqParam)
			throws ResourceNotFoundException, JsonProcessingException {

		ModelAndView mav = new ModelAndView("template");
		String expedienteConsul = reqParam.get("idExpediente");
		mav.addObject("expedienteConsul", expedienteConsul);

		mav.addObject("companiaTel", companiaTelefonoServicio.getCatCompaniaTelefonos());
		mav.addObject("parentesco", parentescoServicio.getCatParentescos());
		mav.addObject("areas", areaServicio.getCatAreas());
		mav.addObject("tipoNota", tipoNotaServicio.getCatTipoNotas());
		mav.addObject("nombreTitular", usuarioServicio.getUsuarios());
		mav.addObject("direccion", direccionServicio.getCatDirecciones());
		mav.addObject("puestoTitular", puestoServicio.getCatPuestos());
		mav.addObject("usuarioSession", usuarioServicio.getUsuario(getNameUser()));
		mav.addObject("estado", estadoServicio.getCatEstados());
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
		mav.addObject("colaboraciones", colaboracionServicio.getColaboracion());
		mav.addObject("instituciones", catInstitucionServicio.getCatInstitucion());
		mav.addObject("estatusColaboracion", catEstatusColaboracionServicio.getCatEstatusColaboracions());
		mav.addObject("lugaresBusqueda", catLugarBusquedaServicio.getCatLugarBusqueda());
		mav.addObject("aniosExpedientes", expedienteServicios.obtenerAniosExpedientes());
		mav.addObject("yearsLargaData", archivoLargaDataServicio.getYearsLargaData());
		mav.addObject("yearsBusquedaLargaData", busquedaLargaDataServicio.getYearsLargaData());

		mav.addObject("asociacionesHidalgo", directorioService.getAsociacionesHidalgo());
		mav.addObject("busquedaInmediata", directorioService.getBusquedaInmediatas());
		mav.addObject("centroRehabilitacion", directorioService.getCentrosRehabilitacion());
		mav.addObject("comisionEstatal", directorioService.getComisionesEstatales());

		CatTipoComunicado catTipoComunicado = new CatTipoComunicado();

		catTipoComunicado.setIdTipoComunicado(2);
		ComunicadosDto comunicadosDto = new ComunicadosDto();
		List<Comunicado> comunicados = comunicadoServicio.getComunicados(catTipoComunicado);

		for (Comunicado comunicado2 : comunicados) {
			Comunicado2 comunicado22 = new Comunicado2();
			comunicado22.setIdComunicado(comunicado2.getIdComunicado());
			comunicado22.setTitulo(comunicado2.getTitulo());
			comunicado22.setDescripcion(comunicado2.getDescripcion());
			comunicado22.setUrl(comunicado2.getUrl());
			comunicado22.setImagen(comunicado2.getImagen());
			comunicado22.setImagenDetalle(comunicado2.getImagen().toString());
			comunicadosDto.getComunicados().add(comunicado22);
		}

		// Object mapper instance
		ObjectMapper mapper = new ObjectMapper();
		// Convert POJO to JSON
		String json = mapper.writeValueAsString(comunicadosDto);
		// model.addObject("comunicadosCarrusel", comunicado.getComunicados());
		mav.addObject("json", json);
		mav.addObject("nameUser", getNameUser());
		mav.addObject("tipo", 6); // 6 comisionado
		mav.addObject("escolaridad", catEscolaridadServicio.getCatEscolaridad());
		mav.addObject("tipoIdentificacion", catTipoIdentificacionServicio.getCatTipoIdentificacion());
		mav.addObject("gradoEstudios", catGradoEstudioServicio.getCatGradoEstudio());
		mav.addObject("idiomas", catIdiomaServicio.getCatIdiomas());
		mav.addObject("municipios", catMunicipioServicio.getCatMunicipiosPorEstado("13"));// estado 13 hidalgo
		mav.addObject("estados", catEstadoServicio.getCatEstados());
		return mav;
	}

	private String getNameUser() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		return currentPrincipalName;
	}

}
