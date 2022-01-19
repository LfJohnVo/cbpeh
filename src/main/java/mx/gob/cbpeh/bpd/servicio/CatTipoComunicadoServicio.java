package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatTipoComunicado;


public interface CatTipoComunicadoServicio {

    public List < CatTipoComunicado > getCatTipoComunicados();

    public void saveCatTipoComunicado(CatTipoComunicado tipoComunicado);

    public Optional<CatTipoComunicado>  getCatTipoComunicado(int idTipoComunicado) throws ResourceNotFoundException;

    public void deleteCatTipoComunicado(int idTipoComunicado) throws ResourceNotFoundException;
}
