package mx.gob.cbpeh.bpd.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("areaRepositorio")
public interface CatAreaRepositorio extends JpaRepository<CatArea, Integer>{
	List<CatArea> findByCatEstatus(CatEstatus catEstatus);
}
