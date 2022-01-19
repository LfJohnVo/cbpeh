package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_compania_telefono")
public class CatCompaniaTelefono  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_compania_telefono")
	private Integer idCompaniaTelefono;

	@Column(name="compania_telefono_detalle")
	private String companiaTelefonoDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_compania_telefono")
	private CatEstatus catEstatus;


	public CatCompaniaTelefono() {
	}

	public Integer getIdCompaniaTelefono() {
		return this.idCompaniaTelefono;
	}

	public void setIdCompaniaTelefono(Integer idCompaniaTelefono) {
		this.idCompaniaTelefono = idCompaniaTelefono;
	}

	public String getCompaniaTelefonoDetalle() {
		return this.companiaTelefonoDetalle;
	}

	public void setCompaniaTelefonoDetalle(String companiaTelefonoDetalle) {
		this.companiaTelefonoDetalle = companiaTelefonoDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}
	
}