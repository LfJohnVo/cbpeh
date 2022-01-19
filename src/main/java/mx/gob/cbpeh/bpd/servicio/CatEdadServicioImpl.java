package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEdad;
import mx.gob.cbpeh.bpd.repositorio.CatEdadRepositorio;

@Service
public class CatEdadServicioImpl implements CatEdadServicio {
	
	@Autowired
	private CatEdadRepositorio edadRepositorio;

	@Override
	@Transactional
	public List<CatEdad> getCatEdades(){
		return edadRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatEdad(CatEdad edad) {
		edadRepositorio.save(edad);		
	}

	@Override
	@Transactional
	public Optional<CatEdad> getCatEdad(int idEdad) throws ResourceNotFoundException {
		return edadRepositorio.findById(idEdad);
	}

	@Override
	@Transactional
	public void deleteCatEdad(int idEdad) throws ResourceNotFoundException {
		edadRepositorio.deleteById(idEdad);		
	}

}
