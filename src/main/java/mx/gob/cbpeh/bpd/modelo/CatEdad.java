package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_edad")
public class CatEdad  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_edad")
	private Integer idEdad;

	@Column(name="edad_detalle")
	private Integer edadDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_edad")
	private CatEstatus catEstatus;

	public CatEdad() {
	}

	public Integer getIdEdad() {
		return this.idEdad;
	}

	public void setIdEdad(Integer idEdad) {
		this.idEdad = idEdad;
	}

	public Integer getEdadDetalle() {
		return this.edadDetalle;
	}

	public void setEdadDetalle(Integer edadDetalle) {
		this.edadDetalle = edadDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}