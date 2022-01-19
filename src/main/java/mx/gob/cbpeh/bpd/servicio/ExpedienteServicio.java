package mx.gob.cbpeh.bpd.servicio;

import java.util.List;

import mx.gob.cbpeh.bpd.dto.CommonRequest;
import mx.gob.cbpeh.bpd.dto.ConsultaArchivoDto;
import mx.gob.cbpeh.bpd.dto.ConsultaArchivosDto;
import mx.gob.cbpeh.bpd.dto.ConsultaConcentradoDto;
import mx.gob.cbpeh.bpd.dto.ConsultaDesaparecidoDto;
import mx.gob.cbpeh.bpd.dto.ConsultaPublicaDto;
import mx.gob.cbpeh.bpd.dto.ConsultaReporteDto;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.Expediente;

public interface ExpedienteServicio {

	public List<Expediente> getExpedientes();

	public Expediente saveExpediente(Expediente expediente);

	public Expediente getExpediente(String idExpediente) throws ResourceNotFoundException, NullPointerException;

	// Servicios clientes de HVA consulta publica de personas desaparecidas
	/** Consulta por expediente */
	public ConsultaPublicaDto getConsultaPublicaPorExp(String idExpediente)
			throws ResourceNotFoundException, NullPointerException;

	/** Consulta por CURP */
	public ConsultaPublicaDto getConsultaPublicaPorCurp(String idExpediente, String limite)
			throws ResourceNotFoundException, NullPointerException;

	/** Consulta por Nombre Completo */
	public ConsultaPublicaDto getConsultaPublicaPorNombreCompleto(String nombre, String apaterno, String amaterno,
			String limite) throws ResourceNotFoundException;

	/** Actualizar estatus en HVA Localizado */
	public CommonRequest doActualizarEstatusLocalizadoHVA(String id_expediente)
			throws ResourceNotFoundException, NullPointerException;

	/** Consulta informacion Reporte */
	public ConsultaReporteDto getConsultaReporte(String id_expediente)
			throws ResourceNotFoundException, NullPointerException;

	/** Consulta informacion de persona desaparecida */
	public ConsultaDesaparecidoDto getConsultaDesaparecido(String id_expediente)
			throws ResourceNotFoundException, NullPointerException;

	/** Consulta informacion para el concentrado por folio expediente */
	public ConsultaConcentradoDto getConsultaConcentradoPorExpediente(String id_expediente)
			throws ResourceNotFoundException, NullPointerException;
	
	/** Consulta informacion para el concentrado por folio expediente */
	public ConsultaConcentradoDto getConsultaConcentradoPorFiltros(String idExpediente,String codigo_entidad, String codigoMunicipio,
			String idSexo, String idEdad, String idEstatusLocalizado) throws ResourceNotFoundException, NullPointerException;
	
	/** Consulta archivos por expediente */
	public ConsultaArchivosDto getArchivos(String idExpediente) throws ResourceNotFoundException, NullPointerException;
	
	/** Consulta 1 archivo para el expediente,id,tipo */
	public ConsultaArchivoDto getArchivo(String idExpediente,String idArchivo, String idTipo) throws ResourceNotFoundException, NullPointerException;

	public String getFolioExpediente(int tipoExpediente) throws ResourceNotFoundException;

	public void deleteExpediente(int idExpediente) throws ResourceNotFoundException;

	public Expediente getExpedienteIdPersonaDesaparecida(int idPersonaDesaparecida) throws ResourceNotFoundException;

	public List<Integer> obtenerAniosExpedientes();

}
