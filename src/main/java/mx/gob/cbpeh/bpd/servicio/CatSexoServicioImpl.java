package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatSexo;
import mx.gob.cbpeh.bpd.repositorio.CatSexoRepositorio;

@Service
public class CatSexoServicioImpl implements CatSexoServicio {
	
	@Autowired
	private CatSexoRepositorio sexoRepositorio;

	@Override
	@Transactional
	public List<CatSexo> getCatSexo() {
		return sexoRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatSexo(CatSexo sexo) {
		sexoRepositorio.save(sexo);
	}

	@Override
	@Transactional
	public Optional<CatSexo> getCatSexo(int idSexo) throws ResourceNotFoundException {
		return sexoRepositorio.findById(idSexo);
	}

	@Override
	@Transactional
	public void deleteCatSexo(int idSexo) throws ResourceNotFoundException {
		sexoRepositorio.deleteById(idSexo);
	}

}
