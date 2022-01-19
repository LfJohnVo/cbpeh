package mx.gob.cbpeh.bpd.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import mx.gob.cbpeh.bpd.dto.CommonRequest;
import mx.gob.cbpeh.bpd.dto.ConsultaArchivoDto;
import mx.gob.cbpeh.bpd.dto.ConsultaArchivosDto;
import mx.gob.cbpeh.bpd.dto.ConsultaConcentradoDto;
import mx.gob.cbpeh.bpd.dto.ConsultaDesaparecidoDto;
import mx.gob.cbpeh.bpd.dto.ConsultaPublicaDto;
import mx.gob.cbpeh.bpd.dto.ConsultaReporteDto;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.Expediente;
import mx.gob.cbpeh.bpd.repositorio.ExpedienteRepositorio;

@Service
public class ExpedienteServicioImpl implements ExpedienteServicio {
	
	@Autowired
	private ExpedienteRepositorio expedienteRepositorio;
	
	@Autowired
	RestTemplate restTemplate;
    
	@Value("${HVA.URI}")
	private String URL;
	
	@Value("${HVA.URII}")
	private String URLL;
	
	

	@Override
	@Transactional
	public List<Expediente> getExpedientes() {
		return expedienteRepositorio.expedientesOrdenadosPorAnioDescendente();
	}

	
	
	@Override
	@Transactional
	public Expediente saveExpediente(Expediente expediente) {
		return expedienteRepositorio.save(expediente);
	}

	@Override
	@Transactional
	public Expediente getExpediente(String idExpediente) throws ResourceNotFoundException {
		return expedienteRepositorio.findByIdExpediente(idExpediente);
	}
	 /**RestClient Consulta por expediente*/
	@Override
	@Transactional
	public ConsultaPublicaDto getConsultaPublicaPorExp(String idExpediente) throws ResourceNotFoundException, NullPointerException {
		ResponseEntity<ConsultaPublicaDto> response = restTemplate.getForEntity(URL + "/consultaPublica?id_expediente="+idExpediente.trim(), ConsultaPublicaDto.class);
			return response.getBody();
	}
	
	/**RestClient Consulta por curp*/
	@Override
	@Transactional
	public ConsultaPublicaDto getConsultaPublicaPorCurp(String curp, String limite) throws ResourceNotFoundException, NullPointerException {
		ResponseEntity<ConsultaPublicaDto> response = restTemplate.getForEntity(URL + "/consultaPublica?curp="+curp.trim()+"&limite="+limite, ConsultaPublicaDto.class);
			return response.getBody();
	}
	/**RestClient Consulta por Nombre completo*/
	@Override
	@Transactional
	public ConsultaPublicaDto getConsultaPublicaPorNombreCompleto(String nombre, String apaterno, String amaterno,String limite) throws ResourceNotFoundException, NullPointerException {
		ResponseEntity<ConsultaPublicaDto> response = restTemplate.getForEntity(URL + "/consultaPublica?nombre="+nombre+"&apaterno="+apaterno+"&amaterno="+amaterno+"&limite="+limite, ConsultaPublicaDto.class);
			return response.getBody();
	}
	
	/**RestClient Consulta por Nombre completo*/
	@Override
	@Transactional
	public CommonRequest  doActualizarEstatusLocalizadoHVA(String id_expediente) throws ResourceNotFoundException, NullPointerException {
		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity httpEntity = new HttpEntity(httpHeaders);
		ResponseEntity<CommonRequest> response = restTemplate.exchange(URLL + "/localizado?id_expediente="+id_expediente.toString(), HttpMethod.PUT, httpEntity, CommonRequest.class);
				//(URLL + "/localizado?id_expediente="+id_expediente, CommonRequest.class);
			return response.getBody();
	}
	
	/**RestClient Consulta Reporte*/
	@Override
	@Transactional
	public ConsultaReporteDto  getConsultaReporte(String id_expediente) throws ResourceNotFoundException, NullPointerException {
		ResponseEntity<ConsultaReporteDto> response = restTemplate.getForEntity(URL + "/consultaReportante?id_expediente="+id_expediente, ConsultaReporteDto.class);
			return response.getBody();
	}
	/**RestClient Consulta persona desaparecida*/
	@Override
	@Transactional
	public ConsultaDesaparecidoDto  getConsultaDesaparecido(String id_expediente) throws ResourceNotFoundException, NullPointerException {
		ResponseEntity<ConsultaDesaparecidoDto> response = restTemplate.getForEntity(URL + "/consultaDesaparecido?id_expediente="+id_expediente, ConsultaDesaparecidoDto.class);
			return response.getBody();
	}
	
	/**RestClient Consulta concentrado por expediente*/
	@Override
	@Transactional
	public ConsultaConcentradoDto  getConsultaConcentradoPorExpediente(String id_expediente) throws ResourceNotFoundException, NullPointerException {
		ResponseEntity<ConsultaConcentradoDto> response = restTemplate.getForEntity(URL + "/consultaConcentrado?id_expediente="+id_expediente, ConsultaConcentradoDto.class);
			return response.getBody();
	}
	
	
	/**RestClient Consulta concentrado por varios filtros*/
	@Override
	@Transactional
	public ConsultaConcentradoDto  getConsultaConcentradoPorFiltros(
			String idExpediente,
			String codigoEntidad,
			String codigoMunicipio,
			String idSexo,
			String idEdad,
			String idEstatusLocalizado
) throws ResourceNotFoundException, NullPointerException {
		ResponseEntity<ConsultaConcentradoDto> response = restTemplate.getForEntity(URL + "/consultaConcentrado?codigo_entidad="+codigoEntidad+"&id_expediente="+idExpediente+"&codigo_municipio="+codigoMunicipio
		+"&id_sexo="+idSexo+"&id_edad="+idEdad+"&id_estatus_localizado="+idEstatusLocalizado, ConsultaConcentradoDto.class);
			return response.getBody();
	}
	@Override
	@Transactional
	public String getFolioExpediente(int tipoExpediente) throws ResourceNotFoundException {
		return expedienteRepositorio.generarFolioExpediente(tipoExpediente);
	}

	@Override
	@Transactional
	public void deleteExpediente(int idExpediente) throws ResourceNotFoundException {
		expedienteRepositorio.deleteById(idExpediente);
	}

	@Override
	public Expediente getExpedienteIdPersonaDesaparecida(int idPersonaDesaparecida) throws ResourceNotFoundException {
		return expedienteRepositorio.findByIdPersonaDesaparecida(idPersonaDesaparecida);
	}

	@Override
	public List<Integer> obtenerAniosExpedientes() {
		return expedienteRepositorio.obtenerAniosExpedientes();
	}

	@Override
	public ConsultaArchivosDto getArchivos(String idExpediente)
			throws ResourceNotFoundException, NullPointerException {
		ResponseEntity<ConsultaArchivosDto> response = restTemplate.getForEntity(URL + "/archivos?id_expediente="+idExpediente, ConsultaArchivosDto.class);
		return response.getBody();
	}

	@Override
	public ConsultaArchivoDto getArchivo(String idExpediente, String idArchivo, String idTipo)
			throws ResourceNotFoundException, NullPointerException {
		ResponseEntity<ConsultaArchivoDto> response = restTemplate.getForEntity(URL + "/archivo?id_expediente="+idExpediente+"&id="+idArchivo+"&tipo="+idTipo, ConsultaArchivoDto.class);
			return response.getBody();
	}

}
