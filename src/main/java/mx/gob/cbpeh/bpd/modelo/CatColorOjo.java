package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;


@Entity
@Table(name="cat_color_ojo")
public class CatColorOjo  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_color_ojo")
	private Integer idColorOjo;

	@Column(name="color_ojo_detalle")
	private String colorOjoDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_color_ojo")
	private CatEstatus catEstatus;

	public CatColorOjo() {
	}

	public Integer getIdColorOjo() {
		return this.idColorOjo;
	}

	public void setIdColorOjo(Integer idColorOjo) {
		this.idColorOjo = idColorOjo;
	}

	public String getColorOjoDetalle() {
		return this.colorOjoDetalle;
	}

	public void setColorOjoDetalle(String colorOjoDetalle) {
		this.colorOjoDetalle = colorOjoDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}