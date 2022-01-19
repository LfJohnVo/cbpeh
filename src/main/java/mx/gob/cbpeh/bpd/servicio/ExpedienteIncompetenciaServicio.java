package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.ExpedienteIncompetencia;


public interface ExpedienteIncompetenciaServicio {

    public List < ExpedienteIncompetencia > getExpedienteIncompetencias();

    public void saveExpedienteIncompetencia(ExpedienteIncompetencia expedienteIncompetencia);

    public Optional<ExpedienteIncompetencia>  getExpedienteIncompetencia(int idExpedienteIncompetencia) throws ResourceNotFoundException;

    public void deleteExpedienteIncompetencia(int idExpedienteIncompetencia) throws ResourceNotFoundException;
}
