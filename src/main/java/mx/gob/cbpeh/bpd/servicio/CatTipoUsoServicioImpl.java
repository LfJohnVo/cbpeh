package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatTipoUso;
import mx.gob.cbpeh.bpd.repositorio.CatTipoUsoRepositorio;

@Service
public class CatTipoUsoServicioImpl implements CatTipoUsoServicio {

	@Autowired
	private CatTipoUsoRepositorio tipoUsoRepositorio;
	
	@Override
	@Transactional
	public List<CatTipoUso> getCatTipoUsos() {
		return tipoUsoRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatTipoUso(CatTipoUso tipoUso) {
		tipoUsoRepositorio.save(tipoUso);
	}

	@Override
	@Transactional
	public Optional<CatTipoUso> getCatTipoUso(int idTipoUso) throws ResourceNotFoundException {
		return tipoUsoRepositorio.findById(idTipoUso);
	}

	@Override
	@Transactional
	public void deleteCatTipoUso(int idTipoUso) throws ResourceNotFoundException {
		tipoUsoRepositorio.deleteById(idTipoUso);

	}

}
