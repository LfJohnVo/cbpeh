package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatTez;
import mx.gob.cbpeh.bpd.repositorio.CatTezRepositorio;

@Service
public class CatTezServicioImpl implements CatTezServicio {
	
	@Autowired
	private CatTezRepositorio tezRepositorio;

	@Override
	@Transactional
	public List<CatTez> getCatTez() {
		return tezRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatTez(CatTez tez) {
		tezRepositorio.save(tez);
	}

	@Override
	@Transactional
	public Optional<CatTez> getCatTez(int idTez) throws ResourceNotFoundException {
		return tezRepositorio.findById(idTez);
	}

	@Override
	@Transactional
	public void deleteCatTez(int idTez) throws ResourceNotFoundException {
		tezRepositorio.deleteById(idTez);
	}

}
