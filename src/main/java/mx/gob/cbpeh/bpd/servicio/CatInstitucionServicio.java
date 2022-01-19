package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatInstitucion;


public interface CatInstitucionServicio {

    public List < CatInstitucion > getCatInstitucion();

    public void saveCatInstitucion(CatInstitucion estado);

    public Optional<CatInstitucion>  getCatInstitucion(int idInstitucion) throws ResourceNotFoundException;

    public void deleteCatInstitucion(int idInstitucion) throws ResourceNotFoundException;
}
