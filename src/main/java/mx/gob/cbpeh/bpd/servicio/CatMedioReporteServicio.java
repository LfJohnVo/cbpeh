package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatMedioReporte;


public interface CatMedioReporteServicio {

    public List < CatMedioReporte > getCatMedioReportes();

    public void saveCatMedioReporte(CatMedioReporte medioReporte);

    public Optional<CatMedioReporte>  getCatMedioReporte(int idMedioReporte) throws ResourceNotFoundException;

    public void deleteCatMedioReporte(int idMedioReporte) throws ResourceNotFoundException;
}
