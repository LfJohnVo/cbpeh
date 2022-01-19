package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatGenero;
import mx.gob.cbpeh.bpd.repositorio.CatGeneroRepositorio;

@Service
public class CatGeneroServicioImpl implements CatGeneroServicio {
	
	@Autowired
	private CatGeneroRepositorio generoRepositorio;	

	@Override
	@Transactional
	public List<CatGenero> getCatGenero() {
		return generoRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatGenero(CatGenero genero) {
		generoRepositorio.save(genero);
	}

	@Override
	@Transactional
	public Optional<CatGenero> getCatGenero(int idGenero) throws ResourceNotFoundException {
		return generoRepositorio.findById(idGenero);
	}

	@Override
	@Transactional
	public void deleteCatGenero(int idGenero) throws ResourceNotFoundException {
		generoRepositorio.deleteById(idGenero);

	}

}
