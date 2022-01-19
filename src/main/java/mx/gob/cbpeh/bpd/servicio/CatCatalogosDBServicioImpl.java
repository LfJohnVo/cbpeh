package mx.gob.cbpeh.bpd.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatCatalogosDB;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.repositorio.CatCatalogosDBRepositorio;


@Service
public class CatCatalogosDBServicioImpl implements CatCatalogosDBServicio {
	
	@Autowired
	private CatCatalogosDBRepositorio catalogosDBRepositorio;

	@Override
	@Transactional
	public List<CatCatalogosDB> getCatCatalogos() {
		//return catalogosDBRepositorio.findAll();
		CatEstatus estatus= new CatEstatus();
		estatus.setIdEstatus(1);
		return catalogosDBRepositorio.findByCatEstatus(estatus);
	}

	@Override
	@Transactional
	public void saveCatCatalogo(CatCatalogosDB complexion) {
		catalogosDBRepositorio.save(complexion);		
	}

	@Override
	@Transactional
	public CatCatalogosDB getCatCatalogo(int idComplexion) throws ResourceNotFoundException {
		return catalogosDBRepositorio.findByIdCatalogo(idComplexion);
	}

	@Override
	@Transactional
	public void deleteCatCatalogo(int idComplexion) throws ResourceNotFoundException {
		catalogosDBRepositorio.deleteById(idComplexion);		
	}
}
