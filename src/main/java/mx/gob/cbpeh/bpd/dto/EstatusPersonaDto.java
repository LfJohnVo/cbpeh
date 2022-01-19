package mx.gob.cbpeh.bpd.dto;

import java.util.List;
import mx.gob.cbpeh.bpd.modelo.ArchivoExpediente;
import mx.gob.cbpeh.bpd.modelo.Busqueda;
import mx.gob.cbpeh.bpd.modelo.Expediente;
import mx.gob.cbpeh.bpd.modelo.PersonaEntrevista;

public class EstatusPersonaDto {
	
	//private ReportanteLecturaDto personaReportante;
	private Expediente expediente;
	private ConsultaReporteResultados personaReporta;
	private ConsultaDesaparecidoResultados personaDesaparecida;	
	private AnidadosDto anidadosDto;
	private List<ArchivoExpediente> archivoExpediente;
	private PersonaEntrevista personaEntrevista;
	private List<BusquedaDireccionDTO> accionBusqueda;
	private ArchivosHvaDto archivoFotoPersona;
	
	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public ConsultaReporteResultados getPersonaReporta() {
		return personaReporta;
	}

	public void setPersonaReporta(ConsultaReporteResultados personaReporta) {
		this.personaReporta = personaReporta;
	}

	public ConsultaDesaparecidoResultados getPersonaDesaparecida() {
		return personaDesaparecida;
	}

	public void setPersonaDesaparecida(ConsultaDesaparecidoResultados personaDesaparecida) {
		this.personaDesaparecida = personaDesaparecida;
	}

	public AnidadosDto getAnidadosDto() {
		return anidadosDto;
	}

	public void setAnidadosDto(AnidadosDto anidadosDto) {
		this.anidadosDto = anidadosDto;
	}

	public List<ArchivoExpediente> getArchivoExpediente() {
		return archivoExpediente;
	}

	public void setArchivoExpediente(List<ArchivoExpediente> archivoExpediente) {
		this.archivoExpediente = archivoExpediente;
	}

	public PersonaEntrevista getPersonaEntrevista() {
		return personaEntrevista;
	}

	public void setPersonaEntrevista(PersonaEntrevista personaEntrevista) {
		this.personaEntrevista = personaEntrevista;
	}

	public List<BusquedaDireccionDTO> getAccionBusqueda() {
		return accionBusqueda;
	}

	public void setAccionBusqueda(List<BusquedaDireccionDTO> accionBusqueda) {
		this.accionBusqueda = accionBusqueda;
	}

	public ArchivosHvaDto getArchivoFotoPersona() {
		return archivoFotoPersona;
	}

	public void setArchivoFotoPersona(ArchivosHvaDto archivoFotoPersona) {
		this.archivoFotoPersona = archivoFotoPersona;
	}
	
}
