package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.modelo.CatParentesco;


public interface CatParentescoServicio {

    public List < CatParentesco > getCatParentescos();
    
    public List < CatParentesco > getCatParentescosActivos(CatEstatus catEstatus);
    

    public void saveCatParentesco(CatParentesco parentesco);

    public Optional<CatParentesco>  getCatParentesco(int idParentesco) throws ResourceNotFoundException;

    public void deleteCatParentesco(int idParentesco) throws ResourceNotFoundException;
}
