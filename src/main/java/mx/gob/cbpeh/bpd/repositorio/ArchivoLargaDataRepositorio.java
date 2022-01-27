package mx.gob.cbpeh.bpd.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("archivoLargaDataRepositorio")
public interface ArchivoLargaDataRepositorio extends JpaRepository<ArchivoLargaData, Integer> {

    @Query(value = "SELECT YEAR(ald.fecha_carga) AS y FROM archivo_larga_data AS ald GROUP BY y", nativeQuery = true)
    List<Integer> getAllYears();

}
