package mx.gob.cbpeh.bpd.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cat_tipo_centrorehabilitacion")
public class CatTipoCentroRehabilitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_centro")
	private int idTipoCentro;

	@Column(name="tipo_centro")
	private String tipoCentro;

	public CatTipoCentroRehabilitacion() {
	}

	public int getIdTipoCentro() {
		return this.idTipoCentro;
	}

	public void setIdTipoCentro(int idTipoCentro) {
		this.idTipoCentro = idTipoCentro;
	}

	public String getTipoCentro() {
		return this.tipoCentro;
	}

	public void setTipoCentro(String tipoCentro) {
		this.tipoCentro = tipoCentro;
	}

}