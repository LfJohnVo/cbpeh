package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatTamanioNariz;


public interface CatTamanioNarizServicio {

    public List < CatTamanioNariz > getCatTamanioNariz();

    public void saveCatTamanioNariz(CatTamanioNariz tamanioNariz);

    public Optional<CatTamanioNariz>  getCatTamanioNariz(int idTamanioNariz) throws ResourceNotFoundException;

    public void deleteCatTamanioNariz(int idTamanioNariz) throws ResourceNotFoundException;
}
