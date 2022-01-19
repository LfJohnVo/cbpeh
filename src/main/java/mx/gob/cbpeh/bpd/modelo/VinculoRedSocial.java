package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="vinculo_red_social")
public class VinculoRedSocial  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vinculo_red_social")
	private int idVinculoRedSocial;

	@Column(name="dato_red_social")
	private String datoRedSocial;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualiza")
	private Date fechaActualiza;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_alta")
	private Date fechaAlta;

	@ManyToOne
	@JoinColumn(name="estatus_viculo_red_social")
	private CatEstatus catEstatus;

	@ManyToOne
	@JoinColumn(name="id_red_social")
	private CatRedSocial catRedSocial;

	@ManyToOne
	@JoinColumn(name="id_tipo_uso")
	private CatTipoUso catTipoUso;

	@ManyToOne
	@JoinColumn(name="id_persona_vinculada")
	private PersonaVinculada personaVinculada;

	@ManyToOne
	@JoinColumn(name="id_usuario_actualiza")
	private Usuario usuario1;

	@ManyToOne
	@JoinColumn(name="id_usuario_alta")
	private Usuario usuario2;

	public VinculoRedSocial() {
	}

	public int getIdVinculoRedSocial() {
		return this.idVinculoRedSocial;
	}

	public void setIdVinculoRedSocial(int idVinculoRedSocial) {
		this.idVinculoRedSocial = idVinculoRedSocial;
	}

	public String getDatoRedSocial() {
		return this.datoRedSocial;
	}

	public void setDatoRedSocial(String datoRedSocial) {
		this.datoRedSocial = datoRedSocial;
	}

	public Date getFechaActualiza() {
		return this.fechaActualiza;
	}

	public void setFechaActualiza(Date fechaActualiza) {
		this.fechaActualiza = fechaActualiza;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

	public CatRedSocial getCatRedSocial() {
		return this.catRedSocial;
	}

	public void setCatRedSocial(CatRedSocial catRedSocial) {
		this.catRedSocial = catRedSocial;
	}

	public CatTipoUso getCatTipoUso() {
		return this.catTipoUso;
	}

	public void setCatTipoUso(CatTipoUso catTipoUso) {
		this.catTipoUso = catTipoUso;
	}

	public PersonaVinculada getPersonaVinculada() {
		return this.personaVinculada;
	}

	public void setPersonaVinculada(PersonaVinculada personaVinculada) {
		this.personaVinculada = personaVinculada;
	}

	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

}