package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_boca")
public class CatBoca  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_boca")
	private Integer idBoca;

	@Column(name="boca_detalle")
	private String bocaDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_boca")
	private CatEstatus catEstatus;

	public CatBoca() {
	}

	public Integer getIdBoca() {
		return this.idBoca;
	}

	public void setIdBoca(Integer idBoca) {
		this.idBoca = idBoca;
	}

	public String getBocaDetalle() {
		return this.bocaDetalle;
	}

	public void setBocaDetalle(String bocaDetalle) {
		this.bocaDetalle = bocaDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}