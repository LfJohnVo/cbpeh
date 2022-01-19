package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_municipio")
public class CatMunicipio  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_municipio")
	private int idMunicipio;

	@Column(name="codigo_estado")
	private String codigoEstado;

	@Column(name="codigo_municipio")
	private String codigoMunicipio;

	@Column(name="municipio_detalle")
	private String municipioDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_municipio")
	private CatEstatus catEstatus;


	public CatMunicipio() {
	}

	public int getIdMunicipio() {
		return this.idMunicipio;
	}

	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
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

	public String getMunicipioDetalle() {
		return this.municipioDetalle;
	}

	public void setMunicipioDetalle(String municipioDetalle) {
		this.municipioDetalle = municipioDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}