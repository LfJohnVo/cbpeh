package mx.gob.cbpeh.bpd.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("municipioRepositorio")
public interface CatMunicipioRepositorio extends JpaRepository<CatMunicipio, Integer>{
	
	List<CatMunicipio> findByCodigoEstadoOrderByMunicipioDetalleAsc(String codigoEstado);
	

}
