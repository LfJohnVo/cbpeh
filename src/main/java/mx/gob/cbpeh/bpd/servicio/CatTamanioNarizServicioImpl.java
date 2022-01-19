package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatTamanioNariz;
import mx.gob.cbpeh.bpd.repositorio.CatTamanioNarizRepositorio;

@Service
public class CatTamanioNarizServicioImpl implements CatTamanioNarizServicio {
	
	@Autowired
	private CatTamanioNarizRepositorio tamanioNarizRepositorio;

	@Override
	@Transactional
	public List<CatTamanioNariz> getCatTamanioNariz() {
		return tamanioNarizRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatTamanioNariz(CatTamanioNariz tamanioNariz) {
		tamanioNarizRepositorio.save(tamanioNariz);

	}

	@Override
	@Transactional
	public Optional<CatTamanioNariz> getCatTamanioNariz(int idTamanioNariz) throws ResourceNotFoundException {
		return tamanioNarizRepositorio.findById(idTamanioNariz);
	}

	@Override
	@Transactional
	public void deleteCatTamanioNariz(int idTamanioNariz) throws ResourceNotFoundException {
		tamanioNarizRepositorio.deleteById(idTamanioNariz);
	}

}
