package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.PersonaIncompetencia;


public interface PersonaIncompetenciaServicio {

    public List < PersonaIncompetencia > getPersonaIncompetencias();

    public void savePersonaIncompetencia(PersonaIncompetencia personaIncompetencia);

    public Optional<PersonaIncompetencia>  getPersonaIncompetencia(int idPersonaIncompetencia) throws ResourceNotFoundException;

    public void deletePersonaIncompetencia(int IdPersonaIncompetencia) throws ResourceNotFoundException;
}
