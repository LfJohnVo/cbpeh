package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.PersonaDesaparecida;


public interface PersonaDesaparecidaServicio {

    public List < PersonaDesaparecida > getPersonaDesaparecidas();

    public PersonaDesaparecida savePersonaDesaparecida(PersonaDesaparecida personaDesaparecida);

    public PersonaDesaparecida getPersonaDesaparecida(int idPersonaDesaparecida) throws ResourceNotFoundException;
    
    //public Optional<PersonaDesaparecida>  getPersonaDesaparecida(int idPersonaDesaparecida) throws ResourceNotFoundException;

    public void deletePersonaDesaparecida(int idPersonaDesaparecida) throws ResourceNotFoundException;
    
    public PersonaDesaparecida  getPersonaDesaparecidaCurp(String curp) throws ResourceNotFoundException;
    
    public PersonaDesaparecida  getPersonaDesaparecidaConsultaExterna(String nombre,String aPaterno,String aMaterno,String curp) throws ResourceNotFoundException;
    
}
