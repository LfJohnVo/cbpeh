package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="atenta_nota")
public class AtentaNota  {

	@Id
	@Column(name="id_atenta_nota")
	private String idAtentaNota;

	@Column(name="descripcion_nota")
	private String descripcionNota;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Column(name="usuario_destino2")
	private String usuarioDestino2;

	
	@ManyToOne
	@JoinColumn(name="id_area")
	private CatArea catArea;

	@ManyToOne
	@JoinColumn(name="estatus_atenta_nota")
	private CatEstatus catEstatus;

	@ManyToOne
	@JoinColumn(name="id_tipo_nota")
	private CatTipoNota catTipoNota;

	//@ManyToOne
	@Column(name="id_expediente")
	private String idExpediente;

	//@ManyToOne
	@Column(name="usuario_destino")
	private String usuarioDestino;

	//@ManyToOne
	@Column(name="id_usuario_remitente")
	private String usuarioRemitente;

	public AtentaNota() {
	}

	public String getIdAtentaNota() {
		return this.idAtentaNota;
	}

	public void setIdAtentaNota(String idAtentaNota) {
		this.idAtentaNota = idAtentaNota;
	}

	public String getDescripcionNota() {
		return this.descripcionNota;
	}

	public void setDescripcionNota(String descripcionNota) {
		this.descripcionNota = descripcionNota;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioDestino2() {
		return this.usuarioDestino2;
	}

	public void setUsuarioDestino2(String usuarioDestino2) {
		this.usuarioDestino2 = usuarioDestino2;
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

	public CatTipoNota getCatTipoNota() {
		return this.catTipoNota;
	}

	public void setCatTipoNota(CatTipoNota catTipoNota) {
		this.catTipoNota = catTipoNota;
	}

	public String getIdExpediente() {
		return this.idExpediente;
	}

	public void setIdExpediente(String expediente) {
		this.idExpediente = expediente;
	}

	public String getUsuarioDestino() {
		return this.usuarioDestino;
	}

	public void setUsuarioDestino(String usuario1) {
		this.usuarioDestino = usuario1;
	}

	public String getUsuarioRemitente() {
		return this.usuarioRemitente;
	}

	public void setUsuarioRemitente(String usuarioRemitente) {
		this.usuarioRemitente = usuarioRemitente;
	}

}