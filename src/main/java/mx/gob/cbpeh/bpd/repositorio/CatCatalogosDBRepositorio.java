package mx.gob.cbpeh.bpd.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("catCatalogosDBRepositorio")
public interface CatCatalogosDBRepositorio extends JpaRepository<CatCatalogosDB, Integer>{
	
	CatCatalogosDB findByIdCatalogo(int idCatalogo);
	
	List<CatCatalogosDB>  findByCatEstatus(CatEstatus estatus);

}
