package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.Colaboracion;
import mx.gob.cbpeh.bpd.repositorio.ColaboracionRepositorio;

@Service
public class ColaboracionServicioImpl implements ColaboracionServicio {
	
	@Autowired
	private ColaboracionRepositorio catLugarbusquedaRepositorio;

	@Override
	@Transactional
	public List<Colaboracion> getColaboracion() {		
		return catLugarbusquedaRepositorio.findAll();
	}

	@Override
	@Transactional
	public Colaboracion saveColaboracion(Colaboracion busqueda) {
		Colaboracion elementoGuardado=null;
		elementoGuardado=catLugarbusquedaRepositorio.save(busqueda);
		return elementoGuardado;
	}

	@Override
	@Transactional
	public Optional<Colaboracion> getColaboracion(int idColaboracion) throws ResourceNotFoundException {		
		return catLugarbusquedaRepositorio.findById(idColaboracion);
	}

	@Override
	@Transactional
	public void deleteColaboracion(int idBusqueda) throws ResourceNotFoundException {		
		catLugarbusquedaRepositorio.deleteById(idBusqueda);
	}
	
	@Override
	@Transactional
	public String getFolioColaboracion(String institucion, String inicialesNombre) {
		return catLugarbusquedaRepositorio.generarFolioColaboracion(institucion, inicialesNombre);
	}


}
