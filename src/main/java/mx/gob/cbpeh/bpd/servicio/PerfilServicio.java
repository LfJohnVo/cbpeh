package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.modelo.Perfil;


public interface PerfilServicio {

    public List < Perfil > getPerfiles();
    
    public List < Perfil > getPerfilesActivos(CatEstatus catEstatus);

    public void savePerfil(Perfil perfil);

    public Optional<Perfil>  getPerfil(int idPerfil) throws ResourceNotFoundException;

    public void deletePerfil(int idPerfil) throws ResourceNotFoundException;
}
