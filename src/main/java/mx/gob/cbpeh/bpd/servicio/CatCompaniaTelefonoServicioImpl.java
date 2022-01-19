package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatCompaniaTelefono;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.repositorio.CatCompaniaTelefonoRepositorio;

@Service
public class CatCompaniaTelefonoServicioImpl implements CatCompaniaTelefonoServicio {
	
	@Autowired
	private CatCompaniaTelefonoRepositorio companiaTelefonoRepositorio;

	@Override
	@Transactional
	public List<CatCompaniaTelefono> getCatCompaniaTelefonos() {
		return companiaTelefonoRepositorio.findAll();
	}
	
	@Override
	@Transactional
	public List<CatCompaniaTelefono> getCatCompaniaTelefonosActivas(CatEstatus catEstatus) {
		return companiaTelefonoRepositorio.findByCatEstatus(catEstatus);
	}

	@Override
	@Transactional
	public void saveCatCompaniaTelefono(CatCompaniaTelefono companiaTelefono) {
		companiaTelefonoRepositorio.save(companiaTelefono);		
	}

	@Override
	@Transactional
	public Optional<CatCompaniaTelefono> getCatCompaniaTelefono(int idCompaniaTelefono) throws ResourceNotFoundException {
		return companiaTelefonoRepositorio.findById(idCompaniaTelefono);
	}

	@Override
	@Transactional
	public void deleteCatCompaniaTelefono(int idCompaniaTelefono) throws ResourceNotFoundException {
		companiaTelefonoRepositorio.deleteById(idCompaniaTelefono);		
	}
}
