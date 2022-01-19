package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.VinculoTelefono;
import mx.gob.cbpeh.bpd.repositorio.VinculoTelefonoRepositorio;

@Service
public class VinculoTelefonoServicioImpl implements VinculoTelefonoServicio {
	
	@Autowired
	private VinculoTelefonoRepositorio vinculoTelefonoRepositorio;

	@Override
	@Transactional
	public List<VinculoTelefono> getVinculoTelefonos() {
		return vinculoTelefonoRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveVinculoTelefono(VinculoTelefono vinculoTelefono) {
		vinculoTelefonoRepositorio.save(vinculoTelefono);
		
	}

	@Override
	@Transactional
	public Optional<VinculoTelefono> getVinculoTelefono(int idVinculoTelefono) throws ResourceNotFoundException {
		return vinculoTelefonoRepositorio.findById(idVinculoTelefono);
	}

	@Override
	@Transactional
	public void deleteVinculoTelefono(int idVinculoTelefono) throws ResourceNotFoundException {
		vinculoTelefonoRepositorio.deleteById(idVinculoTelefono);
		
	}


}
