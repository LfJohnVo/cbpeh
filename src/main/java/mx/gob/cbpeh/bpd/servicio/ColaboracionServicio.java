package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.Colaboracion;

public interface ColaboracionServicio {

    public List<Colaboracion> getColaboracion();

    public Colaboracion saveColaboracion(Colaboracion colaboracion);

    public Optional<Colaboracion> getColaboracion(int idColaboracion) throws ResourceNotFoundException;

    public void deleteColaboracion(int idColaboracion) throws ResourceNotFoundException;

    public String getFolioColaboracion(String institucion, String inicialesNombre);
}
