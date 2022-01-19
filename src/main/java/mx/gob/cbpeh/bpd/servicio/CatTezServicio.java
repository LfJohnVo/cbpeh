package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatTez;


public interface CatTezServicio {

    public List < CatTez > getCatTez();

    public void saveCatTez(CatTez tez);

    public Optional<CatTez>  getCatTez(int idTez) throws ResourceNotFoundException;

    public void deleteCatTez(int idTez) throws ResourceNotFoundException;
}
