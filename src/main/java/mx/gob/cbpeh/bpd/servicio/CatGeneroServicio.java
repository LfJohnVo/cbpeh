package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatGenero;


public interface CatGeneroServicio {

    public List < CatGenero > getCatGenero();

    public void saveCatGenero(CatGenero genero);

    public Optional<CatGenero>  getCatGenero(int idGenero) throws ResourceNotFoundException;

    public void deleteCatGenero(int idGenero) throws ResourceNotFoundException;
}
