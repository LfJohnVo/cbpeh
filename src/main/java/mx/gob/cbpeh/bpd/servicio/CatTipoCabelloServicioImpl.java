package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatTipoCabello;
import mx.gob.cbpeh.bpd.repositorio.CatTipoCabelloRepositorio;

@Service
public class CatTipoCabelloServicioImpl implements CatTipoCabelloServicio {
	
	@Autowired
	private CatTipoCabelloRepositorio tipoCabelloRepositorio;

	@Override
	@Transactional
	public List<CatTipoCabello> getCatTipoCabello() {
		return tipoCabelloRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatTipoCabello(CatTipoCabello tipoCabello) {
		tipoCabelloRepositorio.save(tipoCabello);
	}

	@Override
	@Transactional
	public Optional<CatTipoCabello> getCatTipoCabello(int idTipoCabello) throws ResourceNotFoundException {
		return tipoCabelloRepositorio.findById(idTipoCabello);
	}

	@Override
	@Transactional
	public void deleteCatTipoCabello(int idTipoCabello) throws ResourceNotFoundException {
		tipoCabelloRepositorio.deleteById(idTipoCabello);

	}

}
