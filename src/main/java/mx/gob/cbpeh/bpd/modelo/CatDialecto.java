package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;


@Entity
@Table(name="cat_dialecto")
public class CatDialecto  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_dialecto")
	private Integer idDialecto;

	@Column(name="dialecto_detalle")
	private String dialectoDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_dialecto")
	private CatEstatus catEstatus;

	public CatDialecto() {
	}

	public Integer getIdDialecto() {
		return this.idDialecto;
	}

	public void setIdDialecto(Integer idDialecto) {
		this.idDialecto = idDialecto;
	}

	public String getDialectoDetalle() {
		return this.dialectoDetalle;
	}

	public void setDialectoDetalle(String dialectoDetalle) {
		this.dialectoDetalle = dialectoDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}