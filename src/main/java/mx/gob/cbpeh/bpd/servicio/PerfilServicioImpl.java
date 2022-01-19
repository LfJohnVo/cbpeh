package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.modelo.Perfil;
import mx.gob.cbpeh.bpd.repositorio.PerfilRepositorio;

@Service
public class PerfilServicioImpl implements PerfilServicio {
	
	@Autowired
	private PerfilRepositorio perfilRepositorio;

	@Override
	@Transactional
	public List<Perfil> getPerfiles() {
		return perfilRepositorio.findAll();
	}
	
	@Override
	@Transactional
	public List<Perfil> getPerfilesActivos(CatEstatus catEstatus) {
		return perfilRepositorio.findByCatEstatus(catEstatus);
	}

	@Override
	@Transactional
	public void savePerfil(Perfil perfil) {
		perfilRepositorio.save(perfil);

	}

	@Override
	@Transactional
	public Optional<Perfil> getPerfil(int idPerfil) throws ResourceNotFoundException {
		return perfilRepositorio.findById(idPerfil);
	}

	@Override
	@Transactional
	public void deletePerfil(int idPerfil) throws ResourceNotFoundException {
		perfilRepositorio.deleteById(idPerfil);

	}

}
