package mx.gob.cbpeh.bpd.dto;


public class CommonResponse {
   
	
    private int estatus;

    private String descripcion;
	
    private String sesionToken;

    public CommonResponse() {
        this.estatus = -1;
        this.descripcion = "";
        this.sesionToken = "";
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSesionToken() {
        return sesionToken;
    }

    public void setSesionToken(String sesionToken) {
        this.sesionToken = sesionToken;
    }
}
