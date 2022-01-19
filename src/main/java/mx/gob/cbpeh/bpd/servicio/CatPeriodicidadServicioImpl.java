package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatPeriodicidad;
import mx.gob.cbpeh.bpd.repositorio.CatPeriodicidadRepositorio;

@Service
public class CatPeriodicidadServicioImpl implements CatPeriodicidadServicio {
	
	@Autowired
	private CatPeriodicidadRepositorio periodicidadRepositorio;

	@Override
	@Transactional
	public List<CatPeriodicidad> getCatPeriodicidad() {
		return periodicidadRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatPeriodicidad(CatPeriodicidad periodicidad) {
		periodicidadRepositorio.save(periodicidad);
	}

	@Override
	@Transactional
	public Optional<CatPeriodicidad> getCatPeriodicidad(int idPeriodicidad) throws ResourceNotFoundException {
		return periodicidadRepositorio.findById(idPeriodicidad);
	}

	@Override
	@Transactional
	public void deleteCatPeriodicidad(int idPeriodicidad) throws ResourceNotFoundException {
		periodicidadRepositorio.deleteById(idPeriodicidad);
	}

}
