package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatSexo;


public interface CatSexoServicio {

    public List < CatSexo > getCatSexo();

    public void saveCatSexo(CatSexo sexo);

    public Optional<CatSexo>  getCatSexo(int idSexo) throws ResourceNotFoundException;

    public void deleteCatSexo(int idSexo) throws ResourceNotFoundException;
}
