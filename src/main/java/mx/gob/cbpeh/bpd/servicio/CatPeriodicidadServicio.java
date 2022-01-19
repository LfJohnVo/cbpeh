package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatPeriodicidad;


public interface CatPeriodicidadServicio {

    public List < CatPeriodicidad > getCatPeriodicidad();

    public void saveCatPeriodicidad(CatPeriodicidad periodicidad);

    public Optional<CatPeriodicidad>  getCatPeriodicidad(int idPeriodicidad) throws ResourceNotFoundException;

    public void deleteCatPeriodicidad(int idPeriodicidad) throws ResourceNotFoundException;
}
