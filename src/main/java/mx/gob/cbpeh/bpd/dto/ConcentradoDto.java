package mx.gob.cbpeh.bpd.dto;

import java.io.Serializable;
import java.util.Date;

public class ConcentradoDto implements Serializable{

	private static final long serialVersionUID = -530032632046769943L;
	
	private String idExpediente;
	private String personaDesaparecida;
	private String fechaApertura;
	private String fechaCierre;
	private String sexo;
	private String municipio;
	private String estatus;
	
	public ConcentradoDto(String idExpediente, String nombre,String apaterno,String amaterno, String fechaApertura,
			String sexo, String municipio, String estatus) {
		super();
		this.idExpediente = idExpediente;
		this.personaDesaparecida = ((nombre!=null)?nombre:"")+" "+((apaterno!=null)?apaterno:"")+" "+((amaterno!=null)?amaterno:"");
		this.fechaApertura = fechaApertura;
		this.sexo = sexo;
		this.municipio = municipio;
		this.estatus = estatus;
	}
	
	public ConcentradoDto() {}

	public String getIdExpediente() {
		return idExpediente;
	}

	public void setIdExpediente(String idExpediente) {
		this.idExpediente = idExpediente;
	}

	public String getPersonaDesaparecida() {
		return personaDesaparecida;
	}

	public void setPersonaDesaparecida(String personaDesaparecida) {
		this.personaDesaparecida = personaDesaparecida;
	}

	public String getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public String getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(String fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
}
