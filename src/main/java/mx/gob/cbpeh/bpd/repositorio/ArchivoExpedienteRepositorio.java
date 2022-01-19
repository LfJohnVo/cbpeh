package mx.gob.cbpeh.bpd.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("archivoExpedienteRepositorio")
public interface ArchivoExpedienteRepositorio  extends JpaRepository<ArchivoExpediente, Integer>  {
	
	List<ArchivoExpediente> findByIdExpediente(String idExpediente);

}
