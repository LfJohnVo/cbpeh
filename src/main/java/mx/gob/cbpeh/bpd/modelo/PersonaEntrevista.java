package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.math.BigInteger;

@Entity
@Table(name="persona_entrevista")
public class PersonaEntrevista  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_entrevista")
	private int idEntrevista;

	@Column(name="alias_apodo")
	private String aliasApodo;

	private String amaterno;

	private String apaterno;

	private String calle;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_alta")
	private Date fechaAlta;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	private Time hora;

	private String nombre;

	@Column(name="relato_entrevista")
	private String relatoEntrevista;

	@Column(name="tatuaje_lunar_marca")
	private String tatuajeLunarMarca;

	private BigInteger tefono;

	@ManyToOne
	@JoinColumn(name="id_colonia")
	private CatColonia catColonia;

	@ManyToOne
	@JoinColumn(name="id_cp")
	private CatCp catCp;

	//@ManyToOne
	//@JoinColumn(name="id_dialecto")
	@Column(name="id_dialecto")
	private Integer idDialecto;

	//@ManyToOne
	//@JoinColumn(name="id_edad")
	@Column(name="id_edad")
	private Integer idEdad;

	//@ManyToOne
	@Column(name="id_escolaridad")
	private Integer idEscolaridad;

	@ManyToOne
	@JoinColumn(name="id_estado")
	private CatEstado catEstado;

	//@ManyToOne
	//@JoinColumn(name="lugar_nacimiento")
	@Column(name="lugar_nacimiento")
	private Integer lugarNacimiento;

	//@ManyToOne
	//@JoinColumn(name="id_estado_civil")
	@Column(name="id_estado_civil")
	private Integer idEstadoCivil;

	//@ManyToOne
	//@JoinColumn(name="estatus_persona_estrevista")
	@Column(name="estatus_persona_estrevista")
	private Integer idEstatus;

	//@ManyToOne
	//@JoinColumn(name="id_ultimo_grado_estudio")
	@Column(name="id_ultimo_grado_estudio")
	private Integer idGradoEstudio;

	//@ManyToOne
	//@JoinColumn(name="id_grupo_etnico")
	@Column(name="id_grupo_etnico")
	private Integer idGrupoEtnico;

	//@ManyToOne
	//@JoinColumn(name="id_idioma")
	@Column(name="id_idioma")
	private Integer idIdioma;

	@ManyToOne
	@JoinColumn(name="id_municipio")
	private CatMunicipio catMunicipio;

	//@ManyToOne
	//@JoinColumn(name="id_nacionalidad")
	@Column(name="id_nacionalidad")
	private Integer idNacionalidad;

	//@ManyToOne
	//@JoinColumn(name="id_ocupacion")
	@Column(name="id_ocupacion")
	private Integer idOcupacion;

	//@ManyToOne
	//@JoinColumn(name="id_parentesco")
	@Column(name="id_parentesco")
	private Integer idParentesco;

	//@ManyToOne
	//@JoinColumn(name="id_sexo")
	@Column(name="id_sexo")
	private Integer idSexo;

	//@ManyToOne
	//@JoinColumn(name="sabe_escribir")
	@Column(name="sabe_escribir")
	private Integer sabeEscribir;

	//@ManyToOne
	//@JoinColumn(name="sabe_leer")
	@Column(name="sabe_leer")
	private Integer sabeLeer;

	//@ManyToOne
	//@JoinColumn(name="id_tipo_identificacion")
	@Column(name="id_tipo_identificacion")
	private Integer idTipoIdentificacion;

	//@ManyToOne
	//@JoinColumn(name="id_expediente")
	@Column(name="id_expediente")
	private String idExpediente;

	@ManyToOne
	@JoinColumn(name="id_usuario_actualiza")
	private Usuario usuario1;

	//@ManyToOne
	//@JoinColumn(name="id_usuario_alta")
	@Column(name="id_usuario_alta")
	private String idUsuarioAlta;

	public PersonaEntrevista() {
	}

	public int getIdEntrevista() {
		return idEntrevista;
	}

	public void setIdEntrevista(int idEntrevista) {
		this.idEntrevista = idEntrevista;
	}

	public String getAliasApodo() {
		return aliasApodo;
	}

	public void setAliasApodo(String aliasApodo) {
		this.aliasApodo = aliasApodo;
	}

	public String getAmaterno() {
		return amaterno;
	}

	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}

	public String getApaterno() {
		return apaterno;
	}

	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRelatoEntrevista() {
		return relatoEntrevista;
	}

	public void setRelatoEntrevista(String relatoEntrevista) {
		this.relatoEntrevista = relatoEntrevista;
	}

	public String getTatuajeLunarMarca() {
		return tatuajeLunarMarca;
	}

	public void setTatuajeLunarMarca(String tatuajeLunarMarca) {
		this.tatuajeLunarMarca = tatuajeLunarMarca;
	}

	public BigInteger getTefono() {
		return tefono;
	}

	public void setTefono(BigInteger tefono) {
		this.tefono = tefono;
	}

	public CatColonia getCatColonia() {
		return catColonia;
	}

	public void setCatColonia(CatColonia catColonia) {
		this.catColonia = catColonia;
	}

	public CatCp getCatCp() {
		return catCp;
	}

	public void setCatCp(CatCp catCp) {
		this.catCp = catCp;
	}

	public Integer getIdDialecto() {
		return idDialecto;
	}

	public void setIdDialecto(Integer idDialecto) {
		this.idDialecto = idDialecto;
	}

	public Integer getIdEdad() {
		return idEdad;
	}

	public void setIdEdad(Integer idEdad) {
		this.idEdad = idEdad;
	}

	public Integer getIdEscolaridad() {
		return idEscolaridad;
	}

	public void setIdEscolaridad(Integer idEscolaridad) {
		this.idEscolaridad = idEscolaridad;
	}

	public CatEstado getCatEstado() {
		return catEstado;
	}

	public void setCatEstado(CatEstado catEstado) {
		this.catEstado = catEstado;
	}

	public Integer getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(Integer lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	public Integer getIdEstadoCivil() {
		return idEstadoCivil;
	}

	public void setIdEstadoCivil(Integer idEstadoCivil) {
		this.idEstadoCivil = idEstadoCivil;
	}

	public Integer getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}

	public Integer getIdGradoEstudio() {
		return idGradoEstudio;
	}

	public void setIdGradoEstudio(Integer idGradoEstudio) {
		this.idGradoEstudio = idGradoEstudio;
	}

	public Integer getIdGrupoEtnico() {
		return idGrupoEtnico;
	}

	public void setIdGrupoEtnico(Integer idGrupoEtnico) {
		this.idGrupoEtnico = idGrupoEtnico;
	}

	public Integer getIdIdioma() {
		return idIdioma;
	}

	public void setIdIdioma(Integer idIdioma) {
		this.idIdioma = idIdioma;
	}

	public CatMunicipio getCatMunicipio() {
		return catMunicipio;
	}

	public void setCatMunicipio(CatMunicipio catMunicipio) {
		this.catMunicipio = catMunicipio;
	}

	public Integer getIdNacionalidad() {
		return idNacionalidad;
	}

	public void setIdNacionalidad(Integer idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}

	public Integer getIdOcupacion() {
		return idOcupacion;
	}

	public void setIdOcupacion(Integer idOcupacion) {
		this.idOcupacion = idOcupacion;
	}

	public Integer getIdParentesco() {
		return idParentesco;
	}

	public void setIdParentesco(Integer idParentesco) {
		this.idParentesco = idParentesco;
	}

	public Integer getIdSexo() {
		return idSexo;
	}

	public void setIdSexo(Integer idSexo) {
		this.idSexo = idSexo;
	}

	public Integer getSabeEscribir() {
		return sabeEscribir;
	}

	public void setSabeEscribir(Integer sabeEscribir) {
		this.sabeEscribir = sabeEscribir;
	}

	public Integer getSabeLeer() {
		return sabeLeer;
	}

	public void setSabeLeer(Integer sabeLeer) {
		this.sabeLeer = sabeLeer;
	}

	public Integer getIdTipoIdentificacion() {
		return idTipoIdentificacion;
	}

	public void setIdTipoIdentificacion(Integer idTipoIdentificacion) {
		this.idTipoIdentificacion = idTipoIdentificacion;
	}

	public String getIdExpediente() {
		return idExpediente;
	}

	public void setIdExpediente(String idExpediente) {
		this.idExpediente = idExpediente;
	}

	public Usuario getUsuario1() {
		return usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public String getIdUsuarioAlta() {
		return idUsuarioAlta;
	}

	public void setIdUsuarioAlta(String idUsuarioAlta) {
		this.idUsuarioAlta = idUsuarioAlta;
	}

	

}