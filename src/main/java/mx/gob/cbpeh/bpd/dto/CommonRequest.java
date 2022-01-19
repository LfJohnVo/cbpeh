package mx.gob.cbpeh.bpd.dto;


public class CommonRequest {
   
	
    private String estatus;
    private int status;

    public CommonRequest() {
    	super();
        this.status = -1;
        this.estatus = "";
       
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
}
