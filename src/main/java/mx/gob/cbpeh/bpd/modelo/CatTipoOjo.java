package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_tipo_ojo")
public class CatTipoOjo  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_ojo")
	private Integer idTipoOjo;

	@Column(name="tipo_ojo_detalle")
	private String tipoOjoDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_tipo_ojo")
	private CatEstatus catEstatus;

	public CatTipoOjo() {
	}

	public Integer getIdTipoOjo() {
		return this.idTipoOjo;
	}

	public void setIdTipoOjo(Integer idTipoOjo) {
		this.idTipoOjo = idTipoOjo;
	}

	public String getTipoOjoDetalle() {
		return this.tipoOjoDetalle;
	}

	public void setTipoOjoDetalle(String tipoOjoDetalle) {
		this.tipoOjoDetalle = tipoOjoDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}