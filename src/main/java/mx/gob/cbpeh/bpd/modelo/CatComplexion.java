package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_complexion")
public class CatComplexion  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_complexion")
	private Integer idComplexion;

	@Column(name="complexion_detalle")
	private String complexionDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_complexion")
	private CatEstatus catEstatus;

	public CatComplexion() {
	}

	public Integer getIdComplexion() {
		return this.idComplexion;
	}

	public void setIdComplexion(Integer idComplexion) {
		this.idComplexion = idComplexion;
	}

	public String getComplexionDetalle() {
		return this.complexionDetalle;
	}

	public void setComplexionDetalle(String complexionDetalle) {
		this.complexionDetalle = complexionDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}