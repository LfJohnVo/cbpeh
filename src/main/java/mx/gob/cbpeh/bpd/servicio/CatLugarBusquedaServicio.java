package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatLugarBusqueda;


public interface CatLugarBusquedaServicio {

    public List < CatLugarBusqueda > getCatLugarBusqueda();

    public CatLugarBusqueda saveCatLugarBusqueda(CatLugarBusqueda catLugarBusqueda);

    public Optional<CatLugarBusqueda>  getCatLugarBusqueda(int idCatLugarBusqueda) throws ResourceNotFoundException;

    public void deleteCatLugarBusqueda(int idCatLugarBusqueda) throws ResourceNotFoundException;
}
