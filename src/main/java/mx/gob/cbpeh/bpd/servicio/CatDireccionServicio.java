package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatDireccion;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;


public interface CatDireccionServicio {

    public List < CatDireccion > getCatDirecciones();
    
    public List < CatDireccion > getCatDireccionesActivas(CatEstatus catEstatus);

    public void saveCatDireccion(CatDireccion direccion);

    public Optional<CatDireccion>  getCatDireccion(int idDireccion) throws ResourceNotFoundException;

    public void deleteCatDireccion(int idDireccion) throws ResourceNotFoundException;
}
