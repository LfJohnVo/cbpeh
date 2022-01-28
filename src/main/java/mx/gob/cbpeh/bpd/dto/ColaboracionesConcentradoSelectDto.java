package mx.gob.cbpeh.bpd.dto;

public class ColaboracionesConcentradoSelectDto {   
    public ColaboracionesConcentradoSelectDto(String numPeticion, String fechaPeticion,
            String solColaboracion, String firmadoPor) {
        this.numPeticion = numPeticion;
        this.fechaPeticion = fechaPeticion;
        this.solColaboracion = solColaboracion;
        this.firmadoPor = firmadoPor;
    }
    public String getNumeroOfficioPeticion() {
        return numPeticion;
    }
    public void setNumeroOfficioPeticion(String numPeticion) {
        this.numPeticion = numPeticion;
    }
    public String getNumPeticion() {
		return numPeticion;
	}
	public void setNumPeticion(String numPeticion) {
		this.numPeticion = numPeticion;
	}
	public String getFirmadoPor() {
		return firmadoPor;
	}
	public void setFirmadoPor(String firmadoPor) {
		this.firmadoPor = firmadoPor;
	}
	public String getFechaPeticion() {
        return fechaPeticion;
    }
    public void setFechaPeticion(String fechaPeticion) {
        this.fechaPeticion = fechaPeticion;
    }
    public String getSolColaboracion() {
        return solColaboracion;
    }
    public void setSolColaboracion(String solColaboracion) {
        this.solColaboracion = solColaboracion;
    }
    private String fechaPeticion;
    private String solColaboracion;
    private String numPeticion;
    private String firmadoPor;
}
