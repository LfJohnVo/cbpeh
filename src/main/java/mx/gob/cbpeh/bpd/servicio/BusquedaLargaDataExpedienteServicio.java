package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.BusquedaLargaData;
import mx.gob.cbpeh.bpd.modelo.BusquedaLargaDataExpediente;


public interface BusquedaLargaDataExpedienteServicio {

    public List < BusquedaLargaDataExpediente > getBusquedaLargaDataExpediente();

    public void saveBusquedaLargaDataExpediente(BusquedaLargaDataExpediente busquedaLargaDataExpediente);

    public Optional<BusquedaLargaDataExpediente>  getBusquedaLargaDataExpediente(int idBusquedaLargaDataExpediente) throws ResourceNotFoundException;

    public void deleteBusquedaLargaDataExpediente(int idBusquedaLargaDataExpediente) throws ResourceNotFoundException;
}
