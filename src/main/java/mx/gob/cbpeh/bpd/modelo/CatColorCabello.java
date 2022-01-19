package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;


@Entity
@Table(name="cat_color_cabello")
public class CatColorCabello  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_color_cabello")
	private Integer idColorCabello;

	@Column(name="color_cabello_detalle")
	private String colorCabelloDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_color_cabello")
	private CatEstatus catEstatus;

	public CatColorCabello() {
	}

	public Integer getIdColorCabello() {
		return this.idColorCabello;
	}

	public void setIdColorCabello(Integer idColorCabello) {
		this.idColorCabello = idColorCabello;
	}

	public String getColorCabelloDetalle() {
		return this.colorCabelloDetalle;
	}

	public void setColorCabelloDetalle(String colorCabelloDetalle) {
		this.colorCabelloDetalle = colorCabelloDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}