package mx.gob.cbpeh.bpd.dto;

import java.util.Date;

import mx.gob.cbpeh.bpd.modelo.CatBaseNariz;
import mx.gob.cbpeh.bpd.modelo.CatBoca;
import mx.gob.cbpeh.bpd.modelo.CatColonia;
import mx.gob.cbpeh.bpd.modelo.CatColorCabello;
import mx.gob.cbpeh.bpd.modelo.CatColorOjo;
import mx.gob.cbpeh.bpd.modelo.CatComplexion;
import mx.gob.cbpeh.bpd.modelo.CatCp;
import mx.gob.cbpeh.bpd.modelo.CatDentadura;
import mx.gob.cbpeh.bpd.modelo.CatDialecto;
import mx.gob.cbpeh.bpd.modelo.CatEdad;
import mx.gob.cbpeh.bpd.modelo.CatEstado;
import mx.gob.cbpeh.bpd.modelo.CatEstadoCivil;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.modelo.CatEstatusEconomico;
import mx.gob.cbpeh.bpd.modelo.CatFormaNariz;
import mx.gob.cbpeh.bpd.modelo.CatFrente;
import mx.gob.cbpeh.bpd.modelo.CatGenero;
import mx.gob.cbpeh.bpd.modelo.CatGrupoEtnico;
import mx.gob.cbpeh.bpd.modelo.CatLabio;
import mx.gob.cbpeh.bpd.modelo.CatLongitudCabello;
import mx.gob.cbpeh.bpd.modelo.CatLugar;
import mx.gob.cbpeh.bpd.modelo.CatMedioContacto;
import mx.gob.cbpeh.bpd.modelo.CatMunicipio;
import mx.gob.cbpeh.bpd.modelo.CatNacionalidad;
import mx.gob.cbpeh.bpd.modelo.CatOcupacion;
import mx.gob.cbpeh.bpd.modelo.CatParentesco;
import mx.gob.cbpeh.bpd.modelo.CatPeriodicidad;
import mx.gob.cbpeh.bpd.modelo.CatSexo;
import mx.gob.cbpeh.bpd.modelo.CatSiNo;
import mx.gob.cbpeh.bpd.modelo.CatTamanioNariz;
import mx.gob.cbpeh.bpd.modelo.CatTez;
import mx.gob.cbpeh.bpd.modelo.CatTipoCabello;
import mx.gob.cbpeh.bpd.modelo.CatTipoOjo;
import mx.gob.cbpeh.bpd.modelo.CatTipoSangre;
import mx.gob.cbpeh.bpd.modelo.CatTransporte;
import mx.gob.cbpeh.bpd.modelo.PersonaReporta;

public class PersonaDesaparecidaDto extends CommonResponse{
	
	private int idPersonaDesaparecida;

	private String aDondeIba;

	private String actitudExtrania;

	private String adiccion;

	private String amaterno;

	private String apaterno;

	private String calle;
	
	private String conQuienHabita;
	
	private String contraseniaCorreo;
	
	private String contraseniaFacebook;
	
	private String contraseniaInstagram;
	
	private String contraseniaTwitter;
	
	private String correoElectronico;
	
	private String curp;
	
	private String descripcionCabello;
	
	private String detalleComunicacion;
	
	private String detalleDejoDocumento;
	
	private String detalleDentadura;
	
	private String detalleDocumento;
	
	private String detalleFaltaACasa;
	
	private String detalleFractura;
	
	private String detalleHijos;
	
	private String detalleOperacion;
	
	private String detallePadecimiento;
	
	private String detalleTransporte;
	
	private String detalleViolencia;

	private Integer difusion;

	private String enemistad;	
	
	private Float estatura;

	private String facebook;
	
	private Date fechaActualizacion;
	
	private String fechaAlta;

	private String fechaDesaparecion;

	private Date fechaNacimiento;

	private Date fechaUltimoContacto;
	
	private byte[] fotoPersona;

	private String hechos;

	private String instragram;
	
	private String lugarFrecuente;

	private String nombre;
	
	private String folioExpediente;
	
	private String estatusDesaparecido;
	
	private Integer padecimientoDiscapacidad;

	private String pasatiempo;

	private Float peso;

	private String rfc;
	
	private String seniaParticular;

	private String sospecho;

	private String twitter;

	private String vestimenta;

	private CatBaseNariz catBaseNariz;
	
	private CatBoca catBoca;
	
	private CatColonia catColonia;
	
	private CatColorCabello catColorCabello;
	
	private CatColorOjo catColorOjo;
	
	private CatComplexion catComplexion;
	
	private CatCp catCp;
	
	private CatDentadura catDentadura;

	private CatDialecto catDialecto;
	
	private CatEdad catEdad;
	
	private CatEstado catEstado;
	
	private CatEstadoCivil catEstadoCivil;
	
	private CatEstatus catEstatus;
	
	private CatEstatusEconomico catEstatusEconomico;
	
	private CatFormaNariz catFormaNariz;
	
	private CatFrente catFrente;
	
	private CatGenero catGenero;
	
	private CatGrupoEtnico catGrupoEtnico;
	
	private CatLabio catLabio;
	
	private CatLongitudCabello catLogitudCabello;
	
	private CatLugar catLugar;
	
	private CatMedioContacto catMedioContacto;
	
	private CatMunicipio catMunicipio;
	
	private CatNacionalidad catNacionalidad;
	
	private CatOcupacion catOcupacion;
	
	private CatParentesco catParentesco;
	
	private CatPeriodicidad catPeriodicidad;
	
	private CatSexo catSexo;
	
	private CatSiNo hijos;
	
	private CatSiNo correos;
	
	private CatSiNo consta;
	
	private CatSiNo dejoDocumento;
	
	private CatSiNo faltas;
	
	private CatSiNo fracturas;
	
	private CatSiNo antedentes;
	
	private CatSiNo llevoDocumento;
	
	private CatSiNo operaciones;
	
	private CatSiNo violencia;
	
	private CatTamanioNariz catTamanioNariz;
	
	private CatTez catTez;
	
	private CatTipoCabello catTipoCabello;
	
	private CatTipoOjo catTipoOjo;
	
	private CatTipoSangre catTipoSangre;
	
	private CatTransporte catTransporte;

	private PersonaReporta personaReporta;

	private String idUsuarioActualiza;

	private String idUsuarioAlta;
	
	public PersonaDesaparecidaDto() {
		// TODO Auto-generated constructor stub
	}
	

	public String getFolioExpediente() {
		return folioExpediente;
	}

	public void setFolioExpediente(String folioExpdiente) {
		this.folioExpediente = folioExpdiente;
	}

	public int getIdPersonaDesaparecida() {
		return idPersonaDesaparecida;
	}

	public void setIdPersonaDesaparecida(int idPersonaDesaparecida) {
		this.idPersonaDesaparecida = idPersonaDesaparecida;
	}

	public String getaDondeIba() {
		return aDondeIba;
	}

	public void setaDondeIba(String aDondeIba) {
		this.aDondeIba = aDondeIba;
	}

	public String getActitudExtrania() {
		return actitudExtrania;
	}

	public void setActitudExtrania(String actitudExtrania) {
		this.actitudExtrania = actitudExtrania;
	}

	public String getAdiccion() {
		return adiccion;
	}

	public void setAdiccion(String adiccion) {
		this.adiccion = adiccion;
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

	public String getConQuienHabita() {
		return conQuienHabita;
	}

	public void setConQuienHabita(String conQuienHabita) {
		this.conQuienHabita = conQuienHabita;
	}

	public String getContraseniaCorreo() {
		return contraseniaCorreo;
	}

	public void setContraseniaCorreo(String contraseniaCorreo) {
		this.contraseniaCorreo = contraseniaCorreo;
	}

	public String getContraseniaFacebook() {
		return contraseniaFacebook;
	}

	public void setContraseniaFacebook(String contraseniaFacebook) {
		this.contraseniaFacebook = contraseniaFacebook;
	}

	public String getContraseniaInstagram() {
		return contraseniaInstagram;
	}

	public void setContraseniaInstagram(String contraseniaInstagram) {
		this.contraseniaInstagram = contraseniaInstagram;
	}

	public String getContraseniaTwitter() {
		return contraseniaTwitter;
	}

	public void setContraseniaTwitter(String contraseniaTwitter) {
		this.contraseniaTwitter = contraseniaTwitter;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getDescripcionCabello() {
		return descripcionCabello;
	}

	public void setDescripcionCabello(String descripcionCabello) {
		this.descripcionCabello = descripcionCabello;
	}

	public String getDetalleComunicacion() {
		return detalleComunicacion;
	}

	public void setDetalleComunicacion(String detalleComunicacion) {
		this.detalleComunicacion = detalleComunicacion;
	}

	public String getDetalleDejoDocumento() {
		return detalleDejoDocumento;
	}

	public void setDetalleDejoDocumento(String detalleDejoDocumento) {
		this.detalleDejoDocumento = detalleDejoDocumento;
	}

	public String getDetalleDentadura() {
		return detalleDentadura;
	}

	public void setDetalleDentadura(String detalleDentadura) {
		this.detalleDentadura = detalleDentadura;
	}

	public String getDetalleDocumento() {
		return detalleDocumento;
	}

	public void setDetalleDocumento(String detalleDocumento) {
		this.detalleDocumento = detalleDocumento;
	}

	public String getDetalleFaltaACasa() {
		return detalleFaltaACasa;
	}

	public void setDetalleFaltaACasa(String detalleFaltaACasa) {
		this.detalleFaltaACasa = detalleFaltaACasa;
	}

	public String getDetalleFractura() {
		return detalleFractura;
	}

	public void setDetalleFractura(String detalleFractura) {
		this.detalleFractura = detalleFractura;
	}

	public String getDetalleHijos() {
		return detalleHijos;
	}

	public void setDetalleHijos(String detalleHijos) {
		this.detalleHijos = detalleHijos;
	}

	public String getDetalleOperacion() {
		return detalleOperacion;
	}

	public void setDetalleOperacion(String detalleOperacion) {
		this.detalleOperacion = detalleOperacion;
	}

	public String getDetallePadecimiento() {
		return detallePadecimiento;
	}

	public void setDetallePadecimiento(String detallePadecimiento) {
		this.detallePadecimiento = detallePadecimiento;
	}

	public String getDetalleTransporte() {
		return detalleTransporte;
	}

	public void setDetalleTransporte(String detalleTransporte) {
		this.detalleTransporte = detalleTransporte;
	}

	public String getDetalleViolencia() {
		return detalleViolencia;
	}

	public void setDetalleViolencia(String detalleViolencia) {
		this.detalleViolencia = detalleViolencia;
	}

	public Integer getDifusion() {
		return difusion;
	}

	public void setDifusion(Integer difusion) {
		this.difusion = difusion;
	}

	public String getEnemistad() {
		return enemistad;
	}

	public void setEnemistad(String enemistad) {
		this.enemistad = enemistad;
	}

	public Float getEstatura() {
		return estatura;
	}

	public void setEstatura(Float estatura) {
		this.estatura = estatura;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getFechaDesaparecion() {
		return fechaDesaparecion;
	}

	public void setFechaDesaparecion(String fechaDesaparecion) {
		this.fechaDesaparecion = fechaDesaparecion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaUltimoContacto() {
		return fechaUltimoContacto;
	}

	public void setFechaUltimoContacto(Date fechaUltimoContacto) {
		this.fechaUltimoContacto = fechaUltimoContacto;
	}

	public byte[] getFotoPersona() {
		return fotoPersona;
	}

	public void setFotoPersona(byte[] fotoPersona) {
		this.fotoPersona = fotoPersona;
	}

	public String getHechos() {
		return hechos;
	}

	public void setHechos(String hechos) {
		this.hechos = hechos;
	}

	public String getInstragram() {
		return instragram;
	}

	public void setInstragram(String instragram) {
		this.instragram = instragram;
	}

	public String getLugarFrecuente() {
		return lugarFrecuente;
	}

	public void setLugarFrecuente(String lugarFrecuente) {
		this.lugarFrecuente = lugarFrecuente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPadecimientoDiscapacidad() {
		return padecimientoDiscapacidad;
	}

	public void setPadecimientoDiscapacidad(Integer padecimientoDiscapacidad) {
		this.padecimientoDiscapacidad = padecimientoDiscapacidad;
	}

	public String getPasatiempo() {
		return pasatiempo;
	}

	public void setPasatiempo(String pasatiempo) {
		this.pasatiempo = pasatiempo;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getSeniaParticular() {
		return seniaParticular;
	}

	public void setSeniaParticular(String seniaParticular) {
		this.seniaParticular = seniaParticular;
	}

	public String getSospecho() {
		return sospecho;
	}

	public void setSospecho(String sospecho) {
		this.sospecho = sospecho;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getVestimenta() {
		return vestimenta;
	}

	public void setVestimenta(String vestimenta) {
		this.vestimenta = vestimenta;
	}

	public CatBaseNariz getCatBaseNariz() {
		return catBaseNariz;
	}

	public void setCatBaseNariz(CatBaseNariz catBaseNariz) {
		this.catBaseNariz = catBaseNariz;
	}

	public CatBoca getCatBoca() {
		return catBoca;
	}

	public void setCatBoca(CatBoca catBoca) {
		this.catBoca = catBoca;
	}

	public CatColonia getCatColonia() {
		return catColonia;
	}

	public void setCatColonia(CatColonia catColonia) {
		this.catColonia = catColonia;
	}

	public CatColorCabello getCatColorCabello() {
		return catColorCabello;
	}

	public void setCatColorCabello(CatColorCabello catColorCabello) {
		this.catColorCabello = catColorCabello;
	}

	public CatColorOjo getCatColorOjo() {
		return catColorOjo;
	}

	public void setCatColorOjo(CatColorOjo catColorOjo) {
		this.catColorOjo = catColorOjo;
	}

	public CatComplexion getCatComplexion() {
		return catComplexion;
	}

	public void setCatComplexion(CatComplexion catComplexion) {
		this.catComplexion = catComplexion;
	}

	public CatCp getCatCp() {
		return catCp;
	}

	public void setCatCp(CatCp catCp) {
		this.catCp = catCp;
	}

	public CatDentadura getCatDentadura() {
		return catDentadura;
	}

	public void setCatDentadura(CatDentadura catDentadura) {
		this.catDentadura = catDentadura;
	}

	public CatDialecto getCatDialecto() {
		return catDialecto;
	}

	public void setCatDialecto(CatDialecto catDialecto) {
		this.catDialecto = catDialecto;
	}

	public CatEdad getCatEdad() {
		return catEdad;
	}

	public void setCatEdad(CatEdad catEdad) {
		this.catEdad = catEdad;
	}

	public CatEstado getCatEstado() {
		return catEstado;
	}

	public void setCatEstado(CatEstado catEstado) {
		this.catEstado = catEstado;
	}

	public CatEstadoCivil getCatEstadoCivil() {
		return catEstadoCivil;
	}

	public void setCatEstadoCivil(CatEstadoCivil catEstadoCivil) {
		this.catEstadoCivil = catEstadoCivil;
	}

	public CatEstatus getCatEstatus() {
		return catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

	public CatEstatusEconomico getCatEstatusEconomico() {
		return catEstatusEconomico;
	}

	public void setCatEstatusEconomico(CatEstatusEconomico catEstatusEconomico) {
		this.catEstatusEconomico = catEstatusEconomico;
	}

	public CatFormaNariz getCatFormaNariz() {
		return catFormaNariz;
	}

	public void setCatFormaNariz(CatFormaNariz catFormaNariz) {
		this.catFormaNariz = catFormaNariz;
	}

	public CatFrente getCatFrente() {
		return catFrente;
	}

	public void setCatFrente(CatFrente catFrente) {
		this.catFrente = catFrente;
	}

	public CatGenero getCatGenero() {
		return catGenero;
	}

	public void setCatGenero(CatGenero catGenero) {
		this.catGenero = catGenero;
	}

	public CatGrupoEtnico getCatGrupoEtnico() {
		return catGrupoEtnico;
	}

	public void setCatGrupoEtnico(CatGrupoEtnico catGrupoEtnico) {
		this.catGrupoEtnico = catGrupoEtnico;
	}

	public CatLabio getCatLabio() {
		return catLabio;
	}

	public void setCatLabio(CatLabio catLabio) {
		this.catLabio = catLabio;
	}

	public CatLongitudCabello getCatLogitudCabello() {
		return catLogitudCabello;
	}

	public void setCatLogitudCabello(CatLongitudCabello catLogitudCabello) {
		this.catLogitudCabello = catLogitudCabello;
	}

	public CatLugar getCatLugar() {
		return catLugar;
	}

	public void setCatLugar(CatLugar catLugar) {
		this.catLugar = catLugar;
	}

	public CatMedioContacto getCatMedioContacto() {
		return catMedioContacto;
	}

	public void setCatMedioContacto(CatMedioContacto catMedioContacto) {
		this.catMedioContacto = catMedioContacto;
	}

	public CatMunicipio getCatMunicipio() {
		return catMunicipio;
	}

	public void setCatMunicipio(CatMunicipio catMunicipio) {
		this.catMunicipio = catMunicipio;
	}

	public CatNacionalidad getCatNacionalidad() {
		return catNacionalidad;
	}

	public void setCatNacionalidad(CatNacionalidad catNacionalidad) {
		this.catNacionalidad = catNacionalidad;
	}

	public CatOcupacion getCatOcupacion() {
		return catOcupacion;
	}

	public void setCatOcupacion(CatOcupacion catOcupacion) {
		this.catOcupacion = catOcupacion;
	}

	public CatParentesco getCatParentesco() {
		return catParentesco;
	}

	public void setCatParentesco(CatParentesco catParentesco) {
		this.catParentesco = catParentesco;
	}

	public CatPeriodicidad getCatPeriodicidad() {
		return catPeriodicidad;
	}

	public void setCatPeriodicidad(CatPeriodicidad catPeriodicidad) {
		this.catPeriodicidad = catPeriodicidad;
	}

	public CatSexo getCatSexo() {
		return catSexo;
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
		return catTamanioNariz;
	}

	public void setCatTamanioNariz(CatTamanioNariz catTamanioNariz) {
		this.catTamanioNariz = catTamanioNariz;
	}

	public CatTez getCatTez() {
		return catTez;
	}

	public void setCatTez(CatTez catTez) {
		this.catTez = catTez;
	}

	public CatTipoCabello getCatTipoCabello() {
		return catTipoCabello;
	}

	public void setCatTipoCabello(CatTipoCabello catTipoCabello) {
		this.catTipoCabello = catTipoCabello;
	}

	public CatTipoOjo getCatTipoOjo() {
		return catTipoOjo;
	}

	public void setCatTipoOjo(CatTipoOjo catTipoOjo) {
		this.catTipoOjo = catTipoOjo;
	}

	public CatTipoSangre getCatTipoSangre() {
		return catTipoSangre;
	}

	public void setCatTipoSangre(CatTipoSangre catTipoSangre) {
		this.catTipoSangre = catTipoSangre;
	}

	public CatTransporte getCatTransporte() {
		return catTransporte;
	}

	public void setCatTransporte(CatTransporte catTransporte) {
		this.catTransporte = catTransporte;
	}

	public PersonaReporta getPersonaReporta() {
		return personaReporta;
	}

	public void setPersonaReporta(PersonaReporta personaReporta) {
		this.personaReporta = personaReporta;
	}

	public String getIdUsuarioActualiza() {
		return idUsuarioActualiza;
	}

	public void setIdUsuarioActualiza(String idUsuarioActualiza) {
		this.idUsuarioActualiza = idUsuarioActualiza;
	}

	public String getIdUsuarioAlta() {
		return idUsuarioAlta;
	}

	public void setIdUsuarioAlta(String idUsuarioAlta) {
		this.idUsuarioAlta = idUsuarioAlta;
	}
	

	public String getEstatusDesaparecido() {
		return estatusDesaparecido;
	}


	public void setEstatusDesaparecido(String estatusDesaparecido) {
		this.estatusDesaparecido = estatusDesaparecido;
	}


}
