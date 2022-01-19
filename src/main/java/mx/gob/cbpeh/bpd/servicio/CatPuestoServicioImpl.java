package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.modelo.CatPuesto;
import mx.gob.cbpeh.bpd.repositorio.CatPuestoRepositorio;

@Service
public class CatPuestoServicioImpl implements CatPuestoServicio {
	
	@Autowired
	private CatPuestoRepositorio puestoRepositorio;

	@Override
	@Transactional
	public List<CatPuesto> getCatPuestos() {
		return puestoRepositorio.findAll();
	}
	
	@Override
	@Transactional
	public List<CatPuesto> getCatPuestosActivos(CatEstatus catEstatus) {
		return puestoRepositorio.findByCatEstatus(catEstatus);
	}

	@Override
	@Transactional
	public void saveCatPuesto(CatPuesto puesto) {
		puestoRepositorio.save(puesto);
	}

	@Override
	@Transactional
	public Optional<CatPuesto> getCatPuesto(int idPuesto) throws ResourceNotFoundException {
		return puestoRepositorio.findById(idPuesto);
	}

	@Override
	@Transactional
	public void deleteCatPuesto(int idPuesto) throws ResourceNotFoundException {
		puestoRepositorio.deleteById(idPuesto);
	}

}
