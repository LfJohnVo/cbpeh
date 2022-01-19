package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_tipo_uso")
public class CatTipoUso  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_uso")
	private Integer idTipoUso;

	@Column(name="tipo_uso_detalle")
	private String tipoUsoDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_tipo_uso")
	private CatEstatus catEstatus;

	public CatTipoUso() {
	}

	public Integer getIdTipoUso() {
		return this.idTipoUso;
	}

	public void setIdTipoUso(Integer idTipoUso) {
		this.idTipoUso = idTipoUso;
	}

	public String getTipoUsoDetalle() {
		return this.tipoUsoDetalle;
	}

	public void setTipoUsoDetalle(String tipoUsoDetalle) {
		this.tipoUsoDetalle = tipoUsoDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}