package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_estatus")
public class CatEstatus  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estatus")
	private Integer idEstatus;

	@Column(name="estatus_detalle")
	private String estatusDetalle;	

	public CatEstatus() {
	}

	public Integer getIdEstatus() {
		return this.idEstatus;
	}

	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}

	public String getEstatusDetalle() {
		return this.estatusDetalle;
	}

	public void setEstatusDetalle(String estatusDetalle) {
		this.estatusDetalle = estatusDetalle;
	}

	@Override
	public String toString() {
		return "CatEstatus [idEstatus=" + idEstatus + ", estatusDetalle=" + estatusDetalle + "]";
	}

}