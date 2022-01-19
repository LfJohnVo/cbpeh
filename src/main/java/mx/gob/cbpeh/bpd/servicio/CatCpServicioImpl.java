package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatCp;
import mx.gob.cbpeh.bpd.repositorio.CatCpRepositorio;

@Service
public class CatCpServicioImpl implements CatCpServicio {
	
	@Autowired
	private CatCpRepositorio cpRepositorio;

	@Override
	@Transactional
	public List<CatCp> getCatCps() {
		return cpRepositorio.findAll();
	}
	
	@Override
	@Transactional
	public List<CatCp> getCatCpPorEstadoMunicipio(String codigoEstado,String codigoMunicipio) {
		return cpRepositorio.findByCodigoEstadoAndCodigoMunicipio(codigoEstado, codigoMunicipio);
	}	

	@Override
	@Transactional
	public void saveCatCps(CatCp cp) {
		cpRepositorio.save(cp);		
	}

	@Override
	@Transactional
	public Optional<CatCp> getCatCp(int idCp) throws ResourceNotFoundException {
		return cpRepositorio.findById(idCp);
	}

	@Override
	@Transactional
	public void deleteCatCp(int idCp) throws ResourceNotFoundException {
		cpRepositorio.deleteById(idCp);		
	}
}
