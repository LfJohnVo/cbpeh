package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="expediente_incompetencia")
public class ExpedienteIncompetencia  {

	@Id
	@Column(name="id_expediente_incompetencia")
	private String idExpedienteIncompetencia;

	@Column(name="estatus_resenia")
	private String estatusResenia;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_alta")
	private Date fechaAlta;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_cierre")
	private Date fechaCierre;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_hechos")
	private Date fechaHechos;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_reporte")
	private Date fechaReporte;

	@ManyToOne
	@JoinColumn(name="estatus_expediente_incompetencia")
	private CatEstatus catEstatus;

	@ManyToOne
	@JoinColumn(name="id_persona_incompetencia")
	private PersonaIncompetencia personaIncompetencia;

	@ManyToOne
	@JoinColumn(name="id_usuario_alta")
	private Usuario usuario;

	public ExpedienteIncompetencia() {
	}

	public String getIdExpedienteIncompetencia() {
		return this.idExpedienteIncompetencia;
	}

	public void setIdExpedienteIncompetencia(String idExpedienteIncompetencia) {
		this.idExpedienteIncompetencia = idExpedienteIncompetencia;
	}

	public String getEstatusResenia() {
		return this.estatusResenia;
	}

	public void setEstatusResenia(String estatusResenia) {
		this.estatusResenia = estatusResenia;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaCierre() {
		return this.fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Date getFechaHechos() {
		return this.fechaHechos;
	}

	public void setFechaHechos(Date fechaHechos) {
		this.fechaHechos = fechaHechos;
	}

	public Date getFechaReporte() {
		return this.fechaReporte;
	}

	public void setFechaReporte(Date fechaReporte) {
		this.fechaReporte = fechaReporte;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

	public PersonaIncompetencia getPersonaIncompetencia() {
		return this.personaIncompetencia;
	}

	public void setPersonaIncompetencia(PersonaIncompetencia personaIncompetencia) {
		this.personaIncompetencia = personaIncompetencia;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}