package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatTipoCabello;


public interface CatTipoCabelloServicio {

    public List < CatTipoCabello > getCatTipoCabello();

    public void saveCatTipoCabello(CatTipoCabello tipoCabello);

    public Optional<CatTipoCabello>  getCatTipoCabello(int idTipoCabello) throws ResourceNotFoundException;

    public void deleteCatTipoCabello(int idTipoCabello) throws ResourceNotFoundException;
}
