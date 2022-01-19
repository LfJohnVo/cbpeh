package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_parentesco")
public class CatParentesco  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_parentesco")
	private Integer idParentesco;

	@Column(name="parentesco_detalle")
	private String parentescoDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_parentesco")
	private CatEstatus catEstatus;

	public CatParentesco() {
	}

	public Integer getIdParentesco() {
		return this.idParentesco;
	}

	public void setIdParentesco(Integer idParentesco) {
		this.idParentesco = idParentesco;
	}

	public String getParentescoDetalle() {
		return this.parentescoDetalle;
	}

	public void setParentescoDetalle(String parentescoDetalle) {
		this.parentescoDetalle = parentescoDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}