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
@Table(name="cat_tipodependencia")
public class CatTipoDependencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_dependencia")
	private int idTipoDependencia;

	@Column(name="tipo_dependencia")
	private String tipoDependencia;

	public CatTipoDependencia() {
	}

	public int getIdTipoDependencia() {
		return this.idTipoDependencia;
	}

	public void setIdTipoDependencia(int idTipoDependencia) {
		this.idTipoDependencia = idTipoDependencia;
	}

	public String getTipoDependencia() {
		return this.tipoDependencia;
	}

	public void setTipoDependencia(String tipoDependencia) {
		this.tipoDependencia = tipoDependencia;
	}

}