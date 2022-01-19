package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_red_social")
public class CatRedSocial  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_red_social")
	private Integer idRedSocial;

	@Column(name="red_social_detalle")
	private String redSocialDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_red_social")
	private CatEstatus catEstatus;

	public CatRedSocial() {
	}

	public Integer getIdRedSocial() {
		return this.idRedSocial;
	}

	public void setIdRedSocial(Integer idRedSocial) {
		this.idRedSocial = idRedSocial;
	}

	public String getRedSocialDetalle() {
		return this.redSocialDetalle;
	}

	public void setRedSocialDetalle(String redSocialDetalle) {
		this.redSocialDetalle = redSocialDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}