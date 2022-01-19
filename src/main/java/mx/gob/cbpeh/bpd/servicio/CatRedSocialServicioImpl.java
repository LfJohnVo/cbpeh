package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatRedSocial;
import mx.gob.cbpeh.bpd.repositorio.CatRedSocialRepositorio;

@Service
public class CatRedSocialServicioImpl implements CatRedSocialServicio {
	
	@Autowired
	private CatRedSocialRepositorio redSocialRepositorio;

	@Override
	@Transactional
	public List<CatRedSocial> getCatRedSocial() {
		return redSocialRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatRedSocial(CatRedSocial redSocial) {
		redSocialRepositorio.save(redSocial);
	}

	@Override
	@Transactional
	public Optional<CatRedSocial> getCatRedSocial(int idRedSocial) throws ResourceNotFoundException {
		return redSocialRepositorio.findById(idRedSocial);
	}

	@Override
	@Transactional
	public void deleteCatRedSocial(int idRedSocial) throws ResourceNotFoundException {
		redSocialRepositorio.deleteById(idRedSocial);
	}

}
