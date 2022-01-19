package mx.gob.cbpeh.bpd.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("comunicadoRepositorio")
public interface ComunicadoRepositorio extends JpaRepository<Comunicado, Integer>{
	
	Comunicado findByIdComunicado(int idComunicado  );
	
	List<Comunicado> findByCatTipoComunicadoAndCatEstatus(CatTipoComunicado catTipoComunicado,CatEstatus estatus);

}
