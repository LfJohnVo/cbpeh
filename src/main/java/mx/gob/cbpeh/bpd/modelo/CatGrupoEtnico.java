package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_grupo_etnico")
public class CatGrupoEtnico  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_grupo_etnico")
	private Integer idGrupoEtnico;

	@Column(name="grupo_etnico_detalle")
	private String grupoEtnicoDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_grupo_etnico")
	private CatEstatus catEstatus;
	
	public CatGrupoEtnico() {
	}

	public Integer getIdGrupoEtnico() {
		return this.idGrupoEtnico;
	}

	public void setIdGrupoEtnico(Integer idGrupoEtnico) {
		this.idGrupoEtnico = idGrupoEtnico;
	}

	public String getGrupoEtnicoDetalle() {
		return this.grupoEtnicoDetalle;
	}

	public void setGrupoEtnicoDetalle(String grupoEtnicoDetalle) {
		this.grupoEtnicoDetalle = grupoEtnicoDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}