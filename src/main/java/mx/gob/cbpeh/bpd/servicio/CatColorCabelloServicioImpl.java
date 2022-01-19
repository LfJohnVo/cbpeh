package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatColorCabello;
import mx.gob.cbpeh.bpd.repositorio.CatColorCabelloRepositorio;

@Service
public class CatColorCabelloServicioImpl implements CatColorCabelloServicio {

	@Autowired
	private CatColorCabelloRepositorio colorCabelloRepositorio;

	@Override
	@Transactional
	public List<CatColorCabello> getCatColorCabellos() {
		return colorCabelloRepositorio.findAll();
	}		

	@Override
	@Transactional
	public void saveCatColorCabello(CatColorCabello colorCabello) {
		colorCabelloRepositorio.save(colorCabello);		
	}

	@Override
	@Transactional
	public Optional<CatColorCabello> getCatColorCabello(int idColorCabello) throws ResourceNotFoundException {
		return colorCabelloRepositorio.findById(idColorCabello);
	}

	@Override
	@Transactional
	public void deleteCatColorCabello(int idColorCabello) throws ResourceNotFoundException {
		colorCabelloRepositorio.deleteById(idColorCabello);
		
	}


}
