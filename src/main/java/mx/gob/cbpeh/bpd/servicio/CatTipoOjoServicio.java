package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatTipoOjo;


public interface CatTipoOjoServicio {

    public List < CatTipoOjo > getCatTipoOjos();

    public void saveCatTipoOjo(CatTipoOjo tipoOjo);

    public Optional<CatTipoOjo>  getCatTipoOjo(int idTipoOjo) throws ResourceNotFoundException;

    public void deleteCatTipoOjo(int idTipoOjo) throws ResourceNotFoundException;
}
