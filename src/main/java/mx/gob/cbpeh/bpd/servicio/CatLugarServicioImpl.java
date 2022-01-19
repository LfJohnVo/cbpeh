package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatLugar;
import mx.gob.cbpeh.bpd.repositorio.CatLugarRepositorio;

@Service
public class CatLugarServicioImpl implements CatLugarServicio {
	
	@Autowired
	private CatLugarRepositorio lugarRepositorio;

	@Override
	@Transactional
	public List<CatLugar> getCatLugar() {
		return lugarRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatLugar(CatLugar lugar) {
		lugarRepositorio.save(lugar);
	}

	@Override
	@Transactional
	public Optional<CatLugar> getCatLugar(int idLugar) throws ResourceNotFoundException {
		return lugarRepositorio.findById(idLugar);
	}

	@Override
	@Transactional
	public void deleteCatLugar(int idLugar) throws ResourceNotFoundException {
		lugarRepositorio.deleteById(idLugar);
	}

}
