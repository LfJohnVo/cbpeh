package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatDentadura;
import mx.gob.cbpeh.bpd.repositorio.CatDentaduraRepositorio;

@Service
public class CatDentaduraServicioImpl implements CatDentaduraServicio {
	
	@Autowired
	private CatDentaduraRepositorio dentaduraRepositorio;

	@Override
	@Transactional
	public List<CatDentadura> getCatDentaduras() {
		return dentaduraRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatDentadura(CatDentadura dentadura) {
		dentaduraRepositorio.save(dentadura);		
	}

	@Override
	@Transactional
	public Optional<CatDentadura> getCatDentadura(int idDentadura) throws ResourceNotFoundException {
		return dentaduraRepositorio.findById(idDentadura);
	}

	@Override
	@Transactional
	public void deleteCatDentadura(int idDentadura) throws ResourceNotFoundException {
		dentaduraRepositorio.deleteById(idDentadura);		
	}

}
