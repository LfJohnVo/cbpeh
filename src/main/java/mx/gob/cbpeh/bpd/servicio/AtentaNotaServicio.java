package mx.gob.cbpeh.bpd.servicio;

import java.util.Date;
import java.util.List;


import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.AtentaNota;
import mx.gob.cbpeh.bpd.modelo.CatArea;
import mx.gob.cbpeh.bpd.modelo.CatTipoNota;


public interface AtentaNotaServicio {

    public List < AtentaNota > getAtentaNotas();
    
    public List < AtentaNota > getAtentaNotasPorArea(CatArea catTipoNota);
    
    public List < AtentaNota > getBusquedaAtentaNotas(String idAtentaNotas, String idExpediente, CatTipoNota idTipoNota);
    
    public List < AtentaNota > getBusquedaAtentaNotasLike(String idAtentaNotas, String idExpediente, CatTipoNota idTipoNota);
    
    public List < AtentaNota > getAtentaNotasPorFechas(Date fechaInicio, Date fechaFin);
    
    public List < AtentaNota > getAtentaNotasPorIdExpediente(String idExpediente);
    
    public AtentaNota getAtentaNotaPorIdAtentaNota(String idAtentaNota);
          
    public List < AtentaNota > getAtentaNotasPorTipoNota(CatTipoNota catTipoNota); 
    
    public String getFolioAtentaNota(Integer idTipoNota, Integer idArea, String folioAtentaNota); 
    
    public List < AtentaNota > getAtentaNotasPorAtentaNotaIdExpediente(String idAtentaNota, String idExpediente);
    
    public List < AtentaNota > getAtentaNotasPorAtentaNotaTipoNota(String idAtentaNota, CatTipoNota idTipoNota);
    
    public List < AtentaNota > getAtentaNotasPorIdExpedienteTipoNota(String idExpediente, CatTipoNota idTipoNota);

    public void saveAtentaNota(AtentaNota atentaNota);

    public void deleteAtentaNota(int idAtentaNota) throws ResourceNotFoundException;
}
