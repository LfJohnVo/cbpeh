package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatMunicipio;
import mx.gob.cbpeh.bpd.repositorio.CatMunicipioRepositorio;

@Service
public class CatMunicipioServicioImpl implements CatMunicipioServicio {

	@Autowired
	private CatMunicipioRepositorio municipioRepositorio;

	@Override
	@Transactional
	public List<CatMunicipio> getCatMunicipios() {
		return municipioRepositorio.findAll();
	}

	@Override
	@Transactional
	public List<CatMunicipio> getCatMunicipiosPorEstado(String codigoEstado) {

		return municipioRepositorio.findByCodigoEstadoOrderByMunicipioDetalleAsc(codigoEstado);
	}

	@Override
	@Transactional(readOnly = true)
	public CatMunicipio getCatMunicipiosPorEstadoAndPorCodigo(String codigoEstado, String codigoMunicipio) {
		return municipioRepositorio.findByCodigoEstadoAndCodigoMunicipio(codigoEstado, codigoMunicipio);
	}

	@Override
	@Transactional
	public void saveCatMunicipio(CatMunicipio municipio) {
		municipioRepositorio.save(municipio);

	}

	@Override
	@Transactional
	public Optional<CatMunicipio> getCatMunicipio(int idMunicipio) throws ResourceNotFoundException {
		return municipioRepositorio.findById(idMunicipio);
	}

	@Override
	@Transactional
	public void deleteCatMunicipio(int idMunicipio) throws ResourceNotFoundException {
		municipioRepositorio.deleteById(idMunicipio);
	}

}
