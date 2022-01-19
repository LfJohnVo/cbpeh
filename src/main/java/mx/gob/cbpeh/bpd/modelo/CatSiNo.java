package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_si_no")
public class CatSiNo  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_si_no")
	private Integer idSiNo;

	@Column(name="si_no_detalle")
	private String siNoDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_si_no")
	private CatEstatus catEstatus;

	public CatSiNo() {
	}

	public Integer getIdSiNo() {
		return this.idSiNo;
	}

	public void setIdSiNo(Integer idSiNo) {
		this.idSiNo = idSiNo;
	}

	public String getSiNoDetalle() {
		return this.siNoDetalle;
	}

	public void setSiNoDetalle(String siNoDetalle) {
		this.siNoDetalle = siNoDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}
}