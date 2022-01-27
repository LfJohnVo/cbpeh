package mx.gob.cbpeh.bpd.dto;

public class BusquedaLargaDataConcentradoDto {
    private String idBusquedaLargaData;
    private String fechaBusqueda;
    private String estatusLocalizado;
    private String municipio;
    private String cp;
    private String colonia;
    private String calle;
    private String latitud;
    private String longitud;

    public BusquedaLargaDataConcentradoDto(String idBusquedaLargaData, String fechaBusqueda, String estatusLocalizado,
            String municipio, String cp, String colonia, String calle, String latitud, String longitud) {
        this.idBusquedaLargaData = idBusquedaLargaData;
        this.fechaBusqueda = fechaBusqueda;
        this.estatusLocalizado = estatusLocalizado;
        this.municipio = municipio;
        this.cp = cp;
        this.colonia = colonia;
        this.calle = calle;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getIdBusquedaLargaData() {
        return idBusquedaLargaData;
    }

    public void setIdBusquedaLargaData(String idBusquedaLargaData) {
        this.idBusquedaLargaData = idBusquedaLargaData;
    }

    public String getFechaBusqueda() {
        return fechaBusqueda;
    }

    public void setFechaBusqueda(String fechaBusqueda) {
        this.fechaBusqueda = fechaBusqueda;
    }

    public String getEstatusLocalizado() {
        return estatusLocalizado;
    }

    public void setEstatusLocalizado(String estatusLocalizado) {
        this.estatusLocalizado = estatusLocalizado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

}
