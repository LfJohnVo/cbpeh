package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;


@Entity
@Table(name="cat_colonia")
public class CatColonia  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_colonia")
	private int idColonia;

	@Column(name="codigo_cp")
	private String codigoCp;

	@Column(name="codigo_estado")
	private String codigoEstado;

	@Column(name="codigo_municipio")
	private String codigoMunicipio;

	@Column(name="colonia_detalle")
	private String coloniaDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_colonia")
	private CatEstatus catEstatus;

	public CatColonia() {
	}

	public int getIdColonia() {
		return this.idColonia;
	}

	public void setIdColonia(int idColonia) {
		this.idColonia = idColonia;
	}

	public String getCodigoCp() {
		return this.codigoCp;
	}

	public void setCodigoCp(String codigoCp) {
		this.codigoCp = codigoCp;
	}

	public String getCodigoEstado() {
		return this.codigoEstado;
	}

	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	public String getCodigoMunicipio() {
		return this.codigoMunicipio;
	}

	public void setCodigoMunicipio(String codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	public String getColoniaDetalle() {
		return this.coloniaDetalle;
	}

	public void setColoniaDetalle(String coloniaDetalle) {
		this.coloniaDetalle = coloniaDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}