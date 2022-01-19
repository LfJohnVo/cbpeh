package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatFrente;


public interface CatFrenteServicio {

    public List < CatFrente > getCatFrente();

    public void saveCatFrente(CatFrente frente);

    public Optional<CatFrente>  getCatFrente(int idFrente) throws ResourceNotFoundException;

    public void deleteCatFrente(int idFrente) throws ResourceNotFoundException;
}
