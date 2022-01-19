package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_estado_civil")
public class CatEstadoCivil  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado_civil")
	private Integer idEstadoCivil;

	@Column(name="estado_civil")
	private String estadoCivil;
	
	@ManyToOne
	@JoinColumn(name="estatus_estado_civil")
	private CatEstatus catEstatus;

	public CatEstadoCivil() {
	}

	public Integer getIdEstadoCivil() {
		return this.idEstadoCivil;
	}

	public void setIdEstadoCivil(Integer idEstadoCivil) {
		this.idEstadoCivil = idEstadoCivil;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}