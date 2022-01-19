package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="vinculo_telefono")
public class VinculoTelefono  { 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vinculo_telefono")
	private int idVinculoTelefono;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualiza")
	private Date fechaActualiza;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_alta")
	private Date fechaAlta;

	private Long telefono;

	@ManyToOne
	@JoinColumn(name="id_compania_telefono")
	private CatCompaniaTelefono catCompaniaTelefono;

	@ManyToOne
	@JoinColumn(name="estatus_vinculo_telefono")
	private CatEstatus catEstatus;

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

	public VinculoTelefono() {
	}

	public int getIdVinculoTelefono() {
		return this.idVinculoTelefono;
	}

	public void setIdVinculoTelefono(int idVinculoTelefono) {
		this.idVinculoTelefono = idVinculoTelefono;
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

	public Long getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public CatCompaniaTelefono getCatCompaniaTelefono() {
		return this.catCompaniaTelefono;
	}

	public void setCatCompaniaTelefono(CatCompaniaTelefono catCompaniaTelefono) {
		this.catCompaniaTelefono = catCompaniaTelefono;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
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