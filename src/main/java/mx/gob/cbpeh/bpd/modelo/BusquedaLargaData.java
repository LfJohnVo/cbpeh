package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the busqueda_larga_data database table.
 * 
 */
@Entity
@Table(name="busqueda_larga_data")
public class BusquedaLargaData  {
	
	@Id
	@Column(name="id_busqueda_larga_data")
	private String idBusquedaLargaData;

	private String calle;

	@Column(name="estatus_busqueda_larga_data")
	private byte estatusBusquedaLargaData;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualiza")
	private Date fechaActualiza;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_alta")
	private Date fechaAlta;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_busqueda")
	private Date fechaBusqueda;

	@ManyToOne
	@JoinColumn(name="id_colonia")
	private CatColonia catColonia;

	@ManyToOne
	@JoinColumn(name="id_cp")
	private CatCp catCp;

	@Column(name="id_estatus_localizado")
	private byte idEstatusLocalizado;

	@ManyToOne
	@JoinColumn(name="id_municipio")
	private CatMunicipio catMunicipio;

	@Column(name="id_usuario_actualiza")
	private String idUsuarioActualiza;

	@Column(name="id_usuario_alta")
	private String idUsuarioAlta;

	private float latitud;

	private float longitud;

	private String resenia;

	//bi-directional many-to-one association to ArchivoLargaData
	@OneToMany(mappedBy="busquedaLargaData")
	private List<ArchivoLargaData> archivoLargaData;

	//bi-directional many-to-one association to BusquedaLargaDataExpediente
	@OneToMany(mappedBy="busquedaLargaData")
	private List<BusquedaLargaDataExpediente> busquedaLargaDataExpedientes;

	public BusquedaLargaData() {
	}

	public String getIdBusquedaLargaData() {
		return this.idBusquedaLargaData;
	}

	public void setIdBusquedaLargaData(String idBusquedaLargaData) {
		this.idBusquedaLargaData = idBusquedaLargaData;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public byte getEstatusBusquedaLargaData() {
		return this.estatusBusquedaLargaData;
	}

	public void setEstatusBusquedaLargaData(byte estatusBusquedaLargaData) {
		this.estatusBusquedaLargaData = estatusBusquedaLargaData;
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

	public Date getFechaBusqueda() {
		return this.fechaBusqueda;
	}

	public void setFechaBusqueda(Date fechaBusqueda) {
		this.fechaBusqueda = fechaBusqueda;
	}

	public CatColonia getCatColonia() {
		return catColonia;
	}

	public void setCatColonia(CatColonia catColonia) {
		this.catColonia = catColonia;
	}

	public byte getIdEstatusLocalizado() {
		return this.idEstatusLocalizado;
	}

	public void setIdEstatusLocalizado(byte idEstatusLocalizado) {
		this.idEstatusLocalizado = idEstatusLocalizado;
	}

	public CatMunicipio getCatMunicipio() {
		return catMunicipio;
	}

	public void setCatMunicipio(CatMunicipio catMunicipio) {
		this.catMunicipio = catMunicipio;
	}

	public String getIdUsuarioActualiza() {
		return this.idUsuarioActualiza;
	}

	public void setIdUsuarioActualiza(String idUsuarioActualiza) {
		this.idUsuarioActualiza = idUsuarioActualiza;
	}

	public String getIdUsuarioAlta() {
		return this.idUsuarioAlta;
	}

	public void setIdUsuarioAlta(String idUsuarioAlta) {
		this.idUsuarioAlta = idUsuarioAlta;
	}

	public float getLatitud() {
		return this.latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return this.longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public String getResenia() {
		return this.resenia;
	}

	public void setResenia(String resenia) {
		this.resenia = resenia;
	}

	public CatCp getCatCp() {
		return catCp;
	}

	public void setCatCp(CatCp catCp) {
		this.catCp = catCp;
	}

	public List<ArchivoLargaData> getArchivoLargaData() {
		return this.archivoLargaData;
	}

	public void setArchivoLargaData(List<ArchivoLargaData> archivoLargaData) {
		this.archivoLargaData = archivoLargaData;
	}

	public ArchivoLargaData addArchivoLargaData(ArchivoLargaData archivoLargaData) {
		getArchivoLargaData().add(archivoLargaData);
		archivoLargaData.setBusquedaLargaData(this);

		return archivoLargaData;
	}

	public ArchivoLargaData removeArchivoLargaData(ArchivoLargaData archivoLargaData) {
		getArchivoLargaData().remove(archivoLargaData);
		archivoLargaData.setBusquedaLargaData(null);

		return archivoLargaData;
	}

	public List<BusquedaLargaDataExpediente> getBusquedaLargaDataExpedientes() {
		return this.busquedaLargaDataExpedientes;
	}

	public void setBusquedaLargaDataExpedientes(List<BusquedaLargaDataExpediente> busquedaLargaDataExpedientes) {
		this.busquedaLargaDataExpedientes = busquedaLargaDataExpedientes;
	}

	public BusquedaLargaDataExpediente addBusquedaLargaDataExpediente(BusquedaLargaDataExpediente busquedaLargaDataExpediente) {
		getBusquedaLargaDataExpedientes().add(busquedaLargaDataExpediente);
		busquedaLargaDataExpediente.setBusquedaLargaData(this);

		return busquedaLargaDataExpediente;
	}

	public BusquedaLargaDataExpediente removeBusquedaLargaDataExpediente(BusquedaLargaDataExpediente busquedaLargaDataExpediente) {
		getBusquedaLargaDataExpedientes().remove(busquedaLargaDataExpediente);
		busquedaLargaDataExpediente.setBusquedaLargaData(null);

		return busquedaLargaDataExpediente;
	}

}