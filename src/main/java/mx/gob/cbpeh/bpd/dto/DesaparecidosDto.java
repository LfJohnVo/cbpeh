package mx.gob.cbpeh.bpd.dto;


public class DesaparecidosDto {
	
	private String idExpediente;
	private String nombre;
	private String apaterno;
	private String amaterno;	
	private Integer edad;
	private String sexo;	
	private Integer municipio;
	private String estatus;
	/**
	 * @return the idExpediente
	 */
	public String getIdExpediente() {
		return idExpediente;
	}
	/**
	 * @param idExpediente the idExpediente to set
	 */
	public void setIdExpediente(String idExpediente) {
		this.idExpediente = idExpediente;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apaterno
	 */
	public String getApaterno() {
		return apaterno;
	}
	/**
	 * @param apaterno the apaterno to set
	 */
	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}
	/**
	 * @return the amaterno
	 */
	public String getAmaterno() {
		return amaterno;
	}
	/**
	 * @param amaterno the amaterno to set
	 */
	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}
	/**
	 * @return the edad
	 */
	public Integer getEdad() {
		return edad;
	}
	/**
	 * @param edad the edad to set
	 */
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}
	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/**
	 * @return the municipio
	 */
	public Integer getMunicipio() {
		return municipio;
	}
	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(Integer municipio) {
		this.municipio = municipio;
	}
	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}
	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}	
		
}
