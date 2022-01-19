package mx.gob.cbpeh.bpd.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("formaNarizRepositorio")
public interface CatFormaNarizRepositorio extends JpaRepository<CatFormaNariz, Integer>{

}
