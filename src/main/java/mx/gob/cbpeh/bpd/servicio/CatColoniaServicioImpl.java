package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatColonia;
import mx.gob.cbpeh.bpd.repositorio.CatColoniaRepositorio;

@Service
public class CatColoniaServicioImpl implements CatColoniaServicio {

	@Autowired
	private CatColoniaRepositorio coloniaRepositorio;

	@Override
	@Transactional
	public List<CatColonia> getCatColonias() {
		return coloniaRepositorio.findAll();
	}
	
	@Override
	@Transactional
	public List<CatColonia> getCatColoniasPorCp(String codigoCp) {	
		return coloniaRepositorio.findByCodigoCp(codigoCp);
	}

	@Override
	@Transactional
	public void saveCatColonia(CatColonia colonia) {
		coloniaRepositorio.save(colonia);		
	}

	@Override
	@Transactional
	public Optional<CatColonia> getCatColonia(int idColonia) throws ResourceNotFoundException {
		return coloniaRepositorio.findById(idColonia);
	}

	@Override
	@Transactional
	public void deleteCatColonia(int idColonia) throws ResourceNotFoundException {
		coloniaRepositorio.deleteById(idColonia);
		
	}
	
}
