package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatTipoArchivo;
import mx.gob.cbpeh.bpd.repositorio.CatTipoArchivoRepositorio;

@Service
public class CatTipoArchivoServicioImpl implements CatTipoArchivoServicio {
	
	@Autowired
	private CatTipoArchivoRepositorio tipoArchivoRepositorio;

	@Override
	@Transactional
	public List<CatTipoArchivo> getCatTipoArchivos() {
		return tipoArchivoRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatTipoArchivo(CatTipoArchivo tipoArchivo) {
		tipoArchivoRepositorio.save(tipoArchivo);

	}

	@Override
	@Transactional
	public Optional<CatTipoArchivo> getCatTipoArchivo(int idTipoArchivo) throws ResourceNotFoundException {
		return tipoArchivoRepositorio.findById(idTipoArchivo);
	}
	
	@Override
	@Transactional
	public CatTipoArchivo getCatTipoArchivo(String extension) throws ResourceNotFoundException {
		return tipoArchivoRepositorio.findByTipoArchivoDetalle(extension);
	}

	@Override
	@Transactional
	public void deleteCatTipoArchivo(int idTipoArchivo) throws ResourceNotFoundException {
		tipoArchivoRepositorio.deleteById(idTipoArchivo);

	}

}
