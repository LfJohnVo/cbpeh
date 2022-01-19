package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.ColaboracionLugarBusqueda;


public interface ColaboracionLugarBusquedaServicio {

    public List < ColaboracionLugarBusqueda > getColaboracionLugarBusqueda();

    public ColaboracionLugarBusqueda saveColaboracionLugarBusqueda(ColaboracionLugarBusqueda catLugarBusqueda);

    public Optional<ColaboracionLugarBusqueda>  getColaboracionLugarBusqueda(int idColaboracionLugarBusqueda) throws ResourceNotFoundException;

    public void deleteColaboracionLugarBusqueda(int idColaboracionLugarBusqueda) throws ResourceNotFoundException;
}
