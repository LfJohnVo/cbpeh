package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatSiNo;


public interface CatSiNoServicio {

    public List < CatSiNo > getCatSiNo();

    public void saveCatSiNo(CatSiNo siNo);

    public Optional<CatSiNo>  getCatSiNo(int idSiNo) throws ResourceNotFoundException;

    public void deleteCatSiNo(int idSiNo) throws ResourceNotFoundException;
}
