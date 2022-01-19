package mx.gob.cbpeh.bpd.servicio;

import java.util.List;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstatusLocalizado;


public interface CatEstatusLocalizadoServicio {

    public List < CatEstatusLocalizado > getCatEstatusLocalizados();

    public void saveCatEstatusLocalizado(CatEstatusLocalizado estatusLocalizado);

    public CatEstatusLocalizado  getCatEstatusLocalizado(int idEstatusLocalizado) throws ResourceNotFoundException; 
    
    public void deleteCatEstatusLocalizado(int idEstatusLocalizado) throws ResourceNotFoundException;
}
