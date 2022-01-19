package mx.gob.cbpeh.bpd.servicio;

import java.util.List;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.modelo.Usuario;


public interface UsuarioServicio {

    public List < Usuario > getUsuarios();

    public void saveUsuario(Usuario Usuario);

    public Usuario getUsuario(String idUsuario) throws ResourceNotFoundException;
    
    public Usuario getUsuarioEstatus(String idUsuario, CatEstatus catEstatus) throws ResourceNotFoundException;

    public void deleteUsuario(int idUsuario) throws ResourceNotFoundException;
}
