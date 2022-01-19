package mx.gob.cbpeh.bpd.servicio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.cbpeh.bpd.dto.AnidadosDto;
import mx.gob.cbpeh.bpd.dto.ArchivosHvaDto;
import mx.gob.cbpeh.bpd.dto.BusquedaDireccionDTO;
import mx.gob.cbpeh.bpd.dto.ConsultaArchivoDto;
import mx.gob.cbpeh.bpd.dto.ConsultaArchivosDto;
import mx.gob.cbpeh.bpd.dto.ConsultaDesaparecidoDto;
import mx.gob.cbpeh.bpd.dto.ConsultaDesaparecidoResultados;
import mx.gob.cbpeh.bpd.dto.ConsultaReporteDto;
import mx.gob.cbpeh.bpd.dto.ConsultaReporteResultados;
import mx.gob.cbpeh.bpd.dto.EstatusPersonaDto;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.ArchivoExpediente;
import mx.gob.cbpeh.bpd.modelo.Busqueda;
import mx.gob.cbpeh.bpd.modelo.CatColonia;
import mx.gob.cbpeh.bpd.modelo.CatCp;
import mx.gob.cbpeh.bpd.modelo.CatEstatusLocalizado;
import mx.gob.cbpeh.bpd.modelo.CatMunicipio;
import mx.gob.cbpeh.bpd.modelo.PersonaEntrevista;

@Service
public class EstatusPersonaServicioImpl implements EstatusPersonaServicio {

	private static final Logger log = LoggerFactory.getLogger(EstatusPersonaServicioImpl.class);
	
	@Autowired
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	private ExpedienteServicio expedienteServicio;
	@Autowired 
	private CatMunicipioServicio catMunicipioServicio;
	@Autowired
	private CatCpServicio catCpServicio;
	@Autowired
	private CatColoniaServicio catColoniaServicio;
	@Autowired
	private ArchivoExpedienteServicio archivoExpedienteServicio;
	@Autowired
	private PersonaEntrevistaServicio personaEntrevistaServicio;
	@Autowired
	private BusquedaServicio busquedaServicio;
	@Autowired
	CatEstatusLocalizadoServicio catEstatusLocalizadoServicio;
	
	@Override
	public EstatusPersonaDto consultarEstatus(String idExpediente) {
		EstatusPersonaDto estatusPersona=new EstatusPersonaDto();
		//Expediente expediente = null;
		ConsultaReporteResultados personaReporta = null;
		ConsultaDesaparecidoResultados personaDesaparecida= null;
		List<ArchivoExpediente> archivosExpediente=null;
		PersonaEntrevista personaEntrevista =null;
		List<BusquedaDireccionDTO> accionesBusqueda=null;
		ArchivosHvaDto archivoFotoPersonaDesa=null;
		
		try {
			// paso 1 consegui el expediente
			if(idExpediente != null && !idExpediente.equals("")) {
				 //expediente =expedienteServicio.getExpediente(idExpediente);				
			}
			// se retira busqueda por curp
			/*else if(curp !=null && !curp.equals("")) {
				personaDesaparecida =personaDesaparecidaServicio.getPersonaDesaparecidaCurp(curp);
				if(personaDesaparecida != null && personaDesaparecida.getIdPersonaDesaparecida() >0) {
					expediente =expedienteServicio.getExpedienteIdPersonaDesaparecida(personaDesaparecida.getIdPersonaDesaparecida());
				}
			}*/
			
			// paso 2 llenar la info de WS has visto ah,reportante, desaparecido, evidencias, acta entrevista
			if(idExpediente != null) {
				
				try {
					ConsultaReporteDto reportanteHva=expedienteServicio.getConsultaReporte(idExpediente);
					if(reportanteHva != null && reportanteHva.getResultados().size()!=0 ){
						personaReporta = reportanteHva.getResultados().get(0);
					}
				}catch(Exception e) {
				 log.info("Ocurrio un inconveniente al consumir ws has visto ah: "+e.getMessage());
				}
				
				try {
					ConsultaDesaparecidoDto desaparecidoHva=expedienteServicio.getConsultaDesaparecido(idExpediente);
					if(desaparecidoHva != null && desaparecidoHva.getResultados().size()!=0 ){
						personaDesaparecida = desaparecidoHva.getResultados().get(0);
					}
				}catch(Exception e) {
				 log.info("Ocurrio un inconveniente al consumir ws has visto ah: "+e.getMessage());
				}
					
				archivosExpediente= archivoExpedienteServicio.getArchivosExpediente(idExpediente );				
				personaEntrevista = personaEntrevistaServicio.getPersonaEntrevistaBy(idExpediente, 1);
				accionesBusqueda= convertBusqueda(busquedaServicio.getBusquedas(idExpediente));
				
				ConsultaArchivosDto resArchivos=expedienteServicio.getArchivos(idExpediente);
				if(resArchivos.getResultados() != null && !resArchivos.getEstatus().contains("Sin")) {
					for(ArchivosHvaDto file:resArchivos.getResultados()) {
						if(file.getNombre().contains("Foto Persona")) {
							ConsultaArchivoDto archivoFoto=expedienteServicio.getArchivo(idExpediente, file.getId().toString(), file.getTipo().toString());
							if(archivoFoto.getResultados() != null & archivoFoto.getResultados()!=null && archivoFoto.getResultados().size()>0) {
								file.setArchivo(archivoFoto.getResultados().get(0).getArchivo());
								archivoFotoPersonaDesa=file;
								break;
							}
						}
						
					}
					
				}else {
					
				}
			}
			
			//3 settear info
		//estatusPersona.setExpediente(expediente);
			estatusPersona.setPersonaReporta(personaReporta);
			estatusPersona.setPersonaDesaparecida(personaDesaparecida);
			estatusPersona.setArchivoExpediente(archivosExpediente);
			estatusPersona.setPersonaEntrevista(personaEntrevista);
			estatusPersona.setAccionBusqueda(accionesBusqueda);
			estatusPersona.setArchivoFotoPersona(archivoFotoPersonaDesa);
			
			//4 llenar combosAnidados
			AnidadosDto anidadosDto = new AnidadosDto();
			if(personaReporta.getCodigo_estado()!= null) {
				anidadosDto.setMunicipiosRepo( catMunicipioServicio.getCatMunicipiosPorEstado(personaReporta.getCodigo_estado() ) );				
			}
			if(personaReporta.getCodigo_municipio()!= null) {
				anidadosDto.setCpsRepo( catCpServicio.getCatCpPorEstadoMunicipio(personaReporta.getCodigo_estado(),personaReporta.getCodigo_municipio() ));
			}
			/*if(personaReporta.getCatColonia()!= null) {
				anidadosDto.setColoniasRepo( catColoniaServicio.getCatColoniasPorCp(personaReporta.getCatColonia().getCodigoCp() ) );
			}*/
			
			if(personaDesaparecida.getCodigo_estado()!= null) {
				anidadosDto.setMunicipiosDesa( catMunicipioServicio.getCatMunicipiosPorEstado(personaDesaparecida.getCodigo_estado() ) );				
			}
			if(personaDesaparecida.getCodigo_municipio()!= null) {
				anidadosDto.setCpsDesa( catCpServicio.getCatCpPorEstadoMunicipio(personaDesaparecida.getCodigo_estado(),personaReporta.getCodigo_municipio() ));
			}
			/*if(personaDesaparecida.getCatColonia()!= null) {
				anidadosDto.setColoniasDesa( catColoniaServicio.getCatColoniasPorCp(personaDesaparecida.getCatColonia().getCodigoCp() ) );
			} */
			
			
			if(null != personaEntrevista && personaEntrevista.getCatMunicipio()!= null) {
				anidadosDto.setMunicipiosActa( catMunicipioServicio.getCatMunicipiosPorEstado(personaEntrevista.getCatEstado().getCodigoEstado()+""));
			}
			if(null != personaEntrevista && personaEntrevista.getCatCp()!= null) {
				anidadosDto.setCpsActa( catCpServicio.getCatCpPorEstadoMunicipio(personaEntrevista.getCatMunicipio().getCodigoEstado(),personaEntrevista.getCatMunicipio().getCodigoMunicipio()) );
			}
			if(null != personaEntrevista && personaEntrevista.getCatColonia() != null) {
				anidadosDto.setColoniasActa( catColoniaServicio.getCatColoniasPorCp(personaEntrevista.getCatColonia().getCodigoCp() ) );
			}
			estatusPersona.setAnidadosDto(anidadosDto);
			
		}catch(Exception e) {
			log.info("Ocurrio un inconveniente al consultar estatus persona desaparecida");			
		}
		return estatusPersona;
	}
	
	public List<BusquedaDireccionDTO> convertBusqueda(List<Busqueda> entrada) throws ResourceNotFoundException{
		List<BusquedaDireccionDTO> busqueda= new ArrayList<BusquedaDireccionDTO>();
		for(Busqueda e:entrada) {
			BusquedaDireccionDTO busq=new BusquedaDireccionDTO();
			busq.setIdBusqueda(e.getIdBusqueda());
			busq.setCalle(e.getCalle());
			busq.setFechaActualiza(e.getFechaActualiza());
			busq.setFechaAlta(e.getFechaAlta());
			busq.setFechaBusqueda( (null != e.getFechaBusqueda() )?e.getFechaBusqueda().toString():"");
			busq.setLatitud(e.getLatitud());
			busq.setLongitud(e.getLongitud());
			busq.setResenia(e.getResenia());
			CatColonia colonia = null;
			colonia=(e.getIdColonia()!=null)?catColoniaServicio.getCatColonia(e.getIdColonia()).get():null;
			busq.setColonia(colonia);
			CatCp cp= null;
			cp=(e.getIdCp() !=null)?catCpServicio.getCatCp(e.getIdCp()).get():null;
			busq.setCp(cp);
			CatEstatusLocalizado estatus =null;
			estatus=(e.getIdEstatus()!=null)? catEstatusLocalizadoServicio.getCatEstatusLocalizado(e.getIdEstatus()): null;
			busq.setEstatusLocalizado(estatus);
			busq.setIdEstatusLocalizado(e.getIdEstatusLocalizado());
			busq.setIdEstatusVida(e.getIdEstatusVida());
			CatMunicipio municipio =null;
			municipio=(e.getIdMunicipio()!=null)?catMunicipioServicio.getCatMunicipio(e.getIdMunicipio()).get(): null;
			busq.setMunicipio(municipio);
			busq.setExpediente(e.getExpediente());
			busq.setUsuarioActualiza(e.getUsuarioActualiza());
			busq.setUsuarioAlta(e.getUsuarioAlta());	
			
			busqueda.add(busq);
		}		
		return busqueda;
	}

}
