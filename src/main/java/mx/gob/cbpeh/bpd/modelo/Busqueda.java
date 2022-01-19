package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;

//Se agrega nombre de la tabla para evitar errores case sensitiva
@Entity
@Table(name="busqueda")
public class Busqueda  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_busqueda")
	private int idBusqueda;

	private String calle;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualiza")
	private Date fechaActualiza;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_alta")
	private Date fechaAlta;

	
	@Column(name="fecha_busqueda")
	private LocalDate fechaBusqueda;

	private Float latitud;

	private Float longitud;

	private String resenia;

	/*@ManyToOne
	@JoinColumn(name="id_colonia")*/
	@Column(name="id_colonia")
	private Integer idColonia;

	/*@ManyToOne
	@JoinColumn(name="id_cp")*/
	@Column(name="id_cp")
	private Integer idCp;

	/*@ManyToOne
	@JoinColumn(name="estatus_busqueda")*/
	@Column(name="estatus_busqueda")
	private Integer idEstatus;

	/*@ManyToOne
	@JoinColumn(name="id_estatus_localizado")*/
	@Column(name="id_estatus_localizado")
	private Integer idEstatusLocalizado;

	/*@ManyToOne
	@JoinColumn(name="id_estatus_vida")
	private CatEstatusVida idEstatusVida;*/
	@Column(name="id_estatus_vida")
	private Integer idEstatusVida;

	/*@ManyToOne
	@JoinColumn(name="id_municipio")*/
	@Column(name="id_municipio")
	private Integer idMunicipio;

	/*@ManyToOne
	@JoinColumn(name="id_expediente")*/
	@Column(name="id_expediente")
	private String expediente;

	/*@ManyToOne
	@JoinColumn(name="id_usuario_actualiza")*/
	@Column(name="id_usuario_actualiza")
	private String usuarioActualiza;

	/*@ManyToOne
	@JoinColumn(name="id_usuario_alta")*/
	@Column(name="id_usuario_alta")
	private String usuarioAlta;

	public Busqueda() {
	}

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

	public LocalDate getFechaBusqueda() {
		return fechaBusqueda;
	}

	public void setFechaBusqueda(LocalDate fechaBusqueda) {
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

	public Integer getIdColonia() {
		return idColonia;
	}

	public void setIdColonia(Integer idColonia) {
		this.idColonia = idColonia;
	}

	public Integer getIdCp() {
		return idCp;
	}

	public void setIdCp(Integer idCp) {
		this.idCp = idCp;
	}

	public Integer getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
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

	public Integer getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
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