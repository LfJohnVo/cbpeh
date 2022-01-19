package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatTipoSangre;


public interface CatTipoSangreServicio {

    public List < CatTipoSangre > getCatTipoSangre();

    public void saveCatTipoSangre(CatTipoSangre tipoSangre);

    public Optional<CatTipoSangre>  getCatTipoSangre(int idTipoSangre) throws ResourceNotFoundException;

    public void deleteCatTipoSangre(int idTipoSangre) throws ResourceNotFoundException;
}
