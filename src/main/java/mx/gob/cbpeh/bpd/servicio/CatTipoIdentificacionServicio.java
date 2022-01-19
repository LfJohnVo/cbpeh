package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatTipoIdentificacion;


public interface CatTipoIdentificacionServicio {

    public List < CatTipoIdentificacion > getCatTipoIdentificacion();

    public void saveCatTipoIdentificacion(CatTipoIdentificacion tipoIdentificacion);

    public Optional<CatTipoIdentificacion>  getCatTipoIdentificacion(int idTipoIdentificacion) throws ResourceNotFoundException;

    public void deleteCatTipoIdentificacion(int idTipoIdentificacion) throws ResourceNotFoundException;
}
