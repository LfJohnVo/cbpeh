package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_estatus_localizado")
public class CatEstatusLocalizado  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estatus_localizado")
	private Integer idEstatusLocalizado;

	@Column(name="estatus_localizado_detalle")
	private String estatusLocalizadoDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_cat")
	private CatEstatus catEstatus;

	public CatEstatusLocalizado() {
	}

	public Integer getIdEstatusLocalizado() {
		return this.idEstatusLocalizado;
	}

	public void setIdEstatusLocalizado(Integer idEstatusLocalizado) {
		this.idEstatusLocalizado = idEstatusLocalizado;
	}

	public String getEstatusLocalizadoDetalle() {
		return this.estatusLocalizadoDetalle;
	}

	public void setEstatusLocalizadoDetalle(String estatusLocalizadoDetalle) {
		this.estatusLocalizadoDetalle = estatusLocalizadoDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}