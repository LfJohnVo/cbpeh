package mx.gob.cbpeh.bpd.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("catLugarBusquedaRepositorio")
public interface CatLugarBusquedaRepositorio extends JpaRepository<CatLugarBusqueda, Integer>{

}
