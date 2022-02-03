package mx.gob.cbpeh.bpd.dto;

public class AtencionesPsicologicasConcentradoDto {

    private String nombre;
    private String parentesco;
    private String fecha;
    private String observaciones;
    private String expediente;

    public AtencionesPsicologicasConcentradoDto() {
    }

    public AtencionesPsicologicasConcentradoDto(String nombre, String parentesco, String fecha, String observaciones,
            String expediente) {
        this.nombre = nombre;
        this.parentesco = parentesco;
        this.fecha = fecha;
        this.observaciones = observaciones;
        this.expediente = expediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

}
