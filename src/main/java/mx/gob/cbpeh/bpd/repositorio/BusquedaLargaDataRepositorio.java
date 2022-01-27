package mx.gob.cbpeh.bpd.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("busquedaLargaDataRepositorio")
public interface BusquedaLargaDataRepositorio extends JpaRepository<BusquedaLargaData, Integer> {
    @Query(value = "SELECT YEAR(bld.fecha_busqueda) y FROM busqueda_larga_data bld GROUP BY  y", nativeQuery = true)
    public List<Integer> getAllYears();
}
