package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_tamanio_nariz")
public class CatTamanioNariz  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tamanio_nariz")
	private Integer idTamanioNariz;

	@Column(name="tamanio_nariz_detalle")
	private String tamanioNarizDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_tamanio_nariz")
	private CatEstatus catEstatus;

	public CatTamanioNariz() {
	}

	public Integer getIdTamanioNariz() {
		return this.idTamanioNariz;
	}

	public void setIdTamanioNariz(Integer idTamanioNariz) {
		this.idTamanioNariz = idTamanioNariz;
	}

	public String getTamanioNarizDetalle() {
		return this.tamanioNarizDetalle;
	}

	public void setTamanioNarizDetalle(String tamanioNarizDetalle) {
		this.tamanioNarizDetalle = tamanioNarizDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}