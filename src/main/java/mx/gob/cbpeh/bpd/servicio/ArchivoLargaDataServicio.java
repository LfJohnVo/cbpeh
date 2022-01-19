package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.ArchivoLargaData;

public interface ArchivoLargaDataServicio {

    public List < ArchivoLargaData > getCArchivoLargaData();

    public void saveArchivoLargaData(ArchivoLargaData archivo);

    public Optional<ArchivoLargaData>  getArchivoLargaData(int idArchivoLargaData) throws ResourceNotFoundException;

    public void deleteArchivoLargaData(int idArchivoLargaData) throws ResourceNotFoundException;
}
