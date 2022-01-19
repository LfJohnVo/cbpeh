package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatDentadura;


public interface CatDentaduraServicio {

    public List < CatDentadura > getCatDentaduras();

    public void saveCatDentadura(CatDentadura dentadura);

    public Optional<CatDentadura>  getCatDentadura(int idDentadura) throws ResourceNotFoundException;

    public void deleteCatDentadura(int idDentadura) throws ResourceNotFoundException;
}
