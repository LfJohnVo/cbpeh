package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_genero")
public class CatGenero  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_genero")
	private Integer idGenero;

	@Column(name="genero_detalle")
	private String generoDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_genero")
	private CatEstatus catEstatus;

	public CatGenero() {
	}

	public Integer getIdGenero() {
		return this.idGenero;
	}

	public void setIdGenero(Integer idGenero) {
		this.idGenero = idGenero;
	}

	public String getGeneroDetalle() {
		return this.generoDetalle;
	}

	public void setGeneroDetalle(String generoDetalle) {
		this.generoDetalle = generoDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}