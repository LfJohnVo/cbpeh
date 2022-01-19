package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatBaseNariz;
import mx.gob.cbpeh.bpd.repositorio.CatBaseNarizRepositorio;

@Service
public class CatBaseNarizServicioImpl implements CatBaseNarizServicio {
	
	@Autowired
	private CatBaseNarizRepositorio baseNarizRepositorio;

	@Override
	@Transactional
	public List<CatBaseNariz> getCatBaseNariz() {
		return baseNarizRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatBaseNariz(CatBaseNariz baseNariz) {
		baseNarizRepositorio.save(baseNariz);		
	}

	@Override
	@Transactional
	public Optional<CatBaseNariz> getCatBaseNariz(int idBaseNariz) throws ResourceNotFoundException {
		return baseNarizRepositorio.findById(idBaseNariz);
	}

	@Override
	@Transactional
	public void deleteCatBaseNariz(int idBaseNariz) throws ResourceNotFoundException {
		baseNarizRepositorio.deleteById(idBaseNariz);		
	}

}
