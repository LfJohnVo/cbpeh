package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatFrente;
import mx.gob.cbpeh.bpd.repositorio.CatFrenteRepositorio;

@Service
public class CatFrenteServicioImpl implements CatFrenteServicio {
	
	@Autowired
	private CatFrenteRepositorio frenteRepositorio;

	@Override
	@Transactional
	public List<CatFrente> getCatFrente() {
		return frenteRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatFrente(CatFrente frente) {
		frenteRepositorio.save(frente);
	}

	@Override
	@Transactional
	public Optional<CatFrente> getCatFrente(int idFrente) throws ResourceNotFoundException {
		return frenteRepositorio.findById(idFrente);
	}

	@Override
	@Transactional
	public void deleteCatFrente(int idFrente) throws ResourceNotFoundException {
		frenteRepositorio.deleteById(idFrente);
	}

}
