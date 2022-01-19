package mx.gob.cbpeh.bpd.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("tipoArchivoRepositorio")
public interface CatTipoArchivoRepositorio extends JpaRepository<CatTipoArchivo, Integer>{

	CatTipoArchivo findByTipoArchivoDetalle(String extension);
}
