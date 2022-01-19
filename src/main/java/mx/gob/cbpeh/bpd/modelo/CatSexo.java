package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_sexo")
public class CatSexo  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_sexo")
	private Integer idSexo;

	@Column(name="sexo_detalle")
	private String sexoDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_sexo")
	private CatEstatus catEstatus;

	public CatSexo() {
	}

	public Integer getIdSexo() {
		return this.idSexo;
	}

	public void setIdSexo(Integer idSexo) {
		this.idSexo = idSexo;
	}

	public String getSexoDetalle() {
		return this.sexoDetalle;
	}

	public void setSexoDetalle(String sexoDetalle) {
		this.sexoDetalle = sexoDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}