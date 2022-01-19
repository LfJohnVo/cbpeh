package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.ExpedienteIncompetencia;
import mx.gob.cbpeh.bpd.repositorio.ExpedienteIncompetenciaRepositorio;

@Service
public class ExpedienteIncompetenciaServicioImpl implements ExpedienteIncompetenciaServicio {
	
	@Autowired
	private ExpedienteIncompetenciaRepositorio expedienteIncompetenciaRepositorio;

	@Override
	@Transactional
	public List<ExpedienteIncompetencia> getExpedienteIncompetencias() {
		return expedienteIncompetenciaRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveExpedienteIncompetencia(ExpedienteIncompetencia expedienteIncompetencia) {
		expedienteIncompetenciaRepositorio.save(expedienteIncompetencia);
	}

	@Override
	@Transactional
	public Optional<ExpedienteIncompetencia> getExpedienteIncompetencia(int idExpedienteIncompetencia)
			throws ResourceNotFoundException {
		return expedienteIncompetenciaRepositorio.findById(idExpedienteIncompetencia);
	}

	@Override
	@Transactional
	public void deleteExpedienteIncompetencia(int idExpedienteIncompetencia) throws ResourceNotFoundException {
		expedienteIncompetenciaRepositorio.deleteById(idExpedienteIncompetencia);
	}

}
