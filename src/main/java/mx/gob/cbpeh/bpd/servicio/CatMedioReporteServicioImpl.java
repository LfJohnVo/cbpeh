package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatMedioReporte;
import mx.gob.cbpeh.bpd.repositorio.CatMedioReporteRepositorio;

@Service
public class CatMedioReporteServicioImpl implements CatMedioReporteServicio {
	
	@Autowired
	private CatMedioReporteRepositorio medioReporteRepositorio;

	@Override
	@Transactional
	public List<CatMedioReporte> getCatMedioReportes() {
		return medioReporteRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatMedioReporte(CatMedioReporte medioReporte) {
		medioReporteRepositorio.save(medioReporte);
	}

	@Override
	@Transactional
	public Optional<CatMedioReporte> getCatMedioReporte(int idMedioReporte) throws ResourceNotFoundException {
		return medioReporteRepositorio.findById(idMedioReporte);
	}

	@Override
	@Transactional
	public void deleteCatMedioReporte(int idMedioReporte) throws ResourceNotFoundException {
		medioReporteRepositorio.deleteById(idMedioReporte);
	}

}
