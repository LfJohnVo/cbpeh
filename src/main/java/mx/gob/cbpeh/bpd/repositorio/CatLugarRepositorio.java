package mx.gob.cbpeh.bpd.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("lugarRepositorio")
public interface CatLugarRepositorio extends JpaRepository<CatLugar, Integer>{

}
