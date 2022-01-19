package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;

@Entity
@Table(name="persona_reporta")
public class PersonaReporta  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_persona_reporta")
	private int idPersonaReporta;

	private String amaterno;

	private String apaterno;

	private String calle;

	@Column(name="correo_electronico")
	private String correoElectronico;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actuzalizacion")
	private Date fechaActuzalizacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_alta")
	private Date fechaAlta;

	@Lob
	private byte[] identificacion;

	private String nombre;
	
	@Column(name="nombre_archivo_identificacion")
	private String nombreArchivoIdentificacion;

	private BigInteger telefono1;

	private BigInteger telefono2;

	@ManyToOne
	@JoinColumn(name="id_colonia")
	private CatColonia catColonia;

	@ManyToOne
	@JoinColumn(name="id_cp")
	private CatCp catCp;

	@ManyToOne
	@JoinColumn(name="id_edad")
	private CatEdad catEdad;

	@ManyToOne
	@JoinColumn(name="id_estado")
	private CatEstado catEstado;

	@ManyToOne
	@JoinColumn(name="estatus_persona_reporta")
	private CatEstatus catEstatus;

	@ManyToOne
	@JoinColumn(name="id_medio_reporte")
	private CatMedioReporte catMedioReporte;

	@ManyToOne
	@JoinColumn(name="id_municipio")
	private CatMunicipio catMunicipio;

	@ManyToOne
	@JoinColumn(name="id_nacionalidad")
	private CatNacionalidad catNacionalidad;

	@ManyToOne
	@JoinColumn(name="id_ocupacion")
	private CatOcupacion catOcupacion;

	@ManyToOne
	@JoinColumn(name="id_parentesco")
	private CatParentesco catParentesco;

	@ManyToOne
	@JoinColumn(name="id_sexo")
	private CatSexo catSexo;

	@ManyToOne
	@JoinColumn(name="acompaniaba_a_reportado")
	private CatSiNo catSiNo;

	@ManyToOne
	@JoinColumn(name="id_tipo_identificacion")
	private CatTipoIdentificacion catTipoIdentificacion;

	//@ManyToOne
	@Column(name="id_usuario_alta")
	private String usuario1;

	//@ManyToOne
	@Column(name="id_usuario_actualiza")
	private String usuario2;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_archivo_identificacion")
	private CatTipoArchivo catTipoArchivo;

	public PersonaReporta() {
	}

	public int getIdPersonaReporta() {
		return this.idPersonaReporta;
	}

	public void setIdPersonaReporta(int idPersonaReporta) {
		this.idPersonaReporta = idPersonaReporta;
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

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Date getFechaActuzalizacion() {
		return this.fechaActuzalizacion;
	}

	public void setFechaActuzalizacion(Date fechaActuzalizacion) {
		this.fechaActuzalizacion = fechaActuzalizacion;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public byte[] getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(byte[] identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigInteger getTelefono1() {
		return this.telefono1;
	}

	public void setTelefono1(BigInteger telefono1) {
		this.telefono1 = telefono1;
	}

	public BigInteger getTelefono2() {
		return this.telefono2;
	}

	public void setTelefono2(BigInteger telefono2) {
		this.telefono2 = telefono2;
	}

	public CatColonia getCatColonia() {
		return this.catColonia;
	}

	public void setCatColonia(CatColonia catColonia) {
		this.catColonia = catColonia;
	}

	public CatCp getCatCp() {
		return this.catCp;
	}

	public void setCatCp(CatCp catCp) {
		this.catCp = catCp;
	}

	public CatEdad getCatEdad() {
		return this.catEdad;
	}

	public void setCatEdad(CatEdad catEdad) {
		this.catEdad = catEdad;
	}

	public CatEstado getCatEstado() {
		return this.catEstado;
	}

	public void setCatEstado(CatEstado catEstado) {
		this.catEstado = catEstado;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

	public CatMedioReporte getCatMedioReporte() {
		return this.catMedioReporte;
	}

	public void setCatMedioReporte(CatMedioReporte catMedioReporte) {
		this.catMedioReporte = catMedioReporte;
	}

	public CatMunicipio getCatMunicipio() {
		return this.catMunicipio;
	}

	public void setCatMunicipio(CatMunicipio catMunicipio) {
		this.catMunicipio = catMunicipio;
	}

	public CatNacionalidad getCatNacionalidad() {
		return this.catNacionalidad;
	}

	public void setCatNacionalidad(CatNacionalidad catNacionalidad) {
		this.catNacionalidad = catNacionalidad;
	}

	public CatOcupacion getCatOcupacion() {
		return this.catOcupacion;
	}

	public void setCatOcupacion(CatOcupacion catOcupacion) {
		this.catOcupacion = catOcupacion;
	}

	public CatParentesco getCatParentesco() {
		return this.catParentesco;
	}

	public void setCatParentesco(CatParentesco catParentesco) {
		this.catParentesco = catParentesco;
	}

	public CatSexo getCatSexo() {
		return this.catSexo;
	}

	public void setCatSexo(CatSexo catSexo) {
		this.catSexo = catSexo;
	}

	public CatSiNo getCatSiNo() {
		return this.catSiNo;
	}

	public void setCatSiNo(CatSiNo catSiNo) {
		this.catSiNo = catSiNo;
	}

	public CatTipoIdentificacion getCatTipoIdentificacion() {
		return this.catTipoIdentificacion;
	}

	public void setCatTipoIdentificacion(CatTipoIdentificacion catTipoIdentificacion) {
		this.catTipoIdentificacion = catTipoIdentificacion;
	}

	public String getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(String usuario1) {
		this.usuario1 = usuario1;
	}

	public String getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(String usuario2) {
		this.usuario2 = usuario2;
	}

	public String getNombreArchivoIdentificacion() {
		return nombreArchivoIdentificacion;
	}

	public void setNombreArchivoIdentificacion(String nombreArchivoIdentificacion) {
		this.nombreArchivoIdentificacion = nombreArchivoIdentificacion;
	}

	public CatTipoArchivo getCatTipoArchivo() {
		return catTipoArchivo;
	}

	public void setCatTipoArchivo(CatTipoArchivo catTipoArchivo) {
		this.catTipoArchivo = catTipoArchivo;
	}

}