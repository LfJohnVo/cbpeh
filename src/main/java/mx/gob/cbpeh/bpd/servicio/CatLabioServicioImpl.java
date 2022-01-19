package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatLabio;
import mx.gob.cbpeh.bpd.repositorio.CatLabioRepositorio;

@Service
public class CatLabioServicioImpl implements CatLabioServicio {
	
	@Autowired
	private CatLabioRepositorio labioRepositorio;

	@Override
	@Transactional
	public List<CatLabio> getCatLabios() {
		return labioRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatLabio(CatLabio labio) {
		labioRepositorio.save(labio);
	}

	@Override
	@Transactional
	public Optional<CatLabio> getCatLabio(int idLabio) throws ResourceNotFoundException {
		return labioRepositorio.findById(idLabio);
	}

	@Override
	@Transactional
	public void deleteCatLabio(int idLabio) throws ResourceNotFoundException {
		labioRepositorio.deleteById(idLabio);
	}

}
