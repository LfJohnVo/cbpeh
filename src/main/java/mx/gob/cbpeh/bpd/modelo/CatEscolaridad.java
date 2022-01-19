package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_escolaridad")
public class CatEscolaridad  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_escolaridad")
	private Integer idEscolaridad;

	@Column(name="escolaridad_detalle")
	private String escolaridadDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_escolaridad")
	private CatEstatus catEstatus;

	public CatEscolaridad() {
	}

	public Integer getIdEscolaridad() {
		return this.idEscolaridad;
	}

	public void setIdEscolaridad(Integer idEscolaridad) {
		this.idEscolaridad = idEscolaridad;
	}

	public String getEscolaridadDetalle() {
		return this.escolaridadDetalle;
	}

	public void setEscolaridadDetalle(String escolaridadDetalle) {
		this.escolaridadDetalle = escolaridadDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}