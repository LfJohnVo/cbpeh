package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_longitud_cabello")
public class CatLongitudCabello  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_lognitud_cabello")
	private Integer idLognitudCabello;

	@Column(name="longitud_cabello_detalle")
	private String longitudCabelloDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_longitud_cabello")
	private CatEstatus catEstatus;

	public CatLongitudCabello() {
	}

	public Integer getIdLognitudCabello() {
		return this.idLognitudCabello;
	}

	public void setIdLognitudCabello(Integer idLognitudCabello) {
		this.idLognitudCabello = idLognitudCabello;
	}

	public String getLongitudCabelloDetalle() {
		return this.longitudCabelloDetalle;
	}

	public void setLongitudCabelloDetalle(String longitudCabelloDetalle) {
		this.longitudCabelloDetalle = longitudCabelloDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}