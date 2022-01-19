package mx.gob.cbpeh.bpd.servicio;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.AtentaNota;
import mx.gob.cbpeh.bpd.modelo.CatArea;
import mx.gob.cbpeh.bpd.modelo.CatTipoNota;
import mx.gob.cbpeh.bpd.repositorio.AtentaNotaRepositorio;

@Service
public class AtentaNotaServicioImpl implements AtentaNotaServicio {

	@Autowired
	private AtentaNotaRepositorio atentaNotaRepositorio;

	@Override
	@Transactional
	public List<AtentaNota> getAtentaNotas() {
		return atentaNotaRepositorio.findAll();
	}
	
	 public List < AtentaNota > getBusquedaAtentaNotas(String idAtentaNota, String expediente, CatTipoNota tipoNota){
			return atentaNotaRepositorio.findByIdAtentaNotaAndIdExpedienteAndCatTipoNota(idAtentaNota, expediente, tipoNota);
		}
	 
	 public List < AtentaNota > getBusquedaAtentaNotasLike(String idAtentaNota, String expediente, CatTipoNota tipoNota){
			return atentaNotaRepositorio.findByIdAtentaNotaLikeAndIdExpedienteLikeAndCatTipoNotaLike(idAtentaNota, expediente, tipoNota);
		}

	 public List < AtentaNota > getAtentaNotasPorArea(CatArea area){
			return atentaNotaRepositorio.findByCatArea(area);
		}
	    
	 
	    public List < AtentaNota > getAtentaNotasPorFechas(Date fechaInicio, Date fechaFin){
			return atentaNotaRepositorio.findAllByFechaCreacionBetween(fechaInicio, fechaFin);
		}
	    
	    public List < AtentaNota > getAtentaNotasPorIdExpediente(String expediente){
			return atentaNotaRepositorio.findByIdExpediente(expediente);
		}
	    
	   	    
	    public AtentaNota getAtentaNotaPorIdAtentaNota(String idAtentaNota){
			return atentaNotaRepositorio.findByIdAtentaNota(idAtentaNota);
		}
	    
	   	    
	    public List < AtentaNota > getAtentaNotasPorTipoNota(CatTipoNota catTipoNota){
			return atentaNotaRepositorio.findByCatTipoNota(catTipoNota);
		}
	    
	    public List < AtentaNota > getAtentaNotasPorAtentaNotaIdExpediente(String idAtentaNota, String expediente){
			return atentaNotaRepositorio.findByIdAtentaNotaAndIdExpediente(idAtentaNota, expediente);
		}
	    
	    public List < AtentaNota > getAtentaNotasPorAtentaNotaTipoNota(String idAtentaNota, CatTipoNota catTipoNota){
			return atentaNotaRepositorio.findByIdAtentaNotaAndCatTipoNota(idAtentaNota, catTipoNota);
		}
	    
	    public List < AtentaNota > getAtentaNotasPorIdExpedienteTipoNota(String expediente, CatTipoNota catTipoNota){
			return atentaNotaRepositorio.findByIdExpedienteAndCatTipoNota(expediente, catTipoNota);
		}
	    
	    public String getFolioAtentaNota(Integer idTipoNota, Integer idArea,String folioAtentaNota){
			return atentaNotaRepositorio.generarFolioAtentaNota(idTipoNota, idArea);
		}


	@Override
	@Transactional
	public void saveAtentaNota(AtentaNota atentaNota) {
		atentaNotaRepositorio.save(atentaNota);
		
	}

	@Override
	@Transactional
	public void deleteAtentaNota(int idAtentaNota) throws ResourceNotFoundException {
		atentaNotaRepositorio.deleteById(idAtentaNota);
		
	}	
	
}
