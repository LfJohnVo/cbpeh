package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.PersonaEntrevista;


public interface PersonaEntrevistaServicio {

    public List < PersonaEntrevista > getPersonaEntrevista();

    public PersonaEntrevista savePersonaEntrevista(PersonaEntrevista personaEntrevista);

    public Optional<PersonaEntrevista>  getPersonaEntrevista(int idPersonaEntrevista) throws ResourceNotFoundException;

    public void deletePersonaEntrevista(int idPersonaEntrevista) throws ResourceNotFoundException;
    
    public PersonaEntrevista getPersonaEntrevistaBy(String idExpediente, Integer idEstatus);

}
