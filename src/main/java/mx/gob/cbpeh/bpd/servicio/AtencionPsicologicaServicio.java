package mx.gob.cbpeh.bpd.servicio;

import java.util.List;

import mx.gob.cbpeh.bpd.modelo.AtencionPsicologica;

public interface AtencionPsicologicaServicio {

    public List<AtencionPsicologica> findAll();

    public AtencionPsicologica save(AtencionPsicologica cliente);

    public AtencionPsicologica findOne(int id);

    public boolean existsById(int id);

    public void delete(int id);
}
