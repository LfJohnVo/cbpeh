package mx.gob.cbpeh.bpd.servicio;

import java.io.File;
import java.util.List;

import mx.gob.cbpeh.bpd.dto.BusquedaLargaDataConcentradoDto;
import mx.gob.cbpeh.bpd.dto.ColaboracionesConcentradoDto;
import mx.gob.cbpeh.bpd.dto.ConcentradoDto;
import mx.gob.cbpeh.bpd.dto.RegistroDiarioDto;
import mx.gob.cbpeh.bpd.dto.ColaboracionesConcentradoSelectDto;

public interface ConsultaService {

	List<ConcentradoDto> buscarConcentrado(String idExpediente, String idsexo, String idEdad, String idMunicipio,
			String idEstatusLocalizado);

	List<RegistroDiarioDto> buscarRegistroDiario(Integer anio, Integer mes, Integer idEstatus, String idExpediente);

	List<ColaboracionesConcentradoDto> buscarColaboracion(String idExpediententeColaboracion,

            String fechaPeticion, String idInstitucion, String idEstatusColaboracion);
			
	List<ColaboracionesConcentradoSelectDto> buscarColaboracionSelectDto(String numPeticion ,
	String fechaPeticion, String solColaboracion);
	List<BusquedaLargaDataConcentradoDto> busquedaLargaData(String mesBusquedaLD, String yearBusquedaLD);
	File generarRegistrodiario(Integer anio, Integer mes, Integer idEstatus, String idExpedienten);
	File generarConcentrado(String idExpediente, String idsexo, String idEdad, String idMunicipio,
			String idEstatusLocalizado);
	File generarColaboraciones(String idExpediententeColaboracion, String fechaPeticion, String idInstitucion,
			String idEstatusColaboracion);
	File generarBusquedaLargaData(String mesBusquedaLD, String yearBusquedaLD);
}
