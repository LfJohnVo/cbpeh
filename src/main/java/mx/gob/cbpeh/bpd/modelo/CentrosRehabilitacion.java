package mx.gob.cbpeh.bpd.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="centros_rehabilitacion")
public class CentrosRehabilitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_centro_rehabilitacion")
	private int idCentroRehabilitacion;

	@Column(name="centro_rehabilitacion")
	private String centroRehabilitacion;

	@Column(name="correo_electronico")
	private String correoElectronico;

	private String domicilio;

	@Column(name="id_municipio")
	private int idMunicipio;

	private String telefono;

	//bi-directional many-to-one association to CatTipoCentrorehabilitacion
	@ManyToOne
	@JoinColumn(name="id_tipo_centro")
	private CatTipoCentroRehabilitacion catTipoCentrorehabilitacion;

	public CentrosRehabilitacion() {
	}

	public int getIdCentroRehabilitacion() {
		return this.idCentroRehabilitacion;
	}

	public void setIdCentroRehabilitacion(int idCentroRehabilitacion) {
		this.idCentroRehabilitacion = idCentroRehabilitacion;
	}

	public String getCentroRehabilitacion() {
		return this.centroRehabilitacion;
	}

	public void setCentroRehabilitacion(String centroRehabilitacion) {
		this.centroRehabilitacion = centroRehabilitacion;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public int getIdMunicipio() {
		return this.idMunicipio;
	}

	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public CatTipoCentroRehabilitacion getCatTipoCentrorehabilitacion() {
		return this.catTipoCentrorehabilitacion;
	}

	public void setCatTipoCentrorehabilitacion(CatTipoCentroRehabilitacion catTipoCentrorehabilitacion) {
		this.catTipoCentrorehabilitacion = catTipoCentrorehabilitacion;
	}

}