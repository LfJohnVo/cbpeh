package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.VinculoTelefono;


public interface VinculoTelefonoServicio {

    public List < VinculoTelefono > getVinculoTelefonos();

    public void saveVinculoTelefono(VinculoTelefono vinculoTelefono);

    public Optional<VinculoTelefono>  getVinculoTelefono(int idVinculoTelefono) throws ResourceNotFoundException;

    public void deleteVinculoTelefono(int idVinculoTelefono) throws ResourceNotFoundException;
}
