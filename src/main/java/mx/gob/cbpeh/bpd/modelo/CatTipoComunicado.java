package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_tipo_comunicado")
public class CatTipoComunicado  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_comunicado")
	private Integer idTipoComunicado;

	@Column(name="tipo_comunicado_detalle")
	private String tipoComunicadoDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_tipo_comunicado")
	private CatEstatus catEstatus;

	public CatTipoComunicado() {
	}

	public Integer getIdTipoComunicado() {
		return this.idTipoComunicado;
	}

	public void setIdTipoComunicado(Integer idTipoComunicado) {
		this.idTipoComunicado = idTipoComunicado;
	}

	public String getTipoComunicadoDetalle() {
		return this.tipoComunicadoDetalle;
	}

	public void setTipoComunicadoDetalle(String tipoComunicadoDetalle) {
		this.tipoComunicadoDetalle = tipoComunicadoDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}