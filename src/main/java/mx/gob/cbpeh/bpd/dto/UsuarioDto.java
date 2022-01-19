package mx.gob.cbpeh.bpd.dto;

import java.util.Date;
import java.util.List;

import mx.gob.cbpeh.bpd.modelo.CatArea;
import mx.gob.cbpeh.bpd.modelo.CatDireccion;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.modelo.CatPuesto;
import mx.gob.cbpeh.bpd.modelo.Perfil;
import mx.gob.cbpeh.bpd.modelo.Usuario;

public class UsuarioDto extends CommonResponse {
	
List<Usuario> usuarios;
private Usuario usuario;
private String idUsuario;
private String amaterno;
private String apaterno;
private String correoElectronico;
private Date fechaActualiza;
private Date fechaAlta;
private String nombre;
private CatArea catArea;
private CatDireccion catDireccion;
private int idDireccion;
private CatEstatus catEstatus;
private CatPuesto catPuesto;
private int idPuesto;
private Perfil perfil;

public Usuario getUsuario() {
	return usuario;
}

public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}


public List<Usuario> getUsuarios() {
	return usuarios;
}

public void setUsuarios(List<Usuario> usuarios) {
	this.usuarios = usuarios;
}

public String getIdUsuario() {
	return idUsuario;
}

public void setIdUsuario(String idUsuario) {
	this.idUsuario = idUsuario;
}

public String getAmaterno() {
	return amaterno;
}

public void setAmaterno(String amaterno) {
	this.amaterno = amaterno;
}

public String getApaterno() {
	return apaterno;
}

public void setApaterno(String apaterno) {
	this.apaterno = apaterno;
}

public String getCorreoElectronico() {
	return correoElectronico;
}

public void setCorreoElectronico(String correoElectronico) {
	this.correoElectronico = correoElectronico;
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

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public CatArea getCatArea() {
	return catArea;
}

public void setCatArea(CatArea catArea) {
	this.catArea = catArea;
}

public CatDireccion getCatDireccion() {
	return catDireccion;
}

public void setCatDireccion(CatDireccion catDireccion) {
	this.catDireccion = catDireccion;
}

public CatEstatus getCatEstatus() {
	return catEstatus;
}

public void setCatEstatus(CatEstatus catEstatus) {
	this.catEstatus = catEstatus;
}

public CatPuesto getCatPuesto() {
	return catPuesto;
}

public void setCatPuesto(CatPuesto catPuesto) {
	this.catPuesto = catPuesto;
}

public Perfil getPerfil() {
	return perfil;
}

public void setPerfil(Perfil perfil) {
	this.perfil = perfil;
}

public void setIdDireccion(int idDireccion) {
	this.idDireccion = idDireccion;
}
public void setIdPuesto(int idPuesto) {
	this.idPuesto = idPuesto;
}

public int getIdDireccion() {
	return idDireccion;
}

public int getIdPuesto() {
	return idPuesto;
}

}
