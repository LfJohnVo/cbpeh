package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.VinculoRedSocial;


public interface VinculoRedSocialServicio {

    public List < VinculoRedSocial > getVinculoRedSocial();

    public void saveVinculoRedSocial(VinculoRedSocial vinculoRedSocial);

    public Optional<VinculoRedSocial>  getVinculoRedSocial(int idVinculoRedSocial) throws ResourceNotFoundException;

    public void deleteVinculoRedSocial(int idVinculoRedSocial) throws ResourceNotFoundException;
}
