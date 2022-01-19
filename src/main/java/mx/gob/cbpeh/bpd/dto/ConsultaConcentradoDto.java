package mx.gob.cbpeh.bpd.dto;


import java.util.List;

public class ConsultaConcentradoDto extends CommonRequest{

	
	private List<ConsultaConcetradoResultados> resultados;

	public ConsultaConcentradoDto() {
		super();		
	}

	public ConsultaConcentradoDto(String estatus, List<ConsultaConcetradoResultados> resultados) {
		super();
		this.resultados = resultados;
	}

	public List<ConsultaConcetradoResultados> getResultados() {
		return resultados;
	}

	public void setResultados(List<ConsultaConcetradoResultados> resultados) {
		this.resultados = resultados;
	}



}
