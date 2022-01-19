package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatLugar;


public interface CatLugarServicio {

    public List < CatLugar > getCatLugar();

    public void saveCatLugar(CatLugar lugar);

    public Optional<CatLugar>  getCatLugar(int idLugar) throws ResourceNotFoundException;

    public void deleteCatLugar(int idLugar) throws ResourceNotFoundException;
}
