package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstatusEconomico;
import mx.gob.cbpeh.bpd.repositorio.CatEstatusEconomicoRepositorio;

@Service
public class CatEstatusEconomicoServicioImpl implements CatEstatusEconomicoServicio{
	
	@Autowired
	private CatEstatusEconomicoRepositorio estatusEconomicoRepositorio;

	@Override
	@Transactional
	public List<CatEstatusEconomico> getCatEstatusEconomicos() {
		return estatusEconomicoRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatEstatusEconomico(CatEstatusEconomico estatusEconomico) {
		estatusEconomicoRepositorio.save(estatusEconomico);
		
	}

	@Override
	@Transactional
	public Optional<CatEstatusEconomico> getCatEstatusEconomico(int idEstatusEconomico)
			throws ResourceNotFoundException {
		return estatusEconomicoRepositorio.findById(idEstatusEconomico);
	}

	@Override
	@Transactional
	public void deleteCatEstatusEconomico(int idEstatusEconomico) throws ResourceNotFoundException {
		estatusEconomicoRepositorio.deleteById(idEstatusEconomico);		
	}

}
