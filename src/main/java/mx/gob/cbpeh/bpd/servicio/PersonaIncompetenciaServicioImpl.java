package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.PersonaIncompetencia;
import mx.gob.cbpeh.bpd.repositorio.PersonaIncompetenciaRepositorio;

@Service
public class PersonaIncompetenciaServicioImpl implements PersonaIncompetenciaServicio {
	
	@Autowired
	private PersonaIncompetenciaRepositorio personaIncompetenciaRepositorio;

	@Override
	@Transactional
	public List<PersonaIncompetencia> getPersonaIncompetencias() {
		return personaIncompetenciaRepositorio.findAll();
	}

	@Override
	@Transactional
	public void savePersonaIncompetencia(PersonaIncompetencia personaIncompetencia) {
		personaIncompetenciaRepositorio.save(personaIncompetencia);

	}

	@Override
	@Transactional
	public Optional<PersonaIncompetencia> getPersonaIncompetencia(int idPersonaIncompetencia){
		return personaIncompetenciaRepositorio.findById(idPersonaIncompetencia);
	}

	@Override
	@Transactional
	public void deletePersonaIncompetencia(int IdPersonaIncompetencia) throws ResourceNotFoundException {
		personaIncompetenciaRepositorio.deleteById(IdPersonaIncompetencia);

	}

}
