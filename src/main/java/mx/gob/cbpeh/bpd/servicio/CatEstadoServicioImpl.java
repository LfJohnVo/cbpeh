package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstado;
import mx.gob.cbpeh.bpd.repositorio.CatEstadoRepositorio;

@Service
public class CatEstadoServicioImpl implements CatEstadoServicio {
	
	@Autowired
	private CatEstadoRepositorio estadoRepositorio;

	@Override
	@Transactional
	public List<CatEstado> getCatEstados() {
		return estadoRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatEstado(CatEstado estado) {
		estadoRepositorio.save(estado);		
	}

	@Override
	@Transactional
	public Optional<CatEstado> getCatEstado(int idEstado) throws ResourceNotFoundException {
		return estadoRepositorio.findById(idEstado);
	}

	@Override
	@Transactional
	public void deleteCatEstado(int idEstado) throws ResourceNotFoundException {
		estadoRepositorio.deleteById(idEstado);		
	}

}
