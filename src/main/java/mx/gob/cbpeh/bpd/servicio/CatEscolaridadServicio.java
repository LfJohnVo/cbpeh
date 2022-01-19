package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEscolaridad;


public interface CatEscolaridadServicio {

    public List < CatEscolaridad > getCatEscolaridad();

    public void saveCatEscolaridad(CatEscolaridad escolaridad);

    public Optional<CatEscolaridad>  getCatEscolaridad(int idEscolaridad) throws ResourceNotFoundException;

    public void deleteCatEscolaridad(int idEscolaridad) throws ResourceNotFoundException;
}
