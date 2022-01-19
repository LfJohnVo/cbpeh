package mx.gob.cbpeh.bpd.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("tipoOjoRepositorio")
public interface CatTipoOjoRepositorio extends JpaRepository<CatTipoOjo, Integer>{

}
