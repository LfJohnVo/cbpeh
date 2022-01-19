package mx.gob.cbpeh.bpd.modelo;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="cat_institucion")
public class CatInstitucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_institucion")
	private int idInstitucion;

	@Column(name="abreviatura_institucion")
	private String abreviaturaInstitucion;

	@Column(name="institucion_detalle")
	private String institucionDetalle;

	@ManyToOne
	@JoinColumn(name="estatus_institucion")
	private CatEstatus catEstatus;

	public CatInstitucion() {
	}

	public int getIdInstitucion() {
		return this.idInstitucion;
	}

	public void setIdInstitucion(int idInstitucion) {
		this.idInstitucion = idInstitucion;
	}

	public String getAbreviaturaInstitucion() {
		return this.abreviaturaInstitucion;
	}

	public void setAbreviaturaInstitucion(String abreviaturaInstitucion) {
		this.abreviaturaInstitucion = abreviaturaInstitucion;
	}

	public String getInstitucionDetalle() {
		return this.institucionDetalle;
	}

	public void setInstitucionDetalle(String institucionDetalle) {
		this.institucionDetalle = institucionDetalle;
	}

	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

}