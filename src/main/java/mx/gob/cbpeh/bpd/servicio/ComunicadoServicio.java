package mx.gob.cbpeh.bpd.servicio;

import java.util.List;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.modelo.CatTipoComunicado;
import mx.gob.cbpeh.bpd.modelo.Comunicado;


public interface ComunicadoServicio {

    public List < Comunicado > getComunicados();
    
    public List < Comunicado > getComunicados(CatTipoComunicado catTipoComunicado);
   
    public void saveComunicado(Comunicado comunicado);

    public Comunicado getComunicado(int idComunicado) throws ResourceNotFoundException;

    public void deleteComunicado(int idComunicado) throws ResourceNotFoundException;
}
