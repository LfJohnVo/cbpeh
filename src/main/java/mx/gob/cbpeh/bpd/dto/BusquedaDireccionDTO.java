package mx.gob.cbpeh.bpd.dto;

import java.time.LocalDate;
import java.util.Date;

import mx.gob.cbpeh.bpd.modelo.CatColonia;
import mx.gob.cbpeh.bpd.modelo.CatCp;
import mx.gob.cbpeh.bpd.modelo.CatEstatusLocalizado;
import mx.gob.cbpeh.bpd.modelo.CatMunicipio;

public class BusquedaDireccionDTO {
	
	private int idBusqueda;
	private String calle;	
	private Date fechaActualiza;
	private Date fechaAlta;
	private String fechaBusqueda;
	private Float latitud;
	private Float longitud;
	private String resenia;
	private CatColonia colonia;
	private CatCp cp;
	private CatEstatusLocalizado estatusLocalizado;
	private Integer idEstatusLocalizado;
	private Integer idEstatusVida;
	private CatMunicipio municipio;
	private String expediente;
	private String usuarioActualiza;
	private String usuarioAlta;
	
	public int getIdBusqueda() {
		return idBusqueda;
	}
	public void setIdBusqueda(int idBusqueda) {
		this.idBusqueda = idBusqueda;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Date getFechaActualiza() {
		return fechaActualiza;
	}
	public void setFechaActualiza(Date fechaActualiza) {
		this.fechaActualiza = fechaActualiza;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public String getFechaBusqueda() {
		return fechaBusqueda;
	}
	public void setFechaBusqueda(String fechaBusqueda) {
		this.fechaBusqueda = fechaBusqueda;
	}
	public Float getLatitud() {
		return latitud;
	}
	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}
	public Float getLongitud() {
		return longitud;
	}
	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}
	public String getResenia() {
		return resenia;
	}
	public void setResenia(String resenia) {
		this.resenia = resenia;
	}

	public CatColonia getColonia() {
		return colonia;
	}
	public void setColonia(CatColonia colonia) {
		this.colonia = colonia;
	}
	public CatCp getCp() {
		return cp;
	}
	public void setCp(CatCp cp) {
		this.cp = cp;
	}
	public CatEstatusLocalizado getEstatusLocalizado() {
		return estatusLocalizado;
	}
	public void setEstatusLocalizado(CatEstatusLocalizado estatusLocalizado) {
		this.estatusLocalizado = estatusLocalizado;
	}
	public Integer getIdEstatusLocalizado() {
		return idEstatusLocalizado;
	}
	public void setIdEstatusLocalizado(Integer idEstatusLocalizado) {
		this.idEstatusLocalizado = idEstatusLocalizado;
	}
	public Integer getIdEstatusVida() {
		return idEstatusVida;
	}
	public void setIdEstatusVida(Integer idEstatusVida) {
		this.idEstatusVida = idEstatusVida;
	}
	public CatMunicipio getMunicipio() {
		return municipio;
	}
	public void setMunicipio(CatMunicipio municipio) {
		this.municipio = municipio;
	}
	public String getExpediente() {
		return expediente;
	}
	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}
	public String getUsuarioActualiza() {
		return usuarioActualiza;
	}
	public void setUsuarioActualiza(String usuarioActualiza) {
		this.usuarioActualiza = usuarioActualiza;
	}
	public String getUsuarioAlta() {
		return usuarioAlta;
	}
	public void setUsuarioAlta(String usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}
}
