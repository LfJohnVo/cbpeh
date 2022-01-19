package mx.gob.cbpeh.bpd.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("tezRepositorio")
public interface CatTezRepositorio extends JpaRepository<CatTez, Integer>{

}
