package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.PersonaReporta;
import mx.gob.cbpeh.bpd.repositorio.PersonaReportaRepositorio;

@Service
public class PersonaReportaServicioImpl implements PersonaReportaServicio {
	
	@Autowired
	private PersonaReportaRepositorio personaReportaRepositorio;
	
	@Override
	@Transactional
	public List<PersonaReporta> getPersonaReportas() {
		return personaReportaRepositorio.findAll();
	}

	@Override
	@Transactional
	public PersonaReporta savePersonaReporta(PersonaReporta personaReporta) {
		return personaReportaRepositorio.save(personaReporta);
	}

	@Override
	@Transactional
	public Optional<PersonaReporta> getPersonaReporta(int idPersonaReporta) throws ResourceNotFoundException {
		return personaReportaRepositorio.findById(idPersonaReporta);
	}

	@Override
	@Transactional
	public void deletePersonaReporta(int idPersonaReporta) throws ResourceNotFoundException {
		personaReportaRepositorio.deleteById(idPersonaReporta);
	}

}
