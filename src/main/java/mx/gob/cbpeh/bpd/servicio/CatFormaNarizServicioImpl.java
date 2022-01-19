package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatFormaNariz;
import mx.gob.cbpeh.bpd.repositorio.CatFormaNarizRepositorio;
@Service
public class CatFormaNarizServicioImpl implements CatFormaNarizServicio {
	
	@Autowired
	private CatFormaNarizRepositorio formaNarizRepositorio;

	@Override
	@Transactional
	public List<CatFormaNariz> getCatFormaNariz() {
		return formaNarizRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatFormaNariz(CatFormaNariz formaNariz) {
		formaNarizRepositorio.save(formaNariz);
	}

	@Override
	@Transactional
	public Optional<CatFormaNariz> getCatFormaNariz(int idFormaNariz) throws ResourceNotFoundException {
		return formaNarizRepositorio.findById(idFormaNariz);
	}

	@Override
	@Transactional
	public void deleteCatFormaNariz(int idFormaNariz) throws ResourceNotFoundException {
		formaNarizRepositorio.deleteById(idFormaNariz);
	}

}
