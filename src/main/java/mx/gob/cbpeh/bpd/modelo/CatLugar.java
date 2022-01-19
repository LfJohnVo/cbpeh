package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_lugar")
public class CatLugar  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_lugar")
	private Integer idLugar;

	@Column(name="lugar_detalle")
	private String lugarDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_lugar")
	private CatEstatus catEstatus;

	public CatLugar() {
	}

	public Integer getIdLugar() {
		return this.idLugar;
	}

	public void setIdLugar(Integer idLugar) {
		this.idLugar = idLugar;
	}

	public String getLugarDetalle() {
		return this.lugarDetalle;
	}

	public void setLugarDetalle(String lugarDetalle) {
		this.lugarDetalle = lugarDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}