package mx.gob.cbpeh.bpd.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("puestoRepositorio")
public interface CatPuestoRepositorio extends JpaRepository<CatPuesto, Integer>{
	List<CatPuesto> findByCatEstatus(CatEstatus catEstatus);

}
