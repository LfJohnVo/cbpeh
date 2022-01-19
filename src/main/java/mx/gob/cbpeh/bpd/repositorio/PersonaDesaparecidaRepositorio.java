package mx.gob.cbpeh.bpd.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("personaDesaparecidaRepositorio")
public interface PersonaDesaparecidaRepositorio extends JpaRepository<PersonaDesaparecida, Integer>{
	
PersonaDesaparecida findByIdPersonaDesaparecida(int id);

PersonaDesaparecida findByCurp(String curp);

PersonaDesaparecida findByNombreLikeAndApaternoLikeAndAmaternoLikeAndCurpLike(String nombre,String aPaterno,String aMaterno, String curp);


}
