package mx.gob.cbpeh.bpd.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comisiones_estatales")
public class ComisionesEstatales implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_comisiones")
	private int idComisiones;

	private String comision;

	@Column(name="correo_enlace")
	private String correoEnlace;

	@Column(name="correo_oficial")
	private String correoOficial;

	@Column(name="correo_titular")
	private String correoTitular;

	@Lob
	private String domicilio;

	private String enlace;
	
	@ManyToOne
	@JoinColumn(name="id_estado")
	private CatEstado catEstado;

	@Column(name="telefono_comision")
	private String telefonoComision;

	@Column(name="telefono_enlace")
	private String telefonoEnlace;

	@Column(name="telefono_titular")
	private String telefonoTitular;

	private String titular;

	public ComisionesEstatales() {
	}

	public int getIdComisiones() {
		return this.idComisiones;
	}

	public void setIdComisiones(int idComisiones) {
		this.idComisiones = idComisiones;
	}

	public String getComision() {
		return this.comision;
	}

	public void setComision(String comision) {
		this.comision = comision;
	}

	public String getCorreoEnlace() {
		return this.correoEnlace;
	}

	public void setCorreoEnlace(String correoEnlace) {
		this.correoEnlace = correoEnlace;
	}

	public String getCorreoOficial() {
		return this.correoOficial;
	}

	public void setCorreoOficial(String correoOficial) {
		this.correoOficial = correoOficial;
	}

	public String getCorreoTitular() {
		return this.correoTitular;
	}

	public void setCorreoTitular(String correoTitular) {
		this.correoTitular = correoTitular;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getEnlace() {
		return this.enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public CatEstado getCatEstado() {
		return catEstado;
	}

	public void setCatEstado(CatEstado catEstado) {
		this.catEstado = catEstado;
	}

	public String getTelefonoComision() {
		return this.telefonoComision;
	}

	public void setTelefonoComision(String telefonoComision) {
		this.telefonoComision = telefonoComision;
	}

	public String getTelefonoEnlace() {
		return this.telefonoEnlace;
	}

	public void setTelefonoEnlace(String telefonoEnlace) {
		this.telefonoEnlace = telefonoEnlace;
	}

	public String getTelefonoTitular() {
		return this.telefonoTitular;
	}

	public void setTelefonoTitular(String telefonoTitular) {
		this.telefonoTitular = telefonoTitular;
	}

	public String getTitular() {
		return this.titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

}
