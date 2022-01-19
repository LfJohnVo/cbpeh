package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatTipoArchivo;


public interface CatTipoArchivoServicio {

    public List < CatTipoArchivo > getCatTipoArchivos();

    public void saveCatTipoArchivo(CatTipoArchivo tipoArchivo);

    public Optional<CatTipoArchivo>  getCatTipoArchivo(int idTipoArchivo) throws ResourceNotFoundException;
    
    public CatTipoArchivo  getCatTipoArchivo(String extension) throws ResourceNotFoundException;

    public void deleteCatTipoArchivo(int idTipoArchivo) throws ResourceNotFoundException;
}
