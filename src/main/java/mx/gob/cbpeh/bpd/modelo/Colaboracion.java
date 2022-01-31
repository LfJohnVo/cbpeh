package mx.gob.cbpeh.bpd.modelo;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="colaboracion")
public class Colaboracion  {	

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_expediente_colaboracion")
	private String idExpedienteColaboracion;

	private String amaterno;

	private String apaterno;

	@Column(name="estatus_expediente_colaboracion")
	private int estatusExpedienteColaboracion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualiza")
	private Date fechaActualiza;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_alta")
	private Date fechaAlta;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_peticion")
	private Date fechaPeticion;

	@Column(name="firmado_por")
	private String firmadoPor;

	private String nombre;

	@Column(name="numero_officio_peticion")
	private String numeroOfficioPeticion;

	@Column(name="oficio_colaboracion")
	private String oficioColaboracion;

	@Column(name="usuario_actualiza")
	private String usuarioActualiza;

	@Column(name="usuario_alta")
	private String usuarioAlta;

	//bi-directional many-to-one association to CatEstatusColaboracion
	@ManyToOne
	@JoinColumn(name="id_estatus_colaboracion")
	private CatEstatusColaboracion catEstatusColaboracion;

	//bi-directional many-to-one association to CatInstitucion
	@ManyToOne
	@JoinColumn(name="id_institucion")
	private CatInstitucion catInstitucion;

	public Colaboracion() {
	}

	public String getIdExpedienteColaboracion() {
		return this.idExpedienteColaboracion;
	}

	public void setIdExpedienteColaboracion(String idExpedienteColaboracion) {
		this.idExpedienteColaboracion = idExpedienteColaboracion;
	}

	public String getAmaterno() {
		return this.amaterno;
	}

	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}

	public String getApaterno() {
		return this.apaterno;
	}

	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}

	public int getEstatusExpedienteColaboracion() {
		return this.estatusExpedienteColaboracion;
	}

	public void setEstatusExpedienteColaboracion(int estatusExpedienteColaboracion) {
		this.estatusExpedienteColaboracion = estatusExpedienteColaboracion;
	}

	public Date getFechaActualiza() {
		return this.fechaActualiza;
	}

	public void setFechaActualiza(Date fechaActualiza) {
		this.fechaActualiza = fechaActualiza;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaPeticion() {
		return this.fechaPeticion;
	}

	public void setFechaPeticion(Date fechaPeticion) {
		this.fechaPeticion = fechaPeticion;
	}

	public String getFirmadoPor() {
		return this.firmadoPor;
	}

	public void setFirmadoPor(String firmadoPor) {
		this.firmadoPor = firmadoPor;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroOfficioPeticion() {
		return this.numeroOfficioPeticion;
	}

	public void setNumeroOfficioPeticion(String numeroOfficioPeticion) {
		this.numeroOfficioPeticion = numeroOfficioPeticion;
	}

	public String getOficioColaboracion() {
		return this.oficioColaboracion;
	}

	public void setOficioColaboracion(String oficioColaboracion) {
		this.oficioColaboracion = oficioColaboracion;
	}

	public String getUsuarioActualiza() {
		return this.usuarioActualiza;
	}

	public void setUsuarioActualiza(String usuarioActualiza) {
		this.usuarioActualiza = usuarioActualiza;
	}

	public String getUsuarioAlta() {
		return this.usuarioAlta;
	}

	public void setUsuarioAlta(String usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}

	public CatEstatusColaboracion getCatEstatusColaboracion() {
		return this.catEstatusColaboracion;
	}

	public void setCatEstatusColaboracion(CatEstatusColaboracion catEstatusColaboracion) {
		this.catEstatusColaboracion = catEstatusColaboracion;
	}

	public CatInstitucion getCatInstitucion() {
		return this.catInstitucion;
	}

	public void setCatInstitucion(CatInstitucion catInstitucion) {
		this.catInstitucion = catInstitucion;
	}


}