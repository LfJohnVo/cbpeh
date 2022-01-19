package mx.gob.cbpeh.bpd.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.gob.cbpeh.bpd.modelo.Comunicado;



public class ComunicadosDto extends CommonResponse{
	
private Comunicado2 comunicado;	
	
	private List<Comunicado2> comunicados;
	
	public ComunicadosDto() {
		// TODO Auto-generated constructor stub
		comunicado = new Comunicado2();
		comunicados = new ArrayList<Comunicado2>();
	}
	
	
	
	public Comunicado2 getComunicado() {
		return comunicado;
	}
	public void setComunicado(Comunicado2 comunicado) {
		this.comunicado = comunicado;
	}
	public List<Comunicado2> getComunicados() {
		return comunicados;
	}
	public void setComunicados(List<Comunicado2> comunicados) {	
			                     
	this.comunicados=comunicados;	
	}
	

}



