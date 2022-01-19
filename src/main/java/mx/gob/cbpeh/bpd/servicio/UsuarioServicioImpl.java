package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.modelo.Usuario;
import mx.gob.cbpeh.bpd.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Override
	@Transactional
	public List<Usuario> getUsuarios() {
		return usuarioRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveUsuario(Usuario usuario) {
		usuarioRepositorio.save(usuario);
	}

	@Override
	@Transactional
	public Usuario getUsuario(String idUsuario) throws ResourceNotFoundException {
		return usuarioRepositorio.findByIdUsuario(idUsuario); 
	}
	
	@Override
	@Transactional
	public Usuario getUsuarioEstatus(String idUsuario, CatEstatus catEstus) throws ResourceNotFoundException {
		return usuarioRepositorio.findByIdUsuarioAndCatEstatus(idUsuario,catEstus); 
	}

	@Override
	@Transactional
	public void deleteUsuario(int idUsuario) throws ResourceNotFoundException {
		usuarioRepositorio.deleteById(idUsuario);
	}

}
