package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatTransporte;


public interface CatTransporteServicio {

    public List < CatTransporte > getCatTransportes();

    public void saveCatTransporte(CatTransporte transporte);

    public Optional<CatTransporte>  getCatTransporte(int idTransporte) throws ResourceNotFoundException;

    public void deleteCatTransporte(int idTransporte) throws ResourceNotFoundException;
}
