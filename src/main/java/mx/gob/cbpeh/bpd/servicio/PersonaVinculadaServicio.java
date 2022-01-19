package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.PersonaVinculada;


public interface PersonaVinculadaServicio {

    public List < PersonaVinculada > getPersonaVinculadas();

    public void savePersonaVinculada(PersonaVinculada personaVinculada);
    
    public PersonaVinculada saveAndGetPersonaVinculada(PersonaVinculada personaVinculada);

    public Optional<PersonaVinculada>  getPersonaVinculada(int idPersonaVinculada) throws ResourceNotFoundException;

    public void deletePersonaVinculada(int idPersonaVinculada) throws ResourceNotFoundException;
}
