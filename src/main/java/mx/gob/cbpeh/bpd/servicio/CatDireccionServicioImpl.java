package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatDireccion;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.repositorio.CatDireccionRepositorio;

@Service
public class CatDireccionServicioImpl implements CatDireccionServicio {
	
	@Autowired
	private CatDireccionRepositorio direccionRepositorio;

	@Override
	@Transactional
	public List<CatDireccion> getCatDirecciones() {
		return direccionRepositorio.findAll();
	}
	
	@Override
	@Transactional
	public List<CatDireccion> getCatDireccionesActivas(CatEstatus catEstatus) {
		return direccionRepositorio.findByCatEstatus(catEstatus);
	}

	@Override
	@Transactional
	public void saveCatDireccion(CatDireccion direccion) {
		direccionRepositorio.save(direccion);		
	}

	@Override
	@Transactional
	public Optional<CatDireccion> getCatDireccion(int idDireccion) throws ResourceNotFoundException {
		return direccionRepositorio.findById(idDireccion);
	}

	@Override
	@Transactional
	public void deleteCatDireccion(int idDireccion) throws ResourceNotFoundException {
		direccionRepositorio.deleteById(idDireccion);		
	}

}
