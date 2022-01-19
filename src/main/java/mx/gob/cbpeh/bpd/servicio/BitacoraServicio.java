package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.Bitacora;


public interface BitacoraServicio {

    public List < Bitacora > getBitacoras();

    public void saveBitacora(Bitacora bitacora);

    public Optional<Bitacora>  getBitacora(int idBitacora) throws ResourceNotFoundException;

    public void deleteBitacora(int idBitacora) throws ResourceNotFoundException;
}
