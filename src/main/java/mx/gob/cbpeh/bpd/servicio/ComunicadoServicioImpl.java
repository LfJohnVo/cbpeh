package mx.gob.cbpeh.bpd.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.modelo.CatTipoComunicado;
import mx.gob.cbpeh.bpd.modelo.Comunicado;
import mx.gob.cbpeh.bpd.repositorio.ComunicadoRepositorio;

@Service
public class ComunicadoServicioImpl implements ComunicadoServicio {
	
	@Autowired
	private ComunicadoRepositorio comunicadoRepositorio;

	@Override
	@Transactional
	public List<Comunicado> getComunicados() {
		return comunicadoRepositorio.findAll();
	}
	
	@Override
	@Transactional
	public List<Comunicado> getComunicados(CatTipoComunicado catTipoComunicado){
		CatEstatus catEstatus= new CatEstatus();
		           catEstatus.setIdEstatus(1);
		return comunicadoRepositorio.findByCatTipoComunicadoAndCatEstatus(catTipoComunicado,catEstatus);
	}

	@Override
	@Transactional
	public void saveComunicado(Comunicado tez) {
		comunicadoRepositorio.save(tez);
	}

	@Override
	@Transactional
	public Comunicado getComunicado(int idComunicado) throws ResourceNotFoundException {
		return comunicadoRepositorio.findByIdComunicado(idComunicado);
	}   

	@Override
	@Transactional
	public void deleteComunicado(int idTez) throws ResourceNotFoundException {
		comunicadoRepositorio.deleteById(idTez);
	}

}
