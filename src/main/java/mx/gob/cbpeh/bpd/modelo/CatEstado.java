package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_estado")
public class CatEstado  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado")
	private int idEstado;

	@Column(name="abreviatura_estado")
	private String abreviaturaEstado;

	@Column(name="codigo_estado")
	private String codigoEstado;

	@Column(name="estado_detalle")
	private String estadoDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_estado")
	private CatEstatus catEstatus;

	public CatEstado() {
	}

	public int getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getAbreviaturaEstado() {
		return this.abreviaturaEstado;
	}

	public void setAbreviaturaEstado(String abreviaturaEstado) {
		this.abreviaturaEstado = abreviaturaEstado;
	}

	public String getCodigoEstado() {
		return this.codigoEstado;
	}

	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	public String getEstadoDetalle() {
		return this.estadoDetalle;
	}

	public void setEstadoDetalle(String estadoDetalle) {
		this.estadoDetalle = estadoDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}