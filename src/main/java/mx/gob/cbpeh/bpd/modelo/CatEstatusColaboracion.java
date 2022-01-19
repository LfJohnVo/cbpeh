package mx.gob.cbpeh.bpd.modelo;


import javax.persistence.*;

@Entity
@Table(name="cat_estatus_colaboracion")
public class CatEstatusColaboracion{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estatus_colaboracion")
	private Integer idEstatusColaboracion;

	@Column(name="estatus_colaboracion")
	private Integer estatusColaboracion;

	@Column(name="estatus_colaboracion_detalle")
	private String estatusColaboracionDetalle;

	public CatEstatusColaboracion() {
	}

	public Integer getIdEstatusColaboracion() {
		return this.idEstatusColaboracion;
	}

	public void setIdEstatusColaboracion(Integer idEstatusColaboracion) {
		this.idEstatusColaboracion = idEstatusColaboracion;
	}

	public Integer getEstatusColaboracion() {
		return this.estatusColaboracion;
	}

	public void setEstatusColaboracion(Integer estatusColaboracion) {
		this.estatusColaboracion = estatusColaboracion;
	}

	public String getEstatusColaboracionDetalle() {
		return this.estatusColaboracionDetalle;
	}

	public void setEstatusColaboracionDetalle(String estatusColaboracionDetalle) {
		this.estatusColaboracionDetalle = estatusColaboracionDetalle;
	}

}