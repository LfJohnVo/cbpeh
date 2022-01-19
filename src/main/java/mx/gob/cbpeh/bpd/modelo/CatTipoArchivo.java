package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_tipo_archivo")
public class CatTipoArchivo  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_archivo")
	private Integer idTipoArchivo;

	@Column(name="tipo_archivo_detalle")
	private String tipoArchivoDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_tipo_archivo")
	private CatEstatus catEstatus;

	public CatTipoArchivo() {
	}

	public Integer getIdTipoArchivo() {
		return this.idTipoArchivo;
	}

	public void setIdTipoArchivo(Integer idTipoArchivo) {
		this.idTipoArchivo = idTipoArchivo;
	}

	public String getTipoArchivoDetalle() {
		return this.tipoArchivoDetalle;
	}

	public void setTipoArchivoDetalle(String tipoArchivoDetalle) {
		this.tipoArchivoDetalle = tipoArchivoDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}