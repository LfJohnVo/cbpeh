package mx.gob.cbpeh.bpd.convert;

import java.util.ArrayList;
import java.util.List;

import mx.gob.cbpeh.bpd.dto.ElementoCatDto;
import mx.gob.cbpeh.bpd.modelo.CatArea;
import mx.gob.cbpeh.bpd.modelo.CatBaseNariz;
import mx.gob.cbpeh.bpd.modelo.CatBoca;
import mx.gob.cbpeh.bpd.modelo.CatColorCabello;
import mx.gob.cbpeh.bpd.modelo.CatColorOjo;
import mx.gob.cbpeh.bpd.modelo.CatCompaniaTelefono;
import mx.gob.cbpeh.bpd.modelo.CatComplexion;
import mx.gob.cbpeh.bpd.modelo.CatDentadura;
import mx.gob.cbpeh.bpd.modelo.CatDialecto;
import mx.gob.cbpeh.bpd.modelo.CatDireccion;
import mx.gob.cbpeh.bpd.modelo.CatEdad;
import mx.gob.cbpeh.bpd.modelo.CatEscolaridad;
import mx.gob.cbpeh.bpd.modelo.CatEstadoCivil;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.modelo.CatEstatusColaboracion;
import mx.gob.cbpeh.bpd.modelo.CatEstatusEconomico;
import mx.gob.cbpeh.bpd.modelo.CatEstatusLocalizado;
import mx.gob.cbpeh.bpd.modelo.CatEstatusVida;
import mx.gob.cbpeh.bpd.modelo.CatFormaNariz;
import mx.gob.cbpeh.bpd.modelo.CatFrente;
import mx.gob.cbpeh.bpd.modelo.CatGenero;
import mx.gob.cbpeh.bpd.modelo.CatGradoEstudio;
import mx.gob.cbpeh.bpd.modelo.CatGrupoEtnico;
import mx.gob.cbpeh.bpd.modelo.CatIdioma;
import mx.gob.cbpeh.bpd.modelo.CatLabio;
import mx.gob.cbpeh.bpd.modelo.CatLongitudCabello;
import mx.gob.cbpeh.bpd.modelo.CatLugar;
import mx.gob.cbpeh.bpd.modelo.CatLugarBusqueda;
import mx.gob.cbpeh.bpd.modelo.CatMedioContacto;
import mx.gob.cbpeh.bpd.modelo.CatMedioReporte;
import mx.gob.cbpeh.bpd.modelo.CatNacionalidad;
import mx.gob.cbpeh.bpd.modelo.CatOcupacion;
import mx.gob.cbpeh.bpd.modelo.CatParentesco;
import mx.gob.cbpeh.bpd.modelo.CatPeriodicidad;
import mx.gob.cbpeh.bpd.modelo.CatPuesto;
import mx.gob.cbpeh.bpd.modelo.CatRedSocial;
import mx.gob.cbpeh.bpd.modelo.CatSexo;
import mx.gob.cbpeh.bpd.modelo.CatSiNo;
import mx.gob.cbpeh.bpd.modelo.CatTamanioNariz;
import mx.gob.cbpeh.bpd.modelo.CatTez;
import mx.gob.cbpeh.bpd.modelo.CatTipoArchivo;
import mx.gob.cbpeh.bpd.modelo.CatTipoCabello;
import mx.gob.cbpeh.bpd.modelo.CatTipoComunicado;
import mx.gob.cbpeh.bpd.modelo.CatTipoIdentificacion;
import mx.gob.cbpeh.bpd.modelo.CatTipoNota;
import mx.gob.cbpeh.bpd.modelo.CatTipoOjo;
import mx.gob.cbpeh.bpd.modelo.CatTipoSangre;
import mx.gob.cbpeh.bpd.modelo.CatTipoUso;
import mx.gob.cbpeh.bpd.modelo.CatTransporte;

public class CatalogoConverter {
	
	List<ElementoCatDto> listaElementos= null;
	
	public CatArea dtoToArea(ElementoCatDto dto) {
		CatArea cat = new CatArea();
		cat.setIdArea(dto.getIdCatalogo());
		cat.setAreaDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public ElementoCatDto areaToDto (CatArea ent) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(ent.getIdArea());
		dto.setDetalle(ent.getAreaDetalle());
		dto.setEstatus(ent.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public List<ElementoCatDto> areaToList(List<CatArea> lista){
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatArea e:lista) {
			ElementoCatDto d= areaToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}
	
	public List<ElementoCatDto> narizToList(List<CatBaseNariz> lista){
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatBaseNariz e:lista) {
			ElementoCatDto d= narizToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	public ElementoCatDto narizToDto(CatBaseNariz ent) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(ent.getIdBaseNariz());
		dto.setDetalle(ent.getBaseNarizDetalle());
		dto.setEstatus(ent.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatBaseNariz dtoToNariz(ElementoCatDto dto) {
		CatBaseNariz cat = new CatBaseNariz();
		cat.setIdBaseNariz(dto.getIdCatalogo());
		cat.setBaseNarizDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> bocaToList(List<CatBoca> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatBoca e:lista) {
			ElementoCatDto d= bocaToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	public ElementoCatDto bocaToDto(CatBoca e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdBoca());
		dto.setDetalle(e.getBocaDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatBoca dtoToBoca(ElementoCatDto dto) {
		CatBoca cat = new CatBoca();
		cat.setIdBoca(dto.getIdCatalogo());
		cat.setBocaDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> colorCabelloToList(List<CatColorCabello> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatColorCabello e:lista) {
			ElementoCatDto d= colorCabelloToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	public ElementoCatDto colorCabelloToDto(CatColorCabello e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdColorCabello());
		dto.setDetalle(e.getColorCabelloDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatColorCabello dtoToColorCabello(ElementoCatDto dto) {
		CatColorCabello cat = new CatColorCabello();
		cat.setIdColorCabello(dto.getIdCatalogo());
		cat.setColorCabelloDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> coloOjosToList(List<CatColorOjo> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatColorOjo e:lista) {
			ElementoCatDto d= colorOjoToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	public ElementoCatDto colorOjoToDto(CatColorOjo e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdColorOjo());
		dto.setDetalle(e.getColorOjoDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatColorOjo dtoToColorOjo(ElementoCatDto dto) {
		CatColorOjo cat = new CatColorOjo();
		cat.setIdColorOjo(dto.getIdCatalogo());
		cat.setColorOjoDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> companiaTelToList(List<CatCompaniaTelefono> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatCompaniaTelefono e:lista) {
			ElementoCatDto d= companiaTelToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto companiaTelToDto(CatCompaniaTelefono e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdCompaniaTelefono());
		dto.setDetalle(e.getCompaniaTelefonoDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatCompaniaTelefono dtoToCompaniaTel(ElementoCatDto dto) {
		CatCompaniaTelefono cat = new CatCompaniaTelefono();
		cat.setIdCompaniaTelefono(dto.getIdCatalogo());
		cat.setCompaniaTelefonoDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> complexionToList(List<CatComplexion> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatComplexion e:lista) {
			ElementoCatDto d= complexionToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	public ElementoCatDto complexionToDto(CatComplexion e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdComplexion());
		dto.setDetalle(e.getComplexionDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatComplexion dtoToComplexion(ElementoCatDto dto) {
		CatComplexion cat = new CatComplexion();
		cat.setIdComplexion(dto.getIdCatalogo());
		cat.setComplexionDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> dentaduraToList(List<CatDentadura> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatDentadura e:lista) {
			ElementoCatDto d= dentaduraToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}
	private ElementoCatDto dentaduraToDto(CatDentadura e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdDentadura());
		dto.setDetalle(e.getDentaduraDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	public CatDentadura dtoToDentadura(ElementoCatDto dto) {
		CatDentadura cat = new CatDentadura();
		cat.setIdDentadura(dto.getIdCatalogo());
		cat.setDentaduraDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> dialectoToList(List<CatDialecto> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatDialecto e:lista) {
			ElementoCatDto d= dialectoToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}
	public ElementoCatDto dialectoToDto(CatDialecto e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdDialecto());
		dto.setDetalle(e.getDialectoDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	public CatDialecto dtoToDialecto(ElementoCatDto dto) {
		CatDialecto cat = new CatDialecto();
		cat.setIdDialecto(dto.getIdCatalogo());
		cat.setDialectoDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> edadesToList(List<CatEdad> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatEdad e:lista) {
			ElementoCatDto d= edadToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}
	public ElementoCatDto edadToDto(CatEdad e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdEdad());
		dto.setDetalle(e.getEdadDetalle().toString());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	public CatEdad dtoToEad(ElementoCatDto dto) {
		CatEdad cat = new CatEdad();
		cat.setIdEdad(dto.getIdCatalogo());
		cat.setEdadDetalle(Integer.valueOf(dto.getDetalle()));
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> escolaridadToList(List<CatEscolaridad> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatEscolaridad e:lista) {
			ElementoCatDto d= escolaridadToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	public ElementoCatDto escolaridadToDto(CatEscolaridad e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdEscolaridad());
		dto.setDetalle(e.getEscolaridadDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatEscolaridad dtoToEscolaridad(ElementoCatDto dto) {
		CatEscolaridad cat = new CatEscolaridad();
		cat.setIdEscolaridad(dto.getIdCatalogo());
		cat.setEscolaridadDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> edoCivilToList(List<CatEstadoCivil> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatEstadoCivil e:lista) {
			ElementoCatDto d= edoCivilToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	public ElementoCatDto edoCivilToDto(CatEstadoCivil e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdEstadoCivil());
		dto.setDetalle(e.getEstadoCivil());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatEstadoCivil dtoToEdoCivil(ElementoCatDto dto) {
		CatEstadoCivil cat = new CatEstadoCivil();
		cat.setIdEstadoCivil(dto.getIdCatalogo());
		cat.setEstadoCivil(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> estatusColaboToList(List<CatEstatusColaboracion> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatEstatusColaboracion e:lista) {
			ElementoCatDto d= estatusColaboToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	public ElementoCatDto estatusColaboToDto(CatEstatusColaboracion e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdEstatusColaboracion());
		dto.setDetalle(e.getEstatusColaboracionDetalle());
		dto.setEstatus(e.getEstatusColaboracion());
		return dto;
	}
	public CatEstatusColaboracion dtoToEstatusColabora(ElementoCatDto dto) {
		CatEstatusColaboracion cat = new CatEstatusColaboracion();
		cat.setIdEstatusColaboracion(dto.getIdCatalogo());
		cat.setEstatusColaboracionDetalle(dto.getDetalle());
		cat.setEstatusColaboracion(dto.getEstatus());
		return cat;
	}
	

	public List<ElementoCatDto> economicoToList(List<CatEstatusEconomico> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatEstatusEconomico e:lista) {
			ElementoCatDto d= economicoToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	public ElementoCatDto economicoToDto(CatEstatusEconomico e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdEstatusEconomico());
		dto.setDetalle(e.getEstatusEconomicoDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatEstatusEconomico dtoToEconomico(ElementoCatDto dto) {
		CatEstatusEconomico cat = new CatEstatusEconomico();
		cat.setIdEstatusEconomico(dto.getIdCatalogo());
		cat.setEstatusEconomicoDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> localizadoToList(List<CatEstatusLocalizado> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatEstatusLocalizado e:lista) {
			ElementoCatDto d= localizadoToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto localizadoToDto(CatEstatusLocalizado e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdEstatusLocalizado());
		dto.setDetalle(e.getEstatusLocalizadoDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatEstatusLocalizado dtoToLocalizado(ElementoCatDto dto) {
		CatEstatusLocalizado cat = new CatEstatusLocalizado();
		cat.setIdEstatusLocalizado(dto.getIdCatalogo());
		cat.setEstatusLocalizadoDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> vidaToList(List<CatEstatusVida> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatEstatusVida e:lista) {
			ElementoCatDto d= vidaToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto vidaToDto(CatEstatusVida e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdEstatusVida());
		dto.setDetalle(e.getEstatusVidaDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatEstatusVida dtoToVida(ElementoCatDto dto) {
		CatEstatusVida cat = new CatEstatusVida();
		cat.setIdEstatusVida(dto.getIdCatalogo());
		cat.setEstatusVidaDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> formNarizToList(List<CatFormaNariz> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatFormaNariz e:lista) {
			ElementoCatDto d= forNarizToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto forNarizToDto(CatFormaNariz e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdFormaNariz());
		dto.setDetalle(e.getFormaNarizDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatFormaNariz dtoToForNariz(ElementoCatDto dto) {
		CatFormaNariz cat = new CatFormaNariz();
		cat.setIdFormaNariz(dto.getIdCatalogo());
		cat.setFormaNarizDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> frenteToList(List<CatFrente> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatFrente e:lista) {
			ElementoCatDto d= frenteToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto frenteToDto(CatFrente e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdFrente());
		dto.setDetalle(e.getFrenteDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatFrente dtoToFrente(ElementoCatDto dto) {
		CatFrente cat = new CatFrente();
		cat.setIdFrente(dto.getIdCatalogo());
		cat.setFrenteDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> generoToList(List<CatGenero> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatGenero e:lista) {
			ElementoCatDto d= generoToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto generoToDto(CatGenero e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdGenero());
		dto.setDetalle(e.getGeneroDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatGenero dtoToGenero(ElementoCatDto dto) {
		CatGenero cat = new CatGenero();
		cat.setIdGenero(dto.getIdCatalogo());
		cat.setGeneroDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> gradoEstuToList(List<CatGradoEstudio> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatGradoEstudio e:lista) {
			ElementoCatDto d= gradoEstuToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto gradoEstuToDto(CatGradoEstudio e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdGradoEstudio());
		dto.setDetalle(e.getGradoEstudioDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatGradoEstudio dtoToGradoEstu(ElementoCatDto dto) {
		CatGradoEstudio cat = new CatGradoEstudio();
		cat.setIdGradoEstudio(dto.getIdCatalogo());
		cat.setGradoEstudioDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> grupoEtniToList(List<CatGrupoEtnico> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatGrupoEtnico e:lista) {
			ElementoCatDto d= grupoEtniToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto grupoEtniToDto(CatGrupoEtnico e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdGrupoEtnico());
		dto.setDetalle(e.getGrupoEtnicoDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatGrupoEtnico dtoToGrupoEtni(ElementoCatDto dto) {
		CatGrupoEtnico cat = new CatGrupoEtnico();
		cat.setIdGrupoEtnico(dto.getIdCatalogo());
		cat.setGrupoEtnicoDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> idiomaToList(List<CatIdioma> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatIdioma e:lista) {
			ElementoCatDto d= idiomaToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto idiomaToDto(CatIdioma e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdIdioma());
		dto.setDetalle(e.getIdiomaDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatIdioma dtoToIdioma(ElementoCatDto dto) {
		CatIdioma cat = new CatIdioma();
		cat.setIdIdioma(dto.getIdCatalogo());
		cat.setIdiomaDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> labioToList(List<CatLabio> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatLabio e:lista) {
			ElementoCatDto d= labioToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto labioToDto(CatLabio e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdLabio());
		dto.setDetalle(e.getLabioDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatLabio dtoToLabio(ElementoCatDto dto) {
		CatLabio cat = new CatLabio();
		cat.setIdLabio(dto.getIdCatalogo());
		cat.setLabioDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> longCabelloToList(List<CatLongitudCabello> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatLongitudCabello e:lista) {
			ElementoCatDto d= longCabelloToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto longCabelloToDto(CatLongitudCabello e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdLognitudCabello());
		dto.setDetalle(e.getLongitudCabelloDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatLongitudCabello dtoToLongCabello(ElementoCatDto dto) {
		CatLongitudCabello cat = new CatLongitudCabello();
		cat.setIdLognitudCabello(dto.getIdCatalogo());
		cat.setLongitudCabelloDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> lugarToList(List<CatLugar> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatLugar e:lista) {
			ElementoCatDto d= lugarToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto lugarToDto(CatLugar e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdLugar());
		dto.setDetalle(e.getLugarDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	public CatLugar dtoToLugar(ElementoCatDto dto) {
		CatLugar cat = new CatLugar();
		cat.setIdLugar(dto.getIdCatalogo());
		cat.setLugarDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> lugarBusqToList(List<CatLugarBusqueda> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatLugarBusqueda e:lista) {
			ElementoCatDto d= lugarBusqToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto lugarBusqToDto(CatLugarBusqueda e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdLugarBusqueda());
		dto.setDetalle(e.getLugarBusquedaDetalle());
		dto.setEstatus(Integer.valueOf( e.getEstatusLugarBusqueda()) );
		return dto;
	}
	
	public CatLugarBusqueda dtoToLugarBusq(ElementoCatDto dto) {
		CatLugarBusqueda cat = new CatLugarBusqueda();
		cat.setIdLugarBusqueda(dto.getIdCatalogo());
		cat.setLugarBusquedaDetalle(dto.getDetalle());
		cat.setEstatusLugarBusqueda( dto.getEstatus().byteValue() );
		return cat;
	}

	public List<ElementoCatDto> medioContactoToList(List<CatMedioContacto> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatMedioContacto e:lista) {
			ElementoCatDto d= medioContactoToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto medioContactoToDto(CatMedioContacto e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdMedioContacto());
		dto.setDetalle(e.getMedioContactoDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatMedioContacto dtoToMedioContacto(ElementoCatDto dto) {
		CatMedioContacto cat = new CatMedioContacto();
		cat.setIdMedioContacto(dto.getIdCatalogo());
		cat.setMedioContactoDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> medioReporteToList(List<CatMedioReporte> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatMedioReporte e:lista) {
			ElementoCatDto d= medioReporteToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto medioReporteToDto(CatMedioReporte e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdMedioReporte());
		dto.setDetalle(e.getMedioReporteDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatMedioReporte dtoToMedioReporte(ElementoCatDto dto) {
		CatMedioReporte cat = new CatMedioReporte();
		cat.setIdMedioReporte(dto.getIdCatalogo());
		cat.setMedioReporteDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> nacionalidadToList(List<CatNacionalidad> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatNacionalidad e:lista) {
			ElementoCatDto d= nacionalidadToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto nacionalidadToDto(CatNacionalidad e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdNacionalidad());
		dto.setDetalle(e.getNacionalidadDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatNacionalidad dtoToNacionalidad(ElementoCatDto dto) {
		CatNacionalidad cat = new CatNacionalidad();
		cat.setIdNacionalidad(dto.getIdCatalogo());
		cat.setNacionalidadDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> ocupacionToList(List<CatOcupacion> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatOcupacion e:lista) {
			ElementoCatDto d= ocupacionToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto ocupacionToDto(CatOcupacion e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdOcupacion());
		dto.setDetalle(e.getOcucpacionDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatOcupacion dtoToOcupacion(ElementoCatDto dto) {
		CatOcupacion cat = new CatOcupacion();
		cat.setIdOcupacion(dto.getIdCatalogo());
		cat.setOcucpacionDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> parentescoToList(List<CatParentesco> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatParentesco e:lista) {
			ElementoCatDto d= parentescoToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto parentescoToDto(CatParentesco e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdParentesco());
		dto.setDetalle(e.getParentescoDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatParentesco dtoToParentesco(ElementoCatDto dto) {
		CatParentesco cat = new CatParentesco();
		cat.setIdParentesco(dto.getIdCatalogo());
		cat.setParentescoDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> periodicidadToList(List<CatPeriodicidad> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatPeriodicidad e:lista) {
			ElementoCatDto d= periodicidadToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto periodicidadToDto(CatPeriodicidad e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdPeriodicidad());
		dto.setDetalle(e.getPeriodicidadDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatPeriodicidad dtoToPeriodicidad(ElementoCatDto dto) {
		CatPeriodicidad cat = new CatPeriodicidad();
		cat.setIdPeriodicidad(dto.getIdCatalogo());
		cat.setPeriodicidadDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> puestoToList(List<CatPuesto> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatPuesto e:lista) {
			ElementoCatDto d= puestoToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto puestoToDto(CatPuesto e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdPuesto());
		dto.setDetalle(e.getPuestoDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatPuesto dtoToPuesto(ElementoCatDto dto) {
		CatPuesto cat = new CatPuesto();
		cat.setIdPuesto(dto.getIdCatalogo());
		cat.setPuestoDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> redSocialToList(List<CatRedSocial> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatRedSocial e:lista) {
			ElementoCatDto d= redSocialToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto redSocialToDto(CatRedSocial e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdRedSocial());
		dto.setDetalle(e.getRedSocialDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatRedSocial dtoToRedSocial(ElementoCatDto dto) {
		CatRedSocial cat = new CatRedSocial();
		cat.setIdRedSocial(dto.getIdCatalogo());
		cat.setRedSocialDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> sexoToList(List<CatSexo> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatSexo e:lista) {
			ElementoCatDto d= sexoToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto sexoToDto(CatSexo e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdSexo());
		dto.setDetalle(e.getSexoDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatSexo dtoToSexo(ElementoCatDto dto) {
		CatSexo cat = new CatSexo();
		cat.setIdSexo(dto.getIdCatalogo());
		cat.setSexoDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> siNoToList(List<CatSiNo> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatSiNo e:lista) {
			ElementoCatDto d= siNoToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto siNoToDto(CatSiNo e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdSiNo());
		dto.setDetalle(e.getSiNoDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatSiNo dtoToSiNo(ElementoCatDto dto) {
		CatSiNo cat = new CatSiNo();
		cat.setIdSiNo(dto.getIdCatalogo());
		cat.setSiNoDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> tamanioNarizToList(List<CatTamanioNariz> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatTamanioNariz e:lista) {
			ElementoCatDto d= tamanioNarizToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto tamanioNarizToDto(CatTamanioNariz e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdTamanioNariz());
		dto.setDetalle(e.getTamanioNarizDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatTamanioNariz dtoToTamanioNariz(ElementoCatDto dto) {
		CatTamanioNariz cat = new CatTamanioNariz();
		cat.setIdTamanioNariz(dto.getIdCatalogo());
		cat.setTamanioNarizDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> tezToList(List<CatTez> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatTez e:lista) {
			ElementoCatDto d= tezToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto tezToDto(CatTez e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdTez());
		dto.setDetalle(e.getTezDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatTez dtoToTez(ElementoCatDto dto) {
		CatTez cat = new CatTez();
		cat.setIdTez(dto.getIdCatalogo());
		cat.setTezDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> tipoArchiToList(List<CatTipoArchivo> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatTipoArchivo e:lista) {
			ElementoCatDto d= tipoArchivoToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto tipoArchivoToDto(CatTipoArchivo e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdTipoArchivo());
		dto.setDetalle(e.getTipoArchivoDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatTipoArchivo dtoToTipoArchivo(ElementoCatDto dto) {
		CatTipoArchivo cat = new CatTipoArchivo();
		cat.setIdTipoArchivo(dto.getIdCatalogo());
		cat.setTipoArchivoDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> tipoCabelloToList(List<CatTipoCabello> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatTipoCabello e:lista) {
			ElementoCatDto d= tipoCabelloToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto tipoCabelloToDto(CatTipoCabello e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdTipoCabello());
		dto.setDetalle(e.getTipoCabelloDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatTipoCabello dtoToTipoCabello(ElementoCatDto dto) {
		CatTipoCabello cat = new CatTipoCabello();
		cat.setIdTipoCabello(dto.getIdCatalogo());
		cat.setTipoCabelloDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> tipoComunicadoToList(List<CatTipoComunicado> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatTipoComunicado e:lista) {
			ElementoCatDto d= tipoComunicadoToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto tipoComunicadoToDto(CatTipoComunicado e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdTipoComunicado());
		dto.setDetalle(e.getTipoComunicadoDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatTipoComunicado dtoToTipoComunicado(ElementoCatDto dto) {
		CatTipoComunicado cat = new CatTipoComunicado();
		cat.setIdTipoComunicado(dto.getIdCatalogo());
		cat.setTipoComunicadoDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> tipoIdentiToList(List<CatTipoIdentificacion> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatTipoIdentificacion e:lista) {
			ElementoCatDto d= tipoIdentiToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto tipoIdentiToDto(CatTipoIdentificacion e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdTipoIdentificacion());
		dto.setDetalle(e.getTipoIdentificacionDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatTipoIdentificacion dtoToTipoidenti(ElementoCatDto dto) {
		CatTipoIdentificacion cat = new CatTipoIdentificacion();
		cat.setIdTipoIdentificacion(dto.getIdCatalogo());
		cat.setTipoIdentificacionDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> tipoNotaToList(List<CatTipoNota> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatTipoNota e:lista) {
			ElementoCatDto d= tipoNotaToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto tipoNotaToDto(CatTipoNota e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdTipoNota());
		dto.setDetalle(e.getTipoNotaDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatTipoNota dtoToTipoNota(ElementoCatDto dto) {
		CatTipoNota cat = new CatTipoNota();
		cat.setIdTipoNota(dto.getIdCatalogo());
		cat.setTipoNotaDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> tipoOjoToList(List<CatTipoOjo> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatTipoOjo e:lista) {
			ElementoCatDto d= tipoOjoToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto tipoOjoToDto(CatTipoOjo e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdTipoOjo());
		dto.setDetalle(e.getTipoOjoDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatTipoOjo dtoToTipoOjo(ElementoCatDto dto) {
		CatTipoOjo cat = new CatTipoOjo();
		cat.setIdTipoOjo(dto.getIdCatalogo());
		cat.setTipoOjoDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> tipoSangreToList(List<CatTipoSangre> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatTipoSangre e:lista) {
			ElementoCatDto d= tipoSangreToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto tipoSangreToDto(CatTipoSangre e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdTipoSangre());
		dto.setDetalle(e.getTipoSangreDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatTipoSangre dtoToTipoSangre(ElementoCatDto dto) {
		CatTipoSangre cat = new CatTipoSangre();
		cat.setIdTipoSangre(dto.getIdCatalogo());
		cat.setTipoSangreDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> tipoUsoToList(List<CatTipoUso> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatTipoUso e:lista) {
			ElementoCatDto d= tipoUsoToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto tipoUsoToDto(CatTipoUso e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdTipoUso());
		dto.setDetalle(e.getTipoUsoDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatTipoUso dtoToTipoUso(ElementoCatDto dto) {
		CatTipoUso cat = new CatTipoUso();
		cat.setIdTipoUso(dto.getIdCatalogo());
		cat.setTipoUsoDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> transporteToList(List<CatTransporte> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatTransporte e:lista) {
			ElementoCatDto d= transporteToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto transporteToDto(CatTransporte e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdTransporte());
		dto.setDetalle(e.getTransporteDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatTransporte dtoToTransporte(ElementoCatDto dto) {
		CatTransporte cat = new CatTransporte();
		cat.setIdTransporte(dto.getIdCatalogo());
		cat.setTransporteDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}

	public List<ElementoCatDto> direccionToList(List<CatDireccion> lista) {
		listaElementos= new ArrayList<ElementoCatDto>();
		for(CatDireccion e:lista) {
			ElementoCatDto d= direccionToDto(e);
			listaElementos.add(d);
		}
		return listaElementos;
	}

	private ElementoCatDto direccionToDto(CatDireccion e) {
		ElementoCatDto dto = new ElementoCatDto();
		dto.setIdCatalogo(e.getIdDireccion());
		dto.setDetalle(e.getDireccionDetalle());
		dto.setEstatus(e.getCatEstatus().getIdEstatus());
		return dto;
	}
	
	public CatDireccion dtoToDireccion(ElementoCatDto dto) {
		CatDireccion cat = new CatDireccion();
		cat.setIdDireccion(dto.getIdCatalogo());
		cat.setDireccionDetalle(dto.getDetalle());
		CatEstatus estatus = new CatEstatus();
		estatus.setIdEstatus(dto.getEstatus());
		cat.setCatEstatus(estatus);
		return cat;
	}
}
