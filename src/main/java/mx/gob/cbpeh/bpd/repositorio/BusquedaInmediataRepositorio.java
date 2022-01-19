package mx.gob.cbpeh.bpd.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.BusquedaInmediata;

@Repository("busquedaInmediataRepositorio")
public interface BusquedaInmediataRepositorio extends JpaRepository<BusquedaInmediata, Integer>{

}
