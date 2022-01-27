package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.ArchivoLargaData;
import mx.gob.cbpeh.bpd.repositorio.ArchivoLargaDataRepositorio;

@Service
public class ArchivoLargaDataServicioImpl implements ArchivoLargaDataServicio {

	@Autowired
	private ArchivoLargaDataRepositorio archivoLargaDataRepositorio;

	@Override
	@Transactional
	public List<ArchivoLargaData> getCArchivoLargaData() {
		return archivoLargaDataRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveArchivoLargaData(ArchivoLargaData archivo) {
		archivoLargaDataRepositorio.save(archivo);
	}

	@Override
	@Transactional
	public Optional<ArchivoLargaData> getArchivoLargaData(int idArchivoLargaData) throws ResourceNotFoundException {
		return archivoLargaDataRepositorio.findById(idArchivoLargaData);
	}

	@Override
	@Transactional
	public void deleteArchivoLargaData(int idArchivoLargaData) throws ResourceNotFoundException {
		archivoLargaDataRepositorio.deleteById(idArchivoLargaData);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Integer> getYearsLargaData() {
		return archivoLargaDataRepositorio.getAllYears();
	}

}
