package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.Bitacora;
import mx.gob.cbpeh.bpd.repositorio.BitacoraRepositorio;

@Service
public class BitacoraServicioImpl implements BitacoraServicio {

	@Autowired
	private BitacoraRepositorio bitacoraRepositorio;

	@Override
	@Transactional
	public List<Bitacora> getBitacoras() {
		return bitacoraRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveBitacora(Bitacora bitacora) {
		bitacoraRepositorio.save(bitacora);
	}

	@Override
	@Transactional
	public Optional<Bitacora> getBitacora(int idBitacora) throws ResourceNotFoundException {
		return bitacoraRepositorio.findById(idBitacora);
	}

	@Override
	@Transactional
	public void deleteBitacora(int idBitacora) throws ResourceNotFoundException {
		bitacoraRepositorio.deleteById(idBitacora);		
	}
	
}
