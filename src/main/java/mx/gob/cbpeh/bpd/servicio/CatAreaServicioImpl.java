package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatArea;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.repositorio.CatAreaRepositorio;

@Service
public class CatAreaServicioImpl implements CatAreaServicio {
	
	@Autowired
	private CatAreaRepositorio areaRepositorio;

	@Override
	@Transactional
	public List<CatArea> getCatAreas() {
		return areaRepositorio.findAll();
	}

	@Override
	@Transactional
	public List<CatArea> getCatAreasActivas(CatEstatus catEstatus) {
		return areaRepositorio.findByCatEstatus(catEstatus);
	}
	
	@Override
	@Transactional
	public void saveCatArea(CatArea area) {
		areaRepositorio.save(area);		
	}

	@Override
	@Transactional
	public Optional<CatArea> getCatArea(int idArea) throws ResourceNotFoundException {
		return areaRepositorio.findById(idArea);
	}

	@Override
	@Transactional
	public void deleteCatArea(int idArea) throws ResourceNotFoundException {
		areaRepositorio.deleteById(idArea);
		
	}

}
