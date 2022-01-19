package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatGradoEstudio;


public interface CatGradoEstudioServicio {

    public List < CatGradoEstudio > getCatGradoEstudio();

    public void saveCatGradoEstudio(CatGradoEstudio gradoEstudio);

    public Optional<CatGradoEstudio>  getCatGradoEstudio(int idGradoEstudio) throws ResourceNotFoundException;

    public void deleteCatGradoEstudio(int idGradoEstudio) throws ResourceNotFoundException;
}
