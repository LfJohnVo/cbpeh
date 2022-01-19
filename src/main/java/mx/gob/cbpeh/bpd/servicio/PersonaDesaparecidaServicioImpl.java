package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.PersonaDesaparecida;
import mx.gob.cbpeh.bpd.repositorio.PersonaDesaparecidaRepositorio;

@Service
public class PersonaDesaparecidaServicioImpl implements PersonaDesaparecidaServicio {
	
	@Autowired
	private PersonaDesaparecidaRepositorio personaDesaparecidaRepositorio;

	@Override
	@Transactional
	public List<PersonaDesaparecida> getPersonaDesaparecidas() {
		return personaDesaparecidaRepositorio.findAll();
	}

	@Override
	@Transactional
	public PersonaDesaparecida savePersonaDesaparecida(PersonaDesaparecida personaDesaparecida) {
		return personaDesaparecidaRepositorio.save(personaDesaparecida);
	}

//	@Override
//	@Transactional
//	public Optional<PersonaDesaparecida> getPersonaDesaparecida(int idPersonaDesaparecida)
//			throws ResourceNotFoundException {
//		return personaDesaparecidaRepositorio.findById(idPersonaDesaparecida);
//	}
	
	@Override
	@Transactional
	public PersonaDesaparecida getPersonaDesaparecida(int idPersonaDesaparecida)
			throws ResourceNotFoundException {
		return personaDesaparecidaRepositorio.findByIdPersonaDesaparecida(idPersonaDesaparecida);
	}

	@Override
	@Transactional
	public void deletePersonaDesaparecida(int idPersonaDesaparecida) throws ResourceNotFoundException {
		personaDesaparecidaRepositorio.deleteById(idPersonaDesaparecida);

	}
	
	@Override
	public PersonaDesaparecida getPersonaDesaparecidaCurp(String curp) throws ResourceNotFoundException{
		return personaDesaparecidaRepositorio.findByCurp(curp);
	}
	
	public PersonaDesaparecida getPersonaDesaparecidaConsultaExterna(String nombre,String aPaterno,String aMaterno, String curp) throws ResourceNotFoundException{
		return personaDesaparecidaRepositorio.findByNombreLikeAndApaternoLikeAndAmaternoLikeAndCurpLike(nombre, aPaterno, aMaterno, curp);
	}

}
