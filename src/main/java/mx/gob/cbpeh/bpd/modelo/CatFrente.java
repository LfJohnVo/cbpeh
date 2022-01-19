package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_frente")
public class CatFrente  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_frente")
	private Integer idFrente;

	@Column(name="frente_detalle")
	private String frenteDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_frente")
	private CatEstatus catEstatus;

	public CatFrente() {
	}

	public Integer getIdFrente() {
		return this.idFrente;
	}

	public void setIdFrente(Integer idFrente) {
		this.idFrente = idFrente;
	}

	public String getFrenteDetalle() {
		return this.frenteDetalle;
	}

	public void setFrenteDetalle(String frenteDetalle) {
		this.frenteDetalle = frenteDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}