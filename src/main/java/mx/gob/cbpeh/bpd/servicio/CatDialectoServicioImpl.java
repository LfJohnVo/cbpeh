package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatDialecto;
import mx.gob.cbpeh.bpd.repositorio.CatDialectoRepositorio;

@Service
public class CatDialectoServicioImpl implements CatDialectoServicio {
	
	@Autowired
	private CatDialectoRepositorio dialectoRepositorio;

	@Override
	@Transactional
	public List<CatDialecto> getCatDialectos() {		
		return dialectoRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatDialecto(CatDialecto dialecto) {		
		dialectoRepositorio.save(dialecto);
	}

	@Override
	@Transactional
	public Optional<CatDialecto> getCatDialecto(int idDialecto) throws ResourceNotFoundException {		
		return dialectoRepositorio.findById(idDialecto);
	}

	@Override
	@Transactional
	public void deleteCatDialecto(int idDialecto) throws ResourceNotFoundException {		
		dialectoRepositorio.deleteById(idDialecto);
	}


}
