package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstadoCivil;
import mx.gob.cbpeh.bpd.repositorio.CatEstadoCivilRepositorio;

@Service
public class CatEstadoCivilServicioImpl implements CatEstadoCivilServicio {
	
	@Autowired
	private CatEstadoCivilRepositorio estadoCivilRepositorio;

	@Override
	@Transactional
	public List<CatEstadoCivil> getCatEstadoCivil() {
		return estadoCivilRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatEstadoCivil(CatEstadoCivil estadoCivil) {
		estadoCivilRepositorio.save(estadoCivil);
	}

	@Override
	@Transactional
	public Optional<CatEstadoCivil> getCatEstadoCivil(int idEstadoCivil) throws ResourceNotFoundException {
		return estadoCivilRepositorio.findById(idEstadoCivil);
	}

	@Override
	@Transactional
	public void deleteCatEstadoCivil(int idEstadoCivil) throws ResourceNotFoundException {
		estadoCivilRepositorio.deleteById(idEstadoCivil);		
	}

}
