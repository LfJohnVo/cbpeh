package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_medio_reporte")
public class CatMedioReporte  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_medio_reporte")
	private Integer idMedioReporte;

	@Column(name="medio_reporte_detalle")
	private String medioReporteDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_medio")
	private CatEstatus catEstatus;

	public CatMedioReporte() {
	}

	public Integer getIdMedioReporte() {
		return this.idMedioReporte;
	}

	public void setIdMedioReporte(Integer idMedioReporte) {
		this.idMedioReporte = idMedioReporte;
	}

	public String getMedioReporteDetalle() {
		return this.medioReporteDetalle;
	}

	public void setMedioReporteDetalle(String medioReporteDetalle) {
		this.medioReporteDetalle = medioReporteDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}