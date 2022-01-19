package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatColorOjo;


public interface CatColorOjoServicio {

    public List < CatColorOjo > getCatColorOjos();

    public void saveCatColorOjo(CatColorOjo colorOjo);

    public Optional<CatColorOjo>  getCatColorOjo(int idColorOjo) throws ResourceNotFoundException;

    public void deleteCatColorOjo(int idColorOjo) throws ResourceNotFoundException;
}
