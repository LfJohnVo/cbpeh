package mx.gob.cbpeh.bpd.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("cpRepositorio")
public interface CatCpRepositorio extends JpaRepository<CatCp, Integer>{
	
	public List<CatCp> findByCodigoEstadoAndCodigoMunicipio(String codigoEstado,String codigoMunicipio);

}
