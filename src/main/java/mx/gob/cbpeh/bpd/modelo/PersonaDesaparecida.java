package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="persona_desaparecida")
public class PersonaDesaparecida  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_persona_desaparecida")
	private int idPersonaDesaparecida;

	@Column(name="a_donde_iba")
	private String aDondeIba;

	@Column(name="actitud_extrania")
	private String actitudExtrania;

	private String adiccion;

	private String amaterno;

	private String apaterno;

	private String calle;

	@Column(name="con_quien_habita")
	private String conQuienHabita;

	@Column(name="contrasenia_correo")
	private String contraseniaCorreo;

	@Column(name="contrasenia_facebook")
	private String contraseniaFacebook;

	@Column(name="contrasenia_instagram")
	private String contraseniaInstagram;

	@Column(name="contrasenia_twitter")
	private String contraseniaTwitter;

	@Column(name="correo_electronico")
	private String correoElectronico;

	private String curp;

	@Column(name="descripcion_cabello")
	private String descripcionCabello;

	@Column(name="descripcion_ojo")
	private String detalleOjo;

	@Column(name="detalle_comunicacion")
	private String detalleComunicacion;

	@Column(name="detalle_dejo_documento")
	private String detalleDejoDocumento;

	@Column(name="detalle_dentadura")
	private String detalleDentadura;

	@Column(name="detalle_documento")
	private String detalleDocumento;

	@Column(name="detalle_falta_a_casa")
	private String detalleFaltaACasa;

	@Column(name="detalle_fractura")
	private String detalleFractura;

	@Column(name="detalle_hijos")
	private String detalleHijos;

	@Column(name="detalle_operacion")
	private String detalleOperacion;

	@Column(name="detalle_padecimiento")
	private String detallePadecimiento;

	@Column(name="detalle_transporte")
	private String detalleTransporte;

	@Column(name="detalle_violencia")
	private String detalleViolencia;

	private Integer difusion;

	private String enemistad;
	
	@Column(name="estatura")
	private Float estatura;

	private String facebook;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_alta")
	private Date fechaAlta;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_desaparcion")
	private Date fechaDesaparcion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ultimo_contacto")
	private Date fechaUltimoContacto;

	@Lob
	@Column(name="foto_persona")
	private byte[] fotoPersona;

	private String hechos;

	private String instragram;

	@Column(name="lugar_frecuente")
	private String lugarFrecuente;

	private String nombre;

	@Column(name="padecimiento_discapacidad")
	private Integer padecimientoDiscapacidad;

	private String pasatiempo;

	private Float peso;

	private String rfc;

	@Column(name="senia_particular")
	private String seniaParticular;

	private String sospecho;

	private String twitter;

	private String vestimenta;

	//bi-directional many-to-one association to CatBaseNariz
	@ManyToOne
	@JoinColumn(name="id_base_nariz")
	private CatBaseNariz catBaseNariz;

	//bi-directional many-to-one association to CatBoca
	@ManyToOne
	@JoinColumn(name="id_boca")
	private CatBoca catBoca;

	//bi-directional many-to-one association to CatColonia
	@ManyToOne
	@JoinColumn(name="id_colonia")
	private CatColonia catColonia;

	//bi-directional many-to-one association to CatColorCabello
	@ManyToOne
	@JoinColumn(name="id_color_cabello")
	private CatColorCabello catColorCabello;

	//bi-directional many-to-one association to CatColorOjo
	@ManyToOne
	@JoinColumn(name="id_color_ojo")
	private CatColorOjo catColorOjo;

	//bi-directional many-to-one association to CatComplexion
	@ManyToOne
	@JoinColumn(name="id_complexion")
	private CatComplexion catComplexion;

	//bi-directional many-to-one association to CatCp
	@ManyToOne
	@JoinColumn(name="id_cp")
	private CatCp catCp;

	//bi-directional many-to-one association to CatDentadura
	@ManyToOne
	@JoinColumn(name="id_dentadura")
	private CatDentadura catDentadura;

	//bi-directional many-to-one association to CatDialecto
	@ManyToOne
	@JoinColumn(name="id_dialecto")
	private CatDialecto catDialecto;

	//bi-directional many-to-one association to CatEdad
	@ManyToOne
	@JoinColumn(name="id_edad")
	private CatEdad catEdad;

	//bi-directional many-to-one association to CatEstado
	@ManyToOne
	@JoinColumn(name="id_estado")
	private CatEstado catEstado;

	//bi-directional many-to-one association to CatEstadoCivil
	@ManyToOne
	@JoinColumn(name="id_estado_civil")
	private CatEstadoCivil catEstadoCivil;

	//bi-directional many-to-one association to CatEstatus
	@ManyToOne
	@JoinColumn(name="estatus_persona_desaparecida")
	private CatEstatus catEstatus;

	//bi-directional many-to-one association to CatEstatusEconomico
	@ManyToOne
	@JoinColumn(name="id_estatus_economico")
	private CatEstatusEconomico catEstatusEconomico;

	//bi-directional many-to-one association to CatFormaNariz
	@ManyToOne
	@JoinColumn(name="id_forma_nariz")
	private CatFormaNariz catFormaNariz;

	//bi-directional many-to-one association to CatFrente
	@ManyToOne
	@JoinColumn(name="id_frente")
	private CatFrente catFrente;

	//bi-directional many-to-one association to CatGenero
	@ManyToOne
	@JoinColumn(name="id_genero")
	private CatGenero catGenero;

	//bi-directional many-to-one association to CatGrupoEtnico
	@ManyToOne
	@JoinColumn(name="id_grupo_etnico")
	private CatGrupoEtnico catGrupoEtnico;

	//bi-directional many-to-one association to CatLabio
	@ManyToOne
	@JoinColumn(name="id_labio")
	private CatLabio catLabio;

	//bi-directional many-to-one association to CatLogitudCabello
	@ManyToOne
	@JoinColumn(name="id_longitud_cabello")
	private CatLongitudCabello catLogitudCabello;

	//bi-directional many-to-one association to CatLugar
	@ManyToOne
	@JoinColumn(name="id_lugar_desaparicion")
	private CatLugar catLugar;

	//bi-directional many-to-one association to CatMedioContacto
	@ManyToOne
	@JoinColumn(name="ultimo_medio_contacto")
	private CatMedioContacto catMedioContacto;

	//bi-directional many-to-one association to CatMunicipio
	@ManyToOne
	@JoinColumn(name="id_municipio")
	private CatMunicipio catMunicipio;

	//bi-directional many-to-one association to CatNacionalidad
	@ManyToOne
	@JoinColumn(name="id_nacionalidad")
	private CatNacionalidad catNacionalidad;

	//bi-directional many-to-one association to CatOcupacion
	@ManyToOne
	@JoinColumn(name="id_ocupacion")
	private CatOcupacion catOcupacion;

	//bi-directional many-to-one association to CatParentesco
	@ManyToOne
	@JoinColumn(name="persona_vio_ultima_vez")
	private CatParentesco catParentesco;

	//bi-directional many-to-one association to CatPeriodicidad
	@ManyToOne
	@JoinColumn(name="id_periodicidad")
	private CatPeriodicidad catPeriodicidad;

	//bi-directional many-to-one association to CatSexo
	@ManyToOne
	@JoinColumn(name="id_sexo")
	private CatSexo catSexo;

	//bi-directional many-to-one association to CatSiNo
	@ManyToOne
	@JoinColumn(name="tiene_hijos")
	private CatSiNo hijos;

	//bi-directional many-to-one association to CatSiNo
	@ManyToOne
	@JoinColumn(name="correo_yo_red_social")
	private CatSiNo correos;

	//bi-directional many-to-one association to CatSiNo
	@ManyToOne
	@JoinColumn(name="consta_hecho")
	private CatSiNo consta;

	//bi-directional many-to-one association to CatSiNo
	@ManyToOne
	@JoinColumn(name="dejo_documento")
	private CatSiNo dejoDocumento;

	//bi-directional many-to-one association to CatSiNo
	@ManyToOne
	@JoinColumn(name="falta_a_casa")
	private CatSiNo faltas;

	//bi-directional many-to-one association to CatSiNo
	@ManyToOne
	@JoinColumn(name="tiene_fractura")
	private CatSiNo fracturas;

	//bi-directional many-to-one association to CatSiNo
//	@ManyToOne
//	@JoinColumn(name="tiene_hijos")
//	private CatSiNo catSiNo7;

	//bi-directional many-to-one association to CatSiNo
	@ManyToOne
	@JoinColumn(name="hubo_antecedente")
	private CatSiNo antedentes;

	//bi-directional many-to-one association to CatSiNo
	@ManyToOne
	@JoinColumn(name="llevo_documento")
	private CatSiNo llevoDocumento;

	//bi-directional many-to-one association to CatSiNo
	@ManyToOne
	@JoinColumn(name="tiene_operacion")
	private CatSiNo operaciones;

	//bi-directional many-to-one association to CatSiNo
	@ManyToOne
	@JoinColumn(name="presento_violencia")
	private CatSiNo violencia;

	//bi-directional many-to-one association to CatTamanioNariz
	@ManyToOne
	@JoinColumn(name="id_tamanio_nariz")
	private CatTamanioNariz catTamanioNariz;

	//bi-directional many-to-one association to CatTez
	@ManyToOne
	@JoinColumn(name="id_tez")
	private CatTez catTez;

	//bi-directional many-to-one association to CatTipoCabello
	@ManyToOne
	@JoinColumn(name="id_tipo_cabello")
	private CatTipoCabello catTipoCabello;

	//bi-directional many-to-one association to CatTipoOjo
	@ManyToOne
	@JoinColumn(name="id_tipo_ojo")
	private CatTipoOjo catTipoOjo;

	//bi-directional many-to-one association to CatTipoSangre
	@ManyToOne
	@JoinColumn(name="id_tipo_sangre")
	private CatTipoSangre catTipoSangre;

	//bi-directional many-to-one association to CatTransporte
	@ManyToOne
	@JoinColumn(name="transporte_frecuente")
	private CatTransporte catTransporte;

	//bi-directional many-to-one association to PersonaReporta
	@ManyToOne
	@JoinColumn(name="id_persona_reporta")
	private PersonaReporta personaReporta;

	//bi-directional many-to-one association to Usuario
	//@ManyToOne
	@Column(name="id_usuario_actualiza")
	private String idUsuarioActualiza;

	//bi-directional many-to-one association to Usuario
	//@ManyToOne
	@Column(name="id_usuario_alta")
	private String idUsuarioAlta;

	public PersonaDesaparecida() {
	}

	public int getIdPersonaDesaparecida() {
		return this.idPersonaDesaparecida;
	}

	public void setIdPersonaDesaparecida(int idPersonaDesaparecida) {
		this.idPersonaDesaparecida = idPersonaDesaparecida;
	}

	public String getADondeIba() {
		return this.aDondeIba;
	}

	public void setADondeIba(String aDondeIba) {
		this.aDondeIba = aDondeIba;
	}

	public String getActitudExtrania() {
		return this.actitudExtrania;
	}

	public void setActitudExtrania(String actitudExtrania) {
		this.actitudExtrania = actitudExtrania;
	}

	public String getAdiccion() {
		return this.adiccion;
	}

	public void setAdiccion(String adiccion) {
		this.adiccion = adiccion;
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

	public String getConQuienHabita() {
		return this.conQuienHabita;
	}

	public void setConQuienHabita(String conQuienHabita) {
		this.conQuienHabita = conQuienHabita;
	}

	public String getContraseniaCorreo() {
		return this.contraseniaCorreo;
	}

	public void setContraseniaCorreo(String contraseniaCorreo) {
		this.contraseniaCorreo = contraseniaCorreo;
	}

	public String getContraseniaFacebook() {
		return this.contraseniaFacebook;
	}

	public void setContraseniaFacebook(String contraseniaFacebook) {
		this.contraseniaFacebook = contraseniaFacebook;
	}

	public String getContraseniaInstagram() {
		return this.contraseniaInstagram;
	}

	public void setContraseniaInstagram(String contraseniaInstagram) {
		this.contraseniaInstagram = contraseniaInstagram;
	}

	public String getContraseniaTwitter() {
		return this.contraseniaTwitter;
	}

	public void setContraseniaTwitter(String contraseniaTwitter) {
		this.contraseniaTwitter = contraseniaTwitter;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getCurp() {
		return this.curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getDescripcionCabello() {
		return this.descripcionCabello;
	}

	public void setDescripcionCabello(String descripcionCabello) {
		this.descripcionCabello = descripcionCabello;
	}

	public String getDetalleComunicacion() {
		return this.detalleComunicacion;
	}

	public void setDetalleComunicacion(String detalleComunicacion) {
		this.detalleComunicacion = detalleComunicacion;
	}

	public String getDetalleDejoDocumento() {
		return this.detalleDejoDocumento;
	}

	public void setDetalleDejoDocumento(String detalleDejoDocumento) {
		this.detalleDejoDocumento = detalleDejoDocumento;
	}

	public String getDetalleDentadura() {
		return this.detalleDentadura;
	}

	public void setDetalleDentadura(String detalleDentadura) {
		this.detalleDentadura = detalleDentadura;
	}

	public String getDetalleDocumento() {
		return this.detalleDocumento;
	}

	public void setDetalleDocumento(String detalleDocumento) {
		this.detalleDocumento = detalleDocumento;
	}

	public String getDetalleFaltaACasa() {
		return this.detalleFaltaACasa;
	}

	public void setDetalleFaltaACasa(String detalleFaltaACasa) {
		this.detalleFaltaACasa = detalleFaltaACasa;
	}

	public String getDetalleFractura() {
		return this.detalleFractura;
	}

	public void setDetalleFractura(String detalleFractura) {
		this.detalleFractura = detalleFractura;
	}

	public String getDetalleHijos() {
		return this.detalleHijos;
	}

	public void setDetalleHijos(String detalleHijos) {
		this.detalleHijos = detalleHijos;
	}

	public String getDetalleOperacion() {
		return this.detalleOperacion;
	}

	public void setDetalleOperacion(String detalleOperacion) {
		this.detalleOperacion = detalleOperacion;
	}

	public String getDetallePadecimiento() {
		return this.detallePadecimiento;
	}

	public void setDetallePadecimiento(String detallePadecimiento) {
		this.detallePadecimiento = detallePadecimiento;
	}

	public String getDetalleTransporte() {
		return this.detalleTransporte;
	}

	public void setDetalleTransporte(String detalleTransporte) {
		this.detalleTransporte = detalleTransporte;
	}

	public String getDetalleViolencia() {
		return this.detalleViolencia;
	}

	public void setDetalleViolencia(String detalleViolencia) {
		this.detalleViolencia = detalleViolencia;
	}

	public Integer getDifusion() {
		return this.difusion;
	}

	public void setDifusion(Integer difusion) {
		this.difusion = difusion;
	}

	public String getEnemistad() {
		return this.enemistad;
	}

	public void setEnemistad(String enemistad) {
		this.enemistad = enemistad;
	}

	public Float getEstatura() {
		return this.estatura;
	}

	public void setEstatura(Float estatura) {
		this.estatura = estatura;
	}

	public String getFacebook() {
		return this.facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaDesaparcion() {
		return this.fechaDesaparcion;
	}

	public void setFechaDesaparcion(Date fechaDesaparcion) {
		this.fechaDesaparcion = fechaDesaparcion;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaUltimoContacto() {
		return this.fechaUltimoContacto;
	}

	public void setFechaUltimoContacto(Date fechaUltimoContacto) {
		this.fechaUltimoContacto = fechaUltimoContacto;
	}

	public byte[] getFotoPersona() {
		return this.fotoPersona;
	}

	public void setFotoPersona(byte[] fotoPersona) {
		this.fotoPersona = fotoPersona;
	}

	public String getHechos() {
		return this.hechos;
	}

	public void setHechos(String hechos) {
		this.hechos = hechos;
	}

	public String getInstragram() {
		return this.instragram;
	}

	public void setInstragram(String instragram) {
		this.instragram = instragram;
	}

	public String getLugarFrecuente() {
		return this.lugarFrecuente;
	}

	public void setLugarFrecuente(String lugarFrecuente) {
		this.lugarFrecuente = lugarFrecuente;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPadecimientoDiscapacidad() {
		return this.padecimientoDiscapacidad;
	}

	public void setPadecimientoDiscapacidad(Integer padecimientoDiscapacidad) {
		this.padecimientoDiscapacidad = padecimientoDiscapacidad;
	}

	public String getPasatiempo() {
		return this.pasatiempo;
	}

	public void setPasatiempo(String pasatiempo) {
		this.pasatiempo = pasatiempo;
	}

	public Float getPeso() {
		return this.peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public String getRfc() {
		return this.rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getSeniaParticular() {
		return this.seniaParticular;
	}

	public void setSeniaParticular(String seniaParticular) {
		this.seniaParticular = seniaParticular;
	}

	public String getSospecho() {
		return this.sospecho;
	}

	public void setSospecho(String sospecho) {
		this.sospecho = sospecho;
	}

	public String getTwitter() {
		return this.twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getVestimenta() {
		return this.vestimenta;
	}

	public void setVestimenta(String vestimenta) {
		this.vestimenta = vestimenta;
	}

	public CatBaseNariz getCatBaseNariz() {
		return this.catBaseNariz;
	}

	public void setCatBaseNariz(CatBaseNariz catBaseNariz) {
		this.catBaseNariz = catBaseNariz;
	}

	public CatBoca getCatBoca() {
		return this.catBoca;
	}

	public void setCatBoca(CatBoca catBoca) {
		this.catBoca = catBoca;
	}

	public CatColonia getCatColonia() {
		return this.catColonia;
	}

	public void setCatColonia(CatColonia catColonia) {
		this.catColonia = catColonia;
	}

	public CatColorCabello getCatColorCabello() {
		return this.catColorCabello;
	}

	public void setCatColorCabello(CatColorCabello catColorCabello) {
		this.catColorCabello = catColorCabello;
	}

	public CatColorOjo getCatColorOjo() {
		return this.catColorOjo;
	}

	public void setCatColorOjo(CatColorOjo catColorOjo) {
		this.catColorOjo = catColorOjo;
	}

	public CatComplexion getCatComplexion() {
		return this.catComplexion;
	}

	public void setCatComplexion(CatComplexion catComplexion) {
		this.catComplexion = catComplexion;
	}

	public CatCp getCatCp() {
		return this.catCp;
	}

	public void setCatCp(CatCp catCp) {
		this.catCp = catCp;
	}

	public CatDentadura getCatDentadura() {
		return this.catDentadura;
	}

	public void setCatDentadura(CatDentadura catDentadura) {
		this.catDentadura = catDentadura;
	}

	public CatDialecto getCatDialecto() {
		return this.catDialecto;
	}

	public void setCatDialecto(CatDialecto catDialecto) {
		this.catDialecto = catDialecto;
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

	public CatEstadoCivil getCatEstadoCivil() {
		return this.catEstadoCivil;
	}

	public void setCatEstadoCivil(CatEstadoCivil catEstadoCivil) {
		this.catEstadoCivil = catEstadoCivil;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

	public CatEstatusEconomico getCatEstatusEconomico() {
		return this.catEstatusEconomico;
	}

	public void setCatEstatusEconomico(CatEstatusEconomico catEstatusEconomico) {
		this.catEstatusEconomico = catEstatusEconomico;
	}

	public CatFormaNariz getCatFormaNariz() {
		return this.catFormaNariz;
	}

	public void setCatFormaNariz(CatFormaNariz catFormaNariz) {
		this.catFormaNariz = catFormaNariz;
	}

	public CatFrente getCatFrente() {
		return this.catFrente;
	}

	public void setCatFrente(CatFrente catFrente) {
		this.catFrente = catFrente;
	}

	public CatGenero getCatGenero() {
		return this.catGenero;
	}

	public void setCatGenero(CatGenero catGenero) {
		this.catGenero = catGenero;
	}

	public CatGrupoEtnico getCatGrupoEtnico() {
		return this.catGrupoEtnico;
	}

	public void setCatGrupoEtnico(CatGrupoEtnico catGrupoEtnico) {
		this.catGrupoEtnico = catGrupoEtnico;
	}

	public CatLabio getCatLabio() {
		return this.catLabio;
	}

	public void setCatLabio(CatLabio catLabio) {
		this.catLabio = catLabio;
	}

	public CatLongitudCabello getCatLongitudCabello() {
		return this.catLogitudCabello;
	}

	public void setCatLongitudCabello(CatLongitudCabello catLongitudCabello) {
		this.catLogitudCabello = catLongitudCabello;
	}

	public CatLugar getCatLugar() {
		return this.catLugar;
	}

	public void setCatLugar(CatLugar catLugar) {
		this.catLugar = catLugar;
	}

	public CatMedioContacto getCatMedioContacto() {
		return this.catMedioContacto;
	}

	public void setCatMedioContacto(CatMedioContacto catMedioContacto) {
		this.catMedioContacto = catMedioContacto;
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

	public CatPeriodicidad getCatPeriodicidad() {
		return this.catPeriodicidad;
	}

	public void setCatPeriodicidad(CatPeriodicidad catPeriodicidad) {
		this.catPeriodicidad = catPeriodicidad;
	}

	public CatSexo getCatSexo() {
		return this.catSexo;
	}

	public void setCatSexo(CatSexo catSexo) {
		this.catSexo = catSexo;
	}
	
	public CatSiNo getHijos() {
		return hijos;
	}

	public void setHijos(CatSiNo hijos) {
		this.hijos = hijos;
	}

	public CatSiNo getCorreos() {
		return correos;
	}

	public void setCorreos(CatSiNo correos) {
		this.correos = correos;
	}

	public String getaDondeIba() {
		return aDondeIba;
	}

	public void setaDondeIba(String aDondeIba) {
		this.aDondeIba = aDondeIba;
	}

	public CatLongitudCabello getCatLogitudCabello() {
		return catLogitudCabello;
	}

	public void setCatLogitudCabello(CatLongitudCabello catLogitudCabello) {
		this.catLogitudCabello = catLogitudCabello;
	}

	public CatSiNo getConsta() {
		return consta;
	}

	public void setConsta(CatSiNo consta) {
		this.consta = consta;
	}

	public CatSiNo getDejoDocumento() {
		return dejoDocumento;
	}

	public void setDejoDocumento(CatSiNo dejoDocumento) {
		this.dejoDocumento = dejoDocumento;
	}

	public CatSiNo getFaltas() {
		return faltas;
	}

	public void setFaltas(CatSiNo faltas) {
		this.faltas = faltas;
	}

	public CatSiNo getFracturas() {
		return fracturas;
	}

	public void setFracturas(CatSiNo fracturas) {
		this.fracturas = fracturas;
	}

	public CatSiNo getAntedentes() {
		return antedentes;
	}

	public void setAntedentes(CatSiNo antedentes) {
		this.antedentes = antedentes;
	}

	public CatSiNo getLlevoDocumento() {
		return llevoDocumento;
	}

	public void setLlevoDocumento(CatSiNo llevoDocumento) {
		this.llevoDocumento = llevoDocumento;
	}

	public CatSiNo getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(CatSiNo operaciones) {
		this.operaciones = operaciones;
	}

	public CatSiNo getViolencia() {
		return violencia;
	}

	public void setViolencia(CatSiNo violencia) {
		this.violencia = violencia;
	}	

	public CatTamanioNariz getCatTamanioNariz() {
		return this.catTamanioNariz;
	}

	public void setCatTamanioNariz(CatTamanioNariz catTamanioNariz) {
		this.catTamanioNariz = catTamanioNariz;
	}

	public CatTez getCatTez() {
		return this.catTez;
	}

	public void setCatTez(CatTez catTez) {
		this.catTez = catTez;
	}

	public CatTipoCabello getCatTipoCabello() {
		return this.catTipoCabello;
	}

	public void setCatTipoCabello(CatTipoCabello catTipoCabello) {
		this.catTipoCabello = catTipoCabello;
	}

	public CatTipoOjo getCatTipoOjo() {
		return this.catTipoOjo;
	}

	public void setCatTipoOjo(CatTipoOjo catTipoOjo) {
		this.catTipoOjo = catTipoOjo;
	}

	public CatTipoSangre getCatTipoSangre() {
		return this.catTipoSangre;
	}

	public void setCatTipoSangre(CatTipoSangre catTipoSangre) {
		this.catTipoSangre = catTipoSangre;
	}

	public CatTransporte getCatTransporte() {
		return this.catTransporte;
	}

	public void setCatTransporte(CatTransporte catTransporte) {
		this.catTransporte = catTransporte;
	}

	public PersonaReporta getPersonaReporta() {
		return this.personaReporta;
	}

	public void setPersonaReporta(PersonaReporta personaReporta) {
		this.personaReporta = personaReporta;
	}

	public String getIdUsuarioActualiza() {
		return this.idUsuarioActualiza;
	}

	public void setIdUsuarioActualiza(String usuario1) {
		this.idUsuarioActualiza = usuario1;
	}

	public String getIdUsuarioAlta() {
		return this.idUsuarioAlta;
	}

	public void setIdUsuarioAlta(String usuario2) {
		this.idUsuarioAlta = usuario2;
	}

	public String getDetalleOjo() {
		return detalleOjo;
	}

	public void setDetalleOjo(String detalleOjo) {
		this.detalleOjo = detalleOjo;
	}
}