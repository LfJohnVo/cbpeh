package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_puesto")
public class CatPuesto  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_puesto")
	private Integer idPuesto;

	@Column(name="puesto_detalle")
	private String puestoDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_puesto")
	private CatEstatus catEstatus;

	public CatPuesto() {
	}

	public Integer getIdPuesto() {
		return this.idPuesto;
	}

	public void setIdPuesto(Integer idPuesto) {
		this.idPuesto = idPuesto;
	}

	public String getPuestoDetalle() {
		return this.puestoDetalle;
	}

	public void setPuestoDetalle(String puestoDetalle) {
		this.puestoDetalle = puestoDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}