package mx.gob.cbpeh.bpd.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("companiaTelefonoRepositorio")
public interface CatCompaniaTelefonoRepositorio extends JpaRepository<CatCompaniaTelefono, Integer>{
	
	List<CatCompaniaTelefono> findByCatEstatus(CatEstatus catEstatus);

}
