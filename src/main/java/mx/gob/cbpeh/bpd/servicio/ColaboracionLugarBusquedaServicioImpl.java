package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.ColaboracionLugarBusqueda;
import mx.gob.cbpeh.bpd.repositorio.ColaboracionLugarBusquedaRepositorio;

@Service
public class ColaboracionLugarBusquedaServicioImpl implements ColaboracionLugarBusquedaServicio {
	
	@Autowired
	private ColaboracionLugarBusquedaRepositorio catLugarbusquedaRepositorio;

	@Override
	@Transactional
	public List<ColaboracionLugarBusqueda> getColaboracionLugarBusqueda() {		
		return catLugarbusquedaRepositorio.findAll();
	}

	@Override
	@Transactional
	public ColaboracionLugarBusqueda saveColaboracionLugarBusqueda(ColaboracionLugarBusqueda busqueda) {
		ColaboracionLugarBusqueda elementoGuardado=null;
		elementoGuardado=catLugarbusquedaRepositorio.save(busqueda);
		return elementoGuardado;
	}

	@Override
	@Transactional
	public Optional<ColaboracionLugarBusqueda> getColaboracionLugarBusqueda(int idColaboracionLugarBusqueda) throws ResourceNotFoundException {		
		return catLugarbusquedaRepositorio.findById(idColaboracionLugarBusqueda);
	}

	@Override
	@Transactional
	public void deleteColaboracionLugarBusqueda(int idBusqueda) throws ResourceNotFoundException {		
		catLugarbusquedaRepositorio.deleteById(idBusqueda);
	}


}
