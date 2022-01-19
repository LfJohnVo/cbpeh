package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatLongitudCabello;


public interface CatLongitudCabelloServicio {

    public List < CatLongitudCabello > getCatLongitudCabello();

    public void saveCatLongitudCabello(CatLongitudCabello longitudCabello);

    public Optional<CatLongitudCabello>  getCatLongitudCabello(int idCatLongitudCabello) throws ResourceNotFoundException;

    public void deleteCatLongitudCabello(int idCatLongitudCabello) throws ResourceNotFoundException;
}
