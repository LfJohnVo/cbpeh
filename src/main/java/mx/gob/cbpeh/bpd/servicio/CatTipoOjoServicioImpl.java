package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatTipoOjo;
import mx.gob.cbpeh.bpd.repositorio.CatTipoOjoRepositorio;

@Service
public class CatTipoOjoServicioImpl implements CatTipoOjoServicio {
	
	@Autowired
	private CatTipoOjoRepositorio tipoOjoRepositorio;
	
	@Override
	@Transactional
	public List<CatTipoOjo> getCatTipoOjos() {
		return tipoOjoRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatTipoOjo(CatTipoOjo tipoOjo) {
		tipoOjoRepositorio.save(tipoOjo);

	}

	@Override
	@Transactional
	public Optional<CatTipoOjo> getCatTipoOjo(int idTipoOjo) throws ResourceNotFoundException {
		return tipoOjoRepositorio.findById(idTipoOjo);
	}

	@Override
	@Transactional
	public void deleteCatTipoOjo(int idTipoOjo) throws ResourceNotFoundException {
		tipoOjoRepositorio.deleteById(idTipoOjo);

	}

}
