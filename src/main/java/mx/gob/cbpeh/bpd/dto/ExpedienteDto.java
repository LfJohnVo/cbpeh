package mx.gob.cbpeh.bpd.dto;

import java.sql.Time;
import java.util.Date;

import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.modelo.CatEstatusLocalizado;
import mx.gob.cbpeh.bpd.modelo.CatEstatusVida;
import mx.gob.cbpeh.bpd.modelo.PersonaDesaparecida;
import mx.gob.cbpeh.bpd.modelo.PersonaReporta;

public class ExpedienteDto extends CommonResponse{
	
	
	public String idExpediente;	
	public String breveReseniaHecho;	
	public String carpetaInvestigacion;	
	public Date fechaAlta;	
	public Date fechaAperturaExpediente;	
	public Date fechaCierreExpediente;	
	public Date fechaHechos;	
	public Date fechaUltimaActualizacion;	
	public Time hrAperturaExpediente;
	public String mp;
	public String observacion;
	public String reseniaLocalizaJustificacion;	
	public CatEstatus catEstatus;
	public CatEstatusLocalizado catEstatusLocalizado;	
	public CatEstatusVida catEstatusVida;	
	public PersonaDesaparecida personaDesaparecida;
	public PersonaReporta personaReporta;	
	public String idUsuarioActualiza;	
	public String idUsuarioAlta;	
	
	public ExpedienteDto() {
		// TODO Auto-generated constructor stub
		
		  catEstatus = new CatEstatus();
		  catEstatusLocalizado = new CatEstatusLocalizado();	
		  catEstatusVida = new CatEstatusVida();	
		  personaDesaparecida = new PersonaDesaparecida();
		  personaReporta = new PersonaReporta();	
	}
	
	
	public String getIdExpediente() {
		return idExpediente;
	}

	public void setIdExpediente(String idExpediente) {
		this.idExpediente = idExpediente;
	}

	public String getBreveReseniaHecho() {
		return breveReseniaHecho;
	}

	public void setBreveReseniaHecho(String breveReseniaHecho) {
		this.breveReseniaHecho = breveReseniaHecho;
	}

	public String getCarpetaInvestigacion() {
		return carpetaInvestigacion;
	}

	public void setCarpetaInvestigacion(String carpetaInvestigacion) {
		this.carpetaInvestigacion = carpetaInvestigacion;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaAperturaExpediente() {
		return fechaAperturaExpediente;
	}

	public void setFechaAperturaExpediente(Date fechaAperturaExpediente) {
		this.fechaAperturaExpediente = fechaAperturaExpediente;
	}

	public Date getFechaCierreExpediente() {
		return fechaCierreExpediente;
	}

	public void setFechaCierreExpediente(Date fechaCierreExpediente) {
		this.fechaCierreExpediente = fechaCierreExpediente;
	}

	public Date getFechaHechos() {
		return fechaHechos;
	}

	public void setFechaHechos(Date fechaHechos) {
		this.fechaHechos = fechaHechos;
	}

	public Date getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public Time getHrAperturaExpediente() {
		return hrAperturaExpediente;
	}

	public void setHrAperturaExpediente(Time hrAperturaExpediente) {
		this.hrAperturaExpediente = hrAperturaExpediente;
	}

	public String getMp() {
		return mp;
	}

	public void setMp(String mp) {
		this.mp = mp;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getReseniaLocalizaJustificacion() {
		return reseniaLocalizaJustificacion;
	}

	public void setReseniaLocalizaJustificacion(String reseniaLocalizaJustificacion) {
		this.reseniaLocalizaJustificacion = reseniaLocalizaJustificacion;
	}

	public CatEstatus getCatEstatus() {
		return catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

	public CatEstatusLocalizado getCatEstatusLocalizado() {
		return catEstatusLocalizado;
	}

	public void setCatEstatusLocalizado(CatEstatusLocalizado catEstatusLocalizado) {
		this.catEstatusLocalizado = catEstatusLocalizado;
	}

	public CatEstatusVida getCatEstatusVida() {
		return catEstatusVida;
	}

	public void setCatEstatusVida(CatEstatusVida catEstatusVida) {
		this.catEstatusVida = catEstatusVida;
	}

	public PersonaDesaparecida getPersonaDesaparecida() {
		return personaDesaparecida;
	}

	public void setPersonaDesaparecida(PersonaDesaparecida personaDesaparecida) {
		this.personaDesaparecida = personaDesaparecida;
	}

	public PersonaReporta getPersonaReporta() {
		return personaReporta;
	}

	public void setPersonaReporta(PersonaReporta idPersonaReporta) {
		this.personaReporta = idPersonaReporta;
	}

	public String getIdUsuarioActualiza() {
		return idUsuarioActualiza;
	}

	public void setIdUsuarioActualiza(String idUsuarioActualiza) {
		this.idUsuarioActualiza = idUsuarioActualiza;
	}

	public String getIdUsuarioAlta() {
		return idUsuarioAlta;
	}

	public void setIdUsuarioAlta(String idUsuarioAlta) {
		this.idUsuarioAlta = idUsuarioAlta;
	}

	
	
}
