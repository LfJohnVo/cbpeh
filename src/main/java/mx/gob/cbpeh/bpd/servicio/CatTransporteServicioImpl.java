package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatTransporte;
import mx.gob.cbpeh.bpd.repositorio.CatTransporteRepositorio;

@Service
public class CatTransporteServicioImpl implements CatTransporteServicio {
	
	@Autowired
	private CatTransporteRepositorio transporteRepositorio;

	@Override
	@Transactional
	public List<CatTransporte> getCatTransportes() {
		return transporteRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatTransporte(CatTransporte transporte) {
		transporteRepositorio.save(transporte);
	}

	@Override
	@Transactional
	public Optional<CatTransporte> getCatTransporte(int idTransporte) throws ResourceNotFoundException {
		return transporteRepositorio.findById(idTransporte);
	}

	@Override
	@Transactional
	public void deleteCatTransporte(int idTransporte) throws ResourceNotFoundException {
		transporteRepositorio.deleteById(idTransporte);
	}

}
