package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatBoca;
import mx.gob.cbpeh.bpd.repositorio.CatBocaRepositorio;

@Service
public class CatBocaServicioImpl implements CatBocaServicio {
	
	@Autowired	
	private CatBocaRepositorio bocaRepositorio;

	@Override
	@Transactional
	public List<CatBoca> getCatBocas() {
		return bocaRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatBoca(CatBoca boca) {
		bocaRepositorio.save(boca);		
	}

	@Override
	@Transactional
	public Optional<CatBoca> getCatBoca(int idBoca) throws ResourceNotFoundException {
		return bocaRepositorio.findById(idBoca);
	}

	@Override
	@Transactional
	public void deleteCatBoca(int idBoca) throws ResourceNotFoundException {
		bocaRepositorio.deleteById(idBoca);		
	}

}
