package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;


@Entity
@Table(name="cat_base_nariz")
public class CatBaseNariz  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_base_nariz")
	private Integer idBaseNariz;

	@Column(name="base_nariz_detalle")
	private String baseNarizDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_base_nariz")
	private CatEstatus catEstatus;

	public CatBaseNariz() {
	}

	public Integer getIdBaseNariz() {
		return this.idBaseNariz;
	}

	public void setIdBaseNariz(Integer idBaseNariz) {
		this.idBaseNariz = idBaseNariz;
	}

	public String getBaseNarizDetalle() {
		return this.baseNarizDetalle;
	}

	public void setBaseNarizDetalle(String baseNarizDetalle) {
		this.baseNarizDetalle = baseNarizDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}