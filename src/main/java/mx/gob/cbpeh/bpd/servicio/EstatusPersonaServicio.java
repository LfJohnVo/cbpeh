package mx.gob.cbpeh.bpd.servicio;

import mx.gob.cbpeh.bpd.dto.EstatusPersonaDto;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;

public interface EstatusPersonaServicio {
	
	public EstatusPersonaDto consultarEstatus(String idExpediente) throws ResourceNotFoundException;
}
