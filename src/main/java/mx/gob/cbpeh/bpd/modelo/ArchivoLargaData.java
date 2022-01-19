package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the archivo_larga_data database table.
 * 
 */
@Entity
@Table(name="archivo_larga_data")
public class ArchivoLargaData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_archivo_larga_data")
	private int idArchivoLargaData;

	@Lob
	private byte[] archivo;

	@Column(name="archivo_descripcion")
	private String archivoDescripcion;

	@Column(name="estatus_archivo_larga_data")
	private byte estatusArchivoLargaData;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualiza")
	private Date fechaActualiza;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_carga")
	private Date fechaCarga;

	@Column(name="hora_carga")
	private Time horaCarga;

	/*@Column(name="id_busqueda")
	private int idBusqueda;

	@Column(name="id_perfil_carga")
	private byte idPerfilCarga;*/

	@Column(name="id_tipo_archivo")
	private byte idTipoArchivo;

	@Column(name="id_usuario_actualiza")
	private String idUsuarioActualiza;

	@Column(name="id_usuario_carga")
	private String idUsuarioCarga;

	@Column(name="nombre_archivo")
	private String nombreArchivo;

	//bi-directional many-to-one association to BusquedaLargaData
	@ManyToOne
	@JoinColumn(name="id_busqueda_larga_data")
	private BusquedaLargaData busquedaLargaData;

	public ArchivoLargaData() {
	}

	public int getIdArchivoLargaData() {
		return this.idArchivoLargaData;
	}

	public void setIdArchivoLargaData(int idArchivoLargaData) {
		this.idArchivoLargaData = idArchivoLargaData;
	}

	public byte[] getArchivo() {
		return this.archivo;
	}

	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}

	public String getArchivoDescripcion() {
		return this.archivoDescripcion;
	}

	public void setArchivoDescripcion(String archivoDescripcion) {
		this.archivoDescripcion = archivoDescripcion;
	}

	public byte getEstatusArchivoLargaData() {
		return this.estatusArchivoLargaData;
	}

	public void setEstatusArchivoLargaData(byte estatusArchivoLargaData) {
		this.estatusArchivoLargaData = estatusArchivoLargaData;
	}

	public Date getFechaActualiza() {
		return this.fechaActualiza;
	}

	public void setFechaActualiza(Date fechaActualiza) {
		this.fechaActualiza = fechaActualiza;
	}

	public Date getFechaCarga() {
		return this.fechaCarga;
	}

	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	public Time getHoraCarga() {
		return this.horaCarga;
	}

	public void setHoraCarga(Time horaCarga) {
		this.horaCarga = horaCarga;
	}



	public byte getIdTipoArchivo() {
		return this.idTipoArchivo;
	}

	public void setIdTipoArchivo(byte idTipoArchivo) {
		this.idTipoArchivo = idTipoArchivo;
	}

	public String getIdUsuarioActualiza() {
		return this.idUsuarioActualiza;
	}

	public void setIdUsuarioActualiza(String idUsuarioActualiza) {
		this.idUsuarioActualiza = idUsuarioActualiza;
	}

	public String getIdUsuarioCarga() {
		return this.idUsuarioCarga;
	}

	public void setIdUsuarioCarga(String idUsuarioCarga) {
		this.idUsuarioCarga = idUsuarioCarga;
	}

	public String getNombreArchivo() {
		return this.nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public BusquedaLargaData getBusquedaLargaData() {
		return this.busquedaLargaData;
	}

	public void setBusquedaLargaData(BusquedaLargaData busquedaLargaData) {
		this.busquedaLargaData = busquedaLargaData;
	}

}