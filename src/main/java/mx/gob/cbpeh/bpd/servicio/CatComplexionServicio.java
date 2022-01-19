package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatComplexion;


public interface CatComplexionServicio {

    public List < CatComplexion > getCatComplexiones();

    public void saveCatComplexion(CatComplexion complexion);

    public Optional<CatComplexion>  getCatComplexion(int idComplexion) throws ResourceNotFoundException;

    public void deleteCatComplexion(int idComplexion) throws ResourceNotFoundException;
}
