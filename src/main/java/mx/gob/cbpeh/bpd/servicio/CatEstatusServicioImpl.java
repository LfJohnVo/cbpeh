package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.repositorio.CatEstatusRepositorio;

@Service
public class CatEstatusServicioImpl implements CatEstatusServicio {
	
	@Autowired
	private CatEstatusRepositorio estatusRepositorio;

	@Override
	@Transactional
	public List<CatEstatus> getCatEstatus() {
		return estatusRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatEstatus(CatEstatus estatus) {
		estatusRepositorio.save(estatus);		
	}

	@Override
	@Transactional
	public Optional<CatEstatus> getCatEstatus(int idEstatus) throws ResourceNotFoundException {
		return estatusRepositorio.findById(idEstatus);
	}

	@Override
	@Transactional
	public void deleteCatEstatus(int idEstatus) throws ResourceNotFoundException {
		estatusRepositorio.deleteById(idEstatus);
		
	}
	
	
}
