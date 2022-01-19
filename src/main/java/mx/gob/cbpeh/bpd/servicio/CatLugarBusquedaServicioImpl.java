package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatLugarBusqueda;
import mx.gob.cbpeh.bpd.repositorio.CatLugarBusquedaRepositorio;

@Service
public class CatLugarBusquedaServicioImpl implements CatLugarBusquedaServicio {
	
	@Autowired
	private CatLugarBusquedaRepositorio catLugarbusquedaRepositorio;

	@Override
	@Transactional
	public List<CatLugarBusqueda> getCatLugarBusqueda() {		
		return catLugarbusquedaRepositorio.findAll();
	}

	@Override
	@Transactional
	public CatLugarBusqueda saveCatLugarBusqueda(CatLugarBusqueda busqueda) {
		CatLugarBusqueda elementoGuardado=null;
		elementoGuardado=catLugarbusquedaRepositorio.save(busqueda);
		return elementoGuardado;
	}

	@Override
	@Transactional
	public Optional<CatLugarBusqueda> getCatLugarBusqueda(int idCatLugarBusqueda) throws ResourceNotFoundException {		
		return catLugarbusquedaRepositorio.findById(idCatLugarBusqueda);
	}

	@Override
	@Transactional
	public void deleteCatLugarBusqueda(int idBusqueda) throws ResourceNotFoundException {		
		catLugarbusquedaRepositorio.deleteById(idBusqueda);
	}


}
