package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatTipoComunicado;
import mx.gob.cbpeh.bpd.repositorio.CatTipoComunicadoRepositorio;

@Service
public class CatComunicadoServicioImpl implements CatComunicadoServicio {
	
	@Autowired
	private CatTipoComunicadoRepositorio tipoComunicadoRepositorio;

	@Override
	@Transactional
	public List<CatTipoComunicado> getCatTipoComunicados() {
		return tipoComunicadoRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatTipoComunicado(CatTipoComunicado tipoComunicado) {
		tipoComunicadoRepositorio.save(tipoComunicado);

	}

	@Override
	@Transactional
	public Optional<CatTipoComunicado> getCatTipoComunicado(int idTipoComunicado) throws ResourceNotFoundException {
		return tipoComunicadoRepositorio.findById(idTipoComunicado);
	}

	@Override
	@Transactional
	public void deleteCatTipoComunicado(int idTipoComunicado) throws ResourceNotFoundException {
		tipoComunicadoRepositorio.deleteById(idTipoComunicado);

	}

}
