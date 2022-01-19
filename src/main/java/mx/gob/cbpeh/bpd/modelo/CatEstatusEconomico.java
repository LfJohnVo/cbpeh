package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_estatus_economico")
public class CatEstatusEconomico  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estatus_economico")
	private Integer idEstatusEconomico;

	@Column(name="estatus_economico_detalle")
	private String estatusEconomicoDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_estatus_economico")
	private CatEstatus catEstatus;

	public CatEstatusEconomico() {
	}

	public Integer getIdEstatusEconomico() {
		return this.idEstatusEconomico;
	}

	public void setIdEstatusEconomico(Integer idEstatusEconomico) {
		this.idEstatusEconomico = idEstatusEconomico;
	}

	public String getEstatusEconomicoDetalle() {
		return this.estatusEconomicoDetalle;
	}

	public void setEstatusEconomicoDetalle(String estatusEconomicoDetalle) {
		this.estatusEconomicoDetalle = estatusEconomicoDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}