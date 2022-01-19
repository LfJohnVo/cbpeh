package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatInstitucion;
import mx.gob.cbpeh.bpd.repositorio.CatInstitucionRepositorio;

@Service
public class CatInstitucionServicioImpl implements CatInstitucionServicio {
	
	@Autowired
	private CatInstitucionRepositorio institucionRepositorio;

	@Override
	@Transactional
	public List<CatInstitucion> getCatInstitucion() {
		return institucionRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatInstitucion(CatInstitucion estado) {
		institucionRepositorio.save(estado);		
	}

	@Override
	@Transactional
	public Optional<CatInstitucion> getCatInstitucion(int idInstitucion) throws ResourceNotFoundException {
		return institucionRepositorio.findById(idInstitucion);
	}

	@Override
	@Transactional
	public void deleteCatInstitucion(int idInstitucion) throws ResourceNotFoundException {
		institucionRepositorio.deleteById(idInstitucion);		
	}

}
