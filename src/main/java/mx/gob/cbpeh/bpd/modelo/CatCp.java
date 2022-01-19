package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_cp")
public class CatCp  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cp")
	private int idCp;

	@Column(name="codigo_cp")
	private String codigoCp;

	@Column(name="codigo_estado")
	private String codigoEstado;

	@Column(name="codigo_municipio")
	private String codigoMunicipio;

	@ManyToOne
	@JoinColumn(name="estatus_cp")
	private CatEstatus catEstatus;

	public CatCp() {
	}

	public int getIdCp() {
		return this.idCp;
	}

	public void setIdCp(int idCp) {
		this.idCp = idCp;
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

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}