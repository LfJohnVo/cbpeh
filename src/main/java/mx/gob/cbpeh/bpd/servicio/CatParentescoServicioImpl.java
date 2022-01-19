package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.modelo.CatParentesco;
import mx.gob.cbpeh.bpd.repositorio.CatParentescoRepositorio;

@Service
public class CatParentescoServicioImpl implements CatParentescoServicio {
	
	@Autowired
	private CatParentescoRepositorio parentescoRepositorio;

	@Override
	@Transactional
	public List<CatParentesco> getCatParentescos() {
		return parentescoRepositorio.findAll();
	}
	
	@Override
	@Transactional
	public List<CatParentesco> getCatParentescosActivos(CatEstatus catEstatus) {
		return parentescoRepositorio.findByCatEstatus(catEstatus);
	}

	@Override
	@Transactional
	public void saveCatParentesco(CatParentesco parentesco) {
		parentescoRepositorio.save(parentesco);
	}

	@Override
	@Transactional
	public Optional<CatParentesco> getCatParentesco(int idParentesco) throws ResourceNotFoundException {
		return parentescoRepositorio.findById(idParentesco);
	}

	@Override
	@Transactional
	public void deleteCatParentesco(int idParentesco) throws ResourceNotFoundException {
		parentescoRepositorio.deleteById(idParentesco);
	}

}
