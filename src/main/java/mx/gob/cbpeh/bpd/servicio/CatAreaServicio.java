package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatArea;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;


public interface CatAreaServicio {

    public List < CatArea > getCatAreas();
    
    public List < CatArea > getCatAreasActivas(CatEstatus catEstatus);

    public void saveCatArea(CatArea area);

    public Optional<CatArea>  getCatArea(int idArea) throws ResourceNotFoundException;

    public void deleteCatArea(int idArea) throws ResourceNotFoundException;
}
