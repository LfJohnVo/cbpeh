package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatBoca;


public interface CatBocaServicio {

    public List < CatBoca > getCatBocas();

    public void saveCatBoca(CatBoca boca);

    public Optional<CatBoca>  getCatBoca(int idBoca) throws ResourceNotFoundException;

    public void deleteCatBoca(int idBoca) throws ResourceNotFoundException;
}
