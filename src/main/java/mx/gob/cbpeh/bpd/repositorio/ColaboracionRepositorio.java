package mx.gob.cbpeh.bpd.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("colaboracionRepositorio")
public interface ColaboracionRepositorio extends JpaRepository<Colaboracion, Integer>{
	
	@Procedure(procedureName = "SP_GENERAR_FOLIO_COLABORACION")
    public String generarFolioColaboracion(String institucion, String inicialesNombre);

}
