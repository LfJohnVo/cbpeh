package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatMedioContacto;


public interface CatMedioContactoServicio {

    public List < CatMedioContacto > getCatMedioContactos();

    public void saveCatMedioContacto(CatMedioContacto medioContacto);

    public Optional<CatMedioContacto>  getCatMedioContacto(int idMedioContacto) throws ResourceNotFoundException;

    public void deleteCatMedioContacto(int idMedioContacto) throws ResourceNotFoundException;
}
