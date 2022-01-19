package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_area")
public class CatArea  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_area")
	private Integer idArea;

	@Column(name="area_detalle")
	private String areaDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_area")
	private CatEstatus catEstatus;

	public CatArea() {
	}

	public Integer getIdArea() {
		return this.idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public String getAreaDetalle() {
		return this.areaDetalle;
	}

	public void setAreaDetalle(String areaDetalle) {
		this.areaDetalle = areaDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}