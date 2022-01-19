package mx.gob.cbpeh.bpd.dto;

import java.util.List;

public class ConsultaArchivoDto {
	
	 private String estatus;
	 private List<ArchivoHvaDto> resultados;
	 
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public List<ArchivoHvaDto> getResultados() {
		return resultados;
	}
	public void setResultados(List<ArchivoHvaDto> resultados) {
		this.resultados = resultados;
	}
}
