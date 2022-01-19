package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatLabio;


public interface CatLabioServicio {

    public List < CatLabio > getCatLabios();

    public void saveCatLabio(CatLabio labio);

    public Optional<CatLabio>  getCatLabio(int idLabio) throws ResourceNotFoundException;

    public void deleteCatLabio(int idLabio) throws ResourceNotFoundException;
}
