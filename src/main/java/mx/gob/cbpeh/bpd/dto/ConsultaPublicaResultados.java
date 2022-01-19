package mx.gob.cbpeh.bpd.dto;

public class ConsultaPublicaResultados {

	private String apaterno;
	private int id_estatus_localizado;
	private String id_expediente;
	private String amaterno;
	private String limite;
	private String nombre;
	private String fecha_desaparicion;
	private String curp;

	public ConsultaPublicaResultados() {
		super();
	}

	public ConsultaPublicaResultados(String apaterno, int id_estatus_localizado, String id_expediente, String amaterno,
			String limite, String nombre, String fecha_desaparicion, String curp) {
		super();
		this.apaterno = apaterno;
		this.id_estatus_localizado = id_estatus_localizado;
		this.id_expediente = id_expediente;
		this.amaterno = amaterno;
		this.limite = limite;
		this.nombre = nombre;
		this.fecha_desaparicion = fecha_desaparicion;
		this.curp = curp;
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

	public String getLimite() {
		return limite;
	}

	public void setLimite(String limite) {
		this.limite = limite;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha_desaparicion() {
		return fecha_desaparicion;
	}

	public void setFecha_desaparicion(String fecha_desaparicion) {
		this.fecha_desaparicion = fecha_desaparicion;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

//	 @Override
//		public String toString() {
//			 return "resultados {" + "idExpediente = " + idExpediente + ", idEstatusLocalizado =" + idEstatusLocalizado
//						+ '\'' + '}';
//		}

}
