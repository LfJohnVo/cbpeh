package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstatusColaboracion;
import mx.gob.cbpeh.bpd.repositorio.CatEstatusColaboracionRepositorio;

@Service
public class CatEstatusColaboracionServicioImpl implements CatEstatusColaboracionServicio {

	@Autowired
	private CatEstatusColaboracionRepositorio estatusColaboracionRepositorio;

	@Override
	@Transactional
	public List<CatEstatusColaboracion> getCatEstatusColaboracions() {
		return estatusColaboracionRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatEstatusColaboracion(CatEstatusColaboracion estatusColaboracion) {
		estatusColaboracionRepositorio.save(estatusColaboracion);
		
	}

	@Override
	@Transactional
	public Optional<CatEstatusColaboracion> getCatEstatusColaboracion(int idEstatusColaboracion)
			throws ResourceNotFoundException {
		return estatusColaboracionRepositorio.findById(idEstatusColaboracion);
	}

	@Override
	@Transactional
	public void deleteCatEstatusColaboracion(int idEstatusColaboracion) throws ResourceNotFoundException {
		estatusColaboracionRepositorio.deleteById(idEstatusColaboracion);
		
	}
	
	

}
