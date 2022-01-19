package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_tipo_sangre")
public class CatTipoSangre  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_sangre")
	private Integer idTipoSangre;

	@Column(name="tipo_sangre_detalle")
	private String tipoSangreDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_sangre")
	private CatEstatus catEstatus;

	public CatTipoSangre() {
	}

	public Integer getIdTipoSangre() {
		return this.idTipoSangre;
	}

	public void setIdTipoSangre(Integer idTipoSangre) {
		this.idTipoSangre = idTipoSangre;
	}

	public String getTipoSangreDetalle() {
		return this.tipoSangreDetalle;
	}

	public void setTipoSangreDetalle(String tipoSangreDetalle) {
		this.tipoSangreDetalle = tipoSangreDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}