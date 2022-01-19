package mx.gob.cbpeh.bpd.servicio;

import java.util.List;

import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatCatalogosDB;


public interface CatCatalogosDBServicio {

    public List < CatCatalogosDB > getCatCatalogos();

    public void saveCatCatalogo(CatCatalogosDB catCatalogosDB);

    public CatCatalogosDB  getCatCatalogo(int idCatalogo) throws ResourceNotFoundException;

    public void deleteCatCatalogo(int idCatalogo) throws ResourceNotFoundException;
}
