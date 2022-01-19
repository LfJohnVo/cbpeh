package mx.gob.cbpeh.bpd.dto;

import java.util.List;

public class ConsultaArchivosDto {
	
    private String estatus;
    private List<ArchivosHvaDto> resultados;
    
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public List<ArchivosHvaDto> getResultados() {
		return resultados;
	}
	public void setResultados(List<ArchivosHvaDto> resultados) {
		this.resultados = resultados;
	}
}
