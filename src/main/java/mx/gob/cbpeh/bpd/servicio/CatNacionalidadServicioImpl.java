package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatNacionalidad;
import mx.gob.cbpeh.bpd.repositorio.CatNacionalidadRepositorio;

@Service
public class CatNacionalidadServicioImpl implements CatNacionalidadServicio {
	
	@Autowired
	private CatNacionalidadRepositorio nacionalidadRepositorio;

	@Override
	@Transactional
	public List<CatNacionalidad> getCatNacionalidad() {
		return nacionalidadRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatNacionalidad(CatNacionalidad nacionalidad) {
		nacionalidadRepositorio.save(nacionalidad);
	}

	@Override
	@Transactional
	public Optional<CatNacionalidad> getCatNacionalidad(int idNacionalidad) throws ResourceNotFoundException {
		return nacionalidadRepositorio.findById(idNacionalidad);
	}

	@Override
	@Transactional
	public void deleteCatNacionalidad(int idNacionalidad) throws ResourceNotFoundException {
		nacionalidadRepositorio.deleteById(idNacionalidad);
	}

}
