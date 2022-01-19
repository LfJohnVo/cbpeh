package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatGrupoEtnico;
import mx.gob.cbpeh.bpd.repositorio.CatGrupoEtnicoRepositorio;

@Service
public class CatGrupoEtnicoServicioImpl implements CatGrupoEtnicoServicio {
	
	@Autowired
	private CatGrupoEtnicoRepositorio grupoEtnicoRepositorio;

	@Override
	@Transactional
	public List<CatGrupoEtnico> getCatGrupoEtnicos() {
		return grupoEtnicoRepositorio.findAll();
	}

	@Override
	@Transactional
	public void saveCatGrupoEtnico(CatGrupoEtnico grupoEtnico) {
		grupoEtnicoRepositorio.save(grupoEtnico);
	}

	@Override
	@Transactional
	public Optional<CatGrupoEtnico> getCatGrupoEtnico(int idGrupoEtnico) throws ResourceNotFoundException {
		return grupoEtnicoRepositorio.findById(idGrupoEtnico);
	}

	@Override
	@Transactional
	public void deleteCatGrupoEtnico(int idGrupoEtnico) throws ResourceNotFoundException {
		grupoEtnicoRepositorio.deleteById(idGrupoEtnico);
	}
}
