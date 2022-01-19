package mx.gob.cbpeh.bpd.dto;


import java.util.List;

public class ConsultaDesaparecidoDto extends CommonRequest{

	
	private List<ConsultaDesaparecidoResultados> resultados;

	public ConsultaDesaparecidoDto() {
		super();
		
	}

	public ConsultaDesaparecidoDto(String estatus, List<ConsultaDesaparecidoResultados> estatusDto) {
		super();
		this.resultados = estatusDto;
	}

	public List<ConsultaDesaparecidoResultados> getResultados() {
		return resultados;
	}

	public void setResultados(List<ConsultaDesaparecidoResultados> resultados) {
		this.resultados = resultados;
	}
	

}
