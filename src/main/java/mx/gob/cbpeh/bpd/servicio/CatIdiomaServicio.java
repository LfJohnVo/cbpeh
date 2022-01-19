package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatIdioma;


public interface CatIdiomaServicio {

    public List < CatIdioma > getCatIdiomas();

    public void saveCatIdioma(CatIdioma idioma);

    public Optional<CatIdioma>  getCatIdioma(int idIdioma) throws ResourceNotFoundException;

    public void deleteCatIdioma(int idIdioma) throws ResourceNotFoundException;
}
