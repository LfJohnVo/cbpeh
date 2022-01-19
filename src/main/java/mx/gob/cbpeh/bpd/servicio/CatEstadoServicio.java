package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstado;


public interface CatEstadoServicio {

    public List < CatEstado > getCatEstados();

    public void saveCatEstado(CatEstado estado);

    public Optional<CatEstado>  getCatEstado(int idEstado) throws ResourceNotFoundException;

    public void deleteCatEstado(int idEstado) throws ResourceNotFoundException;
}
