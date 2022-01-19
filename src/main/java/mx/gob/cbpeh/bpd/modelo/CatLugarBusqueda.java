package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.*;

@Entity
@Table(name="cat_lugar_busqueda")
public class CatLugarBusqueda  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_lugar_busqueda")
	private int idLugarBusqueda;

	@Column(name="estatus_lugar_busqueda")
	private byte estatusLugarBusqueda;

	@Column(name="lugar_busqueda_detalle")
	private String lugarBusquedaDetalle;



	public CatLugarBusqueda() {
	}

	public int getIdLugarBusqueda() {
		return this.idLugarBusqueda;
	}

	public void setIdLugarBusqueda(int idLugarBusqueda) {
		this.idLugarBusqueda = idLugarBusqueda;
	}

	public byte getEstatusLugarBusqueda() {
		return this.estatusLugarBusqueda;
	}

	public void setEstatusLugarBusqueda(byte estatusLugarBusqueda) {
		this.estatusLugarBusqueda = estatusLugarBusqueda;
	}

	public String getLugarBusquedaDetalle() {
		return this.lugarBusquedaDetalle;
	}

	public void setLugarBusquedaDetalle(String lugarBusquedaDetalle) {
		this.lugarBusquedaDetalle = lugarBusquedaDetalle;
	}


}