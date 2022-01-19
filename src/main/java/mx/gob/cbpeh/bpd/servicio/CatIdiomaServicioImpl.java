package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatIdioma;
import mx.gob.cbpeh.bpd.repositorio.CatIdiomaRepositorio;


@Service
public class CatIdiomaServicioImpl implements CatIdiomaServicio {
	
	@Autowired
	private CatIdiomaRepositorio idiomaRepositorio;

	@Override
	@Transactional
	public List<CatIdioma> getCatIdiomas() {
		return idiomaRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatIdioma(CatIdioma idioma) {
		idiomaRepositorio.save(idioma);
	}

	@Override
	@Transactional
	public Optional<CatIdioma> getCatIdioma(int idIdioma) throws ResourceNotFoundException {
		return idiomaRepositorio.findById(idIdioma);
	}

	@Override
	@Transactional
	public void deleteCatIdioma(int idIdioma) throws ResourceNotFoundException {
		idiomaRepositorio.deleteById(idIdioma);
	}

}
