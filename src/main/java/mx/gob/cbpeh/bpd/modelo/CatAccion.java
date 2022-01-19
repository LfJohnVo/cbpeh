package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_accion")
public class CatAccion  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_accion")
	private Integer idAccion;

	@Column(name="accion_detalle")
	private String accionDetalle;


	@ManyToOne
	@JoinColumn(name="estatus_accion")
	private CatEstatus catEstatus;

	public CatAccion() {
	}

	public Integer getIdAccion() {
		return this.idAccion;
	}

	public void setIdAccion(Integer idAccion) {
		this.idAccion = idAccion;
	}

	public String getAccionDetalle() {
		return this.accionDetalle;
	}

	public void setAccionDetalle(String accionDetalle) {
		this.accionDetalle = accionDetalle;
	}

	
	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}