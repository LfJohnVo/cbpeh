package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.BusquedaLargaData;
import mx.gob.cbpeh.bpd.repositorio.BusquedaLargaDataRepositorio;

@Service
public class BusquedaLargaDataServicioImpl implements BusquedaLargaDataServicio {

	@Autowired
	private BusquedaLargaDataRepositorio busquedaLargaDataRepositorio;

	@Override
	@Transactional
	public List<BusquedaLargaData> getBusquedaLargaDatas() {
		return busquedaLargaDataRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveBusquedaLargaData(BusquedaLargaData busquedaLargaData) {
		busquedaLargaDataRepositorio.save(busquedaLargaData);

	}

	@Override
	@Transactional
	public Optional<BusquedaLargaData> getBusquedaLargaData(int idBusquedaLargaData) throws ResourceNotFoundException {
		return busquedaLargaDataRepositorio.findById(idBusquedaLargaData);
	}

	@Override
	@Transactional
	public void deleteBusquedaLargaData(int idBusquedaLargaData) throws ResourceNotFoundException {
		busquedaLargaDataRepositorio.deleteById(idBusquedaLargaData);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Integer> getYearsLargaData() {
		return busquedaLargaDataRepositorio.getAllYears();
	}

}
