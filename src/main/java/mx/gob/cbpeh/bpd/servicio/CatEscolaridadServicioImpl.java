package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEscolaridad;
import mx.gob.cbpeh.bpd.repositorio.CatEscolaridadRepositorio;

@Service
public class CatEscolaridadServicioImpl implements CatEscolaridadServicio {
	
	@Autowired	
	private CatEscolaridadRepositorio escolaridadRepositorio;

	@Override
	@Transactional
	public List<CatEscolaridad> getCatEscolaridad() {
		return escolaridadRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatEscolaridad(CatEscolaridad escolaridad) {
		escolaridadRepositorio.save(escolaridad);
		
	}

	@Override
	@Transactional
	public Optional<CatEscolaridad> getCatEscolaridad(int idEscolaridad) throws ResourceNotFoundException {
		return escolaridadRepositorio.findById(idEscolaridad);
	}

	@Override
	@Transactional
	public void deleteCatEscolaridad(int idEscolaridad) throws ResourceNotFoundException {
		escolaridadRepositorio.deleteById(idEscolaridad);
		
	}
}
