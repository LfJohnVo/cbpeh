package mx.gob.cbpeh.bpd.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("atentaNotaRepositorio")
public interface AtentaNotaRepositorio extends JpaRepository<AtentaNota, Integer>{
	
	public List<AtentaNota> findAllByFechaCreacionBetween(Date fechaInicio, Date fechaFin);
	public List<AtentaNota> findByCatArea(CatArea catArea);
	public List<AtentaNota> findByIdExpediente(String expediente);
	      public AtentaNota findByIdAtentaNota(String idAtentaNota);
	//protected List<AtentaNota> findByIdAtentaNota(String idAtentaNota);
	public List<AtentaNota> findByCatTipoNota(CatTipoNota catTipoNota);
	public List<AtentaNota> findByIdAtentaNotaAndIdExpediente(String idAtentaNota, String expediente);
	public List<AtentaNota> findByIdAtentaNotaAndCatTipoNota(String idAtentaNota, CatTipoNota catTipoNota);
	public List<AtentaNota> findByIdExpedienteAndCatTipoNota(String expediente, CatTipoNota catTipoNota);
	public List<AtentaNota> findByIdAtentaNotaAndIdExpedienteAndCatTipoNota(String idAtentaNota, String expediente, CatTipoNota catTipoNota);
	public List<AtentaNota> findByIdAtentaNotaLikeAndIdExpedienteLikeAndCatTipoNotaLike(String idAtentaNota, String expediente, CatTipoNota catTipoNota);
	
	@Procedure(procedureName = "SP_GENERAR_FOLIO_ATENTA_NOTA")
    public String generarFolioAtentaNota(int idTipoNota, int idArea);
	
}
