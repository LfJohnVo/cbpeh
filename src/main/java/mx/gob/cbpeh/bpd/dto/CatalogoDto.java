package mx.gob.cbpeh.bpd.dto;

public class CatalogoDto extends CommonResponse{

	public CatalogoDto() {
		// TODO Auto-generated constructor stub
	}
	
	int idCatalogo;
	String nombreCatalogo;
	String descripcionCatalogo;
	int idEstatusCaatalogo;
	
	public int getIdCatalogo() {
		return idCatalogo;
	}
	public void setIdCatalogo(int idCatalogo) {
		this.idCatalogo = idCatalogo;
	}
	public String getNombreCatalogo() {
		return nombreCatalogo;
	}
	public void setNombreCatalogo(String nombreCatalogo) {
		this.nombreCatalogo = nombreCatalogo;
	}
	public String getDescripcionCatalogo() {
		return descripcionCatalogo;
	}
	public void setDescripcionCatalogo(String descripcionCatalogo) {
		this.descripcionCatalogo = descripcionCatalogo;
	}
	public int getIdEstatusCaatalogo() {
		return idEstatusCaatalogo;
	}
	public void setIdEstatusCaatalogo(int idEstatusCaatalogo) {
		this.idEstatusCaatalogo = idEstatusCaatalogo;
	}
	
	
}
