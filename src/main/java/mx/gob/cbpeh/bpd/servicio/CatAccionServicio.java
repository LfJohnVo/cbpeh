package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatAccion;


public interface CatAccionServicio {

    public List < CatAccion > getCatAcciones();

    public void saveCatAccion(CatAccion accion);

    public Optional<CatAccion>  getCatAccion(int idAccion) throws ResourceNotFoundException;

    public void deleteCatAccion(int idAccion) throws ResourceNotFoundException;
}
