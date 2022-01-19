
package mx.gob.cbpeh.bpd.controlador;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import mx.gob.cbpeh.bpd.dto.Comunicado2;
import mx.gob.cbpeh.bpd.dto.ComunicadosDto;
import mx.gob.cbpeh.bpd.modelo.AtentaNota;
import mx.gob.cbpeh.bpd.modelo.CatMunicipio;
import mx.gob.cbpeh.bpd.modelo.CatTipoComunicado;
import mx.gob.cbpeh.bpd.modelo.Comunicado;
import mx.gob.cbpeh.bpd.modelo.Expediente;
import mx.gob.cbpeh.bpd.modelo.PersonaDesaparecida;
import mx.gob.cbpeh.bpd.modelo.Usuario;
import mx.gob.cbpeh.bpd.servicio.AtentaNotaServicio;
import mx.gob.cbpeh.bpd.servicio.CatAreaServicio;
import mx.gob.cbpeh.bpd.servicio.CatBaseNarizServicio;
import mx.gob.cbpeh.bpd.servicio.CatBocaServicio;
import mx.gob.cbpeh.bpd.servicio.CatColorCabelloServicio;
import mx.gob.cbpeh.bpd.servicio.CatColorOjoServicio;
import mx.gob.cbpeh.bpd.servicio.CatCompaniaTelefonoServicio;
import mx.gob.cbpeh.bpd.servicio.CatComplexionServicio;
import mx.gob.cbpeh.bpd.servicio.CatDentaduraServicio;
import mx.gob.cbpeh.bpd.servicio.CatDialectoServicio;
import mx.gob.cbpeh.bpd.servicio.CatDireccionServicio;
import mx.gob.cbpeh.bpd.servicio.CatEdadServicio;
import mx.gob.cbpeh.bpd.servicio.CatEscolaridadServicio;
import mx.gob.cbpeh.bpd.servicio.CatEstadoCivilServicio;
import mx.gob.cbpeh.bpd.servicio.CatEstadoServicio;
import mx.gob.cbpeh.bpd.servicio.CatEstatusEconomicoServicio;
import mx.gob.cbpeh.bpd.servicio.CatEstatusLocalizadoServicio;
import mx.gob.cbpeh.bpd.servicio.CatEstatusServicio;
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
import mx.gob.cbpeh.bpd.servicio.ExpedienteIncompetenciaServicio;
import mx.gob.cbpeh.bpd.servicio.ExpedienteServicio;
import mx.gob.cbpeh.bpd.servicio.PersonaDesaparecidaServicio;
import mx.gob.cbpeh.bpd.servicio.PersonaIncompetenciaServicio;
import mx.gob.cbpeh.bpd.servicio.PersonaReportaServicio;
import mx.gob.cbpeh.bpd.servicio.UsuarioServicio;

@Controller

public class AnalisisContextoControlador {

	private static final Logger LOG = LoggerFactory.getLogger(AnalisisContextoControlador.class);
	@Autowired
	ExpedienteServicio expedienteServicios;
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
	private AtentaNotaServicio atentaNotaServicio;
	@Autowired
	private ComunicadoServicio comunicadoServicio;
	@Autowired
	private PersonaDesaparecidaServicio personaDesaparecidaServicio;
	
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
	@Autowired
	CatEstatusLocalizadoServicio catEstatusLocalizadoServicio;
	@Autowired
	CatEstatusServicio catEstatusServicio;
	@Autowired
	CatMunicipioServicio catMunicipioServicio;

	/* Este carga la vista de analisis de contexto y con la pre-informacion*/
	@RequestMapping(value = "/analisiscontexto",method = RequestMethod.GET)
	private ModelAndView showUserView() {
		ModelAndView mav = new ModelAndView("template");

		try {
			
			LOG.info("Entra en showUserView");
			
			mav.addObject("expedientes", expedienteServicios.getExpedientes());
			mav.addObject("companiaTel", companiaTelefonoServicio.getCatCompaniaTelefonos());
			mav.addObject("parentesco", parentescoServicio.getCatParentescos());
			mav.addObject("areas", areaServicio.getCatAreas());
			mav.addObject("siNo", siNoServicio.getCatSiNo());
			mav.addObject("tipoNota", tipoNotaServicio.getCatTipoNotas());
			mav.addObject("nombreTitular", usuarioServicio.getUsuarios());
			mav.addObject("direccion", direccionServicio.getCatDirecciones());
			mav.addObject("puestoTitular", puestoServicio.getCatPuestos());
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
			mav.addObject("usuarioSession", usuarioServicio.getUsuario(getNameUser()));
			mav.addObject("nameUser", getNameUser());
			
			// para pantalla consultar expediente
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
			mav.addObject("escolaridad", catEscolaridadServicio.getCatEscolaridad());
			mav.addObject("tipoIdentificacion", catTipoIdentificacionServicio.getCatTipoIdentificacion());
			mav.addObject("gradoEstudios", catGradoEstudioServicio.getCatGradoEstudio());
			mav.addObject("idiomas", catIdiomaServicio.getCatIdiomas());
		
		} catch (Exception e) {
			// TODO: handle exception
			LOG.error("Se genero un error en showUserView", e);
		}

		mav.addObject("tipo", 2);

		return mav;
	}
	
	/* Este carga la vista de analisis de contexto y con la pre-informacion*/
	@RequestMapping(value = "/atenta-nota-pdf",method = RequestMethod.GET)
	public ModelAndView mostrarPDFAtentaNota(@RequestParam("idAtentaNota") String idAtentaNota) {
		
		ModelAndView view = new ModelAndView("pdfView");
		
		try {			
			
			AtentaNota atentaNota= new AtentaNota();	
			Usuario remitente= new Usuario();	
			Usuario destinatario= new Usuario();	
			
			atentaNota=	atentaNotaServicio.getAtentaNotaPorIdAtentaNota(idAtentaNota);	
			remitente=	usuarioServicio.getUsuario(atentaNota.getUsuarioRemitente());
			destinatario=	usuarioServicio.getUsuario(atentaNota.getUsuarioDestino());
			Expediente expediente=new Expediente();
			PersonaDesaparecida desaparecido=new PersonaDesaparecida();
			if(null !=atentaNota.getIdExpediente()){
				expediente=expedienteServicios.getExpediente(atentaNota.getIdExpediente());
				desaparecido=personaDesaparecidaServicio.getPersonaDesaparecida(expediente.getIdPersonaDesaparecida());
			}			
					
			view.addObject("atentaNota", atentaNota);
			view.addObject("remitente", remitente);
			view.addObject("destinatario", destinatario);
			view.addObject("expediente", expediente);
			view.addObject("desaparecido", desaparecido);
		
		} catch (Exception e) {
			// TODO: handle exception
			LOG.error("Se genero un error en mostrarPDFAtentaNota", e);
		}

		

		return view;
	}
	
	 
private String getNameUser() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		return currentPrincipalName;
	}
	   

}
