package mx.gob.cbpeh.bpd.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.cbpeh.bpd.modelo.AtencionPsicologica;
import mx.gob.cbpeh.bpd.repositorio.AtencionPsicologicaRepositorio;

@Service
public class AtencionPsicologicaServicioImpl implements AtencionPsicologicaServicio {

    @Autowired
    private AtencionPsicologicaRepositorio atencionPsicologicaRepositorio;

    @Override
    @Transactional
    public void delete(int id) {
        atencionPsicologicaRepositorio.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(int id) {
        return atencionPsicologicaRepositorio.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AtencionPsicologica> findAll() {
        return atencionPsicologicaRepositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public AtencionPsicologica findOne(int id) {
        return atencionPsicologicaRepositorio.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public AtencionPsicologica save(AtencionPsicologica atencionPsicologica) {
        return atencionPsicologicaRepositorio.save(atencionPsicologica);
    }

}
