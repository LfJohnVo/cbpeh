package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstatusEconomico;


public interface CatEstatusEconomicoServicio {

    public List < CatEstatusEconomico > getCatEstatusEconomicos();

    public void saveCatEstatusEconomico(CatEstatusEconomico estatusEconomico);

    public Optional<CatEstatusEconomico>  getCatEstatusEconomico(int idEstatusEconomico) throws ResourceNotFoundException;

    public void deleteCatEstatusEconomico(int idEstatusEconomico) throws ResourceNotFoundException;
}
