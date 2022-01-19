package mx.gob.cbpeh.bpd.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("siNoRepositorio")
public interface CatSiNoRepositorio extends JpaRepository<CatSiNo, Integer>{

}
