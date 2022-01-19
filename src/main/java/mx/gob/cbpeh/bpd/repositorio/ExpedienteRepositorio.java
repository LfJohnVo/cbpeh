package mx.gob.cbpeh.bpd.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("expedienteRepositorio")
public interface ExpedienteRepositorio extends JpaRepository<Expediente, Integer>{
	
	@Query(nativeQuery = true,value = "SELECT * FROM expediente e  ORDER BY SUBSTRING(e.id_expediente,11,4) desc, SUBSTRING(e.id_expediente,7,3) desc")
	List<Expediente> expedientesOrdenadosPorAnioDescendente();
	
	Expediente findByIdExpediente(String expediente);
	
	@Procedure(procedureName = "SP_GENERAR_FOLIO_EXPEDIENTE")
    public String generarFolioExpediente(int tipoExpediente);

	Expediente findByIdPersonaDesaparecida(int idPersonaDesaparecida);
	
	//@Procedure(procedureName = "SP_LISTAR_ANIOS_EXPEDIENTES")
	@Query(nativeQuery = true,value = "call SP_LISTAR_ANIOS_EXPEDIENTES()")
    public List<Integer> obtenerAniosExpedientes();
}
