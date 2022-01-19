package mx.gob.cbpeh.bpd.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("coloniaRepositorio")
public interface CatColoniaRepositorio extends JpaRepository<CatColonia, Integer>{
	
	List<CatColonia> findByCodigoCp(String codigoCp);

}
