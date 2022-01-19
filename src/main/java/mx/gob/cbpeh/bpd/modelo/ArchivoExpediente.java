package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


@Entity
@Table(name="archivo_expediente")
public class ArchivoExpediente  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_archivo_expediente")
	private int idArchivoExpediente;

	@Lob
	private byte[] archivo;

	@Column(name="fecha_actualiza")
	private String fechaActualiza;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_carga")
	private Date fechaCarga;

	@Column(name="hora_carga")
	private Time horaCarga;

	@Column(name="id_busqueda")
	private int idBusqueda;

	@Column(name="id_usuario_actualiza")
	private String idUsuarioActualiza;

	@Column(name="nombre_archivo")
	private String nombreArchivo;
	
	@Column(name="archivo_descripcion")
	private String archivoDescripcion;

	/*@ManyToOne
	@JoinColumn(name="estatus_expediente")*/
	@Column(name="estatus_expediente")
	private int idEstatusExpediente;

	@ManyToOne
	@JoinColumn(name="id_tipo_archivo")
	private CatTipoArchivo catTipoArchivo;

	/*@ManyToOne
	@JoinColumn(name="id_expediente")*/
	@Column(name="id_expediente")
	private String idExpediente;

	/*@ManyToOne
	@JoinColumn(name="id_perfil_carga") */
	@Column(name="id_perfil_carga")
	private int idPerfilCarga;

	/*@ManyToOne
	@JoinColumn(name="")*/
	@Column(name="id_usuario_carga")
	private String idUsuarioCarga;

	public int getIdArchivoExpediente() {
		return idArchivoExpediente;
	}

	public void setIdArchivoExpediente(int idArchivoExpediente) {
		this.idArchivoExpediente = idArchivoExpediente;
	}

	public byte[] getArchivo() {
		return archivo;
	}

	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}

	public String getFechaActualiza() {
		return fechaActualiza;
	}

	public void setFechaActualiza(String fechaActualiza) {
		this.fechaActualiza = fechaActualiza;
	}

	public Date getFechaCarga() {
		return fechaCarga;
	}

	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	public Time getHoraCarga() {
		return horaCarga;
	}

	public void setHoraCarga(Time horaCarga) {
		this.horaCarga = horaCarga;
	}

	public int getIdBusqueda() {
		return idBusqueda;
	}

	public void setIdBusqueda(int idBusqueda) {
		this.idBusqueda = idBusqueda;
	}

	public String getIdUsuarioActualiza() {
		return idUsuarioActualiza;
	}

	public void setIdUsuarioActualiza(String idUsuarioActualiza) {
		this.idUsuarioActualiza = idUsuarioActualiza;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getArchivoDescripcion() {
		return archivoDescripcion;
	}

	public void setArchivoDescripcion(String archivoDescripcion) {
		this.archivoDescripcion = archivoDescripcion;
	}

	public int getIdEstatusExpediente() {
		return idEstatusExpediente;
	}

	public void setIdEstatusExpediente(int idEstatusExpediente) {
		this.idEstatusExpediente = idEstatusExpediente;
	}

	public CatTipoArchivo getCatTipoArchivo() {
		return catTipoArchivo;
	}

	public void setCatTipoArchivo(CatTipoArchivo catTipoArchivo) {
		this.catTipoArchivo = catTipoArchivo;
	}

	public String getIdExpediente() {
		return idExpediente;
	}

	public void setIdExpediente(String idExpediente) {
		this.idExpediente = idExpediente;
	}

	public int getIdPerfilCarga() {
		return idPerfilCarga;
	}

	public void setIdPerfilCarga(int idPerfilCarga) {
		this.idPerfilCarga = idPerfilCarga;
	}

	public String getIdUsuarioCarga() {
		return idUsuarioCarga;
	}

	public void setIdUsuarioCarga(String idUsuarioCarga) {
		this.idUsuarioCarga = idUsuarioCarga;
	}

}