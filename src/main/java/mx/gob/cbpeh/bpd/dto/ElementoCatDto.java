package mx.gob.cbpeh.bpd.dto;

import java.io.Serializable;

public class ElementoCatDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	Integer idCatalogo;
	String detalle;
	Integer estatus;
	
	public Integer getIdCatalogo() {
		return idCatalogo;
	}
	public void setIdCatalogo(Integer idCatalogo) {
		this.idCatalogo = idCatalogo;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
	

}
