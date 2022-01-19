package mx.gob.cbpeh.bpd.dto;

import java.util.Date;

public class Comunicado2  {

	
	private int idComunicado;

	private String descripcion;
	
	private Date fechaBaja;
	
	private Date fechaCarga;    
	
	private byte[] imagen;
	
	private String imagenDetalle;

	private String titulo;

	private String url;	

public Comunicado2() {
		
	}
	public String getImagenDetalle() {
		return imagenDetalle;
	}

	public void setImagenDetalle(String imagenDetalle) {
		this.imagenDetalle = imagenDetalle;
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

	

}


