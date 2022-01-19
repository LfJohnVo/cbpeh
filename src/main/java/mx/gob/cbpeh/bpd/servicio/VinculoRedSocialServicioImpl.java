package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.VinculoRedSocial;
import mx.gob.cbpeh.bpd.repositorio.VinculoRedSocialRepositorio;

@Service
public class VinculoRedSocialServicioImpl implements VinculoRedSocialServicio{
	
	@Autowired
	private VinculoRedSocialRepositorio vinculoRedSocialRepositorio;

	@Override
	@Transactional
	public List<VinculoRedSocial> getVinculoRedSocial() {
		return vinculoRedSocialRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveVinculoRedSocial(VinculoRedSocial vinculoRedSocial) {
		vinculoRedSocialRepositorio.save(vinculoRedSocial);
		
	}

	@Override
	@Transactional
	public Optional<VinculoRedSocial> getVinculoRedSocial(int idVinculoRedSocial) throws ResourceNotFoundException {
		return vinculoRedSocialRepositorio.findById(idVinculoRedSocial);
	}

	@Override
	@Transactional
	public void deleteVinculoRedSocial(int idVinculoRedSocial) throws ResourceNotFoundException {
		vinculoRedSocialRepositorio.deleteById(idVinculoRedSocial);		
	}

}
