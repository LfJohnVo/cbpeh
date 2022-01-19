package mx.gob.cbpeh.bpd.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("personaEntrevistaRepositorio")
public interface PersonaEntrevistaRepositorio extends JpaRepository<PersonaEntrevista, Integer>{
	
	public PersonaEntrevista findByIdExpedienteAndIdEstatus(String idExpediente, Integer idEstatus);

}
