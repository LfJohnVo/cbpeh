package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_idioma")
public class CatIdioma  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_idioma")
	private Integer idIdioma;

	@Column(name="idioma_detalle")
	private String idiomaDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_idioma")
	private CatEstatus catEstatus;

	public CatIdioma() {
	}

	public Integer getIdIdioma() {
		return this.idIdioma;
	}

	public void setIdIdioma(Integer idIdioma) {
		this.idIdioma = idIdioma;
	}

	public String getIdiomaDetalle() {
		return this.idiomaDetalle;
	}

	public void setIdiomaDetalle(String idiomaDetalle) {
		this.idiomaDetalle = idiomaDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}