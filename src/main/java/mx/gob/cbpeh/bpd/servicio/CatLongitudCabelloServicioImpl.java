package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatLongitudCabello;
import mx.gob.cbpeh.bpd.repositorio.CatLongitudCabelloRepositorio;

@Service
public class CatLongitudCabelloServicioImpl implements CatLongitudCabelloServicio {
	
	@Autowired
	private CatLongitudCabelloRepositorio longitudCabelloRepositorio;

	@Override
	@Transactional
	public List<CatLongitudCabello> getCatLongitudCabello() {
		return longitudCabelloRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatLongitudCabello(CatLongitudCabello longitudCabello) {
		longitudCabelloRepositorio.save(longitudCabello);
	}

	@Override
	@Transactional
	public Optional<CatLongitudCabello> getCatLongitudCabello(int idCatLongitudCabello)
			throws ResourceNotFoundException {
		return longitudCabelloRepositorio.findById(idCatLongitudCabello);
	}

	@Override
	@Transactional
	public void deleteCatLongitudCabello(int idCatLongitudCabello) throws ResourceNotFoundException {
		longitudCabelloRepositorio.deleteById(idCatLongitudCabello);
	}

}
