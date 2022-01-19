package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstatusVida;


public interface CatEstatusVidaServicio {

    public List < CatEstatusVida > getCatEstatusVida();

    public void saveCatEstatusVida(CatEstatusVida estatusVida);

    public Optional<CatEstatusVida>  getCatEstatusVida(int idEstatusVida) throws ResourceNotFoundException;

    public void deleteCatEstatusVida(int idEstatusVida) throws ResourceNotFoundException;
}
