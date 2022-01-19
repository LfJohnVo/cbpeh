package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_forma_nariz")
public class CatFormaNariz  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_forma_nariz")
	private Integer idFormaNariz;

	@Column(name="forma_nariz_detalle")
	private String formaNarizDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_forma_nariz")
	private CatEstatus catEstatus;

	public CatFormaNariz() {
	}

	public Integer getIdFormaNariz() {
		return this.idFormaNariz;
	}

	public void setIdFormaNariz(Integer idFormaNariz) {
		this.idFormaNariz = idFormaNariz;
	}

	public String getFormaNarizDetalle() {
		return this.formaNarizDetalle;
	}

	public void setFormaNarizDetalle(String formaNarizDetalle) {
		this.formaNarizDetalle = formaNarizDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}