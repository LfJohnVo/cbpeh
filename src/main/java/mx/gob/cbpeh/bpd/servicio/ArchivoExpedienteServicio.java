package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.ArchivoExpediente;

public interface ArchivoExpedienteServicio {

    public List < ArchivoExpediente > getArchivoExpedientes();

    public ArchivoExpediente saveArchivoExpediente(ArchivoExpediente archivoExpediente);

    public Optional<ArchivoExpediente>  getArchivoExpediente(int idArchivoExpediente) throws ResourceNotFoundException;

    public void deleteArchivoExpediente(int idArchivoExpediente) throws ResourceNotFoundException;
    
    public List < ArchivoExpediente > getArchivosExpediente(String idExpediente);
}
