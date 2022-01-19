package mx.gob.cbpeh.bpd.dto;

public class ConsultaReporteResultados {

	private String id_expediente;
	private String correo_electronico;
	private String calle;
	private String codigo_estado;
	private String colonia;
	private String ocupacion;
	private int medio_reporte;
	private int id_sexo;
	private int nacionalidad;
	private int id_parentesco;	
	private int id_edad;	
	private String telefono2;
	private String nombre;
	private String apaterno;
	private String amaterno;
	private String codigo_municipio;
	private int id_cp;
	private String telefono1;

	public ConsultaReporteResultados() {
		super();
	}

	public ConsultaReporteResultados(String id_expediente, String correo_electronico, String calle,
			String codigo_estado, String colonia, String ocupacion, int medio_reporte, int id_sexo, int nacionalidad,
			int id_parentesco, int id_edad, String telefono2, String nombre, String apaterno, String amaterno,
			String codigo_municipio, int id_cp, String telefono1) {
		super();
		this.id_expediente = id_expediente;
		this.correo_electronico = correo_electronico;
		this.calle = calle;
		this.codigo_estado = codigo_estado;
		this.colonia = colonia;
		this.ocupacion = ocupacion;
		this.medio_reporte = medio_reporte;
		this.id_sexo = id_sexo;
		this.nacionalidad = nacionalidad;
		this.id_parentesco = id_parentesco;
		this.id_edad = id_edad;
		this.telefono2 = telefono2;
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
		this.codigo_municipio = codigo_municipio;
		this.id_cp = id_cp;
		this.telefono1 = telefono1;
	}



	public String getApaterno() {
		return apaterno;
	}

	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void T(String telefono2) {
		this.telefono2 = telefono2;
	}

	
	public String getId_expediente() {
		return id_expediente;
	}

	public void setId_expediente(String id_expediente) {
		this.id_expediente = id_expediente;
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

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCodigo_estado() {
		return codigo_estado;
	}

	public void setCodigo_estado(String codigo_estado) {
		this.codigo_estado = codigo_estado;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public int getMedio_reporte() {
		return medio_reporte;
	}

	public void setMedio_reporte(int medio_reporte) {
		this.medio_reporte = medio_reporte;
	}

	public int getId_sexo() {
		return id_sexo;
	}

	public void setId_sexo(int id_sexo) {
		this.id_sexo = id_sexo;
	}

	public int getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(int nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getId_parentesco() {
		return id_parentesco;
	}

	public void setId_parentesco(int id_parentesco) {
		this.id_parentesco = id_parentesco;
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

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public int getId_cp() {
		return id_cp;
	}

	public void setId_cp(int id_cp) {
		this.id_cp = id_cp;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

//	 @Override
//		public String toString() {
//			 return "resultados {" + "idExpediente = " + idExpediente + ", idEstatusLocalizado =" + idEstatusLocalizado
//						+ '\'' + '}';
//		}

}
