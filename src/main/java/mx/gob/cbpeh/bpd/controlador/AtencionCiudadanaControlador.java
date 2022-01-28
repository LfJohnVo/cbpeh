package mx.gob.cbpeh.bpd.controlador;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.gob.cbpeh.bpd.dto.Comunicado2;
import mx.gob.cbpeh.bpd.dto.ComunicadosDto;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
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
import mx.gob.cbpeh.bpd.modelo.CatEstatusLocalizado;
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
import mx.gob.cbpeh.bpd.modelo.CatTipoCabello;
import mx.gob.cbpeh.bpd.modelo.CatTipoComunicado;
import mx.gob.cbpeh.bpd.modelo.CatTipoOjo;
import mx.gob.cbpeh.bpd.modelo.CatTipoSangre;
import mx.gob.cbpeh.bpd.modelo.CatTransporte;
import mx.gob.cbpeh.bpd.modelo.Comunicado;
import mx.gob.cbpeh.bpd.modelo.Expediente;
import mx.gob.cbpeh.bpd.modelo.ExpedienteIncompetencia;
import mx.gob.cbpeh.bpd.modelo.PersonaDesaparecida;
import mx.gob.cbpeh.bpd.modelo.PersonaIncompetencia;
import mx.gob.cbpeh.bpd.modelo.PersonaReporta;
import mx.gob.cbpeh.bpd.modelo.Usuario;
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
import mx.gob.cbpeh.bpd.servicio.CatEstatusEconomicoServicio;
import mx.gob.cbpeh.bpd.servicio.CatEstatusLocalizadoServicio;
import mx.gob.cbpeh.bpd.servicio.CatFormaNarizServicio;
import mx.gob.cbpeh.bpd.servicio.CatFrenteServicio;
import mx.gob.cbpeh.bpd.servicio.CatGradoEstudioServicio;
import mx.gob.cbpeh.bpd.servicio.CatGrupoEtnicoServicio;
import mx.gob.cbpeh.bpd.servicio.CatIdiomaServicio;
import mx.gob.cbpeh.bpd.servicio.CatLabioServicio;
import mx.gob.cbpeh.bpd.servicio.CatLongitudCabelloServicio;
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
import mx.gob.cbpeh.bpd.servicio.PersonaDesaparecidaServicio;
import mx.gob.cbpeh.bpd.servicio.PersonaIncompetenciaServicio;
import mx.gob.cbpeh.bpd.servicio.PersonaReportaServicio;
import mx.gob.cbpeh.bpd.servicio.UsuarioServicio;

@RestController
@RequestMapping(value = "/atencionciudadana")
public class AtencionCiudadanaControlador {

	private static final Logger LOG = LoggerFactory.getLogger(AtencionCiudadanaControlador.class);

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

	@GetMapping
	private ModelAndView showUserView(@RequestParam Map<String, String> reqParam)
			throws ResourceNotFoundException, JsonProcessingException {

		ModelAndView mav = new ModelAndView("template");
		LOG.info("Ingreso al controller de /atencionciudadana ");

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
		mav.addObject("tipo", 4);

		mav.addObject("escolaridad", catEscolaridadServicio.getCatEscolaridad());
		mav.addObject("tipoIdentificacion", catTipoIdentificacionServicio.getCatTipoIdentificacion());
		mav.addObject("gradoEstudios", catGradoEstudioServicio.getCatGradoEstudio());
		mav.addObject("idiomas", catIdiomaServicio.getCatIdiomas());

		return mav;

	}

	@RequestMapping(value = "/guardarReportantes", method = RequestMethod.POST) // @ResponseBody
	public Boolean guardarReportantes(@RequestParam("estado") String estado,
			@RequestParam("municipio") String municipio, @RequestParam("cp") String cp,
			@RequestParam("colonia") String colonia, @RequestParam("edad") String edad,
			@RequestParam("sexo") String sexo, @RequestParam("relacion") String relacion,
			@RequestParam("ocupacion") String ocupacion, @RequestParam("medio") String medio,
			@RequestParam("nacionalidad") String nacionalidad, @RequestParam("acompanaba") String acompanaba,
			@RequestParam("nombre") String nombre, @RequestParam("apellidoMaterno") String apellidoMaterno,
			@RequestParam("apellidoPaterno") String apellidoPaterno, @RequestParam("calle") String calle,
			@RequestParam("telefono") String telefono, @RequestParam("correo") String correo,
			@RequestParam("celular") String celular, @RequestParam("identificacion") MultipartFile file)
			throws IOException {

		PersonaReporta personaReporta = new PersonaReporta();

		personaReporta.setNombre(nombre.toUpperCase());
		personaReporta.setApaterno(apellidoPaterno.toUpperCase());
		personaReporta.setAmaterno(apellidoMaterno.toUpperCase());

		personaReporta.setIdentificacion(file.getBytes());

		CatEstado catEstado = new CatEstado();
		if (!estado.equals("")) {
			catEstado.setIdEstado(Integer.parseInt(estado));
			personaReporta.setCatEstado(catEstado);
		}

		CatMunicipio catMunicipio = new CatMunicipio();
		if (!municipio.equals("")) {
			catMunicipio.setIdMunicipio(Integer.parseInt(municipio));
			personaReporta.setCatMunicipio(catMunicipio);
		}

		CatCp catCp = new CatCp();
		if (!cp.equals("")) {
			catCp.setIdCp(Integer.parseInt(cp));
			personaReporta.setCatCp(catCp);
		}

		CatColonia catColonia = new CatColonia();
		if (!colonia.equals("")) {
			catColonia.setIdColonia(Integer.parseInt(colonia));
			personaReporta.setCatColonia(catColonia);
		}

		personaReporta.setCalle(calle.toUpperCase());

		CatEdad catEdad = new CatEdad();
		if (!edad.equals("")) {
			catEdad.setIdEdad(Integer.parseInt(edad));
			personaReporta.setCatEdad(catEdad);
		}

		CatSexo catSexo = new CatSexo();
		if (!sexo.equals("")) {
			catSexo.setIdSexo(Integer.parseInt(sexo));
			personaReporta.setCatSexo(catSexo);
		}

		if (!telefono.equals("")) {
			personaReporta.setTelefono1(new BigInteger(telefono));
		}

		personaReporta.setCorreoElectronico(correo.toUpperCase());

		if (!celular.equals("")) {
			personaReporta.setTelefono2(new BigInteger(celular));
		}

		CatMedioReporte catMedioReporte = new CatMedioReporte();
		if (!medio.equals("")) {
			catMedioReporte.setIdMedioReporte(Integer.parseInt(medio));
			personaReporta.setCatMedioReporte(catMedioReporte);
		}

		CatNacionalidad catNacionalidad = new CatNacionalidad();
		if (!nacionalidad.equals("")) {
			catNacionalidad.setIdNacionalidad(Integer.parseInt(nacionalidad));
			personaReporta.setCatNacionalidad(catNacionalidad);
		}

		CatParentesco catParentesco = new CatParentesco();
		if (!relacion.equals("")) {
			catParentesco.setIdParentesco(Integer.parseInt(relacion));
			personaReporta.setCatParentesco(catParentesco);
		}

		CatOcupacion catOcupacion = new CatOcupacion();
		if (!ocupacion.equals("")) {
			catOcupacion.setIdOcupacion(Integer.parseInt(ocupacion));
			personaReporta.setCatOcupacion(catOcupacion);
		}
		// personaReporta.setIdentificacion(reportante.getIdentificacion());

		CatSiNo catSiNo = new CatSiNo();
		if (!acompanaba.equals("")) {
			catSiNo.setIdSiNo(Integer.parseInt(acompanaba));
			personaReporta.setCatSiNo(catSiNo);
		}

		LocalDate dates = LocalDate.now();
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(1);
		personaReporta.setCatEstatus(estatus);

		personaReporta.setUsuario1(getNameUser());
		personaReporta.setFechaAlta(Date.valueOf(dates));

		personaReportante.savePersonaReporta(personaReporta);

		return true;
	}

	@RequestMapping(value = "/guardarDesaparecidos", method = RequestMethod.POST) // @ResponseBody
	public List<String> guardarDesaparecidos(@RequestParam("declarante") String declarante,
			@RequestParam("nombreDesaparecido") String nombreDesaparecido,
			@RequestParam("apellidoPaternoDesaparecido") String apellidoPaterno,
			@RequestParam("apellidoMaternoDesaparecido") String apellidoMaterno,
			@RequestParam("fechaNacimiento") String fechaNacimiento,
			@RequestParam("edadDesaparecido") String edadDesaparecido,
			@RequestParam("sexoDesaparecido") String sexoDesaparecido, @RequestParam("curp") String curp,
			@RequestParam("rfc") String rfc, @RequestParam("estadoCivil") String estadoCivil,
			@RequestParam("ocupacionDesaparecido") String ocupacionDesaparecido,
			@RequestParam("habitantes") String habitantes,
			@RequestParam("carpetaInvestigacion") String carpetaInvestigacion,
			@RequestParam("nacionalidadDesaparecido") String nacionalidadDesaparecido,
			@RequestParam("estadoDesaparecido") String estadoDesaparecido,
			@RequestParam("municipioDesaparecido") String municipioDesaparecido,
			@RequestParam("cpDesaparecido") String cpDesaparecido,
			@RequestParam("coloniaDesaparecido") String coloniaDesaparecido,
			@RequestParam("calleDesaparecido") String calleDesaparecido, @RequestParam("colorOjos") String colorOjos,
			@RequestParam("tipoOjos") String tipoOjos, @RequestParam("ojo") String ojo,
			@RequestParam("colorCabello") String colorCabello, @RequestParam("longitud") String longitud,
			@RequestParam("tipoCabello") String tipoCabello, @RequestParam("cabello") String cabello,
			@RequestParam("frente") String frente, @RequestParam("boca") String boca,
			@RequestParam("labios") String labios,
			@RequestParam("dentadura") String dentadura, @RequestParam("detalleDentadura") String detalleDentadura,
			@RequestParam("baseNariz") String baseNariz, @RequestParam("forma") String forma,
			@RequestParam("tamanio") String tamanio,
			@RequestParam("complexion") String complexion, @RequestParam("peso") String peso,
			@RequestParam("estatura") String estatura, @RequestParam("colorPiel") String colorPiel,
			@RequestParam("senias") String senias, @RequestParam("fotografia") MultipartFile fotografia,
			@RequestParam("sangre") String sangre, @RequestParam("adicciones") String adicciones,
			@RequestParam("periodicidad") String periodicidad, @RequestParam("operaciones") String operaciones,
			@RequestParam("descripcionOperaciones") String descripcionOperaciones,
			@RequestParam("discapacidad") String discapacidad,
			@RequestParam("descripcionDiscapacidad") String descripcionDiscapacidad,
			@RequestParam("fracturas") String fracturas,
			@RequestParam("descripcionFracturas") String descripcionFracturas,
			@RequestParam("fechaDesaparicion") String fechaDesaparicion,
			@RequestParam("fechaUltimoContacto") String fechaUltimoContacto,
			@RequestParam("lugarDesaparicion") String lugarDesaparicion,
			@RequestParam("ultimoMedio") String ultimoMedio,
			@RequestParam("personaQueVioUltimaVez") String personaQueVioUltimaVez,
			@RequestParam("dondeIba") String dondeIba, @RequestParam("lugares") String lugares,
			@RequestParam("enemistades") String enemistades, @RequestParam("sospechoso") String sospechoso,
			@RequestParam("actitud") String actitud, @RequestParam("faltas") String faltas,
			@RequestParam("descripcionFaltas") String descripcionFaltas, @RequestParam("violencia") String violencia,
			@RequestParam("descripcionViolencia") String descripcionViolencia,
			@RequestParam("descripcionGeneral") String descripcionGeneral,
			@RequestParam("vestimenta") String vestimenta, @RequestParam("documentacion") String documentacion,
			@RequestParam("descripcionDocumentacion") String descripcionDocumentacion,
			@RequestParam("documento") String documento,
			@RequestParam("descripcionDocumento") String descripcionDocumento,
			@RequestParam("llamadas") String llamadas, @RequestParam("descripcionLlamadas") String descripcionLlamadas,
			@RequestParam("transporte") String transporte,
			@RequestParam("descripcionTransporte") String descripcionTransporte, @RequestParam("correo") String correo,
			@RequestParam("contraseniaCorreo") String contraseniaCorreo, @RequestParam("facebook") String facebook,
			@RequestParam("contraseniaFacebook") String contraseniaFacebook, @RequestParam("twitter") String twitter,
			@RequestParam("contraseniaTwitter") String contraseniaTwitter, @RequestParam("instagram") String instagram,
			@RequestParam("contraseniaInstagram") String contraseniaInstagram, @RequestParam("hijos") String hijos,
			@RequestParam("descripcionHijos") String descripcionHijos, @RequestParam("pasatiempos") String pasatiempos,
			@RequestParam("dialecto") String dialecto, @RequestParam("grupo") String grupo,
			@RequestParam("estatusEconomico") String estatusEconomico, @RequestParam("difusion") String difusion,
			@RequestParam("constancia") String constancia) throws IOException, ResourceNotFoundException {

		PersonaDesaparecida personaDesaparece = new PersonaDesaparecida();
		PersonaDesaparecida personaSaved = new PersonaDesaparecida();
		String tipoExpediente = "0";

		if (estadoDesaparecido.equals("14")) {
			PersonaReporta personaReporta = new PersonaReporta();
			if (!declarante.equals("")) {
				personaReporta.setIdPersonaReporta(Integer.parseInt(declarante));
				personaDesaparece.setPersonaReporta(personaReporta);
			}

			personaDesaparece.setNombre(nombreDesaparecido.toUpperCase());
			personaDesaparece.setApaterno(apellidoPaterno.toUpperCase());
			personaDesaparece.setAmaterno(apellidoMaterno.toUpperCase());

			if (!fechaNacimiento.equals("")) {
				personaDesaparece.setFechaNacimiento(Date.valueOf(fechaNacimiento));
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
			personaDesaparece.setFotoPersona(fotografia.getBytes());

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

			personaDesaparece.setDetalleOperacion(descripcionOperaciones.toUpperCase());

			if (!discapacidad.equals("")) {
				personaDesaparece.setPadecimientoDiscapacidad(Integer.parseInt(discapacidad));
			}

			personaDesaparece.setDetallePadecimiento(descripcionDiscapacidad.toUpperCase());

			CatSiNo fractura = new CatSiNo();
			if (!fracturas.equals("")) {
				fractura.setIdSiNo(Integer.parseInt(fracturas));
				personaDesaparece.setFracturas(fractura);
			}

			personaDesaparece.setDetalleFractura(descripcionFracturas.toUpperCase());

			if (!fechaDesaparicion.equals("")) {
				personaDesaparece.setFechaDesaparcion(Date.valueOf(fechaDesaparicion));
			}

			if (!fechaDesaparicion.equals("")) {
				personaDesaparece.setFechaUltimoContacto(Date.valueOf(fechaUltimoContacto));
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

			CatSiNo falta = new CatSiNo();
			if (!faltas.equals("")) {
				falta.setIdSiNo(Integer.parseInt(faltas));
				personaDesaparece.setFaltas(falta);
			}

			personaDesaparece.setDetalleFaltaACasa(descripcionFaltas.toUpperCase());

			CatSiNo violencias = new CatSiNo();
			if (!violencia.equals("")) {
				violencias.setIdSiNo(Integer.parseInt(violencia));
				personaDesaparece.setViolencia(violencias);
			}

			personaDesaparece.setDetalleViolencia(descripcionViolencia.toUpperCase());
			personaDesaparece.setHechos(descripcionGeneral.toUpperCase());
			personaDesaparece.setVestimenta(vestimenta.toUpperCase());

			CatSiNo llevoDocumento = new CatSiNo();
			if (!documentacion.equals("")) {
				llevoDocumento.setIdSiNo(Integer.parseInt(documentacion));
				personaDesaparece.setLlevoDocumento(llevoDocumento);
			}

			personaDesaparece.setDetalleDocumento(descripcionDocumentacion.toUpperCase());

			CatSiNo dejoDocumento = new CatSiNo();
			if (!documento.equals("")) {
				dejoDocumento.setIdSiNo(Integer.parseInt(documento));
				personaDesaparece.setDejoDocumento(dejoDocumento);
			}

			personaDesaparece.setDetalleDejoDocumento(descripcionDocumento.toUpperCase());

			CatSiNo antedentes = new CatSiNo();
			if (!llamadas.equals("")) {
				antedentes.setIdSiNo(Integer.parseInt(llamadas));
				personaDesaparece.setAntedentes(antedentes);
			}

			personaDesaparece.setDetalleComunicacion(descripcionLlamadas.toUpperCase());

			CatTransporte catTransporte = new CatTransporte();
			if (!transporte.equals("")) {
				catTransporte.setIdTransporte(Integer.parseInt(transporte));
				personaDesaparece.setCatTransporte(catTransporte);
			}

			personaDesaparece.setDetalleTransporte(descripcionTransporte.toUpperCase());
			personaDesaparece.setCorreoElectronico(correo.toUpperCase());
			personaDesaparece.setContraseniaCorreo(contraseniaCorreo.toUpperCase());
			personaDesaparece.setFacebook(facebook.toUpperCase());
			personaDesaparece.setContraseniaFacebook(contraseniaFacebook.toUpperCase());
			personaDesaparece.setTwitter(twitter.toUpperCase());
			personaDesaparece.setContraseniaTwitter(contraseniaTwitter.toUpperCase());
			personaDesaparece.setInstragram(instagram.toUpperCase());
			personaDesaparece.setContraseniaInstagram(contraseniaInstagram.toUpperCase());

			CatSiNo hijo = new CatSiNo();
			if (!hijos.equals("")) {
				hijo.setIdSiNo(Integer.parseInt(hijos));
				personaDesaparece.setHijos(hijo);
			}

			personaDesaparece.setDetalleHijos(descripcionHijos.toUpperCase());
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
			personaDesaparece.setFechaAlta(Date.valueOf(dates));

			personaSaved = personaDesaparecida.savePersonaDesaparecida(personaDesaparece);
			tipoExpediente = "1";
			LOG.info("PERSONA ID:" + personaSaved.getIdPersonaDesaparecida());
		}
		LOG.info("PERSONA ID:" + personaSaved.getIdPersonaDesaparecida());
		String expediente = generarExpediente(tipoExpediente, nombreDesaparecido, apellidoPaterno, apellidoMaterno,
				edadDesaparecido, municipioDesaparecido, sexoDesaparecido, declarante, carpetaInvestigacion,
				descripcionGeneral, personaSaved.getIdPersonaDesaparecida());
		List<String> numeroExpediente = new ArrayList<String>();
		numeroExpediente.add(expediente);

		return numeroExpediente;
	}

	@RequestMapping(value = "/generarExpediente", method = RequestMethod.GET)
	public String generarExpediente(@RequestParam("tipoExpediente") String tipoExpediente,
			@RequestParam("nombreDesaparecido") String nombreDesaparecido,
			@RequestParam("apellidoPaterno") String apellidoPaterno,
			@RequestParam("apellidoMaterno") String apellidoMaterno,
			@RequestParam("edadDesaparecido") String edadDesaparecido,
			@RequestParam("municipioDesaparecido") String municipioDesaparecido,
			@RequestParam("sexoDesaparecido") String sexoDesaparecido, @RequestParam("declarante") String declarante,
			@RequestParam("carpetaInvestigacion") String carpetaInvestigacion,
			@RequestParam("descripcionGeneral") String descripcionGeneral, int personaDesaparecidaId)
			throws ResourceNotFoundException {

		Expediente expedienteCompetente = new Expediente();
		ExpedienteIncompetencia expedienteIncompetente = new ExpedienteIncompetencia();
		PersonaIncompetencia personaIncompetencia = new PersonaIncompetencia();

		String expediente = "";
		LocalDate dates = LocalDate.now();

		if (tipoExpediente.equals("1")) {
			expediente = expedienteServicios.getFolioExpediente(1);
			expedienteCompetente.setIdUsuarioAlta(getNameUser());
			expedienteCompetente.setCarpetaInvestigacion(carpetaInvestigacion.toUpperCase());
			expedienteCompetente.setFechaAlta(Date.valueOf(dates));
			expedienteCompetente.setFechaAperturaExpediente(Date.valueOf(dates));
			// expedienteCompetente.setHrAperturaExpediente(hrAperturaExpediente);
			expedienteCompetente.setIdExpediente(expediente.toString().toUpperCase());
			expedienteCompetente.setIdPersonaDesaparecida(personaDesaparecidaId);
			if (!declarante.equals("")) {
				expedienteCompetente.setIdPersonaReporta(Integer.parseInt(declarante));
			}

			CatEstatusLocalizado localizado = new CatEstatusLocalizado();
			localizado.setIdEstatusLocalizado(1);
			expedienteCompetente.setCatEstatusLocalizado(localizado);
			CatEstatus catEstatus = new CatEstatus();
			catEstatus.setIdEstatus(1);
			expedienteCompetente.setCatEstatus(catEstatus);
			expedienteCompetente.setBreveReseniaHecho(descripcionGeneral);

			expedienteServicios.saveExpediente(expedienteCompetente);

		} else {

			expediente = expedienteServicios.getFolioExpediente(0);

			personaIncompetencia.setNombre(nombreDesaparecido.toUpperCase());
			personaIncompetencia.setApaterno(apellidoPaterno.toUpperCase());
			personaIncompetencia.setAmaterno(apellidoMaterno.toUpperCase());

			CatEdad catEdad = new CatEdad();
			if (!edadDesaparecido.equals("")) {
				catEdad.setIdEdad(Integer.parseInt(edadDesaparecido));
				personaIncompetencia.setCatEdad(catEdad);
			}

			CatMunicipio catMunicipio = new CatMunicipio();
			if (!municipioDesaparecido.equals("")) {
				catMunicipio.setIdMunicipio(Integer.parseInt(municipioDesaparecido));
				personaIncompetencia.setCatMunicipio(catMunicipio);
			}

			CatEstatus catEstatus = new CatEstatus();
			catEstatus.setIdEstatus(1);
			personaIncompetencia.setCatEstatus(catEstatus);

			CatSexo catSexo = new CatSexo();
			if (!sexoDesaparecido.equals("")) {
				catSexo.setIdSexo(Integer.parseInt(sexoDesaparecido));
				personaIncompetencia.setCatSexo(catSexo);
			}

			personaIncompetenciaServicios.savePersonaIncompetencia(personaIncompetencia);

			Usuario usuarioIncompetente = new Usuario();
			usuarioIncompetente.setIdUsuario(getNameUser());
			expedienteIncompetente.setUsuario(usuarioIncompetente);
			PersonaIncompetencia persona = new PersonaIncompetencia();
			persona.setIdPersonaIncompetencia(1);
			expedienteIncompetente.setPersonaIncompetencia(persona);
			expedienteIncompetente.setIdExpedienteIncompetencia(expediente);
			expedienteIncompetente.setFechaAlta(Date.valueOf(dates));
			expedienteIncompetente.setCatEstatus(catEstatus);

			expedienteIncompetenciaServicios.saveExpedienteIncompetencia(expedienteIncompetente);

		}

		return expediente;
	}

	private String getNameUser() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		return currentPrincipalName;
	}

	/* obtiene todas las colonias del cp enviado */
	@RequestMapping(value = "/reportantes", method = RequestMethod.POST, produces = "application/json") // @ResponseBody
	public ResponseEntity<List<PersonaReporta>> getReportantes() {
		List<PersonaReporta> reportantes = new ArrayList<PersonaReporta>();
		try {
			reportantes = personaReportaServicio.getPersonaReportas();
		} catch (Exception e) {

		}
		return new ResponseEntity<>(reportantes, HttpStatus.OK);
	}

}