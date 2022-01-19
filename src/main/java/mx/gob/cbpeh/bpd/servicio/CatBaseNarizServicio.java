package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatBaseNariz;


public interface CatBaseNarizServicio {

    public List < CatBaseNariz > getCatBaseNariz();

    public void saveCatBaseNariz(CatBaseNariz baseNariz);

    public Optional<CatBaseNariz>  getCatBaseNariz(int idBaseNariz) throws ResourceNotFoundException;

    public void deleteCatBaseNariz(int idBaseNariz) throws ResourceNotFoundException;
}
