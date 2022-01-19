package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_tipo_cabello")
public class CatTipoCabello  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_cabello")
	private Integer idTipoCabello;

	@Column(name="tipo_cabello_detalle")
	private String tipoCabelloDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_tipo_cabello")
	private CatEstatus catEstatus;

	public CatTipoCabello() {
	}

	public Integer getIdTipoCabello() {
		return this.idTipoCabello;
	}

	public void setIdTipoCabello(Integer idTipoCabello) {
		this.idTipoCabello = idTipoCabello;
	}

	public String getTipoCabelloDetalle() {
		return this.tipoCabelloDetalle;
	}

	public void setTipoCabelloDetalle(String tipoCabelloDetalle) {
		this.tipoCabelloDetalle = tipoCabelloDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}