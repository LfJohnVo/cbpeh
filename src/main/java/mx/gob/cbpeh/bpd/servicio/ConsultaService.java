package mx.gob.cbpeh.bpd.servicio;

import java.io.File;
import java.util.List;
import mx.gob.cbpeh.bpd.dto.ConcentradoDto;
import mx.gob.cbpeh.bpd.dto.RegistroDiarioDto;

public interface ConsultaService {
	
	List<ConcentradoDto> buscarConcentrado(String idExpediente,String idsexo,String idEdad,String idMunicipio,String idEstatusLocalizado);
	List<RegistroDiarioDto> buscarRegistroDiario(Integer anio,Integer mes,Integer idEstatus,String idExpediente);
	File generarRegistrodiario(Integer anio, Integer mes, Integer idEstatus,String idExpedienten);
	File generarConcentrado(String idExpediente,String idsexo,String idEdad,String idMunicipio,String idEstatusLocalizado);
}