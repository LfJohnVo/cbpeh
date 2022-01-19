package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatTipoIdentificacion;
import mx.gob.cbpeh.bpd.repositorio.CatTipoIdentificacionRepositorio;

@Service
public class CatTipoIdentificacionServicioImpl implements CatTipoIdentificacionServicio {
	
	@Autowired
	private CatTipoIdentificacionRepositorio tipoIdentificacionRepositorio;

	@Override
	@Transactional
	public List<CatTipoIdentificacion> getCatTipoIdentificacion() {
		return tipoIdentificacionRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatTipoIdentificacion(CatTipoIdentificacion tipoIdentificacion) {
		tipoIdentificacionRepositorio.save(tipoIdentificacion);

	}

	@Override
	@Transactional
	public Optional<CatTipoIdentificacion> getCatTipoIdentificacion(int idTipoIdentificacion)
			throws ResourceNotFoundException {
		return tipoIdentificacionRepositorio.findById(idTipoIdentificacion);
	}

	@Override
	@Transactional
	public void deleteCatTipoIdentificacion(int idTipoIdentificacion) throws ResourceNotFoundException {
		tipoIdentificacionRepositorio.deleteById(idTipoIdentificacion);

	}

}
