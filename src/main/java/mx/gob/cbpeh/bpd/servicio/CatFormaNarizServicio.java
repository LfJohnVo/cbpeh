package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatFormaNariz;


public interface CatFormaNarizServicio {

    public List < CatFormaNariz > getCatFormaNariz();

    public void saveCatFormaNariz(CatFormaNariz formaNariz);

    public Optional<CatFormaNariz>  getCatFormaNariz(int idFormaNariz) throws ResourceNotFoundException;

    public void deleteCatFormaNariz(int idFormaNariz) throws ResourceNotFoundException;
}
