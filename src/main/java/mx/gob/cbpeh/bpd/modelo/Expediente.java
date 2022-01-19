package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

//Se agrega nombre de la tabla para evitar errores case sensitiva
@Entity
@Table(name="expediente")
public class Expediente  {

	@Id	
	@Column(name="id_expediente")
	private String idExpediente;

	@Column(name="breve_resenia_hecho")
	private String breveReseniaHecho;

	@Column(name="carpeta_investigacion")
	private String carpetaInvestigacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_alta")
	private Date fechaAlta;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_apertura_expediente")
	private Date fechaAperturaExpediente;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_cierre_expediente")
	private Date fechaCierreExpediente;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_hechos")
	private Date fechaHechos;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ultima_actualizacion")
	private Date fechaUltimaActualizacion;

	@Column(name="hr_apertura_expediente")
	private Time hrAperturaExpediente;

	private String mp;

	private String observacion;

	@Column(name="resenia_localiza_justificacion")
	private String reseniaLocalizaJustificacion;

	@ManyToOne
	@JoinColumn(name="estatus_expediente")
	private CatEstatus catEstatus;

	@ManyToOne
	@JoinColumn(name="id_estus_localizado")
	private CatEstatusLocalizado catEstatusLocalizado;

	@ManyToOne
	@JoinColumn(name="id_estatus_vida")
	private CatEstatusVida catEstatusVida;

	//@ManyToOne
	//@JoinColumn(name="id_persona_desaparecida")
	@Column(name="id_persona_desaparecida")
	private Integer idPersonaDesaparecida;

	//@ManyToOne
	//@JoinColumn(name="id_persona_reporta")
	@Column(name="id_persona_reporta")
	private Integer idPersonaReporta;

	//@ManyToOne
	@Column(name="id_usuario_actualiza")
	 private String idUsuarioActualiza;

	//@ManyToOne
	@Column(name="id_usuario_alta")
	private String idUsuarioAlta;

	public Expediente() {
	}

	public String getIdExpediente() {
		return this.idExpediente;
	}

	public void setIdExpediente(String idExpediente) {
		this.idExpediente = idExpediente;
	}

	public String getBreveReseniaHecho() {
		return this.breveReseniaHecho;
	}

	public void setBreveReseniaHecho(String breveReseniaHecho) {
		this.breveReseniaHecho = breveReseniaHecho;
	}

	public String getCarpetaInvestigacion() {
		return this.carpetaInvestigacion;
	}

	public void setCarpetaInvestigacion(String carpetaInvestigacion) {
		this.carpetaInvestigacion = carpetaInvestigacion;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaAperturaExpediente() {
		return this.fechaAperturaExpediente;
	}

	public void setFechaAperturaExpediente(Date fechaAperturaExpediente) {
		this.fechaAperturaExpediente = fechaAperturaExpediente;
	}

	public Date getFechaCierreExpediente() {
		return this.fechaCierreExpediente;
	}

	public void setFechaCierreExpediente(Date fechaCierreExpediente) {
		this.fechaCierreExpediente = fechaCierreExpediente;
	}

	public Date getFechaHechos() {
		return this.fechaHechos;
	}

	public void setFechaHechos(Date fechaHechos) {
		this.fechaHechos = fechaHechos;
	}

	public Date getFechaUltimaActualizacion() {
		return this.fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public Time getHrAperturaExpediente() {
		return this.hrAperturaExpediente;
	}

	public void setHrAperturaExpediente(Time hrAperturaExpediente) {
		this.hrAperturaExpediente = hrAperturaExpediente;
	}

	public String getMp() {
		return this.mp;
	}

	public void setMp(String mp) {
		this.mp = mp;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getReseniaLocalizaJustificacion() {
		return this.reseniaLocalizaJustificacion;
	}

	public void setReseniaLocalizaJustificacion(String reseniaLocalizaJustificacion) {
		this.reseniaLocalizaJustificacion = reseniaLocalizaJustificacion;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

	public CatEstatusLocalizado getCatEstatusLocalizado() {
		return this.catEstatusLocalizado;
	}

	public void setCatEstatusLocalizado(CatEstatusLocalizado catEstatusLocalizado) {
		this.catEstatusLocalizado = catEstatusLocalizado;
	}

	public CatEstatusVida getCatEstatusVida() {
		return this.catEstatusVida;
	}

	public void setCatEstatusVida(CatEstatusVida catEstatusVida) {
		this.catEstatusVida = catEstatusVida;
	}

	public Integer getIdPersonaDesaparecida() {
		return this.idPersonaDesaparecida;
	}

	public void setIdPersonaDesaparecida(Integer personaDesaparecida) {
		this.idPersonaDesaparecida = personaDesaparecida;
	}

	public Integer getIdPersonaReporta() {
		return this.idPersonaReporta;
	}

	public void setIdPersonaReporta(Integer personaReporta) {
		this.idPersonaReporta = personaReporta;
	}

	public String getIdUsuarioActualiza() {
		return this.idUsuarioActualiza;
	}

	public void setIdUsuarioActualiza(String idUsuario) {
		this.idUsuarioActualiza = idUsuario;
	}

	public String getIdUsuarioAlta() {
		return this.idUsuarioAlta;
	}

	public void setIdUsuarioAlta(String idUsuario) {
		this.idUsuarioAlta = idUsuario;
	}

}