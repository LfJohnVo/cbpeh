package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="persona_vinculada")
public class PersonaVinculada  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_persona_vinculada")
	private int idPersonaVinculada;

	private String amaterno;

	private String apaterno;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualiza")
	private Date fechaActualiza;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_alta")
	private Date fechaAlta;

	private String nombre;

	@ManyToOne
	@JoinColumn(name="estatus_persona_vinculada")
	private CatEstatus catEstatus;

	@ManyToOne
	@JoinColumn(name="id_parentesco")
	private CatParentesco catParentesco;

	@ManyToOne
	@JoinColumn(name="id_expediente")
	private Expediente expediente;

	@ManyToOne
	@JoinColumn(name="id_usuario_actualiza")
	private Usuario usuario1;

	@ManyToOne
	@JoinColumn(name="id_usuario_alta")
	private Usuario usuario2;

	public PersonaVinculada() {
	}

	public int getIdPersonaVinculada() {
		return this.idPersonaVinculada;
	}

	public void setIdPersonaVinculada(int idPersonaVinculada) {
		this.idPersonaVinculada = idPersonaVinculada;
	}

	public String getAmaterno() {
		return this.amaterno;
	}

	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}

	public String getApaterno() {
		return this.apaterno;
	}

	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

	public CatParentesco getCatParentesco() {
		return this.catParentesco;
	}

	public void setCatParentesco(CatParentesco catParentesco) {
		this.catParentesco = catParentesco;
	}

	public Expediente getExpediente() {
		return this.expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
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