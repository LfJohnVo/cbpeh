package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

//Se agrega nombre de la tabla para evitar errores case sensitiva
@Entity
@Table(name="bitacora")
public class Bitacora  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_bitacora")
	private int idBitacora;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Time hora;

	private String ip;

	@ManyToOne
	@JoinColumn(name="id_accion")
	private CatAccion catAccion;

	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public Bitacora() {
	}

	public int getIdBitacora() {
		return this.idBitacora;
	}

	public void setIdBitacora(int idBitacora) {
		this.idBitacora = idBitacora;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return this.hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public CatAccion getCatAccion() {
		return this.catAccion;
	}

	public void setCatAccion(CatAccion catAccion) {
		this.catAccion = catAccion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}