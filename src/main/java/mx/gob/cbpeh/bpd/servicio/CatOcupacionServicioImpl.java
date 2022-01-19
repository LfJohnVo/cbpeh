package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatOcupacion;
import mx.gob.cbpeh.bpd.repositorio.CatOcupacionRepositorio;

@Service
public class CatOcupacionServicioImpl implements CatOcupacionServicio {

	@Autowired
	private CatOcupacionRepositorio ocupacionRepositorio;
	
	@Override
	@Transactional
	public List<CatOcupacion> getCatOcupacion() {
		return ocupacionRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatOcupacion(CatOcupacion ocupacion) {
		ocupacionRepositorio.save(ocupacion);
	}

	@Override
	@Transactional
	public Optional<CatOcupacion> getCatOcupacion(int idOcupacion) throws ResourceNotFoundException {
		return ocupacionRepositorio.findById(idOcupacion);
	}

	@Override
	@Transactional
	public void deleteCatOcupacion(int idOcupacion) throws ResourceNotFoundException {
		ocupacionRepositorio.deleteById(idOcupacion);
	}

}
