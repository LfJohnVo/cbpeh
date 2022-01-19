package mx.gob.cbpeh.bpd.modelo;


import javax.persistence.*;


/**
 * The persistent class for the busqueda_larga_data_expediente database table.
 * 
 */
@Entity
@Table(name="busqueda_larga_data_expediente")
public class BusquedaLargaDataExpediente  {


	@Id
	@Column(name="id_expediente")
	private String expediente;

	@Column(name="estatus_busqueda_larga_data_expediente")
	private byte estatusBusquedaLargaDataExpediente;

	//bi-directional many-to-one association to BusquedaLargaData
	@ManyToOne
	@JoinColumn(name="id_busqueda_larga_data")
	private BusquedaLargaData busquedaLargaData;

	public BusquedaLargaDataExpediente() {
	}

	

	public String getExpediente() {
		return expediente;
	}



	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}



	public byte getEstatusBusquedaLargaDataExpediente() {
		return this.estatusBusquedaLargaDataExpediente;
	}

	public void setEstatusBusquedaLargaDataExpediente(byte estatusBusquedaLargaDataExpediente) {
		this.estatusBusquedaLargaDataExpediente = estatusBusquedaLargaDataExpediente;
	}

	public BusquedaLargaData getBusquedaLargaData() {
		return this.busquedaLargaData;
	}

	public void setBusquedaLargaData(BusquedaLargaData busquedaLargaData) {
		this.busquedaLargaData = busquedaLargaData;
	}

}