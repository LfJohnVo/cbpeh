package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.ArchivoExpediente;
import mx.gob.cbpeh.bpd.repositorio.ArchivoExpedienteRepositorio;

@Service
public class ArchivoExpedienteServicioImpl implements ArchivoExpedienteServicio {

	@Autowired
	private ArchivoExpedienteRepositorio archivoExpedienteRepositorio;

	@Override
	@Transactional
	public List<ArchivoExpediente> getArchivoExpedientes() {
		return archivoExpedienteRepositorio.findAll();
	}

	@Override
	@Transactional
	public ArchivoExpediente saveArchivoExpediente(ArchivoExpediente archivoExpediente) {
		ArchivoExpediente archivo= null;
		archivo=archivoExpedienteRepositorio.save(archivoExpediente);
		return archivo;
	}

	@Override
	@Transactional
	public Optional<ArchivoExpediente> getArchivoExpediente(int idArchivoExpediente) throws ResourceNotFoundException {
		return archivoExpedienteRepositorio.findById(idArchivoExpediente);
	}

	@Override
	@Transactional
	public void deleteArchivoExpediente(int idArchivoExpediente) throws ResourceNotFoundException {
		archivoExpedienteRepositorio.deleteById(idArchivoExpediente);		
	}

	@Override
	public List<ArchivoExpediente> getArchivosExpediente(String idExpediente) {
		return archivoExpedienteRepositorio.findByIdExpediente(idExpediente);
	}


}
