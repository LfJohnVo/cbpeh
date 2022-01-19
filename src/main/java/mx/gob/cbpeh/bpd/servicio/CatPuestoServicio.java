package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.modelo.CatPuesto;


public interface CatPuestoServicio {

    public List < CatPuesto > getCatPuestos();
    
    public List < CatPuesto > getCatPuestosActivos(CatEstatus catEstatus);

    public void saveCatPuesto(CatPuesto puesto);

    public Optional<CatPuesto>  getCatPuesto(int idPuesto) throws ResourceNotFoundException;

    public void deleteCatPuesto(int idPuesto) throws ResourceNotFoundException;
}
