package mx.gob.cbpeh.bpd.modelo;
import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the colaboracion_lugar_busqueda database table.
 * 
 */
@Embeddable
public class ColaboracionLugarBusquedaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_expediente_colaboracion", insertable=false, updatable=false)
	private String idExpedienteColaboracion;

	@Column(name="id_lugar_busqueda", insertable=false, updatable=false)
	private int idLugarBusqueda;

	public ColaboracionLugarBusquedaPK() {
	}
	public String getIdExpedienteColaboracion() {
		return this.idExpedienteColaboracion;
	}
	public void setIdExpedienteColaboracion(String idExpedienteColaboracion) {
		this.idExpedienteColaboracion = idExpedienteColaboracion;
	}
	public int getIdLugarBusqueda() {
		return this.idLugarBusqueda;
	}
	public void setIdLugarBusqueda(int idLugarBusqueda) {
		this.idLugarBusqueda = idLugarBusqueda;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ColaboracionLugarBusquedaPK)) {
			return false;
		}
		ColaboracionLugarBusquedaPK castOther = (ColaboracionLugarBusquedaPK)other;
		return 
			this.idExpedienteColaboracion.equals(castOther.idExpedienteColaboracion)
			&& (this.idLugarBusqueda == castOther.idLugarBusqueda);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idExpedienteColaboracion.hashCode();
		hash = hash * prime + this.idLugarBusqueda;
		
		return hash;
	}
}