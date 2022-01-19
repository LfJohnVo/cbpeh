package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

//Se agrega nombre de la tabla para evitar errores case sensitiva
@Entity
@Table(name="perfil")
public class Perfil  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_perfil")
	private Integer idPerfil;

	@Column(name="perfil_detalle")
	private String perfilDetalle;

	@ManyToOne
	@JoinColumn(name="id_area")
	private CatArea catArea;

	@ManyToOne
	@JoinColumn(name="estatus_perfil")
	private CatEstatus catEstatus;
	
	@Column(name="role")
	private String role;

	
	public Perfil() {
	}	

	public Integer getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getPerfilDetalle() {
		return this.perfilDetalle;
	}

	public void setPerfilDetalle(String perfilDetalle) {
		this.perfilDetalle = perfilDetalle;
	}

	public CatArea getCatArea() {
		return this.catArea;
	}

	public void setCatArea(CatArea catArea) {
		this.catArea = catArea;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}