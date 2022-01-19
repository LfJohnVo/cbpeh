package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.BusquedaLargaDataExpediente;
import mx.gob.cbpeh.bpd.repositorio.BusquedaLargaDataExpedienteRepositorio;

@Service
public class BusquedaLargaDataExpedienteServicioImpl implements BusquedaLargaDataExpedienteServicio {
	
	@Autowired
	private BusquedaLargaDataExpedienteRepositorio busquedaLargaDataExpedienteRepositorio;

	@Override
	@Transactional
	public List<BusquedaLargaDataExpediente> getBusquedaLargaDataExpediente() {
		return busquedaLargaDataExpedienteRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveBusquedaLargaDataExpediente(BusquedaLargaDataExpediente busquedaLargaData) {
		busquedaLargaDataExpedienteRepositorio.save(busquedaLargaData);
		
	}

	@Override
	@Transactional
	public Optional<BusquedaLargaDataExpediente> getBusquedaLargaDataExpediente(int idBusquedaLargaDataExpediente) throws ResourceNotFoundException {
		return  busquedaLargaDataExpedienteRepositorio.findById(idBusquedaLargaDataExpediente);
	}

	@Override
	@Transactional
	public void deleteBusquedaLargaDataExpediente(int idBusquedaLargaDataExpediente) throws ResourceNotFoundException {
		busquedaLargaDataExpedienteRepositorio.deleteById(idBusquedaLargaDataExpediente);
		
	}

}
