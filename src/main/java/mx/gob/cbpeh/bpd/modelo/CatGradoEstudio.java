package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_grado_estudio")
public class CatGradoEstudio  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_grado_estudio")
	private Integer idGradoEstudio;

	@Column(name="grado_estudio_detalle")
	private String gradoEstudioDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_grado_estudio")
	private CatEstatus catEstatus;

	public CatGradoEstudio() {
	}

	public Integer getIdGradoEstudio() {
		return this.idGradoEstudio;
	}

	public void setIdGradoEstudio(Integer idGradoEstudio) {
		this.idGradoEstudio = idGradoEstudio;
	}

	public String getGradoEstudioDetalle() {
		return this.gradoEstudioDetalle;
	}

	public void setGradoEstudioDetalle(String gradoEstudioDetalle) {
		this.gradoEstudioDetalle = gradoEstudioDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}