package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatComplexion;
import mx.gob.cbpeh.bpd.repositorio.CatComplexionRepositorio;

@Service
public class CatComplexionServicioImpl implements CatComplexionServicio {
	
	@Autowired
	private CatComplexionRepositorio complexionRepositorio;

	@Override
	@Transactional
	public List<CatComplexion> getCatComplexiones() {
		return complexionRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatComplexion(CatComplexion complexion) {
		complexionRepositorio.save(complexion);		
	}

	@Override
	@Transactional
	public Optional<CatComplexion> getCatComplexion(int idComplexion) throws ResourceNotFoundException {
		return complexionRepositorio.findById(idComplexion);
	}

	@Override
	@Transactional
	public void deleteCatComplexion(int idComplexion) throws ResourceNotFoundException {
		complexionRepositorio.deleteById(idComplexion);		
	}
}
