package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatColorOjo;
import mx.gob.cbpeh.bpd.repositorio.CatColorOjoRepositorio;

@Service
public class CatColorOjoServicioImpl implements CatColorOjoServicio {
	
	@Autowired
	private CatColorOjoRepositorio colorOjoRepositorio;

	@Override
	@Transactional
	public List<CatColorOjo> getCatColorOjos() {
		return colorOjoRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatColorOjo(CatColorOjo colorOjo) {
		colorOjoRepositorio.save(colorOjo);
	}

	@Override
	@Transactional
	public Optional<CatColorOjo> getCatColorOjo(int idColorOjo) throws ResourceNotFoundException {
		return colorOjoRepositorio.findById(idColorOjo);
	}

	@Override
	@Transactional
	public void deleteCatColorOjo(int idColorOjo) throws ResourceNotFoundException {
		colorOjoRepositorio.deleteById(idColorOjo);
	}

}
