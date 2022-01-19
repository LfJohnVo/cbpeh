package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatOcupacion;


public interface CatOcupacionServicio {

    public List < CatOcupacion > getCatOcupacion();

    public void saveCatOcupacion(CatOcupacion ocupacion);

    public Optional<CatOcupacion>  getCatOcupacion(int idOcupacion) throws ResourceNotFoundException;

    public void deleteCatOcupacion(int idOcupacion) throws ResourceNotFoundException;
}
