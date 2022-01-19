package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstatusColaboracion;


public interface CatEstatusColaboracionServicio {

    public List < CatEstatusColaboracion > getCatEstatusColaboracions();

    public void saveCatEstatusColaboracion(CatEstatusColaboracion estatusColaboracion);

    public Optional<CatEstatusColaboracion>  getCatEstatusColaboracion(int idEstatusColaboracion) throws ResourceNotFoundException;

    public void deleteCatEstatusColaboracion(int idEstatusColaboracion) throws ResourceNotFoundException;
}
