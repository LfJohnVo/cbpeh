package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_tez")
public class CatTez  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tez")
	private Integer idTez;

	@Column(name="tez_detalle")
	private String tezDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_tez")
	private CatEstatus catEstatus;

	public CatTez() {
	}

	public Integer getIdTez() {
		return this.idTez;
	}

	public void setIdTez(Integer idTez) {
		this.idTez = idTez;
	}

	public String getTezDetalle() {
		return this.tezDetalle;
	}

	public void setTezDetalle(String tezDetalle) {
		this.tezDetalle = tezDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}