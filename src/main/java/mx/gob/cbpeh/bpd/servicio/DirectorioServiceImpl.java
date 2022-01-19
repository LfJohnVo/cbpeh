package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.gob.cbpeh.bpd.modelo.AsociacionesHidalgo;
import mx.gob.cbpeh.bpd.modelo.BusquedaInmediata;
import mx.gob.cbpeh.bpd.modelo.CentrosRehabilitacion;
import mx.gob.cbpeh.bpd.modelo.ComisionesEstatales;
import mx.gob.cbpeh.bpd.repositorio.AsociacionHidalgoRepositorio;
import mx.gob.cbpeh.bpd.repositorio.BusquedaInmediataRepositorio;
import mx.gob.cbpeh.bpd.repositorio.CentrosRehabilitacionRepositorio;
import mx.gob.cbpeh.bpd.repositorio.ComisionEstatalRepositorio;

@Service
public class DirectorioServiceImpl implements DirectorioService {
	
	@Autowired
	private AsociacionHidalgoRepositorio asociacionHidalgoRepositorio;
	@Autowired
	private BusquedaInmediataRepositorio busquedaInmediataRepositorio;
	@Autowired
	private CentrosRehabilitacionRepositorio centrosRehabilitacionRepositorio;
	@Autowired
	private ComisionEstatalRepositorio comisionEstatalRepositorio;


	@Override
	public List<AsociacionesHidalgo> getAsociacionesHidalgo() {		
		return asociacionHidalgoRepositorio.findAll();
	}

	@Override
	public List<BusquedaInmediata> getBusquedaInmediatas() {
		return busquedaInmediataRepositorio.findAll();
	}

	@Override
	public List<CentrosRehabilitacion> getCentrosRehabilitacion() {
		return centrosRehabilitacionRepositorio.findAll();
	}

	@Override
	public List<ComisionesEstatales> getComisionesEstatales() {
		return comisionEstatalRepositorio.findAll();
	}

}
