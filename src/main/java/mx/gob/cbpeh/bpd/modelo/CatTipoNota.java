package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_tipo_nota")
public class CatTipoNota  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_nota")
	private Integer idTipoNota;

	@Column(name="tipo_nota_detalle")
	private String tipoNotaDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_tipo_nota")
	private CatEstatus catEstatus;

	public CatTipoNota() {
	}

	public Integer getIdTipoNota() {
		return this.idTipoNota;
	}

	public void setIdTipoNota(Integer idTipoNota) {
		this.idTipoNota = idTipoNota;
	}

	public String getTipoNotaDetalle() {
		return this.tipoNotaDetalle;
	}

	public void setTipoNotaDetalle(String tipoNotaDetalle) {
		this.tipoNotaDetalle = tipoNotaDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}