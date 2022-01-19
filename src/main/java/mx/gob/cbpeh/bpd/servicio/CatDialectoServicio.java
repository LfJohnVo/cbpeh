package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatDialecto;


public interface CatDialectoServicio {

    public List < CatDialecto > getCatDialectos();

    public void saveCatDialecto(CatDialecto dialecto);

    public Optional<CatDialecto>  getCatDialecto(int idDialecto) throws ResourceNotFoundException;

    public void deleteCatDialecto(int idDialecto) throws ResourceNotFoundException;
}
