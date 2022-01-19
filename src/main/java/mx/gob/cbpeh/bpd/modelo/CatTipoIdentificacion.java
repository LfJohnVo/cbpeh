package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_tipo_identificacion")
public class CatTipoIdentificacion  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_identificacion")
	private Integer idTipoIdentificacion;

	@Column(name="tipo_identificacion_detalle")
	private String tipoIdentificacionDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_tipo_identificacion")
	private CatEstatus catEstatus;

	public CatTipoIdentificacion() {
	}

	public Integer getIdTipoIdentificacion() {
		return this.idTipoIdentificacion;
	}

	public void setIdTipoIdentificacion(Integer idTipoIdentificacion) {
		this.idTipoIdentificacion = idTipoIdentificacion;
	}

	public String getTipoIdentificacionDetalle() {
		return this.tipoIdentificacionDetalle;
	}

	public void setTipoIdentificacionDetalle(String tipoIdentificacionDetalle) {
		this.tipoIdentificacionDetalle = tipoIdentificacionDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}