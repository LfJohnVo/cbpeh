package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatSiNo;
import mx.gob.cbpeh.bpd.repositorio.CatSiNoRepositorio;

@Service
public class CatSiNoServicioImpl implements CatSiNoServicio {
	
	@Autowired
	private CatSiNoRepositorio siNoRepositorio;

	@Override
	@Transactional
	public List<CatSiNo> getCatSiNo() {
		return siNoRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatSiNo(CatSiNo siNo) {
		siNoRepositorio.save(siNo);
	}

	@Override
	@Transactional
	public Optional<CatSiNo> getCatSiNo(int idSiNo) throws ResourceNotFoundException {
		return siNoRepositorio.findById(idSiNo);
	}

	@Override
	@Transactional
	public void deleteCatSiNo(int idSiNo) throws ResourceNotFoundException {
		siNoRepositorio.deleteById(idSiNo);
	}

}
