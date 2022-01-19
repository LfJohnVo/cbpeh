package mx.gob.cbpeh.bpd.controlador;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import mx.gob.cbpeh.bpd.convert.CatalogoConverter;
import mx.gob.cbpeh.bpd.dto.CommonResponse;
import mx.gob.cbpeh.bpd.dto.CommonResponseElement;
import mx.gob.cbpeh.bpd.dto.ElementoCatDto;
import mx.gob.cbpeh.bpd.dto.ReqEditarCatalogoDto;
import mx.gob.cbpeh.bpd.servicio.*;

@Controller
@RequestMapping(value = "/admin")
public class AdminCatControlador {
	
	private static final Logger LOG = LoggerFactory.getLogger(AdminCatControlador.class);

	@Autowired
	private CatAreaServicio catAreaServicio;
	@Autowired
	private CatBaseNarizServicio catBaseNarizServicio;
	@Autowired
	private CatBocaServicio catBocaServicio;
	@Autowired
	private CatColorCabelloServicio catColorCabelloServicio;
	@Autowired
	private CatColorOjoServicio catColorOjoServicio; 
	@Autowired
	private CatCompaniaTelefonoServicio catCompaniaTelefonoServicio;
	@Autowired
	private CatComplexionServicio catComplexionServicio;
	@Autowired
	private CatDentaduraServicio catDentaduraServicio;
	@Autowired
	private CatDialectoServicio catDialectoServicio;
	@Autowired
	private CatDireccionServicio catDireccionServicio;
	@Autowired
	private CatEdadServicio catEdadServicio;
	@Autowired
	private CatEscolaridadServicio catEscolaridadServicio;
	@Autowired
	private CatEstadoCivilServicio catEstadoCivilServicio;
	@Autowired
	private CatEstatusColaboracionServicio catEstatusColaboracionServicio;
	@Autowired
	private CatEstatusEconomicoServicio catEstatusEconomicoServicio;
	@Autowired
	private CatEstatusLocalizadoServicio catEstatusLocalizadoServicio;
	@Autowired
	private CatEstatusVidaServicio catEstatusVidaServicio;
	@Autowired
	private CatFormaNarizServicio catFormaNarizServicio;
	@Autowired
	private CatFrenteServicio catFrenteServicio;
	@Autowired
	private CatGeneroServicio catGeneroServicio;
	@Autowired
	private CatGradoEstudioServicio catGradoEstudioServicio;
	@Autowired
	private CatGrupoEtnicoServicio catGrupoEtnicoServicio;
	@Autowired
	private CatIdiomaServicio catIdiomaServicio;
	@Autowired
	private CatLabioServicio catLabioServicio;
	@Autowired
	private CatLongitudCabelloServicio catLongitudCabelloServicio;
	@Autowired
	private CatLugarServicio catLugarServicio;
	@Autowired
	private CatLugarBusquedaServicio catLugarBusquedaServicio;
	@Autowired
	private CatMedioContactoServicio catMedioContactoServicio;
	@Autowired
	private CatMedioReporteServicio catMedioReporteServicio;
	@Autowired
	private CatNacionalidadServicio catNacionalidadServicio;
	@Autowired
	private CatOcupacionServicio catOcupacionServicio;
	@Autowired
	private CatParentescoServicio catParentescoServicio;
	@Autowired
	private CatPeriodicidadServicio catPeriodicidadServicio;
	@Autowired
	private CatPuestoServicio catPuestoServicio ;
	@Autowired
	private CatRedSocialServicio catRedSocialServicio;
	@Autowired
	private CatSexoServicio catSexoServicio;
	@Autowired
	private CatSiNoServicio catSiNoServicio;
	@Autowired
	private CatTamanioNarizServicio catTamanioNarizServicio ;
	@Autowired
	private CatTezServicio catTezServicio ;
	@Autowired
	private CatTipoArchivoServicio catTipoArchivoServicio ;
	@Autowired
	private CatTipoCabelloServicio catTipoCabelloServicio ;
	@Autowired
	private CatTipoComunicadoServicio catTipoComunicadoServicio ;
	@Autowired
	private CatTipoIdentificacionServicio catTipoIdentificacionServicio ;
	@Autowired
	private CatTipoNotaServicio catTipoNotaServicio ;
	@Autowired
	private CatTipoOjoServicio catTipoOjoServicio ;
	@Autowired
	private CatTipoSangreServicio catTipoSangreServicio ;
	@Autowired
	private CatTipoUsoServicio catTipoUsoServicio ;
	@Autowired
	private CatTransporteServicio catTransporteServicio ;

	@RequestMapping(value = "/acciones/buscarCatalogo", method = RequestMethod.GET)
	public ResponseEntity<CommonResponse> buscarCatalogo(@RequestParam("idCatalogo") Integer idCatalogo) {
		
		CommonResponseElement< List <ElementoCatDto> > commonResponse = new CommonResponseElement< List<ElementoCatDto> >();		
		try {			
			if(idCatalogo != null && catalogoValido(idCatalogo)){
				List <ElementoCatDto> elementos= new ArrayList<ElementoCatDto>();
				CatalogoConverter convert = new CatalogoConverter();
				switch(idCatalogo) {
				case 1:
					elementos= convert.areaToList(catAreaServicio.getCatAreas());
					break;
				case 2:
					elementos= convert.narizToList(catBaseNarizServicio.getCatBaseNariz());
					break;
				case 3:
					elementos= convert.bocaToList(catBocaServicio.getCatBocas());
					break;
				case 5:
					elementos= convert.colorCabelloToList(catColorCabelloServicio.getCatColorCabellos());
					break;
				case 6:
					elementos= convert.coloOjosToList(catColorOjoServicio.getCatColorOjos());
					break;
				case 7:
					elementos= convert.companiaTelToList(catCompaniaTelefonoServicio.getCatCompaniaTelefonos());
					break;
				case 8:
					elementos= convert.complexionToList(catComplexionServicio.getCatComplexiones());
					break;
				case 10:
					elementos= convert.dentaduraToList(catDentaduraServicio.getCatDentaduras());
					break;
				case 11:
					elementos= convert.dialectoToList(catDialectoServicio.getCatDialectos());
					break;
				case 12:
					elementos= convert.direccionToList(catDireccionServicio.getCatDirecciones());
					break;
				case 13:
					elementos= convert.edadesToList(catEdadServicio.getCatEdades());
					break;
				case 14:
					elementos= convert.escolaridadToList(catEscolaridadServicio.getCatEscolaridad());
					break;
				case 16:
					elementos= convert.edoCivilToList(catEstadoCivilServicio.getCatEstadoCivil());
					break;
				case 18:
					elementos= convert.estatusColaboToList(catEstatusColaboracionServicio.getCatEstatusColaboracions());
					break;
				case 19:
					elementos= convert.economicoToList(catEstatusEconomicoServicio.getCatEstatusEconomicos());
					break;
				case 20:
					elementos= convert.localizadoToList(catEstatusLocalizadoServicio.getCatEstatusLocalizados());
					break;
				case 21:
					elementos= convert.vidaToList(catEstatusVidaServicio.getCatEstatusVida());
					break;
				case 22:
					elementos= convert.formNarizToList(catFormaNarizServicio.getCatFormaNariz());
					break;
				case 23:
					elementos= convert.frenteToList(catFrenteServicio.getCatFrente());
					break;
				case 24:
					elementos= convert.generoToList(catGeneroServicio.getCatGenero());
					break;
				case 25:
					elementos= convert.gradoEstuToList(catGradoEstudioServicio.getCatGradoEstudio());
					break;
				case 26:
					elementos= convert.grupoEtniToList(catGrupoEtnicoServicio.getCatGrupoEtnicos());
					break;
				case 27:
					elementos= convert.idiomaToList(catIdiomaServicio.getCatIdiomas());
					break;
				case 29:
					elementos= convert.labioToList(catLabioServicio.getCatLabios());
					break;
				case 30:
					elementos= convert.longCabelloToList(catLongitudCabelloServicio.getCatLongitudCabello());
					break;
				case 31:
					elementos= convert.lugarToList(catLugarServicio.getCatLugar());
					break;
				case 32:
					elementos= convert.lugarBusqToList(catLugarBusquedaServicio.getCatLugarBusqueda());
					break;
				case 33:
					elementos= convert.medioContactoToList(catMedioContactoServicio.getCatMedioContactos());
					break;
				case 34:
					elementos= convert. medioReporteToList(catMedioReporteServicio.getCatMedioReportes());
					break;
				case 36:
					elementos= convert.nacionalidadToList(catNacionalidadServicio.getCatNacionalidad());
					break;
				case 37:
					elementos= convert.ocupacionToList(catOcupacionServicio.getCatOcupacion());
					break;
				case 38:
					elementos= convert.parentescoToList(catParentescoServicio.getCatParentescos());
					break;
				case 39:
					elementos= convert.periodicidadToList(catPeriodicidadServicio.getCatPeriodicidad());
					break;
				case 40:
					elementos= convert.puestoToList(catPuestoServicio.getCatPuestos());
					break;
				case 41:
					elementos= convert.redSocialToList(catRedSocialServicio.getCatRedSocial());
					break;
				case 42:
					elementos= convert.sexoToList(catSexoServicio.getCatSexo());
					break;
				case 43:
					elementos= convert.siNoToList(catSiNoServicio.getCatSiNo());
					break;
				case 44:
					elementos= convert.tamanioNarizToList(catTamanioNarizServicio.getCatTamanioNariz());
					break;
				case 45:
					elementos= convert.tezToList(catTezServicio.getCatTez());
					break;
				case 46:
					elementos= convert.tipoArchiToList(catTipoArchivoServicio.getCatTipoArchivos());
					break;
				case 47:
					elementos= convert.tipoCabelloToList(catTipoCabelloServicio.getCatTipoCabello());
					break;
				case 48:
					elementos= convert.tipoComunicadoToList(catTipoComunicadoServicio.getCatTipoComunicados());
					break;
				case 49:
					elementos= convert.tipoIdentiToList(catTipoIdentificacionServicio.getCatTipoIdentificacion());
					break;
				case 50:
					elementos= convert.tipoNotaToList(catTipoNotaServicio.getCatTipoNotas());
					break;
				case 51:
					elementos= convert.tipoOjoToList(catTipoOjoServicio.getCatTipoOjos());
					break;
				case 52:
					elementos= convert.tipoSangreToList(catTipoSangreServicio.getCatTipoSangre());
					break;
				case 53:
					elementos= convert.tipoUsoToList(catTipoUsoServicio.getCatTipoUsos());
					break;
				case 54:
					elementos= convert.transporteToList(catTransporteServicio.getCatTransportes());
					break;				
				}
				commonResponse.setElemento(elementos);
			}else {
				commonResponse.setEstatus(-2);
				commonResponse.setDescripcion("Catalogo seleccionado invalido");
				return new ResponseEntity<>(commonResponse, HttpStatus.OK);			
			}
		} catch (Exception e) {
			commonResponse.setEstatus(-3);
			commonResponse.setDescripcion("Se genero un error al consultar la informacion.");
			return new ResponseEntity<>(commonResponse, HttpStatus.OK);
		}
		commonResponse.setEstatus(1);
		commonResponse.setDescripcion("La informacion se consulto correctamente.");
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/acciones/editarGuardarCatalogo", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	private ResponseEntity<CommonResponse> editarCatalogo(@RequestBody ReqEditarCatalogoDto req) {
			
		CommonResponse commonResponse = new CommonResponse();
			
		try {			
			if(req.getIdCatalogo() != null && catalogoValido(req.getIdCatalogo())){
				CatalogoConverter convert = new CatalogoConverter();
				ElementoCatDto dto =req.getDto();
				dto.setDetalle(dto.getDetalle().toUpperCase());
				req.setDto(dto);
				switch(req.getIdCatalogo()) {
				case 1:
					catAreaServicio.saveCatArea(convert.dtoToArea(req.getDto()));
					break;
				case 2:
					catBaseNarizServicio.saveCatBaseNariz(convert.dtoToNariz(req.getDto()));
					break;
				case 3:
					catBocaServicio.saveCatBoca(convert.dtoToBoca(req.getDto()));
					break;
				case 5:
					catColorCabelloServicio.saveCatColorCabello(convert.dtoToColorCabello(req.getDto()));
					break;
				case 6:
					catColorOjoServicio.saveCatColorOjo(convert.dtoToColorOjo(req.getDto()));
					break;
				case 7:
					catCompaniaTelefonoServicio.saveCatCompaniaTelefono(convert.dtoToCompaniaTel(req.getDto()));
					break;
				case 8:
					catComplexionServicio.saveCatComplexion(convert.dtoToComplexion(req.getDto()));
					break;
				case 10:
					catDentaduraServicio.saveCatDentadura(convert.dtoToDentadura(req.getDto()));
					break;
				case 11:
					catDialectoServicio.saveCatDialecto(convert.dtoToDialecto(req.getDto()));
					break;
				case 13:
					catEdadServicio.saveCatEdad(convert.dtoToEad(req.getDto()));
					break;
				case 14:
					catEscolaridadServicio.saveCatEscolaridad(convert.dtoToEscolaridad(req.getDto()) );
					break;
				case 16:
					catEstadoCivilServicio.saveCatEstadoCivil(convert.dtoToEdoCivil(req.getDto()) );
					break;
				case 18:
					catEstatusColaboracionServicio.saveCatEstatusColaboracion(convert.dtoToEstatusColabora(req.getDto()) );
					break;
				case 19:
					catEstatusEconomicoServicio.saveCatEstatusEconomico(convert.dtoToEconomico(req.getDto()) );
					break;
				case 20:
					catEstatusLocalizadoServicio.saveCatEstatusLocalizado(convert.dtoToLocalizado(req.getDto()) );
					break;
				case 21:
					catEstatusVidaServicio.saveCatEstatusVida(convert.dtoToVida(req.getDto()) );
					break;
				case 22:
					catFormaNarizServicio.saveCatFormaNariz(convert.dtoToForNariz(req.getDto()));
					break;
				case 23:
					catFrenteServicio.saveCatFrente(convert.dtoToFrente(req.getDto()));
					break;
				case 24:
					catGeneroServicio.saveCatGenero(convert.dtoToGenero(req.getDto()) );
					break;
				case 25:
					catGradoEstudioServicio.saveCatGradoEstudio(convert.dtoToGradoEstu(req.getDto()));
					break;
				case 26:
					catGrupoEtnicoServicio.saveCatGrupoEtnico(convert.dtoToGrupoEtni(req.getDto()));
					break;
				case 27:
					catIdiomaServicio.saveCatIdioma(convert.dtoToIdioma(req.getDto()));
					break;
				case 29:
					catLabioServicio.saveCatLabio(convert.dtoToLabio(req.getDto()));
					break;
				case 30:
					catLongitudCabelloServicio.saveCatLongitudCabello(convert.dtoToLongCabello(req.getDto()));
					break;
				case 31:
					catLugarServicio.saveCatLugar(convert.dtoToLugar(req.getDto()));
					break;
				case 32:
					catLugarBusquedaServicio.saveCatLugarBusqueda(convert.dtoToLugarBusq(req.getDto()));
					break;
				case 33:
					catMedioContactoServicio.saveCatMedioContacto(convert.dtoToMedioContacto(req.getDto()));
					break;
				case 34:
					catMedioReporteServicio.saveCatMedioReporte(convert.dtoToMedioReporte(req.getDto()));
					break;
				case 36:
					catNacionalidadServicio.saveCatNacionalidad(convert.dtoToNacionalidad(req.getDto()));
					break;
				case 37:
					catOcupacionServicio.saveCatOcupacion(convert.dtoToOcupacion(req.getDto()));
					break;
				case 38:
					catParentescoServicio.saveCatParentesco(convert.dtoToParentesco(req.getDto()));
					break;
				case 39:
					catPeriodicidadServicio.saveCatPeriodicidad(convert.dtoToPeriodicidad(req.getDto()));
					break;
				case 40:
					catPuestoServicio.saveCatPuesto(convert.dtoToPuesto(req.getDto()));
					break;
				case 41:
					catRedSocialServicio.saveCatRedSocial(convert.dtoToRedSocial(req.getDto()));
					break;
				case 42:
					catSexoServicio.saveCatSexo(convert.dtoToSexo(req.getDto()));
					break;
				case 43:
					catSiNoServicio.saveCatSiNo(convert.dtoToSiNo(req.getDto()));
					break;
				case 44:
					catTamanioNarizServicio.saveCatTamanioNariz(convert.dtoToTamanioNariz(req.getDto()));
					break;
				case 45:
					catTezServicio.saveCatTez(convert.dtoToTez(req.getDto()));
					break;
				case 46:
					catTipoArchivoServicio.saveCatTipoArchivo(convert.dtoToTipoArchivo(req.getDto()));
					break;
				case 47:
					catTipoCabelloServicio.saveCatTipoCabello(convert.dtoToTipoCabello(req.getDto()));
					break;
				case 48:
					catTipoComunicadoServicio.saveCatTipoComunicado(convert.dtoToTipoComunicado(req.getDto()));
					break;
				case 49:
					catTipoIdentificacionServicio.saveCatTipoIdentificacion(convert.dtoToTipoidenti(req.getDto()));
					break;
				case 50:
					catTipoNotaServicio.saveCatTipoNota(convert.dtoToTipoNota(req.getDto()));
					break;
				case 51:
					catTipoOjoServicio.saveCatTipoOjo(convert.dtoToTipoOjo(req.getDto() ));
					break;
				case 52:
					catTipoSangreServicio.saveCatTipoSangre(convert.dtoToTipoSangre(req.getDto()));
					break;
				case 53:
					catTipoUsoServicio.saveCatTipoUso(convert.dtoToTipoUso(req.getDto()));
					break;
				case 54:
					catTransporteServicio.saveCatTransporte(convert.dtoToTransporte(req.getDto()));
					break;
						
				}
				commonResponse.setEstatus(1);
				commonResponse.setDescripcion("La informacion se guardo correctamente.");
			}else {
				commonResponse.setEstatus(-2);
				commonResponse.setDescripcion("Catalogo seleccionado invalido");
				return new ResponseEntity<>(commonResponse, HttpStatus.OK);			
			}
		} catch (Exception e) {
			commonResponse.setEstatus(-3);
			commonResponse.setDescripcion("Se genero un inconveniente al guardar la informacion.");	
			return new ResponseEntity<>(commonResponse, HttpStatus.OK);
		}
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/acciones/eliminarCatalogo", method = RequestMethod.GET, produces = "application/json")
	private ResponseEntity<CommonResponse> eliminarCatalogo(@RequestParam("idCatalogo") Integer idCatalogo,@RequestParam("idElemCatalogo") Integer idElemCatalogo) {
			
		CommonResponse commonResponse = new CommonResponse();
			
		try {
			if(idCatalogo != null && catalogoValido(idCatalogo)){
				CatalogoConverter convert = new CatalogoConverter();
				switch(idCatalogo) {
				case 1:
					catAreaServicio.deleteCatArea(idElemCatalogo);
					break;
				case 2:
					catBaseNarizServicio.deleteCatBaseNariz(idElemCatalogo);
					break;
				case 3:
					catBocaServicio.deleteCatBoca(idElemCatalogo);
					break;
				case 5:
					catColorCabelloServicio.deleteCatColorCabello(idElemCatalogo);
					break;
				case 6:
					catColorOjoServicio.deleteCatColorOjo(idElemCatalogo);
					break;
				case 7:
					catCompaniaTelefonoServicio.deleteCatCompaniaTelefono(idElemCatalogo);
					break;
				case 8:
					catComplexionServicio.deleteCatComplexion(idElemCatalogo);
					break;
				case 10:
					catDentaduraServicio.deleteCatDentadura(idElemCatalogo);
					break;
				case 11:
					catDialectoServicio.deleteCatDialecto(idElemCatalogo);
					break;
				case 13:
					catEdadServicio.deleteCatEdad(idElemCatalogo);
					break;
				case 14:
					catEscolaridadServicio.deleteCatEscolaridad(idElemCatalogo);
					break;
				case 16:
					catEstadoCivilServicio.deleteCatEstadoCivil(idElemCatalogo);
					break;
				case 18:
					catEstatusColaboracionServicio.deleteCatEstatusColaboracion(idElemCatalogo);
					break;
				case 19:
					catEstatusEconomicoServicio.deleteCatEstatusEconomico(idElemCatalogo);
					break;
				case 20:
					catEstatusLocalizadoServicio.deleteCatEstatusLocalizado(idElemCatalogo);
					break;
				case 21:
					catEstatusVidaServicio.deleteCatEstatusVida(idElemCatalogo);
					break;
				case 22:
					catFormaNarizServicio.deleteCatFormaNariz(idElemCatalogo);
					break;
				case 23:
					catFrenteServicio.deleteCatFrente(idElemCatalogo);
					break;
				case 24:
					catGeneroServicio.deleteCatGenero(idElemCatalogo);
					break;
				case 25:
					catGradoEstudioServicio.deleteCatGradoEstudio(idElemCatalogo);
					break;
				case 26:
					catGrupoEtnicoServicio.deleteCatGrupoEtnico(idElemCatalogo);
					break;
				case 27:
					catIdiomaServicio.deleteCatIdioma(idElemCatalogo);
					break;
				case 29:
					catLabioServicio.deleteCatLabio(idElemCatalogo);
					break;
				case 30:
					catLongitudCabelloServicio.deleteCatLongitudCabello(idElemCatalogo);
					break;
				case 31:
					catLugarServicio.deleteCatLugar(idElemCatalogo);
					break;
				case 32:
					catLugarBusquedaServicio.deleteCatLugarBusqueda(idElemCatalogo);
					break;
				case 33:
					catMedioContactoServicio.deleteCatMedioContacto(idElemCatalogo);
					break;
				case 34:
					catMedioReporteServicio.deleteCatMedioReporte(idElemCatalogo);
					break;
				case 36:
					catNacionalidadServicio.deleteCatNacionalidad(idElemCatalogo);
					break;
				case 37:
					catOcupacionServicio.deleteCatOcupacion(idElemCatalogo);
					break;
				case 38:
					catParentescoServicio.deleteCatParentesco(idElemCatalogo);
					break;
				case 39:
					catPeriodicidadServicio.deleteCatPeriodicidad(idElemCatalogo);
					break;
				case 40:
					catPuestoServicio.deleteCatPuesto(idElemCatalogo);
					break;
				case 41:
					catRedSocialServicio.deleteCatRedSocial(idElemCatalogo);
					break;
				case 42:
					catSexoServicio.deleteCatSexo(idElemCatalogo);
					break;
				case 43:
					catSiNoServicio.deleteCatSiNo(idElemCatalogo);
					break;
				case 44:
					catTamanioNarizServicio.deleteCatTamanioNariz(idElemCatalogo);
					break;
				case 45:
					catTezServicio.deleteCatTez(idElemCatalogo);
					break;
				case 46:
					catTipoArchivoServicio.deleteCatTipoArchivo(idElemCatalogo);
					break;
				case 47:
					catTipoCabelloServicio.deleteCatTipoCabello(idElemCatalogo);
					break;
				case 48:
					catTipoComunicadoServicio.deleteCatTipoComunicado(idElemCatalogo);
					break;
				case 49:
					catTipoIdentificacionServicio.deleteCatTipoIdentificacion(idElemCatalogo);
					break;
				case 50:
					catTipoNotaServicio.deleteCatTipoNota(idElemCatalogo);
					break;
				case 51:
					catTipoOjoServicio.deleteCatTipoOjo(idElemCatalogo);
					break;
				case 52:
					catTipoSangreServicio.deleteCatTipoSangre(idElemCatalogo);
					break;
				case 53:
					catTipoUsoServicio.deleteCatTipoUso(idElemCatalogo);
					break;
				case 54:
					catTransporteServicio.deleteCatTransporte(idElemCatalogo);
					break;
						
				}
				commonResponse.setEstatus(1);
				commonResponse.setDescripcion("La informacion se guardo correctamente.");
			}else {
				commonResponse.setEstatus(-2);
				commonResponse.setDescripcion("Catalogo seleccionado invalido");
				return new ResponseEntity<>(commonResponse, HttpStatus.OK);			
			}
		} catch (Exception e) {
			commonResponse.setEstatus(-3);
			commonResponse.setDescripcion("Se genero un inconveniente al guardar la informacion.");	
			return new ResponseEntity<>(commonResponse, HttpStatus.OK);
		}
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}

	private boolean catalogoValido(Integer idCatalogo) {	// de mas de 3 campos id,detalle,estatus
		if(idCatalogo != 4 && idCatalogo != 9 && idCatalogo != 15 && idCatalogo != 17 && idCatalogo != 28 && idCatalogo != 35  ) {
			return true;
		}else {
			return false;
		}		
	}
}
