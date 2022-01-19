package mx.gob.cbpeh.bpd.modelo;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class AtentaNotaPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="id_atenta_nota")
	private String idAtentaNota;

	@Column(name="id_area", insertable=false, updatable=false)
	private Integer idArea;

	public AtentaNotaPK() {
	}
	public String getIdAtentaNota() {
		return this.idAtentaNota;
	}
	public void setIdAtentaNota(String idAtentaNota) {
		this.idAtentaNota = idAtentaNota;
	}
	public Integer getIdArea() {
		return this.idArea;
	}
	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AtentaNotaPK)) {
			return false;
		}
		AtentaNotaPK castOther = (AtentaNotaPK)other;
		return 
			this.idAtentaNota.equals(castOther.idAtentaNota)
			&& (this.idArea == castOther.idArea);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idAtentaNota.hashCode();
		hash = hash * prime + ((int) this.idArea);
		
		return hash;
	}
}