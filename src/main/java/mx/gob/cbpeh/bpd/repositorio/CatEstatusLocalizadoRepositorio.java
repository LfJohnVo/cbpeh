package mx.gob.cbpeh.bpd.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("estatusLocalizadoRepositorio")
public interface CatEstatusLocalizadoRepositorio extends JpaRepository<CatEstatusLocalizado, Integer>{
	
	public CatEstatusLocalizado findByIdEstatusLocalizado(int idEstatusLocalizado);

}
