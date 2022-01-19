package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import mx.gob.cbpeh.bpd.modelo.AsociacionesHidalgo;
import mx.gob.cbpeh.bpd.modelo.BusquedaInmediata;
import mx.gob.cbpeh.bpd.modelo.CentrosRehabilitacion;
import mx.gob.cbpeh.bpd.modelo.ComisionesEstatales;

public interface DirectorioService {
	
	public List < AsociacionesHidalgo > getAsociacionesHidalgo();	
	public List < BusquedaInmediata > getBusquedaInmediatas();
	public List < CentrosRehabilitacion > getCentrosRehabilitacion();
	public List < ComisionesEstatales > getComisionesEstatales();

}
