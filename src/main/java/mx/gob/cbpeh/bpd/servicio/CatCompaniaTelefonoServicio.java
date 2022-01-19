package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatCompaniaTelefono;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;


public interface CatCompaniaTelefonoServicio {

    public List < CatCompaniaTelefono > getCatCompaniaTelefonos();
    
    public List < CatCompaniaTelefono > getCatCompaniaTelefonosActivas(CatEstatus catEstatus);

    public void saveCatCompaniaTelefono(CatCompaniaTelefono companiaTelefono);

    public Optional<CatCompaniaTelefono>  getCatCompaniaTelefono(int idCompaniaTelefono) throws ResourceNotFoundException;

    public void deleteCatCompaniaTelefono(int idCompaniaTelefono) throws ResourceNotFoundException;
}
