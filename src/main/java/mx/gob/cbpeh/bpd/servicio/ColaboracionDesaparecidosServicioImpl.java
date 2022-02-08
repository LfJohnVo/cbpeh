package mx.gob.cbpeh.bpd.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.modelo.ColaboracionDesaparecidos;
import mx.gob.cbpeh.bpd.repositorio.ColaboracionDesaparecidoRepositorio;

@Service
public class ColaboracionDesaparecidosServicioImpl implements ColaboracionDesaparecidosServicio {
    @Autowired
    private ColaboracionDesaparecidoRepositorio colaboracionDesaparecidoRepositorio;

    @Override
    @Transactional
    public void delete(int id) {
        colaboracionDesaparecidoRepositorio.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(int id) {
        return colaboracionDesaparecidoRepositorio.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ColaboracionDesaparecidos> findAll() {
        return colaboracionDesaparecidoRepositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ColaboracionDesaparecidos findOne(int id) {
        return colaboracionDesaparecidoRepositorio.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(ColaboracionDesaparecidos colaboracionDesaparecidos) {
        colaboracionDesaparecidoRepositorio.save(colaboracionDesaparecidos);
    }

}
