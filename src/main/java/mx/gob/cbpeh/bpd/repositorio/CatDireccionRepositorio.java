package mx.gob.cbpeh.bpd.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("direccionRepositorio")
public interface CatDireccionRepositorio extends JpaRepository<CatDireccion, Integer>{
	
	List<CatDireccion> findByCatEstatus(CatEstatus catEstatus);

}
