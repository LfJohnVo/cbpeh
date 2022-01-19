package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;


public interface CatEstatusServicio {

    public List < CatEstatus > getCatEstatus();

    public void saveCatEstatus(CatEstatus estatus);

    public Optional<CatEstatus>  getCatEstatus(int idEstatus) throws ResourceNotFoundException;

    public void deleteCatEstatus(int idEstatus) throws ResourceNotFoundException;
}
