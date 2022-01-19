package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.Busqueda;
import mx.gob.cbpeh.bpd.repositorio.BusquedaRepositorio;

@Service
public class BusquedaServicioImpl implements BusquedaServicio {
	
	@Autowired
	private BusquedaRepositorio busquedaRepositorio;

	@Override
	@Transactional
	public List<Busqueda> getBusquedas() {		
		return busquedaRepositorio.findAll();
	}

	@Override
	@Transactional
	public Busqueda saveBusqueda(Busqueda busqueda) {
		Busqueda elementoGuardado=null;
		elementoGuardado=busquedaRepositorio.save(busqueda);
		return elementoGuardado;
	}

	@Override
	@Transactional
	public Optional<Busqueda> getBusqueda(int idBusqueda) throws ResourceNotFoundException {		
		return busquedaRepositorio.findById(idBusqueda);
	}

	@Override
	@Transactional
	public void deleteBusqueda(int idBusqueda) throws ResourceNotFoundException {		
		busquedaRepositorio.deleteById(idBusqueda);
	}

	@Override
	public List<Busqueda> getBusquedas(String expediente) {
		return busquedaRepositorio.findByExpediente(expediente);
	}


}
