package mx.gob.cbpeh.bpd.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("parentescoRepositorio")
public interface CatParentescoRepositorio extends JpaRepository<CatParentesco, Integer>{
	
	public List<CatParentesco> findByCatEstatus(CatEstatus catEstatus);

}
