package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.PersonaEntrevista;
import mx.gob.cbpeh.bpd.repositorio.PersonaEntrevistaRepositorio;

@Service
public class PersonaEntrevistaServicioImpl implements PersonaEntrevistaServicio {
	
	@Autowired
	private PersonaEntrevistaRepositorio personaEntrevistaRepositorio;

	@Override
	@Transactional
	public List<PersonaEntrevista> getPersonaEntrevista() {
		return personaEntrevistaRepositorio.findAll();
	}

	@Override
	@Transactional
	public PersonaEntrevista savePersonaEntrevista(PersonaEntrevista personaEntrevista) {
		return personaEntrevistaRepositorio.save(personaEntrevista);

	}

	@Override
	@Transactional
	public Optional<PersonaEntrevista> getPersonaEntrevista(int idPersonaEntrevista) throws ResourceNotFoundException {
		return personaEntrevistaRepositorio.findById(idPersonaEntrevista);
	}

	@Override
	@Transactional
	public void deletePersonaEntrevista(int idPersonaEntrevista) throws ResourceNotFoundException {
		personaEntrevistaRepositorio.deleteById(idPersonaEntrevista);

	}

	@Override
	public PersonaEntrevista getPersonaEntrevistaBy(String idExpediente, Integer idEstatus) {
		return personaEntrevistaRepositorio.findByIdExpedienteAndIdEstatus(idExpediente, idEstatus);
	}

}
