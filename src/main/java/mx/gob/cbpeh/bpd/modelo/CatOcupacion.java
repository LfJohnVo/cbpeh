package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_ocupacion")
public class CatOcupacion  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ocupacion")
	private Integer idOcupacion;

	@Column(name="ocupacion_detalle")
	private String ocupacionDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_ocupacion")
	private CatEstatus catEstatus;

	public CatOcupacion() {
	}

	public Integer getIdOcupacion() {
		return this.idOcupacion;
	}

	public void setIdOcupacion(Integer idOcupacion) {
		this.idOcupacion = idOcupacion;
	}

	public String getOcucpacionDetalle() {
		return this.ocupacionDetalle;
	}

	public void setOcucpacionDetalle(String ocucpacionDetalle) {
		this.ocupacionDetalle = ocucpacionDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}