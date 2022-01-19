package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_medio_contacto")
public class CatMedioContacto  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_medio_contacto")
	private Integer idMedioContacto;

	@Column(name="medio_contacto_detalle")
	private String medioContactoDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_medio_contato")
	private CatEstatus catEstatus;

	public CatMedioContacto() {
	}

	public Integer getIdMedioContacto() {
		return this.idMedioContacto;
	}

	public void setIdMedioContacto(Integer idMedioContacto) {
		this.idMedioContacto = idMedioContacto;
	}

	public String getMedioContactoDetalle() {
		return this.medioContactoDetalle;
	}

	public void setMedioContactoDetalle(String medioContactoDetalle) {
		this.medioContactoDetalle = medioContactoDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}