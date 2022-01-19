package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEdad;


public interface CatEdadServicio {

    public List < CatEdad > getCatEdades();

    public void saveCatEdad(CatEdad edad);

    public Optional<CatEdad>  getCatEdad(int idEdad) throws ResourceNotFoundException;

    public void deleteCatEdad(int idEdad) throws ResourceNotFoundException;
}
