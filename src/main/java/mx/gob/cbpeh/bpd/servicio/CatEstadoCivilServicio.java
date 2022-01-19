package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatEstadoCivil;


public interface CatEstadoCivilServicio {

    public List < CatEstadoCivil > getCatEstadoCivil();

    public void saveCatEstadoCivil(CatEstadoCivil estadoCivil);

    public Optional<CatEstadoCivil>  getCatEstadoCivil(int idEstadoCivil) throws ResourceNotFoundException;

    public void deleteCatEstadoCivil(int idEstadoCivil) throws ResourceNotFoundException;
}
