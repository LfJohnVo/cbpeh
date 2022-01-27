package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.BusquedaLargaData;

public interface BusquedaLargaDataServicio {

    public List<BusquedaLargaData> getBusquedaLargaDatas();

    public List<Integer> getYearsLargaData();

    public void saveBusquedaLargaData(BusquedaLargaData busquedaLargaData);

    public Optional<BusquedaLargaData> getBusquedaLargaData(int idBusquedaLargaData) throws ResourceNotFoundException;

    public void deleteBusquedaLargaData(int idBusquedaLargaData) throws ResourceNotFoundException;
}
