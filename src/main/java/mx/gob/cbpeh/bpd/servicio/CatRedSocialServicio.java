package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatRedSocial;


public interface CatRedSocialServicio {

    public List < CatRedSocial > getCatRedSocial();

    public void saveCatRedSocial(CatRedSocial redSocial);

    public Optional<CatRedSocial>  getCatRedSocial(int idRedSocial) throws ResourceNotFoundException;

    public void deleteCatRedSocial(int idRedSocial) throws ResourceNotFoundException;
}
