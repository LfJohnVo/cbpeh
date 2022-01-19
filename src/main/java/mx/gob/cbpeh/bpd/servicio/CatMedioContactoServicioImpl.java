package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatMedioContacto;
import mx.gob.cbpeh.bpd.repositorio.CatMedioContactoRepositorio;

@Service
public class CatMedioContactoServicioImpl implements CatMedioContactoServicio {
	
	@Autowired
	private CatMedioContactoRepositorio medioContactoRepositorio;

	@Override
	@Transactional
	public List<CatMedioContacto> getCatMedioContactos() {
		return medioContactoRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatMedioContacto(CatMedioContacto medioContacto) {
		medioContactoRepositorio.save(medioContacto);
	}

	@Override
	@Transactional
	public Optional<CatMedioContacto> getCatMedioContacto(int idMedioContacto) throws ResourceNotFoundException {
		return medioContactoRepositorio.findById(idMedioContacto);
	}

	@Override
	@Transactional
	public void deleteCatMedioContacto(int idMedioContacto) throws ResourceNotFoundException {
		medioContactoRepositorio.deleteById(idMedioContacto);
	}

}
