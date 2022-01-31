package mx.gob.cbpeh.bpd.dto;

public class ColaboracionesConcentradoDto {

    // private static final long serialVersionUID = -530032632046769943L;

    private String idExpedienteColaboracion;
    private String numeroOfficioPeticion;
    private String institucion;
    private String firmadoPor;
    private String personaDesaparecida;
    private String estatusColaboracion;

    public ColaboracionesConcentradoDto() {
    }

    public ColaboracionesConcentradoDto(String idExpedienteColaboracion, String numeroOfficioPeticion,
                                        String institucion, String firmadoPor, String nombre, String aPaterno, String aMaterno,
                                        String estatusColaboracion) {
        this.idExpedienteColaboracion = idExpedienteColaboracion;
        this.numeroOfficioPeticion = numeroOfficioPeticion;
        this.institucion = institucion;
        this.firmadoPor = firmadoPor;
        this.personaDesaparecida = ((nombre != null) ? nombre : "") + " " + ((aPaterno != null) ? aPaterno : "") + " "
                + ((aMaterno != null) ? aMaterno : "");
        this.estatusColaboracion = estatusColaboracion;
    }

    public String getIdExpedienteColaboracion() {
        return idExpedienteColaboracion;
    }

    public void setIdExpedienteColaboracion(String idExpedienteColaboracion) {
        this.idExpedienteColaboracion = idExpedienteColaboracion;
    }

    public String getNumeroOfficioPeticion() {
        return numeroOfficioPeticion;
    }

    public void setNumeroOfficioPeticion(String numeroOfficioPeticion) {
        this.numeroOfficioPeticion = numeroOfficioPeticion;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getFirmadoPor() {
        return firmadoPor;
    }

    public void setFirmadoPor(String firmadoPor) {
        this.firmadoPor = firmadoPor;
    }

    public String getPersonaDesaparecida() {
        return personaDesaparecida;
    }

    public void setPersonaDesaparecida(String personaDesaparecida) {
        this.personaDesaparecida = personaDesaparecida;
    }

    public String getEstatusColaboracion() {
        return estatusColaboracion;
    }

    public void setEstatusColaboracion(String estatusColaboracion) {
        this.estatusColaboracion = estatusColaboracion;
    }

}
