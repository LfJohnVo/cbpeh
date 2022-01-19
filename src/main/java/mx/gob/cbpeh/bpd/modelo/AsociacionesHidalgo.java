package mx.gob.cbpeh.bpd.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="asociaciones_hidalgo")
public class AsociacionesHidalgo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_asociaciones")
	private int idAsociaciones;

	private String asociacion;

	@Column(name="correo_electronico")
	private String correoElectronico;

	private String presidente_representanteLegal;

	@Column(name="telefono_fijo")
	private String telefonoFijo;

	@Column(name="telefono_movil")
	private String telefonoMovil;

	public AsociacionesHidalgo() {
	}

	public int getIdAsociaciones() {
		return this.idAsociaciones;
	}

	public void setIdAsociaciones(int idAsociaciones) {
		this.idAsociaciones = idAsociaciones;
	}

	public String getAsociacion() {
		return this.asociacion;
	}

	public void setAsociacion(String asociacion) {
		this.asociacion = asociacion;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getPresidente_representanteLegal() {
		return this.presidente_representanteLegal;
	}

	public void setPresidente_representanteLegal(String presidente_representanteLegal) {
		this.presidente_representanteLegal = presidente_representanteLegal;
	}

	public String getTelefonoFijo() {
		return this.telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoMovil() {
		return this.telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

}