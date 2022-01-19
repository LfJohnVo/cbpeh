package mx.gob.cbpeh.bpd.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the colaboracion_lugar_busqueda database table.
 * 
 */
@Entity
@Table(name="colaboracion_lugar_busqueda")
@NamedQuery(name="ColaboracionLugarBusqueda.findAll", query="SELECT c FROM ColaboracionLugarBusqueda c")
public class ColaboracionLugarBusqueda implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ColaboracionLugarBusquedaPK id;

	//bi-directional many-to-one association to CatEstatus
	//@ManyToOne
	@Column(name="estatus_colaboracion_lugar")
	private int idEstatus;

	//bi-directional many-to-one association to CatLugarBusqueda
	@ManyToOne
	@JoinColumn(name="id_lugar_busqueda",insertable=false, updatable=false)
	private CatLugarBusqueda catLugarBusqueda;

	//bi-directional many-to-one association to Colaboracion
	@ManyToOne
	@JoinColumn(name="id_expediente_colaboracion",insertable=false, updatable=false)
	private Colaboracion colaboracion;

	public ColaboracionLugarBusqueda() {
	}

	public ColaboracionLugarBusquedaPK getId() {
		return this.id;
	}

	public void setId(ColaboracionLugarBusquedaPK id) {
		this.id = id;
	}

	public int getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(int idEstatus) {
		this.idEstatus = idEstatus;
	}

	public CatLugarBusqueda getCatLugarBusqueda() {
		return this.catLugarBusqueda;
	}

	public void setCatLugarBusqueda(CatLugarBusqueda catLugarBusqueda) {
		this.catLugarBusqueda = catLugarBusqueda;
	}

	public Colaboracion getColaboracion() {
		return this.colaboracion;
	}

	public void setColaboracion(Colaboracion colaboracion) {
		this.colaboracion = colaboracion;
	}

}