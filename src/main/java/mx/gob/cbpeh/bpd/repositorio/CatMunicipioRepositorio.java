package mx.gob.cbpeh.bpd.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("municipioRepositorio")
public interface CatMunicipioRepositorio extends JpaRepository<CatMunicipio, Integer> {

	List<CatMunicipio> findByCodigoEstadoOrderByMunicipioDetalleAsc(String codigoEstado);

	@Query(value = "SELECT * FROM cat_municipio WHERE codigo_estado = ?1 AND codigo_municipio = ?2", nativeQuery = true)
	CatMunicipio findByCodigoEstadoAndCodigoMunicipio(String codigoEstado, String codigoMunicipio);
}
