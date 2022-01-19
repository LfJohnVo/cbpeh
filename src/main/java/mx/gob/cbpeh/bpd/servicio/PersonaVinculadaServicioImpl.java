package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.PersonaVinculada;
import mx.gob.cbpeh.bpd.repositorio.PersonaVinculadaRepositorio;

@Service
public class PersonaVinculadaServicioImpl implements PersonaVinculadaServicio {
	
	@Autowired
	private PersonaVinculadaRepositorio personaVinculadaRepositorio;

	@Override
	@Transactional
	public List<PersonaVinculada> getPersonaVinculadas() {
		return personaVinculadaRepositorio.findAll();
	}

	@Override
	@Transactional
	public void savePersonaVinculada(PersonaVinculada personaVinculada) {
		personaVinculadaRepositorio.save(personaVinculada);

	}
	
	@Override
	@Transactional
	public PersonaVinculada saveAndGetPersonaVinculada(PersonaVinculada personaVinculada) {
		return personaVinculadaRepositorio.save(personaVinculada);

	} 

	@Override
	@Transactional
	public Optional<PersonaVinculada> getPersonaVinculada(int idPersonaVinculada) throws ResourceNotFoundException {
		return personaVinculadaRepositorio.findById(idPersonaVinculada);
	}

	@Override
	@Transactional
	public void deletePersonaVinculada(int idPersonaVinculada) throws ResourceNotFoundException {
		personaVinculadaRepositorio.deleteById(idPersonaVinculada);

	}

}
