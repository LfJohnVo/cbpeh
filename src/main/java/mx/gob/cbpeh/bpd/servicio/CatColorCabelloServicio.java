package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatColorCabello;


public interface CatColorCabelloServicio {

    public List < CatColorCabello > getCatColorCabellos();

    public void saveCatColorCabello(CatColorCabello colorCabello);

    public Optional<CatColorCabello>  getCatColorCabello(int idColorCabello) throws ResourceNotFoundException;

    public void deleteCatColorCabello(int idColorCabello) throws ResourceNotFoundException;
}
