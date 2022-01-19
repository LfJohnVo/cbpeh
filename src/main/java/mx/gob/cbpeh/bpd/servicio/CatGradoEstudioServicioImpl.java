package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatGradoEstudio;
import mx.gob.cbpeh.bpd.repositorio.CatGradoEstudioRepositorio;

@Service
public class CatGradoEstudioServicioImpl implements CatGradoEstudioServicio {
	
	@Autowired
	private CatGradoEstudioRepositorio gradoEstudioRepositorio;

	@Override
	@Transactional
	public List<CatGradoEstudio> getCatGradoEstudio() {
		return gradoEstudioRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatGradoEstudio(CatGradoEstudio gradoEstudio) {
		gradoEstudioRepositorio.save(gradoEstudio);
	}

	@Override
	@Transactional
	public Optional<CatGradoEstudio> getCatGradoEstudio(int idGradoEstudio) throws ResourceNotFoundException {
		return gradoEstudioRepositorio.findById(idGradoEstudio);
	}

	@Override
	@Transactional
	public void deleteCatGradoEstudio(int idGradoEstudio) throws ResourceNotFoundException {
		gradoEstudioRepositorio.deleteById(idGradoEstudio);
	}

}
