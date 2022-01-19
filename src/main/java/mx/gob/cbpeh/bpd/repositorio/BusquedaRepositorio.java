package mx.gob.cbpeh.bpd.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("busquedaRepositorio")
public interface BusquedaRepositorio extends JpaRepository<Busqueda, Integer>{
	
	public List<Busqueda> findByExpediente(String expediente);

}
