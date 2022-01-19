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
@Table(name="busqueda_inmediata")
public class BusquedaInmediata  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_dependencia")
	private int idDependencia;

	private String dependencia;

	private String telefonos;

	//bi-directional many-to-one association to CatTipodependencia
	@ManyToOne
	@JoinColumn(name="id_tipoDependencia")
	private CatTipoDependencia catTipodependencia;

	public BusquedaInmediata() {
	}

	public int getIdDependencia() {
		return this.idDependencia;
	}

	public void setIdDependencia(int idDependencia) {
		this.idDependencia = idDependencia;
	}

	public String getDependencia() {
		return this.dependencia;
	}

	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}

	public String getTelefonos() {
		return this.telefonos;
	}

	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}

	public CatTipoDependencia getCatTipodependencia() {
		return this.catTipodependencia;
	}

	public void setCatTipodependencia(CatTipoDependencia catTipodependencia) {
		this.catTipodependencia = catTipodependencia;
	}

}