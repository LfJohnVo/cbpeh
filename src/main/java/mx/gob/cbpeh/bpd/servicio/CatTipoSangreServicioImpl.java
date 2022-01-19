package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatTipoSangre;
import mx.gob.cbpeh.bpd.repositorio.CatTipoSangreRepositorio;

@Service
public class CatTipoSangreServicioImpl implements CatTipoSangreServicio {
	
	@Autowired
	private CatTipoSangreRepositorio tipoSangreRepositorio;

	@Override
	@Transactional
	public List<CatTipoSangre> getCatTipoSangre() {
		return tipoSangreRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatTipoSangre(CatTipoSangre tipoSangre) {
		tipoSangreRepositorio.save(tipoSangre);
	}

	@Override
	@Transactional
	public Optional<CatTipoSangre> getCatTipoSangre(int idTipoSangre) throws ResourceNotFoundException {
		return tipoSangreRepositorio.findById(idTipoSangre);
	}

	@Override
	@Transactional
	public void deleteCatTipoSangre(int idTipoSangre) throws ResourceNotFoundException {
		tipoSangreRepositorio.deleteById(idTipoSangre);
	}

}
