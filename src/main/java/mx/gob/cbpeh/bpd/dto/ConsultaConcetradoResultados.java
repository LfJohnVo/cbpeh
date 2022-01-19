package mx.gob.cbpeh.bpd.dto;

public class ConsultaConcetradoResultados {
	
    private String apaterno;
    private int id_estatus_localizado;
    private String fecha_apertura_expediente;
    private String id_expediente;
    private String codigo_estado;
    private int id_edad;
    private String codigo_municipio;
    private String amaterno;
    private String nombre;
    private int id_sexo;
    
public ConsultaConcetradoResultados() {
	super();
	
}


	public ConsultaConcetradoResultados(String apaterno, int id_estatus_localizado, String fecha_apertura_expediente,
		String id_expediente, String codigo_estado, int id_edad, String codigo_municipio, String amaterno,
		String nombre, int id_sexo) {
	super();
	this.apaterno = apaterno;
	this.id_estatus_localizado = id_estatus_localizado;
	this.fecha_apertura_expediente = fecha_apertura_expediente;
	this.id_expediente = id_expediente;
	this.codigo_estado = codigo_estado;
	this.id_edad = id_edad;
	this.codigo_municipio = codigo_municipio;
	this.amaterno = amaterno;
	this.nombre = nombre;
	this.id_sexo = id_sexo;
}


	public String getApaterno() {
		return apaterno;
	}
	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}
	public int getId_estatus_localizado() {
		return id_estatus_localizado;
	}
	public void setId_estatus_localizado(int id_estatus_localizado) {
		this.id_estatus_localizado = id_estatus_localizado;
	}
	public String getFecha_apertura_expediente() {
		return fecha_apertura_expediente;
	}
	public void setFecha_apertura_expediente(String fecha_apertura_expediente) {
		this.fecha_apertura_expediente = fecha_apertura_expediente;
	}
	public String getId_expediente() {
		return id_expediente;
	}
	public void setId_expediente(String id_expediente) {
		this.id_expediente = id_expediente;
	}
	public String getCodigo_estado() {
		return codigo_estado;
	}
	public void setCodigo_estado(String codigo_estado) {
		this.codigo_estado = codigo_estado;
	}
	public int getId_edad() {
		return id_edad;
	}
	public void setId_edad(int id_edad) {
		this.id_edad = id_edad;
	}
	public String getCodigo_municipio() {
		return codigo_municipio;
	}
	public void setCodigo_municipio(String codigo_municipio) {
		this.codigo_municipio = codigo_municipio;
	}
	public String getAmaterno() {
		return amaterno;
	}
	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId_sexo() {
		return id_sexo;
	}
	public void setId_sexo(int id_sexo) {
		this.id_sexo = id_sexo;
	}
    
    


}
