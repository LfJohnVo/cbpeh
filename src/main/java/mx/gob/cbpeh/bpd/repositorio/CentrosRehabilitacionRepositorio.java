package mx.gob.cbpeh.bpd.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.CentrosRehabilitacion;

@Repository("centroRehabilitacionRepositorio")
public interface CentrosRehabilitacionRepositorio extends JpaRepository<CentrosRehabilitacion, Integer>{

}
