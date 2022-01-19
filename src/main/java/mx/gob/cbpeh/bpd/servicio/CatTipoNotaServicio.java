package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.modelo.CatTipoNota;


public interface CatTipoNotaServicio {

    public List < CatTipoNota > getCatTipoNotas();
    
    public List < CatTipoNota > getCatTipoNotasActivas(CatEstatus catEstatus);

    public void saveCatTipoNota(CatTipoNota tipoNota);

    public Optional<CatTipoNota>  getCatTipoNota(int idTipoNota) throws ResourceNotFoundException;

    public void deleteCatTipoNota(int idTipoNota) throws ResourceNotFoundException;
}
