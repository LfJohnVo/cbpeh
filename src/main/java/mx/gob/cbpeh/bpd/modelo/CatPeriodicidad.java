package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_periodicidad")
public class CatPeriodicidad  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_periodicidad")
	private Integer idPeriodicidad;

	@Column(name="periodicidad_detalle")
	private String periodicidadDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_periodicidad")
	private CatEstatus catEstatus;

	public CatPeriodicidad() {
	}

	public Integer getIdPeriodicidad() {
		return this.idPeriodicidad;
	}

	public void setIdPeriodicidad(Integer idPeriodicidad) {
		this.idPeriodicidad = idPeriodicidad;
	}

	public String getPeriodicidadDetalle() {
		return this.periodicidadDetalle;
	}

	public void setPeriodicidadDetalle(String periodicidadDetalle) {
		this.periodicidadDetalle = periodicidadDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}