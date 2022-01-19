package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstatusVida;
import mx.gob.cbpeh.bpd.repositorio.CatEstatusVidaRepositorio;

@Service
public class CatEstatusVidaServicioImpl implements CatEstatusVidaServicio {
	
	@Autowired
	private CatEstatusVidaRepositorio estatusVidaRepositorio;

	@Override
	@Transactional
	public List<CatEstatusVida> getCatEstatusVida() {
		return estatusVidaRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatEstatusVida(CatEstatusVida estatusVida) {
		estatusVidaRepositorio.save(estatusVida);
	}

	@Override
	@Transactional
	public Optional<CatEstatusVida> getCatEstatusVida(int idEstatusVida) throws ResourceNotFoundException {
		return estatusVidaRepositorio.findById(idEstatusVida);
	}

	@Override
	@Transactional
	public void deleteCatEstatusVida(int idEstatusVida) throws ResourceNotFoundException {
		estatusVidaRepositorio.deleteById(idEstatusVida);		
	}

}
