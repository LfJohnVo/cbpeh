package mx.gob.cbpeh.bpd.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("perfilRepositorio")
public interface PerfilRepositorio extends JpaRepository<Perfil, Integer>{
	
	List<Perfil> findByCatEstatus(CatEstatus catEstatus);

}
