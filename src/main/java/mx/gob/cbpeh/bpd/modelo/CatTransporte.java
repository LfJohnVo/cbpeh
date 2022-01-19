package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_transporte")
public class CatTransporte  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_transporte")
	private Integer idTransporte;

	@Column(name="transporte_detalle")
	private String transporteDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_transporte")
	private CatEstatus catEstatus;

	public CatTransporte() {
	}

	public Integer getIdTransporte() {
		return this.idTransporte;
	}

	public void setIdTransporte(Integer idTransporte) {
		this.idTransporte = idTransporte;
	}

	public String getTransporteDetalle() {
		return this.transporteDetalle;
	}

	public void setTransporteDetalle(String transporteDetalle) {
		this.transporteDetalle = transporteDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}