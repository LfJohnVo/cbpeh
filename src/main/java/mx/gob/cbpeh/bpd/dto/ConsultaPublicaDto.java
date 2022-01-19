package mx.gob.cbpeh.bpd.dto;


import java.util.List;

public class ConsultaPublicaDto extends CommonRequest{

	
	private List<ConsultaPublicaResultados> resultados;

	public ConsultaPublicaDto() {
		super();
		
	}

	public ConsultaPublicaDto(String estatus, List<ConsultaPublicaResultados> estatusDto) {
		super();
		this.resultados = estatusDto;
	}

	public List<ConsultaPublicaResultados> getResultados() {
		return resultados;
	}

	public void setResultados(List<ConsultaPublicaResultados> resultados) {
		this.resultados = resultados;
	}

	
	
//	 @Override
//		public String toString() {
//			 return "ConsultaPublicaDto {" + "estatus = " + estatus + ", resultados = " + resultados
//						+ '\'' + '}';
//		}

}
