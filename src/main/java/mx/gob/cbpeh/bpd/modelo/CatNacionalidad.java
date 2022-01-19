package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_nacionalidad")
public class CatNacionalidad  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_nacionalidad")
	private int idNacionalidad;

	@Column(name="nacionalidad_detalle")
	private String nacionalidadDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_nacionalidad")
	private CatEstatus catEstatus;

	public CatNacionalidad() {
	}

	public int getIdNacionalidad() {
		return this.idNacionalidad;
	}

	public void setIdNacionalidad(int idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}

	public String getNacionalidadDetalle() {
		return this.nacionalidadDetalle;
	}

	public void setNacionalidadDetalle(String nacionalidadDetalle) {
		this.nacionalidadDetalle = nacionalidadDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}