package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatNacionalidad;


public interface CatNacionalidadServicio {

    public List < CatNacionalidad > getCatNacionalidad();

    public void saveCatNacionalidad(CatNacionalidad nacionalidad);

    public Optional<CatNacionalidad>  getCatNacionalidad(int idNacionalidad) throws ResourceNotFoundException;

    public void deleteCatNacionalidad(int idNacionalidad) throws ResourceNotFoundException;
}
