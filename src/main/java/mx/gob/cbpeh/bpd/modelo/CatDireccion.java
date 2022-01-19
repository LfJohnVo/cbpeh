package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_direccion")
public class CatDireccion  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_direccion")
	private Integer idDireccion;

	@Column(name="direccion_detalle")
	private String direccionDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_direccion")
	private CatEstatus catEstatus;

	public CatDireccion() {
	}

	public Integer getIdDireccion() {
		return this.idDireccion;
	}

	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getDireccionDetalle() {
		return this.direccionDetalle;
	}

	public void setDireccionDetalle(String direccionDetalle) {
		this.direccionDetalle = direccionDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}