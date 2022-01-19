package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.PersonaReporta;


public interface PersonaReportaServicio {

    public List < PersonaReporta > getPersonaReportas();

    public PersonaReporta savePersonaReporta(PersonaReporta personaReporta);

    public Optional<PersonaReporta>  getPersonaReporta(int idPersonaReporta) throws ResourceNotFoundException;

    public void deletePersonaReporta(int idPersonaReporta) throws ResourceNotFoundException;
}
