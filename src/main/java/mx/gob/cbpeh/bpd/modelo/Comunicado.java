package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;
import java.util.Date;

//Se agrega nombre de la tabla para evitar errores case sensitiva
@Entity
@Table(name="comunicado")
public class Comunicado  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_comunicado")
	private int idComunicado;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_baja")
	private Date fechaBaja;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_carga")
	private Date fechaCarga;
    
	@Column(name="imagen")
	private byte[] imagen;

	private String titulo;

	private String url;

	@ManyToOne
	@JoinColumn(name="estatus_comunicado")
	private CatEstatus catEstatus;

	@ManyToOne
	@JoinColumn(name="id_tipo_comunicado")
	private CatTipoComunicado catTipoComunicado;

	@ManyToOne
	@JoinColumn(name="id_usuario_carga")
	private Usuario usuario;

	public Comunicado() {
	}

	public int getIdComunicado() {
		return this.idComunicado;
	}

	public void setIdComunicado(int idComunicado) {
		this.idComunicado = idComunicado;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Date getFechaCarga() {
		return this.fechaCarga;
	}

	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	public byte[] getImagen() {
		return this.imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

	public CatTipoComunicado getCatTipoComunicado() {
		return this.catTipoComunicado;
	}

	public void setCatTipoComunicado(CatTipoComunicado catTipoComunicado) {
		this.catTipoComunicado = catTipoComunicado;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}