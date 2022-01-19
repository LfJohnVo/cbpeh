package mx.gob.cbpeh.bpd.servicio;

import java.util.List;
import java.util.Optional;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatGrupoEtnico;


public interface CatGrupoEtnicoServicio {

    public List < CatGrupoEtnico > getCatGrupoEtnicos();

    public void saveCatGrupoEtnico(CatGrupoEtnico grupoEtnico);

    public Optional<CatGrupoEtnico>  getCatGrupoEtnico(int idGrupoEtnico) throws ResourceNotFoundException;

    public void deleteCatGrupoEtnico(int idGrupoEtnico) throws ResourceNotFoundException;
}
