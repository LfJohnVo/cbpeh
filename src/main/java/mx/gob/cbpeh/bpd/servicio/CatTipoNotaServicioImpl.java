package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.modelo.CatTipoNota;
import mx.gob.cbpeh.bpd.repositorio.CatTipoNotaRepositorio;

@Service
public class CatTipoNotaServicioImpl implements CatTipoNotaServicio {
	
	@Autowired
	private CatTipoNotaRepositorio tipoNotaRepositorio;

	@Override
	@Transactional
	public List<CatTipoNota> getCatTipoNotas() {
		return tipoNotaRepositorio.findAll();
	}
	
	@Override
	@Transactional
	public List<CatTipoNota> getCatTipoNotasActivas(CatEstatus catEstatus ) {
		return tipoNotaRepositorio.findByCatEstatus(catEstatus);
	}

	@Override
	@Transactional
	public void saveCatTipoNota(CatTipoNota tipoNota) {
		tipoNotaRepositorio.save(tipoNota);

	}

	@Override
	@Transactional
	public Optional<CatTipoNota> getCatTipoNota(int idTipoNota) throws ResourceNotFoundException {
		return tipoNotaRepositorio.findById(idTipoNota);
	}

	@Override
	@Transactional
	public void deleteCatTipoNota(int idTipoNota) throws ResourceNotFoundException {
		tipoNotaRepositorio.deleteById(idTipoNota);

	}

}
