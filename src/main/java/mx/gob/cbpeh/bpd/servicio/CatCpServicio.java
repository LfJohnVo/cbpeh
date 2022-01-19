package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatCp;


public interface CatCpServicio {

    public List < CatCp > getCatCps();
    
    public List<CatCp> getCatCpPorEstadoMunicipio(String codigoEstado,String codigoMunicipio);

    public void saveCatCps(CatCp cp);

    public Optional<CatCp>  getCatCp(int idCp) throws ResourceNotFoundException;

    public void deleteCatCp(int idCp) throws ResourceNotFoundException;
}
