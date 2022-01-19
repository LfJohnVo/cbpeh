package mx.gob.cbpeh.bpd.dto;

import java.io.Serializable;
import java.math.BigInteger;

public class RegistroDiarioDto implements Serializable{

	private static final long serialVersionUID = -530032632046769943L;
	
	private String idExpediente;
	private String personaDesaparecida;
	private BigInteger numeroAcciones;
	private String estatus;
	
	public RegistroDiarioDto() {
		
	}
	public RegistroDiarioDto(String idExpediente, String nombre,String apaterno,String amaterno,BigInteger numeroAcciones, String estatus) {
		super();
		this.idExpediente = idExpediente;
		this.personaDesaparecida = ((nombre!=null)?nombre:"")+" "+((apaterno!=null)?apaterno:"")+" "+((amaterno!=null)?amaterno:"");
		this.numeroAcciones = numeroAcciones;
		this.estatus = estatus;
	}
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
	public BigInteger getNumeroAcciones() {
		return numeroAcciones;
	}
	public void setNumeroAcciones(BigInteger numeroAcciones) {
		this.numeroAcciones = numeroAcciones;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
		
}
