package mx.gob.cbpeh.bpd.modelo;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

@Embeddable
public class ColaboracionDesaparecidosPK {
    private static final long serialVersionUID = 1L;

    @JoinColumn(name = "id_expediente_colaboracion", insertable = false, updatable = false)
    private String idExpedienteColaboracion;

    public ColaboracionDesaparecidosPK() {
    }

    public String getIdExpedienteColaboracion() {
        return idExpedienteColaboracion;
    }

    public void setIdExpedienteColaboracion(String idExpedienteColaboracion) {
        this.idExpedienteColaboracion = idExpedienteColaboracion;
    }

}
