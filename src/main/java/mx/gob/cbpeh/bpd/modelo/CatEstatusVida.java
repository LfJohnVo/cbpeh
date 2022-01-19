package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_estatus_vida")
public class CatEstatusVida  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estatus_vida")
	private Integer idEstatusVida;

	@Column(name="estatus_vida_detalle")
	private String estatusVidaDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_estatus_vida")
	private CatEstatus catEstatus;

	public CatEstatusVida() {
	}

	public Integer getIdEstatusVida() {
		return this.idEstatusVida;
	}

	public void setIdEstatusVida(Integer idEstatusVida) {
		this.idEstatusVida = idEstatusVida;
	}

	public String getEstatusVidaDetalle() {
		return this.estatusVidaDetalle;
	}

	public void setEstatusVidaDetalle(String estatusVidaDetalle) {
		this.estatusVidaDetalle = estatusVidaDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}