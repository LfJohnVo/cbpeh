package mx.gob.cbpeh.bpd.dto;


import java.util.List;

public class ConsultaReporteDto extends CommonRequest{

	private String estatus;
	private List<ConsultaReporteResultados> resultados;

	public ConsultaReporteDto() {
		super();
		
	}

	public ConsultaReporteDto(String estatus, List<ConsultaReporteResultados> estatusDto) {
		super();
		this.resultados = estatusDto;
	}

	public List<ConsultaReporteResultados> getResultados() {
		return resultados;
	}

	public void setResultados(List<ConsultaReporteResultados> resultados) {
		this.resultados = resultados;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	
	
//	 @Override
//		public String toString() {
//			 return "ConsultaPublicaDto {" + "estatus = " + estatus + ", resultados = " + resultados
//						+ '\'' + '}';
//		}

}
