package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatAccion;
import mx.gob.cbpeh.bpd.repositorio.CatAccionRepositorio;

@Service
public class CatAccionServicioImpl implements CatAccionServicio {

	@Autowired
	private CatAccionRepositorio accionRepositorio;

	@Override
	@Transactional
	public List<CatAccion> getCatAcciones() {
		return accionRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatAccion(CatAccion theCustomer) {
		accionRepositorio.save(theCustomer);
	}

    @Override
    @Transactional
    public Optional<CatAccion> getCatAccion(int id) throws ResourceNotFoundException {
        return accionRepositorio.findById(id);
    }

	@Override
	@Transactional
	public void deleteCatAccion(int theId) {
		accionRepositorio.deleteById(theId);
	}

}
