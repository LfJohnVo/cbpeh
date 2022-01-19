package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.Busqueda;


public interface BusquedaServicio {

    public List < Busqueda > getBusquedas();

    public Busqueda saveBusqueda(Busqueda busqueda);

    public Optional<Busqueda>  getBusqueda(int idBusqueda) throws ResourceNotFoundException;

    public void deleteBusqueda(int idBusqueda) throws ResourceNotFoundException;
    
    public List < Busqueda > getBusquedas(String expediente);
    
}
