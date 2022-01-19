package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatColonia;


public interface CatColoniaServicio {

    public List < CatColonia > getCatColonias();
    
	public List<CatColonia> getCatColoniasPorCp(String codigoCp);

    public void saveCatColonia(CatColonia colonia);

    public Optional<CatColonia>  getCatColonia(int idColonia) throws ResourceNotFoundException;

    public void deleteCatColonia(int idColonia) throws ResourceNotFoundException;

}
