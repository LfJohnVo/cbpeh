package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;


@Entity
@Table(name="cat_labio")
public class CatLabio  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_labio")
	private Integer idLabio;

	@Column(name="labio_detalle")
	private String labioDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_labio")
	private CatEstatus catEstatus;

	public CatLabio() {
	}

	public Integer getIdLabio() {
		return this.idLabio;
	}

	public void setIdLabio(Integer idLabio) {
		this.idLabio = idLabio;
	}

	public String getLabioDetalle() {
		return this.labioDetalle;
	}

	public void setLabioDetalle(String labioDetalle) {
		this.labioDetalle = labioDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}