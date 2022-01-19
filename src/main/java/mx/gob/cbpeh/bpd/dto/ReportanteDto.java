package mx.gob.cbpeh.bpd.dto;

import java.math.BigInteger;

import org.springframework.web.multipart.MultipartFile;

public class ReportanteDto {
	
	private int estado;
	private int municipio;
	private int cp;
	private int colonia;
	private int edad;
	private int sexo;		
	private int relacion;
	private int ocupacion;
	private int medio;
	private int nacionalidad;
	private int acompanaba;	
	private String nombre;
	private String amaterno;
	private String apaterno;
	private String calle;
	private BigInteger telefono1;
	private String correoElectronico;
	private BigInteger telefono2;
	private byte[] identificacion;
	private MultipartFile file;
		
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getMunicipio() {
		return municipio;
	}
	public void setMunicipio(int municipio) {
		this.municipio = municipio;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public int getColonia() {
		return colonia;
	}
	public void setColonia(int colonia) {
		this.colonia = colonia;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getSexo() {
		return sexo;
	}
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	public int getRelacion() {
		return relacion;
	}
	public void setRelacion(int relacion) {
		this.relacion = relacion;
	}
	public int getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(int ocupacion) {
		this.ocupacion = ocupacion;
	}
	public int getMedio() {
		return medio;
	}
	public void setMedio(int medio) {
		this.medio = medio;
	}
	public int getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(int nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public int getAcompanaba() {
		return acompanaba;
	}
	public void setAcompanaba(int acompanaba) {
		this.acompanaba = acompanaba;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	public BigInteger getTelefono1() {
		return telefono1;
	}
	public void setTelefono1(BigInteger telefono1) {
		this.telefono1 = telefono1;
	}
	public BigInteger getTelefono2() {
		return telefono2;
	}
	public void setTelefono2(BigInteger telefono2) {
		this.telefono2 = telefono2;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public byte[] getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(byte[] identificacion) {
		this.identificacion = identificacion;
	}	
		
}