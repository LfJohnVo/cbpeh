package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_catalogos_bd")
public class CatCatalogosDB  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_catalogo")
	private Integer idCatalogo;

	@Column(name="nombre_catalogo")
	private String nombreCatalogo;
	
	@Column(name="descripcion_catalogo")
	private String descripcionCatalogo;

	@ManyToOne
	@JoinColumn(name="id_estatus_catalogo")
	private CatEstatus catEstatus;

	public CatCatalogosDB() {
	}

	public Integer getIdCatalogo() {
		return idCatalogo;
	}

	public void setIdCatalogo(Integer idCatalogo) {
		this.idCatalogo = idCatalogo;
	}

	public String getNombreCatalogo() {
		return nombreCatalogo;
	}

	public void setNombreCatalogo(String nombreCatalogo) {
		this.nombreCatalogo = nombreCatalogo;
	}

	public String getDescripcionCatalogo() {
		return descripcionCatalogo;
	}

	public void setDescripcionCatalogo(String descripcionCatalogo) {
		this.descripcionCatalogo = descripcionCatalogo;
	}

	public CatEstatus getCatEstatus() {
		return catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

	
}