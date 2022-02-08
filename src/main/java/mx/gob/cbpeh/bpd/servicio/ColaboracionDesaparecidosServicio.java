package mx.gob.cbpeh.bpd.servicio;

import java.util.List;

import mx.gob.cbpeh.bpd.modelo.ColaboracionDesaparecidos;

public interface ColaboracionDesaparecidosServicio {
    public List<ColaboracionDesaparecidos> findAll();

    public void save(ColaboracionDesaparecidos colaboracionDesaparecidos);

    public ColaboracionDesaparecidos findOne(int id);

    public boolean existsById(int id);

    public void delete(int id);
}
