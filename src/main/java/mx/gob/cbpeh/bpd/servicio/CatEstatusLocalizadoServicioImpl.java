package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstatusLocalizado;
import mx.gob.cbpeh.bpd.repositorio.CatEstatusLocalizadoRepositorio;

@Service
public class CatEstatusLocalizadoServicioImpl implements CatEstatusLocalizadoServicio {

	@Autowired
	private CatEstatusLocalizadoRepositorio estatusLocalizadoRepositorio;

	@Override
	@Transactional
	public List<CatEstatusLocalizado> getCatEstatusLocalizados() {
		return estatusLocalizadoRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatEstatusLocalizado(CatEstatusLocalizado estatusLocalizado) {
		estatusLocalizadoRepositorio.save(estatusLocalizado);
		
	}

	@Override
	@Transactional
	public CatEstatusLocalizado getCatEstatusLocalizado(int idEstatusLocalizado)
			throws ResourceNotFoundException {
		return estatusLocalizadoRepositorio.findByIdEstatusLocalizado(idEstatusLocalizado);
	}

	@Override
	@Transactional
	public void deleteCatEstatusLocalizado(int idEstatusLocalizado) throws ResourceNotFoundException {
		estatusLocalizadoRepositorio.deleteById(idEstatusLocalizado);
		
	}
	
	

}
