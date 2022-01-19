package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatTipoUso;


public interface CatTipoUsoServicio {

    public List < CatTipoUso > getCatTipoUsos();

    public void saveCatTipoUso(CatTipoUso tipoUso);

    public Optional<CatTipoUso>  getCatTipoUso(int idTipoUso) throws ResourceNotFoundException;

    public void deleteCatTipoUso(int idTipoUso) throws ResourceNotFoundException;
}
