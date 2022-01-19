package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_dentadura")
public class CatDentadura  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_dentadura")
	private Integer idDentadura;

	@Column(name="dentadura_detalle")
	private String dentaduraDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_dentadura")
	private CatEstatus catEstatus;

	public CatDentadura() {
	}

	public Integer getIdDentadura() {
		return this.idDentadura;
	}

	public void setIdDentadura(Integer idDentadura) {
		this.idDentadura = idDentadura;
	}

	public String getDentaduraDetalle() {
		return this.dentaduraDetalle;
	}

	public void setDentaduraDetalle(String dentaduraDetalle) {
		this.dentaduraDetalle = dentaduraDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}