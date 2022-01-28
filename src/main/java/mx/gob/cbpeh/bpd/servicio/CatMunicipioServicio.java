package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatMunicipio;

public interface CatMunicipioServicio {

    public List<CatMunicipio> getCatMunicipios();

    public List<CatMunicipio> getCatMunicipiosPorEstado(String codigoEstado);

    public CatMunicipio getCatMunicipiosPorEstadoAndPorCodigo(String codigoEstado, String codigoMunicipio);

    public void saveCatMunicipio(CatMunicipio municipio);

    public Optional<CatMunicipio> getCatMunicipio(int idMunicipio) throws ResourceNotFoundException;

    public void deleteCatMunicipio(int idMunicipio) throws ResourceNotFoundException;
}
