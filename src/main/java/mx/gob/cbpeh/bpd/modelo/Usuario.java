package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;
import java.util.Date;

//Se agrega nombre de la tabla para evitar errores case sensitiva
@Entity
@Table(name="usuario")
public class Usuario  {

	@Id
	@Column(name="id_usuario")
	private String idUsuario;

	private String amaterno;

	private String apaterno;

	private String contrasenia;

	@Column(name="contrasenia_anterior")
	private String contraseniaAnterior;

	@Column(name="correo_electronico")
	private String correoElectronico;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualiza")
	private Date fechaActualiza;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_alta")
	private Date fechaAlta;

	private String nombre;

	@ManyToOne
	@JoinColumn(name="id_area")
	private CatArea catArea;

	@ManyToOne
	@JoinColumn(name="id_direccion")
	private CatDireccion catDireccion;

	@ManyToOne
	@JoinColumn(name="estatus_usuario")
	private CatEstatus catEstatus;

	@ManyToOne
	@JoinColumn(name="id_puesto")
	private CatPuesto catPuesto;

	@ManyToOne
	@JoinColumn(name="id_perfil")
	private Perfil perfil;

	//@ManyToOne
	@Column(name="id_usuario_actualiza")
	private String usuario;

	//@ManyToOne
	@Column(name="id_usuario_alta")
	private String usuario2;
	
	@Column(name="llave_secreta")
	private String llaveSecreta;
	
	@Column(name="aplica_2fa")
    private Boolean aplica2fa;
	
	public Usuario() {
	}
	
	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getAmaterno() {
		return this.amaterno;
	}

	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}

	public String getApaterno() {
		return this.apaterno;
	}

	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getContraseniaAnterior() {
		return this.contraseniaAnterior;
	}

	public void setContraseniaAnterior(String contraseniaAnterior) {
		this.contraseniaAnterior = contraseniaAnterior;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Date getFechaActualiza() {
		return this.fechaActualiza;
	}

	public void setFechaActualiza(Date fechaActualiza) {
		this.fechaActualiza = fechaActualiza;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CatArea getCatArea() {
		return this.catArea;
	}

	public void setCatArea(CatArea catArea) {
		this.catArea = catArea;
	}

	public CatDireccion getCatDireccion() {
		return this.catDireccion;
	}

	public void setCatDireccion(CatDireccion catDireccion) {
		this.catDireccion = catDireccion;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

	public CatPuesto getCatPuesto() {
		return this.catPuesto;
	}

	public void setCatPuesto(CatPuesto catPuesto) {
		this.catPuesto = catPuesto;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getUsuario1() {
		return this.usuario;
	}

	public void setUsuario1(String usuario1) {
		this.usuario = usuario1;
	}

	public String getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(String usuario2) {
		this.usuario2 = usuario2;
	}	


	public String getLlaveSecreta() {
		return llaveSecreta;
	}

	public void setLlaveSecreta(String llaveSecreta) {
		this.llaveSecreta = llaveSecreta;
	}

	public Boolean getAplica2fa() {
		return aplica2fa;
	}

	public void setAplica2fa(Boolean aplica2fa) {
		this.aplica2fa = aplica2fa;
	}


}